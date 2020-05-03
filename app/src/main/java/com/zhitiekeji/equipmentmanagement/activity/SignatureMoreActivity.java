package com.zhitiekeji.equipmentmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.view.LinePathView;

import java.io.IOException;

/**
 * Created by zyz on 2017/8/4.
 * 签名画板
 */

public class SignatureMoreActivity extends BaseActivity {
    String name ="";
    LinePathView linePathView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signaturemore);
    }

    @Override
    protected void initView() {
        linePathView = findViewByID_My(R.id.linePathView);
        //清除
//        linePathView.clear();
    }

    @Override
    protected void initData() {
        name = getIntent().getStringExtra("name");
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle(name+"签名");
            titleView.showRightTextview("保存", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (linePathView.getTouched()) {
                        try {
                            linePathView.save("/sdcard/qm_"+name+".png", true, 10);
                            SignatureMoreActivity.this.setResult(RESULT_OK, new Intent());
                            finish();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(SignatureMoreActivity.this, "您还没有签名~", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
