package com.zhitiekeji.equipmentmanagement.model;

import java.util.List;

/**
 * Created by zyz on 2018/1/13.
 */

public class RepairDetailModel {
    /**
     * batch_year : 1970
     * batch : 1
     * facility_service_report : [{"id":"3469af9ae1fc4ee4cf88ab2202322694","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","type":5,"status":1,"signature_pic":"/upload/sign/2018-01-12/8c5c9f9b8aaba8221201821ccacf346c.png","reason":"","money":"3759.00","created_at":"2018-01-12 19:10:04","updated_at":"2018-01-12 19:10:04","deleted_at":null,"employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":5,"role_description":4,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":null}},{"id":"45c72202a6cf8e648cfa73cb41d2f0b3","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"058cdb2c4ce5ed68f797c23c90cf02d0","type":3,"status":1,"signature_pic":"/upload/sign/2018-01-12/1bfce92cdf3673b383e1e5bf4f062e5e.png","reason":"","money":"3759.00","created_at":"2018-01-12 19:07:25","updated_at":"2018-01-12 19:07:25","deleted_at":null,"employee":{"id":"058cdb2c4ce5ed68f797c23c90cf02d0","mobile":"13000000003","active":1,"head":"","duty":"主任","role":3,"role_description":4,"idcard":"3567898024567893456789","name":"车间主任","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"","ip":"","created_at":"2017-10-09 15:50:24","updated_at":"2018-01-05 14:39:19","deleted_at":null}},{"id":"539b283beff5a9efc390b6c6fa68b69e","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"4399cb6e15ff03fedfd6794897e14081","type":4,"status":1,"signature_pic":"/upload/sign/2018-01-12/dbf3d3f2a442001df5c1e4f9b020e561.png","reason":"","money":"3759.00","created_at":"2018-01-12 19:08:30","updated_at":"2018-01-12 19:08:30","deleted_at":null,"employee":{"id":"4399cb6e15ff03fedfd6794897e14081","mobile":"13000000004","active":1,"head":"","duty":"64","role":4,"role_description":4,"idcard":"","name":"技术科","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:08","updated_at":"2017-10-09 15:51:08","deleted_at":null}},{"id":"a1743647aa5e63560ec77f28d8d09ec0","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"06b10a7dc1fe2ab2df430060f869c2a8","type":2,"status":1,"signature_pic":"/upload/sign/2018-01-12/d85baaab0d372e279c0ff77c94f7da86.png","reason":"","money":"3759.00","created_at":"2018-01-12 19:06:16","updated_at":"2018-01-12 19:06:16","deleted_at":null,"employee":{"id":"06b10a7dc1fe2ab2df430060f869c2a8","mobile":"13000000002","active":1,"head":"","duty":"64","role":2,"role_description":4,"idcard":"","name":"工区长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"233f9a9d6bfed3d171f8490a4ecdfe20","ip":"","created_at":"2017-10-09 15:49:07","updated_at":"2018-01-12 14:31:35","deleted_at":null}},{"id":"ddd50842dd5c9ec30e27d96c2fda40ae","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","type":1,"status":1,"signature_pic":"","reason":"","money":"3759.00","created_at":"2018-01-12 18:11:19","updated_at":"2018-01-12 18:11:19","deleted_at":null,"employee":{"id":"acdb6ef78389f6d67cafed76405cfbbc","mobile":"13000000001","active":1,"head":"","duty":"64","role":1,"role_description":1,"idcard":"123456784545645636363","name":"巡检工","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"233f9a9d6bfed3d171f8490a4ecdfe20","ip":"","created_at":"2017-10-09 15:48:06","updated_at":"2018-01-12 14:31:14","deleted_at":null}}]
     * facility_service_approval : {"id":"fc709015a11c09c24432f7b01872bea1","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","evaluate":"3759.00","money":"3759.00","created_at":"2018-01-12 19:10:04","updated_at":"2018-01-12 19:10:04","deleted_at":null,"flag":"段","employee":{"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":5,"role_description":4,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":null}}
     * facility_service_issue : {"id":"acb99ccb891c3bb860318fa97df4b019","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_approval_id":"fc709015a11c09c24432f7b01872bea1","employee_id":"6ea4425bd3b4b7e11fd5cc4c3b649381","plan_number":"134594646494","cost_money":"20000.00","renovate_content":"手机电脑倒计时开始","created_at":"2018-01-12 19:44:44","updated_at":"2018-01-12 19:44:44","deleted_at":null,"flag":"财","employee":{"id":"6ea4425bd3b4b7e11fd5cc4c3b649381","mobile":"13000000006","active":1,"head":"/upload/head/2017-11-03/52c495bd7c74ddfc430adea093335622.png","duty":"64","role":6,"role_description":4,"idcard":"","name":"财政所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:24","updated_at":"2017-12-08 09:33:02","deleted_at":null}}
     * facility_service_reply : {"id":"01b9b87ee5a27fda75eff3c3db2f23e0","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_approval_id":"fc709015a11c09c24432f7b01872bea1","facility_service_issue_id":"acb99ccb891c3bb860318fa97df4b019","employee_id":"86979a51f328e0bd264b026411bd000e","reply_number":"848454","reply_at":null,"project_scope":"vddvfbrb","supervisor_money":"4484.00","construction_money":"555.00","design_money":"555.00","amount_money":"5594.00","created_at":"2018-01-12 20:09:15","updated_at":"2018-01-12 20:09:15","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}}
     * facility_service_implement : {"id":"97bfe3f8f53d145b88ebf3d7e218f244","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_approval_id":"fc709015a11c09c24432f7b01872bea1","facility_service_issue_id":"acb99ccb891c3bb860318fa97df4b019","facility_service_reply_id":"01b9b87ee5a27fda75eff3c3db2f23e0","employee_id":"86979a51f328e0bd264b026411bd000e","start_at":"2018-01-12 00:00:00","end_at":"2018-12-01 00:00:00","design_company":"分E策划部恶鬼","construction_company":"对吧DVDv东北不大","supervisor_company":"呵呵呵呵","contract_money":"45555.00","completion_plan":"/upload/completion/2018-01-12/71190906fd6b0259e51d65e4f0be1911.pdf","content":"然后日本v都是v是v是v","pic_list":"[\"\\/upload\\/implement\\/2018-01-12\\/2b8937e485e863d9283fdbab1a8cab2d.png\",\"\\/upload\\/implement\\/2018-01-12\\/b9d6592bc96376b961bfe5993147d263.png\",\"\\/upload\\/implement\\/2018-01-12\\/d5cf5558779ea29a2c7bee1970799297.jpg\"]","created_at":"2018-01-12 20:12:43","updated_at":"2018-01-12 20:12:43","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}}
     * facility_service_completion : {"id":"f86f762d453fb30d9f12aea4825600c8","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_approval_id":"fc709015a11c09c24432f7b01872bea1","facility_service_issue_id":"acb99ccb891c3bb860318fa97df4b019","facility_service_reply_id":"01b9b87ee5a27fda75eff3c3db2f23e0","facility_service_implement_id":"97bfe3f8f53d145b88ebf3d7e218f244","employee_id":"86979a51f328e0bd264b026411bd000e","actual_money":"544555.00","completion_report":"/upload/completion/2018-01-12/287ba23a7982b914d08ef4c08585d9e7.png","content":"额v是v额v是v上班额红个","pic_list":"[\"\\/upload\\/completion\\/2018-01-12\\/b3a7a7d60d5d366e7783db53d0a0b008.jpg\",\"\\/upload\\/completion\\/2018-01-12\\/4f6544fc109e63a31ecc97eb8edcdd36.jpg\",\"\\/upload\\/completion\\/2018-01-12\\/8361124239426126dda9794df2b00fd8.jpg\"]","created_at":"2018-01-12 20:14:07","updated_at":"2018-01-12 20:14:07","deleted_at":null,"flag":"概","employee":{"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}}
     * facility_disease : [{"id":"653167f2e54c000c603bf6eeb98a1152","facility_disease_repair_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_disease_type_id":"806e1c73d17d1257ad808cb860138d7b","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_disease_valuation_id":"726d96b09927bf2f1c8e76182e7530ef","price":"21.00","amount_money":"651.00","title":"","degree":3,"area":31,"pic_list":null,"description":"分解机健康卡","finalize":1,"facility_skill_type":2,"created_at":"2018-01-12 15:09:58","updated_at":"2018-01-12 19:10:04","deleted_at":null,"facility_disease_type":{"id":"806e1c73d17d1257ad808cb860138d7b","title":"其他破损","created_at":"2017-11-30 14:52:30","updated_at":"2017-11-30 14:52:30","deleted_at":null}},{"id":"80f37ca9f583b210fc6ac09d73bd2be2","facility_disease_repair_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_disease_type_id":"806e1c73d17d1257ad808cb860138d7b","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_disease_valuation_id":"726d96b09927bf2f1c8e76182e7530ef","price":"21.00","amount_money":"378.00","title":"","degree":3,"area":18,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/49d9dd74c690435152b0c494afb38bc3.jpg\",\"\\/upload\\/facility-disease\\/2018-01-12\\/63eec4ea3101090e5bc5e20736382bdc.png\",\"\\/upload\\/facility-disease\\/2018-01-12\\/42564db487e354879fed552759c63295.png\"]","description":"上图恶徒号","finalize":1,"facility_skill_type":2,"created_at":"2018-01-12 18:11:13","updated_at":"2018-01-12 19:10:04","deleted_at":null,"facility_disease_type":{"id":"806e1c73d17d1257ad808cb860138d7b","title":"其他破损","created_at":"2017-11-30 14:52:30","updated_at":"2017-11-30 14:52:30","deleted_at":null}},{"id":"d0816bda84726d68360a1e2d4470c850","facility_disease_repair_id":"","employee_id":"3e8e3f1a802828f137dd9c1cd5ae205e","facility_id":"5228d7441ae36536934ab6abe7dcdb28","facility_disease_type_id":"806e1c73d17d1257ad808cb860138d7b","facility_service_apply_id":"e32f0228cf649154a613c5c2e2f825a8","facility_service_report_id":"3469af9ae1fc4ee4cf88ab2202322694","facility_disease_valuation_id":"b19a1cc155e5e66d5dfe6879e634b386","price":"91.00","amount_money":"2730.00","title":"","degree":1,"area":30,"pic_list":"[\"\\/upload\\/facility-disease\\/2018-01-12\\/4be9135035b1bca95745ebf16a1a3d3c.jpg\",\"\\/upload\\/facility-disease\\/2018-01-12\\/2779423f321c8e1f72ac96922863a924.jpg\"]","description":"动感地带","finalize":1,"facility_skill_type":2,"created_at":"2018-01-12 14:41:47","updated_at":"2018-01-12 19:10:04","deleted_at":null,"facility_disease_type":{"id":"806e1c73d17d1257ad808cb860138d7b","title":"其他破损","created_at":"2017-11-30 14:52:30","updated_at":"2017-11-30 14:52:30","deleted_at":null}}]
     * facility : {"id":"5228d7441ae36536934ab6abe7dcdb28","employee_id":"acdb6ef78389f6d67cafed76405cfbbc","user_id":"94dd2a7cecb2580f30807a98c218be94","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"233f9a9d6bfed3d171f8490a4ecdfe20","station_id":"32a83921ea1add7aecf4f1f39c5359bf","company_id":"a87e460d7c6cde3edf093ba3ba9255e3","type":2,"skill_type":2,"is_urgent":0,"title":"小南海车务段食堂堡坎","number":"CY5500055-1","pic1":"/upload/facility/2018-01-13/2a95f86bb77a407b33e913af67a42411.png","pic2":"/upload/facility/2018-01-13/a1e280c96dcd0ea10bd871e3bb4e7695.png","pic3":"/upload/facility/2018-01-13/77ba1e8d678571936d8141c341ff5d69.png","area":0,"use_age":0,"addr":"中国重庆市南岸区南坪区府美食街惠工路14号","annual":1,"longitude":"106.571424","latitude":"29.534464","status":2,"reason":"","last_small_service_at":"2018-01-12 18:18:22","last_mid_service_at":"2018-01-12 20:14:07","last_big_service_at":null,"created_at":"2018-01-12 13:12:55","updated_at":"2018-01-13 10:51:09","deleted_at":null,"extra_json":null,"line":"成渝线","remark":"","use_status":1,"ha_total":"","house_area":"","attached_area":"","structure":"条石","floor":"","build_age":"1987","roof_form":"","roof_area":"","use_nature":4,"category":3,"structures_unit":"m2","structures_quantity":"230","structures_area":"23.0","take_over":2,"is_inspect":2,"minor":"请检修-完成","minor_updated_at":"2018-01-12","mid":"综合维修-竣工","mid_updated_at":"2018-01-12","big":"大修-批复","big_updated_at":"2018-01-12","section":{"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null},"workshop":{"id":"ce3b156d82d6f8eef15e1e7d16b89776","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆","longitude":"106.722386","latitude":"29.834357","facility_count":7,"created_at":"2017-10-13 14:02:26","updated_at":"2018-01-13 10:51:09","deleted_at":null},"work_area":{"id":"233f9a9d6bfed3d171f8490a4ecdfe20","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","title":"重庆南工区","longitude":"106.571406","latitude":"29.534452","facility_count":2,"created_at":"2018-01-08 16:01:59","updated_at":"2018-01-13 10:51:09","deleted_at":null},"station":{"id":"32a83921ea1add7aecf4f1f39c5359bf","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"233f9a9d6bfed3d171f8490a4ecdfe20","title":"小南海","map_path":"","created_at":"2018-01-08 17:28:20","updated_at":"2018-01-08 17:28:20","deleted_at":null}}
     */

    private String batch_year;
    private int batch;
    private FacilityServiceApprovalBean facility_service_approval;
    private FacilityServiceIssueBean facility_service_issue;
    private FacilityServiceReplyBean facility_service_reply;
    private FacilityServiceImplementBean facility_service_implement;
    private FacilityServiceCompletionBean facility_service_completion;
    private FacilityBean facility;
    private List<FacilityServiceReportBean> facility_service_report;
    private List<FacilityDiseaseBean> facility_disease;

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

    public FacilityBean getFacility() {
        return facility;
    }

    public void setFacility(FacilityBean facility) {
        this.facility = facility;
    }

    public List<FacilityServiceReportBean> getFacility_service_report() {
        return facility_service_report;
    }

    public void setFacility_service_report(List<FacilityServiceReportBean> facility_service_report) {
        this.facility_service_report = facility_service_report;
    }

    public List<FacilityDiseaseBean> getFacility_disease() {
        return facility_disease;
    }

    public void setFacility_disease(List<FacilityDiseaseBean> facility_disease) {
        this.facility_disease = facility_disease;
    }

    public static class FacilityServiceApprovalBean {
        /**
         * id : fc709015a11c09c24432f7b01872bea1
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * evaluate : 3759.00
         * money : 3759.00
         * created_at : 2018-01-12 19:10:04
         * updated_at : 2018-01-12 19:10:04
         * deleted_at : null
         * flag : 段
         * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":5,"role_description":4,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":null}
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
             * head : /upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png
             * duty : 64
             * role : 5
             * role_description : 4
             * idcard :
             * name : 段长
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:51:41
             * updated_at : 2017-11-21 11:32:50
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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
         * id : acb99ccb891c3bb860318fa97df4b019
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * facility_service_approval_id : fc709015a11c09c24432f7b01872bea1
         * employee_id : 6ea4425bd3b4b7e11fd5cc4c3b649381
         * plan_number : 134594646494
         * cost_money : 20000.00
         * renovate_content : 手机电脑倒计时开始
         * created_at : 2018-01-12 19:44:44
         * updated_at : 2018-01-12 19:44:44
         * deleted_at : null
         * flag : 财
         * employee : {"id":"6ea4425bd3b4b7e11fd5cc4c3b649381","mobile":"13000000006","active":1,"head":"/upload/head/2017-11-03/52c495bd7c74ddfc430adea093335622.png","duty":"64","role":6,"role_description":4,"idcard":"","name":"财政所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:24","updated_at":"2017-12-08 09:33:02","deleted_at":null}
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
             * head : /upload/head/2017-11-03/52c495bd7c74ddfc430adea093335622.png
             * duty : 64
             * role : 6
             * role_description : 4
             * idcard :
             * name : 财政所
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id :
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:52:24
             * updated_at : 2017-12-08 09:33:02
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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
         * id : 01b9b87ee5a27fda75eff3c3db2f23e0
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * facility_service_approval_id : fc709015a11c09c24432f7b01872bea1
         * facility_service_issue_id : acb99ccb891c3bb860318fa97df4b019
         * employee_id : 86979a51f328e0bd264b026411bd000e
         * reply_number : 848454
         * reply_at : null
         * project_scope : vddvfbrb
         * supervisor_money : 4484.00
         * construction_money : 555.00
         * design_money : 555.00
         * amount_money : 5594.00
         * created_at : 2018-01-12 20:09:15
         * updated_at : 2018-01-12 20:09:15
         * deleted_at : null
         * flag : 概
         * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}
         */

        private String id;
        private String facility_id;
        private String facility_service_report_id;
        private String facility_service_apply_id;
        private String facility_service_approval_id;
        private String facility_service_issue_id;
        private String employee_id;
        private String reply_number;
        private Object reply_at;
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

        public Object getReply_at() {
            return reply_at;
        }

        public void setReply_at(Object reply_at) {
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
             * role_description : 4
             * idcard :
             * name : 概算所
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id :
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:52:57
             * updated_at : 2017-12-08 09:33:27
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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
         * id : 97bfe3f8f53d145b88ebf3d7e218f244
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * facility_service_approval_id : fc709015a11c09c24432f7b01872bea1
         * facility_service_issue_id : acb99ccb891c3bb860318fa97df4b019
         * facility_service_reply_id : 01b9b87ee5a27fda75eff3c3db2f23e0
         * employee_id : 86979a51f328e0bd264b026411bd000e
         * start_at : 2018-01-12 00:00:00
         * end_at : 2018-12-01 00:00:00
         * design_company : 分E策划部恶鬼
         * construction_company : 对吧DVDv东北不大
         * supervisor_company : 呵呵呵呵
         * contract_money : 45555.00
         * completion_plan : /upload/completion/2018-01-12/71190906fd6b0259e51d65e4f0be1911.pdf
         * content : 然后日本v都是v是v是v
         * pic_list : ["\/upload\/implement\/2018-01-12\/2b8937e485e863d9283fdbab1a8cab2d.png","\/upload\/implement\/2018-01-12\/b9d6592bc96376b961bfe5993147d263.png","\/upload\/implement\/2018-01-12\/d5cf5558779ea29a2c7bee1970799297.jpg"]
         * created_at : 2018-01-12 20:12:43
         * updated_at : 2018-01-12 20:12:43
         * deleted_at : null
         * flag : 概
         * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}
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
             * role_description : 4
             * idcard :
             * name : 概算所
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id :
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:52:57
             * updated_at : 2017-12-08 09:33:27
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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
         * id : f86f762d453fb30d9f12aea4825600c8
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * facility_service_approval_id : fc709015a11c09c24432f7b01872bea1
         * facility_service_issue_id : acb99ccb891c3bb860318fa97df4b019
         * facility_service_reply_id : 01b9b87ee5a27fda75eff3c3db2f23e0
         * facility_service_implement_id : 97bfe3f8f53d145b88ebf3d7e218f244
         * employee_id : 86979a51f328e0bd264b026411bd000e
         * actual_money : 544555.00
         * completion_report : /upload/completion/2018-01-12/287ba23a7982b914d08ef4c08585d9e7.png
         * content : 额v是v额v是v上班额红个
         * pic_list : ["\/upload\/completion\/2018-01-12\/b3a7a7d60d5d366e7783db53d0a0b008.jpg","\/upload\/completion\/2018-01-12\/4f6544fc109e63a31ecc97eb8edcdd36.jpg","\/upload\/completion\/2018-01-12\/8361124239426126dda9794df2b00fd8.jpg"]
         * created_at : 2018-01-12 20:14:07
         * updated_at : 2018-01-12 20:14:07
         * deleted_at : null
         * flag : 概
         * employee : {"id":"86979a51f328e0bd264b026411bd000e","mobile":"13000000007","active":1,"head":"","duty":"64","role":7,"role_description":4,"idcard":"","name":"概算所","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:52:57","updated_at":"2017-12-08 09:33:27","deleted_at":null}
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
             * role_description : 4
             * idcard :
             * name : 概算所
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id :
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:52:57
             * updated_at : 2017-12-08 09:33:27
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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

    public static class FacilityBean {
        /**
         * id : 5228d7441ae36536934ab6abe7dcdb28
         * employee_id : acdb6ef78389f6d67cafed76405cfbbc
         * user_id : 94dd2a7cecb2580f30807a98c218be94
         * railway_id : 23cd931f4e6d162e10fe435e2a06933d
         * section_id : a982d549217f04c3c063e247fb262cd7
         * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
         * work_area_id : 233f9a9d6bfed3d171f8490a4ecdfe20
         * station_id : 32a83921ea1add7aecf4f1f39c5359bf
         * company_id : a87e460d7c6cde3edf093ba3ba9255e3
         * type : 2
         * skill_type : 2
         * is_urgent : 0
         * title : 小南海车务段食堂堡坎
         * number : CY5500055-1
         * pic1 : /upload/facility/2018-01-13/2a95f86bb77a407b33e913af67a42411.png
         * pic2 : /upload/facility/2018-01-13/a1e280c96dcd0ea10bd871e3bb4e7695.png
         * pic3 : /upload/facility/2018-01-13/77ba1e8d678571936d8141c341ff5d69.png
         * area : 0
         * use_age : 0
         * addr : 中国重庆市南岸区南坪区府美食街惠工路14号
         * annual : 1
         * longitude : 106.571424
         * latitude : 29.534464
         * status : 2
         * reason :
         * last_small_service_at : 2018-01-12 18:18:22
         * last_mid_service_at : 2018-01-12 20:14:07
         * last_big_service_at : null
         * created_at : 2018-01-12 13:12:55
         * updated_at : 2018-01-13 10:51:09
         * deleted_at : null
         * extra_json : null
         * line : 成渝线
         * remark :
         * use_status : 1
         * ha_total :
         * house_area :
         * attached_area :
         * structure : 条石
         * floor :
         * build_age : 1987
         * roof_form :
         * roof_area :
         * use_nature : 4
         * category : 3
         * structures_unit : m2
         * structures_quantity : 230
         * structures_area : 23.0
         * take_over : 2
         * is_inspect : 2
         * minor : 请检修-完成
         * minor_updated_at : 2018-01-12
         * mid : 综合维修-竣工
         * mid_updated_at : 2018-01-12
         * big : 大修-批复
         * big_updated_at : 2018-01-12
         * section : {"id":"a982d549217f04c3c063e247fb262cd7","railway_id":"23cd931f4e6d162e10fe435e2a06933d","title":"重庆","longitude":"106.571387","latitude":"29.534466","created_at":"2017-10-09 15:44:15","updated_at":"2017-10-23 14:10:01","deleted_at":null}
         * workshop : {"id":"ce3b156d82d6f8eef15e1e7d16b89776","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","title":"重庆","longitude":"106.722386","latitude":"29.834357","facility_count":7,"created_at":"2017-10-13 14:02:26","updated_at":"2018-01-13 10:51:09","deleted_at":null}
         * work_area : {"id":"233f9a9d6bfed3d171f8490a4ecdfe20","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","title":"重庆南工区","longitude":"106.571406","latitude":"29.534452","facility_count":2,"created_at":"2018-01-08 16:01:59","updated_at":"2018-01-13 10:51:09","deleted_at":null}
         * station : {"id":"32a83921ea1add7aecf4f1f39c5359bf","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"ce3b156d82d6f8eef15e1e7d16b89776","work_area_id":"233f9a9d6bfed3d171f8490a4ecdfe20","title":"小南海","map_path":"","created_at":"2018-01-08 17:28:20","updated_at":"2018-01-08 17:28:20","deleted_at":null}
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
        private int take_over;
        private int is_inspect;
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
             * title : 重庆
             * longitude : 106.722386
             * latitude : 29.834357
             * facility_count : 7
             * created_at : 2017-10-13 14:02:26
             * updated_at : 2018-01-13 10:51:09
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
             * id : 233f9a9d6bfed3d171f8490a4ecdfe20
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
             * title : 重庆南工区
             * longitude : 106.571406
             * latitude : 29.534452
             * facility_count : 2
             * created_at : 2018-01-08 16:01:59
             * updated_at : 2018-01-13 10:51:09
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
             * id : 32a83921ea1add7aecf4f1f39c5359bf
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id : ce3b156d82d6f8eef15e1e7d16b89776
             * work_area_id : 233f9a9d6bfed3d171f8490a4ecdfe20
             * title : 小南海
             * map_path :
             * created_at : 2018-01-08 17:28:20
             * updated_at : 2018-01-08 17:28:20
             * deleted_at : null
             */

            private String id;
            private String railway_id;
            private String section_id;
            private String workshop_id;
            private String work_area_id;
            private String title;
            private String map_path;
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
        }
    }

    public static class FacilityServiceReportBean {
        /**
         * id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * type : 5
         * status : 1
         * signature_pic : /upload/sign/2018-01-12/8c5c9f9b8aaba8221201821ccacf346c.png
         * reason :
         * money : 3759.00
         * created_at : 2018-01-12 19:10:04
         * updated_at : 2018-01-12 19:10:04
         * deleted_at : null
         * employee : {"id":"3e8e3f1a802828f137dd9c1cd5ae205e","mobile":"13000000005","active":1,"head":"/upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png","duty":"64","role":5,"role_description":4,"idcard":"","name":"段长","railway_id":"23cd931f4e6d162e10fe435e2a06933d","section_id":"a982d549217f04c3c063e247fb262cd7","workshop_id":"","work_area_id":"","ip":"","created_at":"2017-10-09 15:51:41","updated_at":"2017-11-21 11:32:50","deleted_at":null}
         */

        private String id;
        private String facility_id;
        private String facility_service_apply_id;
        private String employee_id;
        private int type;
        private int status;
        private String signature_pic;
        private String reason;
        private String money;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private EmployeeBeanXXXXX employee;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSignature_pic() {
            return signature_pic;
        }

        public void setSignature_pic(String signature_pic) {
            this.signature_pic = signature_pic;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
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

        public EmployeeBeanXXXXX getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBeanXXXXX employee) {
            this.employee = employee;
        }

        public static class EmployeeBeanXXXXX {
            /**
             * id : 3e8e3f1a802828f137dd9c1cd5ae205e
             * mobile : 13000000005
             * active : 1
             * head : /upload/head/2017-11-21/cf1774997ea58a7a2ba5cc9e70b34356.png
             * duty : 64
             * role : 5
             * role_description : 4
             * idcard :
             * name : 段长
             * railway_id : 23cd931f4e6d162e10fe435e2a06933d
             * section_id : a982d549217f04c3c063e247fb262cd7
             * workshop_id :
             * work_area_id :
             * ip :
             * created_at : 2017-10-09 15:51:41
             * updated_at : 2017-11-21 11:32:50
             * deleted_at : null
             */

            private String id;
            private String mobile;
            private int active;
            private String head;
            private String duty;
            private int role;
            private int role_description;
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

            public int getRole_description() {
                return role_description;
            }

            public void setRole_description(int role_description) {
                this.role_description = role_description;
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

    public static class FacilityDiseaseBean {
        /**
         * id : 653167f2e54c000c603bf6eeb98a1152
         * facility_disease_repair_id :
         * employee_id : 3e8e3f1a802828f137dd9c1cd5ae205e
         * facility_id : 5228d7441ae36536934ab6abe7dcdb28
         * facility_disease_type_id : 806e1c73d17d1257ad808cb860138d7b
         * facility_service_apply_id : e32f0228cf649154a613c5c2e2f825a8
         * facility_service_report_id : 3469af9ae1fc4ee4cf88ab2202322694
         * facility_disease_valuation_id : 726d96b09927bf2f1c8e76182e7530ef
         * price : 21.00
         * amount_money : 651.00
         * title :
         * degree : 3
         * area : 31
         * pic_list : null
         * description : 分解机健康卡
         * finalize : 1
         * facility_skill_type : 2
         * created_at : 2018-01-12 15:09:58
         * updated_at : 2018-01-12 19:10:04
         * deleted_at : null
         * facility_disease_type : {"id":"806e1c73d17d1257ad808cb860138d7b","title":"其他破损","created_at":"2017-11-30 14:52:30","updated_at":"2017-11-30 14:52:30","deleted_at":null}
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
             * id : 806e1c73d17d1257ad808cb860138d7b
             * title : 其他破损
             * created_at : 2017-11-30 14:52:30
             * updated_at : 2017-11-30 14:52:30
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
