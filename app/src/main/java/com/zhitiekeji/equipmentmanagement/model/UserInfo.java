package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * zyz:这些字段是接口文档上的，信息不全，重用的RegisterBean类。注册返回数据和登录返回数据一样的
 * Created by ling on 2015/9/25.
 * description: 目前和RegisterBean一样
 */
public class UserInfo implements Serializable {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"id":"ab53e73a2e434175341edd79d21121c5","mobile":"13629740880","active":1,"head":"","nickname":"","role":1,"idcard":"","name":"","railway_id":"1cc13085547209494c91c1180501b5bf","section_id":"41c0b73c60e2af2e339bec28d084b5e7","workshop_id":"0f9b6f26038a351ec9bd3ec61f09f115","work_area_id":"511709c8c711863182b8ab4611e502be","station_id":"8a6a4aeed6f8f05aa8a0d9cbb33bc356","ip":"192.168.0.107","created_at":"2017-08-03 11:27:49","updated_at":"2017-08-03 11:27:49","deleted_at":null}
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYjUzZTczYTJlNDM0MTc1MzQxZWRkNzlkMjExMjFjNSIsImlzcyI6Imh0dHA6XC9cLzE5Mi4xNjguMC4xMDdcL2FwaVwvbG9naW4iLCJpYXQiOjE1MDIxNjA3NjksImV4cCI6MTUwMjI0NzE2OSwibmJmIjoxNTAyMTYwNzY5LCJqdGkiOiIzMzkwNzlkNGNjNDZiNjI5YWY3ZWUwZTU1NWU5Nzk3ZSJ9.wNJ6eshsKfEnCYmNmSAMhyVr0GnCkIjI3D-Yeeb4WL4
     * userType : 1
     */

    private int code;
    private String msg;
    private DataBean data;
    private String token;
    private int userType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public static class DataBean {
        /**
         * id : ab53e73a2e434175341edd79d21121c5
         * mobile : 13629740880
         * active : 1
         * head :
         * nickname :
         * role : 1
         * idcard :
         * name :
         * railway_id : 1cc13085547209494c91c1180501b5bf
         * section_id : 41c0b73c60e2af2e339bec28d084b5e7
         * workshop_id : 0f9b6f26038a351ec9bd3ec61f09f115
         * work_area_id : 511709c8c711863182b8ab4611e502be
         * station_id : 8a6a4aeed6f8f05aa8a0d9cbb33bc356
         * ip : 192.168.0.107
         * created_at : 2017-08-03 11:27:49
         * updated_at : 2017-08-03 11:27:49
         * deleted_at : null
         */

        private String id;
        private String mobile;
        private int active;
        private String head;
        private String nickname;
        private int role;
        private String idcard;
        private String name;
        private String railway_id;
        private String section_id;
        private String workshop_id;
        private String work_area_id;
        private String station_id;
        private String ip;
        private String created_at;
        private String updated_at;
        private Object deleted_at;

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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public String getStation_id() {
            return station_id;
        }

        public void setStation_id(String station_id) {
            this.station_id = station_id;
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
    }
}
