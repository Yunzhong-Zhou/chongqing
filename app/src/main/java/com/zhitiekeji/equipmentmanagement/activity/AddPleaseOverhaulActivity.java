package com.zhitiekeji.equipmentmanagement.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.TimePickerView;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_Equipment2Adapter1;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.MaterialModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zyz on 2017/8/25.
 * 添加请检修详情
 */

public class AddPleaseOverhaulActivity extends BaseActivity {
    String facility_service_apply_id = "";//设备维修申请id
    //派修工单
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    TextView textView11, textView12, textView13, textView14, textView15, textView16, textView17, next, textView18;
    LinearLayout linearLayout_add, linearLayout2;

    private TimePickerView pvTime1, pvTime2;//时间选择器
    String start_at = "";
    String end_at = "";

    String secure_item = "", implement_content = "", client_mobile = "", client_feedback = "";
    //工时消耗（json数据：天/金额） 如：{ "day": "10", "money": "1000"}
    String day = "", money1 = "";
    String manhour = "";
    //汽车消耗（json数据：KM/金额） 如：{ "length": "10", "money": "500"}
    String length = "", money2 = "";
    String mileage = "";
    //材料消耗（json数据：种类/数量/金额） 如：[{ "material_id": "x01", "qty": "8", "money": "800"}, { "material_id": "x02", "qty": "20", "money": "2000"}]
//    List<MaterialJsonModel> materialjsonlist = new ArrayList<MaterialJsonModel>();
    String material = "";
    //材料选择下标
    int i_1 = 0;
    int i_2 = 0;
    ArrayList<String> listFileNames = new ArrayList<>();
    ArrayList<File> listFiles = new ArrayList<>();

    //材料数据-父类
    List<MaterialModel> materialList1 = new ArrayList<MaterialModel>();
    //材料数据-子类
    List<MaterialModel> materialList2 = new ArrayList<MaterialModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpleaseoverhaul);
    }

    @Override
    protected void initView() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        next = (TextView) findViewById(R.id.next);
        linearLayout_add = (LinearLayout) findViewById(R.id.linearLayout_add);
        addMaterialView();//添加材料布局

        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        textView18 = (TextView) findViewById(R.id.textView18);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
    }

    @Override
    protected void initData() {
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");//设备维修申请id
        //材料种类
        String string = "?parent_id=" + ""//父id（当不传此参数时，查询材料种类）
                + "&token=" + localUserInfo.getToken();
        RequestMaterial1(string);
        initTimePicker1();
    }

    //材料种类-父类
    private void RequestMaterial1(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_Material + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddPleaseOverhaulActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>材料种类-父类" + response);
                JSONObject jObj;
                materialList1 = new ArrayList<MaterialModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    materialList1 = JSON.parseArray(jsonArray.toString(), MaterialModel.class);

                    if (materialList1.size() > 0) {
                        //材料-子类-获取第一个材料
                        String string = "?parent_id=" + materialList1.get(0).getId()//父id（当不传此参数时，查询材料种类）
                                + "&token=" + localUserInfo.getToken();
                        RequestMaterial2(string);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    //材料种类-子类
    private void RequestMaterial2(String string) {
        OkHttpClientManager.getAsyn(URLs.MANAGEMENT_Material + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddPleaseOverhaulActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>材料种类-子类" + response);
                JSONObject jObj;
                materialList2 = new ArrayList<MaterialModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    materialList2 = JSON.parseArray(jsonArray.toString(), MaterialModel.class);

                    list2 = new ArrayList<String>();
                    for (int i = 0; i < materialList2.size(); i++) {
                        list2.add(materialList2.get(i).getTitle());
                    }
                    if (pop_listView2 != null) {
                        adapter2 = new Pop_Equipment2Adapter1(AddPleaseOverhaulActivity.this, list2);
                        pop_listView2.setAdapter(adapter2);
//                        adapter2.notifyDataSetChanged();
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
        switch (v.getId()) {
            case R.id.textView11:
                //派工时间
                pvTime1.show(textView11);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            case R.id.textView12:
                //完工时间
                if (!start_at.equals(""))
                    pvTime2.show(textView12);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                else
                    showToast("请先选择派工时间");
                break;
            case R.id.textView13:
                //现场
                Bundle bundle13 = new Bundle();
                bundle13.putString("name", "现场");
                CommonUtil.gotoActivityWithDataForResult(AddPleaseOverhaulActivity.this, SignatureMoreActivity.class, bundle13, 10020, false);
                break;
            case R.id.textView14:
                //工长
                Bundle bundle14 = new Bundle();
                bundle14.putString("name", "工长");
                CommonUtil.gotoActivityWithDataForResult(AddPleaseOverhaulActivity.this, SignatureMoreActivity.class, bundle14, 10021, false);
                break;
            case R.id.textView15:
                //技术员
                Bundle bundle15 = new Bundle();
                bundle15.putString("name", "技术员");
                CommonUtil.gotoActivityWithDataForResult(AddPleaseOverhaulActivity.this, SignatureMoreActivity.class, bundle15, 10022, false);
                break;
            case R.id.textView16:
                //劳务公司
                Bundle bundle16 = new Bundle();
                bundle16.putString("name", "劳务公司");
                CommonUtil.gotoActivityWithDataForResult(AddPleaseOverhaulActivity.this, SignatureMoreActivity.class, bundle16, 10023, false);
                break;
            case R.id.textView17:
                //用户签字
                Bundle bundle17 = new Bundle();
                bundle17.putString("name", "用户");
                CommonUtil.gotoActivityWithDataForResult(AddPleaseOverhaulActivity.this, SignatureMoreActivity.class, bundle17, 10024, false);
                break;
            case R.id.next:
                //确认提交
                if (match()) {
                    MyLogger.i(">>>>>>>>>工时消耗：" + manhour + ">>>>>>>>>汽车消耗：" + mileage + ">>>>>>材料消耗：" + material);
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddPleaseOverhaulActivity.this);
                    builder.setMessage("检查填写无误，确认提交");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            showProgress(true, "正在上传数据，请稍后...");
                            String[] filenames = new String[]{};
                            File[] files = new File[]{};
                            for (int i = 0; i < listFiles.size(); i++) {
                                filenames = listFileNames.toArray(new String[i]);
                                files = listFiles.toArray(new File[i]);
                            }
                            params.put("token", localUserInfo.getToken());//token
//                    params.put("employee_id", localUserInfo.getUserId());//员工id
                            params.put("id", facility_service_apply_id);//设备维修申请id
                            params.put("start_at", start_at);//派工时间
                            params.put("end_at", end_at);//完工时间
                            params.put("secure_item", secure_item);//安全事项
                            params.put("implement_content", implement_content);//实施内容
                            params.put("client_mobile", client_mobile);//用户电话
                            params.put("client_feedback", client_feedback);//用户反馈

                            params.put("manhour", manhour);//工时消耗（json数据：天/金额） 如：{ "day": "10", "money": "1000"}
                            params.put("mileage", mileage);//汽车消耗（json数据：KM/金额） 如：{ "length": "10", "money": "500"}
                            params.put("material", material);//材料消耗（json数据：种类/数量/金额） 如：[{ "material_id": "x01", "qty": 8, "money": "800"}, { "material_id": "x02", "qty": 20, "money": "2000"}]
                            RequestAddPleaseOverhaul(filenames, files, params);//设备列表
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
                break;
            case R.id.linearLayout2:
                //材料种类
//                showPopupWindow(linearLayout2,textView18);
                break;
            case R.id.add:
                //添加布局
                addMaterialView();
                break;
        }
    }

    //添加材料布局
    private void addMaterialView() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater = LayoutInflater.from(AddPleaseOverhaulActivity.this);
        View view = inflater.inflate(R.layout.item_pleaseoverhauldetail_material, null, false);
        view.setLayoutParams(lp);
        //实例化子页面的控件
        final TextView textView = (TextView) view.findViewById(R.id.textView);
        final TextView textView_1 = (TextView) view.findViewById(R.id.textView_1);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        EditText editText_1 = (EditText) view.findViewById(R.id.editText_1);
        EditText editText_2 = (EditText) view.findViewById(R.id.editText_2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(linearLayout, textView, textView_1);
            }
        });
        linearLayout_add.addView(view);
    }

    private boolean match() {
        if (TextUtils.isEmpty(start_at)) {
            showToast("请选择派工时间");
            return false;
        }
        if (TextUtils.isEmpty(end_at)) {
            showToast("请选择完工时间");
            return false;
        }
        //工时消耗
        day = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(day)) {
            showToast("请输入工时消耗的天数");
            return false;
        }
        money1 = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(money1)) {
            showToast("请输入工时消耗的金额");
            return false;
        }
        try {
            JSONObject mJsonobjData = new JSONObject();
            mJsonobjData.put("day", day);
            mJsonobjData.put("money", money1);
            manhour = mJsonobjData.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //汽车消耗
        length = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(length)) {
            showToast("请输入汽车消耗的距离");
            return false;
        }
        money2 = editText4.getText().toString().trim();
        if (TextUtils.isEmpty(money2)) {
            showToast("请输入汽车消耗的金额");
            return false;
        }
        try {
            JSONObject mJsonobjData = new JSONObject();
            mJsonobjData.put("length", length);
            mJsonobjData.put("money", money2);
            mileage = mJsonobjData.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //材料消耗
        JSONArray idCradArray = new JSONArray();
        for (int i = 0; i < linearLayout_add.getChildCount(); i++) {
            View childAt = linearLayout_add.getChildAt(i);
            TextView textView_1 = (TextView) childAt.findViewById(R.id.textView_1);
            EditText editText_1 = (EditText) childAt.findViewById(R.id.editText_1);
            EditText editText_2 = (EditText) childAt.findViewById(R.id.editText_2);
            if (!TextUtils.isEmpty(textView_1.getText().toString()) && !TextUtils.isEmpty(editText_1.getText().toString()) && !TextUtils.isEmpty(editText_2.getText().toString())) {
                try {
                    JSONObject stoneObject = new JSONObject();
                    stoneObject.put("material_id", textView_1.getText().toString());
                    stoneObject.put("qty", editText_1.getText().toString().trim());
                    stoneObject.put("money", editText_2.getText().toString().trim());
                    idCradArray.put(stoneObject);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            } else {
                showToast("请完善材料消耗");
            }
        }
        material = idCradArray.toString();

        secure_item = editText6.getText().toString().trim();
        if (TextUtils.isEmpty(secure_item)) {
            showToast("请输入注意安全事项");
            return false;
        }
        implement_content = editText7.getText().toString().trim();
        if (TextUtils.isEmpty(implement_content)) {
            showToast("请输入施工内容");
            return false;
        }
        client_mobile = editText8.getText().toString().trim();
        if (TextUtils.isEmpty(client_mobile)) {
            showToast("请输入用户电话");
            return false;
        }
        client_feedback = editText9.getText().toString().trim();
        if (TextUtils.isEmpty(client_feedback)) {
            showToast("请输入用户反馈");
            return false;
        }

        return true;
    }

    private void RequestAddPleaseOverhaul(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_ADDOVERHAU, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddPleaseOverhaulActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>完善请检修资料" + response);
                myToast("添加成功");
                finish();
            }
        }, this);

    }

    private void initTimePicker1() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
//        startDate.set(2013,0,23);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2019,11,28);
        //时间选择器
        pvTime1 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView txt = (TextView) v;
                txt.setText(getTime(date));
                start_at = getTime(date);

                SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
                SimpleDateFormat format_m = new SimpleDateFormat("MM");
                SimpleDateFormat format_d = new SimpleDateFormat("dd");
                initTimePicker2(Integer.valueOf(format_y.format(date).toString()),
                        Integer.valueOf(format_m.format(date).toString()) - 1,
                        Integer.valueOf(format_d.format(date).toString()) + 1);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
//                .setRangDate(startDate,endDate)
                .build();
    }

    private void initTimePicker2(int y, int m, int d) {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(y, m, d);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2100, 11, 31);
        //时间选择器
        pvTime2 = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                end_at = getTime(date);
                TextView txt = (TextView) v;
                txt.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    Pop_Equipment2Adapter1 adapter2;
    ListView pop_listView2;
    List<String> list2 = new ArrayList<String>();

    private void showPopupWindow(View v, final TextView textView, final TextView textView_1) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(AddPleaseOverhaulActivity.this).inflate(
                R.layout.pop_list2, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
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
        for (int i = 0; i < materialList1.size(); i++) {
            list.add(materialList1.get(i).getTitle());
        }

        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(AddPleaseOverhaulActivity.this, list);
        adapter.setSelectItem(i_1);
        pop_listView1.setAdapter(adapter);
        pop_listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i_1 = i;
                i_2 = 0;
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
//                popupWindow.dismiss();
                //材料-子类-获取第一个材料
                String string = "?parent_id=" + materialList1.get(i).getId()//父id（当不传此参数时，查询材料种类）
                        + "&token=" + localUserInfo.getToken();
                RequestMaterial2(string);
            }
        });
        pop_listView2 = (ListView) contentView.findViewById(R.id.pop_listView2);
        adapter2 = new Pop_Equipment2Adapter1(AddPleaseOverhaulActivity.this, list2);
        adapter2.setSelectItem(i_2);
        pop_listView2.setAdapter(adapter2);
        pop_listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i_2 = i;
                adapter2.setSelectItem(i);
                adapter2.notifyDataSetChanged();
                textView_1.setText(materialList2.get(i).getId());//保存材料id
                textView.setText(materialList2.get(i).getTitle());
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
//        popupWindow.showAsDropDown(v);
        if (Build.VERSION.SDK_INT < 24) {
            popupWindow.showAsDropDown(v);
        } else {
            // 适配 android 7.0
            int[] location = new int[2];
            v.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            Log.e(getClass().getSimpleName(), "x : " + x + ", y : " + y);
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, y + v.getHeight());
        }

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("完善请检修资料");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 10020:
                    //现场
                    textView13.setClickable(false);
                    textView13.setText("现场已签名");
                    showToast("现场签名成功");
                    listFileNames.add("scene_signature");
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_现场.png";
                    File file1 = new File(path);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file1);

                    break;
                case 10021:
                    //工长
                    textView14.setClickable(false);
                    textView14.setText("工长已签名");
                    showToast("工长签名成功");
                    listFileNames.add("section_signature");
                    String path2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_工长.png";
                    File file2 = new File(path2);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file2);
                    break;
                case 10022:
                    //技术员
                    textView15.setClickable(false);
                    textView15.setText("技术员已签名");
                    showToast("技术员签名成功");
                    listFileNames.add("skill_signature");
                    String path3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_技术员.png";
                    File file3 = new File(path3);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file3);
                    break;
                case 10023:
                    //劳务公司
                    textView16.setClickable(false);
                    textView16.setText("劳务公司已签名");
                    showToast("劳务公司签名成功");
                    listFileNames.add("labour_signature");
                    String path4 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_劳务公司.png";
                    File file4 = new File(path4);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file4);
                    break;
                case 10024:
                    //用户签字
                    textView17.setClickable(false);
                    textView17.setText("用户已签名");
                    showToast("用户签名成功");
                    listFileNames.add("client_signature");
                    String path5 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm_用户.png";
                    File file5 = new File(path5);//签字图片（状态为"通过"才有此数据）
                    listFiles.add(file5);
                    break;
            }

        }

    }
}
