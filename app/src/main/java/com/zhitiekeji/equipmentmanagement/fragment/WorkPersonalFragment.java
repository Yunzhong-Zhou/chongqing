package com.zhitiekeji.equipmentmanagement.fragment;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.LoginActivity;
import com.zhitiekeji.equipmentmanagement.activity.WorkshopStatisticsActivity;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.WorkPersonalAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseFragment;
import com.zhitiekeji.equipmentmanagement.model.WorkPersonalModel;
import com.zhitiekeji.equipmentmanagement.model.YearModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.utils.TimeUtil;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/1/16.
 * 个人工区
 */
public class WorkPersonalFragment extends BaseFragment {
    //顶部标题栏
    private ImageView imageView1, imageView2;
    //分类选择栏
    private LinearLayout linearLayout1, linearLayout2;
    private TextView textView1, textView2,
            textView1_1, textView2_1;
    private View pop_view;
    //年份选择下标
    int i1 = 0;
    List<YearModel> areaList1 = new ArrayList<YearModel>();
    String year = TimeUtil.GetYear()+"";

    int page = 1;
    private ListView listView;
    List<WorkPersonalModel> list = new ArrayList<WorkPersonalModel>();
    WorkPersonalAdapter adapter;
    List<WorkPersonalModel> list1 = new ArrayList<WorkPersonalModel>();

    View headerView;
    private LinearLayout head_linearLayout1, head_linearLayout2, head_linearLayout3;
    private TextView head_textView1,head_textView2,head_textView4,head_textView5,head_textView7,head_textView8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workpersonal, container, false);
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
        //分类选择栏
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        pop_view = findViewByID_My(R.id.pop_view);

        listView = findViewByID_My(R.id.listView);
        //头部
//        headerView =View.inflate(getActivity(), R.layout.head_workpersonal, null);
        headerView = View.inflate(getActivity(), R.layout.head_workshop, null);
        head_linearLayout1 = (LinearLayout) headerView.findViewById(R.id.head_linearLayout1);
        head_linearLayout2 = (LinearLayout) headerView.findViewById(R.id.head_linearLayout2);
        head_linearLayout3 = (LinearLayout) headerView.findViewById(R.id.head_linearLayout3);
        head_linearLayout1.setOnClickListener(this);
        head_linearLayout2.setOnClickListener(this);
        head_linearLayout3.setOnClickListener(this);
        head_textView1 = headerView.findViewById(R.id.head_textView1);
        head_textView2 = headerView.findViewById(R.id.head_textView2);
        head_textView4 = headerView.findViewById(R.id.head_textView4);
        head_textView5 = headerView.findViewById(R.id.head_textView5);
        head_textView7 = headerView.findViewById(R.id.head_textView7);
        head_textView8 = headerView.findViewById(R.id.head_textView8);
        listView.addHeaderView(headerView, null, false);//添加头部1，必须设置adapter，不然不会显示,头部不可点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("id", list1.get(i - 1).getEmployee_id());
                bundle.putInt("type", 1);//（1.员工统计详情，2.工区统计详情，3.车间统计详情）
                bundle.putString("year", year);
                CommonUtil.gotoActivityWithData(getActivity(), WorkshopStatisticsActivity.class, bundle, false);
            }
        });
        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?year=" + year
                        + "&page=" + page//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?year=" + year
                        + "&page=" + page//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        String string3 = "?token=" + localUserInfo.getToken();
        RequestAreaList1(string3);//年份列表
        requestServer();
        /*List<WorksShopModel> list = new ArrayList<WorksShopModel>();
        for (int i = 0; i < 10; i++) {
            WorksShopModel model = new WorksShopModel();
            model.setStr("姓名" + (i + 1));
            list.add(model);
        }
        WorkPersonalAdapter adapter = new WorkPersonalAdapter(getActivity(), list);
        listView.setAdapter(adapter);*/
    }
    //年份
    private void RequestAreaList1(String string) {
        OkHttpClientManager.getAsyn(URLs.YearList + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                showErrorPage();
                if (!info.equals("")) {
//                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>年份" + response);
                JSONObject jObj;
                areaList1 = new ArrayList<YearModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    areaList1 = JSON.parseArray(jsonArray.toString(), YearModel.class);
                    year = areaList1.get(0).getYear();
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
        String string = "?year=" + year
                + "&page=" + page//当前页号
                + "&count=" + "10"//页面行数
                + "&token=" + localUserInfo.getToken();
        RequestList(string);
    }
    private void RequestList(String string) {
        OkHttpClientManager.getAsyn(URLs.WorkPersonalList + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(getActivity(), LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>列表" + response);
                JSONObject jObj;
                list = new ArrayList<WorkPersonalModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), WorkPersonalModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        if (list.size() >= 3) {
                            head_linearLayout1.setVisibility(View.VISIBLE);
                            head_linearLayout2.setVisibility(View.VISIBLE);
                            head_linearLayout3.setVisibility(View.VISIBLE);

                            head_textView1.setText(list.get(0).getName());
                            head_textView2.setText(list.get(0).getMoney());

                            head_textView4.setText(list.get(1).getName());
                            head_textView5.setText(list.get(1).getMoney());

                            head_textView7.setText(list.get(2).getName());
                            head_textView8.setText(list.get(2).getMoney());
                        }else if (list.size() == 2){
                            head_linearLayout1.setVisibility(View.VISIBLE);
                            head_linearLayout2.setVisibility(View.VISIBLE);
                            head_linearLayout3.setVisibility(View.GONE);

                            head_textView1.setText(list.get(0).getName());
                            head_textView2.setText(list.get(0).getMoney());

                            head_textView4.setText(list.get(1).getName());
                            head_textView5.setText(list.get(1).getMoney());

                            /*head_textView7.setText(list.get(2).getName());
                            head_textView8.setText(list.get(2).getMoney());*/
                        }else if (list.size() == 1){
                            head_linearLayout1.setVisibility(View.VISIBLE);
                            head_linearLayout2.setVisibility(View.GONE);
                            head_linearLayout3.setVisibility(View.GONE);

                            head_textView1.setText(list.get(0).getName());
                            head_textView2.setText(list.get(0).getMoney());

                           /* head_textView4.setText(list.get(1).getName());
                            head_textView5.setText(list.get(1).getMoney());*/

                            /*head_textView7.setText(list.get(2).getName());
                            head_textView8.setText(list.get(2).getMoney());*/
                        }else {
                            head_linearLayout1.setVisibility(View.GONE);
                            head_linearLayout2.setVisibility(View.GONE);
                            head_linearLayout3.setVisibility(View.GONE);
                        }
                        list1 = new ArrayList<WorkPersonalModel>();
                        if (list.size() >=4){
                            for (int i = 3; i < list.size(); i++) {
                                list1.add(list.get(i));
                            }
                        }
                        WorkPersonalAdapter adapter = new WorkPersonalAdapter(getActivity(), list1);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    private void RequestListMore(String string) {
        OkHttpClientManager.getAsyn(URLs.WorkPersonalList + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                onHttpResult();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                onHttpResult();
                MyLogger.i(">>>>>>>>>更多" + response);
                JSONObject jObj;
                List<WorkPersonalModel> list_1 = new ArrayList<WorkPersonalModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list_1 = JSON.parseArray(jsonArray.toString(), WorkPersonalModel.class);
                    if (list_1.size() == 0) {
                        myToast("没有更多了");
                    } else {
                        list1.addAll(list_1);
                        adapter.notifyDataSetChanged();
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
            case R.id.imageView1:
                //返回
                getActivity().finish();
                break;
            case R.id.imageView2:
                //编辑
                break;
            case R.id.linearLayout1:
                //年份
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow1(pop_view);
                break;
            case R.id.linearLayout2:
                //按金额高低顺序排序
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
//                showPopupWindow1(pop_view);
                break;
            case R.id.head_linearLayout1:
                //
                Bundle bundle1 = new Bundle();
                bundle1.putString("id", list.get(0).getEmployee_id());
                bundle1.putInt("type", 1);//（1.员工统计详情，2.工区统计详情，3.车间统计详情）
                bundle1.putString("year", year);
                CommonUtil.gotoActivityWithData(getActivity(), WorkshopStatisticsActivity.class, bundle1, false);
                break;
            case R.id.head_linearLayout2:
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", list.get(1).getEmployee_id());
                bundle2.putInt("type", 1);//（1.员工统计详情，2.工区统计详情，3.车间统计详情）
                bundle2.putString("year", year);
                CommonUtil.gotoActivityWithData(getActivity(), WorkshopStatisticsActivity.class, bundle2, false);
                break;
            case R.id.head_linearLayout3:
                Bundle bundle3 = new Bundle();
                bundle3.putString("id", list.get(2).getEmployee_id());
                bundle3.putInt("type", 1);//（1.员工统计详情，2.工区统计详情，3.车间统计详情）
                bundle3.putString("year", year);
                CommonUtil.gotoActivityWithData(getActivity(), WorkshopStatisticsActivity.class, bundle3, false);
                break;
        }
    }
    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }
    @Override
    protected void updateView() {
    }
    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(getActivity()).inflate(
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
                    if (y > height1){
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < areaList1.size(); i++) {
            list.add(areaList1.get(i).getYear());
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(getActivity(), list);
        adapter.setSelectItem(i1);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1 = i;
                adapter.setSelectItem(i1);
                adapter.notifyDataSetChanged();
                year = list.get(i);
                requestServer();
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
