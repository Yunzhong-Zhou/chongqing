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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.CalendarYearDetailAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.MyReportDetaiRecycleViewImageAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.CalendarYearDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/17.
 * 历年记录详情-竣工
 */

public class CalendarYearDetailActivity extends BaseActivity {
    String EquipmentID = "";
    private ListView listView;
    List<CalendarYearDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list =
            new ArrayList<CalendarYearDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean>();
    List<CalendarYearDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list1 =
            new ArrayList<CalendarYearDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean>();
    CalendarYearDetailAdapter adapter;
    View headerView;
    Banner banner;


    //基本信息  维修记录
    private ImageView imageView1;
    private TextView textView1_1, textView1_2,textView2_1,textView2_2,textView2_3;
    private LinearLayout linearLayout1_1,linearLayout1_2;
    private View view1_1,view1_2;
    private LinearLayout linearLayout1;


    int type = 1;

    /*基本信息控件*/
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9, textView10,textView8_1, textView9_1, textView10_1;
    /*详细信息控件*/
    TextView textView11, textView12, textView13, textView14, textView15, textView22, textView23, textView24,
            textView25, textView26, textView27, textView28, textView29, textView30, textView31,
            textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39,
            textView40,textView41,textView42,textView43,textView44,textView45;
    private RecyclerView recyclerview,recyclerview2;
    LinearLayout linearLayout_add;

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
        setContentView(R.layout.activity_calendaryeardetail);
    }
    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.listView);

        headerView = View.inflate(this, R.layout.head_calendaryeardetail, null);
        banner = (Banner) headerView.findViewById(R.id.banner);
        imageView1 = (ImageView) headerView.findViewById(R.id.imageView1);
        textView1 = (TextView) headerView.findViewById(R.id.textView1);
        textView2 = (TextView) headerView.findViewById(R.id.textView2);
        textView3 = (TextView) headerView.findViewById(R.id.textView3);
        textView4 = (TextView) headerView.findViewById(R.id.textView4);
        textView5 = (TextView) headerView.findViewById(R.id.textView5);
        textView6 = (TextView) headerView.findViewById(R.id.textView6);
        textView7 = (TextView) headerView.findViewById(R.id.textView7);
        textView8 = (TextView) headerView.findViewById(R.id.textView8);
        textView9 = (TextView) headerView.findViewById(R.id.textView9);
        textView10 = (TextView) headerView.findViewById(R.id.textView10);
        textView8_1 = (TextView) headerView.findViewById(R.id.textView8_1);
        textView9_1 = (TextView) headerView.findViewById(R.id.textView9_1);
        textView10_1 = (TextView) headerView.findViewById(R.id.textView10_1);

        textView11 = (TextView) headerView.findViewById(R.id.textView11);
        textView12 = (TextView) headerView.findViewById(R.id.textView12);
        textView13 = (TextView) headerView.findViewById(R.id.textView13);
        textView14 = (TextView) headerView.findViewById(R.id.textView14);
        textView15 = (TextView) headerView.findViewById(R.id.textView15);
        linearLayout_add = (LinearLayout) headerView.findViewById(R.id.linearLayout_add);
        textView22 = (TextView) headerView.findViewById(R.id.textView22);
        textView23 = (TextView) headerView.findViewById(R.id.textView23);
        textView24 = (TextView) headerView.findViewById(R.id.textView24);
        textView25 = (TextView) headerView.findViewById(R.id.textView25);
        textView26 = (TextView) headerView.findViewById(R.id.textView26);
        textView27 = (TextView) headerView.findViewById(R.id.textView27);
        textView28 = (TextView) headerView.findViewById(R.id.textView28);
        textView29 = (TextView) headerView.findViewById(R.id.textView29);
        textView30 = (TextView) headerView.findViewById(R.id.textView30);
        textView31 = (TextView) headerView.findViewById(R.id.textView31);
        textView32 = (TextView) headerView.findViewById(R.id.textView32);
        textView33 = (TextView) headerView.findViewById(R.id.textView33);
        textView34 = (TextView) headerView.findViewById(R.id.textView34);
        textView35 = (TextView) headerView.findViewById(R.id.textView35);
        textView36 = (TextView) headerView.findViewById(R.id.textView36);
        textView37 = (TextView) headerView.findViewById(R.id.textView37);
        textView38 = (TextView) headerView.findViewById(R.id.textView38);
        textView39 = (TextView) headerView.findViewById(R.id.textView39);
        textView40 = (TextView) headerView.findViewById(R.id.textView40);
        textView41 = (TextView) headerView.findViewById(R.id.textView41);
        textView42 = (TextView) headerView.findViewById(R.id.textView42);
        textView43 = (TextView) headerView.findViewById(R.id.textView43);
        textView44 = (TextView) headerView.findViewById(R.id.textView44);
        textView45 = (TextView) headerView.findViewById(R.id.textView45);

        textView1_1 = (TextView) headerView.findViewById(R.id.textView1_1);
        textView1_2 = (TextView) headerView.findViewById(R.id.textView1_2);
        linearLayout1_1 = (LinearLayout) headerView.findViewById(R.id.linearLayout1_1);
        linearLayout1_2 = (LinearLayout) headerView.findViewById(R.id.linearLayout1_2);
        view1_1 = (View) headerView.findViewById(R.id.view1_1);
        view1_2 = (View) headerView.findViewById(R.id.view1_2);
        linearLayout1 = (LinearLayout) headerView.findViewById(R.id.linearLayout1);


        recyclerview = (RecyclerView) headerView.findViewById(R.id.recyclerview);
        recyclerview2 = (RecyclerView) headerView.findViewById(R.id.recyclerview2);
        listView.addHeaderView(headerView, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (type==2){
                    Bundle bundle = new Bundle();
                    bundle.putString("DiseaseDetailActivity",list.get(i-1).getId());
                    bundle.putInt("DiseaseDetailActivity_type",5);
                    CommonUtil.gotoActivityWithData(CalendarYearDetailActivity.this, DiseaseDetailActivity.class,bundle,false);
                }

            }
        });
    }
    @Override
    protected void initData() {
        this.showProgress(true, "正在获取数据...");
        EquipmentID = getIntent().getStringExtra("EquipmentID");
        //详细信息
        String string1 = "?id=" + EquipmentID//申请ID
                + "&token=" + localUserInfo.getToken();
        RequestReportDetail(string1);
        adapter = new CalendarYearDetailAdapter(CalendarYearDetailActivity.this, list);
        listView.setAdapter(adapter);
    }
    //竣工详情
    private void RequestReportDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_BUILDENDDETAIL + string, new OkHttpClientManager.ResultCallback<CalendarYearDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(CalendarYearDetailActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(CalendarYearDetailModel response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>详细信息" + response);
                if (response != null) {
//                    facility_service_approval_id = response.getId();
                    //设备详情
                    textView1.setText(response.getFacility().getTitle());//设备标题
                    textView2.setText(response.getFacility().getNumber());//设备编号
                    textView3.setText(response.getFacility().getSection().getTitle());//所属车辆段
                    if (response.getFacility().getType().equals("1")) {//判断是房屋还是构筑物
                        textView4.setText(response.getFacility().getHouse_area() + "㎡");//房屋面积
                    } else {
                        textView4.setText(response.getFacility().getStructures_area() + "H㎡");//构筑物面积
                    }
                    textView5.setText(response.getFacility().getCompany().getTitle());//所属段改为使用单位
                    textView6.setText(response.getFacility().getWorkshop().getTitle()+"车间");//所属车间
                    textView7.setText(response.getFacility().getWorkshop().getTitle());//所属车间
                    /*if (response.getFacility().getLast_small_service_at() != null && !response.getFacility().getLast_small_service_at().equals("")) {
                        String[] strs = response.getFacility().getLast_small_service_at().toString().split(" ");
                        textView8.setText("上次" + strs[0]);//请检修时间
                    } else {
                        textView8.setText("暂无");
                    }
                    if (response.getFacility().getLast_mid_service_at() != null && !response.getFacility().getLast_mid_service_at().equals("")) {
                        String[] strs = response.getFacility().getLast_mid_service_at().toString().split(" ");
                        textView9.setText("上次" + strs[0]);//综合维修时间
                    } else {
                        textView9.setText("暂无");
                    }
                    if (response.getFacility().getLast_big_service_at() != null && !response.getFacility().getLast_big_service_at().equals("")) {
                        String[] strs = response.getFacility().getLast_big_service_at().toString().split(" ");
                        textView10.setText("上次" + strs[0]);//大修时间
                    } else {
                        textView10.setText("暂无");
                    }*/
                    textView8_1.setText("["+response.getMinor()+"]");
                    textView9_1.setText("["+response.getMid()+"]");
                    textView10_1.setText("["+response.getBig()+"]");
                    textView8.setText(response.getMinor_updated_at());
                    textView9.setText(response.getMid_updated_at());
                    textView10.setText(response.getBig_updated_at());

                    final ArrayList<String> imageUrlList = new ArrayList<String>();
                    if (!response.getFacility().getPic1().equals("")) {
                        imageUrlList.add(URLs.HOST + response.getFacility().getPic1());
                    }
                    if (!response.getFacility().getPic2().equals("")) {
                        imageUrlList.add(URLs.HOST + response.getFacility().getPic2());
                    }
                    if (!response.getFacility().getPic3().equals("")) {
                        imageUrlList.add(URLs.HOST + response.getFacility().getPic3());
                    }
                    //设置banner样式
                    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    //设置图片集合
                    banner.setImages(imageUrlList);
                    //设置banner动画效果
                    banner.setBannerAnimation(Transformer.DepthPage);
                    //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(linkUrlArray);
                    //设置自动轮播，默认为true
                    banner.isAutoPlay(true);
                    //设置轮播时间
                    banner.setDelayTime(3000);
                    //设置指示器位置（当banner模式中有指示器时）
                    banner.setIndicatorGravity(BannerConfig.CENTER);
                    //banner设置方法全部调用完毕时最后调用
                    banner.start();
                    banner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            ViewPagerPhotoViewActivity.startThisActivity(imageUrlList, position, CalendarYearDetailActivity.this);
                        }
                    });
                    //上报记录
                    textView11.setText("[" + response.getFacility_service_apply().getBatch_year() + "年第" +
                            response.getFacility_service_apply().getBatch() + "批次]");//批次号
                    textView12.setText(response.getFacility_service_approval().getEmployee().getName());//上报人
                    textView13.setText(response.getFacility_service_approval().getCreated_at());//上报时间
                    textView14.setText(response.getFacility_service_approval().getMoney() + "元");//上报费用
                    textView15.setText(response.getFacility_service_approval().getEvaluate() + "元");//预估费用
                    //巡检员
                    //添加布局
                    for (int i = 0; i < response.getFacility_service_apply().getFacility_service_report_list().size(); i++) {
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        LayoutInflater inflater = LayoutInflater.from(CalendarYearDetailActivity.this);
                        View view = inflater.inflate(R.layout.item_managementreview, null, false);
                        view.setLayoutParams(lp);
                        //实例化子页面的控件
                        TextView textView_1 = (TextView) view.findViewById(R.id.textView_1);
                        TextView textView_2 = (TextView) view.findViewById(R.id.textView_2);
                        textView_1.setText(response.getFacility_service_apply().getFacility_service_report_list().get(i).getEmployee().getName());
                        textView_2.setText(response.getFacility_service_apply().getFacility_service_report_list().get(i).getCreated_at());
                        linearLayout_add.addView(view);
                    }
                    //病害列表
                    list = response.getFacility_service_report().getFacility_disease_list();

                    //下达记录
                    textView22.setText(response.getFacility_service_issue().getPlan_number());//计划号
                    textView23.setText(response.getFacility_service_issue().getRenovate_content());//整治内容
                    textView24.setText(response.getFacility_service_issue().getCost_money() + "元");//下达费用

                    //批复记录
                    textView25.setText(response.getFacility_service_reply().getReply_number());//批复号
                    textView26.setText(response.getCreated_at());//批复时间
                    textView27.setText(response.getFacility_service_reply().getProject_scope());//工程范围
                    textView28.setText(response.getFacility_service_reply().getSupervisor_money() + "元");//监理费
                    textView29.setText(response.getFacility_service_reply().getConstruction_money() + "元");//施工费
                    textView30.setText(response.getFacility_service_reply().getDesign_money() + "元");//设计费
                    textView31.setText(response.getFacility_service_reply().getAmount_money() + "元");//总额

                    //实施记录
                    textView32.setText(response.getFacility_service_implement().getStart_at().split(" ")[0] + "—" + response.getFacility_service_implement().getEnd_at().split(" ")[0]);//开竣工时间
                    textView33.setText(response.getFacility_service_implement().getDesign_company());//设计单位
                    textView34.setText(response.getFacility_service_implement().getConstruction_company());//施工单位
                    textView35.setText(response.getFacility_service_implement().getSupervisor_company());//监理单位
                    textView36.setText(response.getFacility_service_implement().getContract_money() + "元");//合同金额
                    Strname1 = response.getFacility_service_implement().getCompletion_plan();
                    textView37.setText(response.getFacility_service_implement().getCompletion_plan());//施工方案
//                    textView38.setText(response.getFacility_service_reply());//(157k)
                    textView39.setText(response.getContent());//施工记录
                    //横向滑动数据
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
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CalendarYearDetailActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerview.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(CalendarYearDetailActivity.this, strings);
                        recyclerview.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, CalendarYearDetailActivity.this);
                            }
                        });
                    } else {
                        //没有图片

                    }

                    //竣工记录
                    textView40.setText(response.getEmployee().getName());//姓名
                    textView41.setText(response.getCreated_at());//时间
                    textView42.setText(response.getActual_money()+"元");//实际费用
                    Strname2 = response.getCompletion_report();
                    textView43.setText(response.getCompletion_report());//竣工报告
//                    textView44.setText(response.getCreated_at());//157k
                    textView45.setText(response.getContent());//详情
                    //横向滑动数据
                    if (response.getPic_list() != null) {
                        MyLogger.i(">>>>>>>>>" + response.getPic_list().toString());
                        String str = response.getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]", "");
                        str = str.replaceAll("\\\\", "");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(CalendarYearDetailActivity.this);
                        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerview2.setLayoutManager(linearLayoutManager1);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(CalendarYearDetailActivity.this, strings);
                        recyclerview2.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, CalendarYearDetailActivity.this);
                            }
                        });
                    } else {
                        //没有图片
                    }
                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_3:
                //已完善数据
                break;
            case R.id.imageView1:
                //返回
                finish();
                break;
            case R.id.linearLayout1_1:
                //基本信息
                textView1_1.setTextColor(getResources().getColor(R.color.lightblue500));
                view1_1.setBackgroundResource(R.color.lightblue500);
                textView1_2.setTextColor(getResources().getColor(R.color.default_text));
                view1_2.setBackgroundResource(R.color.white);

                linearLayout1.setVisibility(View.VISIBLE);

                adapter = new CalendarYearDetailAdapter(CalendarYearDetailActivity.this, list1);
                listView.setAdapter(adapter);
                type = 1;
                break;
            case R.id.linearLayout1_2:
                //维修记录
                textView1_1.setTextColor(getResources().getColor(R.color.default_text));
                view1_1.setBackgroundResource(R.color.white);
                textView1_2.setTextColor(getResources().getColor(R.color.lightblue500));
                view1_2.setBackgroundResource(R.color.lightblue500);

                linearLayout1.setVisibility(View.GONE);
                adapter = new CalendarYearDetailAdapter(CalendarYearDetailActivity.this, list);
                listView.setAdapter(adapter);
                type = 2;
                break;
            case R.id.textView37:
                //打开附件
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
                            intent.setClass(CalendarYearDetailActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(CalendarYearDetailActivity.this);
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
            case R.id.textView43:
                //打开附件
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
                            intent.setClass(CalendarYearDetailActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(CalendarYearDetailActivity.this);
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

    @Override
    protected void updateView() {
        titleView.setVisibility(View.GONE);
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
            //Glide 加载图片简单用法
            Glide.with(context).load(path.toString()).fitCenter().into(imageView);
        }
        /*//提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
        @Override
        public ImageView createImageView(Context context) {
            //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
            SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
            return simpleDraweeView;
        }*/
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

                    Uri uri = getUriForFile(CalendarYearDetailActivity.this, file);
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
