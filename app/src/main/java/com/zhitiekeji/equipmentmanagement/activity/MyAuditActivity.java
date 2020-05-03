package com.zhitiekeji.equipmentmanagement.activity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.MyAuditAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment3Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.AreaModel1;
import com.zhitiekeji.equipmentmanagement.model.AreaModel2;
import com.zhitiekeji.equipmentmanagement.model.AreaModel3;
import com.zhitiekeji.equipmentmanagement.model.MyAuditModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/18.
 * 我的审核
 */
public class MyAuditActivity extends BaseActivity {
    private ListView listView;
    List<MyAuditModel> list = new ArrayList<MyAuditModel>();
    MyAuditAdapter adapter;
    int page = 1;

    private LinearLayout linearLayout1, linearLayout2, linearLayout3;
    private TextView textView1, textView2, textView3,
            textView1_1, textView2_1, textView3_1;
    private View pop_view;

    //分类选择下标
    int i1 = 0;
    //状态选择下标
    int i2 = 0;

    //区域列表数据-车间
    List<AreaModel1> areaList1 = new ArrayList<AreaModel1>();
    int i3_1 = 0;
    //区域列表数据-工区
    List<AreaModel2> areaList2 = new ArrayList<AreaModel2>();
    int i3_2 = 0;
    //区域列表数据-站区
    List<AreaModel3> areaList3 = new ArrayList<AreaModel3>();
    int i3_3 = 0;
    String workshop_id = "";//车间id
    String work_area_id = "";//工区id
    String station_id = "";//站区id
    String status = "";//状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
    String disease_classify = "";//病害分类（1.一类 2.二类 3.三类）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaudit);
        findViewByID_My(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        requestServer();//获取数据
    }

    @Override
    protected void initView() {
        listView = findViewByID_My(R.id.listView);
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout3 = findViewByID_My(R.id.linearLayout3);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        textView3_1 = findViewByID_My(R.id.textView3_1);
        pop_view = findViewByID_My(R.id.pop_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("facility_service_apply_id", list.get(i).getId());
                CommonUtil.gotoActivityWithData(MyAuditActivity.this, MaintenanceRecordDetailsActivity.class, bundle, false);
            }
        });
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?employee_role=" + localUserInfo.getUserJob()
                        + "&type=" + disease_classify//病害分类（1.一类 2.二类 3.三类）
                        + "&status=" + status //状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                        + "&workshop_id=" + workshop_id//车间id
                        + "&work_area_id=" + work_area_id//工区id
                        + "&station_id=" + station_id//站区id
                        + "&page=" + page + ""
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestMyAuditList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?employee_role=" + localUserInfo.getUserId()
                        + "&type=" + disease_classify//病害分类（1.一类 2.二类 3.三类）
                        + "&status=" + status //状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                        + "&workshop_id=" + workshop_id//车间id
                        + "&work_area_id=" + work_area_id//工区id
                        + "&station_id=" + station_id//站区id
                        + "&page=" + page + ""
                        + "&count=" + "10"
                        + "&token=" + localUserInfo.getToken();
                RequestMyAuditListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        String string3 = "?token=" + localUserInfo.getToken();
        RequestAreaList1(string3);//区域列表
    }

    @Override
    public void onClick(View v) {
        Drawable drawable1 = getResources().getDrawable(R.mipmap.downimg2);//选中-蓝色
        Drawable drawable2 = getResources().getDrawable(R.mipmap.downimg3);//未选-灰色
        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        switch (v.getId()) {
            case R.id.linearLayout1:
                //分类
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.default_text));
                textView3.setTextColor(getResources().getColor(R.color.default_text));
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow1(pop_view);
                break;
            case R.id.linearLayout2:
                //状态
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow2(pop_view);
                break;
            case R.id.linearLayout3:
                //地区
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.blue));
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.blue);
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable1, null);
                showPopupWindow3(pop_view);
                break;
        }
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
                        CommonUtil.gotoActivityWithFinishOtherAll(MyAuditActivity.this, LoginActivity.class, true);
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
                list = new ArrayList<MyAuditModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), MyAuditModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new MyAuditAdapter(MyAuditActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private void RequestMyAuditListMore(String params) {
        OkHttpClientManager.getAsyn(URLs.MyAudit + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MyAuditActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>我的审核更多" + response);
                JSONObject jObj;
                List<MyAuditModel> list1 = new ArrayList<MyAuditModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), MyAuditModel.class);
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

    //区域列表1-车间
    private void RequestAreaList1(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST1 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(MyAuditActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表1-车间" + response);
                JSONObject jObj;
                areaList1 = new ArrayList<AreaModel1>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList1 = JSON.parseArray(jsonArray.toString(), AreaModel1.class);

                    /*if (areaList1.size() > 0) {
                        //获取第一个车间所属工区
                        String string = "?token=" + localUserInfo.getToken()
                                + "&workshop_id=" + areaList1.get(0).getId();
                        RequestAreaList2(string);//区域列表
                    }*/

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //区域列表2-工区
    private void RequestAreaList2(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST2 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表2-工区" + response);
                JSONObject jObj;
                areaList2 = new ArrayList<AreaModel2>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList2 = JSON.parseArray(jsonArray.toString(), AreaModel2.class);

                    list2.clear();
                    list2.add("全部");
                    for (int i = 0; i < areaList2.size(); i++) {
                        list2.add(areaList2.get(i).getTitle());
                    }
                    if (adapter2 != null) {
//                        adapter2 = new Pop_Equipment2Adapter(getActivity(),list2);
//                        pop_listView2.setAdapter(adapter2);
                        adapter2.notifyDataSetChanged();
                        adapter2.setSelectItem(0);
                    }
                    if (list2.size() == 1) {
                        String string = "?token=" + localUserInfo.getToken()
                                + "&work_area_id=" + "";
                        RequestAreaList3(string);//站区列表
                    } else {
                        if (areaList2.size() > 0) {
                            //获取第一个车间所属站区
                            String string = "?token=" + localUserInfo.getToken()
                                    + "&work_area_id=" + areaList2.get(0).getId();
                            RequestAreaList3(string);//站区列表
                        }
                    }


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //区域列表3-站区
    private void RequestAreaList3(String string) {
        OkHttpClientManager.getAsyn(URLs.AREA_LIST3 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                onHttpResult();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                onHttpResult();
                MyLogger.i(">>>>>>>>>区域列表3-站区" + response);
                JSONObject jObj;
                areaList3 = new ArrayList<AreaModel3>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList3 = JSON.parseArray(jsonArray.toString(), AreaModel3.class);

                    list3.clear();
                    list3.add("全部");
                    for (int i = 0; i < areaList3.size(); i++) {
                        list3.add(areaList3.get(i).getTitle());
                    }
                    if (adapter3 != null) {
                        adapter3.notifyDataSetChanged();
                        adapter3.setSelectItem(0);
                    }
                    /*if (areaList3.size() > 0){
                        area_id = areaList3.get(0).getId();
                    }*/


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
        if (localUserInfo.getUserJob().equals("5")) {
            findViewByID_My(R.id.right_txt2).setVisibility(View.VISIBLE);
        } else {
            findViewByID_My(R.id.right_txt2).setVisibility(View.GONE);
        }
        findViewByID_My(R.id.right_txt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空
                workshop_id = "";//车间id
                work_area_id = "";//工区id
                station_id = "";//站区id
                status = "";//状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                disease_classify = "";//病害分类（1.一类 2.二类 3.三类）
                requestServer();
            }
        });
        findViewByID_My(R.id.right_txt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //批量
                CommonUtil.gotoActivity(MyAuditActivity.this, MyAuditListActivity.class, false);
            }
        });

    }

    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        page = 1;
        String string = "?employee_role=" + localUserInfo.getUserJob()
                + "&type=" + disease_classify//病害分类（1.一类 2.二类 3.三类）
                + "&status=" + status //状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                + "&workshop_id=" + workshop_id//车间id
                + "&work_area_id=" + work_area_id//工区id
                + "&station_id=" + station_id//站区id
                + "&page=" + page
                + "&count=" + "10"
                + "&token=" + localUserInfo.getToken();
        RequestMyAuditList(string);
    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }

    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });

        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("综合维修");
        list.add("大修");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        adapter.setSelectItem(i1);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1 = i;
                adapter.setSelectItem(i1);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    disease_classify = "";
                } else {
                    disease_classify = (i + 1)+"";
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }

    private void showPopupWindow2(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("上报中");
        list.add("已上报");
        list.add("下达");
        list.add("批复");
        list.add("实施");
        list.add("竣工");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        adapter.setSelectItem(i2);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i2 = i;
                adapter.setSelectItem(i2);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    status = "";
                } else {
                    status = i + "";
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);

    }

    Pop_Equipment2Adapter adapter2;
    ListView pop_listView2;
    List<String> list2 = new ArrayList<String>();
    Pop_Equipment3Adapter adapter3;
    ListView pop_listView3;
    List<String> list3 = new ArrayList<String>();

    private void showPopupWindow3(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_list3, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.linearLayout).getTop();
                int height1 = contentView.findViewById(R.id.linearLayout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView1 = (ListView) contentView.findViewById(R.id.pop_listView1);
        List<String> list1 = new ArrayList<String>();
        list1.add("全部");
        for (int i = 0; i < areaList1.size(); i++) {
            list1.add(areaList1.get(i).getTitle());
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list1);
        adapter.setSelectItem(i3_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i3_1 = i;
                adapter.setSelectItem(i3_1);
                adapter.notifyDataSetChanged();
                i3_2 = 0;
                i3_3 = 0;
                work_area_id = "";//工区id
                station_id = "";//站区id
                if (i == 0) {
                    workshop_id = "";//车间id
                } else {
                    //获取该车间所属工区
                    workshop_id = areaList1.get(i - 1).getId();
                    ;//车间id
                }
                String string = "?token=" + localUserInfo.getToken()
                        + "&workshop_id=" + workshop_id;
                RequestAreaList2(string);//区域列表

                requestServer();
            }
        });

        pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        adapter2 = new Pop_Equipment2Adapter(this, list2);
        adapter2.setSelectItem(i3_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i3_2 = i;
                adapter2.setSelectItem(i3_2);
                adapter2.notifyDataSetChanged();

                i3_3 = 0;
                station_id = "";//站区id
                //获取该工区所属站区
                if (i == 0) {
                    work_area_id = "";//工区id
                } else {
                    work_area_id = areaList2.get(i - 1).getId();//工区id

                }
                String string = "?token=" + localUserInfo.getToken()
                        + "&work_area_id=" + work_area_id;
                RequestAreaList3(string);//站区列表
                requestServer();
            }
        });

        pop_listView3 = (ListView) contentView.findViewById(R.id.pop_listView3);
        adapter3 = new Pop_Equipment3Adapter(this, list3);
        adapter3.setSelectItem(i3_3);
        pop_listView3.setAdapter(adapter3);
        pop_listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i3_3 = i;
                adapter3.setSelectItem(i3_3);
                adapter3.notifyDataSetChanged();
                if (i == 0) {
                    station_id = "";//站区id
                } else {
                    station_id = areaList3.get(i - 1).getId();
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }
}
