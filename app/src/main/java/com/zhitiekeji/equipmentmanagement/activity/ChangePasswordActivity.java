package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fafukeji01 on 2017/1/19.
 * 修改密码
 */

public class ChangePasswordActivity extends BaseActivity {
    TextView textView1, textView2;
    EditText editText1, editText2, editText3;
    String oldPassword="",newPassword1="",newPassword2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
    }

    @Override
    protected void initView() {
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        editText3 = findViewByID_My(R.id.editText3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (match()) {
                    showProgress(true, "正在修改...");
                    HashMap<String, String> params = new HashMap<>();
                    params.put("mobile", localUserInfo.getPhonenumber());
                    params.put("old_password", oldPassword);
                    params.put("new_password", newPassword1);
                    params.put("token", localUserInfo.getToken());
                    RequestChangePassword(params);//注册
                }
            }
        });

    }

    @Override
    protected void initData() {
        textView1.setText(localUserInfo.getPhonenumber());
    }

    private void RequestChangePassword(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.ChangePassword, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(ChangePasswordActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>修改密码" + response);
                myToast("修改密码成功");
                finish();
            }
        });

    }


    private boolean match() {
        oldPassword = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(oldPassword)) {
            showToast("请输入原始密码");
            return false;
        }
        newPassword1 = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(newPassword1)) {
            showToast("请输入新密码");
            return false;
        }
        newPassword2 = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(newPassword1)) {
            showToast("请再次输入新密码");
            return false;
        }
        if (!newPassword1.equals(newPassword2)) {
            showToast("请输入相同的密码");
            return false;
        }
        return true;
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("修改密码");
        }
    }
}
