package com.zhitiekeji.equipmentmanagement.model;

import java.io.Serializable;

/**
 * Created by zyz on 2017/10/12.
 * 审报记录
 */

public class RetaliationRecordModel implements Serializable{
        /**
         * facility_service_approval : {"id":"9affd1fbc8e4ec9cb9a0f436636119a4","facility_id":"42dccd8f3ed22ca9a0a2abdd6319c68c","facility_service_report_id":"484f67b3eb1817da0a6d3a9b3e1fa195","facility_service_apply_id":"44cae6ca554e942a72bdaf856d39440f","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","evaluate":"20.00","money":"20.00","created_at":"2017-10-12 18:19:51","updated_at":"2017-10-12 18:19:51","deleted_at":null,"flag":"段","employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"","duty":"64","role":5,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-10-09 19:05:41","deleted_at":null}}
         * facility_service_issue : {"id":"ef3b66664a4258a8da572e9e11468196","facility_id":"42dccd8f3ed22ca9a0a2abdd6319c68c","facility_service_report_id":"484f67b3eb1817da0a6d3a9b3e1fa195","facility_service_apply_id":"44cae6ca554e942a72bdaf856d39440f","facility_service_approval_id":"9affd1fbc8e4ec9cb9a0f436636119a4","employee_id":"6ea4425bd3b4b7e11fd5cc4c3b649381","plan_number":"x01","cost_money":"10000.00","renovate_content":"下达_接口测试","created_at":"2017-10-12 20:13:01","updated_at":"2017-10-12 20:13:01","deleted_at":null,"flag":"财","employee":{"id":"6ea4425bd3b4b7e11fd5cc4c3b649381","mobile":"13000000006","active":1,"head":"","duty":"64","role":6,"idcard":"","name":"财政所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:24","updated_at":"2017-10-09 15:52:24","deleted_at":null}}
         * facility_service_reply : {"id":"9a048df2818b44763e06ab7438a04c11","facility_id":"42dccd8f3ed22ca9a0a2abdd6319c68c","facility_service_report_id":"484f67b3eb1817da0a6d3a9b3e1fa195","facility_service_apply_id":"44cae6ca554e942a72bdaf856d39440f","facility_service_approval_id":"9affd1fbc8e4ec9cb9a0f436636119a4","facility_service_issue_id":"ef3b66664a4258a8da572e9e11468196","employee_id":"86979a51f328e0bd264b026411bd000e","reply_number":"y01","reply_at":null,"project_scope":"批复_接口测试","supervisor_money":"10000.00","construction_money":"10000.00","design_money":"10000.00","amount_money":"0.00","created_at":"2017-10-12 20:15:20","updated_at":"2017-10-12 20:15:20","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}}
         * facility_service_implement : {"id":"e6664bce3d0d09b7fedf3b7937d6e1cf","facility_id":"42dccd8f3ed22ca9a0a2abdd6319c68c","facility_service_report_id":"484f67b3eb1817da0a6d3a9b3e1fa195","facility_service_apply_id":"44cae6ca554e942a72bdaf856d39440f","facility_service_approval_id":"9affd1fbc8e4ec9cb9a0f436636119a4","facility_service_issue_id":"ef3b66664a4258a8da572e9e11468196","facility_service_reply_id":"9a048df2818b44763e06ab7438a04c11","employee_id":"86979a51f328e0bd264b026411bd000e","start_at":"2017-11-01 00:00:00","end_at":"2017-12-06 00:00:00","design_company":"智铁科技","construction_company":"智铁科技","supervisor_company":"智铁科技","contract_money":"100000.00","completion_plan":"/upload/completion/2017-10-12/33b814493fa113dbdde6054d4af49913.jpg","content":"实施_接口测试","pic_list":"[\"\\/upload\\/implement\\/2017-10-12\\/33b814493fa113dbdde6054d4af49913.jpg\",\"\\/upload\\/implement\\/2017-10-12\\/33b814493fa113dbdde6054d4af49913.jpg\"]","created_at":"2017-10-12 20:18:05","updated_at":"2017-10-12 20:18:05","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}}
         * facility_service_completion : {"id":"e334da53dc44988f9c730996a66f83b9","facility_id":"42dccd8f3ed22ca9a0a2abdd6319c68c","facility_service_report_id":"484f67b3eb1817da0a6d3a9b3e1fa195","facility_service_apply_id":"44cae6ca554e942a72bdaf856d39440f","facility_service_approval_id":"9affd1fbc8e4ec9cb9a0f436636119a4","facility_service_issue_id":"ef3b66664a4258a8da572e9e11468196","facility_service_reply_id":"9a048df2818b44763e06ab7438a04c11","facility_service_implement_id":"e6664bce3d0d09b7fedf3b7937d6e1cf","employee_id":"86979a51f328e0bd264b026411bd000e","actual_money":"100000.00","completion_report":"/upload/completion/2017-10-12/043d872f6d682a9360d2b296582df7d9.jpg","content":"接口测试接口测试接口测试接口测试接口测试接口测试接口测试","pic_list":"[\"\\/upload\\/completion\\/2017-10-12\\/07b91c8dcefc5241c45be569055f50ce.jpg\",\"\\/upload\\/completion\\/2017-10-12\\/6e32e937e5312c065e1eb0800432e2d7.jpg\"]","created_at":"2017-10-12 20:19:42","updated_at":"2017-10-12 20:19:42","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}}
         */

        private FacilityServiceApprovalBean facility_service_approval;
        private FacilityServiceIssueBean facility_service_issue;
        private FacilityServiceReplyBean facility_service_reply;
        private FacilityServiceImplementBean facility_service_implement;
        private FacilityServiceCompletionBean facility_service_completion;

        public FacilityServiceApprovalBean getFacility_service_approval() {
            return facility_service_approval;
        }

        public void setFacility_service_approval(FacilityServiceApprovalBean facility_service_approval) {
            this.facility_service_approval = facility_service_approval;
        }

        public FacilityServiceIssueBean getFacility_service_issue() {
            return facility_service_issue;
        }

        public void setFacility_service_issue(FacilityServiceIssueBean facility_service_issue) {
            this.facility_service_issue = facility_service_issue;
        }

        public FacilityServiceReplyBean getFacility_service_reply() {
            return facility_service_reply;
        }

        public void setFacility_service_reply(FacilityServiceReplyBean facility_service_reply) {
            this.facility_service_reply = facility_service_reply;
        }

        public FacilityServiceImplementBean getFacility_service_implement() {
            return facility_service_implement;
        }

        public void setFacility_service_implement(FacilityServiceImplementBean facility_service_implement) {
            this.facility_service_implement = facility_service_implement;
        }

        public FacilityServiceCompletionBean getFacility_service_completion() {
            return facility_service_completion;
        }

        public void setFacility_service_completion(FacilityServiceCompletionBean facility_service_completion) {
            this.facility_service_completion = facility_service_completion;
        }

        public static class FacilityServiceApprovalBean {
            /**
             * id : 9affd1fbc8e4ec9cb9a0f436636119a4
             * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
             * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
             * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
             * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
             * evaluate : 20.00
             * money : 20.00
             * created_at : 2017-10-12 18:19:51
             * updated_at : 2017-10-12 18:19:51
             * deleted_at : null
             * flag : 段
             * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"","duty":"64","role":5,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-10-09 19:05:41","deleted_at":null}
             */

            private String id;
            private String facility_id;
            private String facility_service_report_id;
            private String facility_service_apply_id;
            private String employee_id;
            private String evaluate;
            private String money;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String flag;
            private EmployeeBean employee;

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

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
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

            public String getEvaluate() {
                return evaluate;
            }

            public void setEvaluate(String evaluate) {
                this.evaluate = evaluate;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public EmployeeBean getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBean employee) {
                this.employee = employee;
            }

            public static class EmployeeBean {
                /**
                 * id : 3e8e3f1a802828f137dd9c1cd5ae205e
                 * mobile : 13000000005
                 * active : 1
                 * head :
                 * duty : 64
                 * role : 5
                 * idcard :
                 * name : 段长
                 * railway_id : 23cd931f4e6d162e10fe435e2a06933d
                 * section_id : a982d549217f04c3c063e247fb262cd7
                 * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
                 * work_area_id : ae445ad9baa0886e952c48ec32e134d8
                 * ip :
                 * created_at : 2017-10-09 15:51:41
                 * updated_at : 2017-10-09 19:05:41
                 * deleted_at : null
                 */

                private String id;
                private String mobile;
                private int active;
                private String head;
                private String duty;
                private int role;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

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

                public int getActive() {
                    return active;
                }

                public void setActive(int active) {
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

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
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

                public Object getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(Object deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }

        public static class FacilityServiceIssueBean {
            /**
             * id : ef3b66664a4258a8da572e9e11468196
             * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
             * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
             * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
             * facility_service_approval_id : 9affd1fbc8e4ec9cb9a0f436636119a4
             * employee_id : 6ea4425bd3b4b7e11fd5cc4c3b649381
             * plan_number : x01
             * cost_money : 10000.00
             * renovate_content : 下达_接口测试
             * created_at : 2017-10-12 20:13:01
             * updated_at : 2017-10-12 20:13:01
             * deleted_at : null
             * flag : 财
             * employee : {"id":"6ea4425bd3b4b7e11fd5cc4c3b649381","mobile":"13000000006","active":1,"head":"","duty":"64","role":6,"idcard":"","name":"财政所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:24","updated_at":"2017-10-09 15:52:24","deleted_at":null}
             */

            private String id;
            private String facility_id;
            private String facility_service_report_id;
            private String facility_service_apply_id;
            private String facility_service_approval_id;
            private String employee_id;
            private String plan_number;
            private String cost_money;
            private String renovate_content;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String flag;
            private EmployeeBeanX employee;

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

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
            }

            public String getFacility_service_apply_id() {
                return facility_service_apply_id;
            }

            public void setFacility_service_apply_id(String facility_service_apply_id) {
                this.facility_service_apply_id = facility_service_apply_id;
            }

            public String getFacility_service_approval_id() {
                return facility_service_approval_id;
            }

            public void setFacility_service_approval_id(String facility_service_approval_id) {
                this.facility_service_approval_id = facility_service_approval_id;
            }

            public String getEmployee_id() {
                return employee_id;
            }

            public void setEmployee_id(String employee_id) {
                this.employee_id = employee_id;
            }

            public String getPlan_number() {
                return plan_number;
            }

            public void setPlan_number(String plan_number) {
                this.plan_number = plan_number;
            }

            public String getCost_money() {
                return cost_money;
            }

            public void setCost_money(String cost_money) {
                this.cost_money = cost_money;
            }

            public String getRenovate_content() {
                return renovate_content;
            }

            public void setRenovate_content(String renovate_content) {
                this.renovate_content = renovate_content;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public EmployeeBeanX getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBeanX employee) {
                this.employee = employee;
            }

            public static class EmployeeBeanX {
                /**
                 * id : 6ea4425bd3b4b7e11fd5cc4c3b649381
                 * mobile : 13000000006
                 * active : 1
                 * head :
                 * duty : 64
                 * role : 6
                 * idcard :
                 * name : 财政所
                 * railway_id : 23cd931f4e6d162e10fe435e2a06933d
                 * section_id : a982d549217f04c3c063e247fb262cd7
                 * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
                 * work_area_id : ae445ad9baa0886e952c48ec32e134d8
                 * ip :
                 * created_at : 2017-10-09 15:52:24
                 * updated_at : 2017-10-09 15:52:24
                 * deleted_at : null
                 */

                private String id;
                private String mobile;
                private int active;
                private String head;
                private String duty;
                private int role;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

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

                public int getActive() {
                    return active;
                }

                public void setActive(int active) {
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

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
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

                public Object getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(Object deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }

        public static class FacilityServiceReplyBean {
            /**
             * id : 9a048df2818b44763e06ab7438a04c11
             * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
             * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
             * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
             * facility_service_approval_id : 9affd1fbc8e4ec9cb9a0f436636119a4
             * facility_service_issue_id : ef3b66664a4258a8da572e9e11468196
             * employee_id : 86979a51f328e0bd264b026411bd000e
             * reply_number : y01
             * reply_at : null
             * project_scope : 批复_接口测试
             * supervisor_money : 10000.00
             * construction_money : 10000.00
             * design_money : 10000.00
             * amount_money : 0.00
             * created_at : 2017-10-12 20:15:20
             * updated_at : 2017-10-12 20:15:20
             * deleted_at : null
             * flag : 概
             * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}
             */

            private String id;
            private String facility_id;
            private String facility_service_report_id;
            private String facility_service_apply_id;
            private String facility_service_approval_id;
            private String facility_service_issue_id;
            private String employee_id;
            private String reply_number;
            private String reply_at;
            private String project_scope;
            private String supervisor_money;
            private String construction_money;
            private String design_money;
            private String amount_money;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String flag;
            private EmployeeBeanXX employee;

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

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
            }

            public String getFacility_service_apply_id() {
                return facility_service_apply_id;
            }

            public void setFacility_service_apply_id(String facility_service_apply_id) {
                this.facility_service_apply_id = facility_service_apply_id;
            }

            public String getFacility_service_approval_id() {
                return facility_service_approval_id;
            }

            public void setFacility_service_approval_id(String facility_service_approval_id) {
                this.facility_service_approval_id = facility_service_approval_id;
            }

            public String getFacility_service_issue_id() {
                return facility_service_issue_id;
            }

            public void setFacility_service_issue_id(String facility_service_issue_id) {
                this.facility_service_issue_id = facility_service_issue_id;
            }

            public String getEmployee_id() {
                return employee_id;
            }

            public void setEmployee_id(String employee_id) {
                this.employee_id = employee_id;
            }

            public String getReply_number() {
                return reply_number;
            }

            public void setReply_number(String reply_number) {
                this.reply_number = reply_number;
            }

            public String getReply_at() {
                return reply_at;
            }

            public void setReply_at(String reply_at) {
                this.reply_at = reply_at;
            }

            public String getProject_scope() {
                return project_scope;
            }

            public void setProject_scope(String project_scope) {
                this.project_scope = project_scope;
            }

            public String getSupervisor_money() {
                return supervisor_money;
            }

            public void setSupervisor_money(String supervisor_money) {
                this.supervisor_money = supervisor_money;
            }

            public String getConstruction_money() {
                return construction_money;
            }

            public void setConstruction_money(String construction_money) {
                this.construction_money = construction_money;
            }

            public String getDesign_money() {
                return design_money;
            }

            public void setDesign_money(String design_money) {
                this.design_money = design_money;
            }

            public String getAmount_money() {
                return amount_money;
            }

            public void setAmount_money(String amount_money) {
                this.amount_money = amount_money;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public EmployeeBeanXX getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBeanXX employee) {
                this.employee = employee;
            }

            public static class EmployeeBeanXX {
                /**
                 * id : 86979a51f328e0bd264b026411bd000e
                 * mobile : 13000000007
                 * active : 1
                 * head :
                 * duty : 64
                 * role : 7
                 * idcard :
                 * name : 概算所
                 * railway_id : 23cd931f4e6d162e10fe435e2a06933d
                 * section_id : a982d549217f04c3c063e247fb262cd7
                 * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
                 * work_area_id : ae445ad9baa0886e952c48ec32e134d8
                 * ip :
                 * created_at : 2017-10-09 15:52:57
                 * updated_at : 2017-10-09 15:52:57
                 * deleted_at : null
                 */

                private String id;
                private String mobile;
                private int active;
                private String head;
                private String duty;
                private int role;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

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

                public int getActive() {
                    return active;
                }

                public void setActive(int active) {
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

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
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

                public Object getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(Object deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }

        public static class FacilityServiceImplementBean {
            /**
             * id : e6664bce3d0d09b7fedf3b7937d6e1cf
             * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
             * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
             * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
             * facility_service_approval_id : 9affd1fbc8e4ec9cb9a0f436636119a4
             * facility_service_issue_id : ef3b66664a4258a8da572e9e11468196
             * facility_service_reply_id : 9a048df2818b44763e06ab7438a04c11
             * employee_id : 86979a51f328e0bd264b026411bd000e
             * start_at : 2017-11-01 00:00:00
             * end_at : 2017-12-06 00:00:00
             * design_company : 智铁科技
             * construction_company : 智铁科技
             * supervisor_company : 智铁科技
             * contract_money : 100000.00
             * completion_plan : /upload/completion/2017-10-12/33b814493fa113dbdde6054d4af49913.jpg
             * content : 实施_接口测试
             * pic_list : ["\/upload\/implement\/2017-10-12\/33b814493fa113dbdde6054d4af49913.jpg","\/upload\/implement\/2017-10-12\/33b814493fa113dbdde6054d4af49913.jpg"]
             * created_at : 2017-10-12 20:18:05
             * updated_at : 2017-10-12 20:18:05
             * deleted_at : null
             * flag : 概
             * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}
             */

            private String id;
            private String facility_id;
            private String facility_service_report_id;
            private String facility_service_apply_id;
            private String facility_service_approval_id;
            private String facility_service_issue_id;
            private String facility_service_reply_id;
            private String employee_id;
            private String start_at;
            private String end_at;
            private String design_company;
            private String construction_company;
            private String supervisor_company;
            private String contract_money;
            private String completion_plan;
            private String content;
            private String pic_list;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String flag;
            private EmployeeBeanXXX employee;

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

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
            }

            public String getFacility_service_apply_id() {
                return facility_service_apply_id;
            }

            public void setFacility_service_apply_id(String facility_service_apply_id) {
                this.facility_service_apply_id = facility_service_apply_id;
            }

            public String getFacility_service_approval_id() {
                return facility_service_approval_id;
            }

            public void setFacility_service_approval_id(String facility_service_approval_id) {
                this.facility_service_approval_id = facility_service_approval_id;
            }

            public String getFacility_service_issue_id() {
                return facility_service_issue_id;
            }

            public void setFacility_service_issue_id(String facility_service_issue_id) {
                this.facility_service_issue_id = facility_service_issue_id;
            }

            public String getFacility_service_reply_id() {
                return facility_service_reply_id;
            }

            public void setFacility_service_reply_id(String facility_service_reply_id) {
                this.facility_service_reply_id = facility_service_reply_id;
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

            public String getDesign_company() {
                return design_company;
            }

            public void setDesign_company(String design_company) {
                this.design_company = design_company;
            }

            public String getConstruction_company() {
                return construction_company;
            }

            public void setConstruction_company(String construction_company) {
                this.construction_company = construction_company;
            }

            public String getSupervisor_company() {
                return supervisor_company;
            }

            public void setSupervisor_company(String supervisor_company) {
                this.supervisor_company = supervisor_company;
            }

            public String getContract_money() {
                return contract_money;
            }

            public void setContract_money(String contract_money) {
                this.contract_money = contract_money;
            }

            public String getCompletion_plan() {
                return completion_plan;
            }

            public void setCompletion_plan(String completion_plan) {
                this.completion_plan = completion_plan;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPic_list() {
                return pic_list;
            }

            public void setPic_list(String pic_list) {
                this.pic_list = pic_list;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public EmployeeBeanXXX getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBeanXXX employee) {
                this.employee = employee;
            }

            public static class EmployeeBeanXXX {
                /**
                 * id : 86979a51f328e0bd264b026411bd000e
                 * mobile : 13000000007
                 * active : 1
                 * head :
                 * duty : 64
                 * role : 7
                 * idcard :
                 * name : 概算所
                 * railway_id : 23cd931f4e6d162e10fe435e2a06933d
                 * section_id : a982d549217f04c3c063e247fb262cd7
                 * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
                 * work_area_id : ae445ad9baa0886e952c48ec32e134d8
                 * ip :
                 * created_at : 2017-10-09 15:52:57
                 * updated_at : 2017-10-09 15:52:57
                 * deleted_at : null
                 */

                private String id;
                private String mobile;
                private int active;
                private String head;
                private String duty;
                private int role;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

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

                public int getActive() {
                    return active;
                }

                public void setActive(int active) {
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

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
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

                public Object getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(Object deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }

        public static class FacilityServiceCompletionBean {
            /**
             * id : e334da53dc44988f9c730996a66f83b9
             * facility_id : 42dccd8f3ed22ca9a0a2abdd6319c68c
             * facility_service_report_id : 484f67b3eb1817da0a6d3a9b3e1fa195
             * facility_service_apply_id : 44cae6ca554e942a72bdaf856d39440f
             * facility_service_approval_id : 9affd1fbc8e4ec9cb9a0f436636119a4
             * facility_service_issue_id : ef3b66664a4258a8da572e9e11468196
             * facility_service_reply_id : 9a048df2818b44763e06ab7438a04c11
             * facility_service_implement_id : e6664bce3d0d09b7fedf3b7937d6e1cf
             * employee_id : 86979a51f328e0bd264b026411bd000e
             * actual_money : 100000.00
             * completion_report : /upload/completion/2017-10-12/043d872f6d682a9360d2b296582df7d9.jpg
             * content : 接口测试接口测试接口测试接口测试接口测试接口测试接口测试
             * pic_list : ["\/upload\/completion\/2017-10-12\/07b91c8dcefc5241c45be569055f50ce.jpg","\/upload\/completion\/2017-10-12\/6e32e937e5312c065e1eb0800432e2d7.jpg"]
             * created_at : 2017-10-12 20:19:42
             * updated_at : 2017-10-12 20:19:42
             * deleted_at : null
             * flag : 概
             * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"f37326274f1fc4c8c208b8df5d1f2bb3","work_area_id":"ae445ad9baa0886e952c48ec32e134d8","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-10-09 15:52:57","deleted_at":null}
             */

            private String id;
            private String facility_id;
            private String facility_service_report_id;
            private String facility_service_apply_id;
            private String facility_service_approval_id;
            private String facility_service_issue_id;
            private String facility_service_reply_id;
            private String facility_service_implement_id;
            private String employee_id;
            private String actual_money;
            private String completion_report;
            private String content;
            private String pic_list;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String flag;
            private EmployeeBeanXXXX employee;

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

            public String getFacility_service_report_id() {
                return facility_service_report_id;
            }

            public void setFacility_service_report_id(String facility_service_report_id) {
                this.facility_service_report_id = facility_service_report_id;
            }

            public String getFacility_service_apply_id() {
                return facility_service_apply_id;
            }

            public void setFacility_service_apply_id(String facility_service_apply_id) {
                this.facility_service_apply_id = facility_service_apply_id;
            }

            public String getFacility_service_approval_id() {
                return facility_service_approval_id;
            }

            public void setFacility_service_approval_id(String facility_service_approval_id) {
                this.facility_service_approval_id = facility_service_approval_id;
            }

            public String getFacility_service_issue_id() {
                return facility_service_issue_id;
            }

            public void setFacility_service_issue_id(String facility_service_issue_id) {
                this.facility_service_issue_id = facility_service_issue_id;
            }

            public String getFacility_service_reply_id() {
                return facility_service_reply_id;
            }

            public void setFacility_service_reply_id(String facility_service_reply_id) {
                this.facility_service_reply_id = facility_service_reply_id;
            }

            public String getFacility_service_implement_id() {
                return facility_service_implement_id;
            }

            public void setFacility_service_implement_id(String facility_service_implement_id) {
                this.facility_service_implement_id = facility_service_implement_id;
            }

            public String getEmployee_id() {
                return employee_id;
            }

            public void setEmployee_id(String employee_id) {
                this.employee_id = employee_id;
            }

            public String getActual_money() {
                return actual_money;
            }

            public void setActual_money(String actual_money) {
                this.actual_money = actual_money;
            }

            public String getCompletion_report() {
                return completion_report;
            }

            public void setCompletion_report(String completion_report) {
                this.completion_report = completion_report;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPic_list() {
                return pic_list;
            }

            public void setPic_list(String pic_list) {
                this.pic_list = pic_list;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public EmployeeBeanXXXX getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBeanXXXX employee) {
                this.employee = employee;
            }

            public static class EmployeeBeanXXXX {
                /**
                 * id : 86979a51f328e0bd264b026411bd000e
                 * mobile : 13000000007
                 * active : 1
                 * head :
                 * duty : 64
                 * role : 7
                 * idcard :
                 * name : 概算所
                 * railway_id : 23cd931f4e6d162e10fe435e2a06933d
                 * section_id : a982d549217f04c3c063e247fb262cd7
                 * workshop_id : f37326274f1fc4c8c208b8df5d1f2bb3
                 * work_area_id : ae445ad9baa0886e952c48ec32e134d8
                 * ip :
                 * created_at : 2017-10-09 15:52:57
                 * updated_at : 2017-10-09 15:52:57
                 * deleted_at : null
                 */

                private String id;
                private String mobile;
                private int active;
                private String head;
                private String duty;
                private int role;
                private String idcard;
                private String name;
                private String railway_id;
                private String section_id;
                private String workshop_id;
                private String work_area_id;
                private String ip;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

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

                public int getActive() {
                    return active;
                }

                public void setActive(int active) {
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

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
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

                public Object getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(Object deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }
}
