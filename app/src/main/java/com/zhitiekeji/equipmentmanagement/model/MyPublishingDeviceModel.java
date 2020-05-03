package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/4.
 */

public class MyPublishingDeviceModel implements Serializable {

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
     * last_small_service_at : null
     * last_mid_service_at : null
     * last_big_service_at : null
     * created_at : 2017-11-21 11:19:32
     * updated_at : 2017-11-21 17:57:04
     * deleted_at : null
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
     * minor : 请检修-暂无
     * minor_updated_at : 暂无
     * mid : 综合维修-已上报
     * mid_updated_at : 2017-11-24
     * big : 大修-暂无
     * big_updated_at : 暂无
     * railway : {"id":"23cd931f4e6d162e10fe435e2a06933d","title":"成都铁路局","created_at":"2017-10-09 15:41:51","updated_at":"2017-11-22 11:26:24","deleted_at":null}
     * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null}
     * workshop : {"id":"ce3b156d82d6f8eef15e1e7d16b89776","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆车间","longitude":"106.722386","latitude":"29.834357","facility_count":5,"created_at":"2017-10-13 14:02:26","updated_at":"2017-11-21 11:19:50","deleted_at":null}
     * work_area : {"id":"a51e3c04a5fda9ea98c28bfdd3f61dde","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","title":"达州工区","longitude":"106.72986","latitude":"29.164357","facility_count":3,"created_at":"2017-10-13 14:24:43","updated_at":"2017-11-24 14:45:49","deleted_at":null}
     * station : {"id":"3a3d00cd19fc25a3720daf236d39fa56","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"a51e3c04a5fda9ea98c28bfdd3f61dde","title":"G站区","created_at":"2017-10-13 14:29:32","updated_at":"2017-10-26 09:34:59","deleted_at":null}
     * company : {"id":"5356bdd2a4a09b6222c60e317ede6d8f","title":"智铁科技","created_at":"2017-10-16 14:20:19","updated_at":"2017-10-26 10:16:47","deleted_at":null}
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
    private Object last_small_service_at;
    private Object last_mid_service_at;
    private Object last_big_service_at;
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
    private String minor;
    private String minor_updated_at;
    private String mid;
    private String mid_updated_at;
    private String big;
    private String big_updated_at;
    private RailwayBean railway;
    private SectionBean section;
    private WorkshopBean workshop;
    private WorkAreaBean work_area;
    private StationBean station;
    private CompanyBean company;
    private String is_inspect;

    public String getIs_inspect() {
        return is_inspect;
    }

    public void setIs_inspect(String is_inspect) {
        this.is_inspect = is_inspect;
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

    public Object getLast_small_service_at() {
        return last_small_service_at;
    }

    public void setLast_small_service_at(Object last_small_service_at) {
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

    public RailwayBean getRailway() {
        return railway;
    }

    public void setRailway(RailwayBean railway) {
        this.railway = railway;
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

    public static class RailwayBean {
        /**
         * id : 23cd931f4e6d162e10fe435e2a06933d
         * title : 成都铁路局
         * created_at : 2017-10-09 15:41:51
         * updated_at : 2017-11-22 11:26:24
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
         * id : ce3b156d82d6f8eef15e1e7d16b89776
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * title : 重庆车间
         * longitude : 106.722386
         * latitude : 29.834357
         * facility_count : 5
         * created_at : 2017-10-13 14:02:26
         * updated_at : 2017-11-21 11:19:50
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
         * id : 3a3d00cd19fc25a3720daf236d39fa56
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
         * work_area_id : a51e3c04a5fda9ea98c28bfdd3f61dde
         * title : G站区
         * created_at : 2017-10-13 14:29:32
         * updated_at : 2017-10-26 09:34:59
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
         * id : 5356bdd2a4a09b6222c60e317ede6d8f
         * title : 智铁科技
         * created_at : 2017-10-16 14:20:19
         * updated_at : 2017-10-26 10:16:47
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
