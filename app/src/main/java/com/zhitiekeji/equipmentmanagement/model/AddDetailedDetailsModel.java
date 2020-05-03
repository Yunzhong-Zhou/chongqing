package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyz on 2018/6/19.
 */

public class AddDetailedDetailsModel implements Serializable {
    /**
     * id : 9f7beb0cd5a3cf5cdaa9520414be1aa1
     * title : 屋面
     * pic_list : ["/upload/facility_detail/2018-06-20/169dac4ea835ba30c0af2cfb07016b51.jpg","/upload/facility_detail/2018-06-20/f0e2fce532a1b33b995426c8fc300390.jpg"]
     * content : 屋面说明
     * type_name : 屋面
     * created_at : 2018.06.20
     */

    private String id;
    private String title;
    private String content;
    private String type_name;
    private String created_at;
    private List<String> pic_list;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<String> getPic_list() {
        return pic_list;
    }

    public void setPic_list(List<String> pic_list) {
        this.pic_list = pic_list;
    }
}
