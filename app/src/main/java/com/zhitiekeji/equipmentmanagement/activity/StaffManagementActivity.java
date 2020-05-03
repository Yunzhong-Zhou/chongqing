package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.StaffManagementAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.StaffManagementModel;
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
 * 员工管理
 */

public class StaffManagementActivity extends BaseActivity {
    private ListView listView;
    List<StaffManagementModel> list = new ArrayList<StaffManagementModel>();
    StaffManagementAdapter adapter;
    int page = 1;
    private EditText editText;
    String search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmanagement);
    }

    @Override
    protected void initView() {
        listView = findViewByID_My(R.id.listView);
        editText = findViewByID_My(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search = v.getText().toString().trim();
                    if (!search.equals("")) {
                        requestServer();
                    } else {
                        showToast("请输入要查询的员工姓名或电话");
                    }
                }
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list.get(i).getId());
                bundle.putString("name", list.get(i).getName());
                CommonUtil.gotoActivityWithData(StaffManagementActivity.this, StaffManagementDetailActivity.class, bundle, false);
            }
        });
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?search=" + search
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
                String string = "?search=" + search
                        + "&page=" + page + ""
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        requestServer();
    }

    private void RequestList(String params) {
        OkHttpClientManager.getAsyn(URLs.StaffManagement + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(StaffManagementActivity.this, LoginActivity.class, true);
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
                list = new ArrayList<StaffManagementModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), StaffManagementModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new StaffManagementAdapter(StaffManagementActivity.this, list);
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
        OkHttpClientManager.getAsyn(URLs.StaffManagement + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(StaffManagementActivity.this, LoginActivity.class, true);
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
                List<StaffManagementModel> list1 = new ArrayList<StaffManagementModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), StaffManagementModel.class);
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
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        page = 1;
        String string = "?search=" + search
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
        if (titleView != null) {
            titleView.setTitle("员工管理");
        }
    }
}
