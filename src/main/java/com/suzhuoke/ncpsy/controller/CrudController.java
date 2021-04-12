package com.suzhuoke.ncpsy.controller;

import com.suzhuoke.ncpsy.model.Crud1;
import com.suzhuoke.ncpsy.model.Crud2;
import com.suzhuoke.ncpsy.model.Qy;
import com.suzhuoke.ncpsy.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * 增删改查 Controller
 *
 * @RestController修饰的类会将  return后面的内容字符串的形式返回
 * @Controller修饰的类会将return的字符串配合视图解析器InternalResourceViewResolver添加上前缀和后缀。跳转到对应的页面。
 * @Controller和@ResponseBody配合作用和@RestController一样
 *
 * @author zyc
 * @date 2021/4/12
 */
@RestController
@RequestMapping("/crud")
public class CrudController {


    /**
     * @Qualifier("crud1") 指定 CrudService的实现类
     * CrudService的俩种实现(我复制了 一样的  但其实 实现可以不一样)      多态的一种体现
     */
    @Autowired
    @Qualifier("crud1")
    CrudService crudService;
    @Autowired
    @Qualifier("crud2")
    CrudService crudService2;


    /**
     * tb_qy 表的增
     *
     * RequestMethod.POST 请求类型
     *
     * @date 2021/4/12 9:33
     * @param crud1 {@link Crud1}  注意  edit 中的Crud2
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestBody Crud1 crud1) throws Exception{
        //try-catch和throw,throws的区别
        //throws 用在方法上 关键字声明此方法可能 会抛出异常
        //try 方法内捕获异常
        try{
            int re = crudService.add(crud1);
            return re;
        }catch (Exception e){
            e.printStackTrace();
            //throw 关键字 方法内主动抛出异常
            throw new Exception();
        }
    }

    /**
     * tb_qy 表的删
     * @date 2021/4/12 9:33
     * @param qyid
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public int del(@RequestParam("qyid") String qyid) {
        int re = crudService.del(qyid);
        return re;
    }

    /**
     * tb_qy 表的改
     * @date 2021/4/12 9:33
     * @param crud2  对照 crud1
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public int edit(@RequestBody Crud2 crud2) {
        int re = crudService.edit(crud2);
        return re;
    }

    /**
     * tb_qy 表的查
     * @date 2021/4/12 9:33
     * @param qyid
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Qy query(@RequestParam("qyid") String qyid) {
        Qy re = crudService.query(qyid);
        return re;
    }
}
