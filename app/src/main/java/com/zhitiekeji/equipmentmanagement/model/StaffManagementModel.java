package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/27.
 */

public class StaffManagementModel implements Serializable {
    /**
     * id : 02f6071211c443a26cb04c591a73ac4c
     * mobile : 18780965040
     * duty : 工人
     * name : 田雨薇
     */

    private String id;
    private String mobile;
    private String duty;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StaffManagementModel{" +
                "id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", duty='" + duty + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
