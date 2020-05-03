package com.zhitiekeji.equipmentmanagement.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maning.updatelibrary.InstallUtils;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.UpgradeModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.utils.permission.PermissionsActivity;
import com.zhitiekeji.equipmentmanagement.utils.permission.PermissionsChecker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by fafukeji01 on 2017/2/14.
 * 登录
 */

public class LoginActivity extends BaseActivity {
    private EditText editText1, editText2;
    private TextView textView1, textView2, textView3;
    private String phonenum, password;

    private static final int REQUEST_CODE = 0; // 请求码
    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
//            Manifest.permission.CALL_PHONE,
//            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,


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
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mPermissionsChecker = new PermissionsChecker(this);
    }

    @Override
    protected void initView() {
        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        textView1 = findViewByID_My(R.id.textView1);
        textView1 = findViewByID_My(R.id.textView1);
        textView1 = findViewByID_My(R.id.textView1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                //忘记密码
                CommonUtil.gotoActivity(this, ForgetPasswordActivity.class, false);
                break;
            case R.id.textView2:
                //没有账号
                CommonUtil.gotoActivity(this, RegisteredActivity.class, true);
                break;
            case R.id.textView3:
                //登录
                if (match()) {
                    this.showProgress(true, "正在登录...");
//                    params.put("username", phonenum);
//                    params.put("password", password);
                    params.put("mobile", phonenum);
                    params.put("password", password);
//                    params.put("version", localUserInfo.getVersion());
//                    params.put("token", localUserInfo.getToken());
//                    params.put("timestamp", System.currentTimeMillis()+"");
                    RequestLogin(params);//登录
                }
//                CommonUtil.gotoActivity(LoginActivity.this, MainActivity.class,false);
                break;
            case R.id.textView4:
                CommonUtil.gotoActivity(LoginActivity.this, ReportPersonMainActivity.class, false);
                break;
        }
    }

    @Override
    protected void initData() {
        /*//起始数字，最后一个数字，取的随机个数
        get_RandomID(1,400, 30);
        get_RandomID(401,800, 30);
        get_RandomID(801,1200, 30);
        get_RandomID(1201,1600, 30);*/

        RequestUpgrade("");//检查更新

    }

    private void get_RandomID(int start,int all, int num) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = start; i <= all; i++) {
            list.add(i);
        }
        Random random = new Random();
        while (list.size() > 0) {
            int index = random.nextInt(list.size());
            /*System.out.print(list.get(index));
            System.out.print(" ");*/
            list1.add(list.get(index));
            list.remove(index);
        }
        String string = "";
        for (int i = 0; i < num; i++) {
            string = string + list1.get(i) + "  ";
        }
        MyLogger.i(">>>>>" +string);
    }

    private void RequestLogin(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.USER_SIGNIN, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
//                myToast("密码错误，请重新输入");
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>登录" + response);
                localUserInfo.setTime(System.currentTimeMillis() + "");
                JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    //保存Token
                    String token = jObj.getString("token");
                    localUserInfo.setToken(token);
                    //保存用户类型（1.员工 2.会员）
                    int userType = jObj.getInt("userType");
                    localUserInfo.setUserType(userType + "");
                    //保存用户id
                    JSONObject jObj1 = jObj.getJSONObject("data");
                    String id = jObj1.getString("id");
                    localUserInfo.setUserId(id);
                    //保存电话号码
                    String mobile = jObj1.getString("mobile");
                    localUserInfo.setPhoneNumber(mobile);

                    //内部员工
                    if (userType == 1) {
                        //保存姓名
                        localUserInfo.setUserName(jObj1.getString("name"));
                        //保存角色
                        localUserInfo.setUserJob(jObj1.getString("role"));
                        //保存头像
                        localUserInfo.setUserImage(jObj1.getString("head"));
                        //保存所属id
                        if (localUserInfo.getUserJob().equals("1")) {//[1.巡检工]此id为工区id
                            localUserInfo.setBelongid(jObj1.getString("work_area_id"));
                        } else if (localUserInfo.getUserJob().equals("2")) {//[2.工区长]此id为车间id
                            localUserInfo.setBelongid(jObj1.getString("workshop_id"));
                        } else {//[3.车间主任 4.技术科 5.段长]此id为路段id）
                            localUserInfo.setBelongid(jObj1.getString("section_id"));
                        }
                        CommonUtil.gotoActivity(LoginActivity.this, MainActivity.class, true);
                    } else {
                        //会员
                        CommonUtil.gotoActivity(LoginActivity.this, ReportPersonMainActivity.class, true);
                    }
                    hideProgress();

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

    }

    private boolean match() {
        phonenum = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(phonenum)) {
            showToast("请输入手机号码");
            return false;
        }
        password = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            showToast("请输入密码");
            return false;
        }
        return true;
    }

    @Override
    protected void updateView() {
        titleView.setVisibility(View.GONE);
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
                hideProgress();
            }

            @Override
            public void onResponse(UpgradeModel response) {
                MyLogger.i(">>>>>>>>>更新" + response);
                hideProgress();
                model = response;
                if (Integer.valueOf(localUserInfo.getVersion()) < Integer.valueOf(response.getCode())) {
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
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("发现版本：" + model.getName()+",确认更新吗？");
        builder.setTitle("版本更新");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);    //进度条，在下载的时候实时更新进度，提高用户友好度
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setCancelable(false);//点击外部不消失，返回键没用
//        progressDialog.setCanceledOnTouchOutside(false);//点击外部不消失，返回键有用
                    progressDialog.setTitle("正在更新版本");
                    progressDialog.setMessage("安装包下载中，请稍候...");
                    progressDialog.setProgress(0);
                    progressDialog.show();
                    new InstallUtils(LoginActivity.this, model.getPath(), "设备管理"+model.getName(), new InstallUtils.DownloadCallBack() {
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
                                boolean haveInstallPermission = LoginActivity.this.getPackageManager().canRequestPackageInstalls();
                                if (!haveInstallPermission) {
                                    //跳转设置开启允许安装
                                    Uri packageURI = Uri.parse("package:"+LoginActivity.this.getPackageName());
                                    Intent intent =new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageURI);
                                    startActivityForResult(intent,1000);
                                    return;
                                }
                            }
                            InstallUtils.installAPK(LoginActivity.this, path, new InstallUtils.InstallCallBack() {
                                @Override
                                public void onSuccess() {
                                    myToast("正在安装程序");
                                }

                                @Override
                                public void onFail(Exception e) {
                                    myToast("安装失败:" + e.toString());
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
                    Toast.makeText(LoginActivity.this, "SD卡不可用，请插入SD卡",
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
