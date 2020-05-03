package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
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

public class SignatureActivity extends BaseActivity {
    int type = -1;
    TextView textView1, textView2;
    EditText editText;
    String money = "";
    LinePathView linePathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);
    }

    @Override
    protected void initView() {
        linePathView = findViewByID_My(R.id.linePathView);
        //清除
//        linePathView.clear();
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        editText = findViewByID_My(R.id.editText1);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linePathView.getTouched()) {
                    try {
                        linePathView.save("/sdcard/qm.png", true, 10);
                        if (type == 1) {
                            //同意病害审核
                            if (match()) {
                                textView2.setClickable(false);
                                showProgress(true, "正在上传数据，请稍后...");
                                ArrayList<String> listFileNames = new ArrayList<>();
                                ArrayList<File> listFiles = new ArrayList<>();
                                listFileNames.add("signature_pic");
                                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
                                File file1 = new File(path);//签字图片（状态为"通过"才有此数据）
                                listFiles.add(file1);

                                if (!AgreeDiseaseManagementActivity.accessory.equals("")) {
                                    listFileNames.add("accessory");
//                                    File file2 = new File(AgreeDiseaseManagementActivity.accessory);//计划附件（实施计划）

                                    listFiles.add(AgreeDiseaseManagementActivity.accessory_file);
                                } else {

                                }

                                String[] filenames = new String[]{};
                                File[] files = new File[]{};
                                for (int i = 0; i < listFiles.size(); i++) {
                                    filenames = listFileNames.toArray(new String[i]);
                                    files = listFiles.toArray(new File[i]);
                                }
                                params.put("token", localUserInfo.getToken());
                                params.put("id", AgreeDiseaseManagementActivity.facility_service_apply_id);//设备维修申请id
                                params.put("employee_id", localUserInfo.getUserId());//员工id
                                params.put("status", "1");//状态（1.通过 2.未通过）
                                String facility_disease_id_list = "";
                                for (int i = 0; i < AgreeDiseaseManagementActivity.list.size(); i++) {
                                    facility_disease_id_list = facility_disease_id_list + AgreeDiseaseManagementActivity.list.get(i).getId() + ",";
                                }
                                MyLogger.i(">>>>>>>>>>" + facility_disease_id_list);
                                params.put("facility_disease_id_list", facility_disease_id_list);//设备病害id合集
                                params.put("money", money);//金额（预算评估：车间主任和技术科有次权限）
                                params.put("reason", "");//理由（状态为"未通过"才有此数据）

                                params.put("start_at", AgreeDiseaseManagementActivity.start_at);//开工时间（实施计划）
                                params.put("end_at", AgreeDiseaseManagementActivity.end_at);//竣工时间（实施计划）
                                params.put("description", AgreeDiseaseManagementActivity.editText1.getText().toString().trim());//计划描述（实施计划）

                                RequestUpLoad(filenames, files, params);
                            }

                        }
                       /* setResult(10010);
                        finish();*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(SignatureActivity.this, "您还没有签名~", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //审核-确认审核
    private void RequestUpLoad(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.AgreeAudit, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
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
//                CommonUtil.gotoActivityWithFinishOtherAll(SignatureActivity.this, MyAuditActivity.class, true);//跳转到列表

                Bundle bundle = new Bundle();
                bundle.putString("facility_service_apply_id", MaintenanceRecordDetailsActivity.facility_service_apply_id);
                CommonUtil.gotoActivityWithBundleFinishOtherAll(SignatureActivity.this, MaintenanceRecordDetailsActivity.class,bundle, true);//跳转到详情
            }
        }, this);
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra("type", -1);
        textView1.setText(AgreeDiseaseManagementActivity.allMoney + "");
        editText.setText(AgreeDiseaseManagementActivity.allMoney + "");

        if (Integer.valueOf(localUserInfo.getUserJob()) == 3 || Integer.valueOf(localUserInfo.getUserJob()) == 4) {
            editText.setEnabled(true);
        } else {
            editText.setEnabled(false);
        }
    }

    private boolean match() {
        money = editText.getText().toString().trim();
        if (TextUtils.isEmpty(money)) {
            showToast("请输入您的预算");
            return false;
        }
        return true;
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
