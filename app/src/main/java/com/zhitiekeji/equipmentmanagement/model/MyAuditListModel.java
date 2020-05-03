package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class MyAuditListModel implements Serializable {
    /**
     * id : 36cd7550cdf8834f43b3f6241cd59bb9
     * facility_id : 7b7211724bb68aa241360af705f267e0
     * publish_disease_id :
     * employee_id : acdb6ef78389f6d67cafed76405cfbbc
     * employee_role : 1
     * type : 3
     * disease_classify : 3
     * status : 1
     * facility_service_report_id : 45948ac5c4a268a365951b342089c5c0
     * batch_year :
     * batch : 1
     * created_at : 2017-11-24 18:01:36
     * updated_at : 2017-11-24 18:02:37
     * deleted_at :
     * facility : {"id":"7b7211724bb68aa241360af705f267e0","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","station_id":"1673e20e9d72c2ac8659e2182d69258d","company_id":"61ede8f70a0d041db205c1d67f86d2e7","type":"2","skill_type":"3","title":"设备10","number":"xc0010","pic1":"/upload/facility/2017-11-08/27c192ce5409409ee5ddbf74359219da.png","pic2":"/upload/facility/2017-11-08/c049f5688ad52cc3647946f16d41100a.png","pic3":"/upload/facility/2017-11-08/67223696dfc68c01f7a4f2dbb9d4b112.png","area":"2800","use_age":"18","addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":"1","longitude":"106.571399","latitude":"29.534442","status":"2","reason":"","last_small_service_at":"2017-11-24 20:50:51","last_mid_service_at":"2017-11-24 20:46:20","last_big_service_at":"","created_at":"2017-11-08 09:46:58","updated_at":"2017-11-28 16:31:02","deleted_at":"","extra_json":"","line":"成渝线","remark":"分局内全部堡坎","use_status":"3","ha_total":"","house_area":"","attached_area":"","structure":"混合（砖混）","floor":"","build_age":"19900315","roof_form":"","roof_area":"","use_nature":"4","category":"4","structures_unit":"座","structures_quantity":"3","structures_area":"150","workshop":{"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":"3","created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":""},"work_area":{"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":"1","created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":""},"station":{"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":""},"company":{"id":"61ede8f70a0d041db205c1d67f86d2e7","title":"阿里巴巴","created_at":"2017-10-09 16:29:40","updated_at":"2017-11-02 14:49:44","deleted_at":""}}
     * facility_disease_list : [{"id":"2d4d50c099d50f238910d6dc9cc43f1f","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"36cd7550cdf8834f43b3f6241cd59bb9","facility_service_report_id":"45948ac5c4a268a365951b342089c5c0","facility_disease_valuation_id":"7be209c469cd9ba0153a05ad73fa1fa0","price":"2.00","amount_money":"50.00","title":"还好","degree":"2","area":"25","pic_list":"","description":"","finalize":"1","created_at":"2017-11-24 18:01:50","updated_at":"2017-11-24 18:02:37","deleted_at":"","facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"分类3","created_at":"2017-08-21 10:39:52","updated_at":"2017-08-21 10:39:52","deleted_at":""}},{"id":"ef4b89c5349ca90ae7964c943ec33cb7","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"7b7211724bb68aa241360af705f267e0","facility_disease_type_id":"e6af12378fe83e4911e6b6f92421126a","facility_service_apply_id":"36cd7550cdf8834f43b3f6241cd59bb9","facility_service_report_id":"45948ac5c4a268a365951b342089c5c0","facility_disease_valuation_id":"ef7d6a6f752d67dd4e11ef2daf4aa474","price":"50.00","amount_money":"600.00","title":"谷歌","degree":"1","area":"12","pic_list":"","description":"","finalize":"1","created_at":"2017-11-24 18:01:36","updated_at":"2017-11-24 18:02:37","deleted_at":"","facility_disease_type":{"id":"e6af12378fe83e4911e6b6f92421126a","title":"紧急病害","created_at":"2017-11-22 11:29:58","updated_at":"2017-11-22 11:29:58","deleted_at":""}}]
     */

    private int select;

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

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
    private FacilityBean facility;
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

    public FacilityBean getFacility() {
        return facility;
    }

    public void setFacility(FacilityBean facility) {
        this.facility = facility;
    }

    public List<FacilityDiseaseListBean> getFacility_disease_list() {
        return facility_disease_list;
    }

    public void setFacility_disease_list(List<FacilityDiseaseListBean> facility_disease_list) {
        this.facility_disease_list = facility_disease_list;
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
         * workshop : {"id":"f37326274f1fc4c8c208b8df5d1f2bb3","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"内江车间","longitude":"105.505326","latitude":"29.769387","facility_count":"3","created_at":"2017-10-09 15:44:59","updated_at":"2017-11-28 16:31:02","deleted_at":""}
         * work_area : {"id":"1a61baea57bcd21a520fac2749ba5e39","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","title":"自贡工区","longitude":"106.571399","latitude":"29.534442","facility_count":"1","created_at":"2017-11-24 14:48:43","updated_at":"2017-11-28 16:31:02","deleted_at":""}
         * station : {"id":"1673e20e9d72c2ac8659e2182d69258d","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"1a61baea57bcd21a520fac2749ba5e39","title":"王场","created_at":"2017-11-27 14:49:50","updated_at":"2017-11-27 14:49:50","deleted_at":""}
         * company : {"id":"61ede8f70a0d041db205c1d67f86d2e7","title":"阿里巴巴","created_at":"2017-10-09 16:29:40","updated_at":"2017-11-02 14:49:44","deleted_at":""}
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

    public static class FacilityDiseaseListBean {
        /**
         * id : 2d4d50c099d50f238910d6dc9cc43f1f
         * facility_disease_repair_id :
         * employee_id : acdb6ef78389f6d67cafed76405cfbbc
         * facility_id : 7b7211724bb68aa241360af705f267e0
         * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
         * facility_service_apply_id : 36cd7550cdf8834f43b3f6241cd59bb9
         * facility_service_report_id : 45948ac5c4a268a365951b342089c5c0
         * facility_disease_valuation_id : 7be209c469cd9ba0153a05ad73fa1fa0
         * price : 2.00
         * amount_money : 50.00
         * title : 还好
         * degree : 2
         * area : 25
         * pic_list :
         * description :
         * finalize : 1
         * created_at : 2017-11-24 18:01:50
         * updated_at : 2017-11-24 18:02:37
         * deleted_at :
         * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"分类3","created_at":"2017-08-21 10:39:52","updated_at":"2017-08-21 10:39:52","deleted_at":""}
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
             * id : 4529aed21751b7a350430adf28fd1034
             * title : 分类3
             * created_at : 2017-08-21 10:39:52
             * updated_at : 2017-08-21 10:39:52
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
