package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.LinePathView;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zyz on 2017/8/4.
 * 签名画板
 */

public class SignatureActivity1 extends BaseActivity {
    String facility_service_apply_id = "";
    TextView textView2;
    String money = "";
    LinePathView linePathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature1);
    }

    @Override
    protected void initView() {
        linePathView = findViewByID_My(R.id.linePathView);
        //清除
//        linePathView.clear();
        textView2 = findViewByID_My(R.id.textView2);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linePathView.getTouched()) {
                    try {
                        linePathView.save("/sdcard/qm.png", true, 10);
                        //同意病害审核
                        showProgress(true, "正在上传数据，请稍后...");
                        textView2.setClickable(false);
                        ArrayList<String> listFileNames = new ArrayList<>();
                        ArrayList<File> listFiles = new ArrayList<>();
                        listFileNames.add("signature_pic");
                        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
                        File file1 = new File(path);//签字图片（状态为"通过"才有此数据）
                        listFiles.add(file1);

                        String[] filenames = new String[]{};
                        File[] files = new File[]{};
                        for (int i = 0; i < listFiles.size(); i++) {
                            filenames = listFileNames.toArray(new String[i]);
                            files = listFiles.toArray(new File[i]);
                        }
                        params.put("token", localUserInfo.getToken());
                        params.put("id", facility_service_apply_id);//设备维修申请id
                        params.put("status", "1");//状态（1.通过 2.未通过）
                        params.put("reason", "");//理由（状态为"未通过"才有此数据）
                        RequestUpLoad(filenames, files, params);

                       /* setResult(10010);
                        finish();*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(SignatureActivity1.this, "您还没有签名~", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //审核-确认审核
    private void RequestUpLoad(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.AgreeAudit1, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                //清除
                linePathView.clear();
                textView2.setClickable(true);
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                //清除
                linePathView.clear();
                textView2.setClickable(true);
                hideProgress();
                MyLogger.i(">>>>>>>同意审核" + response);
                myToast("提交成功");
//                finish();
                CommonUtil.gotoActivityWithFinishOtherAll(SignatureActivity1.this, MyAuditActivity.class, true);
            }
        }, this);
    }

    @Override
    protected void initData() {
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("签名");
            /*titleView.showRightTextview("保存", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });*/
        }
    }
}
