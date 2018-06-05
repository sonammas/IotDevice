package com.sonam.mas.IOTdevice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IotDevice {

    private String id;

    private String deviceName;

    private Long value;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IotDevice() {}

    @JsonCreator
    public IotDevice(@JsonProperty("id") String id,
                     @JsonProperty("deviceName") String deviceName,
                     @JsonProperty("value") Long value,
                     @JsonProperty("date") Date date) {
        this.id = id;
        this.deviceName = deviceName;
        this.date = date;
        this.value = value;
    }
}
