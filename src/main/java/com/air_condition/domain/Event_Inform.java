package com.air_condition.domain;

import java.util.Date;

public class Event_Inform {
    private Integer id;

    private Integer eqid;

    private String eqname;

    private Date informtime;

    private String grade;

    private String desc;

    private String state;

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

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname == null ? null : eqname.trim();
    }

    public Date getInformtime() {
        return informtime;
    }

    public void setInformtime(Date informtime) {
        this.informtime = informtime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}