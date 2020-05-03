package com.zhitiekeji.equipmentmanagement.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.MyAuditListAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.MyAuditListModel;
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
 * Created by fafukeji01 on 2017/1/18.
 * 批量审核
 */
public class MyAuditListActivity extends BaseActivity {
    private ListView listView;
    List<MyAuditListModel> list = new ArrayList<MyAuditListModel>();
    MyAuditListAdapter adapter;
    String facility_service_apply_id = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myauditlist);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void initView() {
        listView = findViewByID_My(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        findViewByID_My(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewByID_My(R.id.right_txt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //全选
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelect(1);
                }
                adapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.foot_textView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //同意
                facility_service_apply_id = "";
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getSelect() == 1) {
                            facility_service_apply_id = facility_service_apply_id + list.get(i).getId() + ",";
                        }
                    }
                } else {
                    showToast("请选择需要审核的设备");
                }

                //去掉最后一个标点
                facility_service_apply_id = facility_service_apply_id.substring(0, facility_service_apply_id.length() - 1);

                AlertDialog.Builder builder = new AlertDialog.Builder(MyAuditListActivity.this);
                builder.setMessage("确认批量审核选中的设备吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Bundle bundle = new Bundle();
                        bundle.putString("facility_service_apply_id", facility_service_apply_id);
                        CommonUtil.gotoActivityWithData(MyAuditListActivity.this, SignatureActivity1.class, bundle, false);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        findViewById(R.id.foot_textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不同意
                facility_service_apply_id = "";
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getSelect() == 1) {
                            facility_service_apply_id = facility_service_apply_id + list.get(i).getId() + ",";
                        }
                    }
                } else {
                    showToast("请选择需要审核的设备");
                }

                //去掉最后一个标点
                facility_service_apply_id = facility_service_apply_id.substring(0, facility_service_apply_id.length() - 1);
                AlertDialog.Builder builder = new AlertDialog.Builder(MyAuditListActivity.this);
                builder.setMessage("确认批量审核选中的设备吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Bundle bundle = new Bundle();
                        bundle.putString("facility_service_apply_id", facility_service_apply_id);
                        bundle.putBoolean("isList", true);
                        CommonUtil.gotoActivityWithData(MyAuditListActivity.this, DisagreeDiseaseManagementActivity.class, bundle, false);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();

            }
        });
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                String string = "?employee_role=" + localUserInfo.getUserJob()
                        + "&disease_classify=" + ""//病害分类（1.一类 2.二类 3.三类）
                        + "&status=" + "" //状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                        + "&workshop_id=" + ""//车间id
                        + "&work_area_id=" + ""//工区id
                        + "&station_id=" + ""//站区id
                        + "&page=" + ""
                        + "&count=" + ""
                        + "&all=" + "1"
                        + "&token=" + localUserInfo.getToken();
                RequestMyAuditList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                myToast("没有更多了");
                pullview.onFooterLoadFinish();
            }
        });
    }

    @Override
    protected void initData() {
        requestServer();
    }

    private void RequestMyAuditList(String params) {
        OkHttpClientManager.getAsyn(URLs.MyAudit + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(MyAuditListActivity.this, LoginActivity.class, true);
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
                MyLogger.i(">>>>>>>>>我的审核列表" + response);
                JSONObject jObj;
                list = new ArrayList<MyAuditListModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), MyAuditListModel.class);

                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setSelect(1);
                    }

                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                        findViewById(R.id.foot_textView1).setVisibility(View.GONE);

                    } else {
                        findViewById(R.id.foot_textView1).setVisibility(View.VISIBLE);
                        adapter = new MyAuditListAdapter(MyAuditListActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void updateView() {
        /*if (titleView != null) {
            titleView.setTitle("我的审核");
            titleView.showRightTextview("清空", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    workshop_id = "";//车间id
                    work_area_id = "";//工区id
                    station_id = "";//站区id
                    status = "";//状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                    disease_classify = "";//病害分类（1.一类 2.二类 3.三类）
                    requestServer();
                }
            });
        }*/

        titleView.setVisibility(View.GONE);

    }
    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
//        this.showProgress(true, "正在获取数据...");
        String string = "?employee_role=" + localUserInfo.getUserJob()
                + "&disease_classify=" + ""//病害分类（1.一类 2.二类 3.三类）
                + "&status=" + "" //状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                + "&workshop_id=" + ""//车间id
                + "&work_area_id=" + ""//工区id
                + "&station_id=" + ""//站区id
                + "&page=" + ""
                + "&count=" + ""
                + "&all=" + "1"
                + "&token=" + localUserInfo.getToken();
        RequestMyAuditList(string);
    }
    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }

}
