package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.view.FragmentIndicator3;
/*
* 请检修主页面（数据统计）
* */

public class PleaseOverhaulMainActivity extends BaseActivity {
    public static Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pleaseoverhaulmain);
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
        mFragments = new Fragment[3];
        mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment3);
        getSupportFragmentManager().beginTransaction().hide(mFragments[0])
                .hide(mFragments[1]).hide(mFragments[2]).show(mFragments[whichIsDefault]).commit();

        FragmentIndicator3 mIndicator = (FragmentIndicator3) findViewById(R.id.indicator);
        //FragmentIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new FragmentIndicator3.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                getSupportFragmentManager().beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]).show(mFragments[which]).commit();
            }
        });
    }
}
