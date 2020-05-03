package com.zhitiekeji.equipmentmanagement.net;

/**
 * URL路径处理类
 */
public class URLs {
    public static final String HOST = "http://app.zhitiekeji.com";//重庆
//    public static final String HOST = "http://gyd.zhitiekeji.com";//贵阳


//        public static final String HOST = "http://192.168.0.108";
//    public static final String HOST = "http://20499qo155.imwork.net:42604";

    public static final String PROJECT_NAME = "";
    public static final String API = "";

    // 用户模块
    /**
     * 注册-普通用户
     */
    public static final String Registered = HOST + "/api/member/register";
    /**
     * 注册-发送验证码
     */
    public static final String RegisteredCode = HOST + "/api/member/send-code";
    /**
     * 登录
     */
    public static final String USER_SIGNIN = HOST + "/api/login";
    /**
     * 找回密码-发送验证码
     */
    public static final String ForgetCode = HOST + "/api/send-code";
    /**
     * 找回密码
     */
    public static final String ForgetPassword = HOST + "/api/reset-password";
    /**
     * 修改密码
     */
    public static final String ChangePassword = HOST + "/api/update-password";
    /**
     * 普通用户上传病害
     */
    public static final String AddDisease_ReportPerson = HOST + "/api/publish-disease/create";
    /**
     * 普通用户-病害列表
     */
    public static final String ReportPersonDiseaseList = HOST + "/api/publish-disease";

    /**
     * 用户详情
     */
    public static final String USER_DETAIL = HOST + "/api/employee/detail";
    /**
     * 修改头像
     */
    public static final String ChangeProfile = HOST + "/api/employee/chang-head-img";
    /**
     * 留言反馈
     */
    public static final String USER_FEEDBACK = HOST + "/api/suggestion/create";
    /**
     * 更新
     */
    public static final String Upgrade = HOST + "/api/version-update";

    //设备模块
    /**
     * 区域列表-车间
     */
    public static final String AREA_LIST1 = HOST + "/api/workshop";
    /**
     * 区域列表-工区
     */
    public static final String AREA_LIST2 = HOST + "/api/work-area";
    /**
     * 区域列表-站区
     */
    public static final String AREA_LIST3 = HOST + "/api/station";
    /**
     * 单位列表
     */
    public static final String UNIT_LIST = HOST + "/api/company";
    /**
     * 添加设备
     */
    public static final String EQUIPMENT_ADD = HOST + "/api/facility/create";
    /**
     * 地图模式-设备地图
     */
    public static final String EQUIPMENT_MAP = HOST + "/api/facility/map";
    /**
     * 地图模式-设备地图_详细
     */
    public static final String EQUIPMENT_MAP_Detail = HOST + "/api/facility/detail-coordinate";
    /**
     * 设备列表
     */
    public static final String EQUIPMENT_LIST = HOST + "/api/facility";
    /**
     * 设备详情
     */
    public static final String EQUIPMENT_DETAIL = HOST + "/api/facility/detail";
    /**
     * * 设备type
     */
    public static final String EQUIPMENT_TYPE = HOST + "/api/facility/facility-type";
    /**
     * 设备详情-维修记录
     */
    public static final String EQUIPMENT_Maintain = HOST + "/api/facility-service-apply";
    /**
     * 设备详情-检查能否巡检
     */
    public static final String EQUIPMENT_Check = HOST + "/api/facility/inspect";
    /**
     * 设备详情-巡检记录
     */
    public static final String EQUIPMENT_INSPECTION = HOST + "/api/facility-inspect";
    /**
     * 设备详情-巡检
     */
    public static final String EQUIPMENT_CHECK = HOST + "/api/facility-inspect/create";


    /**
     * 发布病害-检查是否存在未提交的设备维修申请-获取设备维修申请id
     */
    public static final String Disease_Check = HOST + "/api/facility-service-apply/check";
    /**
     * 发布病害-病害种类
     */
    public static final String Disease_type = HOST + "/api/facility-disease-type";
    /**
     * 发布病害
     */
    public static final String AddDisease = HOST + "/api/facility-disease/create";
    /**
     * 发布病害-病害列表
     */
    public static final String Disease_List = HOST + "/api/facility-disease";
    /**
     * 发布病害-删除病害
     */
    public static final String Disease_Delete = HOST + "/api/facility-disease/delete";
    /**
     * 发布病害-提交设备维修申请
     */
    public static final String Disease_UpData = HOST + "/api/facility-service-apply/submit";
    /**
     * 发布病害-提交设备维修申请-短信通知相关负责人
     */
    public static final String Disease_NoticeList = HOST + "/api/facility-service-apply/inform";

    /**
     * 细部明细
     */
    public static final String DetailedDetails = HOST + "/api/facility-detail";
    /**
     * 细部明细-分类
     */
    public static final String DetailedDetails_type = HOST + "/api/facility-detail-type";
    /**
     * 细部明细-添加
     */
    public static final String DetailedDetails_add = HOST + "/api/facility-detail/create";
    /**
     * 细部明细-删除
     */
    public static final String DetailedDetails_delete = HOST + "/api/facility-detail/delete";
    //管理模块
    /**
     * 完善请检修资料
     */
    public static final String MANAGEMENT_ADDOVERHAU = HOST + "/api/facility-service-minor/update";
    /**
     * 请检修列表-内部
     */
    public static final String MANAGEMENT_OVERHAULLIST = HOST + "/api/facility-service-minor";
    /**
     * 请检修详情-内部
     */
    public static final String MANAGEMENT_OVERHAULDETAIL = HOST + "/api/facility-service-minor/detail";
    /**
     * 请检修列表-劳务
     */
    public static final String MANAGEMENT_OVERHAULLIST1 = HOST + "/api/facility-service-minor/labour";
    /**
     * 请检修列表-个人中心
     */
    public static final String MANAGEMENT_OVERHAULLIST2 = HOST + "/api/facility-service-minor/my";

    /**
     * 材料种类
     */
    public static final String MANAGEMENT_Material = HOST + "/api/material";

    /**
     * 病害详情
     */
    public static final String MANAGEMENT_DISEASEDETAIL = HOST + "/api/facility-disease/detail";
    /**
     * 修复病害
     */
    public static final String MANAGEMENT_RepairDISEASE = HOST + "/api/facility-disease-repair/create";

    /**
     * 上报列表
     */
    public static final String MANAGEMENT_REPORTEDLIST = HOST + "/api/facility-service-approval";
    /**
     * 上报详情
     */
    public static final String MANAGEMENT_REPORTDETAIL = HOST + "/api/facility-service-approval/detail";
    /**
     * 删除上报记录
     */
    public static final String MANAGEMENT_REPORTDETAIL_DETAIL = HOST + "/api/facility-service-issue/delete";
    /**
     * 下达发布
     */
    public static final String MANAGEMENT_AddReplyPlan = HOST + "/api/facility-service-issue/create";

    /**
     * 下达列表
     */
    public static final String MANAGEMENT_GIVELIST = HOST + "/api/facility-service-issue";
    /**
     * 下达详情
     */
    public static final String MANAGEMENT_GIVEDETAIL = HOST + "/api/facility-service-issue/detail";
    /**
     * 批复发布
     */
    public static final String MANAGEMENT_AddReplyImplementation = HOST + "/api/facility-service-reply/create";

    /**
     * 批复列表
     */
    public static final String MANAGEMENT_REPLYLIST = HOST + "/api/facility-service-reply";
    /**
     * 批复详情
     */
    public static final String MANAGEMENT_REPLYDETAIL = HOST + "/api/facility-service-reply/detail";
    /**
     * 实施发布
     */
    public static final String MANAGEMENT_AddImplementationPlan = HOST + "/api/facility-service-implement/create";

    /**
     * 实施列表
     */
    public static final String MANAGEMENT_BUILDRECORDLIST = HOST + "/api/facility-service-implement";
    /**
     * 实施详情
     */
    public static final String MANAGEMENT_BUILDRECORDDETAIL = HOST + "/api/facility-service-implement/detail";
    /**
     * 竣工发布
     */
    public static final String MANAGEMENT_AddCalendarYear = HOST + "/api/facility-service-completion/create";

    /**
     * 竣工列表
     */
    public static final String MANAGEMENT_BUILDENDLIST = HOST + "/api/facility-service-completion";
    /**
     * 竣工详情
     */
    public static final String MANAGEMENT_BUILDENDDETAIL = HOST + "/api/facility-service-completion/detail";

    //我的
    /**
     * 我发布的设备
     */
    public static final String MyPublishingDevice = HOST + "/api/facility/my";
    /**
     * 我的上报
     */
    public static final String MyReport = HOST + "/api/facility-service-apply/my";
    /**
     * 再次提交申请
     */
    public static final String AgainReport = HOST + "/api/facility-service-apply/apply";
    /**
     * 我的上报详情
     */
    public static final String MyReportDetail = HOST + "/api/facility-service-apply/detail";
    /**
     * 我的审核-报审记录
     */
    public static final String RetaliationRecord = HOST + "/api/facility-service-apply/report";
    /**
     * 我的审核-修复结果
     */
    public static final String RepairResults = HOST + "/api/facility-service-apply/completion-detail";
    /**
     * 我的审核
     */
    public static final String MyAudit = HOST + "/api/facility-service-apply/audit-list";
    /**
     * 同意审核
     */
    public static final String AgreeAudit = HOST + "/api/facility-service-apply/audit";
    /**
     * 删除病害
     */
    public static final String DeleteDisease = HOST + "/api/facility-disease/delete";
    /**
     * 同意审核-批量
     */
    public static final String AgreeAudit1 = HOST + "/api/facility-service-apply/audit-batch";

    /**
     * 用户反馈的病害列表
     */
    public static final String CustomerFeedbackDiseaseList = HOST + "/api/publish-disease/wait";

    /**
     * 更改请检修资料
     */
    public static final String MANAGEMENT_ADDOVERHAU_Change = HOST + "/api/facility-service-minor/update";

    /**
     * 帮助中心
     */
    public static final String HELPLIST = HOST + "/api/help";

    /**
     * 施工计划
     */
    public static final String ConstructionPlan = HOST + "/api/construction";
    /**
     * 施工计划详情
     */
    public static final String ConstructionPlanDetail = HOST + "/api/construction/detail";

    /**
     * 修改设置极光推送别名的状态
     */
    public static final String ChangeJpish = HOST + "/api/employee/chang-jpush";

    /**
     * 员工管理
     */
    public static final String StaffManagement = HOST + "/api/employee";
    /**
     * 员工管理详情
     */
    public static final String StaffManagementDetail = HOST + "/api/facility-inspect/inspect";
    /**
     * 党员小书包
     */
    public static final String SchoolBag = HOST + "/api/chapbook";
    /**
     * 增加阅读量
     */
    public static final String SchoolBag_read = HOST + "/api/chapbook/read";

    //统计模块
    /**
     * 年份
     */
    public static final String YearList = HOST + "/api/statistic/get-year";
    /**
     * 车间统计列表
     */
    public static final String WorkShopList = HOST + "/api/statistic/workshop-statistic";
    /**
     * 工区统计列表
     */
    public static final String WorkAreaList = HOST + "/api/statistic/work-area-statistic";
    /**
     * 个人统计列表
     */
    public static final String WorkPersonalList = HOST + "/api/statistic/employee-statistic";
    /**
     * 统计详情
     */
    public static final String WorkDetail = HOST + "/api/statistic/statistic-detail";

    /**
     * 拼接请求路径
     *
     * @PARAM URI
     * @RETURN
     */
    public static String getURL(String uri) {
        return HOST + PROJECT_NAME + API + uri;
    }

}
