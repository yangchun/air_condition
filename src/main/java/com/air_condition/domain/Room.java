package com.air_condition.domain;

public class Room {
    private Integer roomNum;

    private String temp;

    private String humidity;

    private String type;

    private Double airSpeed;

    private Integer state;

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(Double airSpeed) {
        this.airSpeed = airSpeed;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}