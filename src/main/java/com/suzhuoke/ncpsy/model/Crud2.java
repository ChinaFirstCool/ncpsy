package com.suzhuoke.ncpsy.model;

/**
 * 增删改查实体
 * Crud2 和 Crud1  都继承 Qy  多态的一种体现 extends 关键字 继承的一种体现  所以此类包含Qy的所有属性
 *
 * @author zyc
 * @date 2021/4/12
 */
public class Crud2 extends Qy {

    /**
     * qyid 企业id
     * private 私有不能直接被外部修改。必须通过 get set 修改和获取   封装的一种体现
     */
    private String privatePam;
}
