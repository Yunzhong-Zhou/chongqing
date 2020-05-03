package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class WorksShopModel implements Serializable {
    /**
     * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
     * money : 2388.00
     * name : 重庆
     * count : 3
     * sort : 0
     */

    private String workshop_id;
    private String money;
    private String name;
    private int count;
    private int sort;

    public String getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(String workshop_id) {
        this.workshop_id = workshop_id;
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
        return "WorksShopModel{" +
                "workshop_id='" + workshop_id + '\'' +
                ", money='" + money + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", sort=" + sort +
                '}';
    }
}
