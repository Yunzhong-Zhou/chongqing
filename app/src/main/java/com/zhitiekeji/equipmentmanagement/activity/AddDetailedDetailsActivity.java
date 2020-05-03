package com.zhitiekeji.equipmentmanagement.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.AddDetailedDetailsAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.AddDetailedDetailsModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/18.
 * 发布细部明细
 */

public class AddDetailedDetailsActivity extends BaseActivity {
    String EquipmentID = "";
    private SwipeMenuListView listView;
    List<AddDetailedDetailsModel> list = new ArrayList<AddDetailedDetailsModel>();
    AddDetailedDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetaileddetails);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress(true, "正在获取数据...");

        String string = "?facility_id=" + EquipmentID
                + "&token=" + localUserInfo.getToken();
        RequestDetailedDetailsList(string);
    }

    @Override
    protected void initView() {
        listView = (SwipeMenuListView) findViewById(R.id.listView);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                /*openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));*/
                openItem.setBackground(R.color.red);
//                openItem.setBackground(R.mipmap.shanchu1);
                // set item width
                openItem.setWidth(dp2px(60));
                // set item title
//                openItem.setIcon(R.mipmap.dajiawen_butongyi1);
                openItem.setTitle("删除");
                // set item title fontsize
                openItem.setTitleSize(14);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);
            }
        };
        // set creator
        listView.setMenuCreator(creator);
        // step 2. listener item click event
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(final int position, SwipeMenu menu, int index) {
               /* ApplicationInfo item = mAppList.get(position);*/
                switch (index) {
                    case 0:
                        // 删除
                        /*String string = "?id=" + list.get(position).getId()//病害id
                                + "&token=" + localUserInfo.getToken();
                        RequestDetele(string, position);*/
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        EquipmentID = getIntent().getStringExtra("EquipmentID");
    }

    private void RequestDetailedDetailsList(String string) {
        OkHttpClientManager.getAsyn(URLs.DetailedDetails + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
//                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(AddDetailedDetailsActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
//                onHttpResult();
                MyLogger.i(">>>>>>>>>细部明细列表" + response);
                JSONObject jObj;
                list = new ArrayList<AddDetailedDetailsModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), AddDetailedDetailsModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new AddDetailedDetailsAdapter(AddDetailedDetailsActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //删除病害列表
    private void RequestDetele(String params, final int position) {
        OkHttpClientManager.getAsyn(URLs.Disease_Delete + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>删除细部详情" + response);
                /*list.remove(position);
                adapter.notifyDataSetChanged();*/
            }
        });
    }



    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("细部增删");
            titleView.showRightTextview("发布", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
