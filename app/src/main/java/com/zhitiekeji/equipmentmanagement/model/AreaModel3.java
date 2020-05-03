package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/10.
 */

public class AreaModel3 implements Serializable {
    /**
     * id : 8a6a4aeed6f8f05aa8a0d9cbb33bc356
     * railway_id : 1cc13085547209494c91c1180501b5bf
     * section_id : 41c0b73c60e2af2e339bec28d084b5e7
     * workshop_id : 0f9b6f26038a351ec9bd3ec61f09f115
     * work_area_id : 511709c8c711863182b8ab4611e502be
     * title : 站区1
     * created_at : 2017-08-07 18:38:58
     * updated_at : 2017-08-07 18:38:58
     * deleted_at : null
     */

    private String id;
    private String railway_id;
    private String section_id;
    private String workshop_id;
    private String work_area_id;
    private String title;
    private String created_at;
    private String updated_at;
    private Object deleted_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRailway_id() {
        return railway_id;
    }

    public void setRailway_id(String railway_id) {
        this.railway_id = railway_id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(String workshop_id) {
        this.workshop_id = workshop_id;
    }

    public String getWork_area_id() {
        return work_area_id;
    }

    public void setWork_area_id(String work_area_id) {
        this.work_area_id = work_area_id;
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
        return "AreaModel3{" +
                "id='" + id + '\'' +
                ", railway_id='" + railway_id + '\'' +
                ", section_id='" + section_id + '\'' +
                ", workshop_id='" + workshop_id + '\'' +
                ", work_area_id='" + work_area_id + '\'' +
                ", title='" + title + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
