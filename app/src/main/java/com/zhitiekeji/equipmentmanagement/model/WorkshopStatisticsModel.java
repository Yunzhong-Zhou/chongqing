package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/19.
 */

public class WorkshopStatisticsModel implements Serializable {
    /**
     * id : ce3b156d82d6f8eef15e1e7d16b89776
     * name : 重庆
     * count : 3
     * material_money : 1200
     * artificial_money : 1188
     * total_money : 2388
     * facility_disease_area : 16
     * facility_qty : 1
     */

    private String id;
    private String name;
    private String count;
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    private String material_money;
    private String artificial_money;
    private String total_money;
    private String facility_disease_area;
    private int facility_qty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMaterial_money() {
        return material_money;
    }

    public void setMaterial_money(String material_money) {
        this.material_money = material_money;
    }

    public String getArtificial_money() {
        return artificial_money;
    }

    public void setArtificial_money(String artificial_money) {
        this.artificial_money = artificial_money;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getFacility_disease_area() {
        return facility_disease_area;
    }

    public void setFacility_disease_area(String facility_disease_area) {
        this.facility_disease_area = facility_disease_area;
    }

    public int getFacility_qty() {
        return facility_qty;
    }

    public void setFacility_qty(int facility_qty) {
        this.facility_qty = facility_qty;
    }

    @Override
    public String toString() {
        return "WorkshopStatisticsModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                ", material_money='" + material_money + '\'' +
                ", artificial_money='" + artificial_money + '\'' +
                ", total_money='" + total_money + '\'' +
                ", facility_disease_area='" + facility_disease_area + '\'' +
                ", facility_qty=" + facility_qty +
                '}';
    }
}
