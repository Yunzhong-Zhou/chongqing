package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.view.FragmentIndicator1;

/**
 * Created by fafukeji01 on 2017/2/15.
 * 综合维修主页面
 */

public class IntegratedMaintenanceActivity extends BaseActivity{
    public static Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intergratedmaintenance);
        setFragmentIndicator(0);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateView() {
        titleView.setVisibility(View.GONE);
    }
    /**
     * 初始化fragment
     */
    private void setFragmentIndicator(int whichIsDefault) {
        mFragments = new Fragment[5];
        mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment3);
        mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment4);
        mFragments[4] = getSupportFragmentManager().findFragmentById(R.id.fragment5);
        getSupportFragmentManager().beginTransaction().hide(mFragments[0])
                .hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[whichIsDefault]).commit();

        FragmentIndicator1 mIndicator = (FragmentIndicator1) findViewById(R.id.indicator);
        //FragmentIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new FragmentIndicator1.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                getSupportFragmentManager().beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[which]).commit();
            }
        });
    }
}
