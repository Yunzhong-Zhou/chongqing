package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.MaintenanceRecordAdapter1;
import com.zhitiekeji.equipmentmanagement.adapter.MaintenanceRecordAdapter2;
import com.zhitiekeji.equipmentmanagement.adapter.MyReportDetaiRecycleViewImageAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.MyReportDetailAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.MaintenanceRecordModel1;
import com.zhitiekeji.equipmentmanagement.model.MaintenanceRecordModel2;
import com.zhitiekeji.equipmentmanagement.model.MyReportDetailModel;
import com.zhitiekeji.equipmentmanagement.model.RepairResultsModel;
import com.zhitiekeji.equipmentmanagement.model.RetaliationRecordModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/18.
 * 我的上报详情
 */

public class MyReportDetailActivity extends BaseActivity{
    String facility_service_apply_id = "";
    private ListView listView;
    int type = 1;
    //审核结果
    View headerView1;
    RecyclerView recyclerview;
    TextView textView_head1,textView_head2,textView_head3,textView_head4;
    List<MyReportDetailModel.FacilityServiceReportListBean> list = new ArrayList<MyReportDetailModel.FacilityServiceReportListBean>();
    MyReportDetailAdapter adapter;
    //报审记录
    View headerView2;
    LinearLayout head2_linearLayout1,head2_linearLayout2,head2_linearLayout3,head2_linearLayout4,head2_linearLayout5;
    TextView head2_textView1_1,head2_textView1_2,head2_textView1_3,head2_textView1_4,head2_textView1_5,head2_textView1_6;
    TextView head2_textView2_1,head2_textView2_2,head2_textView2_3,head2_textView2_4,head2_textView2_5,head2_textView2_6,head2_textView2_7;
    TextView head2_textView3_1,head2_textView3_2,head2_textView3_3,head2_textView3_4,head2_textView3_5,
            head2_textView3_6,head2_textView3_7,head2_textView3_8,head2_textView3_9,head2_textView3_10,head2_textView3_11;
    TextView head2_textView4_1,head2_textView4_2,head2_textView4_3,head2_textView4_4,head2_textView4_5, head2_textView4_6,
            head2_textView4_7,head2_textView4_8,head2_textView4_9,head2_textView4_10,head2_textView4_11,head2_textView4_12;
    RecyclerView head2_recyclerview1,head2_recyclerview2;
    TextView head2_textView5_1,head2_textView5_2,head2_textView5_3,head2_textView5_4,head2_textView5_5,head2_textView5_6,head2_textView5_7;
    List<MaintenanceRecordModel1> list1 = new ArrayList<MaintenanceRecordModel1>();
    MaintenanceRecordAdapter1 adapter1;
    //修复结果
    List<MaintenanceRecordModel2> list2 = new ArrayList<MaintenanceRecordModel2>();
    MaintenanceRecordAdapter2 adapter2;
    TextView textView4;
    String facility_service_issue_id = "";

    private LinearLayout linearLayout1,linearLayout2,linearLayout3;
    private TextView textView1,textView2,textView3,
            textView1_1,textView2_1,textView3_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreportdetail);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestServer();
    }

    @Override
    protected void initView() {
        listView = findViewByID_My(R.id.listView);
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout3 = findViewByID_My(R.id.linearLayout3);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        textView3_1 = findViewByID_My(R.id.textView3_1);
        textView4 = findViewByID_My(R.id.textView4);

        //普通用户发布
        headerView1 = View.inflate(this, R.layout.head_maintenancerecorddetail1, null);//普通会员上传
        textView_head1 = (TextView) headerView1.findViewById(R.id.textView_head1);
        textView_head2 = (TextView) headerView1.findViewById(R.id.textView_head2);
        textView_head3 = (TextView) headerView1.findViewById(R.id.textView_head3);
        textView_head4 = (TextView) headerView1.findViewById(R.id.textView_head4);
        recyclerview = (RecyclerView) headerView1.findViewById(R.id.recyclerview);

        //审报记录布局
        headerView2 = View.inflate(this, R.layout.head_maintenancerecord2, null);
        head2_textView1_1 = (TextView) headerView2.findViewById(R.id.head2_textView1_1);
        head2_textView1_2 = (TextView) headerView2.findViewById(R.id.head2_textView1_2);
        head2_textView1_3 = (TextView) headerView2.findViewById(R.id.head2_textView1_3);
        head2_textView1_4 = (TextView) headerView2.findViewById(R.id.head2_textView1_4);
        head2_textView1_5 = (TextView) headerView2.findViewById(R.id.head2_textView1_5);
        head2_textView1_6 = (TextView) headerView2.findViewById(R.id.head2_textView1_6);

        head2_textView2_1 = (TextView) headerView2.findViewById(R.id.head2_textView2_1);
        head2_textView2_2 = (TextView) headerView2.findViewById(R.id.head2_textView2_2);
        head2_textView2_3 = (TextView) headerView2.findViewById(R.id.head2_textView2_3);
        head2_textView2_4 = (TextView) headerView2.findViewById(R.id.head2_textView2_4);
        head2_textView2_5 = (TextView) headerView2.findViewById(R.id.head2_textView2_5);
        head2_textView2_6 = (TextView) headerView2.findViewById(R.id.head2_textView2_6);
        head2_textView2_7 = (TextView) headerView2.findViewById(R.id.head2_textView2_7);

        head2_textView3_1 = (TextView) headerView2.findViewById(R.id.head2_textView3_1);
        head2_textView3_2 = (TextView) headerView2.findViewById(R.id.head2_textView3_2);
        head2_textView3_3 = (TextView) headerView2.findViewById(R.id.head2_textView3_3);
        head2_textView3_4 = (TextView) headerView2.findViewById(R.id.head2_textView3_4);
        head2_textView3_5 = (TextView) headerView2.findViewById(R.id.head2_textView3_5);
        head2_textView3_6 = (TextView) headerView2.findViewById(R.id.head2_textView3_6);
        head2_textView3_7 = (TextView) headerView2.findViewById(R.id.head2_textView3_7);
        head2_textView3_8 = (TextView) headerView2.findViewById(R.id.head2_textView3_8);
        head2_textView3_9 = (TextView) headerView2.findViewById(R.id.head2_textView3_9);
        head2_textView3_10 = (TextView) headerView2.findViewById(R.id.head2_textView3_10);
        head2_textView3_11 = (TextView) headerView2.findViewById(R.id.head2_textView3_11);

        head2_textView4_1 = (TextView) headerView2.findViewById(R.id.head2_textView4_1);
        head2_textView4_2 = (TextView) headerView2.findViewById(R.id.head2_textView4_2);
        head2_textView4_3 = (TextView) headerView2.findViewById(R.id.head2_textView4_3);
        head2_textView4_4 = (TextView) headerView2.findViewById(R.id.head2_textView4_4);
        head2_textView4_5 = (TextView) headerView2.findViewById(R.id.head2_textView4_5);
        head2_textView4_6 = (TextView) headerView2.findViewById(R.id.head2_textView4_6);
        head2_textView4_7 = (TextView) headerView2.findViewById(R.id.head2_textView4_7);
        head2_textView4_8 = (TextView) headerView2.findViewById(R.id.head2_textView4_8);
        head2_textView4_9 = (TextView) headerView2.findViewById(R.id.head2_textView4_9);
        head2_textView4_10 = (TextView) headerView2.findViewById(R.id.head2_textView4_10);
        head2_textView4_11 = (TextView) headerView2.findViewById(R.id.head2_textView4_11);
        head2_textView4_12 = (TextView) headerView2.findViewById(R.id.head2_textView4_12);

        head2_textView5_1 = (TextView) headerView2.findViewById(R.id.head2_textView5_1);
        head2_textView5_2 = (TextView) headerView2.findViewById(R.id.head2_textView5_2);
        head2_textView5_3 = (TextView) headerView2.findViewById(R.id.head2_textView5_3);
        head2_textView5_4 = (TextView) headerView2.findViewById(R.id.head2_textView5_4);
        head2_textView5_5 = (TextView) headerView2.findViewById(R.id.head2_textView5_5);
        head2_textView5_6 = (TextView) headerView2.findViewById(R.id.head2_textView5_6);
        head2_textView5_7 = (TextView) headerView2.findViewById(R.id.head2_textView5_7);

        head2_recyclerview1 = (RecyclerView) headerView2.findViewById(R.id.head2_recyclerview1);
        head2_recyclerview2 = (RecyclerView) headerView2.findViewById(R.id.head2_recyclerview2);
        head2_linearLayout1 = (LinearLayout) headerView2.findViewById(R.id.head2_linearLayout1);
        head2_linearLayout2 = (LinearLayout) headerView2.findViewById(R.id.head2_linearLayout2);
        head2_linearLayout3 = (LinearLayout) headerView2.findViewById(R.id.head2_linearLayout3);
        head2_linearLayout4 = (LinearLayout) headerView2.findViewById(R.id.head2_linearLayout4);
        head2_linearLayout5 = (LinearLayout) headerView2.findViewById(R.id.head2_linearLayout5);
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                requestServer();
                /*if (type == 1) {
                    //审核结果
                    String string = "?id=" + facility_service_apply_id
                            + "&token=" + localUserInfo.getToken();
                    RequestMyReportDetail(string);
                } else if (type == 2) {
                    //报审记录
                    String string2 = "?id=" + facility_service_apply_id
                            + "&token=" + localUserInfo.getToken();
                    RequestRetaliationRecord(string2);
                } else {
                    //修复结果
                    String string3 = "?id=" + facility_service_apply_id
                            + "&token=" + localUserInfo.getToken();
                    RequestRepairResults(string3);
                }*/
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                //加载更多
                pullview.onFooterLoadFinish();
            }
        });
    }

    @Override
    protected void initData() {
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");

//        listView.addHeaderView(headerView1, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearLayout1:
                //审核结果
                /*textView1.setTextColor(getResources().getColor(R.color.lightblue500));
                textView2.setTextColor(getResources().getColor(R.color.default_text));
                textView3.setTextColor(getResources().getColor(R.color.default_text));*/
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);

                type = 1;
                requestServer();
                break;
            case R.id.linearLayout2:
                //审报记录
                /*textView1.setTextColor(getResources().getColor(R.color.default_text));
                textView2.setTextColor(getResources().getColor(R.color.lightblue500));
                textView3.setTextColor(getResources().getColor(R.color.default_text));*/
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                textView3_1.setBackgroundResource(R.color.transparent);

                type = 2;
                requestServer();

                break;
            case R.id.linearLayout3:
                //修复结果
                /*textView1.setTextColor(getResources().getColor(R.color.default_text));
                textView2.setTextColor(getResources().getColor(R.color.default_text));
                textView3.setTextColor(getResources().getColor(R.color.lightblue500));*/
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.blue);

                type = 3;
                requestServer();
                break;
            case R.id.textView4:
                //发布维修结果
                if (!facility_service_issue_id.equals("")){
                    Bundle bundle = new Bundle();
                    bundle.putString("facility_service_issue_id", facility_service_issue_id);
                    CommonUtil.gotoActivityWithData(this, AddCalendarYearActivity.class, bundle, false);
                }else {
                    showToast("暂时不能发布");
                }

                break;
        }
    }
    //审核结果
    private void RequestMyReportDetail(String params) {
        OkHttpClientManager.getAsyn(URLs.MyReportDetail + params, new OkHttpClientManager.ResultCallback<MyReportDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                onHttpResult();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MyReportDetailActivity.this, LoginActivity.class,true);
                }else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(MyReportDetailModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的申请详情" + response);
                facility_service_issue_id = response.getFacility_service_implement_id();
                if (response.getPublish_disease() != null){
                    listView.addHeaderView(headerView1, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
                    //                textView_head1.setText(response.);//普通用户-姓名
//                textView_head2.setText(response.);//是否通过
                    textView_head3.setText(response.getPublish_disease().getCreated_at());//创建时间
                    textView_head4.setText(response.getPublish_disease().getDescription());//描述
                    if (response.getPublish_disease().getPic_list() != null){
                        MyLogger.i(">>>>>>>>>"+response.getPublish_disease().getPic_list().toString());
                        String str = response.getPublish_disease().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]","");
                        str = str.replaceAll("\\\\","");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyReportDetailActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerview.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MyReportDetailActivity.this, strings);
                        recyclerview.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MyReportDetailActivity.this);
                            }
                        });
                    }
                }else {
                    listView.removeHeaderView(headerView2);
                    listView.removeHeaderView(headerView1);
                }
                list = response.getFacility_service_report_list();
                adapter = new MyReportDetailAdapter(MyReportDetailActivity.this, list,response.getType());
                listView.setAdapter(adapter);
            }
        });
    }
    //报审记录
    private void RequestRetaliationRecord(String params) {
        OkHttpClientManager.getAsyn(URLs.RetaliationRecord + params, new OkHttpClientManager.ResultCallback<RetaliationRecordModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                onHttpResult();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MyReportDetailActivity.this, LoginActivity.class,true);
                }else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(RetaliationRecordModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的申请详情-报审记录" + response);
                if (response.getFacility_service_approval() != null){
                    head2_linearLayout1.setVisibility(View.VISIBLE);
                    head2_textView1_1.setText(response.getFacility_service_approval().getFlag());
                    head2_textView1_2.setText(response.getFacility_service_approval().getEmployee().getName());
                    head2_textView1_4.setText(response.getFacility_service_approval().getCreated_at());
                    head2_textView1_5.setText("评估费用："+response.getFacility_service_approval().getEvaluate());
                    head2_textView1_6.setText("上报费用："+response.getFacility_service_approval().getMoney());
                }else {
                    head2_linearLayout1.setVisibility(View.GONE);
                }
                if (response.getFacility_service_issue() != null){
                    head2_linearLayout2.setVisibility(View.VISIBLE);
                    head2_textView2_1.setText(response.getFacility_service_issue().getFlag());
                    head2_textView2_2.setText(response.getFacility_service_issue().getEmployee().getName());
                    head2_textView2_4.setText(response.getFacility_service_issue().getCreated_at());
                    head2_textView2_5.setText("计划号："+response.getFacility_service_issue().getPlan_number());
                    head2_textView2_6.setText("下达费用："+response.getFacility_service_issue().getCost_money());
                    head2_textView2_7.setText("整治内容："+response.getFacility_service_issue().getRenovate_content());
                }else {
                    head2_linearLayout2.setVisibility(View.GONE);
                }
                if (response.getFacility_service_reply() != null){
                    head2_linearLayout3.setVisibility(View.VISIBLE);
                    head2_textView3_1.setText(response.getFacility_service_reply().getFlag());
                    head2_textView3_2.setText(response.getFacility_service_reply().getEmployee().getName());
                    head2_textView3_4.setText(response.getFacility_service_reply().getCreated_at());
                    head2_textView3_5.setText("批复号："+response.getFacility_service_reply().getReply_number());
                    if (response.getFacility_service_reply().getCreated_at() != null){
                        head2_textView3_6.setText("批复时间："+response.getFacility_service_reply().getCreated_at().split(" ")[0]);
                    }
                    head2_textView3_7.setText("监理费："+response.getFacility_service_reply().getSupervisor_money());
                    head2_textView3_8.setText("施工费："+response.getFacility_service_reply().getConstruction_money());
                    head2_textView3_9.setText("设计费："+response.getFacility_service_reply().getDesign_money());
                    head2_textView3_10.setText("总额："+response.getFacility_service_reply().getAmount_money());
                    head2_textView3_11.setText("工程范围："+response.getFacility_service_reply().getProject_scope());
                }else {
                    head2_linearLayout3.setVisibility(View.GONE);
                }
                if (response.getFacility_service_implement() != null){
                    head2_linearLayout4.setVisibility(View.VISIBLE);
                    head2_textView4_1.setText(response.getFacility_service_implement().getFlag());
                    head2_textView4_2.setText(response.getFacility_service_implement().getEmployee().getName());
                    head2_textView4_4.setText(response.getFacility_service_implement().getCreated_at());
                    head2_textView4_5.setText("开工时间："+response.getFacility_service_implement().getStart_at().split(" ")[0]);
                    head2_textView4_6.setText("竣工时间："+response.getFacility_service_implement().getEnd_at().split(" ")[0]);
                    head2_textView4_7.setText("设计单位："+response.getFacility_service_implement().getDesign_company());
                    head2_textView4_8.setText("施工单位："+response.getFacility_service_implement().getConstruction_company());
                    head2_textView4_9.setText("监理单位："+response.getFacility_service_implement().getSupervisor_company());
                    head2_textView4_10.setText("合同金额："+response.getFacility_service_implement().getContract_money());
                    head2_textView4_12.setText("实施内容："+response.getFacility_service_implement().getContent());
                    if (response.getFacility_service_implement().getPic_list() != null){
                        MyLogger.i(">>>>>>>>>"+response.getFacility_service_implement().getPic_list().toString());
                        String str = response.getFacility_service_implement().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]","");
                        str = str.replaceAll("\\\\","");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyReportDetailActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        head2_recyclerview1.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MyReportDetailActivity.this, strings);
                        head2_recyclerview1.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MyReportDetailActivity.this);
                            }
                        });
                    }
                }else {
                    head2_linearLayout4.setVisibility(View.GONE);
                }
                if (response.getFacility_service_completion() != null){
                    head2_linearLayout5.setVisibility(View.VISIBLE);
                    head2_textView5_1.setText(response.getFacility_service_completion().getFlag());
                    head2_textView5_2.setText(response.getFacility_service_completion().getEmployee().getName());
                    head2_textView5_4.setText(response.getFacility_service_completion().getCreated_at());
                    head2_textView5_5.setText("实际金额："+response.getFacility_service_completion().getActual_money());
                    head2_textView5_7.setText("竣工内容："+response.getFacility_service_completion().getContent());
                    if (response.getFacility_service_completion().getPic_list() != null){
                        MyLogger.i(">>>>>>>>>"+response.getFacility_service_completion().getPic_list().toString());
                        String str = response.getFacility_service_completion().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]","");
                        str = str.replaceAll("\\\\","");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyReportDetailActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        head2_recyclerview2.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MyReportDetailActivity.this, strings);
                        head2_recyclerview2.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MyReportDetailActivity.this);
                            }
                        });
                    }
                }else {
                    head2_linearLayout5.setVisibility(View.GONE);
                }

                if (response.getFacility_service_approval() == null &&
                        response.getFacility_service_issue() == null &&
                        response.getFacility_service_reply() == null &&
                        response.getFacility_service_implement() == null &&
                        response.getFacility_service_completion() == null) {
                    showEmptyPage();
                }
            }
        });
    }
    //修复结果
    private void RequestRepairResults(String params) {
        OkHttpClientManager.getAsyn(URLs.RepairResults + params, new OkHttpClientManager.ResultCallback<RepairResultsModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                onHttpResult();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MyReportDetailActivity.this, LoginActivity.class,true);
                }else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(RepairResultsModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的申请详情-修复结果" + response);
                if (response != null){
                    MaintenanceRecordAdapter2 adapter2 = new MaintenanceRecordAdapter2(MyReportDetailActivity.this, response);
                    listView.setAdapter(adapter2);
                    textView4.setVisibility(View.GONE);
                }else {
                    MaintenanceRecordAdapter1 adapter1 = new MaintenanceRecordAdapter1(MyReportDetailActivity.this, list1);
                    listView.setAdapter(adapter1);
                    textView4.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("维修记录段内报审");
        }
    }

    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        if (type == 1) {
            //审核结果
            //移除头部
            listView.removeHeaderView(headerView2);
            listView.removeHeaderView(headerView1);
//                listView.addHeaderView(headerView1, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
//                foot_linearLayout.setVisibility(View.VISIBLE);
//                foot_textView3.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
            String string = "?id=" + facility_service_apply_id
                    + "&token=" + localUserInfo.getToken();
            RequestMyReportDetail(string);
        } else if (type == 2) {
            //报审记录
            //移除尾部
            listView.removeHeaderView(headerView2);
            listView.removeHeaderView(headerView1);
            listView.addHeaderView(headerView2, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
            textView4.setVisibility(View.GONE);

            list1 = new ArrayList<MaintenanceRecordModel1>();
                /*for (int i = 0; i < 1; i++) {
                    MaintenanceRecordModel1 model1 = new MaintenanceRecordModel1();
                    model1.setStr("姓名" + (i + 1));
                    list1.add(model1);
                }*/
            MaintenanceRecordAdapter1 adapter1 = new MaintenanceRecordAdapter1(MyReportDetailActivity.this, list1);
            listView.setAdapter(adapter1);
            String string2 = "?id=" + facility_service_apply_id
                    + "&token=" + localUserInfo.getToken();
            RequestRetaliationRecord(string2);
        } else {
            //修复结果
            //移除头部
            listView.removeHeaderView(headerView2);
            listView.removeHeaderView(headerView1);
//                listView.addFooterView(footerView, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
//                foot_linearLayout.setVisibility(View.GONE);
//                foot_textView3.setVisibility(View.VISIBLE);
            String string3 = "?id=" + facility_service_apply_id
                    + "&token=" + localUserInfo.getToken();
            RequestRepairResults(string3);
        }

    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }
}
