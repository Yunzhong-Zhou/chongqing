package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/6/21.
 */

public class DetailedDetailsTypeModel implements Serializable {
    /**
     * id : 3f49d2c0ac0682efb5c391968e843500
     * title : 变形缝
     * parent_id : 16d5348a9faf873d9421c3417d423140
     */

    private String id;
    private String title;
    private String parent_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
}
