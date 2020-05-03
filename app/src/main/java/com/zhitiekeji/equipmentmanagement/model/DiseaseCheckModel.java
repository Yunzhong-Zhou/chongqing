package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/8/9.
 */

public class DiseaseCheckModel implements Serializable {
    /**
     * id : 0729380b46f38467cc9ca8f65ff5eb11
     * facility_id : 68e44ce5b6af8da6ed4bef3427814cd5
     * publish_disease_id :
     * employee_id : ab53e73a2e434175341edd79d21121c5
     * type : 1
     * report_step : -1
     * status : 1
     * created_at : 2017-08-09 18:00:12
     * updated_at : 2017-08-09 18:00:12
     * deleted_at : null
     */

    private String id;
    private String facility_id;
    private String publish_disease_id;
    private String employee_id;
    private int type;
    private int report_step;
    private int status;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getReport_step() {
        return report_step;
    }

    public void setReport_step(int report_step) {
        this.report_step = report_step;
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

    @Override
    public String toString() {
        return "DiseaseCheckModel{" +
                "id='" + id + '\'' +
                ", facility_id='" + facility_id + '\'' +
                ", publish_disease_id='" + publish_disease_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", type=" + type +
                ", report_step=" + report_step +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
