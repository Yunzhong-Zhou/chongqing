package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/27.
 */

public class StaffManagementDetailModel implements Serializable {
    /**
     * status : 1
     * created_at : 2018-03-27 15:59:10
     * facility_name : 小南海车务段会议室
     * facility_number : CY5500060
     * employee_name : 巡检工
     */

    private int status;
    private String created_at;
    private String facility_name;
    private String facility_number;
    private String employee_name;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_number() {
        return facility_number;
    }

    public void setFacility_number(String facility_number) {
        this.facility_number = facility_number;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    @Override
    public String toString() {
        return "StaffManagementDetailModel{" +
                "status=" + status +
                ", created_at='" + created_at + '\'' +
                ", facility_name='" + facility_name + '\'' +
                ", facility_number='" + facility_number + '\'' +
                ", employee_name='" + employee_name + '\'' +
                '}';
    }
}
