package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/19.
 */

public class WorkAreaModel implements Serializable {

    /**
     * work_area_id : 233f9a9d6bfed3d171f8490a4ecdfe20
     * money : 1988.00
     * name : 重庆南工区
     * count : 2
     * sort : 0
     */

    private String work_area_id;
    private String money;
    private String name;
    private int count;
    private int sort;

    public String getWork_area_id() {
        return work_area_id;
    }

    public void setWork_area_id(String work_area_id) {
        this.work_area_id = work_area_id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "WorkAreaModel{" +
                "work_area_id='" + work_area_id + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", sort=" + sort +
                '}';
    }
}
