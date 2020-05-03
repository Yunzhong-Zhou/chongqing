package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/10.
 */

public class AreaModel1 implements Serializable {

    /**
     * id : 0f9b6f26038a351ec9bd3ec61f09f115
     * railway_id : 1cc13085547209494c91c1180501b5bf
     * section_id : 41c0b73c60e2af2e339bec28d084b5e7
     * title : 车间1
     * longitude :
     * latitude :
     * facility_count : 2
     * created_at : 2017-08-07 18:26:33
     * updated_at : 2017-08-09 14:18:15
     * deleted_at : null
     */

    private String id;
    private String railway_id;
    private String section_id;
    private String title;
    private String longitude;
    private String latitude;
    private int facility_count;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getFacility_count() {
        return facility_count;
    }

    public void setFacility_count(int facility_count) {
        this.facility_count = facility_count;
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
        return "AreaModel1{" +
                "id='" + id + '\'' +
                ", railway_id='" + railway_id + '\'' +
                ", section_id='" + section_id + '\'' +
                ", title='" + title + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", facility_count=" + facility_count +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
