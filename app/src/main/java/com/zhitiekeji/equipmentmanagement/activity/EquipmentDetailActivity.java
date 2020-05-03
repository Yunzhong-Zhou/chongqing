package com.zhitiekeji.equipmentmanagement.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentDetailAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentDetailAdapter2_1;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentDetailAdapter2_2;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentDetailAdapter2_3;
import com.zhitiekeji.equipmentmanagement.adapter.EquipmentDetailAdapter3;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel1;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel2;
import com.zhitiekeji.equipmentmanagement.model.EquipmentInspectionModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.popupwindow.ConfirmInspectionPopupWindow;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.zhitiekeji.equipmentmanagement.R.id.linearLayout1_2;

/**
 * Created by fafukeji01 on 2017/1/17.
 * 设备详情
 */

public class EquipmentDetailActivity extends BaseActivity {
    String number = "";//设备号
    String EquipmentID = "";//设备id

    private ListView listView;
    List<EquipmentDetailModel> list = new ArrayList<EquipmentDetailModel>();
    EquipmentDetailAdapter adapter;

    EquipmentDetailModel1 model = null;

    List<EquipmentDetailModel2.BigBean> list2_1 = new ArrayList<EquipmentDetailModel2.BigBean>();
    List<EquipmentDetailModel2.MidBean> list2_2 = new ArrayList<EquipmentDetailModel2.MidBean>();
    List<EquipmentDetailModel2.SmallBean> list2_3 = new ArrayList<EquipmentDetailModel2.SmallBean>();
    EquipmentDetailAdapter2_1 adapter2_1;
    EquipmentDetailAdapter2_2 adapter2_2;
    EquipmentDetailAdapter2_3 adapter2_3;

    View headerView;
    Banner banner;
    private ImageView imageView1, imageView2, imageView3;
    ArrayList<String> imageUrlList = new ArrayList<String>();

    //基本信息  维修记录
    private LinearLayout linearLayout1, linearLayout2;
    int type = 1;
    private TextView textView1_1, textView1_2, textView1_3,//基本信息
            textView2_1, textView2_2, textView2_3;//维修记录
    private ImageView view1_1, view1_2, view1_3;//基本信息
    private View view2_1, view2_2, view2_3;//维修记录

    /*基本信息控件*/
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9, textView10, textView8_1, textView9_1, textView10_1, textView11, textView12,
            textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20,
            textView21, textView22, textView23, textView33, textView34, textView35, textView36, textView37;
    LinearLayout linearLayout_add;//设备病害列表
    //生产房屋
    LinearLayout linearLayout_1, linearLayout_2;
    TextView textView24, textView25, textView26, textView27, textView28, textView29;
    //生产构筑物
    TextView textView30, textView31, textView32;

    /*巡检记录*/
    List<EquipmentInspectionModel> list3 = new ArrayList<EquipmentInspectionModel>();
    EquipmentDetailAdapter3 adapter3;

    String longitude = "";//经度
    String latitude = "";//纬度
    String addr = "";//地址

    boolean isChange = false;

    /**
     * 定位
     */
    // 定位相关
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipmentdetail);

        // 定位初始化
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        initLocation();

//        mLocationClient.start();
    }

    /**
     * pdf文件打开
     */
    String Strname = "", Strname1 = "";
    private ProgressDialog mProgressDialog;

    // 下载失败
    public static final int DOWNLOAD_ERROR = 2;
    // 下载成功
    public static final int DOWNLOAD_SUCCESS = 1;
    private File file1;

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.listView);

        headerView = View.inflate(this, R.layout.head_equipmentdetail, null);
        banner = (Banner) headerView.findViewById(R.id.banner);
        imageView1 = (ImageView) headerView.findViewById(R.id.imageView1);
        imageView2 = (ImageView) headerView.findViewById(R.id.imageView2);
        imageView3 = (ImageView) headerView.findViewById(R.id.imageView3);
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
        textView16 = (TextView) headerView.findViewById(R.id.textView16);
        textView17 = (TextView) headerView.findViewById(R.id.textView17);
        textView18 = (TextView) headerView.findViewById(R.id.textView18);
        textView19 = (TextView) headerView.findViewById(R.id.textView19);
        textView20 = (TextView) headerView.findViewById(R.id.textView20);
        textView21 = (TextView) headerView.findViewById(R.id.textView21);
        textView22 = (TextView) headerView.findViewById(R.id.textView22);
        textView23 = (TextView) headerView.findViewById(R.id.textView23);
        textView33 = (TextView) headerView.findViewById(R.id.textView33);
        textView34 = (TextView) headerView.findViewById(R.id.textView34);
        textView35 = (TextView) headerView.findViewById(R.id.textView35);
        textView36 = (TextView) headerView.findViewById(R.id.textView36);
        textView37 = (TextView) headerView.findViewById(R.id.textView37);
        linearLayout_add = headerView.findViewById(R.id.linearLayout_add);

        linearLayout_1 = (LinearLayout) headerView.findViewById(R.id.linearLayout_1);
        textView24 = (TextView) headerView.findViewById(R.id.textView24);
        textView25 = (TextView) headerView.findViewById(R.id.textView25);
        textView26 = (TextView) headerView.findViewById(R.id.textView26);
        textView27 = (TextView) headerView.findViewById(R.id.textView27);
        textView28 = (TextView) headerView.findViewById(R.id.textView28);
        textView29 = (TextView) headerView.findViewById(R.id.textView29);
        linearLayout_2 = (LinearLayout) headerView.findViewById(R.id.linearLayout_2);
        textView30 = (TextView) headerView.findViewById(R.id.textView30);
        textView31 = (TextView) headerView.findViewById(R.id.textView31);
        textView32 = (TextView) headerView.findViewById(R.id.textView32);

        textView1_1 = (TextView) headerView.findViewById(R.id.textView1_1);
        textView1_2 = (TextView) headerView.findViewById(R.id.textView1_2);
        textView1_3 = (TextView) headerView.findViewById(R.id.textView1_3);
        view1_1 = (ImageView) headerView.findViewById(R.id.view1_1);
        view1_2 = (ImageView) headerView.findViewById(R.id.view1_2);
        view1_3 = (ImageView) headerView.findViewById(R.id.view1_3);
        linearLayout1 = (LinearLayout) headerView.findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout) headerView.findViewById(R.id.linearLayout2);
        textView2_1 = (TextView) headerView.findViewById(R.id.textView2_1);
        textView2_2 = (TextView) headerView.findViewById(R.id.textView2_2);
        textView2_3 = (TextView) headerView.findViewById(R.id.textView2_3);
        view2_1 = (View) headerView.findViewById(R.id.view2_1);
        view2_2 = (View) headerView.findViewById(R.id.view2_2);
        view2_3 = (View) headerView.findViewById(R.id.view2_3);

        listView.addHeaderView(headerView, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*if (type == 2) {
                    //维修记录
//                    adapter2.setSelectItem(i - 1);
//                    adapter2.notifyDataSetChanged();

                }else if (type == 3){
                    //巡检记录

                }*/
            }
        });
    }

    @Override
    protected void initData() {
        EquipmentDetailActivity.this.showProgress(true, "正在获取数据...");
        number = getIntent().getStringExtra("number");
        //设备详情
        String string = "?number=" + number//台账号
                + "&type=" + "1"//1、只能查询通过审核的设备2、能查询到没有通过审核的设备
                + "&token=" + localUserInfo.getToken();
        RequestEquipmentDetail(string);
        adapter = new EquipmentDetailAdapter(EquipmentDetailActivity.this, list);
        listView.setAdapter(adapter);

    }

    //设备详情
    private void RequestEquipmentDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_DETAIL + string, new OkHttpClientManager.ResultCallback<EquipmentDetailModel1>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(EquipmentDetailActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(final EquipmentDetailModel1 response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>设备详情" + response);
                if (response != null) {
                    model = response;
                    EquipmentID = response.getId();//设备号
                    textView1.setText(response.getTitle());//设备标题
                    textView2.setText(response.getNumber());//设备编号
                    textView3.setText(response.getStation().getTitle());//站区
//                    textView4.setText(response.getArea() + "㎡");//面积
                    if (response.getType() == 1) {//判断是房屋还是构筑物
                        textView4.setText(response.getHouse_area() + "㎡");//房屋面积
                    } else {
                        textView4.setText(response.getStructures_area() + "H㎡");//构筑物面积
                    }
                    textView5.setText(response.getCompany().getTitle());//所属段改为使用单位
                    textView6.setText(response.getWorkshop().getTitle() + "车间");//所属车间
                    textView7.setText(response.getWork_area().getTitle());//所属工区

                    //维修记录
                    textView8_1.setText("[" + response.getMinor() + "]");
                    textView9_1.setText("[" + response.getMid() + "]");
                    textView10_1.setText("[" + response.getBig() + "]");
                    textView8.setText(response.getMinor_updated_at());
                    textView9.setText(response.getMid_updated_at());
                    textView10.setText(response.getBig_updated_at());

                    //设备类型-高速/普速
                    if (response.getSpeed() == 1) {
                        textView36.setText("普速");
                    } else {
                        textView36.setText("高速");
                    }
                    if (response.getType() == 1) {//判断是房屋还是构筑物
                        textView11.setText(response.getHouse_area() + "㎡");//房屋面积
                    } else {
                        textView11.setText(response.getStructures_area() + "H㎡");//构筑物面积
                    }
                    textView12.setText(response.getAddr());//设备地址
                    textView16.setText(response.getRemark());//备注
                    textView17.setText(response.getLine());//线别
                    textView18.setText(response.getCompany().getTitle());//使用单位
                    if (response.getUse_status() == 1) {
                        textView19.setText("无物");//使用状态
                    } else if (response.getUse_status() == 2) {
                        textView19.setText("闲置");//使用状态
                    } else if (response.getUse_status() == 3) {
                        textView19.setText("出租");//使用状态
                    } else if (response.getUse_status() == 4) {
                        textView19.setText("封闭");//使用状态
                    }

                    textView20.setText(response.getBuild_age());//建造时间
                    textView21.setText(response.getStructure());//结构
                    if (response.getSkill_type() == 1) {
                        textView22.setText("一级");//技术状态
                    } else if (response.getSkill_type() == 2) {
                        textView22.setText("二级");//技术状态
                    } else if (response.getSkill_type() == 3) {
                        textView22.setText("三级");//技术状态
                    }
                    if (response.getUse_nature() == 1) {
                        textView23.setText("生产");//使用性质
                    } else if (response.getUse_nature() == 2) {
                        textView23.setText("办公");//使用性质
                    } else if (response.getUse_nature() == 3) {
                        textView23.setText("宿舍");//使用性质
                    } else if (response.getUse_nature() == 4) {
                        textView23.setText("其他");//使用性质
                    }

                    //站区平面图
                    Strname = response.getStation().getMap_path();
                    if (!Strname.equals("")) {
                        textView33.setText(response.getStation().getMap_name());
                    } else {
                        textView33.setText("暂未上传");
                    }
                    //房屋平面图
                    Strname1 = response.getRoof_attachment();
                    if (!Strname1.equals("")) {
                        textView35.setText(response.getRoof_attachment());
                    } else {
                        textView35.setText("暂未上传");
                    }
                    //动态添加设备病害
                    //                    textView34.setText(response.getFacility_disease_info());//病害
                    linearLayout_add.removeAllViews();
                    if (response.getFacility_diseases() != null) {
                        for (int i = 0; i < response.getFacility_diseases().size(); i++) {
                            //设置布局
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            LayoutInflater inflater = LayoutInflater.from(EquipmentDetailActivity.this);
                            View view = inflater.inflate(R.layout.item_equipment_disease, null, false);
                            view.setLayoutParams(lp);
                            //实例化子页面的控件
                            TextView textView1 = (TextView) view.findViewById(R.id.textView1);

                            textView1.setText(response.getFacility_diseases().get(i).getContent());
                            final int finalI = i;
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //跳转病害详情
                                    Bundle bundle = new Bundle();
                                    bundle.putString("DiseaseDetailActivity", response.getFacility_diseases().get(finalI).getId());
                                    bundle.putInt("DiseaseDetailActivity_type", 1);
                                    CommonUtil.gotoActivityWithData(EquipmentDetailActivity.this, DiseaseDetailActivity.class, bundle, false);

                                }
                            });
                            linearLayout_add.addView(view);
                        }
                    }

                    if (response.getType() == 1) {
                        textView13.setText("生产房屋");//种类

                        linearLayout_1.setVisibility(View.VISIBLE);
                        linearLayout_2.setVisibility(View.GONE);
                        textView24.setText(response.getHa_total() + "H㎡");//房附总计
                        textView25.setText(response.getHouse_area() + "㎡");//房屋面积
                        textView26.setText(response.getAttached_area() + "H㎡");//附属设备
                        textView27.setText(response.getFloor() + "");//层数
                        textView28.setText(response.getRoof_form());//屋面形式
                        textView29.setText(response.getRoof_area() + "㎡");//屋面面积
                    } else {
                        textView13.setText("生产构筑物");//种类

                        linearLayout_1.setVisibility(View.GONE);
                        linearLayout_2.setVisibility(View.VISIBLE);
                        textView30.setText(response.getStructures_quantity() + "");//构筑物数量
                        textView31.setText(response.getStructures_unit() + "");//构筑物单位
                        textView32.setText(response.getStructures_area() + "H㎡");//换算面积
                    }
                    textView14.setText(response.getUse_age() + "年");//使用年限
                    //年检
//                if (response.getE_year_check() == 1) {
//                    textView15.setText("有");
//                }
                    //没有图片
                    if (response.getPic1().equals("") || response.getPic2().equals("") || response.getPic3().equals("")) {
                        imageView2.setVisibility(View.VISIBLE);
                    } else {
                        imageView2.setVisibility(View.GONE);
                        //banner
                        imageUrlList.add(URLs.HOST + response.getPic1());
                        imageUrlList.add(URLs.HOST + response.getPic2());
                        imageUrlList.add(URLs.HOST + response.getPic3());
                        if (!response.getPic4().equals("")){
                            imageUrlList.add(URLs.HOST + response.getPic4());
                        }
                        if (!response.getPic4().equals("")){
                            imageUrlList.add(URLs.HOST + response.getPic5());
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
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList, position, EquipmentDetailActivity.this);
                            }
                        });
                    }
                } else {
                    myToast("设备暂未通过审核");
                    finish();
                }

            }
        });

    }

    //维修记录
    private void RequestEquipmentMaintain(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_Maintain + string, new OkHttpClientManager.ResultCallback<EquipmentDetailModel2>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(EquipmentDetailActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(EquipmentDetailModel2 response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>维修记录" + response);


                list2_1.clear();
                list2_2.clear();
                list2_3.clear();

                list2_1 = response.getBig();
                for (int i = 0; i < list2_1.size(); i++) {
                    list2_1.get(i).setIsOpen(0);
                }
                list2_2 = response.getMid();
                for (int i = 0; i < list2_2.size(); i++) {
                    list2_2.get(i).setIsOpen(0);
                }
                list2_3 = response.getSmall();
                for (int i = 0; i < list2_3.size(); i++) {
                    list2_3.get(i).setIsOpen(0);
                }
                adapter2_1 = new EquipmentDetailAdapter2_1(EquipmentDetailActivity.this, list2_1);
                listView.setAdapter(adapter2_1);
            }
        });

    }

    //巡检记录
    private void RequestEquipmentInspection(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_INSPECTION + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(EquipmentDetailActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>巡检记录" + response);
                JSONObject jObj;
                list3 = new ArrayList<EquipmentInspectionModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list3 = JSON.parseArray(jsonArray.toString(), EquipmentInspectionModel.class);
                    adapter3 = new EquipmentDetailAdapter3(EquipmentDetailActivity.this, list3);
                    listView.setAdapter(adapter3);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //检查能否巡检
    private void RequestCheck(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_Check + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(EquipmentDetailActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>检查能否巡检" + response);
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
//                    if (type == 3){
                    if (!model.getLongitude().equals("") && !model.getLatitude().equals("")) {
                        ConfirmInspectionPopupWindow popupwindow = new ConfirmInspectionPopupWindow(EquipmentDetailActivity.this, EquipmentID, model.getLongitude(), model.getLatitude());
                        popupwindow.showAtLocation(EquipmentDetailActivity.this.findViewById(R.id.textView4), Gravity.CENTER, 0, 0);
                    } else {
                        showToast("该设备暂无位置信息");
                    }
                } else {
                    showToast("无权限进行此操作");
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_3:
                //上报病害
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EquipmentID", EquipmentID);
                    bundle.putString("publish_disease_id", "");
                    bundle.putString("faxianbinghai", "0");
                    CommonUtil.gotoActivityWithData(EquipmentDetailActivity.this, ReportDiseaseActivity.class, bundle, false);
                } else {
                    showToast("无权限进行此操作");
                }

                break;
            case R.id.textView_4:
                //确认修复-先检查是否能巡检
                /*initLocation();
                mLocClient.start();*/
                String string = "?id=" + EquipmentID//设备id
                        + "&token=" + localUserInfo.getToken();
                RequestCheck(string);
                break;
            case R.id.imageView1:
                //返回
                finish();
                break;
            case R.id.imageView2:
                //添加设备图片
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", EquipmentID);
                    CommonUtil.gotoActivityWithData(EquipmentDetailActivity.this, AddEquipmentImageActivity.class, bundle, true);
                } else {
                    showToast("无权限进行此操作");
                }

                break;
            case R.id.imageView3:
                //地图定位
                AlertDialog.Builder builder = new AlertDialog.Builder(EquipmentDetailActivity.this);
                builder.setMessage("确定在此定位，以更新该设备位置信息？");
                builder.setTitle("提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EquipmentDetailActivity.this.showProgress(true, "正在获取当前位置，请稍后...");
                        isChange = true;

                        initLocation();
                        mLocationClient.start();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                break;

            case R.id.textView12:
                //导航-判断手机是否装有百度地图、高德地图、腾讯地图，如无则显示网页版百度地图
                if (model != null && !model.getLongitude().equals("") && !model.getLatitude().equals("")) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(EquipmentDetailActivity.this);
                    builder1.setMessage("确定跳转到百度地图进行导航？");
                    builder1.setTitle("提示");
                    builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent naviIntent = new Intent("android.intent.action.VIEW",
                                    android.net.Uri.parse("baidumap://map/geocoder?location=" + model.getLatitude() + "," + model.getLongitude()));
                            startActivity(naviIntent);
                        }
                    });
                    builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder1.create().show();
//                    NavigationPopupWindow popupwindow = new NavigationPopupWindow(EquipmentDetailActivity.this,
//                            model.getLatitude(),model.getLongitude());
//                    popupwindow.showAtLocation(EquipmentDetailActivity.this.findViewById(R.id.textView12), Gravity.CENTER, 0, 0);
                } else {
                    showToast("该设备暂无位置信息");
                }
                break;
            case R.id.textView33:
                //站区平面图
                if (!Strname.equals("")) {
                    if (Strname.substring(Strname.length() - 3).equals("pdf")) {
                        //是pdf文件
                        mProgressDialog = new ProgressDialog(EquipmentDetailActivity.this);
                        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        mProgressDialog.setCancelable(false);
                        mProgressDialog.show();
                        //截取最后14位 作为文件名
                        String s = Strname.substring(Strname.length() - 14);
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
                                File downloadfile = downLoad(URLs.HOST + Strname, file1.getAbsolutePath(), mProgressDialog);
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
                        //不是pdf文件
                        Intent intent = new Intent();
                        intent.putExtra("url", Strname);
                        intent.setClass(EquipmentDetailActivity.this, ShowSignatureActivity.class);
                        startActivity(intent);
                    }

                } else {
                    showToast("暂未上传站区平面图");
                }
                break;
            case R.id.textView35:
                //房屋平面图
                if (!Strname1.equals("")) {
                    if (Strname1.substring(Strname1.length() - 3).equals("pdf")) {
                        //是pdf文件
                        mProgressDialog = new ProgressDialog(EquipmentDetailActivity.this);
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
                                File downloadfile = downLoad(URLs.HOST + Strname, file1.getAbsolutePath(), mProgressDialog);
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
                        //不是pdf文件
                        Intent intent = new Intent();
                        intent.putExtra("url", Strname1);
                        intent.setClass(EquipmentDetailActivity.this, ShowSignatureActivity.class);
                        startActivity(intent);
                    }

                } else {
                    showToast("暂未上传房屋平面图");
                }
                break;
            case R.id.textView37:
                //细部明细
                Bundle bundle = new Bundle();
                bundle.putString("EquipmentID", EquipmentID);
                CommonUtil.gotoActivityWithData(EquipmentDetailActivity.this, DetailedDetailsActivity.class, bundle, false);

                break;
            case R.id.linearLayout1_1:
                //基本信息
                textView1_1.setTextColor(getResources().getColor(R.color.lightblue500));
                view1_1.setImageResource(R.mipmap.xuanzhong1);
                textView1_2.setTextColor(getResources().getColor(R.color.default_text));
                view1_2.setImageResource(R.mipmap.weixuan1);
                textView1_3.setTextColor(getResources().getColor(R.color.default_text));
                view1_3.setImageResource(R.mipmap.weixuan1);
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.GONE);

                list = new ArrayList<EquipmentDetailModel>();
                EquipmentDetailAdapter adapter = new EquipmentDetailAdapter(EquipmentDetailActivity.this, list);
                listView.setAdapter(adapter);

                type = 1;
                break;
            case linearLayout1_2:
                //维修记录
                textView1_1.setTextColor(getResources().getColor(R.color.default_text));
                view1_1.setImageResource(R.mipmap.weixuan1);
                textView1_2.setTextColor(getResources().getColor(R.color.lightblue500));
                view1_2.setImageResource(R.mipmap.xuanzhong1);
                textView1_3.setTextColor(getResources().getColor(R.color.default_text));
                view1_3.setImageResource(R.mipmap.weixuan1);

                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.VISIBLE);

                type = 2;

                //默认选中第一个
                textView2_1.setTextColor(getResources().getColor(R.color.lightblue500));
                textView2_2.setTextColor(getResources().getColor(R.color.default_text));
                textView2_3.setTextColor(getResources().getColor(R.color.default_text));
                view2_1.setBackgroundResource(R.color.blue);
                view2_2.setBackgroundResource(R.color.white);
                view2_3.setBackgroundResource(R.color.white);

                //维修记录
                String string2 = "?facility_id=" + EquipmentID//设id
                        + "&token=" + localUserInfo.getToken();
                RequestEquipmentMaintain(string2);
                break;
            case R.id.linearLayout1_3:
                //巡检记录
                textView1_1.setTextColor(getResources().getColor(R.color.default_text));
                view1_1.setImageResource(R.mipmap.weixuan1);
                textView1_2.setTextColor(getResources().getColor(R.color.default_text));
                view1_2.setImageResource(R.mipmap.weixuan1);
                textView1_3.setTextColor(getResources().getColor(R.color.lightblue500));
                view1_3.setImageResource(R.mipmap.xuanzhong1);
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);

                type = 3;
                //巡检记录
                String string3 = "?facility_id=" + EquipmentID//设id
                        + "&token=" + localUserInfo.getToken();
                RequestEquipmentInspection(string3);
                break;
            case R.id.linearLayout2_1:
                //大修
                textView2_1.setTextColor(getResources().getColor(R.color.lightblue500));
                textView2_2.setTextColor(getResources().getColor(R.color.default_text));
                textView2_3.setTextColor(getResources().getColor(R.color.default_text));
                view2_1.setBackgroundResource(R.color.blue);
                view2_2.setBackgroundResource(R.color.white);
                view2_3.setBackgroundResource(R.color.white);

                adapter2_1 = new EquipmentDetailAdapter2_1(EquipmentDetailActivity.this, list2_1);
                listView.setAdapter(adapter2_1);
                break;
            case R.id.linearLayout2_2:
                //综合维修
                textView2_1.setTextColor(getResources().getColor(R.color.default_text));
                textView2_2.setTextColor(getResources().getColor(R.color.lightblue500));
                textView2_3.setTextColor(getResources().getColor(R.color.default_text));
                view2_1.setBackgroundResource(R.color.white);
                view2_2.setBackgroundResource(R.color.blue);
                view2_3.setBackgroundResource(R.color.white);

                adapter2_2 = new EquipmentDetailAdapter2_2(EquipmentDetailActivity.this, list2_2);
                listView.setAdapter(adapter2_2);
                break;
            case R.id.linearLayout2_3:
                //请检修
                textView2_1.setTextColor(getResources().getColor(R.color.default_text));
                textView2_2.setTextColor(getResources().getColor(R.color.default_text));
                textView2_3.setTextColor(getResources().getColor(R.color.lightblue500));
                view2_1.setBackgroundResource(R.color.white);
                view2_2.setBackgroundResource(R.color.white);
                view2_3.setBackgroundResource(R.color.blue);

                adapter2_3 = new EquipmentDetailAdapter2_3(EquipmentDetailActivity.this, list2_3);
                listView.setAdapter(adapter2_3);
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
//            Glide.with(context).load(R.mipmap.headimg).fitCenter().into(imageView);
        }
    }


    /**
     * ********************************************定位**********************************************
     */
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        option.setCoorType("bd09ll");

        option.setScanSpan(1000);

        option.setOpenGps(true);

        option.setIsNeedAddress(true);

        option.setLocationNotify(true);//可选，设置是否当GPS有效时按照1S/1次频率输出GPS结果，默认false

        option.setIgnoreKillProcess(false);

        option.SetIgnoreCacheException(false);

        option.setWifiCacheTimeOut(5 * 60 * 1000);

        option.setEnableSimulateGps(false);

        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取经纬度相关（常用）的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            double latitude1 = location.getLatitude();    //获取纬度信息
            double longitude1 = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();//获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准

            int errorCode = location.getLocType();//获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
            String addr1 = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息


//            editText6.setText(location.getAddrStr()+"");
            longitude = location.getLongitude() + "";
            latitude = location.getLatitude() + "";
            addr = location.getAddrStr() + "";
            MyLogger.i(">>>>>>>>>>>>详细信息" + addr + longitude + ">>>>" + latitude);
            mLocationClient.stop();

            //定位完毕
            hideProgress();
            if (!addr.equals("") && isChange == true) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EquipmentDetailActivity.this);
                builder.setMessage("确认将位置修改为" + addr + "？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
//                        showProgress(true, "正在修改数据，请稍后...");
                        params.put("id", EquipmentID);//有id值：修改，无id值：增加
                        params.put("employee_id", localUserInfo.getUserId());
                        params.put("number", "");//台帐号
                        params.put("title", "");//名称
                        params.put("longitude", longitude);
                        params.put("latitude", latitude);
                        params.put("addr", addr);
                        params.put("token", localUserInfo.getToken());//token
                        RequestAddEquipment(params);//添加设备

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }

        }
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocationClient.stop();
        super.onDestroy();
    }

    private void RequestAddEquipment(HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.EQUIPMENT_ADD, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
//                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>添加设备" + response);
//                hideProgress();
                myToast("修改成功");
                finish();
            }
        }, this);

    }


    //根据两个经纬度计算之间的距离 （单位： 米）
    public static double getDistance(double longitude1, double latitude1,
                                     double longitude2, double latitude2) {
        double Lat1 = rad(latitude1);
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;
        double b = rad(longitude1) - rad(longitude2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(Lat1) * Math.cos(Lat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;//地球半径
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
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
                    Uri uri = getUriForFile(EquipmentDetailActivity.this, file);
                    intent.setDataAndType(uri, "application/pdf");
//              startActivity(intent);
                    startActivity(Intent.createChooser(intent, "标题"));
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
