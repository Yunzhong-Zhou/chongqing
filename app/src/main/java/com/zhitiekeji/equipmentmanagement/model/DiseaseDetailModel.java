package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/18.
 */

public class DiseaseDetailModel implements Serializable {
    /**
     * id : 2391404c96dbfd5e5b8fd6a6cd92bfb7
     * facility_disease_repair_id : 71fcfffba09eea1a9f3c0bc788352634
     * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
     * facility_id : 2f9804724a3f31539973a9631142429c
     * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
     * facility_service_apply_id : d08501e3ece341352475d40ce57b5d18
     * facility_service_report_id : 4b306f0c9fe856d3b97ec5853d830b29
     * facility_disease_valuation_id : 7be209c469cd9ba0153a05ad73fa1fa0
     * price : 2.00
     * amount_money : 24.00
     * title : 大修
     * degree : 2
     * area : 12
     * pic_list : ["\/upload\/facility-disease\/2017-11-24\/377a1688056c0e4aa7e2834c6331407d.jpg"]
     * description : 大家阿胶粉看看
     * finalize : 1
     * created_at : 2017-11-24 20:46:08
     * updated_at : 2017-11-30 16:52:02
     * deleted_at : null
     * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":5,"role_description":4,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":null}
     * facility_disease_repair : {"id":"71fcfffba09eea1a9f3c0bc788352634","facility_disease_id":"2391404c96dbfd5e5b8fd6a6cd92bfb7","employee_id":"86979a51f328e0bd264b026411bd000e","facility_id":"2f9804724a3f31539973a9631142429c","facility_service_apply_id":"d08501e3ece341352475d40ce57b5d18","facility_service_report_id":"4b306f0c9fe856d3b97ec5853d830b29","pic_list":"[\"\\/upload\\/facility-disease\\/2017-11-30\\/20e92b894eca3c7c4be78edf033cc815.png\",\"\\/upload\\/facility-disease\\/2017-11-30\\/31e230f1c7ff33c82889e8f6dffd0e8e.png\",\"\\/upload\\/facility-disease\\/2017-11-30\\/a1c0a1f9bc1204b242a019cf361c0d6b.png\"]","description":"大红包姐姐","created_at":"2017-11-30 16:52:02","updated_at":"2017-11-30 16:52:02","deleted_at":null,"employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}}
     * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"严重腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-11-30 14:50:51","deleted_at":null}
     */

    private String id;
    private String facility_disease_repair_id;
    private String employee_id;
    private String facility_id;
    private String facility_disease_type_id;
    private String facility_service_apply_id;
    private String facility_service_report_id;
    private String facility_disease_valuation_id;
    private String price;
    private String amount_money;
    private String title;
    private int degree;
    private int area;
    private String pic_list;
    private String description;
    private int finalize;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private EmployeeBean employee;
    private FacilityDiseaseRepairBean facility_disease_repair;
    private FacilityDiseaseTypeBean facility_disease_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacility_disease_repair_id() {
        return facility_disease_repair_id;
    }

    public void setFacility_disease_repair_id(String facility_disease_repair_id) {
        this.facility_disease_repair_id = facility_disease_repair_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_disease_type_id() {
        return facility_disease_type_id;
    }

    public void setFacility_disease_type_id(String facility_disease_type_id) {
        this.facility_disease_type_id = facility_disease_type_id;
    }

    public String getFacility_service_apply_id() {
        return facility_service_apply_id;
    }

    public void setFacility_service_apply_id(String facility_service_apply_id) {
        this.facility_service_apply_id = facility_service_apply_id;
    }

    public String getFacility_service_report_id() {
        return facility_service_report_id;
    }

    public void setFacility_service_report_id(String facility_service_report_id) {
        this.facility_service_report_id = facility_service_report_id;
    }

    public String getFacility_disease_valuation_id() {
        return facility_disease_valuation_id;
    }

    public void setFacility_disease_valuation_id(String facility_disease_valuation_id) {
        this.facility_disease_valuation_id = facility_disease_valuation_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount_money() {
        return amount_money;
    }

    public void setAmount_money(String amount_money) {
        this.amount_money = amount_money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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

    public int getFinalize() {
        return finalize;
    }

    public void setFinalize(int finalize) {
        this.finalize = finalize;
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

    public EmployeeBean getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBean employee) {
        this.employee = employee;
    }

    public FacilityDiseaseRepairBean getFacility_disease_repair() {
        return facility_disease_repair;
    }

    public void setFacility_disease_repair(FacilityDiseaseRepairBean facility_disease_repair) {
        this.facility_disease_repair = facility_disease_repair;
    }

    public FacilityDiseaseTypeBean getFacility_disease_type() {
        return facility_disease_type;
    }

    public void setFacility_disease_type(FacilityDiseaseTypeBean facility_disease_type) {
        this.facility_disease_type = facility_disease_type;
    }

    public static class EmployeeBean {
        /**
         * id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * mobile : 13000000005
         * active : 1
         * head : /upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png
         * duty : 64
         * role : 5
         * role_description : 4
         * idcard :
         * name : 段长
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id :
         * work_area_id :
         * ip :
         * created_at : 2017-10-09 15:51:41
         * updated_at : 2017-11-21 11:32:50
         * deleted_at : null
         */

        private String id;
        private String mobile;
        private int active;
        private String head;
        private String duty;
        private int role;
        private int role_description;
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

        public int getRole_description() {
            return role_description;
        }

        public void setRole_description(int role_description) {
            this.role_description = role_description;
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

    public static class FacilityDiseaseRepairBean {
        /**
         * id : 71fcfffba09eea1a9f3c0bc788352634
         * facility_disease_id : 2391404c96dbfd5e5b8fd6a6cd92bfb7
         * employee_id : 86979a51f328e0bd264b026411bd000e
         * facility_id : 2f9804724a3f31539973a9631142429c
         * facility_service_apply_id : d08501e3ece341352475d40ce57b5d18
         * facility_service_report_id : 4b306f0c9fe856d3b97ec5853d830b29
         * pic_list : ["\/upload\/facility-disease\/2017-11-30\/20e92b894eca3c7c4be78edf033cc815.png","\/upload\/facility-disease\/2017-11-30\/31e230f1c7ff33c82889e8f6dffd0e8e.png","\/upload\/facility-disease\/2017-11-30\/a1c0a1f9bc1204b242a019cf361c0d6b.png"]
         * description : 大红包姐姐
         * created_at : 2017-11-30 16:52:02
         * updated_at : 2017-11-30 16:52:02
         * deleted_at : null
         * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}
         */

        private String id;
        private String facility_disease_id;
        private String employee_id;
        private String facility_id;
        private String facility_service_apply_id;
        private String facility_service_report_id;
        private String pic_list;
        private String description;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private EmployeeBeanX employee;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFacility_disease_id() {
            return facility_disease_id;
        }

        public void setFacility_disease_id(String facility_disease_id) {
            this.facility_disease_id = facility_disease_id;
        }

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getFacility_id() {
            return facility_id;
        }

        public void setFacility_id(String facility_id) {
            this.facility_id = facility_id;
        }

        public String getFacility_service_apply_id() {
            return facility_service_apply_id;
        }

        public void setFacility_service_apply_id(String facility_service_apply_id) {
            this.facility_service_apply_id = facility_service_apply_id;
        }

        public String getFacility_service_report_id() {
            return facility_service_report_id;
        }

        public void setFacility_service_report_id(String facility_service_report_id) {
            this.facility_service_report_id = facility_service_report_id;
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

        public EmployeeBeanX getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBeanX employee) {
            this.employee = employee;
        }

        public static class EmployeeBeanX {
            /**
             * id : 86979a51f328e0bd264b026411bd000e
             * mobile : 13000000007
             * active : 1
             * head :
             * duty : 64
             * role : 7
             * role_description : 4
             * idcard :
             * name : 概算所
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id :
             * work_area_id :
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
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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

    public static class FacilityDiseaseTypeBean {
        /**
         * id : 4529aed21751b7a350430adf28fd1034
         * title : 严重腐蚀破裂变形
         * created_at : 2017-08-21 10:39:52
         * updated_at : 2017-11-30 14:50:51
         * deleted_at : null
         */

        private String id;
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
    }
}
