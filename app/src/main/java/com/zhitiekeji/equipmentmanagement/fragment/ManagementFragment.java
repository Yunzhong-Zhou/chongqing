package com.zhitiekeji.equipmentmanagement.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.IntegratedMaintenanceActivity;
import com.zhitiekeji.equipmentmanagement.activity.OverhaulMainActivity;
import com.zhitiekeji.equipmentmanagement.activity.PleaseOverhaulActivity;
import com.zhitiekeji.equipmentmanagement.base.BaseFragment;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;

/**
 * Created by fafukeji01 on 2017/1/16.
 * 上报主页面
 */
public class ManagementFragment extends BaseFragment {
    private TextView textView1, textView2, textView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_management, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //请检修
//                CommonUtil.gotoActivity(getActivity(), PleaseOverhaulMainActivity.class,false);
                if (Integer.valueOf(localUserInfo.getUserJob()) > 1) {
                    CommonUtil.gotoActivity(getActivity(), PleaseOverhaulActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //综合维修
//                CommonUtil.gotoActivity(getActivity(), IntegratedMaintenanceActivity.class, false);
                if (Integer.valueOf(localUserInfo.getUserJob()) >1) {
                    CommonUtil.gotoActivity(getActivity(), IntegratedMaintenanceActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //大修
//                CommonUtil.gotoActivity(getActivity(), OverhaulMainActivity.class, false);
                if (Integer.valueOf(localUserInfo.getUserJob()) > 1) {
                    CommonUtil.gotoActivity(getActivity(), OverhaulMainActivity.class, false);
                } else {
                    showToast("无权限进行此操作");
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateView() {
    }
}
