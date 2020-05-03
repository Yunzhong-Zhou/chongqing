package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.PhotoData;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.FileUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.photochooser.ImagePagerActivity;
import com.zhitiekeji.equipmentmanagement.view.photochooser.PhotoOperate;
import com.zhitiekeji.equipmentmanagement.view.photochooser.PhotoPickActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import id.zelory.compressor.Compressor;

/**
 * Created by fafukeji01 on 2017/6/14.
 * 实施发布
 */

public class AddImplementationPlanActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    String facility_service_reply_id = "";
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
    String fileName = "";
    File file = null;

    EditText editText1, editText2, editText3, editText4, editText5;
    TextView textView1, textView2, textView3, next;
    private TimePickerView pvTime1, pvTime2;//时间选择器
    String start_at = "";
    String end_at = "";
    String completion_plan = "";

    String design_company = "", construction_company = "", supervisor_company = "", contract_money = "", content = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addimplementationplan);
    }

    @Override
    protected void initView() {
        gridView01 = findViewByID_My(R.id.gridView01);
        photoOperate = new PhotoOperate(this);
        mSize = new ImageSize(220, 220);
        gridView01.setOnItemClickListener(AddImplementationPlanActivity.this);

        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        editText3 = findViewByID_My(R.id.editText3);
        editText4 = findViewByID_My(R.id.editText4);
        editText5 = findViewByID_My(R.id.editText5);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        next = findViewByID_My(R.id.next);
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList();
        for (int i = 0; i < 4; i++) {
            mDatas.add(new ArrayList());
        }
        adapter1 = new MyGridViewAdapter(mDatas.get(0));
        gridView01.setAdapter(adapter1);

        facility_service_reply_id = getIntent().getStringExtra("facility_service_reply_id");
        initTimePicker1();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                //开工时间
                pvTime1.show(textView1);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            case R.id.textView2:
                //竣工时间
                if (!start_at.equals(""))
                    pvTime2.show(textView2);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                else
                    showToast("请先选择开工时间");
                break;
            case R.id.textView3:
                //附件
                completion_plan = "";
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                if (Build.VERSION.SDK_INT >= 24) {
                    // 适配android7.0 ，不能直接访问原路径
                    // 需要对intent 授权
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    // 重新构造Uri：content://
                    File imagePath = new File(AddImplementationPlanActivity.this.getFilesDir(), "docs");
                    if (!imagePath.exists()) {
                        imagePath.mkdirs();
                    }
                    File newFile = new File(imagePath, "wenjian.pdf");
                    Uri contentUri = FileProvider.getUriForFile(AddImplementationPlanActivity.this,
                            "com.zhitiekeji.equipmentmanagement.fileprovider", newFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
                }
                intent.setType("file/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //显示文件管理器列表
                try {
                    startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"), 10010);

                } catch (android.content.ActivityNotFoundException ex) {
                    myToast("请安装文件管理器");
                }
                break;
            case R.id.next:
                //提交
                if (match()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddImplementationPlanActivity.this);
                    builder.setMessage("检查填写无误，确认提交");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            showProgress(true, "正在上传数据，请稍后...");
                            String[] filenames = new String[]{};
                            File[] files = new File[]{};
                            if (!fileName.equals("")){
                                listFiles.add(file);
                                listFileNames.add(fileName);
                            }/*else {
                                showToast("请上传施工方案");
                            }*/

                            for (int i = 0; i < listFiles.size(); i++) {
                                filenames = listFileNames.toArray(new String[i]);
                                files = listFiles.toArray(new File[i]);
                            }
                            params.put("token", localUserInfo.getToken());
                            params.put("facility_service_reply_id", facility_service_reply_id);//设备维修批复id
                            params.put("employee_id", localUserInfo.getUserId());//员工id
                            params.put("start_at", start_at);//开工时间
                            params.put("end_at", end_at);//竣工时间
                            params.put("design_company", design_company);//设计单位
                            params.put("construction_company", construction_company);//施工单位
                            params.put("supervisor_company", supervisor_company);//监理单位
                            params.put("contract_money", contract_money);//合同金额
                            params.put("content", content);//实施内容
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

    private void RequestUpLoad(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_AddImplementationPlan, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddImplementationPlanActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>实施发布" + response);
                myToast("提交成功");
                finish();
            }
        }, this);
    }

    private boolean match() {
        if (TextUtils.isEmpty(start_at)) {
            showToast("请选择开工时间");
            return false;
        }
        if (TextUtils.isEmpty(end_at)) {
            showToast("请选择竣工时间");
            return false;
        }
        design_company = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(design_company)) {
            showToast("请输入设计单位");
            return false;
        }
        construction_company = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(construction_company)) {
            showToast("请输入施工单位");
            return false;
        }
        supervisor_company = editText3.getText().toString().trim();
        if (TextUtils.isEmpty(supervisor_company)) {
            showToast("请输入监理单位");
            return false;
        }
        contract_money = editText4.getText().toString().trim();
        if (TextUtils.isEmpty(contract_money)) {
            showToast("请输入合同金额");
            return false;
        }
        content = editText5.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入实施内容");
            return false;
        }
        return true;
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("实施发布");
        }
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
                convertView = LayoutInflater.from(AddImplementationPlanActivity.this).inflate(R.layout.item_imagedelete, null);
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
            if (requestCode == 10010) {
                Uri uri = data.getData();
                MyLogger.i(">>>>>>>>>选取的文件路径：" + uri.getPath());
                completion_plan = uri.getPath();
                if (!completion_plan.equals("")) {
                    textView3.setText("竣工方案（已选择附件：" + completion_plan + "）");
                    fileName = "completion_plan";
//                    file = new File(completion_plan);//计划附件（实施计划）
                    file = FileUtil.getFileByUri(AddImplementationPlanActivity.this,uri);
                }
            } else
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
                        File file = new File(FileUtil.getPath(AddImplementationPlanActivity.this, uri1));
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
