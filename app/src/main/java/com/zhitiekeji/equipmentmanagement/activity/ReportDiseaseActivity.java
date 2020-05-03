package com.zhitiekeji.equipmentmanagement.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.ReportDiseaseListAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.DiseaseCheckModel;
import com.zhitiekeji.equipmentmanagement.model.ReportDiseaseListModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhitiekeji.equipmentmanagement.utils.Global.mContext;

/**
 * Created by fafukeji01 on 2017/1/18.
 * 发布维修申请页面
 */

public class ReportDiseaseActivity extends BaseActivity {
    String EquipmentID = "";
    String publish_disease_id = "";

    String faxianbinghai = "";

    int e_type = 0;

    String facility_service_apply_id = "";//设备维修申请id
    private SwipeMenuListView listView;
    List<ReportDiseaseListModel> list = new ArrayList<ReportDiseaseListModel>();
    ReportDiseaseListAdapter adapter;
    private TextView textView1, textView2, textView3, textView4, textView5;

    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reported);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress(true, "正在获取数据...");

        //设备type
        String string = "?id=" + EquipmentID//设备id
                + "&token=" + localUserInfo.getToken();
        RequestEquipmentDetail(string);
    }

    @Override
    protected void initView() {
        listView = (SwipeMenuListView) findViewById(R.id.listView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
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
                        String string = "?id=" + list.get(position).getId()//病害id
                                + "&token=" + localUserInfo.getToken();
                        RequestDetele(string, position);
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        EquipmentID = getIntent().getStringExtra("EquipmentID");

        publish_disease_id = getIntent().getStringExtra("publish_disease_id");

        faxianbinghai = getIntent().getStringExtra("faxianbinghai");

    }

    //设备type
    private void RequestEquipmentDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_TYPE + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>设备详情——e_type" + response);
                JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    JSONObject jObj1 = jObj.getJSONObject("data");
                    e_type = jObj1.getInt("type");
                    //检查是否存在未提交的设备维修申请-获取设备维修申请id
                    String string = "?facility_id=" + EquipmentID//设备id
                            + "&employee_id=" + localUserInfo.getUserId()
                            + "&token=" + localUserInfo.getToken();
                    RequestCheck(string);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //检查是否存在未提交的设备维修申请-获取设备维修申请id
    private void RequestCheck(String string) {
        OkHttpClientManager.getAsyn(URLs.Disease_Check + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>检查是否存在未提交的设备维修申请-获取设备维修申请id" + response);
                JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    int code = jObj.getInt("code");
                    if (code == 9) {
                        //没有维修申请id-跳转到添加病害
                        /*Intent intent = new Intent(ReportDiseaseActivity.this, AddDiseaseActivity.class);
                        intent.putExtra("EquipmentID",EquipmentID);
                        intent.putExtra("publish_disease_id", publish_disease_id);
                        intent.putExtra("facility_service_apply_id",facility_service_apply_id);
                        startActivity(intent);*/
                        adapter = new ReportDiseaseListAdapter(ReportDiseaseActivity.this, list, EquipmentID, facility_service_apply_id, publish_disease_id, false, e_type);
                        listView.setAdapter(adapter);
                    } else {
                        DiseaseCheckModel model = new DiseaseCheckModel();
                        JSONObject object1 = jObj.getJSONObject("data");
                        model = JSON.parseObject(object1.toString(), DiseaseCheckModel.class);
                        facility_service_apply_id = model.getId();

                        if (facility_service_apply_id.equals("")) {
                            //没有维修申请id-跳转到添加病害
                            /*Intent intent = new Intent(ReportDiseaseActivity.this, AddDiseaseActivity.class);
                            intent.putExtra("EquipmentID",EquipmentID);
                            intent.putExtra("publish_disease_id", publish_disease_id);
                            intent.putExtra("facility_service_apply_id",facility_service_apply_id);
                            startActivity(intent);*/
                            adapter = new ReportDiseaseListAdapter(ReportDiseaseActivity.this, list, EquipmentID, facility_service_apply_id, publish_disease_id, false, e_type);
                            listView.setAdapter(adapter);
                        } else {
                            //获取病害列表
                            String string = "?facility_service_apply_id=" + facility_service_apply_id//设备维修申请id
                                    + "&token=" + localUserInfo.getToken();
                            RequestDiseaseList(string);
                        }
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //获取病害列表
    private void RequestDiseaseList(String string) {
        OkHttpClientManager.getAsyn(URLs.Disease_List + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>获取病害列表" + response);
                JSONObject jObj;
                list = new ArrayList<ReportDiseaseListModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), ReportDiseaseListModel.class);
                    adapter = new ReportDiseaseListAdapter(ReportDiseaseActivity.this, list, EquipmentID, facility_service_apply_id, publish_disease_id, false, e_type);
                    listView.setAdapter(adapter);
                    double allmoney = 0;
                    for (int i = 0; i < list.size(); i++) {
                        allmoney = allmoney + Double.valueOf(list.get(i).getAmount_money());
                    }
                    textView4.setText(allmoney + "元");

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
                MyLogger.i(">>>>>>>>>删除病害列表" + response);
                /*list.remove(position);
                adapter.notifyDataSetChanged();*/
                //获取病害列表
                String string = "?facility_service_apply_id=" + facility_service_apply_id//设备维修申请id
                        + "&token=" + localUserInfo.getToken();
                RequestDiseaseList(string);

            }
        });
    }

    //提交设备维修申请
    AlertDialog alertDialog3;
    List<String> items_ids = new ArrayList<>();

    String flag = "";
    String id = "";

    private void RequestUpData(HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.Disease_UpData, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (!info.equals("")) {
                    /*if (info.equals("系统繁忙，请稍后再试")){
                        //相应超时后，跳转到我的申请
                        CommonUtil.gotoActivity(ReportDiseaseActivity.this, MyReportActivity.class, true);
                    }else {
                        showToast(info);
                    }*/
                    showToast(info);
                }
                textView5.setClickable(true);
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>提交设备维修申请" + response);
                myToast("提交成功");
                //判断是不是从确认巡检入口进入，如是则生成巡检记录
                if (faxianbinghai.equals("1")){
                    HashMap<String, String> params1 = new HashMap<>();
                    params1.put("facility_id", EquipmentID);
                    params1.put("employee_id", LocalUserInfo.getInstance(mContext).getUserId());
                    params1.put("status", "2");
                    params1.put("token", LocalUserInfo.getInstance(mContext).getToken());
                    RequestCheck(params1);//生成巡检记录（有病害）
                }

                JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    if (type == 1) {
                        //需要解析
                        JSONObject jObj1 = jObj.getJSONObject("data");
                        flag = jObj1.getString("flag");
                        id = jObj1.getString("id");
                    } else {
                        flag = jObj.getString("data");
                    }

                    if (flag.equals("true")) {
                        // 多选提示框
                        final String[] items = {"副工长", "工长", "副科长", "科长", "副段长", "段长"};
                        // 创建一个AlertDialog建造者
                        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ReportDiseaseActivity.this);
                        // 设置标题
                        alertDialogBuilder.setTitle("请选择要通知的人");
                        // 参数介绍
                        // 第一个参数：弹出框的信息集合，一般为字符串集合
                        // 第二个参数：被默认选中的，一个布尔类型的数组
                        // 第三个参数：勾选事件监听
                        alertDialogBuilder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // dialog：不常使用，弹出框接口
                                // which：勾选或取消的是第几个
                                // isChecked：是否勾选
                                if (isChecked) {
                                    // 选中
//                                    Toast.makeText(ReportDiseaseActivity.this, "选中"+which+1, Toast.LENGTH_SHORT).show();
                                    items_ids.add((which + 1) + "");
                                    MyLogger.i(">>>>选中的人" + items_ids);
                                } else {
                                    // 取消选中
//                                    Toast.makeText(ReportDiseaseActivity.this, "取消选中"+which+1, Toast.LENGTH_SHORT).show();
                                    items_ids.remove((which + 1) + "");
                                    MyLogger.i(">>>>选中的人" + items_ids);
                                }

                            }
                        });
                        alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //TODO 业务逻辑代码
                                MyLogger.i(">>>>选中的人" + items_ids);
                                // 关闭提示框
                                alertDialog3.dismiss();

                                //短信通知相关负责人
                                String string = "";
                                for (int i = 0; i < items_ids.size(); i++) {
                                    string = string + items_ids.get(i) + "|";
                                }
                                HashMap<String, String> params = new HashMap<String, String>();
                                params.put("persons", string);
                                params.put("facility_id", EquipmentID);
                                params.put("token", localUserInfo.getToken());
                                RequestNotice(params, id);
                            }
                        });
                        alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // TODO 业务逻辑代码
                                // 关闭提示框
                                alertDialog3.dismiss();
                                if (type == 1) {
                                    //跳转到请检修发布详情
                                    Bundle bundle = new Bundle();
                                    bundle.putString("facility_service_apply_id", id);//设备维修申请id
                                    CommonUtil.gotoActivityWithData(ReportDiseaseActivity.this, AddPleaseOverhaulActivity.class, bundle, true);
                                } else {
                                    //跳转到我的上报
                                    CommonUtil.gotoActivity(ReportDiseaseActivity.this, MyReportActivity.class, true);
                                }
                            }
                        });
                        alertDialog3 = alertDialogBuilder.create();
                        alertDialog3.show();

                        textView5.setClickable(true);
                    } else {
                        if (type == 1) {
                            //跳转到请检修发布详情
                            Bundle bundle = new Bundle();
                            bundle.putString("facility_service_apply_id", id);//设备维修申请id
                            CommonUtil.gotoActivityWithData(ReportDiseaseActivity.this, AddPleaseOverhaulActivity.class, bundle, true);
                        } else {
                            //跳转到我的上报
                            CommonUtil.gotoActivity(ReportDiseaseActivity.this, MyReportActivity.class, true);
                        }
                        textView5.setClickable(true);
                    }


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
    }

    private void RequestNotice(Map<String, String> params, final String id) {
        OkHttpClientManager.postAsyn(URLs.Disease_NoticeList, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>短信通知相关负责人" + response);
                myToast("发出通知成功");
                if (type == 1) {
                    //跳转到请检修发布详情
                    Bundle bundle = new Bundle();
                    bundle.putString("facility_service_apply_id", id);//设备维修申请id
                    CommonUtil.gotoActivityWithData(ReportDiseaseActivity.this, AddPleaseOverhaulActivity.class, bundle, true);
                } else {
                    //跳转到我的上报
                    CommonUtil.gotoActivity(ReportDiseaseActivity.this, MyReportActivity.class, true);
                }
            }
        });

    }

    private void RequestCheck(HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.EQUIPMENT_CHECK ,params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    Toast.makeText(mContext,info,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>设备详情-巡检-是否发现病害" + response);

            }
        });

    }
    @Override
    public void onClick(View v) {
        Drawable drawable_xuanzhong = getResources().getDrawable(R.mipmap.reported_xuanzhong);
        drawable_xuanzhong.setBounds(0, 0, drawable_xuanzhong.getMinimumWidth(), drawable_xuanzhong.getMinimumHeight());
        Drawable drawable_weixuan = getResources().getDrawable(R.mipmap.reported_weixuan);
        drawable_weixuan.setBounds(0, 0, drawable_weixuan.getMinimumWidth(), drawable_weixuan.getMinimumHeight());
        switch (v.getId()) {
            case R.id.textView1:
                //请检修
                textView1.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                textView2.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView3.setCompoundDrawables(drawable_weixuan, null, null, null);
                type = 1;
//                /*Bundle bundle = new Bundle();
//                bundle.putString("facility_service_apply_id", facility_service_apply_id);//设备维修申请id
//                CommonUtil.gotoActivityWithData(ReportDiseaseActivity.this, AddPleaseOverhaulActivity.class, bundle, true);*/
                break;
            case R.id.textView2:
                //综合维修
                textView1.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView2.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                textView3.setCompoundDrawables(drawable_weixuan, null, null, null);
                type = 2;
                break;
            case R.id.textView3:
                //大修
                textView1.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView2.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView3.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                type = 3;
                break;
            case R.id.textView5:
                //提交
                if (list.size() >0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ReportDiseaseActivity.this);
                    builder.setMessage("检查填写无误，确认提交");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            textView5.setClickable(false);

                            showProgress(true, "正在上传数据，请稍后...");
                            params.put("id", facility_service_apply_id);//设备维修申请id
                            params.put("type", type + "");//类型（1.请检修 2.综合维修 3.大修）
                            params.put("token", localUserInfo.getToken());//token
                            RequestUpData(params);
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }else {
                    showToast("请上传病害");
                }


                break;
        }
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("发布维修申请");
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
