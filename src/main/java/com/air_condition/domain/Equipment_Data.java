package com.air_condition.domain;

import java.util.Date;

public class Equipment_Data {
    private Integer eqid;

    private String eqname;

    private String eqparm;

    private String eqvalue;

    private String eqstate;

    private Date recordtime;

    private String version;

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

    public String getEqparm() {
        return eqparm;
    }

    public void setEqparm(String eqparm) {
        this.eqparm = eqparm == null ? null : eqparm.trim();
    }

    public String getEqvalue() {
        return eqvalue;
    }

    public void setEqvalue(String eqvalue) {
        this.eqvalue = eqvalue == null ? null : eqvalue.trim();
    }

    public String getEqstate() {
        return eqstate;
    }

    public void setEqstate(String eqstate) {
        this.eqstate = eqstate == null ? null : eqstate.trim();
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}