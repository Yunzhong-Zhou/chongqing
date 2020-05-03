package com.zhitiekeji.equipmentmanagement.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ChangePasswordActivity;
import com.zhitiekeji.equipmentmanagement.activity.LoginActivity;
import com.zhitiekeji.equipmentmanagement.base.BaseFragment;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;

/**
 * Created by fafukeji01 on 2017/1/16.
 * 上报员-资料管理
 */
public class ReportPersonMineFragment extends BaseFragment {
    //顶部标题栏
    private ImageView imageView1, imageView2;

    private TextView textView1,textView2,textView3,textView4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reportpersonmine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        //顶部标题栏
        imageView1 = findViewByID_My(R.id.imageView1);
        imageView2 = findViewByID_My(R.id.imageView2);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);

        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView3.setOnClickListener(this);
        textView4 = findViewByID_My(R.id.textView4);
        textView4.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        textView2.setText(localUserInfo.getPhonenumber());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView1:
                //返回
                break;
            case R.id.imageView2:
                //编辑
                break;
            case R.id.textView3:
                //修改密码
                CommonUtil.gotoActivity(getActivity(), ChangePasswordActivity.class,false);
                break;
            case R.id.textView4:
                //退出登录
                localUserInfo.setUserId("");
                CommonUtil.gotoActivity(getActivity(), LoginActivity.class,true);
                break;
        }
    }
    @Override
    protected void updateView() {
    }
}
