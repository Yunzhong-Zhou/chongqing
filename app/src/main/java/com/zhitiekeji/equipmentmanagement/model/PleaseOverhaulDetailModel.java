package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zyz on 2017/8/24.
 */

public class PleaseOverhaulDetailModel implements Serializable {
    /**
     * id : 3f6933921354e77ec83fd993c02b065c
     * facility_id : 7b7211724bb68aa241360af705f267e0
     * facility_service_apply_id : cddfec4eef88049ee50c7a9f43eeed71
     * employee_id : acdb6ef78389f6d67cafed76405cfbbc
     * start_at : 2017-11-24 00:00:00
     * end_at : 2017-11-30 00:00:00
     * manhour : {"day":"1","money":"100"}
     * mileage : {"length":"2","money":"200"}
     * material : [{"material_id":"34ca7f40bf5e47de8556254f11bb5020","qty":"3","money":"300","material_title":"材料C-01"},{"material_id":"e1fc95716621a3b73515752a6090d529","qty":"4","money":"400","material_title":"材料B-01"}]
     * amount : 1000.00
     * secure_item : 大概不能
     * implement_content : 啊是是是
     * scene_signature :
     * section_signature :
     * skill_signature :
     * labour_signature :
     * client_mobile : 1576878859
     * client_signature :
     * client_feedback : 大红包v姐姐还不能
     * status : 2
     * created_at : 2017-11-24 20:10:51
     * updated_at : 2017-11-24 20:11:48
     * deleted_at : null
     * minor : 请检修-待签字
     * minor_updated_at : 2017-11-24
     * mid : 综合维修-竣工
     * mid_updated_at : 2017-11-24
     * big : 大修-竣工
     * big_updated_at : 2017-11-30
     * facility : {"id":"7b7211724bb68aa241360af705f267e0","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","station_id":"1673e20e9d72c2ac8659e2182d69258d","company_id":"61ede8f70a0d041db205c1d67f86d2e7","type":2,"skill_type":3,"title":"设备10","number":"xc0010","pic1":"/upload/facility/2017-11-08/27c192ce5409409ee5ddbf74359219da.png","pic2":"/upload/facility/2017-11-08/c049f5688ad52cc3647946f16d41100a.png","pic3":"/upload/facility/2017-11-08/67223696dfc68c01f7a4f2dbb9d4b112.png","area":2800,"use_age":18,"addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":1,"longitude":"106.571399","latitude":"29.534442","status":2,"reason":"","last_small_service_at":"2017-11-24 20:50:51","last_mid_service_at":"2017-11-24 20:46:20","last_big_service_at":"2017-11-30 16:49:38","created_at":"2017-11-08 09:46:58","updated_at":"2017-11-30 16:49:38","deleted_at":null,"extra_json":null,"line":"成渝线","remark":"分局内全部堡坎","use_status":3,"ha_total":"","house_area":"","attached_area":"","structure":"混合（砖混）","floor":"","build_age":"19900315","roof_form":"","roof_area":"","use_nature":4,"category":4,"structures_unit":"座","structures_quantity":"3","structures_area":"150","section":{"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null},"workshop":{"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":3,"created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":null},"work_area":{"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":1,"created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":null},"station":{"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":null},"company":{"id":"61ede8f70a0d041db205c1d67f86d2e7","title":"阿里巴巴","created_at":"2017-10-09 16:29:40","updated_at":"2017-11-02 14:49:44","deleted_at":null}}
     * facility_service_apply : {"id":"cddfec4eef88049ee50c7a9f43eeed71","facility_id":"7b7211724bb68aa241360af705f267e0","publish_disease_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","employee_role":1,"type":1,"disease_classify":1,"status":6,"facility_service_report_id":"","batch_year":"","batch":1,"created_at":"2017-11-24 20:10:16","updated_at":"2017-11-24 20:11:48","deleted_at":null,"facility_disease_list":[{"id":"78096f4e2a4b496a380921a515abc271","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"fff14b2b1b25176d2f118f68f49273d1","facility_service_apply_id":"cddfec4eef88049ee50c7a9f43eeed71","facility_service_report_id":"","facility_disease_valuation_id":"65f72a6608dac2844cd64455f37bae4c","price":"5.00","amount_money":"100.00","title":"不紧急","degree":1,"area":20,"pic_list":null,"description":"","finalize":1,"created_at":"2017-11-24 20:10:41","updated_at":"2017-11-24 20:10:41","deleted_at":null,"facility_disease_type":{"id":"fff14b2b1b25176d2f118f68f49273d1","title":"冻害、蚁害","created_at":"2017-08-23 16:14:22","updated_at":"2017-11-30 14:51:07","deleted_at":null}},{"id":"b33a902e37fecd46a8b25e3735b28633","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"e6af12378fe83e4911e6b6f92421126a","facility_service_apply_id":"cddfec4eef88049ee50c7a9f43eeed71","facility_service_report_id":"","facility_disease_valuation_id":"ef7d6a6f752d67dd4e11ef2daf4aa474","price":"50.00","amount_money":"500.00","title":"紧急","degree":1,"area":10,"pic_list":null,"description":"","finalize":1,"created_at":"2017-11-24 20:10:16","updated_at":"2017-11-24 20:10:16","deleted_at":null,"facility_disease_type":{"id":"e6af12378fe83e4911e6b6f92421126a","title":"潮湿返霜","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-30 14:51:21","deleted_at":null}}]}
     * facility_service_minor_material_list : [{"id":"d9b6f269fcd0d13b658100f91e53b8c0","facility_service_minor_id":"3f6933921354e77ec83fd993c02b065c","material_id":"e1fc95716621a3b73515752a6090d529","material_title":"材料B-01","qty":4,"money":"400.00","created_at":"2017-11-24 20:11:48","updated_at":"2017-11-24 20:11:48","deleted_at":null},{"id":"e394c6216a2ab780cefe1ef5deddec55","facility_service_minor_id":"3f6933921354e77ec83fd993c02b065c","material_id":"34ca7f40bf5e47de8556254f11bb5020","material_title":"材料C-01","qty":3,"money":"300.00","created_at":"2017-11-24 20:11:48","updated_at":"2017-11-24 20:11:48","deleted_at":null}]
     */

    private String id;
    private String facility_id;
    private String facility_service_apply_id;
    private String employee_id;
    private String start_at;
    private String end_at;
    private ManhourBean manhour;
    private MileageBean mileage;
    private String amount;
    private String secure_item;
    private String implement_content;
    private String scene_signature;
    private String section_signature;
    private String skill_signature;
    private String labour_signature;
    private String client_mobile;
    private String client_name;
    private String employee_signature;
    private String visit_time;
    private String visit_name;
    private String client_feedback;
    private int status;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private String minor;
    private String minor_updated_at;
    private String mid;
    private String mid_updated_at;
    private String big;
    private String big_updated_at;
    private FacilityBean facility;
    private FacilityServiceApplyBean facility_service_apply;
    private List<MaterialBean> material;
    private List<FacilityServiceMinorMaterialListBean> facility_service_minor_material_list;

    public String getVisit_name() {
        return visit_name;
    }

    public void setVisit_name(String visit_name) {
        this.visit_name = visit_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getEmployee_signature() {
        return employee_signature;
    }

    public void setEmployee_signature(String employee_signature) {
        this.employee_signature = employee_signature;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

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

    public ManhourBean getManhour() {
        return manhour;
    }

    public void setManhour(ManhourBean manhour) {
        this.manhour = manhour;
    }

    public MileageBean getMileage() {
        return mileage;
    }

    public void setMileage(MileageBean mileage) {
        this.mileage = mileage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSecure_item() {
        return secure_item;
    }

    public void setSecure_item(String secure_item) {
        this.secure_item = secure_item;
    }

    public String getImplement_content() {
        return implement_content;
    }

    public void setImplement_content(String implement_content) {
        this.implement_content = implement_content;
    }

    public String getScene_signature() {
        return scene_signature;
    }

    public void setScene_signature(String scene_signature) {
        this.scene_signature = scene_signature;
    }

    public String getSection_signature() {
        return section_signature;
    }

    public void setSection_signature(String section_signature) {
        this.section_signature = section_signature;
    }

    public String getSkill_signature() {
        return skill_signature;
    }

    public void setSkill_signature(String skill_signature) {
        this.skill_signature = skill_signature;
    }

    public String getLabour_signature() {
        return labour_signature;
    }

    public void setLabour_signature(String labour_signature) {
        this.labour_signature = labour_signature;
    }

    public String getClient_mobile() {
        return client_mobile;
    }

    public void setClient_mobile(String client_mobile) {
        this.client_mobile = client_mobile;
    }

    public String getClient_feedback() {
        return client_feedback;
    }

    public void setClient_feedback(String client_feedback) {
        this.client_feedback = client_feedback;
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

    public FacilityServiceApplyBean getFacility_service_apply() {
        return facility_service_apply;
    }

    public void setFacility_service_apply(FacilityServiceApplyBean facility_service_apply) {
        this.facility_service_apply = facility_service_apply;
    }

    public List<MaterialBean> getMaterial() {
        return material;
    }

    public void setMaterial(List<MaterialBean> material) {
        this.material = material;
    }

    public List<FacilityServiceMinorMaterialListBean> getFacility_service_minor_material_list() {
        return facility_service_minor_material_list;
    }

    public void setFacility_service_minor_material_list(List<FacilityServiceMinorMaterialListBean> facility_service_minor_material_list) {
        this.facility_service_minor_material_list = facility_service_minor_material_list;
    }

    public static class ManhourBean {
        /**
         * day : 1
         * money : 100
         */

        private String day;
        private String money;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }

    public static class MileageBean {
        /**
         * length : 2
         * money : 200
         */

        private String length;
        private String money;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
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
         * last_big_service_at : 2017-11-30 16:49:38
         * created_at : 2017-11-08 09:46:58
         * updated_at : 2017-11-30 16:49:38
         * deleted_at : null
         * extra_json : null
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
         * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null}
         * workshop : {"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":3,"created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":null}
         * work_area : {"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":1,"created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":null}
         * station : {"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":null}
         * company : {"id":"61ede8f70a0d041db205c1d67f86d2e7","title":"阿里巴巴","created_at":"2017-10-09 16:29:40","updated_at":"2017-11-02 14:49:44","deleted_at":null}
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
        private int type;
        private int skill_type;
        private String title;
        private String number;
        private String pic1;
        private String pic2;
        private String pic3;
        private int area;
        private int use_age;
        private String addr;
        private int annual;
        private String longitude;
        private String latitude;
        private int status;
        private String reason;
        private String last_small_service_at;
        private String last_mid_service_at;
        private String last_big_service_at;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private Object extra_json;
        private String line;
        private String remark;
        private int use_status;
        private String ha_total;
        private String house_area;
        private String attached_area;
        private String structure;
        private String floor;
        private String build_age;
        private String roof_form;
        private String roof_area;
        private int use_nature;
        private int category;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSkill_type() {
            return skill_type;
        }

        public void setSkill_type(int skill_type) {
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

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getUse_age() {
            return use_age;
        }

        public void setUse_age(int use_age) {
            this.use_age = use_age;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getAnnual() {
            return annual;
        }

        public void setAnnual(int annual) {
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
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

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public Object getExtra_json() {
            return extra_json;
        }

        public void setExtra_json(Object extra_json) {
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

        public int getUse_status() {
            return use_status;
        }

        public void setUse_status(int use_status) {
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

        public int getUse_nature() {
            return use_nature;
        }

        public void setUse_nature(int use_nature) {
            this.use_nature = use_nature;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
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
             * deleted_at : null
             */

            private String id;
            private String railway_id;
            private String title;
            private String longitude;
            private String latitude;
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
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

    public static class FacilityServiceApplyBean {
        /**
         * id : cddfec4eef88049ee50c7a9f43eeed71
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * publish_disease_id :
         * employee_id : acdb6ef78389f6d67cafed76405cfbbc
         * employee_role : 1
         * type : 1
         * disease_classify : 1
         * status : 6
         * facility_service_report_id :
         * batch_year :
         * batch : 1
         * created_at : 2017-11-24 20:10:16
         * updated_at : 2017-11-24 20:11:48
         * deleted_at : null
         * facility_disease_list : [{"id":"78096f4e2a4b496a380921a515abc271","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"fff14b2b1b25176d2f118f68f49273d1","facility_service_apply_id":"cddfec4eef88049ee50c7a9f43eeed71","facility_service_report_id":"","facility_disease_valuation_id":"65f72a6608dac2844cd64455f37bae4c","price":"5.00","amount_money":"100.00","title":"不紧急","degree":1,"area":20,"pic_list":null,"description":"","finalize":1,"created_at":"2017-11-24 20:10:41","updated_at":"2017-11-24 20:10:41","deleted_at":null,"facility_disease_type":{"id":"fff14b2b1b25176d2f118f68f49273d1","title":"冻害、蚁害","created_at":"2017-08-23 16:14:22","updated_at":"2017-11-30 14:51:07","deleted_at":null}},{"id":"b33a902e37fecd46a8b25e3735b28633","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"e6af12378fe83e4911e6b6f92421126a","facility_service_apply_id":"cddfec4eef88049ee50c7a9f43eeed71","facility_service_report_id":"","facility_disease_valuation_id":"ef7d6a6f752d67dd4e11ef2daf4aa474","price":"50.00","amount_money":"500.00","title":"紧急","degree":1,"area":10,"pic_list":null,"description":"","finalize":1,"created_at":"2017-11-24 20:10:16","updated_at":"2017-11-24 20:10:16","deleted_at":null,"facility_disease_type":{"id":"e6af12378fe83e4911e6b6f92421126a","title":"潮湿返霜","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-30 14:51:21","deleted_at":null}}]
         */

        private String id;
        private String facility_id;
        private String publish_disease_id;
        private String employee_id;
        private int employee_role;
        private int type;
        private int disease_classify;
        private int status;
        private String facility_service_report_id;
        private String batch_year;
        private int batch;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
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

        public int getEmployee_role() {
            return employee_role;
        }

        public void setEmployee_role(int employee_role) {
            this.employee_role = employee_role;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getDisease_classify() {
            return disease_classify;
        }

        public void setDisease_classify(int disease_classify) {
            this.disease_classify = disease_classify;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
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

        public int getBatch() {
            return batch;
        }

        public void setBatch(int batch) {
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

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
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
             * id : 78096f4e2a4b496a380921a515abc271
             * facility_disease_repair_id :
             * employee_id : acdb6ef78389f6d67cafed76405cfbbc
             * facility_id : 7b7211724bb68aa241360af705f267e0
             * facility_disease_type_id : fff14b2b1b25176d2f118f68f49273d1
             * facility_service_apply_id : cddfec4eef88049ee50c7a9f43eeed71
             * facility_service_report_id :
             * facility_disease_valuation_id : 65f72a6608dac2844cd64455f37bae4c
             * price : 5.00
             * amount_money : 100.00
             * title : 不紧急
             * degree : 1
             * area : 20
             * pic_list : null
             * description :
             * finalize : 1
             * created_at : 2017-11-24 20:10:41
             * updated_at : 2017-11-24 20:10:41
             * deleted_at : null
             * facility_disease_type : {"id":"fff14b2b1b25176d2f118f68f49273d1","title":"冻害、蚁害","created_at":"2017-08-23 16:14:22","updated_at":"2017-11-30 14:51:07","deleted_at":null}
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
            private Object pic_list;
            private String description;
            private int finalize;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
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

            public Object getPic_list() {
                return pic_list;
            }

            public void setPic_list(Object pic_list) {
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

            public FacilityDiseaseTypeBean getFacility_disease_type() {
                return facility_disease_type;
            }

            public void setFacility_disease_type(FacilityDiseaseTypeBean facility_disease_type) {
                this.facility_disease_type = facility_disease_type;
            }

            public static class FacilityDiseaseTypeBean {
                /**
                 * id : fff14b2b1b25176d2f118f68f49273d1
                 * title : 冻害、蚁害
                 * created_at : 2017-08-23 16:14:22
                 * updated_at : 2017-11-30 14:51:07
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
    }

    public static class MaterialBean {
        /**
         * material_id : 34ca7f40bf5e47de8556254f11bb5020
         * qty : 3
         * money : 300
         * material_title : 材料C-01
         */

        private String material_id;
        private String qty;
        private String money;
        private String material_title;

        public String getMaterial_id() {
            return material_id;
        }

        public void setMaterial_id(String material_id) {
            this.material_id = material_id;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getMaterial_title() {
            return material_title;
        }

        public void setMaterial_title(String material_title) {
            this.material_title = material_title;
        }
    }

    public static class FacilityServiceMinorMaterialListBean {
        /**
         * id : d9b6f269fcd0d13b658100f91e53b8c0
         * facility_service_minor_id : 3f6933921354e77ec83fd993c02b065c
         * material_id : e1fc95716621a3b73515752a6090d529
         * material_title : 材料B-01
         * qty : 4
         * money : 400.00
         * created_at : 2017-11-24 20:11:48
         * updated_at : 2017-11-24 20:11:48
         * deleted_at : null
         */

        private String id;
        private String facility_service_minor_id;
        private String material_id;
        private String material_title;
        private int qty;
        private String money;
        private String created_at;
        private String updated_at;
        private Object deleted_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFacility_service_minor_id() {
            return facility_service_minor_id;
        }

        public void setFacility_service_minor_id(String facility_service_minor_id) {
            this.facility_service_minor_id = facility_service_minor_id;
        }

        public String getMaterial_id() {
            return material_id;
        }

        public void setMaterial_id(String material_id) {
            this.material_id = material_id;
        }

        public String getMaterial_title() {
            return material_title;
        }

        public void setMaterial_title(String material_title) {
            this.material_title = material_title;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
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

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }
    }

}
