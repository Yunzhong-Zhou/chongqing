package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;

/**
 * Created by fafukeji01 on 2017/5/18.
 * 帮助中心详情
 */

public class HelpCenterDetailActivity extends BaseActivity {
    private TextView textView1,textView2;
    String title= "";
    String content = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpcenterdetail);
    }

    @Override
    protected void initView() {
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
    }

    @Override
    protected void initData() {
        title = getIntent().getStringExtra("HelpCenterDetailActivity_title");
        content = getIntent().getStringExtra("HelpCenterDetailActivity_content");
        textView1.setText(title);
        textView2.setText(content);
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("问题详情");
        }
    }
}
