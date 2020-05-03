package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fafukeji01 on 2017/2/15.
 * 忘记密码
 */

public class ForgetPasswordActivity extends BaseActivity{
    private ImageView imageView1;
    private EditText editText1, editText2, editText3, editText4;
    private TextView textView1, textView2;

    String phonenum = "", password1 = "", password2 = "", code = "";

    private TimeCount time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
    }

    @Override
    protected void initView() {
        imageView1 =findViewByID_My(R.id.imageView1);

        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        editText3 = findViewByID_My(R.id.editText3);
        editText4 = findViewByID_My(R.id.editText4);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);

    }

    @Override
    protected void initData() {
        time = new TimeCount(60000, 1000);//构造CountDownTimer对象
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView1:
                finish();
                break;
            case R.id.textView1:
                //发送验证码
                phonenum = editText1.getText().toString().trim();
                if (TextUtils.isEmpty(phonenum)) {
                    Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                } else {

                    HashMap<String, String> params1 = new HashMap<>();
                    params1.put("mobile", phonenum);
                    RequestCode(params1);//获取验证码
                }

                break;
            case R.id.textView2:
                //重置密码
                if (match()) {
                    this.showProgress(true, "正在重置密码...");
                    HashMap<String, String> params = new HashMap<>();
                    params.put("mobile", phonenum);
                    params.put("password", password1);
                    params.put("code", code);
                    RequestRegistered(params);//重置密码
                }
                break;
        }
    }
    private boolean match() {
        phonenum = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(phonenum)) {
            showToast("请输入手机号码");
            return false;
        }
        password1 = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(password1)) {
            showToast("请输入密码");
            return false;
        }
        password2 = editText4.getText().toString().trim();
        if (TextUtils.isEmpty(password2)) {
            showToast("请再次输入密码");
            return false;
        }
        code = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(code)) {
            showToast("请输入验证码");
            return false;
        }
        if (!password1.equals(password2)) {
            showToast("请输入相同的密码");
            return false;
        }

        return true;
    }

    private void RequestCode(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.ForgetCode, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>验证码" + response);
                time.start();//开始计时
                showToast("验证码发送成功");
                /*JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    String data = jObj.getString("data");
                    editText2.setText(data);

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
        });

    }

    private void RequestRegistered(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.ForgetPassword, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>重置密码" + response);
                myToast("重置密码成功，请登录");
                finish();
            }
        });

    }

    @Override
    protected void updateView() {
        titleView.setVisibility(View.GONE);
    }
    //屏蔽返回键
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK)
            return true;//不执行父类点击事件
        return super.onKeyDown(keyCode, event);//继续执行父类其他点击事件
    }

    //获取验证码倒计时
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            textView1.setText("重新获取");
            textView1.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            textView1.setClickable(false);
            textView1.setText(millisUntilFinished / 1000 + "s后获取");
        }
    }
}
