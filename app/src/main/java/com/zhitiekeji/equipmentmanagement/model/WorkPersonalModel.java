package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/19.
 */

public class WorkPersonalModel implements Serializable {
    /**
     * employee_id : acdb6ef78389f6d67cafed76405cfbbc
     * money : 2388.00
     * name : 巡检工
     * count : 3
     * sort : 0
     */

    private String employee_id;
    private String money;
    private String name;
    private int count;
    private int sort;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
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
        return "WorkPersonalModel{" +
                "employee_id='" + employee_id + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", sort=" + sort +
                '}';
    }
}
