package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2018/6/19.
 */

public class SchoolBagModel implements Serializable {

    /**
     * id : 1aa2279b4ecb27b1f43690b24a8657db
     * title : 测试1
     * attachment : http://192.168.0.108/aaa.excel
     * read_count : 0
     * publish_time : 2018-06-19 11:22:41
     * user_name : 超级管理员
     */

    private String id;
    private String title;
    private String attachment;
    private int read_count;
    private String publish_time;
    private String user_name;

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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
