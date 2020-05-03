package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class EquipmentDetailModel1 implements Serializable {
    /**
     * id : 5dedc6d12866883fae31c672da8302c6
     * employee_id : 4399cb6e15ff03fedfd6794897e14081
     * user_id : 94dd2a7cecb2580f30807a98c218be94
     * railway_id : 23cd931f4e6d162e10fe435e2a06933d
     * section_id : a982d549217f04c3c063e247fb262cd7
     * workshop_id : 664e61b7fa80368e57fdd499f26a9392
     * work_area_id : cc7e95acd10a09e4fcb46eefc1d4d2c4
     * station_id : 7b00f411ed306ae034a09cb5bea4d5cf
     * company_id : 4db45cd9b74683a13c53f39ae6ba6002
     * type : 1
     * skill_type : 2
     * is_urgent : 0
     * title : 141线路所
     * number : SYI00-0100001
     * pic1 : /upload/facility/2018-04-24/d41f7ccb88ac98cf51c92ccf631f9c90.png
     * pic2 : /upload/facility/2018-04-24/3ee19a1d63d2d1864cbdee6f23747846.png
     * pic3 : /upload/facility/2018-04-24/c1208a12e2a2dd305e288ef5f8809198.png
     * area : 0
     * use_age : 0
     * addr : 中国重庆市南岸区南坪区府美食街惠工路14号
     * annual : 1
     * longitude : 106.571445
     * latitude : 29.534465
     * status : 2
     * reason :
     * last_small_service_at : 2018-04-13 16:02:46
     * last_mid_service_at : 2018-04-11 16:29:04
     * last_big_service_at : 2018-03-31 20:27:43
     * created_at : 2018-01-12 16:48:16
     * updated_at : 2018-04-25 10:18:30
     * deleted_at : null
     * line : 遂渝线
     * remark :
     * use_status : 2
     * ha_total : 350.0
     * house_area : 218.0
     * attached_area : 132.0
     * structure : 混合（砖混）
     * floor : 1
     * build_age : 20091230
     * roof_form : 平屋面
     * roof_area : 218
     * use_nature : 1
     * category : 1
     * structures_unit :
     * structures_quantity :
     * structures_area :
     * take_over : 2
     * is_inspect : 2
     * facility_disease_info : 请检修-潮湿返霜-6㎡
     * 请检修-潮湿返霜-6㎡
     * 请检修-电照设备破损-2㎡
     * 大修-水暖设备破损-1㎡
     * 大修-水暖设备破损-3㎡
     * 综合维修-冻害、蚁害-6㎡
     * facility_diseases : [{"id":"53d731e6af2f70fb1fa20d7af71556be","content":"请检修-潮湿返霜-6㎡"},{"id":"7be8c9debab217ac0917892cf65fc34a","content":"请检修-潮湿返霜-6㎡"},{"id":"9b2d1eee63d5801a2f10100603629cb5","content":"请检修-电照设备破损-2㎡"},{"id":"b888aeda86017e8a333e6957738660b3","content":"大修-水暖设备破损-1㎡"},{"id":"b8ddce99ca74457cb16e243156c65964","content":"大修-水暖设备破损-3㎡"},{"id":"bf52452e2620d324b07f388b8b068294","content":"综合维修-冻害、蚁害-6㎡"}]
     * minor : 请检修-待完善
     * minor_updated_at : 2018-04-24
     * mid : 综合维修-上报中
     * mid_updated_at : 2018-04-25
     * big : 大修-暂无
     * big_updated_at : 暂无
     * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null}
     * workshop : {"id":"664e61b7fa80368e57fdd499f26a9392","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆北","longitude":"108.671422","latitude":"29.13445","facility_count":3,"created_at":"2017-10-18 18:43:45","updated_at":"2018-04-24 11:04:53","deleted_at":null}
     * work_area : {"id":"cc7e95acd10a09e4fcb46eefc1d4d2c4","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","title":"沙坪坝工区","longitude":"106.571464","latitude":"29.534554","facility_count":1,"created_at":"2018-01-08 16:01:59","updated_at":"2018-04-24 11:04:53","deleted_at":null}
     * station : {"id":"7b00f411ed306ae034a09cb5bea4d5cf","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"664e61b7fa80368e57fdd499f26a9392","work_area_id":"cc7e95acd10a09e4fcb46eefc1d4d2c4","title":"蔡家-井口","longitude":"","latitude":"","sort":0,"map_path":"","created_at":"2018-01-08 17:34:11","updated_at":"2018-01-08 17:34:11","deleted_at":null,"map_name":""}
     * company : {"id":"4db45cd9b74683a13c53f39ae6ba6002","title":"重庆北车务段","created_at":"2018-01-08 16:01:59","updated_at":null,"deleted_at":null}
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
    private int is_urgent;
    private String title;
    private String number;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;
    private String pic5;

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
    private int take_over;
    private int is_inspect;
    private String facility_disease_info;
    private String minor;
    private String minor_updated_at;
    private String mid;
    private String mid_updated_at;
    private String big;
    private String big_updated_at;
    private SectionBean section;
    private WorkshopBean workshop;
    private WorkAreaBean work_area;
    private StationBean station;
    private CompanyBean company;
    private List<FacilityDiseasesBean> facility_diseases;

    private int speed;
    private String roof_attachment;

    public String getPic4() {
        return pic4;
    }

    public void setPic4(String pic4) {
        this.pic4 = pic4;
    }

    public String getPic5() {
        return pic5;
    }

    public void setPic5(String pic5) {
        this.pic5 = pic5;
    }

    public String getRoof_attachment() {
        return roof_attachment;
    }

    public void setRoof_attachment(String roof_attachment) {
        this.roof_attachment = roof_attachment;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public int getIs_urgent() {
        return is_urgent;
    }

    public void setIs_urgent(int is_urgent) {
        this.is_urgent = is_urgent;
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

    public int getTake_over() {
        return take_over;
    }

    public void setTake_over(int take_over) {
        this.take_over = take_over;
    }

    public int getIs_inspect() {
        return is_inspect;
    }

    public void setIs_inspect(int is_inspect) {
        this.is_inspect = is_inspect;
    }

    public String getFacility_disease_info() {
        return facility_disease_info;
    }

    public void setFacility_disease_info(String facility_disease_info) {
        this.facility_disease_info = facility_disease_info;
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

    public List<FacilityDiseasesBean> getFacility_diseases() {
        return facility_diseases;
    }

    public void setFacility_diseases(List<FacilityDiseasesBean> facility_diseases) {
        this.facility_diseases = facility_diseases;
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
         * title : 重庆北
         * longitude : 108.671422
         * latitude : 29.13445
         * facility_count : 3
         * created_at : 2017-10-18 18:43:45
         * updated_at : 2018-04-24 11:04:53
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
         * id : cc7e95acd10a09e4fcb46eefc1d4d2c4
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : 664e61b7fa80368e57fdd499f26a9392
         * title : 沙坪坝工区
         * longitude : 106.571464
         * latitude : 29.534554
         * facility_count : 1
         * created_at : 2018-01-08 16:01:59
         * updated_at : 2018-04-24 11:04:53
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
         * id : 7b00f411ed306ae034a09cb5bea4d5cf
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : 664e61b7fa80368e57fdd499f26a9392
         * work_area_id : cc7e95acd10a09e4fcb46eefc1d4d2c4
         * title : 蔡家-井口
         * longitude :
         * latitude :
         * sort : 0
         * map_path :
         * created_at : 2018-01-08 17:34:11
         * updated_at : 2018-01-08 17:34:11
         * deleted_at : null
         * map_name :
         */

        private String id;
        private String railway_id;
        private String section_id;
        private String workshop_id;
        private String work_area_id;
        private String title;
        private String longitude;
        private String latitude;
        private int sort;
        private String map_path;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private String map_name;

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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getMap_path() {
            return map_path;
        }

        public void setMap_path(String map_path) {
            this.map_path = map_path;
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

        public String getMap_name() {
            return map_name;
        }

        public void setMap_name(String map_name) {
            this.map_name = map_name;
        }
    }

    public static class CompanyBean {
        /**
         * id : 4db45cd9b74683a13c53f39ae6ba6002
         * title : 重庆北车务段
         * created_at : 2018-01-08 16:01:59
         * updated_at : null
         * deleted_at : null
         */

        private String id;
        private String title;
        private String created_at;
        private Object updated_at;
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

        public Object getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Object updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }
    }

    public static class FacilityDiseasesBean {
        /**
         * id : 53d731e6af2f70fb1fa20d7af71556be
         * content : 请检修-潮湿返霜-6㎡
         */

        private String id;
        private String content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
