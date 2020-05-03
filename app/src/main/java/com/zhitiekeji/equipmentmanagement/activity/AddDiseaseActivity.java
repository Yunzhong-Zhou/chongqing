package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.DiseaseTypeModel;
import com.zhitiekeji.equipmentmanagement.model.PhotoData;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.FileUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.photochooser.ImagePagerActivity;
import com.zhitiekeji.equipmentmanagement.view.photochooser.PhotoOperate;
import com.zhitiekeji.equipmentmanagement.view.photochooser.PhotoPickActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.zelory.compressor.Compressor;


/**
 * Created by fafukeji01 on 2017/1/18.
 * 添加病害
 */

public class AddDiseaseActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    String EquipmentID = "";
    String facility_service_apply_id = "";
    String publish_disease_id = "";
    boolean isShowNotice = false;
    int e_type = 0;

    private TextView next;

    //选择图片及上传
    GridView gridView01;
    ArrayList<ArrayList<PhotoData>> mDatas = new ArrayList(4);
    BaseAdapter adapter1;
    public static final int PHOTO_MAX_COUNT = 3;
    private ImageSize mSize;
    public static final int RESULT_REQUEST_IMAGE = 100;
    public static final int RESULT_REQUEST_FOLLOW = 1002;
    public static final int RESULT_REQUEST_PICK_PHOTO = 1003;
    public static final int RESULT_REQUEST_PHOTO = 1005;
    private PhotoOperate photoOperate;
    private Uri fileUri;
    ArrayList<String> listFileNames = new ArrayList<>();
    ArrayList<File> listFiles = new ArrayList<>();

    LinearLayout linearLayout,linearLayout1;
    TextView textView;
    TextView textView1, textView2;
    EditText editText1, editText2, editText3;
    //病害种类
    List<DiseaseTypeModel> list1 = new ArrayList<DiseaseTypeModel>();
    String facility_disease_type_id = "";
    //病害程度
    int degree = 1;
    String area = "", title = "", description = "";
    String skill_type = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddisease);
    }

    @Override
    protected void initView() {
        linearLayout = findViewByID_My(R.id.linearLayout);
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        textView = findViewByID_My(R.id.textView);

        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        editText3 = findViewByID_My(R.id.editText3);
        next = findViewByID_My(R.id.next);

        gridView01 = findViewByID_My(R.id.gridView01);
        photoOperate = new PhotoOperate(this);
        mSize = new ImageSize(220, 220);
        gridView01.setOnItemClickListener(AddDiseaseActivity.this);
    }

    @Override
    protected void initData() {
        EquipmentID = getIntent().getStringExtra("EquipmentID");
        facility_service_apply_id = getIntent().getStringExtra("facility_service_apply_id");
        publish_disease_id = getIntent().getStringExtra("publish_disease_id");
        isShowNotice = getIntent().getBooleanExtra("isShowNotice", false);

        e_type = getIntent().getIntExtra("e_type",0);
        if (e_type == 1){
            //房屋 - 隐藏技术状态等级、显示种类
            linearLayout.setVisibility(View.GONE);
            linearLayout1.setVisibility(View.VISIBLE);
        }else if (e_type == 2){
            //构筑物 - 显示技术状态等级、隐藏种类
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.GONE);
        }

        mDatas = new ArrayList();
        for (int i = 0; i < 4; i++) {
            mDatas.add(new ArrayList());
        }
        adapter1 = new MyGridViewAdapter(mDatas.get(0));
        gridView01.setAdapter(adapter1);

        //获取病害种类
        String string = "?token=" + localUserInfo.getToken();
        RequestDiseaseType(string);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearLayout:
                //技术状态等级
                showPopupWindow(textView);
                break;
            case R.id.linearLayout1:
                //种类
                showPopupWindow1(textView1);
                break;
            case R.id.linearLayout2:
                //危害程度
                showPopupWindow2(textView2);
                break;
            case R.id.next:
                //确认增加
                if (match()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddDiseaseActivity.this);
                    builder.setMessage("检查填写无误，确认增加");
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
                            params.put("facility_id", EquipmentID);//设备id
                            params.put("employee_id", localUserInfo.getUserId());//userid
                            params.put("facility_service_apply_id", facility_service_apply_id);//设备维修申请id
                            params.put("publish_disease_id", publish_disease_id);//会员发布病害id

                            params.put("facility_disease_type_id", facility_disease_type_id);//设备病害类型id
                            params.put("title", title);//标题
                            params.put("degree", degree + "");//程度（1.一般 2.较重 3.严重）
                            params.put("area", area);//面积（单位：㎡）
                            params.put("description", description);//描述
                            params.put("token", localUserInfo.getToken());//token

                            params.put("skill_type", skill_type);//技术危害等级
                            RequestUpLoad(filenames, files, params);
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
        }
    }

    //病害种类
    private void RequestDiseaseType(String string) {
        OkHttpClientManager.getAsyn(URLs.Disease_type + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddDiseaseActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>病害种类" + response);
                JSONObject jObj;
                list1 = new ArrayList<DiseaseTypeModel>();
                try {
                    jObj = new JSONObject(response);
//                    String resCode = jObj.getString("resCode");
//                    JSONObject jObj1 = new JSONObject(response1);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), DiseaseTypeModel.class);
                    if (list1.size() > 0) {
                        facility_disease_type_id = list1.get(0).getId();
                        textView1.setText(list1.get(0).getTitle());
                    }


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    AlertDialog alertDialog3;
    List<String> items_ids = new ArrayList<>();
    private void RequestUpLoad(final String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.AddDisease, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddDiseaseActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>发布病害" + response);
                myToast("提交病害成功");
                if (isShowNotice){
                    JSONObject jObj;
                    try {
                        jObj = new JSONObject(response);
                        String flag = jObj.getString("data");
                        if (flag.equals("true")) {
                            // 多选提示框
                            final String[] items = {"副工长", "工长", "副科长", "科长", "副段长", "段长"};
                            // 创建一个AlertDialog建造者
                            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AddDiseaseActivity.this);
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
                                    RequestNotice(params);
                                }
                            });
                            alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    // TODO 业务逻辑代码
                                    // 关闭提示框
                                    alertDialog3.dismiss();
                                    finish();
                                }
                            });
                            alertDialog3 = alertDialogBuilder.create();
                            alertDialog3.show();
                        } else {
                            finish();
                        }


                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    finish();
                }


            }
        }, this);
    }
    private void RequestNotice(Map<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.Disease_NoticeList, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddDiseaseActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>短信通知相关负责人" + response);
                myToast("发出通知成功");
                finish();
            }
        });

    }
    private boolean match() {
        if (TextUtils.isEmpty(facility_disease_type_id)) {
            showToast("请选择种类");
            return false;
        }
        area = editText1.getText().toString().trim();
        /*if (TextUtils.isEmpty(area)) {
            showToast("请输入面积");
            return false;
        }*/
        title = editText2.getText().toString().trim();
        /*if (TextUtils.isEmpty(title)) {
            showToast("请输入标题");
            return false;
        }*/
        description = editText3.getText().toString().trim();
        /*if (TextUtils.isEmpty(description)) {
            showToast("请输入描述");
            return false;
        }*/
        /*if (listFileNames.size() != 3){
            myToast("请上传三张图片");
            return false;
        }*/
        return true;
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("发布病害");
        }
    }

    private void showPopupWindow(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
        final List<String> list = new ArrayList<String>();
        list.add("一级");
        list.add("二级");
        list.add("三级");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
                skill_type = (i+1)+"";
                textView.setText(list.get(i));
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
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.yuanjiao_0_heisetouming));
        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack2));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }
    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i).getTitle());
        }
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();

                facility_disease_type_id = list1.get(i).getId();
                textView1.setText(list1.get(i).getTitle());
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
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.yuanjiao_0_heisetouming));
        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack2));
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

        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
        final List<String> list = new ArrayList<String>();
        list.add("轻微");
        list.add("一般");
        list.add("较重");
        list.add("严重");
        list.add("紧急");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();

                degree = i + 1;
                textView2.setText(list.get(i));
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
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.yuanjiao_0_heisetouming));
        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack2));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
    }

    /**
     * *****************************************选择图片********************************************
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onItemClickExtract(position, mDatas.get(0));
    }

    public class MyGridViewAdapter extends BaseAdapter {
        private ArrayList<PhotoData> photoDatas;

        public MyGridViewAdapter(ArrayList<PhotoData> photoDatas) {
            this.photoDatas = photoDatas;
        }

        public int getCount() {
            return photoDatas.size() + 1;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        ArrayList<ViewHolder> holderList = new ArrayList<ViewHolder>();

        // create a new ImageView for each item referenced by the Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(AddDiseaseActivity.this).inflate(R.layout.item_imagedelete, null);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                holder.delete = (ImageView) convertView.findViewById(R.id.delete);
                /*holder.image = (ImageView) LayoutInflater.from(AddQuestionActivity.this).inflate(
                        R.layout.image_make_maopao, parent, false);*/
                holderList.add(holder);
                holder.image.setTag(holder);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (position == getCount() - 1) {
                if (getCount() == (PHOTO_MAX_COUNT + 1)) {
                    holder.image.setVisibility(View.GONE);
                    holder.delete.setVisibility(View.GONE);
                } else {
                    holder.image.setVisibility(View.VISIBLE);
                    holder.delete.setVisibility(View.GONE);
//                    holder.image.setImageResource(R.drawable.addimage);
                    holder.image.setImageResource(R.mipmap.tupian);
                    holder.uri = "";
                }
            } else {
                holder.image.setVisibility(View.VISIBLE);
                holder.delete.setVisibility(View.VISIBLE);
                final PhotoData photoData = photoDatas.get(position);
                Uri data = photoData.uri;
                holder.uri = data.toString();
                ImageLoader.getInstance().loadImage(data.toString(), mSize,
                        new SimpleImageLoadingListener() {
                            @Override
                            public void onLoadingComplete(String imageUri,
                                                          View view, Bitmap loadedImage) {
                                for (ViewHolder item : holderList) {
                                    if (item.uri.equals(imageUri)) {
                                        item.image.setImageBitmap(loadedImage);
                                    }
                                }
                            }
                        });
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatas.get(0).remove(position);
//                        photoDatas.remove(position);
                        listFileNames.remove(position);
                        listFiles.remove(position);
                        MyLogger.i(">>>>>>>>减少图片后>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                        notifyDataSetChanged();
                    }
                });
            }

//            return holder.image;
            return convertView;
        }

        class ViewHolder {
            ImageView image, delete;
            String uri = "";
        }
    }

    private void onItemClickExtract(int position, ArrayList<PhotoData> mData) {
        if (position == mData.size()) {
            int count = PHOTO_MAX_COUNT - mData.size();
            if (count <= 0) {
                return;
            }
            Intent intent = new Intent(this,
                    PhotoPickActivity.class);
            intent.putExtra(PhotoPickActivity.EXTRA_MAX, count);
            startActivityForResult(intent, RESULT_REQUEST_PICK_PHOTO);

        } else {
            Intent intent = new Intent(this,
                    ImagePagerActivity.class);
            ArrayList<String> arrayUri = new ArrayList<String>();
            for (PhotoData item : mData) {
                arrayUri.add(item.uri.toString());
            }
            intent.putExtra("mArrayUri", arrayUri);
            intent.putExtra("mPagerPosition", position);
            intent.putExtra("needEdit", true);
            startActivityForResult(intent, RESULT_REQUEST_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            onActivityResultExtract(requestCode, resultCode, data, mDatas.get(0), adapter1);
        }
    }


    private void onActivityResultExtract(int requestCode, int resultCode, Intent data, ArrayList<PhotoData> mData, BaseAdapter adapter) {
        if (requestCode == RESULT_REQUEST_PICK_PHOTO) {//点击加图片
            if (resultCode == Activity.RESULT_OK) {
                try {
                    ArrayList<PhotoPickActivity.ImageInfo> pickPhots = (ArrayList<PhotoPickActivity.ImageInfo>) data
                            .getSerializableExtra("data");
                    for (PhotoPickActivity.ImageInfo item : pickPhots) {
                        Uri uri = Uri.parse(item.path);
                        File outputFile = photoOperate.scal(uri);
                        mData.add(new PhotoData(outputFile));

                        MyLogger.i("?????????" + uri.toString() + ">>>>>>" + pickPhots.get(0).path.toString());
                        //错误形式：/file:/storage/emulated/0/Download/com.peoit.twopointcf/images/0607173907987.png
                        //正确形式：/storage/emulated/0/Download/com.peoit.twopointcf/images/0607173907987.png

//                        String newStr = item.path.toString().substring(item.path.toString().indexOf(":"), item.path.length());
                        String spStr[] = item.path.toString().split(":");
                        //增加
                        listFileNames.add("pic_list");
                        Uri uri1 = Uri.parse("");
                        uri1 = Uri.fromFile(new File(spStr[1]));
                        File file = new File(FileUtil.getPath(AddDiseaseActivity.this, uri1));
                        File newFile = null;
                        try {
                            newFile = new Compressor(this).compressToFile(file);
                            listFiles.add(newFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                            showToast("图片压缩失败");
                        }
                    }
                    MyLogger.i(">>>>>>>>增加图片后>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
            }
        } else if (requestCode == RESULT_REQUEST_PHOTO) {//无用
            if (resultCode == Activity.RESULT_OK) {
                try {
                    File outputFile = photoOperate.scal(fileUri);
                    mData.add(mData.size(), new PhotoData(
                            outputFile));
                    adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == RESULT_REQUEST_IMAGE) {//点击图片
            if (resultCode == Activity.RESULT_OK) {
                ArrayList<String> delUris = data
                        .getStringArrayListExtra("mDelUrls");
                for (String item : delUris) {
                    for (int i = 0; i < mData.size(); ++i) {
                        if (mData.get(i).uri.toString().equals(item)) {
                            mData.remove(i);
                            listFileNames.remove(i);
                            listFiles.remove(i);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
                MyLogger.i(">>>>>>>>减少图片后>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
            }
        } else if (requestCode == RESULT_REQUEST_FOLLOW) {//无用
            if (resultCode == Activity.RESULT_OK) {
                String name = data.getStringExtra("name");
                //mEnterLayout.insertText(name);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
