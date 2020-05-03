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

import java.util.Map;

/**
 * Created by fafukeji01 on 2017/2/15.
 * 反馈
 */

public class FeedBackActivity extends BaseActivity{
    EditText editText1,editText2;
    TextView textView3;
    String title,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    @Override
    protected void initView() {
        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        textView3 = findViewByID_My(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (match()) {
                    showProgress(true, "正在提交数据，请稍后...");
                    params.put("content", content);//整治内容
                    params.put("token", localUserInfo.getToken());//token
                    RequestFeedback(params);
                }
            }
        });
    }
    private void RequestFeedback(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.USER_FEEDBACK, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
//                myToast("密码错误，请重新输入");
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(FeedBackActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>留言反馈" + response);
                myToast("反馈成功");
                finish();
            }
        });

    }
    private boolean match() {
        /*title = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            myToast("请输入标题");
            return false;
        }*/
        content = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入内容");
            return false;
        }
        return true;
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("留言反馈");
        }
    }
}
