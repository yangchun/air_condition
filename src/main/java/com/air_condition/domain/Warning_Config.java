package com.air_condition.domain;

public class Warning_Config {
    private Integer eqid;

    private Long warningTemp;

    private Long warningPower;

    private Integer informUser;

    private Integer state;

    public Integer getEqid() {
        return eqid;
    }

    public void setEqid(Integer eqid) {
        this.eqid = eqid;
    }

    public Long getWarningTemp() {
        return warningTemp;
    }

    public void setWarningTemp(Long warningTemp) {
        this.warningTemp = warningTemp;
    }

    public Long getWarningPower() {
        return warningPower;
    }

    public void setWarningPower(Long warningPower) {
        this.warningPower = warningPower;
    }

    public Integer getInformUser() {
        return informUser;
    }

    public void setInformUser(Integer informUser) {
        this.informUser = informUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}