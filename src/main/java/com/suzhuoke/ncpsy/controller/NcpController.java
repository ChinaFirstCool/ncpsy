package com.suzhuoke.ncpsy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.suzhuoke.ncpsy.model.Ewm;
import com.suzhuoke.ncpsy.model.Ncp;
import com.suzhuoke.ncpsy.service.IEwmService;
import com.suzhuoke.ncpsy.service.INcpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author RobinYoung10
 * @since 2019-02-17
 */
@Controller
@RequestMapping("/handle")
public class NcpController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private INcpService ncpService;
	
	@Autowired
	private IEwmService ewmService;
	
	/**
	 * 新增农产品(生成二维码数据，插入二维码表)
	 * @param ncp
	 * @return
	 */
	@RequestMapping("/product/add")
	@ResponseBody
	public boolean productAdd(@RequestBody Ncp ncp, HttpServletRequest request) {
		logger.info("/handle/product/add===> ncp={}", ncp);
		QueryWrapper<Ncp> queryWrapper = new QueryWrapper<Ncp>();
		
		//设置农产品id
		queryWrapper.eq("qyid", ncp.getQyid());
		int num = ncpService.count(queryWrapper) + 1;
		String ncpid = "ncp";
		while(ncp.getNcpid() == null) {
			if(num /10 == 0) {
				ncpid = ncpid.concat("00" + num);
			} else if(num / 10 >= 1 && num / 10 < 10) {
				ncpid = ncpid.concat("0" + num);
			} else {
				ncpid = ncpid.concat("" + num);
			}
			ncpid = ncpid.concat("-" + ncp.getQyid());
			//查询数据库是否存在相同的ncpid，存在则num+1，继续循环
			QueryWrapper<Ncp> ncpidQueryWrapper = new QueryWrapper<Ncp>();
			ncpidQueryWrapper.eq("ncpid", ncpid);
			int isExist = ncpService.count(ncpidQueryWrapper);
			if(isExist > 0) {
				num += 1;
				ncpid = "ncp";
				continue;
			} else {
				break;
			}
		}
		ncp.setNcpid(ncpid);
		
		//生成二维码id
		QueryWrapper<Ewm> ewmQueryWrapper = new QueryWrapper<Ewm>();
		ewmQueryWrapper.likeLeft("ewmid", ncp.getQyid());
		//int num2 = ewmService.count(ewmQueryWrapper) + 1;
		int num2 = num;
		String ewmid = "ewm";
		while(ncp.getEwmid() == null) {
			if(num2 /10 == 0) {
				ewmid = ewmid.concat("00" + num2);
			} else if(num2 / 10 >= 1 && num2 / 10 < 10) {
				ewmid = ewmid.concat("0" + num2);
			} else {
				ewmid = ewmid.concat("" + num2);
			}
			ewmid = ewmid.concat("-" + ncpid);
			//查询数据库是否存在相同的ewmid，存在则num+1，继续循环
			QueryWrapper<Ewm> ewmidQueryWrapper = new QueryWrapper<Ewm>();
			ewmidQueryWrapper.eq("ewmid", ewmid);
			int isExist = ewmService.count(ewmidQueryWrapper);
			if(isExist > 0) {
				num2 += 1;
				ewmid = "ewm";
				continue;
			} else {
				break;
			}
		}
		
		//获取服务器地址、端口、项目名
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		String baseUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + httpRequest.getContextPath();

		//插入二维码表
		String ewmsj = baseUrl + "/info/product-info?ncpid=" + ncpid;
		Ewm ewm = new Ewm();
		ewm.setEwmid(ewmid);
		ewm.setEwmsj(ewmsj);
		boolean flag = ewmService.save(ewm);
		
		//如果二维码表插入成功，则插入ncp表
		//在插入农产品表的时候可能会出错导致插入失败，这样上面插入的二维码表字段就作废了，所以在这里catch农产品表的错误，并把上面二维码表字段删除
		try {
			if(flag) {
				ncp.setEwmid(ewmid);
				boolean flag2 = ncpService.save(ncp);
				return flag2;
			} else {
				return flag;
			}
		} catch (Exception e) {
			ewmQueryWrapper.eq("ewmid", ewm.getEwmid());
			ewmService.remove(ewmQueryWrapper);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 农产品列表
	 * @param ncp
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/product/list")
	@ResponseBody
	public Map productList(Ncp ncp, @RequestParam int page, @RequestParam int limit) throws Exception {
		logger.info("/handle/product/list===> ncp={}", ncp);
		logger.info("page = {}", page);
		logger.info("limit = {}", limit);
		QueryWrapper<Ncp> ncpQueryWrapper = new QueryWrapper<Ncp>();
		//遍历ncp对象的属性
		Field field[] = ncp.getClass().getDeclaredFields();
		for(int i = 0; i < field.length; i++) {
			//获取属性名
			String name = field[i].getName();
			//将属性的首字符大写，方便构造get，set方法
			String getterName = name.substring(0,1).toUpperCase()+name.substring(1);
			//获取属性的类型
			String type = field[i].getGenericType().toString();
			//根据类型做操作
			if (type.equals("class java.lang.String")) {
				//获得getter方法
				Method m = ncp.getClass().getMethod("get" + getterName);
				//调用getter方法
				String value = (String) m.invoke(ncp);
				//如果非空，则加入查询条件
				if (value != null) {
					ncpQueryWrapper.eq(name, value);
				}
			}
		}
		List<Ncp> ncpList = ncpService.list(ncpQueryWrapper);
		logger.info("=========={}", ncpList);
		//查询到的总量，返回数据要用
		int count = ncpList.size();
		//list截取分页的索引
		int fromIndex = (page-1)*limit;
		int toIndex = page * limit;
		//截取分页数据
		if(page*limit > count) {
			toIndex = count;
		}
		ncpList = ncpList.subList(fromIndex, toIndex);
		
		Map response = new HashMap();
		response.put("code", 0);
		response.put("msg", "");
		response.put("count", count);
		response.put("data", ncpList);
		
		return response;
	}
	
	/**
	 * 获取农产品表一个数据
	 * @param ncp
	 * @return
	 */
	@RequestMapping("/product/getone")
	@ResponseBody
	public Ncp productGetone(@RequestBody Ncp ncp) {
		logger.info("/handle/product/getone===> ncp={}", ncp);
		QueryWrapper<Ncp> ncpQueryWrapper = new QueryWrapper<Ncp>();
		ncpQueryWrapper.eq("ncpid", ncp.getNcpid());
		ncp = ncpService.getOne(ncpQueryWrapper);
		return ncp;
	}
	
	@RequestMapping("/product/modify")
	@ResponseBody
	public boolean productModify(@RequestBody Ncp ncp) {
		logger.info("/handle/product/modify===> ncp={}", ncp);
		QueryWrapper<Ncp> ncpQueryWrapper = new QueryWrapper<Ncp>();
		ncpQueryWrapper.eq("ncpid", ncp.getNcpid());
		Ncp ncpEntity = ncpService.getOne(ncpQueryWrapper);
		ncp.setQyid(ncpEntity.getQyid());
		ncp.setEwmid(ncpEntity.getEwmid());
		UpdateWrapper<Ncp> ncpUpdateWrapper = new UpdateWrapper<Ncp>();
		ncpUpdateWrapper.eq("ncpid", ncp.getNcpid());
		boolean flag = ncpService.update(ncp, ncpUpdateWrapper);
		return flag;
	}
	
	/**
	 * 删除农产品
	 * @param ncp
	 * @return
	 */
	@RequestMapping("/product/delete")
	@ResponseBody
	public boolean productDelete(@RequestBody Ncp ncp) {
		logger.info("/handle/product/list===> ncp={}", ncp);
		QueryWrapper<Ncp> queryWrapper = new QueryWrapper<Ncp>();
		queryWrapper.eq("ncpid", ncp.getNcpid());
		ncp = ncpService.getOne(queryWrapper);
		boolean flag = ncpService.remove(queryWrapper);
		if(flag) {
			QueryWrapper<Ewm> ewmQueryWrapper = new QueryWrapper<Ewm>();
			ewmQueryWrapper.eq("ewmid", ncp.getEwmid());
			boolean flag2 = ewmService.remove(ewmQueryWrapper);
			return flag2;
		} else {
			return flag;
		}
	}
}

