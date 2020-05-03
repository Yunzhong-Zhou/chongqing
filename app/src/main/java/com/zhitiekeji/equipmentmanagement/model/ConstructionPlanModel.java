package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/24.
 */

public class ConstructionPlanModel implements Serializable {

    /**
     * id : 801df16dee16ea49ee937410d2d2f124
     * type : 1
     * title : 日计划1
     * created_at : 2018-03-26 16:04:33
     * status : 2
     * user_name : 超级管理员
     */

    private String id;
    private int type;
    private String title;
    private String created_at;
    private int status;
    private String user_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "ConstructionPlanModel{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", created_at='" + created_at + '\'' +
                ", status=" + status +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
