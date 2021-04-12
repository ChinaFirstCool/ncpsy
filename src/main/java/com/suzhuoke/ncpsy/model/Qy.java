package com.suzhuoke.ncpsy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 *     extends 关键字 继承的一种体现  Model 是mybatis自带的  类 不用关心他暂时
 * </p>
 *
 */
@TableName("tb_qy")
public class Qy extends Model<Qy> {

    private static final long serialVersionUID = 1L;

    /**
     * qyid 企业id
     * private 私有不能直接被外部修改。必须通过 get set 修改和获取   封装的一种体现
     */
    private String qyid;

    private String zh;

    private String mm;

    private String qymc;

    private String dz;

    private String fzr;

    private String dh;

    private String yx;

    private String bz;


    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    protected Serializable pkVal() {
        return this.qyid;
    }

    @Override
    public String toString() {
        return "Qy{" +
        "qyid=" + qyid +
        ", zh=" + zh +
        ", mm=" + mm +
        ", qymc=" + qymc +
        ", dz=" + dz +
        ", fzr=" + fzr +
        ", dh=" + dh +
        ", yx=" + yx +
        ", bz=" + bz +
        "}";
    }
}
