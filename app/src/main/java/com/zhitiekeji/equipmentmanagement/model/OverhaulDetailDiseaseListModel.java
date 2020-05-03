package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/7/13.
 * 请检修详情-病害列表
 */

public class OverhaulDetailDiseaseListModel implements Serializable {
    /**
     * o_task : 照明设备更换(请检修)申报
     * level : 一般
     * o_fee_total : 2000
     */

    private String o_task;
    private String level;
    private int o_fee_total;

    public String getO_task() {
        return o_task;
    }

    public void setO_task(String o_task) {
        this.o_task = o_task;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getO_fee_total() {
        return o_fee_total;
    }

    public void setO_fee_total(int o_fee_total) {
        this.o_fee_total = o_fee_total;
    }

    @Override
    public String toString() {
        return "OverhaulDetailDiseaseListModel{" +
                "o_task='" + o_task + '\'' +
                ", level='" + level + '\'' +
                ", o_fee_total=" + o_fee_total +
                '}';
    }
}
