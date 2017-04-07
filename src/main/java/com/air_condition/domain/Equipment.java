package com.air_condition.domain;

import java.util.Date;

public class Equipment {
    private Integer id;

    private String eqname;

    private String eqtype;

    private Date eqbuytime;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname == null ? null : eqname.trim();
    }

    public String getEqtype() {
        return eqtype;
    }

    public void setEqtype(String eqtype) {
        this.eqtype = eqtype == null ? null : eqtype.trim();
    }

    public Date getEqbuytime() {
        return eqbuytime;
    }

    public void setEqbuytime(Date eqbuytime) {
        this.eqbuytime = eqbuytime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}