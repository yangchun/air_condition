package com.air_condition.domain;

public class Limit {
    private Integer id;

    private String limitname;

    private String limitcode;

    private String limitdesc;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLimitname() {
        return limitname;
    }

    public void setLimitname(String limitname) {
        this.limitname = limitname == null ? null : limitname.trim();
    }

    public String getLimitcode() {
        return limitcode;
    }

    public void setLimitcode(String limitcode) {
        this.limitcode = limitcode == null ? null : limitcode.trim();
    }

    public String getLimitdesc() {
        return limitdesc;
    }

    public void setLimitdesc(String limitdesc) {
        this.limitdesc = limitdesc == null ? null : limitdesc.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}