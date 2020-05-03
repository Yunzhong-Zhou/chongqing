package com.zhitiekeji.equipmentmanagement.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.maning.updatelibrary.InstallUtils;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.UpgradeModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.utils.permission.PermissionsActivity;
import com.zhitiekeji.equipmentmanagement.utils.permission.PermissionsChecker;
import com.zhitiekeji.equipmentmanagement.view.FragmentIndicator;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class MainActivity extends AppCompatActivity {
    public static Fragment[] mFragments;

    private static final int REQUEST_CODE = 0; // 请求码
    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
//            Manifest.permission.CALL_PHONE,
//            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
            /*Manifest.permission.INTERNET,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.WRITE_SETTINGS,
            Manifest.permission.VIBRATE*/
    };
    private PermissionsChecker mPermissionsChecker; // 权限检测器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentIndicator(1);

        mPermissionsChecker = new PermissionsChecker(this);


        //极光推送
        JPushInterface.setDebugMode(false);
        JPushInterface.init(this);
//        JPushInterface.setAlias(this, 0, LocalUserInfo.getInstance(this).getUserId());
        // 调用 Handler 来异步设置别名
        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, LocalUserInfo.getInstance(this).getUserId()));
        JPushInterface.setAlias(this, //上下文对象
                LocalUserInfo.getInstance(this).getUserId(), //别名
                new TagAliasCallback() {//回调接口,i=0表示成功,其它设置失败
                    @Override
                    public void gotResult(int i, String s, Set<String> set) {
                        MyLogger.i("alias", "设置别名结果为" + i);
                    }
                });

        RequestUpgrade("");//检查更新
    }

    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "极光推送 别名设置成功";
                    MyLogger.i(logs);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    String string = "?token=" + LocalUserInfo.getInstance(MainActivity.this).getToken();
                    Request(string);
                    break;
                case 6002:
                    logs = "由于超时而无法设置别名和标签。 60秒后再试。";
                    MyLogger.i(logs);
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
                    MyLogger.i(logs);
                    break;
            }
//            ExampleUtil.showToast(logs, getApplicationContext());
        }
    };
    private static final int MSG_SET_ALIAS = 1001;
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
                    MyLogger.i("Set alias in handler.");
                    // 调用 JPush 接口来设置别名。
                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            (String) msg.obj,
                            null,
                            mAliasCallback);
                    break;
                default:
                    MyLogger.i("Unhandled msg - " + msg.what);
                    break;
            }
        }
    };

    private void Request(String params) {
        OkHttpClientManager.getAsyn(URLs.ChangeJpish + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {

            }

            @Override
            public void onResponse(String response) {

            }
        });
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

        FragmentIndicator mIndicator = (FragmentIndicator) findViewById(R.id.indicator);
        //FragmentIndicator.setIndicator(whichIsDefault);
        mIndicator.setOnIndicateListener(new FragmentIndicator.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                getSupportFragmentManager().beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]).show(mFragments[which]).commit();
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


    @Override
    protected void onResume() {
        super.onResume();
        // 缺少权限时, 进入权限配置页面
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }
    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }


    //更新
    UpgradeModel model;
    private void RequestUpgrade(String string) {
        OkHttpClientManager.getAsyn(URLs.Upgrade + string, new OkHttpClientManager.ResultCallback<UpgradeModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
//                hideProgress();
            }

            @Override
            public void onResponse(UpgradeModel response) {
                MyLogger.i(">>>>>>>>>更新" + response);
//                hideProgress();
                model = response;
                if (Integer.valueOf(LocalUserInfo.getInstance(MainActivity.this).getVersion()) < Integer.valueOf(response.getCode())) {
//                    handler1.sendEmptyMessage(0);
                    showUpdateDialog();
                } else {
//                    showToast("已经是最新版，无需更新");
                }
            }
        });
    }
    //显示是否要更新的对话框
    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("发现版本：" + model.getName()+",确认更新吗？");
        builder.setTitle("版本更新");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);    //进度条，在下载的时候实时更新进度，提高用户友好度
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setCancelable(false);//点击外部不消失，返回键没用
//        progressDialog.setCanceledOnTouchOutside(false);//点击外部不消失，返回键有用
                    progressDialog.setTitle("正在更新版本");
                    progressDialog.setMessage("安装包下载中，请稍候...");
                    progressDialog.setProgress(0);
                    progressDialog.show();
                    new InstallUtils(MainActivity.this, model.getPath(), "设备管理"+model.getName(), new InstallUtils.DownloadCallBack() {
                        @Override
                        public void onStart() {
                            Log.i("下载", "InstallUtils---onStart");
                        }

                        @Override
                        public void onComplete(String path) {
                            Log.i("下载", "InstallUtils---onComplete:" + path);
                            progressDialog.cancel();
                            /**
                             * 安装APK工具类
                             * @param context       上下文
                             * @param filePath      文件路径
                             * @param callBack      安装界面成功调起的回调
                             */
                            //一加手机8.0碰到了安装解析失败问题请添加下面判断
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                //先获取是否有安装未知来源应用的权限
                                boolean haveInstallPermission = MainActivity.this.getPackageManager().canRequestPackageInstalls();
                                if (!haveInstallPermission) {
                                    //跳转设置开启允许安装
                                    Uri packageURI = Uri.parse("package:"+MainActivity.this.getPackageName());
                                    Intent intent =new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageURI);
                                    startActivityForResult(intent,1000);
                                    return;
                                }
                            }
                            InstallUtils.installAPK(MainActivity.this, path, new InstallUtils.InstallCallBack() {
                                @Override
                                public void onSuccess() {
                                    Toast.makeText(MainActivity.this,"正在安装程序",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFail(Exception e) {
                                    Toast.makeText(MainActivity.this,"安装失败:" + e.toString(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onLoading(long total, long current) {
                            Log.i("下载", "InstallUtils----onLoading:-----total:" + total + ",current:" + current);
                            progressDialog.setMax((int) total);
                            progressDialog.setProgress((int) current);
                        }

                        @Override
                        public void onFail(Exception e) {
                            Log.i("下载", "InstallUtils---onFail:" + e.getMessage());
                        }

                    }).downloadAPK();
                } else {
                    Toast.makeText(MainActivity.this, "SD卡不可用，请插入SD卡",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
//                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }
}
