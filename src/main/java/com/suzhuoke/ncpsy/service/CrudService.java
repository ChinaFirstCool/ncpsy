package com.suzhuoke.ncpsy.service;

import com.suzhuoke.ncpsy.model.Qy;

/**
 * 增删改查接口
 *
 * @author zyc
 * @date 2021/4/12
 */
public interface CrudService {

    /**
     * tb_qy 表的增
     * @date 2021/4/12 9:33
     * @param qy {@link Qy}
     * @return
     */
    int add(Qy qy);

    /**
     * tb_qy 表的删
     * @date 2021/4/12 9:33
     * @param qyid 企业id
     * @return
     */
    int del(String qyid);

    /**
     * tb_qy 表的改
     * @date 2021/4/12 9:33
     * @param qy 企业实体
     * @return
     */
    int edit(Qy qy);

    /**
     * tb_qy 表的查
     * @date 2021/4/12 9:33
     * @param qyid 企业id
     * @return
     */
    Qy query(String qyid);
}
