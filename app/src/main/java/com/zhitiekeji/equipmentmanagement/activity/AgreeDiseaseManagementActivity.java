package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bigkoo.pickerview.TimePickerView;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.ReportDiseaseListAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportDiseaseListModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.FileUtil;
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
import java.util.List;


/**
 * Created by fafukeji01 on 2017/6/20.
 * 同意病害管理
 */

public class AgreeDiseaseManagementActivity extends BaseActivity {
    static String EquipmentID = "";
    static String facility_service_apply_id = "";

    private LinearLayout linearLayout1, linearLayout2, linearLayout_1, linearLayout_2;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView1_1, textView2_1;
    private ImageView imageView;
    static EditText editText1;
    private TimePickerView pvTime1, pvTime2;//时间选择器
    private SwipeMenuListView listView;
    /* List<ReportedModel> list = new ArrayList<ReportedModel>();
     AgreeDiseaseManagementAdapter adapter;*/
    static List<ReportDiseaseListModel> list = new ArrayList<ReportDiseaseListModel>();
    ReportDiseaseListAdapter adapter;

    static double allMoney = 0.00;
    static String start_at = "";
    static String end_at = "";
    static String accessory = "";
    static File accessory_file = null;

    int e_type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreediseasemanagement);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress(true, "正在获取数据...");
        //获取病害列表
        String string = "?facility_service_apply_id=" + facility_service_apply_id//设备维修申请id
                + "&token=" + localUserInfo.getToken();
        RequestDiseaseList(string);
    }

    @Override
    protected void initView() {
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout_1 = findViewByID_My(R.id.linearLayout_1);
        linearLayout_2 = findViewByID_My(R.id.linearLayout_2);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView5 = findViewByID_My(R.id.textView5);
        textView6 = findViewByID_My(R.id.textView6);
        initTimePicker1();
        textView7 = findViewByID_My(R.id.textView7);
        textView8 = findViewByID_My(R.id.textView8);
        editText1 = findViewByID_My(R.id.editText1);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        imageView = findViewByID_My(R.id.imageView);

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
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        /*showProgress(true, "正在删除病害...");
                        String string = "?id=" + list.get(position).getId()
                                + "&token=" + localUserInfo.getToken();
                        RequestDetele(string);*/
                        break;
                }
            }
        });
    }

    //删除病害
    private void RequestDetele(String string) {
        OkHttpClientManager.getAsyn(URLs.DeleteDisease + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>删除病害" + response);
                String string = "?facility_service_apply_id=" + facility_service_apply_id//设备维修申请id
                        + "&token=" + localUserInfo.getToken();
                RequestDiseaseList(string);
            }
        });
    }

    @Override
    protected void initData() {
        accessory = "";//清空选择的文件路径
        start_at = "";//清空开工时间

        EquipmentID = getIntent().getStringExtra("EquipmentID");
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");

        //设备type
        String string = "?id=" + EquipmentID//设备id
                + "&token=" + localUserInfo.getToken();
        RequestEquipmentDetail(string);
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
                MyLogger.i(">>>>>>>>>设备详情" + response);
                JSONObject jObj;
                try {
                    jObj = new JSONObject(response);
                    JSONObject jObj1 = jObj.getJSONObject("data");
                    e_type = jObj1.getInt("type");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
            case R.id.linearLayout1:
                //审核结果
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                linearLayout_1.setVisibility(View.VISIBLE);
                linearLayout_2.setVisibility(View.GONE);
                break;
            case R.id.linearLayout2:
                //施工记录
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                linearLayout_1.setVisibility(View.GONE);
                linearLayout_2.setVisibility(View.VISIBLE);
                break;
            case R.id.textView1:
                //请检修
                textView1.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                textView2.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView3.setCompoundDrawables(drawable_weixuan, null, null, null);
                break;
            case R.id.textView2:
                //综合维修
                textView1.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView2.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                textView3.setCompoundDrawables(drawable_weixuan, null, null, null);
                break;
            case R.id.textView3:
                //大修
                textView1.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView2.setCompoundDrawables(drawable_weixuan, null, null, null);
                textView3.setCompoundDrawables(drawable_xuanzhong, null, null, null);
                break;
            case R.id.textView5:
                //提交

                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                CommonUtil.gotoActivityWithData(AgreeDiseaseManagementActivity.this, SignatureActivity.class, bundle, false);
//                startActivityForResult(new Intent(AgreeDiseaseManagementActivity.this, SignatureActivity.class), 1);
                break;
            case R.id.textView6:
                //开工时间
                pvTime1.show(textView6);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            case R.id.textView7:
                //竣工时间
                if (!start_at.equals(""))
                    pvTime2.show(textView7);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                else
                    showToast("请先选择开工时间");
                break;
            case R.id.textView8:
                //添加附件
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                if (Build.VERSION.SDK_INT >= 24) {
                    // 适配android7.0 ，不能直接访问原路径
                    // 需要对intent 授权
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    // 重新构造Uri：content://
                    File imagePath = new File(AgreeDiseaseManagementActivity.this.getFilesDir(), "docs");
                    if (!imagePath.exists()) {
                        imagePath.mkdirs();
                    }
                    File newFile = new File(imagePath, "wenjian.pdf");
                    Uri contentUri = FileProvider.getUriForFile(AgreeDiseaseManagementActivity.this,
                            "com.zhitiekeji.equipmentmanagement.fileprovider", newFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
                }
                intent.setType("file/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //显示文件管理器列表
                try {
                    startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"), 10010);

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(AgreeDiseaseManagementActivity.this, "请安装文件管理器", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //获取病害列表
    private void RequestDiseaseList(String string) {
        OkHttpClientManager.getAsyn(URLs.Disease_List + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AgreeDiseaseManagementActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
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
                    adapter = new ReportDiseaseListAdapter(AgreeDiseaseManagementActivity.this, list, EquipmentID, facility_service_apply_id, "", true, e_type);
                    listView.setAdapter(adapter);

                    allMoney = 0.00;
                    for (int i = 0; i < list.size(); i++) {
                        allMoney = allMoney + Double.valueOf(list.get(i).getAmount_money());
                    }
                    textView4.setText("¥" + allMoney + "元");
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("病害审核");
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 10010) {
                Uri uri = data.getData();
                MyLogger.i(">>>>>>>>>选取的文件路径：" + uri.toString());
                accessory_file = FileUtil.getFileByUri(AgreeDiseaseManagementActivity.this,uri);
                accessory = uri.getPath();
                if (!accessory.equals("")) {
                    textView8.setText("已选择附件：" + accessory);
                    imageView.setImageResource(R.mipmap.dajiawen_butongyi1);
                } else {
                    imageView.setImageResource(R.mipmap.equipment2);
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!accessory.equals("")) {
                            accessory = "";
                            textView8.setText("点击添加附件");
                            imageView.setImageResource(R.mipmap.equipment2);
                        }
                    }
                });
            }
        }
    }
}
