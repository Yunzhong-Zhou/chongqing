package com.zhitiekeji.equipmentmanagement.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.PleaseOverhaulDetailAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter1;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.MaterialModel;
import com.zhitiekeji.equipmentmanagement.model.PleaseOverhaulDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/6/15.
 * 请检修详情
 */

public class PleaseOverhaulDetailActivity extends BaseActivity {
    String EquipmentID = "";
    boolean isrepair = false;
    PleaseOverhaulDetailModel model;
    private ListView listView;
    List<PleaseOverhaulDetailModel.FacilityServiceApplyBean.FacilityDiseaseListBean> list =
            new ArrayList<PleaseOverhaulDetailModel.FacilityServiceApplyBean.FacilityDiseaseListBean>();
    List<PleaseOverhaulDetailModel.FacilityServiceApplyBean.FacilityDiseaseListBean> list1 =
            new ArrayList<PleaseOverhaulDetailModel.FacilityServiceApplyBean.FacilityDiseaseListBean>();
    PleaseOverhaulDetailAdapter adapter;
    View headerView;
    Banner banner;
    //派修工单  病害列表
    private ImageView imageView1;
    private TextView textView1_1, textView1_2, textView2_1, textView2_2, textView2_3;
    private LinearLayout linearLayout1_1, linearLayout1_2;
    private View view1_1, view1_2;
    private LinearLayout linearLayout1;
    int type = 1;
    /*基本信息控件*/
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9, textView10, textView8_1, textView9_1, textView10_1;

    //派修工单
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7,
            editText8, editText9, editText10, editText11;
    TextView textView11, textView12, textView13, textView14, textView15, textView16, textView17,
            next, textView18, textView_time;
    LinearLayout linearLayout_add, linearLayout2, add;


    boolean isShowAddText = false;
    private TimePickerView pvTime1, pvTime2, pvTime3;//时间选择器
    String start_at = "";
    String end_at = "";
    String visit_time = "", visit_name = "";
    String secure_item = "", implement_content = "", client_mobile = "", client_name = "", client_feedback = "";
    //工时消耗（json数据：天/金额） 如：{ "day": "10", "money": "1000"}
    String day = "", money1 = "";
    String manhour = "";
    //汽车消耗（json数据：KM/金额） 如：{ "length": "10", "money": "500"}
    String length = "", money2 = "";
    String mileage = "";
    //材料消耗（json数据：种类/数量/金额） 如：[{ "material_id": "x01", "qty": "8", "money": "800"}, { "material_id": "x02", "qty": "20", "money": "2000"}]
//    List<MaterialJsonModel> materialjsonlist = new ArrayList<MaterialJsonModel>();
    String material = "";
    //材料选择下标
    int i_1 = 0;
    int i_2 = 0;
    ArrayList<String> listFileNames = new ArrayList<>();
    ArrayList<File> listFiles = new ArrayList<>();
    //材料数据-父类
    List<MaterialModel> materialList1 = new ArrayList<MaterialModel>();
    //材料数据-子类
    List<MaterialModel> materialList2 = new ArrayList<MaterialModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pleaseoverhauldetail);
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.listView);

        headerView = View.inflate(this, R.layout.head_pleaseoverhauldetail, null);
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

        editText1 = (EditText) headerView.findViewById(R.id.editText1);
        editText2 = (EditText) headerView.findViewById(R.id.editText2);
        editText3 = (EditText) headerView.findViewById(R.id.editText3);
        editText4 = (EditText) headerView.findViewById(R.id.editText4);
        editText5 = (EditText) headerView.findViewById(R.id.editText5);
        editText6 = (EditText) headerView.findViewById(R.id.editText6);
        editText7 = (EditText) headerView.findViewById(R.id.editText7);
        textView11 = (TextView) headerView.findViewById(R.id.textView11);
        textView12 = (TextView) headerView.findViewById(R.id.textView12);
        textView13 = (TextView) headerView.findViewById(R.id.textView13);
        textView14 = (TextView) headerView.findViewById(R.id.textView14);
        textView15 = (TextView) headerView.findViewById(R.id.textView15);
        textView16 = (TextView) headerView.findViewById(R.id.textView16);
        textView17 = (TextView) headerView.findViewById(R.id.textView17);
        next = (TextView) headerView.findViewById(R.id.next);
        add = (LinearLayout) headerView.findViewById(R.id.add);
        linearLayout_add = (LinearLayout) headerView.findViewById(R.id.linearLayout_add);

        editText8 = (EditText) headerView.findViewById(R.id.editText8);
        editText9 = (EditText) headerView.findViewById(R.id.editText9);
        editText10 = (EditText) headerView.findViewById(R.id.editText10);
        editText11 = (EditText) headerView.findViewById(R.id.editText11);
        textView_time = headerView.findViewById(R.id.textView_time);
        textView18 = (TextView) headerView.findViewById(R.id.textView18);
        linearLayout2 = (LinearLayout) headerView.findViewById(R.id.linearLayout2);

        textView1_1 = (TextView) headerView.findViewById(R.id.textView1_1);
        textView1_2 = (TextView) headerView.findViewById(R.id.textView1_2);
        linearLayout1_1 = (LinearLayout) headerView.findViewById(R.id.linearLayout1_1);
        linearLayout1_2 = (LinearLayout) headerView.findViewById(R.id.linearLayout1_2);
        view1_1 = (View) headerView.findViewById(R.id.view1_1);
        view1_2 = (View) headerView.findViewById(R.id.view1_2);
        linearLayout1 = (LinearLayout) headerView.findViewById(R.id.linearLayout1);

        listView.addHeaderView(headerView, null, false);//添加头部，必须设置adapter，不然不会显示,头部不可点击

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (type == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("DiseaseDetailActivity", list.get(i - 1).getId());
                    if (isrepair == true) {
                        bundle.putInt("DiseaseDetailActivity_type", 5);
                    } else {
                        bundle.putInt("DiseaseDetailActivity_type", 1);
                    }
                    CommonUtil.gotoActivityWithData(PleaseOverhaulDetailActivity.this, DiseaseDetailActivity.class, bundle, false);
                }
            }
        });
    }

    @Override
    protected void initData() {
        this.showProgress(true, "正在获取数据...");
        EquipmentID = getIntent().getStringExtra("EquipmentID");
        //材料种类
        String string = "?parent_id=" + ""//父id（当不传此参数时，查询材料种类）
                + "&token=" + localUserInfo.getToken();
        RequestMaterial1(string);
        //详细信息
        String string1 = "?id=" + EquipmentID//申请ID
                + "&token=" + localUserInfo.getToken();
        RequestReportDetail(string1);

        adapter = new PleaseOverhaulDetailAdapter(PleaseOverhaulDetailActivity.this, list);
        listView.setAdapter(adapter);

        initTimePicker1();

        initTimePicker3();

    }

    //请检修详情
    private void RequestReportDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_OVERHAULDETAIL + string, new OkHttpClientManager.ResultCallback<PleaseOverhaulDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(PleaseOverhaulDetailModel response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>详细信息" + response);
                if (response != null) {
//                    facility_service_approval_id = response.getId();
                    //判断是否完成
                    if (response.getStatus() == 3) {
                        //完成
                        isrepair = true;
                    } else {
                        isrepair = false;
                    }

                    model = response;
                    //设备详情
                    textView1.setText(response.getFacility().getTitle());//设备标题
                    textView2.setText(response.getFacility().getNumber());//设备编号
                    textView3.setText(response.getFacility().getStation().getTitle());//站区
                    if (response.getFacility().getType() == 1) {//判断是房屋还是构筑物
                        textView4.setText(response.getFacility().getHouse_area() + "㎡");//房屋面积
                    } else {
                        textView4.setText(response.getFacility().getStructures_area() + "H㎡");//构筑物面积
                    }

                    textView5.setText(response.getFacility().getCompany().getTitle());//所属段改为使用单位
                    textView6.setText(response.getFacility().getWorkshop().getTitle() + "车间");//所属车间
                    textView7.setText(response.getFacility().getWork_area().getTitle());//所属工区
                    textView8_1.setText("[" + response.getMinor() + "]");
                    textView9_1.setText("[" + response.getMid() + "]");
                    textView10_1.setText("[" + response.getBig() + "]");
                    textView8.setText(response.getMinor_updated_at());
                    textView9.setText(response.getMid_updated_at());
                    textView10.setText(response.getBig_updated_at());

                    if (response.getStart_at() != null && !response.getStart_at().equals("")) {
                        start_at = response.getStart_at();
                        textView11.setText(response.getStart_at());//派工时间
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getEnd_at() != null && !response.getEnd_at().equals("")) {
                        end_at = response.getEnd_at();
                        textView12.setText(response.getEnd_at());//完工时间
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getManhour() != null && !response.getManhour().getDay().equals("")) {
                        editText1.setText(response.getManhour().getDay());//工时消耗数量
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getManhour() != null && !response.getManhour().getMoney().equals("")) {
                        editText2.setText(response.getManhour().getMoney());//工时消耗金额
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getMileage() != null && !response.getMileage().getLength().equals("")) {
                        editText3.setText(response.getMileage().getLength());//汽车消耗数量
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getMileage() != null && !response.getMileage().getMoney().equals("")) {
                        editText4.setText(response.getMileage().getMoney());//汽车消耗金额
                    } else {
                        isShowAddText = true;
                    }
                    //材料
                    if (response.getMaterial() != null && response.getMaterial().size() != 0) {
                        for (int i = 0; i < response.getMaterial().size(); i++) {
                            addMaterialView(response.getMaterial().get(i).getMaterial_id(),
                                    response.getMaterial().get(i).getMaterial_title(),
                                    response.getMaterial().get(i).getQty(),
                                    response.getMaterial().get(i).getMoney());//添加材料布局
                        }
                    } else {
                        addMaterialView("", "", "", "");//添加材料布局
                        isShowAddText = true;
                    }
                    if (response.getAmount() != null && !response.getAmount().equals("")) {
                        editText5.setText(response.getAmount());//小计
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getSecure_item() != null && !response.getSecure_item().equals("")) {
                        editText6.setText(response.getSecure_item());//安全事项
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getImplement_content() != null && !response.getImplement_content().equals("")) {
                        editText7.setText(response.getImplement_content());//施工内容
                    } else {
                        isShowAddText = true;
                    }


                    if (response.getClient_mobile() != null && !response.getClient_mobile().equals("")) {
                        editText8.setText(response.getClient_mobile());//用户电话
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getClient_feedback() != null && !response.getClient_feedback().equals("")) {
                        editText9.setText(response.getClient_feedback());//用户意见
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getClient_name() != null && !response.getClient_name().equals("")) {
                        editText10.setText(response.getClient_name());//用户姓名
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getVisit_name() != null && !response.getVisit_name().equals("")) {
                        editText11.setText(response.getVisit_name());//回访人
                    } else {
                        isShowAddText = true;
                    }
                    if (response.getVisit_time() != null && !response.getVisit_time().equals("")) {
                        visit_time = response.getVisit_time();
                        textView_time.setText(response.getVisit_time());//回访时间
                    } else {
                        isShowAddText = true;
                    }


                    //现场签字
                    if (!response.getScene_signature().equals("")) {
                        textView13.setText("点击查看现场签名");
                    } else {
                        isShowAddText = true;
                    }
                    //工长签字
                    if (!response.getSection_signature().equals("")) {
                        textView14.setText("点击查看工长签名");
                    } else {
                        isShowAddText = true;
                    }
                    //技术员
                    if (!response.getSkill_signature().equals("")) {
                        textView15.setText("点击查看技术员签名");
                    } else {
                        isShowAddText = true;
                    }
                    //劳务签字
                    if (!response.getLabour_signature().equals("")) {
                        textView16.setText("点击查看劳务签名");
                    } else {
                        isShowAddText = true;
                    }
                    //回访人签字
                    if (!response.getEmployee_signature().equals("")) {
                        textView17.setText("点击查看回访人签名");
                    } else {
                        isShowAddText = true;
                    }


                    ArrayList<String> imageUrlList = new ArrayList<String>();
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
                    banner.setOnBannerClickListener(new OnBannerClickListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            //下标从1开始
//                openJuamp(position - 1, linkUrlArray);
                        }
                    });
                    //病害列表
                    if (response.getFacility_service_apply() != null) {
                        list = response.getFacility_service_apply().getFacility_disease_list();
                    }

                    if (isShowAddText) {
                        add.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                    } else {
                        add.setVisibility(View.GONE);
                        next.setVisibility(View.GONE);
                    }


                }
            }
        });

    }

    //材料种类-父类
    private void RequestMaterial1(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_Material + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>材料种类-父类" + response);
                JSONObject jObj;
                materialList1 = new ArrayList<MaterialModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    materialList1 = JSON.parseArray(jsonArray.toString(), MaterialModel.class);

                    if (materialList1.size() > 0) {
                        //材料-子类-获取第一个材料
                        String string = "?parent_id=" + materialList1.get(0).getId()//父id（当不传此参数时，查询材料种类）
                                + "&token=" + localUserInfo.getToken();
                        RequestMaterial2(string);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //材料种类-子类
    private void RequestMaterial2(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_Material + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>材料种类-子类" + response);
                JSONObject jObj;
                materialList2 = new ArrayList<MaterialModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    materialList2 = JSON.parseArray(jsonArray.toString(), MaterialModel.class);

                    list2 = new ArrayList<String>();
                    for (int i = 0; i < materialList2.size(); i++) {
                        list2.add(materialList2.get(i).getTitle());
                    }
                    if (pop_listView2 != null) {
                        adapter2 = new Pop_Equipment2Adapter1(PleaseOverhaulDetailActivity.this, list2);
                        pop_listView2.setAdapter(adapter2);
//                        adapter2.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //修改请检修资料
    private void RequestChangePleaseOverhaul(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_ADDOVERHAU_Change, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>修改请检修资料" + response);
                showToast("修改成功", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

            }
        }, this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                adapter = new PleaseOverhaulDetailAdapter(PleaseOverhaulDetailActivity.this, list1);
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

                adapter = new PleaseOverhaulDetailAdapter(PleaseOverhaulDetailActivity.this, list);
                listView.setAdapter(adapter);
                type = 2;
                break;


            case R.id.textView11:
                //派工时间
                pvTime1.show(textView11);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            case R.id.textView12:
                //完工时间
                if (!start_at.equals(""))
                    pvTime2.show(textView12);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                else
                    showToast("请先选择派工时间");
                break;
            case R.id.textView13:
                //现场
                if (textView13.getText().toString().trim().equals("点击查看现场签名")) {
                    Intent intent = new Intent();
                    intent.putExtra("url", model.getScene_signature());
                    intent.setClass(PleaseOverhaulDetailActivity.this, ShowSignatureActivity.class);
                    startActivity(intent);
                } else {
                    Bundle bundle13 = new Bundle();
                    bundle13.putString("name", "现场");
                    CommonUtil.gotoActivityWithDataForResult(PleaseOverhaulDetailActivity.this, SignatureMoreActivity.class, bundle13, 10020, false);
                }

                break;
            case R.id.textView14:
                //工长
                if (textView14.getText().toString().trim().equals("点击查看工长签名")) {
                    Intent intent = new Intent();
                    intent.putExtra("url", model.getSection_signature());
                    intent.setClass(PleaseOverhaulDetailActivity.this, ShowSignatureActivity.class);
                    startActivity(intent);
                } else {
                    Bundle bundle14 = new Bundle();
                    bundle14.putString("name", "工长");
                    CommonUtil.gotoActivityWithDataForResult(PleaseOverhaulDetailActivity.this, SignatureMoreActivity.class, bundle14, 10021, false);
                }

                break;
            case R.id.textView15:
                //技术员
                if (textView15.getText().toString().trim().equals("点击查看技术员签名")) {
                    Intent intent = new Intent();
                    intent.putExtra("url", model.getSkill_signature());
                    intent.setClass(PleaseOverhaulDetailActivity.this, ShowSignatureActivity.class);
                    startActivity(intent);
                } else {
                    Bundle bundle15 = new Bundle();
                    bundle15.putString("name", "技术员");
                    CommonUtil.gotoActivityWithDataForResult(PleaseOverhaulDetailActivity.this, SignatureMoreActivity.class, bundle15, 10022, false);
                }

                break;
            case R.id.textView16:
                //劳务公司
                if (textView16.getText().toString().trim().equals("点击查看劳务签名")) {
                    Intent intent = new Intent();
                    intent.putExtra("url", model.getLabour_signature());
                    intent.setClass(PleaseOverhaulDetailActivity.this, ShowSignatureActivity.class);
                    startActivity(intent);
                } else {
                    Bundle bundle16 = new Bundle();
                    bundle16.putString("name", "劳务公司");
                    CommonUtil.gotoActivityWithDataForResult(PleaseOverhaulDetailActivity.this, SignatureMoreActivity.class, bundle16, 10023, false);
                }

                break;
            case R.id.textView17:
                //回访人签字
                if (textView17.getText().toString().trim().equals("点击查看回访人签名")) {
                    Intent intent = new Intent();
                    intent.putExtra("url", model.getEmployee_signature());
                    intent.setClass(PleaseOverhaulDetailActivity.this, ShowSignatureActivity.class);
                    startActivity(intent);
                } else {
                    Bundle bundle17 = new Bundle();
                    bundle17.putString("name", "回访人");
                    CommonUtil.gotoActivityWithDataForResult(PleaseOverhaulDetailActivity.this, SignatureMoreActivity.class, bundle17, 10024, false);
                }

                break;
            case R.id.textView_time:
                //回访时间
                pvTime3.show(textView_time);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            case R.id.next:
                //确认提交
                if (match()) {
                    MyLogger.i(">>>>>>>>>工时消耗：" + manhour + ">>>>>>>>>汽车消耗：" + mileage + ">>>>>>材料消耗：" + material);
                    showProgress(true, "正在上传数据，请稍后...");
                    String[] filenames = new String[]{};
                    File[] files = new File[]{};
                    for (int i = 0; i < listFiles.size(); i++) {
                        filenames = listFileNames.toArray(new String[i]);
                        files = listFiles.toArray(new File[i]);
                    }
                    params.put("token", localUserInfo.getToken());//token
                    params.put("id", model.getId());//id
                    params.put("start_at", start_at);//派工时间
                    params.put("end_at", end_at);//完工时间
                    params.put("secure_item", secure_item);//安全事项
                    params.put("implement_content", implement_content);//实施内容
                    params.put("client_mobile", client_mobile);//用户电话
                    params.put("client_name", client_name);//用户姓名
                    params.put("client_feedback", client_feedback);//用户反馈
                    params.put("visit_time", visit_time);//回访时间
                    params.put("visit_name", visit_name);//回访人

                    params.put("manhour", manhour);//工时消耗（json数据：天/金额） 如：{ "day": "10", "money": "1000"}
                    params.put("mileage", mileage);//汽车消耗（json数据：KM/金额） 如：{ "length": "10", "money": "500"}
                    params.put("material", material);//材料消耗（json数据：种类/数量/金额） 如：[{ "material_id": "x01", "qty": 8, "money": "800"}, { "material_id": "x02", "qty": 20, "money": "2000"}]
                    RequestChangePleaseOverhaul(filenames, files, params);//设备列表
                }
                break;
            /*case R.id.linearLayout2:
                //材料种类
                showPopupWindow(linearLayout2,textView18,textView_1);
                break;*/
            case R.id.add:
                //添加布局
                addMaterialView("", "", "", "");//添加材料布局
                break;
        }
    }

    private boolean match() {
        if (TextUtils.isEmpty(start_at)) {
            showToast("请选择派工时间");
            return false;
        }
        if (TextUtils.isEmpty(end_at)) {
            showToast("请选择完工时间");
            return false;
        }
        //工时消耗
        day = editText1.getText().toString().trim();
        /*if (TextUtils.isEmpty(day)) {
            myToast("请输入工时消耗的天数");
            return false;
        }*/
        money1 = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(money1)) {
            showToast("请输入工时消耗的金额");
            return false;
        }
        try {
            JSONObject mJsonobjData = new JSONObject();
            mJsonobjData.put("day", day);
            mJsonobjData.put("money", money1);
            manhour = mJsonobjData.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //汽车消耗
        length = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(length)) {
            showToast("请输入汽车消耗的距离");
            return false;
        }
        money2 = editText4.getText().toString().trim();
        if (TextUtils.isEmpty(money2)) {
            showToast("请输入汽车消耗的金额");
            return false;
        }
        try {
            JSONObject mJsonobjData = new JSONObject();
            mJsonobjData.put("length", length);
            mJsonobjData.put("money", money2);
            mileage = mJsonobjData.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //材料消耗
        JSONArray idCradArray = new JSONArray();
        for (int i = 0; i < linearLayout_add.getChildCount(); i++) {
            View childAt = linearLayout_add.getChildAt(i);
            TextView textView_1 = (TextView) childAt.findViewById(R.id.textView_1);
            EditText editText_1 = (EditText) childAt.findViewById(R.id.editText_1);
            EditText editText_2 = (EditText) childAt.findViewById(R.id.editText_2);

            if (!TextUtils.isEmpty(textView_1.getText().toString()) && !TextUtils.isEmpty(editText_1.getText().toString()) && !TextUtils.isEmpty(editText_2.getText().toString())) {
                try {
                    JSONObject stoneObject = new JSONObject();
                    stoneObject.put("material_id", textView_1.getText().toString());
                    stoneObject.put("qty", editText_1.getText().toString().trim());
                    stoneObject.put("money", editText_2.getText().toString().trim());
                    idCradArray.put(stoneObject);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            } else {
                showToast("请完善材料消耗");
            }
        }
        material = idCradArray.toString();

        secure_item = editText6.getText().toString().trim();
        if (TextUtils.isEmpty(secure_item)) {
            showToast("请输入注意安全事项");
            return false;
        }
        implement_content = editText7.getText().toString().trim();
        if (TextUtils.isEmpty(implement_content)) {
            showToast("请输入施工内容");
            return false;
        }
        client_mobile = editText8.getText().toString().trim();
        if (TextUtils.isEmpty(client_mobile)) {
            showToast("请输入用户电话");
            return false;
        }
        client_feedback = editText9.getText().toString().trim();
        if (TextUtils.isEmpty(client_feedback)) {
            showToast("请输入用户反馈");
            return false;
        }
        client_name = editText10.getText().toString().trim();
        if (TextUtils.isEmpty(client_name)) {
            showToast("请输入用户姓名");
            return false;
        }
        visit_name = editText11.getText().toString().trim();
        if (TextUtils.isEmpty(visit_name)) {
            showToast("请输入回访人姓名");
            return false;
        }

        return true;
    }

    //添加材料布局
    private void addMaterialView(String material_id, String material_title, String qty, String money) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater = LayoutInflater.from(PleaseOverhaulDetailActivity.this);
        View view = inflater.inflate(R.layout.item_pleaseoverhauldetail_material, null, false);
        view.setLayoutParams(lp);
        //实例化子页面的控件
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        final TextView textView_1 = (TextView) view.findViewById(R.id.textView_1);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        EditText editText_1 = (EditText) view.findViewById(R.id.editText_1);
        EditText editText_2 = (EditText) view.findViewById(R.id.editText_2);
        if (!material_id.equals("")) {
            textView.setText(material_title);
            textView_1.setText(material_id);
            editText_1.setText(qty);
            editText_2.setText(money);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(linearLayout, textView, textView_1);
            }
        });
        linearLayout_add.addView(view);
    }

    private void initTimePicker1() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
//        startDate.set(2013,0,23);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2019,11,28);
        //时间选择器
        pvTime1 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView txt = (TextView) v;
                txt.setText(getTime(date));
                start_at = getTime(date);

                SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
                SimpleDateFormat format_m = new SimpleDateFormat("MM");
                SimpleDateFormat format_d = new SimpleDateFormat("dd");
                initTimePicker2(Integer.valueOf(format_y.format(date).toString()),
                        Integer.valueOf(format_m.format(date).toString()) - 1,
                        Integer.valueOf(format_d.format(date).toString()) + 1);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
//                .setRangDate(startDate,endDate)
                .build();
    }

    private void initTimePicker2(int y, int m, int d) {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(y, m, d);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2100, 11, 31);
        //时间选择器
        pvTime2 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                end_at = getTime(date);
                TextView txt = (TextView) v;
                txt.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .build();
    }

    private void initTimePicker3() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
//        startDate.set(2013,0,23);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2019,11,28);
        //时间选择器
        pvTime3 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView txt = (TextView) v;
                txt.setText(getTime(date));
                visit_time = getTime(date);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
//                .setRangDate(startDate,endDate)
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
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

    Pop_Equipment2Adapter1 adapter2;
    ListView pop_listView2;
    List<String> list2 = new ArrayList<String>();

    private void showPopupWindow(View v, final TextView textView, final TextView textView_1) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(PleaseOverhaulDetailActivity.this).inflate(
                R.layout.pop_list2, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.linearLayout).getTop();
                int height1 = contentView.findViewById(R.id.linearLayout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView1 = (ListView) contentView.findViewById(R.id.pop_listView1);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < materialList1.size(); i++) {
            list.add(materialList1.get(i).getTitle());
        }

        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(PleaseOverhaulDetailActivity.this, list);
        adapter.setSelectItem(i_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i_1 = i;
                i_2 = 0;
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
//                popupWindow.dismiss();
                //材料-子类-获取第一个材料
                String string = "?parent_id=" + materialList1.get(i).getId()//父id（当不传此参数时，查询材料种类）
                        + "&token=" + localUserInfo.getToken();
                RequestMaterial2(string);

            }
        });
        pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        adapter2 = new Pop_Equipment2Adapter1(PleaseOverhaulDetailActivity.this, list2);
        adapter2.setSelectItem(i_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i_2 = i;
                adapter2.setSelectItem(i);
                adapter2.notifyDataSetChanged();

                textView_1.setText(materialList2.get(i).getId());//保存材料id
                textView.setText(materialList2.get(i).getTitle());
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
//        popupWindow.showAsDropDown(v);
        if (Build.VERSION.SDK_INT < 24) {
            popupWindow.showAsDropDown(v);
        } else {
            // 适配 android 7.0
            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            Log.e(getClass().getSimpleName(), "x : " + x + ", y : " + y);
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, y + v.getHeight());
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 10020:
                    //现场
                    textView13.setClickable(false);
                    textView13.setText("现场已签名");
                    showToast("现场签名成功");
                    listFileNames.add("scene_signature");
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_现场.png";
                    File file1 = new File(path);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file1);
                    break;
                case 10021:
                    //工长
                    textView14.setClickable(false);
                    textView14.setText("工长已签名");
                    showToast("工长签名成功");
                    listFileNames.add("section_signature");
                    String path2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_工长.png";
                    File file2 = new File(path2);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file2);
                    break;
                case 10022:
                    //技术员
                    textView15.setClickable(false);
                    textView15.setText("技术员已签名");
                    showToast("技术员签名成功");
                    listFileNames.add("skill_signature");
                    String path3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_技术员.png";
                    File file3 = new File(path3);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file3);
                    break;
                case 10023:
                    //劳务公司
                    textView16.setClickable(false);
                    textView16.setText("劳务公司已签名");
                    showToast("劳务公司签名成功");
                    listFileNames.add("labour_signature");
                    String path4 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_劳务公司.png";
                    File file4 = new File(path4);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file4);
                    break;
                case 10024:
                    //回访人签字
                    textView17.setClickable(false);
                    textView17.setText("回访人已签名");
                    showToast("回访人签名成功");
                    listFileNames.add("employee_signature");
                    String path5 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_回访人.png";
                    File file5 = new File(path5);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file5);
                    break;
            }

        }

    }
}
