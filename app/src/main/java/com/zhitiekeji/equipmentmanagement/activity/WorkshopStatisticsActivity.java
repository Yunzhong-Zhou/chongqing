package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.WorkshopStatisticsModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.shanxingtongji.bean.ShanXinViewData;
import com.zhitiekeji.equipmentmanagement.view.shanxingtongji.diyview.ShanXinView;
import com.squareup.okhttp.Request;

import java.util.ArrayList;

/**
 * Created by fafukeji01 on 2017/2/17.
 * 车间统计
 */

public class WorkshopStatisticsActivity extends BaseActivity {
    String id = "", year = "";
    int type = 0;//1.员工统计详情，2.工区统计详情，3.车间统计详情）
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    TextView textView2_1, textView3_1;
    private ImageView imageView;
    ProgressBar pb_progressbar;

    private ShanXinView shanXinView;
    private ArrayList<ShanXinViewData> shanXinViewDatas;   //数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshopstatistics);
    }

    @Override
    protected void initView() {
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView5 = findViewByID_My(R.id.textView5);
        textView6 = findViewByID_My(R.id.textView6);
        textView7 = findViewByID_My(R.id.textView7);
        pb_progressbar = findViewByID_My(R.id.pb_progressbar);

        textView2_1 = findViewByID_My(R.id.textView2_1);
        textView3_1 = findViewByID_My(R.id.textView3_1);

        /*imageView = findViewByID_My(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.gotoActivity(WorkshopStatisticsActivity.this,StatisticalDetailsActivity.class,false);
            }
        });*/
        shanXinView = (ShanXinView) findViewById(R.id.shanXingView);
//        histogramView.setVisibility(View.INVISIBLE);
        shanXinViewDatas = new ArrayList<>();
        //大小最大为100
        shanXinViewDatas.add(new ShanXinViewData(90, "", 100));
        shanXinViewDatas.add(new ShanXinViewData(90, "", 90));
        shanXinViewDatas.add(new ShanXinViewData(90, "", 80));
        shanXinViewDatas.add(new ShanXinViewData(90, "", 70));
        shanXinView.setData(shanXinViewDatas);
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra("type", 0);
        id = getIntent().getStringExtra("id");
        year = getIntent().getStringExtra("year");
        MyLogger.i(">>>>>>" + type + ">>>>>" + id);
        if (titleView != null) {
            switch (type) {
                case 1:
                    titleView.setTitle("员工统计");
                    textView2_1.setText("的员工");
                    textView3_1.setText("在所有员工排名");
                    break;
                case 2:
                    titleView.setTitle("工区统计");
                    textView2_1.setText("的工区");
                    textView3_1.setText("在所有工区排名");
                    break;
                case 3:
                    titleView.setTitle("车间统计");
                    textView2_1.setText("的车间");
                    textView3_1.setText("在所有车间排名");
                    break;
            }

        }
        this.showProgress(true, "正在获取数据...");
        //详细信息
        String string2 = "?id=" + id
                + "&type=" + type
                + "&year=" + year
                + "&token=" + localUserInfo.getToken();
        RequestDetail(string2);

    }

    private void RequestDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.WorkDetail + string, new OkHttpClientManager.ResultCallback<WorkshopStatisticsModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(WorkshopStatisticsActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(WorkshopStatisticsModel response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>统计详情" + response);
                textView1.setText(response.getTotal_money());
                textView2.setText(response.getCount() + "%");
                pb_progressbar.setProgress((int) Math.round(Double.valueOf(response.getCount())));
                textView3.setText(response.getSort() + "");
                textView4.setText("全年材料费用\n" + response.getMaterial_money() + "元");
                textView5.setText("全年病害面积\n" + response.getFacility_disease_area() + "㎡");
                textView6.setText("全年人工费用\n" + response.getArtificial_money() + "元");
                textView7.setText("全年维修设备数\n" + response.getFacility_qty() + "个");
            }
        });
    }

    @Override
    protected void updateView() {
    }
}
