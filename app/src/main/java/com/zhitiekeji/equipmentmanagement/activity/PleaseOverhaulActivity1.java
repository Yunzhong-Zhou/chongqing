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
import com.zhitiekeji.equipmentmanagement.adapter.PleaseOverhaulAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter1;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment3Adapter;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.AreaModel1;
import com.zhitiekeji.equipmentmanagement.model.AreaModel2;
import com.zhitiekeji.equipmentmanagement.model.AreaModel3;
import com.zhitiekeji.equipmentmanagement.model.PleaseOverhaulModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.utils.TimeUtil;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.zhitiekeji.equipmentmanagement.R.id.pop_listView;

/**
 * Created by fafukeji01 on 2017/6/15.
 * 我的请检修-用户中心
 */

public class PleaseOverhaulActivity1 extends BaseActivity{
    //分类选择栏
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    private TextView textView1, textView2, textView3, textView4,
            textView1_1, textView2_1, textView3_1, textView4_1;
    private View pop_view;
    private ListView listView;
    PleaseOverhaulAdapter adapter;
    List<PleaseOverhaulModel> list = new ArrayList<PleaseOverhaulModel>();
    int page = 1;
    String year = "";//年份
    int i1_1 = 0;//年份选择下标
    String month = "";//月份
    int i1_2 = 0;//月份选择下标
    String status = "";//状态（1.待完善 2.待签字 3.完成）
    int i2 = 0;//状态下标
    //区域列表数据-车间
    List<AreaModel1> areaList1 = new ArrayList<AreaModel1>();
    //区域列表数据-工区
    List<AreaModel2> areaList2 = new ArrayList<AreaModel2>();
    //区域列表数据-站区
    List<AreaModel3> areaList3 = new ArrayList<AreaModel3>();
    String station_id = "";//区域id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pleaseoverhaul);
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
                bundle.putString("EquipmentID",list.get(i).getId());
                CommonUtil.gotoActivityWithData(PleaseOverhaulActivity1.this, PleaseOverhaulDetailActivity.class,bundle,false);
            }
        });

        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?status=" + station_id//区域id
                        + "&year=" + year//年份
                        + "&month=" + month//月份
                        + "&status=" + status//状态（1.待完善 2.待签字 3.完成）
                        + "&page=" + page+""//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestOverhaulList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?status=" + station_id//区域id
                        + "&year=" + year//年份
                        + "&month=" + month//月份
                        + "&status=" + status//状态（1.待完善 2.待签字 3.完成）
                        + "&page=" + page+""//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestOverhaulListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        /*String string3 = "?token=" + localUserInfo.getToken();
        RequestAreaList1(string3);//区域列表*/
        requestServer();//获取数据
    }
    private void RequestOverhaulList(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_OVERHAULLIST2+string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")){
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>我的请检修列表" + response);
                JSONObject jObj;
                list = new ArrayList<PleaseOverhaulModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), PleaseOverhaulModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new PleaseOverhaulAdapter(PleaseOverhaulActivity1.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    private void RequestOverhaulListMore(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_OVERHAULLIST2 + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>我的请检修更多" + response);
                JSONObject jObj;
                List<PleaseOverhaulModel> list1 = new ArrayList<PleaseOverhaulModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), PleaseOverhaulModel.class);
                    if (list1.size() == 0) {
                        myToast("没有更多了");
                    } else {
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
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
                if (!info.equals("")) {
                    showToast(info);
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

                    if (areaList1.size() > 0) {
                        //获取第一个车间所属工区
                        String string = "?token=" + localUserInfo.getToken()
                                + "&workshop_id=" + areaList1.get(0).getId();
                        RequestAreaList2(string);//区域列表
                    }

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
                    for (int i = 0; i < areaList2.size(); i++) {
                        list2.add(areaList2.get(i).getTitle());
                    }
                    if (adapter2 != null){
//                        adapter2 = new Pop_Equipment2Adapter(getActivity(),list2);
//                        pop_listView2.setAdapter(adapter2);
                        adapter2.notifyDataSetChanged();
                        adapter2.setSelectItem(0);
                    }
                    if (areaList2.size() > 0) {
                        //获取第一个车间所属站区
                        String string = "?token=" + localUserInfo.getToken()
                                + "&work_area_id=" + areaList2.get(0).getId();
                        RequestAreaList3(string);//站区列表
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
                    for (int i = 0; i < areaList3.size(); i++) {
                        list3.add(areaList3.get(i).getTitle());
                    }
                    if (adapter3 != null){
                        adapter3.notifyDataSetChanged();
                        adapter3.setSelectItem(0);
                    }
                    if (areaList3.size() > 0){
                        station_id = areaList3.get(0).getId();
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
                //批次号
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
                showPopupWindow1(pop_view);

                break;
            case R.id.linearLayout2:
                //状态
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
                showPopupWindow2(pop_view);
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
                showPopupWindow3(pop_view);
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
                showPopupWindow4(pop_view);
                break;
        }
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("我的请检修");
            titleView.showRightTextview("清空", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    station_id = "";//区域id
                    status = "";//状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                     year = "";//年份
                     month = "";//月份
                    requestServer();
                }
            });
        }
    }
    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        String string = "?status=" + station_id//区域id
                + "&year=" + year//年份
                + "&month=" + month//月份
                + "&status=" + status//状态（1.待完善 2.待签字 3.完成）
                + "&page=" + "1"//当前页号
                + "&count=" + "10"//页面行数
                + "&token=" + localUserInfo.getToken();
        RequestOverhaulList(string);
    }
    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }

    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(PleaseOverhaulActivity1.this).inflate(
                R.layout.pop_list2, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

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
        List<String> list = new ArrayList<String>();
        final String tempYear = TimeUtil.GetYear() + "";
        list.add("全部");
        for (int i = 0; i < 10; i++) {
            list.add((Integer.valueOf(tempYear) - i) + "年");
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(PleaseOverhaulActivity1.this, list);
        adapter.setSelectItem(i1_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1_1 = i;
                adapter.setSelectItem(i1_1);
                adapter.notifyDataSetChanged();
//                popupWindow.dismiss();
                if (i== 0){
                    year = "";
                }else {
                    year = Integer.valueOf(tempYear) - (i-1) + "";
                }
                requestServer();
            }
        });
        ListView pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        List<String> list2 = new ArrayList<String>();
        list2.add("全部");
        for (int i = 0; i < 12; i++) {
            list2.add((1 + i) + "月");
        }
        final Pop_Equipment2Adapter1 adapter2 = new Pop_Equipment2Adapter1(PleaseOverhaulActivity1.this, list2);
        adapter2.setSelectItem(i1_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1_2= i;
                adapter2.setSelectItem(i1_2);
                adapter2.notifyDataSetChanged();
                if (i == 0){
                    month = "";
                }else {
                    month = i + "";
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
        final View contentView = LayoutInflater.from(PleaseOverhaulActivity1.this).inflate(
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
        list.add("待完善");
        list.add("待签字");
        list.add("完成");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(PleaseOverhaulActivity1.this, list);
        adapter.setSelectItem(i2);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i2 = i;
                adapter.setSelectItem(i2);
                adapter.notifyDataSetChanged();
                if (i== 0){
                    status = "";
                }else {
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
        final View contentView = LayoutInflater.from(PleaseOverhaulActivity1.this).inflate(
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
        for (int i = 0; i < areaList1.size(); i++) {
            list1.add(areaList1.get(i).getTitle());
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(PleaseOverhaulActivity1.this, list1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
                //获取该车间所属工区
                String string = "?token=" + localUserInfo.getToken()
                        + "&workshop_id=" + areaList1.get(i).getId();
                RequestAreaList2(string);//区域列表
                adapter2.notifyDataSetChanged();
            }
        });

        pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        adapter2 = new Pop_Equipment2Adapter(PleaseOverhaulActivity1.this, list2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter2.setSelectItem(i);
                adapter2.notifyDataSetChanged();
                //获取该工区所属站区
                String string = "?token=" + localUserInfo.getToken()
                        + "&work_area_id=" + areaList2.get(i).getId();
                RequestAreaList3(string);//站区列表
                adapter3.notifyDataSetChanged();
            }
        });

        pop_listView3 = (ListView) contentView.findViewById(R.id.pop_listView3);
        adapter3 = new Pop_Equipment3Adapter(PleaseOverhaulActivity1.this, list3);
        pop_listView3.setAdapter(adapter3);
        pop_listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter3.setSelectItem(i);
                adapter3.notifyDataSetChanged();
                station_id = areaList3.get(i).getId();
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
    private void showPopupWindow4(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(PleaseOverhaulActivity1.this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(pop_listView).getTop();
                int height1 = contentView.findViewById(pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1){
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("2016");
        list.add("2015");
        list.add("2014");
        list.add("2013");
        list.add("2012");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(PleaseOverhaulActivity1.this, list);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
//                popupWindow.dismiss();
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
