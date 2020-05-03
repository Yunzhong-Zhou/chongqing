package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/10/14.
 * 修复结果
 */

public class RepairResultsModel implements Serializable {
    /**
     * id : e334da53dc44988f9c730996a66f83b9
     * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
     * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
     * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
     * facility_service_approval_id : 9affd1fbc8e4ec9cb9a0f436636119a4
     * facility_service_issue_id : ef3b66664a4258a8da572e9e11468196
     * facility_service_reply_id : 9a048df2818b44763e06ab7438a04c11
     * facility_service_implement_id : e6664bce3d0d09b7fedf3b7937d6e1cf
     * employee_id : 86979a51f328e0bd264b026411bd000e
     * actual_money : 100000.00
     * completion_report : /upload/completion/2017-10-12/043d872f6d682a9360d2b296582df7d9.jpg
     * content : 接口测试接口测试接口测试接口测试接口测试接口测试接口测试
     * pic_list : ["\/upload\/completion\/2017-10-12\/07b91c8dcefc5241c45be569055f50ce.jpg","\/upload\/completion\/2017-10-12\/6e32e937e5312c065e1eb0800432e2d7.jpg"]
     * created_at : 2017-10-12 20:19:42
     * updated_at : 2017-10-12 20:19:42
     * deleted_at : null
     * flag : 概
     * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}
     */

    private String id;
    private String facility_id;
    private String facility_service_report_id;
    private String facility_service_apply_id;
    private String facility_service_approval_id;
    private String facility_service_issue_id;
    private String facility_service_reply_id;
    private String facility_service_implement_id;
    private String employee_id;
    private String actual_money;
    private String completion_report;
    private String content;
    private String pic_list;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private String flag;
    private EmployeeBean employee;

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

    public String getFacility_service_report_id() {
        return facility_service_report_id;
    }

    public void setFacility_service_report_id(String facility_service_report_id) {
        this.facility_service_report_id = facility_service_report_id;
    }

    public String getFacility_service_apply_id() {
        return facility_service_apply_id;
    }

    public void setFacility_service_apply_id(String facility_service_apply_id) {
        this.facility_service_apply_id = facility_service_apply_id;
    }

    public String getFacility_service_approval_id() {
        return facility_service_approval_id;
    }

    public void setFacility_service_approval_id(String facility_service_approval_id) {
        this.facility_service_approval_id = facility_service_approval_id;
    }

    public String getFacility_service_issue_id() {
        return facility_service_issue_id;
    }

    public void setFacility_service_issue_id(String facility_service_issue_id) {
        this.facility_service_issue_id = facility_service_issue_id;
    }

    public String getFacility_service_reply_id() {
        return facility_service_reply_id;
    }

    public void setFacility_service_reply_id(String facility_service_reply_id) {
        this.facility_service_reply_id = facility_service_reply_id;
    }

    public String getFacility_service_implement_id() {
        return facility_service_implement_id;
    }

    public void setFacility_service_implement_id(String facility_service_implement_id) {
        this.facility_service_implement_id = facility_service_implement_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getActual_money() {
        return actual_money;
    }

    public void setActual_money(String actual_money) {
        this.actual_money = actual_money;
    }

    public String getCompletion_report() {
        return completion_report;
    }

    public void setCompletion_report(String completion_report) {
        this.completion_report = completion_report;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic_list() {
        return pic_list;
    }

    public void setPic_list(String pic_list) {
        this.pic_list = pic_list;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public static class EmployeeBean {
        /**
         * id : 86979a51f328e0bd264b026411bd000e
         * mobile : 13000000007
         * active : 1
         * head :
         * duty : 64
         * role : 7
         * idcard :
         * name : 概算所
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
         * work_area_id : ae445ad9baa0886e952c48ec32e134d8
         * ip :
         * created_at : 2017-10-09 15:52:57
         * updated_at : 2017-10-09 15:52:57
         * deleted_at : null
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
    }
}
