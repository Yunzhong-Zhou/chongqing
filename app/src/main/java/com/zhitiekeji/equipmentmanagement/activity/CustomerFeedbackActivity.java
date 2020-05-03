package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.ReportPersonDiseaseListAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportPersonDiseaseListModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyz on 2017/8/15.
 * 用户反馈
 */

public class CustomerFeedbackActivity extends BaseActivity{
    private ListView listView;
    List<ReportPersonDiseaseListModel> list = new ArrayList<ReportPersonDiseaseListModel>();
    ReportPersonDiseaseListAdapter adapter;
    int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerfeedback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestServer();//获取数据
    }

    @Override
    protected void initView() {
        listView = findViewByID_My(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("EquipmentID", list.get(i).getFacility_id());
                bundle.putString("publish_disease_id", list.get(i).getId());
                bundle.putString("faxianbinghai", "0");
                CommonUtil.gotoActivityWithData(CustomerFeedbackActivity.this, ReportDiseaseActivity.class, bundle, false);
            }
        });

        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?page=" + page
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestDiseaseList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string ="?page=" + page
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestDiseaseListMore(string);
            }
        });
    }

    @Override
    protected void initData() {

    }
    private void RequestDiseaseList(String params) {
        OkHttpClientManager.getAsyn(URLs.CustomerFeedbackDiseaseList + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(CustomerFeedbackActivity.this, LoginActivity.class,true);
                }else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>普通用户病害列表" + response);
                JSONObject jObj;
                list = new ArrayList<ReportPersonDiseaseListModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), ReportPersonDiseaseListModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new ReportPersonDiseaseListAdapter(CustomerFeedbackActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private void RequestDiseaseListMore(String params) {
        OkHttpClientManager.getAsyn(URLs.CustomerFeedbackDiseaseList + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(CustomerFeedbackActivity.this, LoginActivity.class,true);
                }else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>普通用户病害列表更多" + response);
                JSONObject jObj;
                List<ReportPersonDiseaseListModel> list1 = new ArrayList<ReportPersonDiseaseListModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), ReportPersonDiseaseListModel.class);
                    if (list1.size() != 0) {
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
                    }else {
                        showToast("没有更多了");
                        page = page-1;
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
        String string = "?page=" + "1"
                + "&count=" + "10"
                + "&token=" + localUserInfo.getToken();
        RequestDiseaseList(string);
    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("用户反馈");
        }
    }
}
