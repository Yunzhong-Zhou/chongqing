package com.zhitiekeji.equipmentmanagement.model;

/**
 * Created by zyz on 2017/8/9.
 */

public class ReportDiseaseListModel {
    /**
     * id : 2dbdfb895bf38553e78c43c21fdc9701
     * facility_disease_repair_id :
     * employee_id : acdb6ef78389f6d67cafed76405cfbbc
     * facility_id : 2f9804724a3f31539973a9631142429c
     * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
     * facility_service_apply_id : eb7c3c540c558841e67cfa933b7a5d84
     * facility_service_report_id : bc50d77748dc58a9dec0b3235b98b174
     * facility_disease_valuation_id : 33016992b77136e72931f8e5ee1bd83e
     * price : 32.00
     * amount_money : 384.00
     * title : 会员发布
     * degree : 3
     * area : 12
     * pic_list :
     * description :
     * finalize : 1
     * created_at : 2017-11-30 14:25:41
     * updated_at : 2017-11-30 14:25:44
     * deleted_at :
     * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"严重腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-11-30 14:50:51","deleted_at":""}
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
         * title : 严重腐蚀破裂变形
         * created_at : 2017-08-21 10:39:52
         * updated_at : 2017-11-30 14:50:51
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
