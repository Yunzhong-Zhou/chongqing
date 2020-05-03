package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/17.
 */

public class EquipmentDetailModel2 implements Serializable {
    private List<SmallBean> small;
    private List<MidBean> mid;
    private List<BigBean> big;

    public List<SmallBean> getSmall() {
        return small;
    }

    public void setSmall(List<SmallBean> small) {
        this.small = small;
    }

    public List<MidBean> getMid() {
        return mid;
    }

    public void setMid(List<MidBean> mid) {
        this.mid = mid;
    }

    public List<BigBean> getBig() {
        return big;
    }

    public void setBig(List<BigBean> big) {
        this.big = big;
    }

    public static class SmallBean {
        /**
         * year : 2018
         * data : [{"id":"b80e4c3b4031f8da8570f41949ccf2dd","facility_id":"9e1222afa81b2329ac44d673f194f23a","publish_disease_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","employee_role":1,"type":1,"disease_classify":1,"status":6,"facility_service_report_id":"","batch_year":"","batch":1,"created_at":"2018-01-12 15:18:39","updated_at":"2018-01-12 15:34:47","deleted_at":null,"facility_disease_list":[{"id":"d39231bc3425b368cc8a451acc639d98","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"b80e4c3b4031f8da8570f41949ccf2dd","facility_service_report_id":"","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"280.00","title":"","degree":1,"area":20,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/ecf0460ba09587b65ff5d09888eadb8a.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/cef3e59a5404390ca761d2691b081a9f.png\"]","description":"好几遍好纠结","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 15:33:23","updated_at":"2018-01-12 15:33:23","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}},{"id":"3d78618f13f22b1258853fc1f9fde805","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"eac4871f536b1d009697af62e6ec2396","facility_service_apply_id":"b80e4c3b4031f8da8570f41949ccf2dd","facility_service_report_id":"","facility_disease_valuation_id":"6ea5cde00851a232246c6cd9b6ec397a","price":"6.00","amount_money":"120.00","title":"","degree":1,"area":20,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/11b1c58582e98e5956fb96632c276abd.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/dfe08d3649b19c0fda8d0c9e503af7e0.png\"]","description":"公积金你哪位","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 15:18:40","updated_at":"2018-01-12 15:18:40","deleted_at":null,"facility_disease_type":{"id":"eac4871f536b1d009697af62e6ec2396","title":"水暖设备破损","created_at":"2017-11-30 14:52:06","updated_at":"2017-11-30 14:52:06","deleted_at":null}}]}]
         */
        private int isOpen;

        public int getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(int isOpen) {
            this.isOpen = isOpen;
        }

        private int year;
        private List<DataBean> data;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : b80e4c3b4031f8da8570f41949ccf2dd
             * facility_id : 9e1222afa81b2329ac44d673f194f23a
             * publish_disease_id :
             * employee_id : acdb6ef78389f6d67cafed76405cfbbc
             * employee_role : 1
             * type : 1
             * disease_classify : 1
             * status : 6
             * facility_service_report_id :
             * batch_year :
             * batch : 1
             * created_at : 2018-01-12 15:18:39
             * updated_at : 2018-01-12 15:34:47
             * deleted_at : null
             * facility_disease_list : [{"id":"d39231bc3425b368cc8a451acc639d98","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"b80e4c3b4031f8da8570f41949ccf2dd","facility_service_report_id":"","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"280.00","title":"","degree":1,"area":20,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/ecf0460ba09587b65ff5d09888eadb8a.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/cef3e59a5404390ca761d2691b081a9f.png\"]","description":"好几遍好纠结","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 15:33:23","updated_at":"2018-01-12 15:33:23","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}},{"id":"3d78618f13f22b1258853fc1f9fde805","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"eac4871f536b1d009697af62e6ec2396","facility_service_apply_id":"b80e4c3b4031f8da8570f41949ccf2dd","facility_service_report_id":"","facility_disease_valuation_id":"6ea5cde00851a232246c6cd9b6ec397a","price":"6.00","amount_money":"120.00","title":"","degree":1,"area":20,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/11b1c58582e98e5956fb96632c276abd.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/dfe08d3649b19c0fda8d0c9e503af7e0.png\"]","description":"公积金你哪位","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 15:18:40","updated_at":"2018-01-12 15:18:40","deleted_at":null,"facility_disease_type":{"id":"eac4871f536b1d009697af62e6ec2396","title":"水暖设备破损","created_at":"2017-11-30 14:52:06","updated_at":"2017-11-30 14:52:06","deleted_at":null}}]
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
                 * id : d39231bc3425b368cc8a451acc639d98
                 * facility_disease_repair_id :
                 * employee_id : acdb6ef78389f6d67cafed76405cfbbc
                 * facility_id : 9e1222afa81b2329ac44d673f194f23a
                 * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
                 * facility_service_apply_id : b80e4c3b4031f8da8570f41949ccf2dd
                 * facility_service_report_id :
                 * facility_disease_valuation_id : 35143ce7f1056ab1c5e3dc6cabd6f674
                 * price : 14.00
                 * amount_money : 280.00
                 * title :
                 * degree : 1
                 * area : 20
                 * pic_list : ["\/upload\/facility-disease\/2018-01-12\/ecf0460ba09587b65ff5d09888eadb8a.png","\/upload\/facility-disease\/2018-01-12\/cef3e59a5404390ca761d2691b081a9f.png"]
                 * description : 好几遍好纠结
                 * finalize : 1
                 * facility_skill_type : 1
                 * created_at : 2018-01-12 15:33:23
                 * updated_at : 2018-01-12 15:33:23
                 * deleted_at : null
                 * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}
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
                private String pic_list;
                private String description;
                private int finalize;
                private int facility_skill_type;
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

                public int getFinalize() {
                    return finalize;
                }

                public void setFinalize(int finalize) {
                    this.finalize = finalize;
                }

                public int getFacility_skill_type() {
                    return facility_skill_type;
                }

                public void setFacility_skill_type(int facility_skill_type) {
                    this.facility_skill_type = facility_skill_type;
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
                     * id : 4529aed21751b7a350430adf28fd1034
                     * title : 腐蚀破裂变形
                     * created_at : 2017-08-21 10:39:52
                     * updated_at : 2017-12-12 16:52:09
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

        @Override
        public String toString() {
            return "SmallBean{" +
                    "isOpen=" + isOpen +
                    ", year=" + year +
                    ", data=" + data +
                    '}';
        }
    }

    public static class MidBean {
        /**
         * year : 2018
         * data : [{"id":"81d68278161feab04d215f53eb645a32","facility_id":"9e1222afa81b2329ac44d673f194f23a","publish_disease_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","employee_role":1,"type":2,"disease_classify":2,"status":1,"facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","batch_year":"","batch":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_list":[{"id":"bb2ad97f638aa80749813fcccf3dacc4","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"81d68278161feab04d215f53eb645a32","facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"560.00","title":"","degree":1,"area":40,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/163c3475de667d5653f8bad619449967.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/05ac358a1ac3c110bba5e3b7b3df49bc.png\"]","description":"次叫姐姐白百何","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}}]}]
         */
        private int isOpen;

        public int getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(int isOpen) {
            this.isOpen = isOpen;
        }

        private int year;
        private List<DataBeanX> data;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public static class DataBeanX {
            /**
             * id : 81d68278161feab04d215f53eb645a32
             * facility_id : 9e1222afa81b2329ac44d673f194f23a
             * publish_disease_id :
             * employee_id : acdb6ef78389f6d67cafed76405cfbbc
             * employee_role : 1
             * type : 2
             * disease_classify : 2
             * status : 1
             * facility_service_report_id : 51f4f01229ec93c3f729763789b06dab
             * batch_year :
             * batch : 1
             * created_at : 2018-01-12 14:45:49
             * updated_at : 2018-01-12 15:01:01
             * deleted_at : null
             * facility_disease_list : [{"id":"bb2ad97f638aa80749813fcccf3dacc4","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"81d68278161feab04d215f53eb645a32","facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"560.00","title":"","degree":1,"area":40,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/163c3475de667d5653f8bad619449967.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/05ac358a1ac3c110bba5e3b7b3df49bc.png\"]","description":"次叫姐姐白百何","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}}]
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
            private List<FacilityDiseaseListBeanX> facility_disease_list;

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

            public List<FacilityDiseaseListBeanX> getFacility_disease_list() {
                return facility_disease_list;
            }

            public void setFacility_disease_list(List<FacilityDiseaseListBeanX> facility_disease_list) {
                this.facility_disease_list = facility_disease_list;
            }

            public static class FacilityDiseaseListBeanX {
                /**
                 * id : bb2ad97f638aa80749813fcccf3dacc4
                 * facility_disease_repair_id :
                 * employee_id : acdb6ef78389f6d67cafed76405cfbbc
                 * facility_id : 9e1222afa81b2329ac44d673f194f23a
                 * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
                 * facility_service_apply_id : 81d68278161feab04d215f53eb645a32
                 * facility_service_report_id : 51f4f01229ec93c3f729763789b06dab
                 * facility_disease_valuation_id : 35143ce7f1056ab1c5e3dc6cabd6f674
                 * price : 14.00
                 * amount_money : 560.00
                 * title :
                 * degree : 1
                 * area : 40
                 * pic_list : ["\/upload\/facility-disease\/2018-01-12\/163c3475de667d5653f8bad619449967.png","\/upload\/facility-disease\/2018-01-12\/05ac358a1ac3c110bba5e3b7b3df49bc.png"]
                 * description : 次叫姐姐白百何
                 * finalize : 1
                 * facility_skill_type : 1
                 * created_at : 2018-01-12 14:45:49
                 * updated_at : 2018-01-12 15:01:01
                 * deleted_at : null
                 * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}
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
                private String pic_list;
                private String description;
                private int finalize;
                private int facility_skill_type;
                private String created_at;
                private String updated_at;
                private Object deleted_at;
                private FacilityDiseaseTypeBeanX facility_disease_type;

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

                public int getFinalize() {
                    return finalize;
                }

                public void setFinalize(int finalize) {
                    this.finalize = finalize;
                }

                public int getFacility_skill_type() {
                    return facility_skill_type;
                }

                public void setFacility_skill_type(int facility_skill_type) {
                    this.facility_skill_type = facility_skill_type;
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

                public FacilityDiseaseTypeBeanX getFacility_disease_type() {
                    return facility_disease_type;
                }

                public void setFacility_disease_type(FacilityDiseaseTypeBeanX facility_disease_type) {
                    this.facility_disease_type = facility_disease_type;
                }

                public static class FacilityDiseaseTypeBeanX {
                    /**
                     * id : 4529aed21751b7a350430adf28fd1034
                     * title : 腐蚀破裂变形
                     * created_at : 2017-08-21 10:39:52
                     * updated_at : 2017-12-12 16:52:09
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

        @Override
        public String toString() {
            return "MidBean{" +
                    "isOpen=" + isOpen +
                    ", year=" + year +
                    ", data=" + data +
                    '}';
        }
    }

    public static class BigBean {
        /**
         * year : 2018
         * data : [{"id":"81d68278161feab04d215f53eb645a32","facility_id":"9e1222afa81b2329ac44d673f194f23a","publish_disease_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","employee_role":1,"type":2,"disease_classify":2,"status":1,"facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","batch_year":"","batch":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_list":[{"id":"bb2ad97f638aa80749813fcccf3dacc4","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"81d68278161feab04d215f53eb645a32","facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"560.00","title":"","degree":1,"area":40,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/163c3475de667d5653f8bad619449967.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/05ac358a1ac3c110bba5e3b7b3df49bc.png\"]","description":"次叫姐姐白百何","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}}]}]
         */


        private int isOpen;

        public int getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(int isOpen) {
            this.isOpen = isOpen;
        }

        private int year;
        private List<DataBeanXX> data;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<DataBeanXX> getData() {
            return data;
        }

        public void setData(List<DataBeanXX> data) {
            this.data = data;
        }

        public static class DataBeanXX {
            /**
             * id : 81d68278161feab04d215f53eb645a32
             * facility_id : 9e1222afa81b2329ac44d673f194f23a
             * publish_disease_id :
             * employee_id : acdb6ef78389f6d67cafed76405cfbbc
             * employee_role : 1
             * type : 2
             * disease_classify : 2
             * status : 1
             * facility_service_report_id : 51f4f01229ec93c3f729763789b06dab
             * batch_year :
             * batch : 1
             * created_at : 2018-01-12 14:45:49
             * updated_at : 2018-01-12 15:01:01
             * deleted_at : null
             * facility_disease_list : [{"id":"bb2ad97f638aa80749813fcccf3dacc4","facility_disease_repair_id":"","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","facility_id":"9e1222afa81b2329ac44d673f194f23a","facility_disease_type_id":"4529aed21751b7a350430adf28fd1034","facility_service_apply_id":"81d68278161feab04d215f53eb645a32","facility_service_report_id":"51f4f01229ec93c3f729763789b06dab","facility_disease_valuation_id":"35143ce7f1056ab1c5e3dc6cabd6f674","price":"14.00","amount_money":"560.00","title":"","degree":1,"area":40,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/163c3475de667d5653f8bad619449967.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/05ac358a1ac3c110bba5e3b7b3df49bc.png\"]","description":"次叫姐姐白百何","finalize":1,"facility_skill_type":1,"created_at":"2018-01-12 14:45:49","updated_at":"2018-01-12 15:01:01","deleted_at":null,"facility_disease_type":{"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}}]
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
            private List<FacilityDiseaseListBeanXX> facility_disease_list;

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

            public List<FacilityDiseaseListBeanXX> getFacility_disease_list() {
                return facility_disease_list;
            }

            public void setFacility_disease_list(List<FacilityDiseaseListBeanXX> facility_disease_list) {
                this.facility_disease_list = facility_disease_list;
            }

            public static class FacilityDiseaseListBeanXX {
                /**
                 * id : bb2ad97f638aa80749813fcccf3dacc4
                 * facility_disease_repair_id :
                 * employee_id : acdb6ef78389f6d67cafed76405cfbbc
                 * facility_id : 9e1222afa81b2329ac44d673f194f23a
                 * facility_disease_type_id : 4529aed21751b7a350430adf28fd1034
                 * facility_service_apply_id : 81d68278161feab04d215f53eb645a32
                 * facility_service_report_id : 51f4f01229ec93c3f729763789b06dab
                 * facility_disease_valuation_id : 35143ce7f1056ab1c5e3dc6cabd6f674
                 * price : 14.00
                 * amount_money : 560.00
                 * title :
                 * degree : 1
                 * area : 40
                 * pic_list : ["\/upload\/facility-disease\/2018-01-12\/163c3475de667d5653f8bad619449967.png","\/upload\/facility-disease\/2018-01-12\/05ac358a1ac3c110bba5e3b7b3df49bc.png"]
                 * description : 次叫姐姐白百何
                 * finalize : 1
                 * facility_skill_type : 1
                 * created_at : 2018-01-12 14:45:49
                 * updated_at : 2018-01-12 15:01:01
                 * deleted_at : null
                 * facility_disease_type : {"id":"4529aed21751b7a350430adf28fd1034","title":"腐蚀破裂变形","created_at":"2017-08-21 10:39:52","updated_at":"2017-12-12 16:52:09","deleted_at":null}
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
                private String pic_list;
                private String description;
                private int finalize;
                private int facility_skill_type;
                private String created_at;
                private String updated_at;
                private Object deleted_at;
                private FacilityDiseaseTypeBeanXX facility_disease_type;

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

                public int getFinalize() {
                    return finalize;
                }

                public void setFinalize(int finalize) {
                    this.finalize = finalize;
                }

                public int getFacility_skill_type() {
                    return facility_skill_type;
                }

                public void setFacility_skill_type(int facility_skill_type) {
                    this.facility_skill_type = facility_skill_type;
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

                public FacilityDiseaseTypeBeanXX getFacility_disease_type() {
                    return facility_disease_type;
                }

                public void setFacility_disease_type(FacilityDiseaseTypeBeanXX facility_disease_type) {
                    this.facility_disease_type = facility_disease_type;
                }

                public static class FacilityDiseaseTypeBeanXX {
                    /**
                     * id : 4529aed21751b7a350430adf28fd1034
                     * title : 腐蚀破裂变形
                     * created_at : 2017-08-21 10:39:52
                     * updated_at : 2017-12-12 16:52:09
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

        @Override
        public String toString() {
            return "BigBean{" +
                    "isOpen=" + isOpen +
                    ", year=" + year +
                    ", data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EquipmentDetailModel2{" +
                "small=" + small +
                ", mid=" + mid +
                ", big=" + big +
                '}';
    }
}
