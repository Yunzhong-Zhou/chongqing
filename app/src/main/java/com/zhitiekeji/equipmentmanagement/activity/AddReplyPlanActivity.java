package com.zhitiekeji.equipmentmanagement.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
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

import java.util.Map;

/**
 * Created by fafukeji01 on 2017/6/14.
 * 下达发布
 */

public class AddReplyPlanActivity extends BaseActivity {
    String facility_service_approval_id="",plan_number="",cost_money="",renovate_content="";
    EditText editText1,editText2,editText3;
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreplyplan);
    }

    @Override
    protected void initView() {
        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        editText3 = findViewByID_My(R.id.editText3);
        next = findViewByID_My(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (match()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddReplyPlanActivity.this);
                    builder.setMessage("检查填写无误，确认提交");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            showProgress(true, "正在提交数据，请稍后...");
                            params.put("employee_id", localUserInfo.getUserId());//员工id
                            params.put("facility_service_approval_id", facility_service_approval_id);//设备维修上报id
                            params.put("plan_number", plan_number);//计划号
                            params.put("cost_money", cost_money);//下达费用
                            params.put("renovate_content", renovate_content);//整治内容
                            params.put("token", localUserInfo.getToken());//token
                            RequestAddReplyPlan(params);
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();

                }
            }
        });
    }

    @Override
    protected void initData() {
        facility_service_approval_id=getIntent().getStringExtra("facility_service_approval_id");
    }
    private void RequestAddReplyPlan(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_AddReplyPlan, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
//                myToast("密码错误，请重新输入");
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddReplyPlanActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>下达发布" + response);
                myToast("发布成功");
                finish();
            }
        });

    }
    private boolean match() {
        plan_number = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(plan_number)) {
            showToast("请输入计划号");
            return false;
        }
        cost_money = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(cost_money)) {
            showToast("请输入下达费用");
            return false;
        }
        renovate_content = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(renovate_content)) {
            showToast("请输入整治内容");
            return false;
        }
        return true;
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("下达发布");
        }
    }
}
