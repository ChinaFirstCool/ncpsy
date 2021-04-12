package com.suzhuoke.ncpsy.dao;

import com.suzhuoke.ncpsy.model.Qy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 增删改成mapper
 *
 * @author zyc
 * @date 2021/4/12
 */
@Repository
public interface CrudMapper {

    /**
     * 增
     * @date 2021/4/12 10:00
     * @param qy  企业实体
     * @return 返回插入了 几行
     */
    int add(@Param("qy") Qy qy);

    /**
     * 删
     * @date 2021/4/12 10:00
     * @param qyid 企业id
     * @return 返回删除了几行
     */
    int del(@Param("qyid") String qyid);

    /**
     * 改
     * @date 2021/4/12 10:00
     * @param qy  企业实体
     * @return 返回修改了 几行
     */
    int edit(@Param("qy") Qy qy);

    /**
     * 查
     * @date 2021/4/12 10:00
     * @param qyid  企业id
     * @return 返回查询的企业实体
     */
    Qy query(@Param("qyid") String qyid);
}
