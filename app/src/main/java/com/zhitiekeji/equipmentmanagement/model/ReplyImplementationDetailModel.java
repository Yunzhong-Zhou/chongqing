package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyz on 2017/8/21.
 */

public class ReplyImplementationDetailModel implements Serializable {

    /**
     * id : 7f0cf4ea8a108de3546d8138b08de0c1
     * facility_id : 7b7211724bb68aa241360af705f267e0
     * facility_service_report_id : 4a51504ffda8ebc3c489999a5d23b630
     * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
     * facility_service_approval_id : a203132b92e365f76b7d632a78f4f904
     * facility_service_issue_id : e9e844f2aac98d022f66684e9b0d1455
     * employee_id : 86979a51f328e0bd264b026411bd000e
     * reply_number : dghh
     * reply_at :
     * project_scope : 放假还不回家
     * supervisor_money : 3000.00
     * construction_money : 5000.00
     * design_money : 8000.00
     * amount_money : 16000.00
     * created_at : 2017-11-30 16:44:34
     * updated_at : 2017-11-30 16:44:34
     * deleted_at :
     * minor : 请检修-待签字
     * minor_updated_at : 2017-11-24
     * mid : 综合维修-竣工
     * mid_updated_at : 2017-11-24
     * big : 大修-批复
     * big_updated_at : 2017-11-30
     * facility : {"id":"7b7211724bb68aa241360af705f267e0","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","station_id":"1673e20e9d72c2ac8659e2182d69258d","company_id":"61ede8f70a0d041db205c1d67f86d2e7","type":"2","skill_type":"3","title":"设备10","number":"xc0010","pic1":"/upload/facility/2017-11-08/27c192ce5409409ee5ddbf74359219da.png","pic2":"/upload/facility/2017-11-08/c049f5688ad52cc3647946f16d41100a.png","pic3":"/upload/facility/2017-11-08/67223696dfc68c01f7a4f2dbb9d4b112.png","area":"2800","use_age":"18","addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":"1","longitude":"106.571399","latitude":"29.534442","status":"2","reason":"","last_small_service_at":"2017-11-24 20:50:51","last_mid_service_at":"2017-11-24 20:46:20","last_big_service_at":"","created_at":"2017-11-08 09:46:58","updated_at":"2017-11-28 16:31:02","deleted_at":"","extra_json":"","line":"成渝线","remark":"分局内全部堡坎","use_status":"3","ha_total":"","house_area":"","attached_area":"","structure":"混合（砖混）","floor":"","build_age":"19900315","roof_form":"","roof_area":"","use_nature":"4","category":"4","structures_unit":"座","structures_quantity":"3","structures_area":"150","section":{"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":""},"workshop":{"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":"3","created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":""},"work_area":{"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":"1","created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":""},"station":{"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":""}}
     * facility_service_report : {"id":"4a51504ffda8ebc3c489999a5d23b630","facility_id":"7b7211724bb68aa241360af705f267e0","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","type":"5","status":"1","signature_pic":"","reason":"","money":"3000.00","created_at":"2017-11-24 17:31:45","updated_at":"2017-11-24 17:31:45","deleted_at":"","facility_disease_list":[{"id":"856cff86f35d462741dc2d1c94dca6ed","facility_disease_repair_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"e6af12378fe83e4911e6b6f92421126a","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","facility_service_report_id":"4a51504ffda8ebc3c489999a5d23b630","facility_disease_valuation_id":"d4d34656eb8098188c151e8410069ef2","price":"120.00","amount_money":"3000.00","title":"vvnnn","degree":"3","area":"25","pic_list":"[\"\\/upload\\/facility-disease\\/2017-11-24\\/9b2792cb8e65c57159204513a6b6764b.png\"]","description":"hbcvhbbn","finalize":"1","created_at":"2017-11-24 17:31:13","updated_at":"2017-11-24 17:31:45","deleted_at":"","facility_disease_type":{"id":"e6af12378fe83e4911e6b6f92421126a","title":"潮湿返霜","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-30 14:51:21","deleted_at":""}}]}
     * facility_service_apply : {"id":"9d51b8dbce52e80476cf3c6414e4779d","facility_id":"7b7211724bb68aa241360af705f267e0","publish_disease_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","employee_role":"5","type":"3","disease_classify":"3","status":"4","facility_service_report_id":"4a51504ffda8ebc3c489999a5d23b630","batch_year":"2017","batch":"3","created_at":"2017-11-24 17:31:13","updated_at":"2017-11-30 16:44:34","deleted_at":"","facility_service_report_list":[{"id":"4a51504ffda8ebc3c489999a5d23b630","facility_id":"7b7211724bb68aa241360af705f267e0","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","type":"5","status":"1","signature_pic":"","reason":"","money":"3000.00","created_at":"2017-11-24 17:31:45","updated_at":"2017-11-24 17:31:45","deleted_at":"","employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":"1","head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":"5","role_description":"4","idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":""}}]}
     * facility_service_approval : {"id":"a203132b92e365f76b7d632a78f4f904","facility_id":"7b7211724bb68aa241360af705f267e0","facility_service_report_id":"4a51504ffda8ebc3c489999a5d23b630","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","evaluate":"3000.00","money":"3000.00","created_at":"2017-11-24 17:31:45","updated_at":"2017-11-24 17:31:45","deleted_at":"","employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":"1","head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":"5","role_description":"4","idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":""}}
     * facility_service_issue : {"id":"e9e844f2aac98d022f66684e9b0d1455","facility_id":"7b7211724bb68aa241360af705f267e0","facility_service_report_id":"4a51504ffda8ebc3c489999a5d23b630","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","facility_service_approval_id":"a203132b92e365f76b7d632a78f4f904","employee_id":"6ea4425bd3b4b7e11fd5cc4c3b649381","plan_number":"12345","cost_money":"588.00","renovate_content":"大概就是上课","created_at":"2017-11-24 20:40:35","updated_at":"2017-11-24 20:40:35","deleted_at":""}
     */

    private String id;
    private String facility_id;
    private String facility_service_report_id;
    private String facility_service_apply_id;
    private String facility_service_approval_id;
    private String facility_service_issue_id;
    private String employee_id;
    private String reply_number;
    private String reply_at;
    private String project_scope;
    private String supervisor_money;
    private String construction_money;
    private String design_money;
    private String amount_money;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String minor;
    private String minor_updated_at;
    private String mid;
    private String mid_updated_at;
    private String big;
    private String big_updated_at;
    private FacilityBean facility;
    private FacilityServiceReportBean facility_service_report;
    private FacilityServiceApplyBean facility_service_apply;
    private FacilityServiceApprovalBean facility_service_approval;
    private FacilityServiceIssueBean facility_service_issue;

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

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getReply_number() {
        return reply_number;
    }

    public void setReply_number(String reply_number) {
        this.reply_number = reply_number;
    }

    public String getReply_at() {
        return reply_at;
    }

    public void setReply_at(String reply_at) {
        this.reply_at = reply_at;
    }

    public String getProject_scope() {
        return project_scope;
    }

    public void setProject_scope(String project_scope) {
        this.project_scope = project_scope;
    }

    public String getSupervisor_money() {
        return supervisor_money;
    }

    public void setSupervisor_money(String supervisor_money) {
        this.supervisor_money = supervisor_money;
    }

    public String getConstruction_money() {
        return construction_money;
    }

    public void setConstruction_money(String construction_money) {
        this.construction_money = construction_money;
    }

    public String getDesign_money() {
        return design_money;
    }

    public void setDesign_money(String design_money) {
        this.design_money = design_money;
    }

    public String getAmount_money() {
        return amount_money;
    }

    public void setAmount_money(String amount_money) {
        this.amount_money = amount_money;
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

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getMinor_updated_at() {
        return minor_updated_at;
    }

    public void setMinor_updated_at(String minor_updated_at) {
        this.minor_updated_at = minor_updated_at;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMid_updated_at() {
        return mid_updated_at;
    }

    public void setMid_updated_at(String mid_updated_at) {
        this.mid_updated_at = mid_updated_at;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getBig_updated_at() {
        return big_updated_at;
    }

    public void setBig_updated_at(String big_updated_at) {
        this.big_updated_at = big_updated_at;
    }

    public FacilityBean getFacility() {
        return facility;
    }

    public void setFacility(FacilityBean facility) {
        this.facility = facility;
    }

    public FacilityServiceReportBean getFacility_service_report() {
        return facility_service_report;
    }

    public void setFacility_service_report(FacilityServiceReportBean facility_service_report) {
        this.facility_service_report = facility_service_report;
    }

    public FacilityServiceApplyBean getFacility_service_apply() {
        return facility_service_apply;
    }

    public void setFacility_service_apply(FacilityServiceApplyBean facility_service_apply) {
        this.facility_service_apply = facility_service_apply;
    }

    public FacilityServiceApprovalBean getFacility_service_approval() {
        return facility_service_approval;
    }

    public void setFacility_service_approval(FacilityServiceApprovalBean facility_service_approval) {
        this.facility_service_approval = facility_service_approval;
    }

    public FacilityServiceIssueBean getFacility_service_issue() {
        return facility_service_issue;
    }

    public void setFacility_service_issue(FacilityServiceIssueBean facility_service_issue) {
        this.facility_service_issue = facility_service_issue;
    }

    public static class FacilityBean {
        /**
         * id : 7b7211724bb68aa241360af705f267e0
         * employee_id : 06b10a7dc1fe2ab2df430060f869c2a8
         * user_id : 94dd2a7cecb2580f30807a98c218be94
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
         * work_area_id : 1a61baea57bcd21a520fac2749ba5e39
         * station_id : 1673e20e9d72c2ac8659e2182d69258d
         * company_id : 61ede8f70a0d041db205c1d67f86d2e7
         * type : 2
         * skill_type : 3
         * title : 设备10
         * number : xc0010
         * pic1 : /upload/facility/2017-11-08/27c192ce5409409ee5ddbf74359219da.png
         * pic2 : /upload/facility/2017-11-08/c049f5688ad52cc3647946f16d41100a.png
         * pic3 : /upload/facility/2017-11-08/67223696dfc68c01f7a4f2dbb9d4b112.png
         * area : 2800
         * use_age : 18
         * addr : 中国重庆市南岸区南坪区府美食街惠工路14号
         * annual : 1
         * longitude : 106.571399
         * latitude : 29.534442
         * status : 2
         * reason :
         * last_small_service_at : 2017-11-24 20:50:51
         * last_mid_service_at : 2017-11-24 20:46:20
         * last_big_service_at :
         * created_at : 2017-11-08 09:46:58
         * updated_at : 2017-11-28 16:31:02
         * deleted_at :
         * extra_json :
         * line : 成渝线
         * remark : 分局内全部堡坎
         * use_status : 3
         * ha_total :
         * house_area :
         * attached_area :
         * structure : 混合（砖混）
         * floor :
         * build_age : 19900315
         * roof_form :
         * roof_area :
         * use_nature : 4
         * category : 4
         * structures_unit : 座
         * structures_quantity : 3
         * structures_area : 150
         * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":""}
         * workshop : {"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":"3","created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":""}
         * work_area : {"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":"1","created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":""}
         * station : {"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":""}
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
        public CompanyBean getCompany() {
            return company;
        }

        public void setCompany(CompanyBean company) {
            this.company = company;
        }

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
             * id : f37326274f1fc4c8c208b8df5d1f2bb3
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * title : 内江车间
             * longitude : 105.505326
             * latitude : 29.769387
             * facility_count : 3
             * created_at : 2017-10-09 15:44:59
             * updated_at : 2017-11-28 16:31:02
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
             * id : 1a61baea57bcd21a520fac2749ba5e39
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
             * title : 自贡工区
             * longitude : 106.571399
             * latitude : 29.534442
             * facility_count : 1
             * created_at : 2017-11-24 14:48:43
             * updated_at : 2017-11-28 16:31:02
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
             * id : 1673e20e9d72c2ac8659e2182d69258d
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
             * work_area_id : 1a61baea57bcd21a520fac2749ba5e39
             * title : 王场
             * created_at : 2017-11-27 14:49:50
             * updated_at : 2017-11-27 14:49:50
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
             * id : 61ede8f70a0d041db205c1d67f86d2e7
             * title : 阿里巴巴
             * created_at : 2017-10-09 16:29:40
             * updated_at : 2017-11-02 14:49:44
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

    public static class FacilityServiceReportBean {
        /**
         * id : 4a51504ffda8ebc3c489999a5d23b630
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * type : 5
         * status : 1
         * signature_pic :
         * reason :
         * money : 3000.00
         * created_at : 2017-11-24 17:31:45
         * updated_at : 2017-11-24 17:31:45
         * deleted_at :
         * facility_disease_list : [{"id":"856cff86f35d462741dc2d1c94dca6ed","facility_disease_repair_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"e6af12378fe83e4911e6b6f92421126a","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","facility_service_report_id":"4a51504ffda8ebc3c489999a5d23b630","facility_disease_valuation_id":"d4d34656eb8098188c151e8410069ef2","price":"120.00","amount_money":"3000.00","title":"vvnnn","degree":"3","area":"25","pic_list":"[\"\\/upload\\/facility-disease\\/2017-11-24\\/9b2792cb8e65c57159204513a6b6764b.png\"]","description":"hbcvhbbn","finalize":"1","created_at":"2017-11-24 17:31:13","updated_at":"2017-11-24 17:31:45","deleted_at":"","facility_disease_type":{"id":"e6af12378fe83e4911e6b6f92421126a","title":"潮湿返霜","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-30 14:51:21","deleted_at":""}}]
         */

        private String id;
        private String facility_id;
        private String facility_service_apply_id;
        private String employee_id;
        private String type;
        private String status;
        private String signature_pic;
        private String reason;
        private String money;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private List<FacilityDiseaseListBean> facility_disease_list;

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

        public String getFacility_service_apply_id() {
            return facility_service_apply_id;
        }

        public void setFacility_service_apply_id(String facility_service_apply_id) {
            this.facility_service_apply_id = facility_service_apply_id;
        }

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSignature_pic() {
            return signature_pic;
        }

        public void setSignature_pic(String signature_pic) {
            this.signature_pic = signature_pic;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
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

        public List<FacilityDiseaseListBean> getFacility_disease_list() {
            return facility_disease_list;
        }

        public void setFacility_disease_list(List<FacilityDiseaseListBean> facility_disease_list) {
            this.facility_disease_list = facility_disease_list;
        }

        public static class FacilityDiseaseListBean {
            /**
             * id : 856cff86f35d462741dc2d1c94dca6ed
             * facility_disease_repair_id :
             * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
             * facility_id : 7b7211724bb68aa241360af705f267e0
             * facility_disease_type_id : e6af12378fe83e4911e6b6f92421126a
             * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
             * facility_service_report_id : 4a51504ffda8ebc3c489999a5d23b630
             * facility_disease_valuation_id : d4d34656eb8098188c151e8410069ef2
             * price : 120.00
             * amount_money : 3000.00
             * title : vvnnn
             * degree : 3
             * area : 25
             * pic_list : ["\/upload\/facility-disease\/2017-11-24\/9b2792cb8e65c57159204513a6b6764b.png"]
             * description : hbcvhbbn
             * finalize : 1
             * created_at : 2017-11-24 17:31:13
             * updated_at : 2017-11-24 17:31:45
             * deleted_at :
             * facility_disease_type : {"id":"e6af12378fe83e4911e6b6f92421126a","title":"潮湿返霜","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-30 14:51:21","deleted_at":""}
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
            private String degree;
            private String area;
            private String pic_list;
            private String description;
            private String finalize;
            private String created_at;
            private String updated_at;
            private String deleted_at;
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

            public String getDegree() {
                return degree;
            }

            public void setDegree(String degree) {
                this.degree = degree;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
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

            public String getFinalize() {
                return finalize;
            }

            public void setFinalize(String finalize) {
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public FacilityDiseaseTypeBean getFacility_disease_type() {
                return facility_disease_type;
            }

            public void setFacility_disease_type(FacilityDiseaseTypeBean facility_disease_type) {
                this.facility_disease_type = facility_disease_type;
            }

            public static class FacilityDiseaseTypeBean {
                /**
                 * id : e6af12378fe83e4911e6b6f92421126a
                 * title : 潮湿返霜
                 * created_at : 2017-11-22 11:29:58
                 * updated_at : 2017-11-30 14:51:21
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
    }

    public static class FacilityServiceApplyBean {
        /**
         * id : 9d51b8dbce52e80476cf3c6414e4779d
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * publish_disease_id :
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * employee_role : 5
         * type : 3
         * disease_classify : 3
         * status : 4
         * facility_service_report_id : 4a51504ffda8ebc3c489999a5d23b630
         * batch_year : 2017
         * batch : 3
         * created_at : 2017-11-24 17:31:13
         * updated_at : 2017-11-30 16:44:34
         * deleted_at :
         * facility_service_report_list : [{"id":"4a51504ffda8ebc3c489999a5d23b630","facility_id":"7b7211724bb68aa241360af705f267e0","facility_service_apply_id":"9d51b8dbce52e80476cf3c6414e4779d","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","type":"5","status":"1","signature_pic":"","reason":"","money":"3000.00","created_at":"2017-11-24 17:31:45","updated_at":"2017-11-24 17:31:45","deleted_at":"","employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":"1","head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":"5","role_description":"4","idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":""}}]
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
        private List<FacilityServiceReportListBean> facility_service_report_list;

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

        public List<FacilityServiceReportListBean> getFacility_service_report_list() {
            return facility_service_report_list;
        }

        public void setFacility_service_report_list(List<FacilityServiceReportListBean> facility_service_report_list) {
            this.facility_service_report_list = facility_service_report_list;
        }

        public static class FacilityServiceReportListBean {
            /**
             * id : 4a51504ffda8ebc3c489999a5d23b630
             * facility_id : 7b7211724bb68aa241360af705f267e0
             * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
             * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
             * type : 5
             * status : 1
             * signature_pic :
             * reason :
             * money : 3000.00
             * created_at : 2017-11-24 17:31:45
             * updated_at : 2017-11-24 17:31:45
             * deleted_at :
             * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":"1","head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":"5","role_description":"4","idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":""}
             */

            private String id;
            private String facility_id;
            private String facility_service_apply_id;
            private String employee_id;
            private String type;
            private String status;
            private String signature_pic;
            private String reason;
            private String money;
            private String created_at;
            private String updated_at;
            private String deleted_at;
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

            public String getFacility_service_apply_id() {
                return facility_service_apply_id;
            }

            public void setFacility_service_apply_id(String facility_service_apply_id) {
                this.facility_service_apply_id = facility_service_apply_id;
            }

            public String getEmployee_id() {
                return employee_id;
            }

            public void setEmployee_id(String employee_id) {
                this.employee_id = employee_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSignature_pic() {
                return signature_pic;
            }

            public void setSignature_pic(String signature_pic) {
                this.signature_pic = signature_pic;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
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

            public EmployeeBean getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBean employee) {
                this.employee = employee;
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
                 * deleted_at :
                 */

                private String id;
                private String mobile;
                private String active;
                private String head;
                private String duty;
                private String role;
                private String role_description;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private String deleted_at;

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

                public String getActive() {
                    return active;
                }

                public void setActive(String active) {
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

                public String getRole() {
                    return role;
                }

                public void setRole(String role) {
                    this.role = role;
                }

                public String getRole_description() {
                    return role_description;
                }

                public void setRole_description(String role_description) {
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

                public String getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(String deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }
    }

    public static class FacilityServiceApprovalBean {
        /**
         * id : a203132b92e365f76b7d632a78f4f904
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * facility_service_report_id : 4a51504ffda8ebc3c489999a5d23b630
         * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * evaluate : 3000.00
         * money : 3000.00
         * created_at : 2017-11-24 17:31:45
         * updated_at : 2017-11-24 17:31:45
         * deleted_at :
         * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":"1","head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":"5","role_description":"4","idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":""}
         */

        private String id;
        private String facility_id;
        private String facility_service_report_id;
        private String facility_service_apply_id;
        private String employee_id;
        private String evaluate;
        private String money;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private EmployeeBeanX employee;

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

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(String evaluate) {
            this.evaluate = evaluate;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
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

        public EmployeeBeanX getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBeanX employee) {
            this.employee = employee;
        }

        public static class EmployeeBeanX {
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
             * deleted_at :
             */

            private String id;
            private String mobile;
            private String active;
            private String head;
            private String duty;
            private String role;
            private String role_description;
            private String idcard;
            private String name;
            private String railway_id;
            private String section_id;
            private String workshop_id;
            private String work_area_id;
            private String ip;
            private String created_at;
            private String updated_at;
            private String deleted_at;

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

            public String getActive() {
                return active;
            }

            public void setActive(String active) {
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

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getRole_description() {
                return role_description;
            }

            public void setRole_description(String role_description) {
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }
        }
    }

    public static class FacilityServiceIssueBean {
        /**
         * id : e9e844f2aac98d022f66684e9b0d1455
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * facility_service_report_id : 4a51504ffda8ebc3c489999a5d23b630
         * facility_service_apply_id : 9d51b8dbce52e80476cf3c6414e4779d
         * facility_service_approval_id : a203132b92e365f76b7d632a78f4f904
         * employee_id : 6ea4425bd3b4b7e11fd5cc4c3b649381
         * plan_number : 12345
         * cost_money : 588.00
         * renovate_content : 大概就是上课
         * created_at : 2017-11-24 20:40:35
         * updated_at : 2017-11-24 20:40:35
         * deleted_at :
         */

        private String id;
        private String facility_id;
        private String facility_service_report_id;
        private String facility_service_apply_id;
        private String facility_service_approval_id;
        private String employee_id;
        private String plan_number;
        private String cost_money;
        private String renovate_content;
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

        public String getEmployee_id() {
            return employee_id;
        }

        public void setEmployee_id(String employee_id) {
            this.employee_id = employee_id;
        }

        public String getPlan_number() {
            return plan_number;
        }

        public void setPlan_number(String plan_number) {
            this.plan_number = plan_number;
        }

        public String getCost_money() {
            return cost_money;
        }

        public void setCost_money(String cost_money) {
            this.cost_money = cost_money;
        }

        public String getRenovate_content() {
            return renovate_content;
        }

        public void setRenovate_content(String renovate_content) {
            this.renovate_content = renovate_content;
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
