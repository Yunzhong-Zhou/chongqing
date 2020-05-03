package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.MyReportDetaiRecycleViewImageAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.DiseaseDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import java.util.ArrayList;

/**
 * Created by fafukeji01 on 2017/6/20.
 * 病害详情
 */

public class DiseaseDetailActivity extends BaseActivity {
    int type = 0;
    String diseaseId = "";
    private LinearLayout linearLayout1, linearLayout2;
    private TextView xiufu;

    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9, textView10, textView11, textView12;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    RecyclerView recyclerview1, recyclerview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseasedetail);
    }

    @Override
    protected void initView() {
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        xiufu = findViewByID_My(R.id.xiufu);
        xiufu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //修复病害
                Bundle bundle = new Bundle();
                bundle.putString("facility_disease_id", diseaseId);
                CommonUtil.gotoActivityWithData(DiseaseDetailActivity.this, RepairDiseaseActivity.class, bundle, false);
            }
        });

        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView5 = findViewByID_My(R.id.textView5);
        textView6 = findViewByID_My(R.id.textView6);
        textView7 = findViewByID_My(R.id.textView7);
        textView8 = findViewByID_My(R.id.textView8);
        textView9 = findViewByID_My(R.id.textView9);
        textView10 = findViewByID_My(R.id.textView10);
        textView11 = findViewByID_My(R.id.textView11);
        textView12 = findViewByID_My(R.id.textView12);
        imageView1 = findViewByID_My(R.id.imageView1);
        imageView2 = findViewByID_My(R.id.imageView2);
        imageView3 = findViewByID_My(R.id.imageView3);
        imageView4 = findViewByID_My(R.id.imageView4);
        imageView5 = findViewByID_My(R.id.imageView5);
        imageView6 = findViewByID_My(R.id.imageView6);
        recyclerview1 = findViewByID_My(R.id.recyclerview1);
        recyclerview2 = findViewByID_My(R.id.recyclerview2);
    }

    @Override
    protected void initData() {
        /*type = getIntent().getIntExtra("DiseaseDetailActivity",1);
        if (type ==1){
        //修复后
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.GONE);
        }else {
              //没有修复
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.VISIBLE);
        }*/
        diseaseId = getIntent().getStringExtra("DiseaseDetailActivity");
        type = getIntent().getIntExtra("DiseaseDetailActivity_type", 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //病害详细信息
        showProgress(true, "正在获取数据，请稍后...");
        String string = "?id=" + diseaseId//病害ID
                + "&token=" + localUserInfo.getToken();
        RequestDiseaseDetail(string);
    }

    private void RequestDiseaseDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_DISEASEDETAIL + string, new OkHttpClientManager.ResultCallback<DiseaseDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(DiseaseDetailActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(DiseaseDetailModel response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>病害详细信息" + response);
                if (response.getFacility_disease_repair() != null) {
                    //已修复
                    linearLayout1.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.GONE);
                    /**
                     * /修复后布局
                     */
                    textView1.setText(response.getFacility_disease_repair().getEmployee().getName());//修复后-姓名
                    textView2.setText(response.getFacility_disease_repair().getCreated_at());//修复后-时间
                    textView3.setText(response.getFacility_disease_repair().getDescription());//修复后-介绍
                    //横向滑动数据
                    if (response.getFacility_disease_repair().getPic_list() != null) {
                        MyLogger.i(">>>>>>>>>" + response.getFacility_disease_repair().getPic_list().toString());
                        String str = response.getFacility_disease_repair().getPic_list().toString().replaceAll("\\[\"", "");
                        str = str.replaceAll("\"]", "");
                        str = str.replaceAll("\\\\", "");
                        String[] strings = str.split("\",\"");
                        final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
                        for (int i = 0; i < strings.length; i++) {
                            imageUrlList_1.add(URLs.HOST+strings[i]);
                        }
                        //设置布局管理器
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DiseaseDetailActivity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerview1.setLayoutManager(linearLayoutManager);
                        //设置适配器
                        MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(DiseaseDetailActivity.this, strings);
                        recyclerview1.setAdapter(mAdapter);
                        mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, DiseaseDetailActivity.this);
                            }
                        });
                    } else {
                        //没有图片
                    }
                } else {
                    //未修复
                    if (type == 5) {
                        //竣工详情跳转
                        linearLayout1.setVisibility(View.GONE);
                        linearLayout2.setVisibility(View.VISIBLE);
                    } else {
                        linearLayout1.setVisibility(View.GONE);
                        linearLayout2.setVisibility(View.GONE);
                    }
                }
                /**
                 * 修复前
                 */
                textView4.setText(response.getEmployee().getName());//修复前-姓名
                textView5.setText(response.getEmployee().getCreated_at());//修复前-时间
                textView6.setText(response.getTitle());//修复前-标题


                textView7.setText(response.getFacility_disease_type().getTitle());//修复前-病害类型
                if (response.getDegree() == 1) {
                    textView8.setText("轻微");//修复前-程度
                } else if (response.getDegree() == 2) {
                    textView8.setText("一般");//修复前-程度
                } else if (response.getDegree() == 3) {
                    textView8.setText("较重");//修复前-程度
                } else if (response.getDegree() == 4) {
                    textView8.setText("严重");//修复前-程度
                } else if (response.getDegree() == 5) {
                    textView8.setText("紧急");//修复前-程度
                }

                textView9.setText(response.getArea() + "㎡");//修复前-病害面积
                textView10.setText(response.getAmount_money() + "元");//修复前-金额
                /*if (!response.getDescription().equals("")){
                    textView11.setText(response.getDescription());//修复前-病害详情
                }else{
                    textView11.setText("暂无描述");//修复前-病害详情
                }*/
                if (!response.getDescription().equals("")){
                    textView12.setText(response.getDescription());//修复前-病害详情
                }else{
                    textView12.setText("暂无描述");//修复前-病害详情
                }
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
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DiseaseDetailActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerview2.setLayoutManager(linearLayoutManager);
                    //设置适配器
                    MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(DiseaseDetailActivity.this, strings);
                    recyclerview2.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, DiseaseDetailActivity.this);
                        }
                    });
                } else {
                    //没有图片
                }


            }
        });
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("病害详情");
        }
    }
}
