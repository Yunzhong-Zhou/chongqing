package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/7/13.
 * 请检修列表model
 */

public class PleaseOverhaulModel implements Serializable {

    /**
     * id : 7ee3c122912bb9ad51b3e30780395e8e
     * facility_id : d81d2c1df850c87ffeae3e33d63a6061
     * facility_service_apply_id : 254025f0a4c17254eedb2fa8fab4980e
     * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
     * start_at : 2017-11-24 00:00:00
     * end_at : 2017-11-25 00:00:00
     * manhour : {"day":"15","money":"55"}
     * mileage : {"length":"55","money":"5"}
     * material : [{"material_id":"c594af30492d00d170ce6b53a32f287f","qty":"15","money":"55"}]
     * amount : 115.00
     * secure_item : 复活甲
     * implement_content : 干活干活
     * scene_signature : /upload/sign/2017-11-24/8a9eba8df55e755597ecea14ac7a7259.png
     * section_signature : /upload/sign/2017-11-24/6603dfd2c8c93a808b3bf5c0ebcbc862.png
     * skill_signature : /upload/sign/2017-11-24/63ba5dc50d9a5d560679edc7cd7e9ccb.png
     * labour_signature : /upload/sign/2017-11-24/890e09671d67f90cebef19ad8a7eb4dc.png
     * client_mobile : 15455545655
     * client_signature : /upload/sign/2017-11-24/7164358f746d75cc6d12a4334f5e5e54.png
     * client_feedback : 头发
     * status : 3
     * created_at : 2017-11-24 15:54:08
     * updated_at : 2017-11-24 16:11:41
     * deleted_at : null
     * facility : {"id":"d81d2c1df850c87ffeae3e33d63a6061","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","work_area_id":"80d5019d489fc88ae1d01f9e27bf885b","station_id":"79125684af1ff8290788e2902f4162a6","company_id":"61ede8f70a0d041db205c1d67f86d2e7","type":2,"skill_type":3,"title":"设备14","number":"xc0014","pic1":"/upload/facility/2017-11-08/762394b81ec64a2a55a8eb9ece3d11c0.png","pic2":"/upload/facility/2017-11-08/65c70f1c16047f3b767e2ed3899af9ff.png","pic3":"/upload/facility/2017-11-08/de53b6d581c4773afeb2d2083019eb17.png","area":4800,"use_age":50,"addr":"中国重庆市南岸区南坪西路13号","annual":1,"longitude":"118.571514","latitude":"29.534529","status":2,"reason":"","last_small_service_at":"2017-11-24 16:11:41","last_mid_service_at":null,"last_big_service_at":null,"created_at":"2017-11-08 09:51:41","updated_at":"2017-11-24 16:11:41","deleted_at":null,"extra_json":null,"line":"","remark":"","use_status":1,"ha_total":"","house_area":"","attached_area":"","structure":"","floor":"","build_age":"","roof_form":"","roof_area":"","use_nature":4,"category":4,"structures_unit":"","structures_quantity":"","structures_area":"","section":{"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null},"workshop":{"id":"664e61b7fa80368e57fdd499f26a9392","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆北车间","longitude":"108.671422","latitude":"29.13445","facility_count":7,"created_at":"2017-10-18 18:43:45","updated_at":"2017-11-24 14:42:12","deleted_at":null},"work_area":{"id":"80d5019d489fc88ae1d01f9e27bf885b","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","title":"长寿北工区","longitude":"106.276386","latitude":"29.134357","facility_count":3,"created_at":"2017-10-23 10:39:15","updated_at":"2017-11-24 14:43:57","deleted_at":null},"station":{"id":"79125684af1ff8290788e2902f4162a6","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","work_area_id":"80d5019d489fc88ae1d01f9e27bf885b","title":"A站区","created_at":"2017-10-23 10:41:17","updated_at":"2017-10-26 09:33:29","deleted_at":null},"company":{"id":"61ede8f70a0d041db205c1d67f86d2e7","title":"阿里巴巴","created_at":"2017-10-09 16:29:40","updated_at":"2017-11-02 14:49:44","deleted_at":null}}
     * facility_service_apply : {"id":"254025f0a4c17254eedb2fa8fab4980e","facility_id":"d81d2c1df850c87ffeae3e33d63a6061","publish_disease_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","employee_role":5,"type":1,"disease_classify":1,"status":6,"facility_service_report_id":"7f4e83227823b1c56a4b7db1e5413c8a","batch_year":"2017","batch":3,"created_at":"2017-11-21 14:41:51","updated_at":"2017-11-24 16:11:41","deleted_at":null}
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
    private String client_signature;
    private String client_feedback;
    private int status;
    private String created_at;
    private String updated_at;
    private Object deleted_at;
    private FacilityBean facility;
    private FacilityServiceApplyBean facility_service_apply;
    private List<MaterialBean> material;

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

    public String getClient_signature() {
        return client_signature;
    }

    public void setClient_signature(String client_signature) {
        this.client_signature = client_signature;
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

    public static class ManhourBean {
        /**
         * day : 15
         * money : 55
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
         * length : 55
         * money : 5
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
         * id : d81d2c1df850c87ffeae3e33d63a6061
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * user_id : 94dd2a7cecb2580f30807a98c218be94
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : 664e61b7fa80368e57fdd499f26a9392
         * work_area_id : 80d5019d489fc88ae1d01f9e27bf885b
         * station_id : 79125684af1ff8290788e2902f4162a6
         * company_id : 61ede8f70a0d041db205c1d67f86d2e7
         * type : 2
         * skill_type : 3
         * title : 设备14
         * number : xc0014
         * pic1 : /upload/facility/2017-11-08/762394b81ec64a2a55a8eb9ece3d11c0.png
         * pic2 : /upload/facility/2017-11-08/65c70f1c16047f3b767e2ed3899af9ff.png
         * pic3 : /upload/facility/2017-11-08/de53b6d581c4773afeb2d2083019eb17.png
         * area : 4800
         * use_age : 50
         * addr : 中国重庆市南岸区南坪西路13号
         * annual : 1
         * longitude : 118.571514
         * latitude : 29.534529
         * status : 2
         * reason :
         * last_small_service_at : 2017-11-24 16:11:41
         * last_mid_service_at : null
         * last_big_service_at : null
         * created_at : 2017-11-08 09:51:41
         * updated_at : 2017-11-24 16:11:41
         * deleted_at : null
         * extra_json : null
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
         * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null}
         * workshop : {"id":"664e61b7fa80368e57fdd499f26a9392","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆北车间","longitude":"108.671422","latitude":"29.13445","facility_count":7,"created_at":"2017-10-18 18:43:45","updated_at":"2017-11-24 14:42:12","deleted_at":null}
         * work_area : {"id":"80d5019d489fc88ae1d01f9e27bf885b","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","title":"长寿北工区","longitude":"106.276386","latitude":"29.134357","facility_count":3,"created_at":"2017-10-23 10:39:15","updated_at":"2017-11-24 14:43:57","deleted_at":null}
         * station : {"id":"79125684af1ff8290788e2902f4162a6","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","work_area_id":"80d5019d489fc88ae1d01f9e27bf885b","title":"A站区","created_at":"2017-10-23 10:41:17","updated_at":"2017-10-26 09:33:29","deleted_at":null}
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
        private Object last_mid_service_at;
        private Object last_big_service_at;
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

        public Object getLast_mid_service_at() {
            return last_mid_service_at;
        }

        public void setLast_mid_service_at(Object last_mid_service_at) {
            this.last_mid_service_at = last_mid_service_at;
        }

        public Object getLast_big_service_at() {
            return last_big_service_at;
        }

        public void setLast_big_service_at(Object last_big_service_at) {
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
             * id : 664e61b7fa80368e57fdd499f26a9392
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * title : 重庆北车间
             * longitude : 108.671422
             * latitude : 29.13445
             * facility_count : 7
             * created_at : 2017-10-18 18:43:45
             * updated_at : 2017-11-24 14:42:12
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
             * id : 80d5019d489fc88ae1d01f9e27bf885b
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : 664e61b7fa80368e57fdd499f26a9392
             * title : 长寿北工区
             * longitude : 106.276386
             * latitude : 29.134357
             * facility_count : 3
             * created_at : 2017-10-23 10:39:15
             * updated_at : 2017-11-24 14:43:57
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
             * id : 79125684af1ff8290788e2902f4162a6
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : 664e61b7fa80368e57fdd499f26a9392
             * work_area_id : 80d5019d489fc88ae1d01f9e27bf885b
             * title : A站区
             * created_at : 2017-10-23 10:41:17
             * updated_at : 2017-10-26 09:33:29
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
         * id : 254025f0a4c17254eedb2fa8fab4980e
         * facility_id : d81d2c1df850c87ffeae3e33d63a6061
         * publish_disease_id :
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * employee_role : 5
         * type : 1
         * disease_classify : 1
         * status : 6
         * facility_service_report_id : 7f4e83227823b1c56a4b7db1e5413c8a
         * batch_year : 2017
         * batch : 3
         * created_at : 2017-11-21 14:41:51
         * updated_at : 2017-11-24 16:11:41
         * deleted_at : null
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
    }

    public static class MaterialBean {
        /**
         * material_id : c594af30492d00d170ce6b53a32f287f
         * qty : 15
         * money : 55
         */

        private String material_id;
        private String qty;
        private String money;

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
    }
}
