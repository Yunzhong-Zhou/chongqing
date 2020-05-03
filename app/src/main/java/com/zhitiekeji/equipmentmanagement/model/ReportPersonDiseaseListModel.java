package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/2.
 */

public class ReportPersonDiseaseListModel implements Serializable {
    /**
     * id : a3c325b0797498d77c404c29d521b1e5
     * facility_id : cq23457812cy
     * member_id : a49d1be7aca355b5d167bdf9e2b9d184
     * pic_list : ["\/upload\/facility_disease\/2017-08-02\/8d5f68ef06ab36fe69a085e711532b9e.jpg","\/upload\/facility_disease\/2017-08-02\/815773519c5b2ca64640d52e13e36d23.png","\/upload\/facility_disease\/2017-08-02\/9eeafba6ca522c7ce8d10694540004ef.png"]
     * description : 是干活好纠结
     * status : 1
     * created_at : 2017-08-02 19:20:35
     * updated_at : 2017-08-02 19:20:35
     * deleted_at : null
     */

    private String id;
    private String facility_id;
    private String member_id;
    private String pic_list;
    private String description;
    private int status;
    private String created_at;
    private String updated_at;
    private Object deleted_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getPic_list() {
        return pic_list;
    }

    public void setPic_list(String pic_list) {
        this.pic_list = pic_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "ReportPersonDiseaseListModel{" +
                "id='" + id + '\'' +
                ", facility_id='" + facility_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", pic_list='" + pic_list + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
