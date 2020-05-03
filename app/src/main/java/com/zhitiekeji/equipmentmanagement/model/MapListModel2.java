package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/10/13.
 * 车间
 */

public class MapListModel2 implements Serializable{

        /**
         * id : 290d50f1b9c24f37c769c6e57f993958
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
         * title : 涪陵工区
         * longitude : 305
         * latitude : 301
         * facility_count :
         * created_at : 2017-10-13 14:25:18
         * updated_at : 2017-10-13 14:25:18
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
