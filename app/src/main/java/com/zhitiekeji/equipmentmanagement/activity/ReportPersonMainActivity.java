package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.view.FragmentIndicator4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fafukeji01 on 2017/6/19.
 * 上报员
 */

public class ReportPersonMainActivity extends BaseActivity{
    public static Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportpersonmain);
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
        mFragments = new Fragment[2];
        mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment2);
        getSupportFragmentManager().beginTransaction().hide(mFragments[0])
                .hide(mFragments[1]).show(mFragments[whichIsDefault]).commit();

        FragmentIndicator4 mIndicator = (FragmentIndicator4) findViewById(R.id.indicator);
        //FragmentIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new FragmentIndicator4.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                getSupportFragmentManager().beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .show(mFragments[which]).commit();
            }
        });
    }
    /**
     * 双击退出函数
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            exitBy2Click();
            return false;
        } else {
            return super.dispatchKeyEvent(event);
        }
    }

    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            //退出
            finish();
        }
    }
}
