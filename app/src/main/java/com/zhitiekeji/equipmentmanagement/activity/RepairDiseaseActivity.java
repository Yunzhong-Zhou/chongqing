package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.PhotoData;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
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
 * Created by fafukeji01 on 2017/6/20.
 * 修复病害
 */

public class RepairDiseaseActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    String facility_disease_id = "";
    EditText editText;
    String description="";
    TextView next;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairdisease);
    }

    @Override
    protected void initView() {
        gridView01 = findViewByID_My(R.id.gridView01);
        photoOperate = new PhotoOperate(this);
        mSize = new ImageSize(220, 220);
        gridView01.setOnItemClickListener(RepairDiseaseActivity.this);

        editText = findViewByID_My(R.id.editText);
        next = findViewByID_My(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                description = editText.getText().toString().trim();
                if (!description.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RepairDiseaseActivity.this);
                    builder.setMessage("检查填写无误，确认修复");
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
                            params.put("facility_disease_id", facility_disease_id);//设备病害id
                            params.put("employee_id", localUserInfo.getUserId());//员工id
                            params.put("description", description);//描述
                            params.put("token", localUserInfo.getToken());//token
                            RequestRepairDisease(filenames, files, params);//设备列表
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
                    showToast("请输入描述");
                }
            }
        });
    }
    private void RequestRepairDisease(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.MANAGEMENT_RepairDISEASE, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
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
                MyLogger.i(">>>>>>>修复病害" + response);
                myToast("病害修复成功");
                finish();
            }
        }, this);

    }
    @Override
    protected void initData() {
        facility_disease_id = getIntent().getStringExtra("facility_disease_id");
        mDatas = new ArrayList();
        for (int i = 0; i < 4; i++) {
            mDatas.add(new ArrayList());
        }
        adapter1 = new MyGridViewAdapter(mDatas.get(0));
        gridView01.setAdapter(adapter1);

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("修复病害");
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
                convertView = LayoutInflater.from(RepairDiseaseActivity.this).inflate(R.layout.item_imagedelete, null);
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
            ImageView image,delete;
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
                        File file = new File(FileUtil.getPath(RepairDiseaseActivity.this, uri1));
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
