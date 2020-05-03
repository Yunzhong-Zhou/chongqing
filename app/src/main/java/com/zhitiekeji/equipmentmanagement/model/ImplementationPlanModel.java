package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by fafukeji01 on 2017/7/14.
 * 实施model
 */

public class ImplementationPlanModel implements Serializable {

    /**
     * id : 1689662badcbf66a339ce5aed99f2613
     * facility_id : 0a11abcebe95181a23337f2faa6a79d8
     * facility_service_report_id : 1e14c2f6f2f6004786205e03cf91e1b5
     * facility_service_apply_id : 9c725dba859e40716407dcbe832ce64d
     * facility_service_approval_id : b9d58a8e53ccb49ac9253dafa73b5482
     * facility_service_issue_id : 90563cd79d6525f897c1fc3fc5a6bc45
     * facility_service_reply_id : 2e471699d4c32198c53add49b9b03bcd
     * employee_id : 86979a51f328e0bd264b026411bd000e
     * start_at : 2017-11-24 00:00:00
     * end_at : 2017-11-30 00:00:00
     * design_company : 公积金卡
     * construction_company : 古巨基
     * supervisor_company : 黄金甲
     * contract_money : 500.00
     * completion_plan : /upload/completion/2017-11-24/ad0b111cd1fc4511c620645407a4c510.png
     * content : 还回家
     * pic_list : ["\/upload\/implement\/2017-11-24\/8a38fc6252ae7432bda629de82de4d33.png","\/upload\/implement\/2017-11-24\/f317826b27107ff260aca9a2793925f8.png"]
     * created_at : 2017-11-24 16:51:11
     * updated_at : 2017-11-24 16:51:11
     * deleted_at :
     * facility : {"id":"0a11abcebe95181a23337f2faa6a79d8","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"a51e3c04a5fda9ea98c28bfdd3f61dde","station_id":"3a3d00cd19fc25a3720daf236d39fa56","company_id":"5356bdd2a4a09b6222c60e317ede6d8f","type":"1","skill_type":"1","title":"设备修改测试1","number":"xc005_2121","pic1":"/upload/facility/2017-11-21/84696270068e25ed0b094da1e7cfcf4f.jpg","pic2":"/upload/facility/2017-11-21/70ef25560bca50cf0b3b9b6ca841c850.png","pic3":"/upload/facility/2017-11-21/51007db6811ec3c49f68c7f2278f3148.jpg","area":"6433","use_age":"50","addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":"1","longitude":"108.571414","latitude":"29.534459","status":"2","reason":"","last_small_service_at":"","last_mid_service_at":"","last_big_service_at":"","created_at":"2017-11-21 11:19:32","updated_at":"2017-11-21 17:57:04","deleted_at":"","extra_json":"","line":"","remark":"","use_status":"1","ha_total":"","house_area":"","attached_area":"","structure":"","floor":"","build_age":"","roof_form":"","roof_area":"","use_nature":"4","category":"4","structures_unit":"","structures_quantity":"","structures_area":"","section":{"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":""},"workshop":{"id":"ce3b156d82d6f8eef15e1e7d16b89776","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆车间","longitude":"106.722386","latitude":"29.834357","facility_count":"5","created_at":"2017-10-13 14:02:26","updated_at":"2017-11-21 11:19:50","deleted_at":""},"work_area":{"id":"a51e3c04a5fda9ea98c28bfdd3f61dde","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","title":"达州工区","longitude":"106.72986","latitude":"29.164357","facility_count":"3","created_at":"2017-10-13 14:24:43","updated_at":"2017-11-24 14:45:49","deleted_at":""},"station":{"id":"3a3d00cd19fc25a3720daf236d39fa56","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"a51e3c04a5fda9ea98c28bfdd3f61dde","title":"G站区","created_at":"2017-10-13 14:29:32","updated_at":"2017-10-26 09:34:59","deleted_at":""},"company":{"id":"5356bdd2a4a09b6222c60e317ede6d8f","title":"智铁科技","created_at":"2017-10-16 14:20:19","updated_at":"2017-10-26 10:16:47","deleted_at":""}}
     * facility_service_apply : {"id":"9c725dba859e40716407dcbe832ce64d","facility_id":"0a11abcebe95181a23337f2faa6a79d8","publish_disease_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","employee_role":"5","type":"3","disease_classify":"3","status":"5","facility_service_report_id":"1e14c2f6f2f6004786205e03cf91e1b5","batch_year":"2017","batch":"3","created_at":"2017-11-24 16:26:59","updated_at":"2017-11-24 16:51:11","deleted_at":""}
     */

    private String id;
    private String facility_id;
    private String facility_service_report_id;
    private String facility_service_apply_id;
    private String facility_service_approval_id;
    private String facility_service_issue_id;
    private String facility_service_reply_id;
    private String employee_id;
    private String start_at;
    private String end_at;
    private String design_company;
    private String construction_company;
    private String supervisor_company;
    private String contract_money;
    private String completion_plan;
    private String content;
    private String pic_list;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private FacilityBean facility;
    private FacilityServiceApplyBean facility_service_apply;

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

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getDesign_company() {
        return design_company;
    }

    public void setDesign_company(String design_company) {
        this.design_company = design_company;
    }

    public String getConstruction_company() {
        return construction_company;
    }

    public void setConstruction_company(String construction_company) {
        this.construction_company = construction_company;
    }

    public String getSupervisor_company() {
        return supervisor_company;
    }

    public void setSupervisor_company(String supervisor_company) {
        this.supervisor_company = supervisor_company;
    }

    public String getContract_money() {
        return contract_money;
    }

    public void setContract_money(String contract_money) {
        this.contract_money = contract_money;
    }

    public String getCompletion_plan() {
        return completion_plan;
    }

    public void setCompletion_plan(String completion_plan) {
        this.completion_plan = completion_plan;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public FacilityBean getFacility() {
        return facility;
    }

    public void setFacility(FacilityBean facility) {
        this.facility = facility;
    }

    public FacilityServiceApplyBean getFacility_service_apply() {
        return facility_service_apply;
    }

    public void setFacility_service_apply(FacilityServiceApplyBean facility_service_apply) {
        this.facility_service_apply = facility_service_apply;
    }

    public static class FacilityBean {
        /**
         * id : 0a11abcebe95181a23337f2faa6a79d8
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * user_id : 94dd2a7cecb2580f30807a98c218be94
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
         * work_area_id : a51e3c04a5fda9ea98c28bfdd3f61dde
         * station_id : 3a3d00cd19fc25a3720daf236d39fa56
         * company_id : 5356bdd2a4a09b6222c60e317ede6d8f
         * type : 1
         * skill_type : 1
         * title : 设备修改测试1
         * number : xc005_2121
         * pic1 : /upload/facility/2017-11-21/84696270068e25ed0b094da1e7cfcf4f.jpg
         * pic2 : /upload/facility/2017-11-21/70ef25560bca50cf0b3b9b6ca841c850.png
         * pic3 : /upload/facility/2017-11-21/51007db6811ec3c49f68c7f2278f3148.jpg
         * area : 6433
         * use_age : 50
         * addr : 中国重庆市南岸区南坪区府美食街惠工路14号
         * annual : 1
         * longitude : 108.571414
         * latitude : 29.534459
         * status : 2
         * reason :
         * last_small_service_at :
         * last_mid_service_at :
         * last_big_service_at :
         * created_at : 2017-11-21 11:19:32
         * updated_at : 2017-11-21 17:57:04
         * deleted_at :
         * extra_json :
         * line :
         * remark :
         * use_status : 1
         * ha_total :
         * house_area :
         * attached_area :
         * structure :
         * floor :
         * build_age :
         * roof_form :
         * roof_area :
         * use_nature : 4
         * category : 4
         * structures_unit :
         * structures_quantity :
         * structures_area :
         * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":""}
         * workshop : {"id":"ce3b156d82d6f8eef15e1e7d16b89776","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆车间","longitude":"106.722386","latitude":"29.834357","facility_count":"5","created_at":"2017-10-13 14:02:26","updated_at":"2017-11-21 11:19:50","deleted_at":""}
         * work_area : {"id":"a51e3c04a5fda9ea98c28bfdd3f61dde","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","title":"达州工区","longitude":"106.72986","latitude":"29.164357","facility_count":"3","created_at":"2017-10-13 14:24:43","updated_at":"2017-11-24 14:45:49","deleted_at":""}
         * station : {"id":"3a3d00cd19fc25a3720daf236d39fa56","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"a51e3c04a5fda9ea98c28bfdd3f61dde","title":"G站区","created_at":"2017-10-13 14:29:32","updated_at":"2017-10-26 09:34:59","deleted_at":""}
         * company : {"id":"5356bdd2a4a09b6222c60e317ede6d8f","title":"智铁科技","created_at":"2017-10-16 14:20:19","updated_at":"2017-10-26 10:16:47","deleted_at":""}
         */

        private String id;
        private String employee_id;
        private String user_id;
        private String railway_id;
        private String section_id;
        private String workshop_id;
        private String work_area_id;
        private String station_id;
        private String company_id;
        private String type;
        private String skill_type;
        private String title;
        private String number;
        private String pic1;
        private String pic2;
        private String pic3;
        private String area;
        private String use_age;
        private String addr;
        private String annual;
        private String longitude;
        private String latitude;
        private String status;
        private String reason;
        private String last_small_service_at;
        private String last_mid_service_at;
        private String last_big_service_at;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private String extra_json;
        private String line;
        private String remark;
        private String use_status;
        private String ha_total;
        private String house_area;
        private String attached_area;
        private String structure;
        private String floor;
        private String build_age;
        private String roof_form;
        private String roof_area;
        private String use_nature;
        private String category;
        private String structures_unit;
        private String structures_quantity;
        private String structures_area;
        private SectionBean section;
        private WorkshopBean workshop;
        private WorkAreaBean work_area;
        private StationBean station;
        private CompanyBean company;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
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

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSkill_type() {
            return skill_type;
        }

        public void setSkill_type(String skill_type) {
            this.skill_type = skill_type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getPic1() {
            return pic1;
        }

        public void setPic1(String pic1) {
            this.pic1 = pic1;
        }

        public String getPic2() {
            return pic2;
        }

        public void setPic2(String pic2) {
            this.pic2 = pic2;
        }

        public String getPic3() {
            return pic3;
        }

        public void setPic3(String pic3) {
            this.pic3 = pic3;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getUse_age() {
            return use_age;
        }

        public void setUse_age(String use_age) {
            this.use_age = use_age;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getAnnual() {
            return annual;
        }

        public void setAnnual(String annual) {
            this.annual = annual;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getLast_small_service_at() {
            return last_small_service_at;
        }

        public void setLast_small_service_at(String last_small_service_at) {
            this.last_small_service_at = last_small_service_at;
        }

        public String getLast_mid_service_at() {
            return last_mid_service_at;
        }

        public void setLast_mid_service_at(String last_mid_service_at) {
            this.last_mid_service_at = last_mid_service_at;
        }

        public String getLast_big_service_at() {
            return last_big_service_at;
        }

        public void setLast_big_service_at(String last_big_service_at) {
            this.last_big_service_at = last_big_service_at;
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

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getExtra_json() {
            return extra_json;
        }

        public void setExtra_json(String extra_json) {
            this.extra_json = extra_json;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUse_status() {
            return use_status;
        }

        public void setUse_status(String use_status) {
            this.use_status = use_status;
        }

        public String getHa_total() {
            return ha_total;
        }

        public void setHa_total(String ha_total) {
            this.ha_total = ha_total;
        }

        public String getHouse_area() {
            return house_area;
        }

        public void setHouse_area(String house_area) {
            this.house_area = house_area;
        }

        public String getAttached_area() {
            return attached_area;
        }

        public void setAttached_area(String attached_area) {
            this.attached_area = attached_area;
        }

        public String getStructure() {
            return structure;
        }

        public void setStructure(String structure) {
            this.structure = structure;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getBuild_age() {
            return build_age;
        }

        public void setBuild_age(String build_age) {
            this.build_age = build_age;
        }

        public String getRoof_form() {
            return roof_form;
        }

        public void setRoof_form(String roof_form) {
            this.roof_form = roof_form;
        }

        public String getRoof_area() {
            return roof_area;
        }

        public void setRoof_area(String roof_area) {
            this.roof_area = roof_area;
        }

        public String getUse_nature() {
            return use_nature;
        }

        public void setUse_nature(String use_nature) {
            this.use_nature = use_nature;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStructures_unit() {
            return structures_unit;
        }

        public void setStructures_unit(String structures_unit) {
            this.structures_unit = structures_unit;
        }

        public String getStructures_quantity() {
            return structures_quantity;
        }

        public void setStructures_quantity(String structures_quantity) {
            this.structures_quantity = structures_quantity;
        }

        public String getStructures_area() {
            return structures_area;
        }

        public void setStructures_area(String structures_area) {
            this.structures_area = structures_area;
        }

        public SectionBean getSection() {
            return section;
        }

        public void setSection(SectionBean section) {
            this.section = section;
        }

        public WorkshopBean getWorkshop() {
            return workshop;
        }

        public void setWorkshop(WorkshopBean workshop) {
            this.workshop = workshop;
        }

        public WorkAreaBean getWork_area() {
            return work_area;
        }

        public void setWork_area(WorkAreaBean work_area) {
            this.work_area = work_area;
        }

        public StationBean getStation() {
            return station;
        }

        public void setStation(StationBean station) {
            this.station = station;
        }

        public CompanyBean getCompany() {
            return company;
        }

        public void setCompany(CompanyBean company) {
            this.company = company;
        }

        public static class SectionBean {
            /**
             * id : a982d549217f04c3c063e247fb262cd7
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * title : 重庆
             * longitude : 106.571387
             * latitude : 29.534466
             * created_at : 2017-10-09 15:44:15
             * updated_at : 2017-10-23 14:10:01
             * deleted_at :
             */

            private String id;
            private String railway_id;
            private String title;
            private String longitude;
            private String latitude;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }

        public static class WorkshopBean {
            /**
             * id : ce3b156d82d6f8eef15e1e7d16b89776
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * title : 重庆车间
             * longitude : 106.722386
             * latitude : 29.834357
             * facility_count : 5
             * created_at : 2017-10-13 14:02:26
             * updated_at : 2017-11-21 11:19:50
             * deleted_at :
             */

            private String id;
            private String railway_id;
            private String section_id;
            private String title;
            private String longitude;
            private String latitude;
            private String facility_count;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getFacility_count() {
                return facility_count;
            }

            public void setFacility_count(String facility_count) {
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }

        public static class WorkAreaBean {
            /**
             * id : a51e3c04a5fda9ea98c28bfdd3f61dde
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
             * title : 达州工区
             * longitude : 106.72986
             * latitude : 29.164357
             * facility_count : 3
             * created_at : 2017-10-13 14:24:43
             * updated_at : 2017-11-24 14:45:49
             * deleted_at :
             */

            private String id;
            private String railway_id;
            private String section_id;
            private String workshop_id;
            private String title;
            private String longitude;
            private String latitude;
            private String facility_count;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getFacility_count() {
                return facility_count;
            }

            public void setFacility_count(String facility_count) {
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }

        public static class StationBean {
            /**
             * id : 3a3d00cd19fc25a3720daf236d39fa56
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
             * work_area_id : a51e3c04a5fda9ea98c28bfdd3f61dde
             * title : G站区
             * created_at : 2017-10-13 14:29:32
             * updated_at : 2017-10-26 09:34:59
             * deleted_at :
             */

            private String id;
            private String railway_id;
            private String section_id;
            private String workshop_id;
            private String work_area_id;
            private String title;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }

        public static class CompanyBean {
            /**
             * id : 5356bdd2a4a09b6222c60e317ede6d8f
             * title : 智铁科技
             * created_at : 2017-10-16 14:20:19
             * updated_at : 2017-10-26 10:16:47
             * deleted_at :
             */

            private String id;
            private String title;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }
    }

    public static class FacilityServiceApplyBean {
        /**
         * id : 9c725dba859e40716407dcbe832ce64d
         * facility_id : 0a11abcebe95181a23337f2faa6a79d8
         * publish_disease_id :
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * employee_role : 5
         * type : 3
         * disease_classify : 3
         * status : 5
         * facility_service_report_id : 1e14c2f6f2f6004786205e03cf91e1b5
         * batch_year : 2017
         * batch : 3
         * created_at : 2017-11-24 16:26:59
         * updated_at : 2017-11-24 16:51:11
         * deleted_at :
         */

        private String id;
        private String facility_id;
        private String publish_disease_id;
        private String employee_id;
        private String employee_role;
        private String type;
        private String disease_classify;
        private String status;
        private String facility_service_report_id;
        private String batch_year;
        private String batch;
        private String created_at;
        private String updated_at;
        private String deleted_at;

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

        public String getPublish_disease_id() {
            return publish_disease_id;
        }

        public void setPublish_disease_id(String publish_disease_id) {
            this.publish_disease_id = publish_disease_id;
        }

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getEmployee_role() {
            return employee_role;
        }

        public void setEmployee_role(String employee_role) {
            this.employee_role = employee_role;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDisease_classify() {
            return disease_classify;
        }

        public void setDisease_classify(String disease_classify) {
            this.disease_classify = disease_classify;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFacility_service_report_id() {
            return facility_service_report_id;
        }

        public void setFacility_service_report_id(String facility_service_report_id) {
            this.facility_service_report_id = facility_service_report_id;
        }

        public String getBatch_year() {
            return batch_year;
        }

        public void setBatch_year(String batch_year) {
            this.batch_year = batch_year;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
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

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }
    }
}
