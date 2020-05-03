package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyz on 2017/8/11.
 */

public class MyReportDetailModel implements Serializable {

    /**
     * id : 899a81b5eee98f7762fbc2cde4bc82db
     * facility_id : a534f91b35822ccf9d98c88c16921f44
     * publish_disease_id :
     * employee_id : acdb6ef78389f6d67cafed76405cfbbc
     * employee_role : 1
     * type : 2
     * disease_classify : 2
     * status : 1
     * facility_service_report_id : 90266ca9b67ef7969123859c407390b4
     * batch_year :
     * batch : 1
     * created_at : 2017-12-01 15:48:49
     * updated_at : 2017-12-01 15:51:58
     * deleted_at :
     * audit : 2
     * publish_disease : {"id":"f3911263eab9a989b28f9e5b76287597","facility_id":"2f9804724a3f31539973a9631142429c","member_id":"a5cb386cf5ea01c3a86bad98462f86be","pic_list":"[\"\\/upload\\/facility-disease\\/2017-11-30\\/9bb390e41759f8f12eaa78580391a51a.jpg\",\"\\/upload\\/facility-disease\\/2017-11-30\\/6efa1e1737a84ffb6a359a1aa296a6f8.jpg\",\"\\/upload\\/facility-disease\\/2017-11-30\\/f08e399b850683d2fc9a930e785d3e9f.jpg\"]","description":"会员发布","status":"2","created_at":"2017-11-30 14:24:41","updated_at":"2017-11-30 14:25:41","deleted_at":""}
     * facility : {"id":"a534f91b35822ccf9d98c88c16921f44","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","station_id":"1719f13925393705732de9924521ac0d","company_id":"1209b48349480c3ab803c7ce99ba4d24","type":"2","skill_type":"2","title":"前台发布的设01","number":"xcxc001","pic1":"/upload/facility/2017-11-27/9fad9bd3ac5d452e889f75b6e591d21a.png","pic2":"/upload/facility/2017-11-27/121711e0a99c0dd79fd2ade249ccfc36.png","pic3":"/upload/facility/2017-11-27/4a8f78fa0d37db7e10281f658a1c37a7.png","area":"3800","use_age":"50","addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":"1","longitude":"106.571426","latitude":"29.534467","status":"2","reason":"","last_small_service_at":"","last_mid_service_at":"","last_big_service_at":"","created_at":"2017-11-27 16:36:34","updated_at":"2017-11-27 17:55:44","deleted_at":"","extra_json":"","line":"成渝线","remark":"无","use_status":"2","ha_total":"","house_area":"","attached_area":"","structure":"混凝土","floor":"","build_age":"19900820","roof_form":"","roof_area":"","use_nature":"2","category":"1","structures_unit":"腾讯","structures_quantity":"2","structures_area":"500"}
     * facility_service_report_list : [{"id":"ece768ffcf260acbf8c2f733c0f581ef","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","type":"2","status":"1","signature_pic":"/upload/sign/2017-12-01/9e69e2d974d26ba140f1c67a18f2cb8a.png","reason":"","money":"808.00","created_at":"2017-12-01 15:50:11","updated_at":"2017-12-01 15:50:11","deleted_at":"","facility_service_plan_list":[{"id":"311c8f539eb7625cb4aaa30c3959142b","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","start_at":"2017-12-07 00:00:00","end_at":"2017-12-11 00:00:00","description":"尽快修复","accessory":"","created_at":"2017-12-01 15:50:11","updated_at":"2017-12-01 15:50:11","deleted_at":""}],"employee":{"id":"06b10a7dc1fe2ab2df430060f869c2a8","mobile":"13000000002","active":"1","head":"","duty":"64","role":"2","role_description":"4","idcard":"","name":"工区长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:49:07","updated_at":"2017-10-09 15:49:07","deleted_at":""},"facility_disease_list":[{"id":"c13039b02badcd0fff6b420c5518b515","facility_disease_repair_id":"","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"6c8fc506dc51ea39e90a80dd815f3601","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","facility_disease_valuation_id":"aa360dc877eda8c3f387134d03cbeb37","price":"28.00","amount_money":"28.00","title":"病害2","degree":"3","area":"1","pic_list":"","description":"","finalize":"2","created_at":"2017-12-01 15:49:42","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"6c8fc506dc51ea39e90a80dd815f3601","title":"电照设备破损","created_at":"2017-11-30 14:51:53","updated_at":"2017-11-30 14:51:53","deleted_at":""}},{"id":"109fba8eb6498b4dec36b989152d3b7e","facility_disease_repair_id":"","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","facility_disease_valuation_id":"e7baed82e1df73ee59de143647a13ee0","price":"65.00","amount_money":"780.00","title":"病害1","degree":"4","area":"12","pic_list":"","description":"","finalize":"2","created_at":"2017-12-01 15:48:49","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"严重腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-11-30 14:50:51","deleted_at":""}}]},{"id":"90266ca9b67ef7969123859c407390b4","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","employee_id":"058cdb2c4ce5ed68f797c23c90cf02d0","type":"3","status":"1","signature_pic":"/upload/sign/2017-12-01/60215f7ddae34681f3c4137d52652b90.png","reason":"","money":"900.00","created_at":"2017-12-01 15:51:58","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_service_plan_list":null,"employee":{"id":"058cdb2c4ce5ed68f797c23c90cf02d0","mobile":"13000000003","active":"1","head":"","duty":"64","role":"3","role_description":"4","idcard":"","name":"车间主任","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"","ip":"","created_at":"2017-10-09 15:50:24","updated_at":"2017-10-09 15:50:24","deleted_at":""},"facility_disease_list":[{"id":"2ca6e9efcbffb6c98115e37a07614584","facility_disease_repair_id":"","employee_id":"058cdb2c4ce5ed68f797c23c90cf02d0","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"4d16be2ab203d41c9d0c6e702c6e683a","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"90266ca9b67ef7969123859c407390b4","facility_disease_valuation_id":"ce47d8031b66ab8f8c71f0f09bcbab8e","price":"61.00","amount_money":"61.00","title":"病害3","degree":"5","area":"1","pic_list":"[\"\\/upload\\/facility-disease\\/2017-12-01\\/ca988931e64eb85ca923648b02882c39.jpg\"]","description":"","finalize":"1","created_at":"2017-12-01 15:51:40","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"4d16be2ab203d41c9d0c6e702c6e683a","title":"倒塌危险","created_at":"2017-08-08 18:11:00","updated_at":"2017-11-30 14:49:00","deleted_at":""}},{"id":"7711eae6c4fa48b2e391fb5f32bd034f","facility_disease_repair_id":"","employee_id":"058cdb2c4ce5ed68f797c23c90cf02d0","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"6c8fc506dc51ea39e90a80dd815f3601","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"90266ca9b67ef7969123859c407390b4","facility_disease_valuation_id":"aa360dc877eda8c3f387134d03cbeb37","price":"28.00","amount_money":"28.00","title":"病害2","degree":"3","area":"1","pic_list":"","description":"","finalize":"1","created_at":"2017-12-01 15:49:42","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"6c8fc506dc51ea39e90a80dd815f3601","title":"电照设备破损","created_at":"2017-11-30 14:51:53","updated_at":"2017-11-30 14:51:53","deleted_at":""}},{"id":"06cc0161053139eb9a1c6c93567ad5ad","facility_disease_repair_id":"","employee_id":"058cdb2c4ce5ed68f797c23c90cf02d0","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"90266ca9b67ef7969123859c407390b4","facility_disease_valuation_id":"e7baed82e1df73ee59de143647a13ee0","price":"65.00","amount_money":"780.00","title":"病害1","degree":"4","area":"12","pic_list":"","description":"","finalize":"1","created_at":"2017-12-01 15:48:49","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"严重腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-11-30 14:50:51","deleted_at":""}}]}]
     * facility_service_implement_id :
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
    private String audit;
    private PublishDiseaseBean publish_disease;
    private FacilityBean facility;
    private String facility_service_implement_id;
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

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public PublishDiseaseBean getPublish_disease() {
        return publish_disease;
    }

    public void setPublish_disease(PublishDiseaseBean publish_disease) {
        this.publish_disease = publish_disease;
    }

    public FacilityBean getFacility() {
        return facility;
    }

    public void setFacility(FacilityBean facility) {
        this.facility = facility;
    }

    public String getFacility_service_implement_id() {
        return facility_service_implement_id;
    }

    public void setFacility_service_implement_id(String facility_service_implement_id) {
        this.facility_service_implement_id = facility_service_implement_id;
    }

    public List<FacilityServiceReportListBean> getFacility_service_report_list() {
        return facility_service_report_list;
    }

    public void setFacility_service_report_list(List<FacilityServiceReportListBean> facility_service_report_list) {
        this.facility_service_report_list = facility_service_report_list;
    }

    public static class PublishDiseaseBean {
        /**
         * id : f3911263eab9a989b28f9e5b76287597
         * facility_id : 2f9804724a3f31539973a9631142429c
         * member_id : a5cb386cf5ea01c3a86bad98462f86be
         * pic_list : ["\/upload\/facility-disease\/2017-11-30\/9bb390e41759f8f12eaa78580391a51a.jpg","\/upload\/facility-disease\/2017-11-30\/6efa1e1737a84ffb6a359a1aa296a6f8.jpg","\/upload\/facility-disease\/2017-11-30\/f08e399b850683d2fc9a930e785d3e9f.jpg"]
         * description : 会员发布
         * status : 2
         * created_at : 2017-11-30 14:24:41
         * updated_at : 2017-11-30 14:25:41
         * deleted_at :
         */

        private String id;
        private String facility_id;
        private String member_id;
        private String pic_list;
        private String description;
        private String status;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
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

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }
    }

    public static class FacilityBean {
        /**
         * id : a534f91b35822ccf9d98c88c16921f44
         * employee_id : acdb6ef78389f6d67cafed76405cfbbc
         * user_id : 94dd2a7cecb2580f30807a98c218be94
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : 664e61b7fa80368e57fdd499f26a9392
         * work_area_id : ae445ad9baa0886e952c48ec32e134d8
         * station_id : 1719f13925393705732de9924521ac0d
         * company_id : 1209b48349480c3ab803c7ce99ba4d24
         * type : 2
         * skill_type : 2
         * title : 前台发布的设01
         * number : xcxc001
         * pic1 : /upload/facility/2017-11-27/9fad9bd3ac5d452e889f75b6e591d21a.png
         * pic2 : /upload/facility/2017-11-27/121711e0a99c0dd79fd2ade249ccfc36.png
         * pic3 : /upload/facility/2017-11-27/4a8f78fa0d37db7e10281f658a1c37a7.png
         * area : 3800
         * use_age : 50
         * addr : 中国重庆市南岸区南坪区府美食街惠工路14号
         * annual : 1
         * longitude : 106.571426
         * latitude : 29.534467
         * status : 2
         * reason :
         * last_small_service_at :
         * last_mid_service_at :
         * last_big_service_at :
         * created_at : 2017-11-27 16:36:34
         * updated_at : 2017-11-27 17:55:44
         * deleted_at :
         * extra_json :
         * line : 成渝线
         * remark : 无
         * use_status : 2
         * ha_total :
         * house_area :
         * attached_area :
         * structure : 混凝土
         * floor :
         * build_age : 19900820
         * roof_form :
         * roof_area :
         * use_nature : 2
         * category : 1
         * structures_unit : 腾讯
         * structures_quantity : 2
         * structures_area : 500
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
    }

    public static class FacilityServiceReportListBean implements Serializable {
        /**
         * id : ece768ffcf260acbf8c2f733c0f581ef
         * facility_id : a534f91b35822ccf9d98c88c16921f44
         * facility_service_apply_id : 899a81b5eee98f7762fbc2cde4bc82db
         * employee_id : 06b10a7dc1fe2ab2df430060f869c2a8
         * type : 2
         * status : 1
         * signature_pic : /upload/sign/2017-12-01/9e69e2d974d26ba140f1c67a18f2cb8a.png
         * reason :
         * money : 808.00
         * created_at : 2017-12-01 15:50:11
         * updated_at : 2017-12-01 15:50:11
         * deleted_at :
         * facility_service_plan_list : [{"id":"311c8f539eb7625cb4aaa30c3959142b","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","start_at":"2017-12-07 00:00:00","end_at":"2017-12-11 00:00:00","description":"尽快修复","accessory":"","created_at":"2017-12-01 15:50:11","updated_at":"2017-12-01 15:50:11","deleted_at":""}]
         * employee : {"id":"06b10a7dc1fe2ab2df430060f869c2a8","mobile":"13000000002","active":"1","head":"","duty":"64","role":"2","role_description":"4","idcard":"","name":"工区长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:49:07","updated_at":"2017-10-09 15:49:07","deleted_at":""}
         * facility_disease_list : [{"id":"c13039b02badcd0fff6b420c5518b515","facility_disease_repair_id":"","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"6c8fc506dc51ea39e90a80dd815f3601","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","facility_disease_valuation_id":"aa360dc877eda8c3f387134d03cbeb37","price":"28.00","amount_money":"28.00","title":"病害2","degree":"3","area":"1","pic_list":"","description":"","finalize":"2","created_at":"2017-12-01 15:49:42","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"6c8fc506dc51ea39e90a80dd815f3601","title":"电照设备破损","created_at":"2017-11-30 14:51:53","updated_at":"2017-11-30 14:51:53","deleted_at":""}},{"id":"109fba8eb6498b4dec36b989152d3b7e","facility_disease_repair_id":"","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","facility_id":"a534f91b35822ccf9d98c88c16921f44","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"899a81b5eee98f7762fbc2cde4bc82db","facility_service_report_id":"ece768ffcf260acbf8c2f733c0f581ef","facility_disease_valuation_id":"e7baed82e1df73ee59de143647a13ee0","price":"65.00","amount_money":"780.00","title":"病害1","degree":"4","area":"12","pic_list":"","description":"","finalize":"2","created_at":"2017-12-01 15:48:49","updated_at":"2017-12-01 15:51:58","deleted_at":"","facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"严重腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-11-30 14:50:51","deleted_at":""}}]
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
        private List<FacilityServicePlanListBean> facility_service_plan_list;
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

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public List<FacilityServicePlanListBean> getFacility_service_plan_list() {
            return facility_service_plan_list;
        }

        public void setFacility_service_plan_list(List<FacilityServicePlanListBean> facility_service_plan_list) {
            this.facility_service_plan_list = facility_service_plan_list;
        }

        public List<FacilityDiseaseListBean> getFacility_disease_list() {
            return facility_disease_list;
        }

        public void setFacility_disease_list(List<FacilityDiseaseListBean> facility_disease_list) {
            this.facility_disease_list = facility_disease_list;
        }

        public static class EmployeeBean {
            /**
             * id : 06b10a7dc1fe2ab2df430060f869c2a8
             * mobile : 13000000002
             * active : 1
             * head :
             * duty : 64
             * role : 2
             * role_description : 4
             * idcard :
             * name : 工区长
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
             * work_area_id : ae445ad9baa0886e952c48ec32e134d8
             * ip :
             * created_at : 2017-10-09 15:49:07
             * updated_at : 2017-10-09 15:49:07
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

        public static class FacilityServicePlanListBean implements Serializable {
            /**
             * id : 311c8f539eb7625cb4aaa30c3959142b
             * facility_service_report_id : ece768ffcf260acbf8c2f733c0f581ef
             * start_at : 2017-12-07 00:00:00
             * end_at : 2017-12-11 00:00:00
             * description : 尽快修复
             * accessory :
             * created_at : 2017-12-01 15:50:11
             * updated_at : 2017-12-01 15:50:11
             * deleted_at :
             */

            private String id;
            private String facility_service_report_id;
            private String start_at;
            private String end_at;
            private String description;
            private String accessory;
            private String created_at;
            private String updated_at;
            private String deleted_at;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAccessory() {
                return accessory;
            }

            public void setAccessory(String accessory) {
                this.accessory = accessory;
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

            @Override
            public String toString() {
                return "FacilityServicePlanListBean{" +
                        "id='" + id + '\'' +
                        ", facility_service_report_id='" + facility_service_report_id + '\'' +
                        ", start_at='" + start_at + '\'' +
                        ", end_at='" + end_at + '\'' +
                        ", description='" + description + '\'' +
                        ", accessory='" + accessory + '\'' +
                        ", created_at='" + created_at + '\'' +
                        ", updated_at='" + updated_at + '\'' +
                        ", deleted_at='" + deleted_at + '\'' +
                        '}';
            }
        }

        public static class FacilityDiseaseListBean {
            /**
             * id : c13039b02badcd0fff6b420c5518b515
             * facility_disease_repair_id :
             * employee_id : 06b10a7dc1fe2ab2df430060f869c2a8
             * facility_id : a534f91b35822ccf9d98c88c16921f44
             * facility_disease_type_id : 6c8fc506dc51ea39e90a80dd815f3601
             * facility_service_apply_id : 899a81b5eee98f7762fbc2cde4bc82db
             * facility_service_report_id : ece768ffcf260acbf8c2f733c0f581ef
             * facility_disease_valuation_id : aa360dc877eda8c3f387134d03cbeb37
             * price : 28.00
             * amount_money : 28.00
             * title : 病害2
             * degree : 3
             * area : 1
             * pic_list :
             * description :
             * finalize : 2
             * created_at : 2017-12-01 15:49:42
             * updated_at : 2017-12-01 15:51:58
             * deleted_at :
             * facility_disease_type : {"id":"6c8fc506dc51ea39e90a80dd815f3601","title":"电照设备破损","created_at":"2017-11-30 14:51:53","updated_at":"2017-11-30 14:51:53","deleted_at":""}
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
                 * id : 6c8fc506dc51ea39e90a80dd815f3601
                 * title : 电照设备破损
                 * created_at : 2017-11-30 14:51:53
                 * updated_at : 2017-11-30 14:51:53
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
}
