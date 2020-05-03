package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class MaintenanceRecordModel implements Serializable {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "MaintenanceRecordModel{" +
                "str='" + str + '\'' +
                '}';
    }
}
