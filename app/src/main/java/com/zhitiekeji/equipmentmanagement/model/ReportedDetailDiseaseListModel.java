package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/7/18.
 * 上报详情 -病害列表
 */

public class ReportedDetailDiseaseListModel implements Serializable {

    /**
     * year : 2001
     * month : 3-23
     * o_name : 岔口房屋增建(大修)申报
     * status : 1
     */

    private String year;
    private String month;
    private String o_name;
    private int status;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportedDetailDiseaseListModel{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", o_name='" + o_name + '\'' +
                ", status=" + status +
                '}';
    }
}
