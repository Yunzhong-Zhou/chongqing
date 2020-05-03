package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;


/**
 * Created by zyz on 2016/6/17.
 * Email：1125213018@qq.com
 * description：启动页
 */
public class HelloActivity extends Activity {
    private static final String SHARE_APP_TAG = "HelloActivity";
    String versionName = "";//版本号
    int versionCode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*//在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现，建议该方法放在Application的初始化方法中
        SDKInitializer.initialize(getApplicationContext());*/
        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 判断是否是第一次开启应用
        SharedPreferences setting = getSharedPreferences(SHARE_APP_TAG, 0);
        Boolean user_first = setting.getBoolean("FIRST",true);

        //获取当前客户端版本号
        try {
            String pkName = this.getPackageName();
            versionName = this.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            versionCode = this.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode;
            MyLogger.i(">>>>>>>>>>>包名：" + pkName + "版本名：" + versionName + "版本号：" + versionCode);
            LocalUserInfo.getInstance(HelloActivity.this).setVersion(versionCode+"");
        } catch (Exception e) {
        }


        // 如果是第一次启动，则先进入功能引导页
        if (user_first) {
            setting.edit().putBoolean("FIRST", false).commit();
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        }else {
            // 如果不是第一次启动app，则正常显示启动屏
            setContentView(R.layout.viewpager_page);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    enterHomeActivity();
                }
            }, 2000);
        }
    }

    private void enterHomeActivity() {
        if (LocalUserInfo.getInstance(HelloActivity.this).getUserId().equals("")){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else {
            if (System.currentTimeMillis()-Long.valueOf(LocalUserInfo.getInstance(HelloActivity.this).getTime())>= 1000*60*60*6){
                LocalUserInfo.getInstance(HelloActivity.this).setUserId("");
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }else {
                if (LocalUserInfo.getInstance(HelloActivity.this).getUserType().equals("1")){
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(this, ReportPersonMainActivity.class);
                    startActivity(intent);
                }

            }

        }
        finish();
    }
}
