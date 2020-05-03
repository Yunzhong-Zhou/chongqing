package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.ConstructionPlanDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

/**
 * Created by zyz on 2018/3/26.
 * 计划详情
 */

public class ConstructionPlanDetailActivity extends BaseActivity {
    String id = "";
    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructionplandetail);
    }

    @Override
    protected void initView() {
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);

    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        showProgress(true, "正在获取数据，请稍后...");
        String string = "?id=" + id
                + "&token=" + localUserInfo.getToken();
        RequestDetail(string);
    }

    private void RequestDetail(String params) {
        OkHttpClientManager.getAsyn(URLs.ConstructionPlanDetail + params, new OkHttpClientManager.ResultCallback<ConstructionPlanDetailModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(ConstructionPlanDetailActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(ConstructionPlanDetailModel response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>施工计划详情" + response);
                textView1.setText(response.getTitle());
                textView2.setText("发布人："+response.getUser_name());
                textView3.setText(response.getCreated_at());
                textView4.setText(response.getContent());

            }
        });
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("计划详情");
        }
    }
}
