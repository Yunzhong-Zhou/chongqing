package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/7/12.
 */

public class PersonalInformationModel implements Serializable {


    /**
     * id : 3e8e3f1a802828f137dd9c1cd5ae205e
     * mobile : 13000000005
     * active : 1
     * head :
     * duty : 64
     * role : 5
     * idcard :
     * name : 段长
     * railway_id : 23cd931f4e6d162e10fe435e2a06933d
     * section_id : a982d549217f04c3c063e247fb262cd7
     * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
     * work_area_id : ae445ad9baa0886e952c48ec32e134d8
     * ip :
     * created_at : 2017-10-09 15:51:41
     * updated_at : 2017-10-09 19:05:41
     * deleted_at : null
     * workarea : {"id":"ae445ad9baa0886e952c48ec32e134d8","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"沙坪坝A工区","longitude":"106.522386","latitude":"29.538357","facility_count":3,"created_at":"2017-10-09 15:45:38","updated_at":"2017-10-26 09:54:13","deleted_at":null}
     */

    private String id;
    private String mobile;
    private int active;
    private String head;
    private String duty;
    private int role;
    private String idcard;
    private String name;
    private String railway_id;
    private String section_id;
    private String workshop_id;
    private String work_area_id;
    private String ip;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private WorkareaBean workarea;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public WorkareaBean getWorkarea() {
        return workarea;
    }

    public void setWorkarea(WorkareaBean workarea) {
        this.workarea = workarea;
    }

    public static class WorkareaBean {
        /**
         * id : ae445ad9baa0886e952c48ec32e134d8
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
         * title : 沙坪坝A工区
         * longitude : 106.522386
         * latitude : 29.538357
         * facility_count : 3
         * created_at : 2017-10-09 15:45:38
         * updated_at : 2017-10-26 09:54:13
         * deleted_at : null
         */

        private String id;
        private String railway_id;
        private String section_id;
        private String workshop_id;
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

        public String getWorkshop_id() {
            return workshop_id;
        }

        public void setWorkshop_id(String workshop_id) {
            this.workshop_id = workshop_id;
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
    }
}
