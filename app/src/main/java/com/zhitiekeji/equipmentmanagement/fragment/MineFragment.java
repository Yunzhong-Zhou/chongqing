package com.zhitiekeji.equipmentmanagement.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maning.updatelibrary.InstallUtils;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ChangePasswordActivity;
import com.zhitiekeji.equipmentmanagement.activity.ConstructionPlanActivity;
import com.zhitiekeji.equipmentmanagement.activity.CustomerFeedbackActivity;
import com.zhitiekeji.equipmentmanagement.activity.FeedBackActivity;
import com.zhitiekeji.equipmentmanagement.activity.HelpCenterActivity;
import com.zhitiekeji.equipmentmanagement.activity.LoginActivity;
import com.zhitiekeji.equipmentmanagement.activity.MyAuditActivity;
import com.zhitiekeji.equipmentmanagement.activity.MyPublishingDeviceActivity;
import com.zhitiekeji.equipmentmanagement.activity.MyReportActivity;
import com.zhitiekeji.equipmentmanagement.activity.PersonalInformationActivity;
import com.zhitiekeji.equipmentmanagement.activity.PleaseOverhaulActivity1;
import com.zhitiekeji.equipmentmanagement.activity.PleaseOverhaulMainActivity;
import com.zhitiekeji.equipmentmanagement.activity.SchoolBagActivity;
import com.zhitiekeji.equipmentmanagement.activity.StaffManagementActivity;
import com.zhitiekeji.equipmentmanagement.base.BaseFragment;
import com.zhitiekeji.equipmentmanagement.model.UpgradeModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.RoundImageView;

/**
 * Created by fafukeji01 on 2016/1/6.
 * 我的
 */
public class MineFragment extends BaseFragment {
    private TextView userName;
    private RoundImageView roundImageView;
    private ImageView imageView1;
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5,
            linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10,
            linearLayout11,linearLayout12,linearLayout13,linearLayout14;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (localUserInfo.getUserName().equals(""))
            userName.setText("暂无用户姓名");
        else
            userName.setText(localUserInfo.getUserName());
        if (!localUserInfo.getUserImage().equals(""))
            Glide.with(getActivity()).load(URLs.HOST + localUserInfo.getUserImage()).centerCrop().into(roundImageView);//加载图片
        else
            roundImageView.setImageResource(R.mipmap.touxiang);
    }

    @Override
    protected void initView(View view) {
        userName = findViewByID_My(R.id.userName);
        roundImageView = findViewByID_My(R.id.roundImageView);
        imageView1 = findViewByID_My(R.id.imageView1);
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout3 = findViewByID_My(R.id.linearLayout3);
        linearLayout4 = findViewByID_My(R.id.linearLayout4);
        linearLayout5 = findViewByID_My(R.id.linearLayout5);
        linearLayout6 = findViewByID_My(R.id.linearLayout6);
        linearLayout7 = findViewByID_My(R.id.linearLayout7);
        linearLayout8 = findViewByID_My(R.id.linearLayout8);
        linearLayout9 = findViewByID_My(R.id.linearLayout9);
        linearLayout10 = findViewByID_My(R.id.linearLayout10);
        linearLayout11 = findViewByID_My(R.id.linearLayout11);
        linearLayout12 = findViewByID_My(R.id.linearLayout12);
        linearLayout13 = findViewByID_My(R.id.linearLayout13);
        linearLayout14 = findViewByID_My(R.id.linearLayout14);
        roundImageView.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        linearLayout5.setOnClickListener(this);
        linearLayout6.setOnClickListener(this);
        linearLayout7.setOnClickListener(this);
        linearLayout8.setOnClickListener(this);
        linearLayout9.setOnClickListener(this);
        linearLayout10.setOnClickListener(this);
        linearLayout11.setOnClickListener(this);
        linearLayout12.setOnClickListener(this);
        linearLayout13.setOnClickListener(this);
        linearLayout14.setOnClickListener(this);
        //统计权限 >=4
        if (Integer.valueOf(localUserInfo.getUserJob()) >= 4) {
            linearLayout7.setVisibility(View.VISIBLE);
        } else {
            linearLayout7.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.roundImageView:
                //头像
                CommonUtil.gotoActivity(getActivity(), PersonalInformationActivity.class, false);
                break;
            case R.id.imageView1:
                //编辑
                CommonUtil.gotoActivity(getActivity(), PersonalInformationActivity.class, false);
                break;
            case R.id.linearLayout1:
                //我的审核
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), MyAuditActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            case R.id.linearLayout2:
                //我的申请
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), MyReportActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            case R.id.linearLayout10:
                //用户反馈
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), CustomerFeedbackActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            case R.id.linearLayout11:
                //请检修
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), PleaseOverhaulActivity1.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            case R.id.linearLayout3:
                //我添加的设备
                if (Integer.valueOf(localUserInfo.getUserJob()) <= 5) {
                    CommonUtil.gotoActivity(getActivity(), MyPublishingDeviceActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
                break;
            case R.id.linearLayout4:
                //修改密码
                CommonUtil.gotoActivity(getActivity(), ChangePasswordActivity.class, false);
                break;
            case R.id.linearLayout5:
                //帮助中心
                CommonUtil.gotoActivity(getActivity(), HelpCenterActivity.class, false);
                break;
            case R.id.linearLayout6:
                //意见反馈
                CommonUtil.gotoActivity(getActivity(), FeedBackActivity.class, false);
                break;
            case R.id.linearLayout7:
                //数据统计
                CommonUtil.gotoActivity(getActivity(), PleaseOverhaulMainActivity.class, false);
                break;
            case R.id.linearLayout8:
                //在线升级
                showProgress(true, "正在检查更新，请稍后...");
                RequestUpgrade("");//检查更新
                break;
            case R.id.linearLayout12:
                //施工计划
                CommonUtil.gotoActivity(getActivity(), ConstructionPlanActivity.class, false);
                break;
            case R.id.linearLayout13:
                //员工管理
                CommonUtil.gotoActivity(getActivity(), StaffManagementActivity.class, false);
                break;
            case R.id.linearLayout14:
                //党员小书包
                CommonUtil.gotoActivity(getActivity(), SchoolBagActivity.class, false);
                break;
            case R.id.linearLayout9:
                //退出账号
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("确认退出该账号吗");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        localUserInfo.setUserId("");
                        CommonUtil.gotoActivity(getActivity(), LoginActivity.class, true);
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
        }
    }

    @Override
    protected void updateView() {

    }

    //更新
    UpgradeModel model;
    private void RequestUpgrade(String string) {
        OkHttpClientManager.getAsyn(URLs.Upgrade + string, new OkHttpClientManager.ResultCallback<UpgradeModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    myToast("登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(getActivity(), LoginActivity.class, true);
                } else {
                    myToast(info);
                }
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
                    showToast("已经是最新版，无需更新");
                }
            }
        });
    }
    //显示是否要更新的对话框
    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("发现版本：" + model.getName()+",确认更新吗？");
        builder.setTitle("版本更新");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    final ProgressDialog progressDialog = new ProgressDialog(getActivity());    //进度条，在下载的时候实时更新进度，提高用户友好度
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setCancelable(false);//点击外部不消失，返回键没用
//        progressDialog.setCanceledOnTouchOutside(false);//点击外部不消失，返回键有用
                    progressDialog.setTitle("正在更新版本");
                    progressDialog.setMessage("安装包下载中，请稍候...");
                    progressDialog.setProgress(0);
                    progressDialog.show();
                    new InstallUtils(getContext(), model.getPath(), "设备管理"+model.getName(), new InstallUtils.DownloadCallBack() {
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
                                boolean haveInstallPermission = getActivity().getPackageManager().canRequestPackageInstalls();
                                if (!haveInstallPermission) {
                                    //跳转设置开启允许安装
                                    Uri packageURI = Uri.parse("package:"+getActivity().getPackageName());
                                    Intent intent =new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageURI);
                                    startActivityForResult(intent,1000);
                                    return;
                                }
                            }
                            InstallUtils.installAPK(getContext(), path, new InstallUtils.InstallCallBack() {
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
                    Toast.makeText(getActivity(), "SD卡不可用，请插入SD卡",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                finish();
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }
    /*private ProgressDialog progressDialog;
    UpdateInfoService updateInfoService;
    private Handler handler1 = new Handler() {
        public void handleMessage(Message msg) {
            // 如果有更新就提示
            updateInfoService = new UpdateInfoService(getActivity());
            showUpdateDialog();
        }
    };

    void downFile(final String url) {
        progressDialog = new ProgressDialog(getActivity());    //进度条，在下载的时候实时更新进度，提高用户友好度
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);//点击外部不消失，返回键没用
//        progressDialog.setCanceledOnTouchOutside(false);//点击外部不消失，返回键有用
        progressDialog.setTitle("正在更新版本");
        progressDialog.setMessage("安装包下载中，请稍候...");
        progressDialog.setProgress(0);
        progressDialog.show();
        updateInfoService.downLoadFile(url, model.getName(),progressDialog, handler1);
    }*/
}
