package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import java.util.HashMap;

/**
 * Created by fafukeji01 on 2017/2/15.
 * 不同意病害管理
 */

public class DisagreeDiseaseManagementActivity extends BaseActivity{
    String facility_service_apply_id = "";
    boolean isList = false;
    EditText editText1;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disagreediseasemanagement);
    }

    @Override
    protected void initView() {
        editText1 = findViewByID_My(R.id.editText1);
        textView = findViewByID_My(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText1.getText().toString().trim().equals("")){
                    showProgress(true, "正在提交数据，请稍后...");
                    params.put("token",localUserInfo.getToken());
                    params.put("id",facility_service_apply_id);//设备维修申请id
                    params.put("status","2");//状态（1.通过 2.未通过）
                    params.put("reason",editText1.getText().toString().trim());//理由（状态为"未通过"才有此数据）
                    if (isList == false){
                        //不是批量审核
                        params.put("employee_id",localUserInfo.getUserId());//员工id
                        RequestUpLoad(params,URLs.AgreeAudit);
                    }else {
                        RequestUpLoad(params,URLs.AgreeAudit1);
                    }

                }else {
                    showToast("请输入不通过理由");
                }
            }
        });
    }

    @Override
    protected void initData() {
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");
        isList = getIntent().getBooleanExtra("isList",false);
    }
    //审核-确认审核
    private void RequestUpLoad(HashMap<String, String> params,String url) {
        OkHttpClientManager.postAsyn(url, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(DisagreeDiseaseManagementActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>不同意审核" + response);
                myToast("提交成功");
//                CommonUtil.gotoActivityWithFinishOtherAll(DisagreeDiseaseManagementActivity.this, MyAuditActivity.class, true);
                Bundle bundle = new Bundle();
                bundle.putString("facility_service_apply_id", MaintenanceRecordDetailsActivity.facility_service_apply_id);
                CommonUtil.gotoActivityWithBundleFinishOtherAll(DisagreeDiseaseManagementActivity.this, MaintenanceRecordDetailsActivity.class,bundle, true);//跳转到详情

            }
        });
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("不同意");
        }
    }
}
