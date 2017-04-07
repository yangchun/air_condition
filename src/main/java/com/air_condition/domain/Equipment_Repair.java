package com.air_condition.domain;

import java.util.Date;

public class Equipment_Repair {
    private Integer id;

    private Integer eqid;

    private Integer userid;

    private Date repairtime;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEqid() {
        return eqid;
    }

    public void setEqid(Integer eqid) {
        this.eqid = eqid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getRepairtime() {
        return repairtime;
    }

    public void setRepairtime(Date repairtime) {
        this.repairtime = repairtime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}