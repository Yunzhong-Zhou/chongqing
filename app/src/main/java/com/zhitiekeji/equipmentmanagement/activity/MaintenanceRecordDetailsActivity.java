package com.zhitiekeji.equipmentmanagement.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.Request;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/18.
 * 维修记录详情- 我的审核详情-维修段内报审
 */

public class MaintenanceRecordDetailsActivity extends BaseActivity {
    static String facility_service_apply_id = "";
    private ListView listView;

    View footerView;
    TextView foot_textView1, foot_textView2, foot_textView3;
    LinearLayout foot_linearLayout;

    int type = 1;
    //审核结果
    View headerView1;
    RecyclerView recyclerview;
    TextView textView_head1, textView_head2, textView_head3, textView_head4;
    MyReportDetailModel model;
    List<MyReportDetailModel.FacilityServiceReportListBean> list = new ArrayList<MyReportDetailModel.FacilityServiceReportListBean>();
    MyReportDetailAdapter adapter;
    //报审记录
    View headerView2;
    LinearLayout head2_linearLayout1, head2_linearLayout2, head2_linearLayout3, head2_linearLayout4, head2_linearLayout5;
    TextView head2_textView1_1, head2_textView1_2, head2_textView1_3, head2_textView1_4, head2_textView1_5, head2_textView1_6;
    TextView head2_textView2_1, head2_textView2_2, head2_textView2_3, head2_textView2_4, head2_textView2_5, head2_textView2_6, head2_textView2_7;
    TextView head2_textView3_1, head2_textView3_2, head2_textView3_3, head2_textView3_4, head2_textView3_5,
            head2_textView3_6, head2_textView3_7, head2_textView3_8, head2_textView3_9, head2_textView3_10, head2_textView3_11;
    TextView head2_textView4_1, head2_textView4_2, head2_textView4_3, head2_textView4_4, head2_textView4_5, head2_textView4_6,
            head2_textView4_7, head2_textView4_8, head2_textView4_9, head2_textView4_10, head2_textView4_11, head2_textView4_12;
    RecyclerView head2_recyclerview1, head2_recyclerview2;
    TextView head2_textView5_1, head2_textView5_2, head2_textView5_3, head2_textView5_4, head2_textView5_5, head2_textView5_6, head2_textView5_7;
    List<MaintenanceRecordModel1> list1 = new ArrayList<MaintenanceRecordModel1>();
    MaintenanceRecordAdapter1 adapter1;
    //修复结果
    List<MaintenanceRecordModel2> list2 = new ArrayList<MaintenanceRecordModel2>();
    MaintenanceRecordAdapter2 adapter2;
    TextView textView4;
    String facility_service_issue_id = "";

    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private TextView textView1, textView2, textView3,
            textView1_1, textView2_1, textView3_1;

    int file_type = 0;
    /**
     * pdf文件打开
     */
    String Strname1 = "";
    String Strname2 = "";
    private ProgressDialog mProgressDialog;

    // 下载失败
    public static final int DOWNLOAD_ERROR = 2;
    // 下载成功
    public static final int DOWNLOAD_SUCCESS = 1;
    private File file1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenancerecorddetail);
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

        footerView = View.inflate(this, R.layout.foot_maintenancerecord, null);
        foot_textView1 = (TextView) footerView.findViewById(R.id.foot_textView1);
        foot_textView2 = (TextView) footerView.findViewById(R.id.foot_textView2);
        foot_textView3 = (TextView) footerView.findViewById(R.id.foot_textView3);
        foot_linearLayout = (LinearLayout) footerView.findViewById(R.id.foot_linearLayout);
        foot_textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //同意
                Bundle bundle = new Bundle();
                bundle.putString("facility_service_apply_id", model.getId());
                bundle.putString("EquipmentID", model.getFacility_id());
                CommonUtil.gotoActivityWithData(MaintenanceRecordDetailsActivity.this, AgreeDiseaseManagementActivity.class, bundle, false);
            }
        });
        foot_textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拒绝
                Bundle bundle = new Bundle();
                bundle.putString("facility_service_apply_id", model.getId());
                bundle.putBoolean("isList", false);
                CommonUtil.gotoActivityWithData(MaintenanceRecordDetailsActivity.this, DisagreeDiseaseManagementActivity.class, bundle, false);
            }
        });

        headerView1 = View.inflate(this, R.layout.head_maintenancerecorddetail1, null);//普通会员上传
        textView_head1 = (TextView) headerView1.findViewById(R.id.textView_head1);
        textView_head2 = (TextView) headerView1.findViewById(R.id.textView_head2);
        textView_head3 = (TextView) headerView1.findViewById(R.id.textView_head3);
        textView_head4 = (TextView) headerView1.findViewById(R.id.textView_head4);
        recyclerview = (RecyclerView) headerView1.findViewById(R.id.recyclerview);

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
        listView.addFooterView(footerView, null, false);//添加底部，必须设置adapter，不然不会显示,头部不可点击
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                //报审记录
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
                if (!facility_service_issue_id.equals("")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("facility_service_issue_id", facility_service_issue_id);
                    CommonUtil.gotoActivityWithData(this, AddCalendarYearActivity.class, bundle, false);
                } else {
                    showToast("暂时不能发布");
                }
                break;
            case R.id.head2_textView4_11:
                //施工方案
                if (!Strname1.equals("")) {
                    switch (Strname1.substring(Strname1.length() - 3)) {
                        case "pdf":
                            //是pdf文件
                            file_type = 1;
                            break;
                        case "doc":
                            //.doc
                            file_type = 2;
                            break;
                        case "ocx":
                            //.docx
                            file_type = 3;
                            break;
                        case "xls":
                            //.xls
                            file_type = 4;
                            break;
                        default:
                            //其他
                            file_type = 0;
                            Intent intent = new Intent();
                            intent.putExtra("url", Strname1);
                            intent.setClass(MaintenanceRecordDetailsActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(MaintenanceRecordDetailsActivity.this);
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mProgressDialog.setCancelable(false);
                    mProgressDialog.show();
                    //截取最后14位 作为文件名
                    String s = Strname1.substring(Strname1.length() - 14);
                    //文件存储
                    file1 = new File(Environment.getExternalStorageDirectory(), getFileName(s));
                    new Thread() {
                        public void run() {
                            File haha = new File(file1.getAbsolutePath());
                            //判断是否有此文件
                            if (haha.exists()) {
                                //有缓存文件,拿到路径 直接打开
                                Message msg = Message.obtain();
                                msg.obj = haha;
                                msg.what = DOWNLOAD_SUCCESS;
                                handler.sendMessage(msg);
                                mProgressDialog.dismiss();
                                return;
                            }
//              本地没有此文件 则从网上下载打开
                            File downloadfile = downLoad(URLs.HOST + Strname1, file1.getAbsolutePath(), mProgressDialog);
//              Log.i("Log",file1.getAbsolutePath());
                            Message msg = Message.obtain();
                            if (downloadfile != null) {
                                // 下载成功,安装....
                                msg.obj = downloadfile;
                                msg.what = DOWNLOAD_SUCCESS;
                            } else {
                                // 提示用户下载失败.
                                msg.what = DOWNLOAD_ERROR;
                            }
                            handler.sendMessage(msg);
                            mProgressDialog.dismiss();
                        }
                    }.start();

                } else {
                    showToast("暂未上传施工方案");
                }
                break;
            case R.id.head2_textView5_6:
                //竣工报告
                if (!Strname2.equals("")) {
                    switch (Strname2.substring(Strname2.length() - 3)) {
                        case "pdf":
                            //是pdf文件
                            file_type = 1;
                            break;
                        case "doc":
                            //.doc
                            file_type = 2;
                            break;
                        case "ocx":
                            //.docx
                            file_type = 3;
                            break;
                        case "xls":
                            //.xls
                            file_type = 4;
                            break;
                        default:
                            //其他
                            file_type = 0;
                            Intent intent = new Intent();
                            intent.putExtra("url", Strname2);
                            intent.setClass(MaintenanceRecordDetailsActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(MaintenanceRecordDetailsActivity.this);
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mProgressDialog.setCancelable(false);
                    mProgressDialog.show();
                    //截取最后14位 作为文件名
                    String s = Strname2.substring(Strname2.length() - 14);
                    //文件存储
                    file1 = new File(Environment.getExternalStorageDirectory(), getFileName(s));
                    new Thread() {
                        public void run() {
                            File haha = new File(file1.getAbsolutePath());
                            //判断是否有此文件
                            if (haha.exists()) {
                                //有缓存文件,拿到路径 直接打开
                                Message msg = Message.obtain();
                                msg.obj = haha;
                                msg.what = DOWNLOAD_SUCCESS;
                                handler.sendMessage(msg);
                                mProgressDialog.dismiss();
                                return;
                            }
//              本地没有此文件 则从网上下载打开
                            File downloadfile = downLoad(URLs.HOST + Strname2, file1.getAbsolutePath(), mProgressDialog);
//              Log.i("Log",file1.getAbsolutePath());
                            Message msg = Message.obtain();
                            if (downloadfile != null) {
                                // 下载成功,安装....
                                msg.obj = downloadfile;
                                msg.what = DOWNLOAD_SUCCESS;
                            } else {
                                // 提示用户下载失败.
                                msg.what = DOWNLOAD_ERROR;
                            }
                            handler.sendMessage(msg);
                            mProgressDialog.dismiss();
                        }
                    }.start();

                } else {
                    showToast("暂未上传施工方案");
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
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MaintenanceRecordDetailsActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(MyReportDetailModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的审核详情" + response);
                model = response;
                facility_service_issue_id = response.getFacility_service_implement_id();
                if (response.getAudit().equals("1") && Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    listView.addFooterView(footerView, null, false);
                } else {
                    listView.removeFooterView(footerView);
                }

                if (model.getPublish_disease() != null) {
                    listView.addHeaderView(headerView1, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
                    //                textView_head1.setText(response.);//普通用户-姓名
//                textView_head2.setText(response.);//是否通过
                    textView_head3.setText(model.getPublish_disease().getCreated_at());//创建时间
                    textView_head4.setText(model.getPublish_disease().getDescription());//描述
                    if (model.getPublish_disease().getPic_list() != null) {
                        MyLogger.i(">>>>>>>>>" + model.getPublish_disease().getPic_list().toString());
                        String str = model.getPublish_disease().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]", "");
                        str = str.replaceAll("\\\\", "");
                        String[] strings = str.split("\",\"");

                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MaintenanceRecordDetailsActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerview.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MaintenanceRecordDetailsActivity.this, strings);
                        recyclerview.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MaintenanceRecordDetailsActivity.this);
                            }
                        });
                    }
                } else {
                    listView.removeHeaderView(headerView1);
                    listView.removeHeaderView(headerView2);
                }
                list = response.getFacility_service_report_list();
                adapter = new MyReportDetailAdapter(MaintenanceRecordDetailsActivity.this, list,response.getType());
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
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MaintenanceRecordDetailsActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(RetaliationRecordModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的审核-报审记录" + response);
                if (response.getFacility_service_approval() != null) {
                    head2_linearLayout1.setVisibility(View.VISIBLE);
                    head2_textView1_1.setText(response.getFacility_service_approval().getFlag());
                    head2_textView1_2.setText(response.getFacility_service_approval().getEmployee().getName());
                    head2_textView1_4.setText(response.getFacility_service_approval().getCreated_at());
                    head2_textView1_5.setText("评估费用：" + response.getFacility_service_approval().getEvaluate());
                    head2_textView1_6.setText("上报费用：" + response.getFacility_service_approval().getMoney());
                } else {
                    head2_linearLayout1.setVisibility(View.GONE);
                }
                if (response.getFacility_service_issue() != null) {
                    head2_linearLayout2.setVisibility(View.VISIBLE);
                    head2_textView2_1.setText(response.getFacility_service_issue().getFlag());
                    head2_textView2_2.setText(response.getFacility_service_issue().getEmployee().getName());
                    head2_textView2_4.setText(response.getFacility_service_issue().getCreated_at());
                    head2_textView2_5.setText("计划号：" + response.getFacility_service_issue().getPlan_number());
                    head2_textView2_6.setText("下达费用：" + response.getFacility_service_issue().getCost_money());
                    head2_textView2_7.setText("整治内容：" + response.getFacility_service_issue().getRenovate_content());
                } else {
                    head2_linearLayout2.setVisibility(View.GONE);
                }
                if (response.getFacility_service_reply() != null) {
                    head2_linearLayout3.setVisibility(View.VISIBLE);
                    head2_textView3_1.setText(response.getFacility_service_reply().getFlag());
                    head2_textView3_2.setText(response.getFacility_service_reply().getEmployee().getName());
                    head2_textView3_4.setText(response.getFacility_service_reply().getCreated_at());
                    head2_textView3_5.setText("批复号：" + response.getFacility_service_reply().getReply_number());
                    head2_textView3_6.setText("批复时间：" + response.getFacility_service_reply().getCreated_at().split(" ")[0]);
                    head2_textView3_7.setText("监理费：" + response.getFacility_service_reply().getSupervisor_money());
                    head2_textView3_8.setText("施工费：" + response.getFacility_service_reply().getConstruction_money());
                    head2_textView3_9.setText("设计费：" + response.getFacility_service_reply().getDesign_money());
                    head2_textView3_10.setText("总额：" + response.getFacility_service_reply().getAmount_money());
                    head2_textView3_11.setText("工程范围：" + response.getFacility_service_reply().getProject_scope());
                } else {
                    head2_linearLayout3.setVisibility(View.GONE);
                }
                //实施
                if (response.getFacility_service_implement() != null) {
                    head2_linearLayout4.setVisibility(View.VISIBLE);
                    head2_textView4_1.setText(response.getFacility_service_implement().getFlag());
                    head2_textView4_2.setText(response.getFacility_service_implement().getEmployee().getName());
                    head2_textView4_4.setText(response.getFacility_service_implement().getCreated_at());
                    head2_textView4_5.setText("开工时间：" + response.getFacility_service_implement().getStart_at().split(" ")[0]);
                    head2_textView4_6.setText("竣工时间：" + response.getFacility_service_implement().getEnd_at().split(" ")[0]);
                    head2_textView4_7.setText("设计单位：" + response.getFacility_service_implement().getDesign_company());
                    head2_textView4_8.setText("施工单位：" + response.getFacility_service_implement().getConstruction_company());
                    head2_textView4_9.setText("监理单位：" + response.getFacility_service_implement().getSupervisor_company());
                    head2_textView4_10.setText("合同金额：" + response.getFacility_service_implement().getContract_money());
                    head2_textView4_12.setText("实施内容：" + response.getFacility_service_implement().getContent());

                    Strname1 = response.getFacility_service_implement().getCompletion_plan();
                    if (response.getFacility_service_implement().getPic_list() != null) {
                        MyLogger.i(">>>>>>>>>" + response.getFacility_service_implement().getPic_list().toString());
                        String str = response.getFacility_service_implement().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]", "");
                        str = str.replaceAll("\\\\", "");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MaintenanceRecordDetailsActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        head2_recyclerview1.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MaintenanceRecordDetailsActivity.this, strings);
                        head2_recyclerview1.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MaintenanceRecordDetailsActivity.this);
                            }
                        });
                    }
                } else {
                    head2_linearLayout4.setVisibility(View.GONE);
                }
                //竣工
                if (response.getFacility_service_completion() != null) {
                    head2_linearLayout5.setVisibility(View.VISIBLE);
                    head2_textView5_1.setText(response.getFacility_service_completion().getFlag());
                    head2_textView5_2.setText(response.getFacility_service_completion().getEmployee().getName());
                    head2_textView5_4.setText(response.getFacility_service_completion().getCreated_at());
                    head2_textView5_5.setText("实际金额：" + response.getFacility_service_completion().getActual_money());
                    head2_textView5_7.setText("竣工内容：" + response.getFacility_service_completion().getContent());
                    Strname2 = response.getFacility_service_completion().getCompletion_report();

                    if (response.getFacility_service_completion().getPic_list() != null) {
                        MyLogger.i(">>>>>>>>>" + response.getFacility_service_completion().getPic_list().toString());
                        String str = response.getFacility_service_completion().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]", "");
                        str = str.replaceAll("\\\\", "");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //横向滑动数据
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MaintenanceRecordDetailsActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        head2_recyclerview2.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(MaintenanceRecordDetailsActivity.this, strings);
                        head2_recyclerview2.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, MaintenanceRecordDetailsActivity.this);
                            }
                        });
                    }
                } else {
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
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MaintenanceRecordDetailsActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(RepairResultsModel response) {
                onHttpResult();
                showContentPage();
                MyLogger.i(">>>>>>>>>我的申请详情-修复结果" + response);
                if (response != null) {
                    MaintenanceRecordAdapter2 adapter2 = new MaintenanceRecordAdapter2(MaintenanceRecordDetailsActivity.this, response);
                    listView.setAdapter(adapter2);
                    textView4.setVisibility(View.GONE);
                } else {
                    MaintenanceRecordAdapter1 adapter1 = new MaintenanceRecordAdapter1(MaintenanceRecordDetailsActivity.this, list1);
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
            //移除头部
            listView.removeHeaderView(headerView1);
            listView.removeHeaderView(headerView2);
            listView.removeFooterView(footerView);
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
            listView.removeHeaderView(headerView1);
            listView.removeHeaderView(headerView2);
            listView.removeFooterView(footerView);
            listView.addHeaderView(headerView2, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
            textView4.setVisibility(View.GONE);

            list1 = new ArrayList<MaintenanceRecordModel1>();
                /*for (int i = 0; i < 1; i++) {
                    MaintenanceRecordModel1 model1 = new MaintenanceRecordModel1();
                    model1.setStr("姓名" + (i + 1));
                    list1.add(model1);
                }*/
            MaintenanceRecordAdapter1 adapter1 = new MaintenanceRecordAdapter1(MaintenanceRecordDetailsActivity.this, list1);
            listView.setAdapter(adapter1);

            String string2 = "?id=" + facility_service_apply_id
                    + "&token=" + localUserInfo.getToken();
            RequestRetaliationRecord(string2);
        } else {
            //修复结果
            //移除头部
            listView.removeHeaderView(headerView1);
            listView.removeHeaderView(headerView2);
            listView.removeFooterView(footerView);
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

    /**************************pdf文件下载及打开**************************************************/
    /**
     * 下载完成后  直接打开文件
     */
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case DOWNLOAD_SUCCESS:
                    File file = (File) msg.obj;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } else {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    }

                    Uri uri = getUriForFile(MaintenanceRecordDetailsActivity.this, file);
                    switch (file_type){
                        case 1:
                            intent.setDataAndType(uri, "application/pdf");
                            break;
                        case 2:
                            intent.setDataAndType(uri, "application/msword");
                            break;
                        case 3:
                            intent.setDataAndType(uri, "application/msword");
                            break;
                        case 4:
                            intent.setDataAndType(uri, "application/vnd.ms-excel");
                            break;
                    }
//              startActivity(intent);
                    startActivity(Intent.createChooser(intent, "请选择您要打开的应用"));
                    /**
                     * 弹出选择框   把本activity销毁
                     */
//                    finish();
                    break;
                case DOWNLOAD_ERROR:
                    showToast("文件加载失败");
                    break;
            }
        }
    };
    private static Uri getUriForFile(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.zhitiekeji.equipmentmanagement.fileprovider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }


    /**
     * 传入文件 url  文件路径  和 弹出的dialog  进行 下载文档
     */
    public static File downLoad(String serverpath, String savedfilepath, ProgressDialog pd) {
        try {
            URL url = new URL(serverpath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() == 200) {
                int max = conn.getContentLength();
                pd.setMax(max);
                InputStream is = conn.getInputStream();
                File file = new File(savedfilepath);
                FileOutputStream fos = new FileOutputStream(file);
                int len = 0;
                byte[] buffer = new byte[1024];
                int total = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                    total += len;
                    pd.setProgress(total);
                }
                fos.flush();
                fos.close();
                is.close();
                return file;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getFileName(String serverurl) {
        return serverurl.substring(serverurl.lastIndexOf("/") + 1);
    }
}
