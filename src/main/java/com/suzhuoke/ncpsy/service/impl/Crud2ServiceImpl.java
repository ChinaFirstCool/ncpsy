package com.suzhuoke.ncpsy.service.impl;

import com.suzhuoke.ncpsy.dao.CrudMapper;
import com.suzhuoke.ncpsy.model.Qy;
import com.suzhuoke.ncpsy.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 增删改查接口实现
 *
 * @author zyc
 * @date 2021/4/12
 */
@Service("crud2")
public class Crud2ServiceImpl implements CrudService {

    @Autowired
    CrudMapper crudMapper;

    /**
     * tb_qy 表的增
     * @date 2021/4/12 9:33
     * @param qy {@link Qy}
     * @return
     */
    @Override
    public int add(Qy qy){
        int re = crudMapper.add(qy);
        return re;
    }

    /**
     * tb_qy 表的删
     * @date 2021/4/12 9:33
     * @param qyid 企业id
     * @return
     */
    @Override
    public int del(String qyid){
        int re = crudMapper.del(qyid);
        return re;
    }

    /**
     * tb_qy 表的改
     * @date 2021/4/12 9:33
     * @param qy 企业实体
     * @return
     */
    @Override
    public int edit(Qy qy){
        int re = crudMapper.edit(qy);
        return re;
    }

    /**
     * tb_qy 表的查
     * @date 2021/4/12 9:33
     * @param qyid 企业id
     * @return
     */
    @Override
    public Qy query(String qyid){
        Qy re = crudMapper.query(qyid);
        return re;
    }
}
