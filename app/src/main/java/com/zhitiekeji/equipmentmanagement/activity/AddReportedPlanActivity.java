package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;

/**
 * Created by fafukeji01 on 2017/6/14.
 * 上报发布
 */

public class AddReportedPlanActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreportedplan);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("上报发布");
        }
    }
}
