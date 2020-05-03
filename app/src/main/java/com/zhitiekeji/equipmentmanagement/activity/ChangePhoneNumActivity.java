package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;

/**
 * Created by fafukeji01 on 2017/1/19.
 * 修改密码
 */

public class ChangePhoneNumActivity extends BaseActivity{
    private ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changephonenum);
    }

    @Override
    protected void initView() {
        imageView1 = findViewByID_My(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView1:
                //获取验证码
                break;
            case R.id.textView2:
                //确认
                break;
        }
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("修改手机号");
        }
    }
}
