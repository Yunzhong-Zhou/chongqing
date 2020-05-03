package com.zhitiekeji.equipmentmanagement.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.StaffManagementDetailAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.StaffManagementDetailModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyz on 2018/3/24.
 * 员工管理详情
 */

public class StaffManagementDetailActivity extends BaseActivity {
    //分类选择栏
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    private TextView textView1, textView2, textView3, textView4,
            textView1_1, textView2_1, textView3_1, textView4_1;
    private View pop_view;
    String id = "", name = "";
    private ListView listView;
    List<StaffManagementDetailModel> list = new ArrayList<StaffManagementDetailModel>();
    StaffManagementDetailAdapter adapter;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmanagementdetail);
    }

    @Override
    protected void initView() {
        //分类选择栏
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout3 = findViewByID_My(R.id.linearLayout3);
        linearLayout4 = findViewByID_My(R.id.linearLayout4);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        textView3_1 = findViewByID_My(R.id.textView3_1);
        textView4_1 = findViewByID_My(R.id.textView4_1);
        pop_view = findViewByID_My(R.id.pop_view);

        listView = findViewByID_My(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("number", list.get(i).getFacility_number());
                CommonUtil.gotoActivityWithData(StaffManagementDetailActivity.this, EquipmentDetailActivity.class, bundle, false);
            }
        });
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?employee_id=" + id
                        + "&page=" + page + ""
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?employee_id=" + id
                        + "&page=" + page + ""
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        if (titleView != null) {
            titleView.setTitle(name);
        }
        requestServer();
    }

    private void RequestList(String params) {
        OkHttpClientManager.getAsyn(URLs.StaffManagementDetail + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(StaffManagementDetailActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>施工计划列表" + response);
                JSONObject jObj;
                list = new ArrayList<StaffManagementDetailModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), StaffManagementDetailModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new StaffManagementDetailAdapter(StaffManagementDetailActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private void RequestListMore(String params) {
        OkHttpClientManager.getAsyn(URLs.StaffManagementDetail + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(StaffManagementDetailActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>施工计划更多" + response);
                JSONObject jObj;
                List<StaffManagementDetailModel> list1 = new ArrayList<StaffManagementDetailModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), StaffManagementDetailModel.class);
                    if (list1.size() != 0) {
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
                    } else {
                        myToast("没有更多了");
                        page = page - 1;
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        Drawable drawable1 = getResources().getDrawable(R.mipmap.downimg2);//选中-蓝色
        Drawable drawable2 = getResources().getDrawable(R.mipmap.downimg3);//未选-灰色
        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        switch (v.getId()) {
            case R.id.linearLayout1:
                //时间先后
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);

                break;
            case R.id.linearLayout2:
                //阅读量
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);

                break;
            case R.id.linearLayout3:
                //地区
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.blue);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.blue));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable1, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);

                break;
            case R.id.linearLayout4:
                //历年记录
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.blue);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.blue));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable1, null);

                break;
        }
    }

    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        page = 1;
        String string = "?employee_id=" + id
                + "&page=" + page + ""
                + "&count=" + "10"
                + "&token=" + localUserInfo.getToken();
        RequestList(string);
    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }

    @Override
    protected void updateView() {

    }
}
