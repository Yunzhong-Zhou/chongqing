package com.zhitiekeji.equipmentmanagement.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.ReportedPlanDetailAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportedPlanDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhitiekeji.equipmentmanagement.R.id.textView_3;
import static com.zhitiekeji.equipmentmanagement.R.id.textView_4;
import static com.zhitiekeji.equipmentmanagement.R.id.textView_5;

/**
 * Created by fafukeji01 on 2017/1/17.
 * 上报计划详情 -上报详情
 */

public class ReportedPlanDetailActivity extends BaseActivity {
    String EquipmentID = "";
    private ListView listView;
    List<ReportedPlanDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list = new
            ArrayList<ReportedPlanDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean>();
    List<ReportedPlanDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list1 = new
            ArrayList<ReportedPlanDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean>();
    ReportedPlanDetailAdapter adapter;
    View headerView;
    Banner banner;
    String facility_service_approval_id="";
    String facility_id = "";

    //基本信息  维修记录
    private ImageView imageView1;
    private TextView textView1_1, textView1_2, textView2_1, textView2_2, textView2_3;
    private LinearLayout linearLayout1_1, linearLayout1_2;
    private View view1_1, view1_2;
    private LinearLayout linearLayout1;
    int type = 1;

    /*基本信息控件*/
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9, textView10,textView8_1, textView9_1, textView10_1;
    /*详细信息控件*/
    TextView textView11, textView12, textView13, textView14, textView15;
    LinearLayout linearLayout_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportedplandetail);
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.listView);

        headerView = View.inflate(this, R.layout.head_reportedplandetail, null);
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
                if (type==2){
                    Bundle bundle = new Bundle();
                    bundle.putString("DiseaseDetailActivity",list.get(i-1).getId());
                    bundle.putInt("DiseaseDetailActivity_type",1);
                    CommonUtil.gotoActivityWithData(ReportedPlanDetailActivity.this, DiseaseDetailActivity.class,bundle,false);
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
        adapter = new ReportedPlanDetailAdapter(ReportedPlanDetailActivity.this, list1);
        listView.setAdapter(adapter);
    }

    //上报详情
    private void RequestReportDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_REPORTDETAIL + string, new OkHttpClientManager.ResultCallback<ReportedPlanDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(ReportedPlanDetailModel response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>详细信息" + response);
                if (response != null){
                    facility_service_approval_id=response.getId();
                    facility_id = response.getFacility_id();
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
                        imageUrlList.add(URLs.HOST+response.getFacility().getPic1());
                    }
                    if (!response.getFacility().getPic2().equals("")) {
                        imageUrlList.add(URLs.HOST+response.getFacility().getPic2());
                    }
                    if (!response.getFacility().getPic3().equals("")) {
                        imageUrlList.add(URLs.HOST+response.getFacility().getPic3());
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
                            ViewPagerPhotoViewActivity.startThisActivity(imageUrlList, position, ReportedPlanDetailActivity.this);
                        }
                    });
                    //上报记录
                    textView11.setText("[" + response.getFacility_service_apply().getBatch_year() + "年第" +
                            response.getFacility_service_apply().getBatch() + "批次]");//批次号
                    textView12.setText(response.getEmployee().getName());//上报人
                    textView13.setText(response.getCreated_at());//上报时间
                    textView14.setText(response.getMoney() + "元");//上报费用
                    textView15.setText(response.getEvaluate() + "元");//预估费用
                    //审报记录
                    //添加布局
                    for (int i = 0; i < response.getFacility_service_apply().getFacility_service_report_list().size(); i++) {
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        LayoutInflater inflater = LayoutInflater.from(ReportedPlanDetailActivity.this);
                        View  view = inflater.inflate(R.layout.item_managementreview, null, false);
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
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case textView_3:
                //上报
//                CommonUtil.gotoActivity(ReportedPlanDetailActivity.this, ReportDiseaseActivity.class, false);
                break;
            case textView_4:
                //下达
                if (Integer.valueOf(localUserInfo.getUserJob()) == 6){
                    Bundle bundle = new Bundle();
                    bundle.putString("facility_service_approval_id",facility_service_approval_id);
                    CommonUtil.gotoActivityWithData(ReportedPlanDetailActivity.this, AddReplyPlanActivity.class,bundle, true);
                }else {
                    showToast("无权限进行此操作");
                }

                break;
            case textView_5:
                //删除
//                finish();
                AlertDialog.Builder builder = new AlertDialog.Builder(ReportedPlanDetailActivity.this);
                builder.setMessage("确定删除该记录吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("id", facility_service_approval_id);//id
                        params.put("facility_id", facility_id);//设备id
                        params.put("token", localUserInfo.getToken());//token
                        RequestUpLoad(params);
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
                ReportedPlanDetailAdapter adapter = new ReportedPlanDetailAdapter(ReportedPlanDetailActivity.this, list1);
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
                //病害列表
                adapter = new ReportedPlanDetailAdapter(ReportedPlanDetailActivity.this, list);
                listView.setAdapter(adapter);
                type = 2;
                break;
        }
    }
    private void RequestUpLoad(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_REPORTDETAIL_DETAIL, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    Toast.makeText(ReportedPlanDetailActivity.this,info,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>删除" + response);
                AlertDialog.Builder builder = new AlertDialog.Builder(ReportedPlanDetailActivity.this);
                builder.setMessage("删除成功");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                builder.create().show();

            }
        });

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
}
