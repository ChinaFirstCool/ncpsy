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
@Service("crud1")
public class Crud1ServiceImpl implements CrudService {

    public static String pam = "aa";

    /**
     * 无参构造函数  不写会默认自己创建   作用初始化类  还可以自定义  有参数的构造函数
     */
    public Crud1ServiceImpl(){
        //比如 初始化类参数
        pam = "bb";
    }

/*    public Crud1ServiceImpl(String gz){
        //比如 初始化类参数
        pam = gz;
    }*/

    @Autowired
    CrudMapper crudMapper;

    /**
     * tb_qy 表的增
     * Override 关键字  重写
     * 此类有俩个 add 方法  名字相同参数不同 重载
     * @date 2021/4/12 9:33
     * @param qy {@link Qy}
     * @return
     */
    @Override
    public int add(Qy qy){
        int re = crudMapper.add(qy);
        return re;
    }
    public void add(String test){

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


    /**
     * java基本数据类型，其他的都是包装类型  比如  Integer Long 等
     *
     * byte：8位，最大存储数据量是255，存放的数据范围是-128~127之间。
     *
     * short：16位，最大数据存储量是65536，数据范围是-32768~32767之间。
     *
     * int：32位，最大数据存储容量是2的32次方减1，数据范围是负的2的31次方到正的2的31次方减1。
     *
     * long：64位，最大数据存储容量是2的64次方减1，数据范围为负的2的63次方到正的2的63次方减1。
     *
     * float：32位，数据范围在3.4e-45~1.4e38，直接赋值时必须在数字后加上f或F。
     *
     * double：64位，数据范围在4.9e-324~1.8e308，赋值时可以加d或D也可以不加。
     *
     * boolean：只有true和false两个取值。
     *
     * char：16位，存储Unicode码，用单引号赋值。
     */


    /**
     * java——事务四大特性
     *
     * 事务四大特性（ACID）：
     * 1、原子性（Atomicity）：化学中的原子指不可再分的基本微粒，数据库中原子性强调事务是一个不可分割的整体，事务开始后所有操作要么全部成功，要么全部失败，不可能停滞在中间某个环节。如果事务执行过程中出错就会回滚到事务开始前的状态，所有的操作就像没有发生一样不会对数据库有任何影响。
     *
     * 2、一致性（Consistency）：事务必须使数据库从一个一致性状态变换到另一个一致性状态，即一个事务执行之前和执行之后都必须处于一致性状态。拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还是5000，这就是事务的一致性。
     *
     * 3、隔离性（Isolation）：当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离，比如A正在从一张银行卡中取钱，在A取钱的过程结束前，B不能向这张卡转入钱。
     *
     * 4、持久性（Durability）：一个事务一旦被提交，则对数据库的所有更新将被保存到数据库中，不能回滚。

     */

    /**
     * final
     *
     * 被final修饰的类不可以被继承
     * 被final修饰的方法不可以被重写
     * 被final修饰的变量不可以被改变.
     */
}
