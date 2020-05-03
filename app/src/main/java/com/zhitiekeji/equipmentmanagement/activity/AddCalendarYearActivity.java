package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.HashMap;

import id.zelory.compressor.Compressor;

/**
 * Created by fafukeji01 on 2017/6/14.
 * 竣工发布
 */

public class AddCalendarYearActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    String facility_service_implement_id = "";
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

    EditText editText1, editText2;
    TextView textView1;
    String actual_money = "", content = "", completion_report = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcalendaryear);
    }

    @Override
    protected void initView() {
        gridView01 = findViewByID_My(R.id.gridView01);
        photoOperate = new PhotoOperate(this);
        mSize = new ImageSize(220, 220);
        gridView01.setOnItemClickListener(AddCalendarYearActivity.this);

        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        textView1 = findViewByID_My(R.id.textView1);
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList();
        for (int i = 0; i < 4; i++) {
            mDatas.add(new ArrayList());
        }
        adapter1 = new MyGridViewAdapter(mDatas.get(0));
        gridView01.setAdapter(adapter1);

        facility_service_implement_id = getIntent().getStringExtra("facility_service_issue_id");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                //附件
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                if (Build.VERSION.SDK_INT >= 24) {
                    // 适配android7.0 ，不能直接访问原路径
                    // 需要对intent 授权
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    // 重新构造Uri：content://
                    File imagePath = new File(AddCalendarYearActivity.this.getFilesDir(), "docs");
                    if (!imagePath.exists()) {
                        imagePath.mkdirs();
                    }
                    File newFile = new File(imagePath, "wenjian.pdf");
                    Uri contentUri = FileProvider.getUriForFile(AddCalendarYearActivity.this,
                            "com.zhitiekeji.equipmentmanagement.fileprovider", newFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
                }
                intent.setType("file/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //显示文件管理器列表
                try {
                    startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"), 10010);

                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(AddCalendarYearActivity.this, "请安装文件管理器", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.next:
                //提交
                if (match()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddCalendarYearActivity.this);
                    builder.setMessage("检查填写无误，确认提交");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            showProgress(true, "正在上传数据，请稍后...");
                            String[] filenames = new String[]{};
                            File[] files = new File[]{};
                            if (!fileName.equals("")) {
                                listFiles.add(file);
                                listFileNames.add(fileName);
                            }/*else {
                                showToast("请上传竣工报告");
                            }*/
                            for (int i = 0; i < listFiles.size(); i++) {
                                filenames = listFileNames.toArray(new String[i]);
                                files = listFiles.toArray(new File[i]);
                            }

                            params.put("token", localUserInfo.getToken());
                            params.put("facility_service_implement_id", facility_service_implement_id);//设备维修实施id
                            params.put("employee_id", localUserInfo.getUserId());//员工id
                            params.put("actual_money", actual_money);//合同金额
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
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_AddCalendarYear, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddCalendarYearActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>竣工发布" + response);
                myToast("提交成功");
                finish();
            }
        }, this);
    }

    private boolean match() {
        actual_money = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(actual_money)) {
            showToast("请输入实际金额");
            return false;
        }
        content = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入竣工记录");
            return false;
        }
        return true;
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("竣工发布");
        }
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
                convertView = LayoutInflater.from(AddCalendarYearActivity.this).inflate(R.layout.item_imagedelete, null);
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
                completion_report = uri.getPath();
                if (!completion_report.equals("")) {

                    textView1.setText("竣工报告（已选择附件：" + completion_report + "）");
                    fileName = "completion_report";
//                    file = new File(completion_report);//计划附件（实施计划）
                    file = FileUtil.getFileByUri(AddCalendarYearActivity.this,uri);
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
                        File file = new File(FileUtil.getPath(AddCalendarYearActivity.this, uri1));
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
