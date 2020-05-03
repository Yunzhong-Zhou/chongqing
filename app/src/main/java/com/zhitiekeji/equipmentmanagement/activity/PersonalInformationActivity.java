package com.zhitiekeji.equipmentmanagement.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.PersonalInformationModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.FileUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import id.zelory.compressor.Compressor;

import static com.zhitiekeji.equipmentmanagement.net.URLs.HOST;
import static com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz.REQUEST_CODE_CAPTURE_CAMEIA;
import static com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz.REQUEST_CODE_PICK_IMAGE;

/**
 * Created by fafukeji01 on 2017/6/1.
 * 个人资料
 */

public class PersonalInformationActivity extends BaseActivity{
    //选择图片及上传
    ArrayList<String> listFileNames;
    ArrayList<File> listFiles;
    private ImageView imageView;
    private TextView textView1,textView2,textView3,textView4,textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinformation);
    }

    @Override
    protected void initView() {
        imageView = findViewByID_My(R.id.imageView);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView5 = findViewByID_My(R.id.textView5);
    }

    @Override
    protected void initData() {
        this.showProgress(true, "正在获取数据...");
        String string = "?token=" + localUserInfo.getToken();
        RequestUserDetail(string);//用户详情
    }
    private void RequestUserDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.USER_DETAIL+string, new OkHttpClientManager.ResultCallback<PersonalInformationModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
//                LoginActivity.this.hideProgress();
//                myToast("密码错误，请重新输入");
                hideProgress();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(PersonalInformationActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(PersonalInformationModel response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>用户详情" + response);
                textView1.setText(response.getName());
                textView2.setText(response.getMobile());
                textView3.setText(response.getDuty());
                if (response.getWorkarea()!= null){
                    textView4.setText(response.getWorkarea().getTitle());
                }
                textView5.setText(response.getIdcard());
                if (!response.getHead().equals(""))
                    Glide.with(PersonalInformationActivity.this).load(HOST+response.getHead()).centerCrop().into(imageView);//加载图片
                else
                    imageView.setImageResource(R.mipmap.touxiang);
                /*localUserInfo.setUserName(response.getM_name());
                localUserInfo.setUserId(response.getId());
                localUserInfo.setUserJob(response.getM_job());
                localUserInfo.setUserImage(response.getAvatarImage());*/
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                //头像
                ChooseImages_zyz.showPhotoDialog(PersonalInformationActivity.this);
                break;
            case R.id.linearLayout1:
                //电话号码
//                CommonUtil.gotoActivity(PersonalInformationActivity.this, ChangePhoneNumActivity.class,false);
                break;
            case R.id.linearLayout2:
                //修改密码
                CommonUtil.gotoActivity(PersonalInformationActivity.this, ChangePasswordActivity.class,false);
                break;
        }
    }
    private void RequestChangeProfile(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.ChangeProfile, fileKeys, files, params, new OkHttpClientManager.ResultCallback<PersonalInformationModel>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("登录验证过时");
                    CommonUtil.gotoActivityWithFinishOtherAll(PersonalInformationActivity.this, LoginActivity.class, true);
                } else {
                    showToast(info);
                }
            }

            @Override
            public void onResponse(PersonalInformationModel response) {
                MyLogger.i(">>>>>>>>>修改信息" + response);
                showToast("修改成功");
                localUserInfo.setUserImage(response.getHead());
                Glide.with(PersonalInformationActivity.this).load(HOST + localUserInfo.getUserImage()).centerCrop().into(imageView);//加载图片
                hideProgress();
            }
        }, this);

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("个人资料");
        }
    }

    /**
     * *****************************************选择图片********************************************
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = null;
            String imagePath = null;
            switch (requestCode) {
                case REQUEST_CODE_CAPTURE_CAMEIA:
                    //相机
                    uri = Uri.parse("");
                    uri = Uri.fromFile(new File(ChooseImages_zyz.imagepath));
                    imagePath = uri.getPath();
                    break;
                case REQUEST_CODE_PICK_IMAGE:
                    //相册
                    uri = data.getData();
                    //处理得到的url
                    ContentResolver cr = this.getContentResolver();
                    Cursor cursor = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        cursor = cr.query(uri, null, null, null, null, null);
                    }
                    if (cursor != null) {
                        cursor.moveToFirst();
                        imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    } else {
                        imagePath = uri.getPath();
                    }
                    break;
            }
            if (uri != null) {
                MyLogger.i(">>>>>>>>>>获取到的图片路径1：" + imagePath);
                //图片过大解决方法
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 32;
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath,options);

                imageView.setImageBitmap(bitmap);
                listFileNames = new ArrayList<>();
                listFileNames.add("headImg");

                Uri uri1 = Uri.parse("");
                uri1 = Uri.fromFile(new File(imagePath));
                File file1 = new File(FileUtil.getPath(this, uri1));
                listFiles = new ArrayList<>();
                File newFile = null;
                try {
                    newFile = new Compressor(this).compressToFile(file1);
                    listFiles.add(newFile);
                    MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                    String[] filenames = new String[]{};
                    File[] files = new File[]{};
                    for (int i = 0; i < listFiles.size(); i++) {
                        filenames = listFileNames.toArray(new String[i]);
                        files = listFiles.toArray(new File[i]);
                    }
                    this.showProgress(true, "正在上传数据");
                    params.put("token", localUserInfo.getToken());
                    RequestChangeProfile(filenames, files, params);//修改
                } catch (IOException e) {
                    e.printStackTrace();
                    showToast("图片压缩失败");
                }

            }
        }

    }
}
