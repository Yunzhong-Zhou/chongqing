package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/30.
 */

public class MaterialJsonModel implements Serializable{

    /**
     * material_id : x01
     * qty : 8
     * money : 800
     */

    private String material_id;
    private String qty;
    private String money;

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "MaterialJsonModel{" +
                "material_id='" + material_id + '\'' +
                ", qty='" + qty + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
