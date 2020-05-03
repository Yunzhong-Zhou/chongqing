package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/3/26.
 */

public class ConstructionPlanDetailModel implements Serializable {

    /**
     * id : 801df16dee16ea49ee937410d2d2f124
     * type : 1
     * title : 日计划1
     * content : 法国人的更多发挥更多撒谎法规建设三干扰而感人会突然觉得他
     * created_at : 2018-03-26 16:04:33
     * user_name : 超级管理员
     */

    private String id;
    private int type;
    private String title;
    private String content;
    private String created_at;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "ConstructionPlanDetailModel{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
