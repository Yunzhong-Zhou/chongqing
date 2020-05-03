package com.zhitiekeji.equipmentmanagement.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel1;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.Constant;
import com.zhitiekeji.equipmentmanagement.utils.FileUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.zxing.CaptureActivity;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import id.zelory.compressor.Compressor;

import static com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz.REQUEST_CODE_CAPTURE_CAMEIA;
import static com.zhitiekeji.equipmentmanagement.utils.ChooseImages_zyz.REQUEST_CODE_PICK_IMAGE;


/**
 * Created by fafukeji01 on 2017/1/18.
 * 添加设备
 */

public class AddEquipmentActivity extends BaseActivity {
    //选择图片及上传
    ArrayList<String> listFileNames = new ArrayList<>();
    ArrayList<File> listFiles = new ArrayList<>();

    EditText editText1, editText2;
    String string1, string2;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    ImageView delete1, delete2, delete3, delete4, delete5;

    private int iv_tag = -1;

    String longitude = "";//经度
    String latitude = "";//纬度
    String addr = "";//地址
    String id = "";

    /**
     * 定位
     */
    // 定位相关
    LocationClient mLocClient = null;
    MyLocationListenner myListener = new MyLocationListenner();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addequipment);
        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        initLocation();
    }

    @Override
    protected void initView() {

        editText1 = findViewByID_My(R.id.editText1);
        editText2 = findViewByID_My(R.id.editText2);
        imageView1 = findViewByID_My(R.id.imageView1);
        imageView2 = findViewByID_My(R.id.imageView2);
        imageView3 = findViewByID_My(R.id.imageView3);
        imageView4 = findViewByID_My(R.id.imageView4);
        imageView5 = findViewByID_My(R.id.imageView5);

        delete1 = findViewByID_My(R.id.delete1);
        delete2 = findViewByID_My(R.id.delete2);
        delete3 = findViewByID_My(R.id.delete3);
        delete4 = findViewByID_My(R.id.delete4);
        delete5 = findViewByID_My(R.id.delete5);

    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                if (match()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddEquipmentActivity.this);
                    builder.setMessage("检查填写无误，确认发布");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            AddEquipmentActivity.this.showProgress(true, "正在上传数据，请稍后...");
                            String[] filenames = new String[]{};
                            File[] files = new File[]{};
                            for (int i = 0; i < listFiles.size(); i++) {
                                filenames = listFileNames.toArray(new String[i]);
                                files = listFiles.toArray(new File[i]);
                            }
                            params.put("id", id);//有id值：修改，无id值：增加
                            params.put("employee_id", localUserInfo.getUserId());
                            params.put("number", string2);//台帐号
                            params.put("title", string1);//名称
                            params.put("longitude", longitude);
                            params.put("latitude", latitude);
                            params.put("addr", addr);
                            params.put("token", localUserInfo.getToken());//token
                            RequestAddEquipment(filenames, files, params);//添加设备
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
            case R.id.imageView1:
                iv_tag = 1;
                mLocClient.start();
                ChooseImages_zyz.showPhotoDialog(AddEquipmentActivity.this);

                break;
            case R.id.imageView2:
                iv_tag = 2;
                ChooseImages_zyz.showPhotoDialog(AddEquipmentActivity.this);

                break;
            case R.id.imageView3:
                iv_tag = 3;
                ChooseImages_zyz.showPhotoDialog(AddEquipmentActivity.this);

                break;
            case R.id.imageView4:
                iv_tag = 4;
                ChooseImages_zyz.showPhotoDialog(AddEquipmentActivity.this);

                break;
            case R.id.imageView5:
                iv_tag = 5;
                ChooseImages_zyz.showPhotoDialog(AddEquipmentActivity.this);

                break;

            case R.id.delete1:
                for (int i = 0; i < listFileNames.size(); i++) {
                    if (listFileNames.get(i).equals("pic1")) {
                        //删除
                        listFileNames.remove(i);
                        listFiles.remove(i);
                    }
                }
                MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                delete1.setVisibility(View.GONE);
                imageView1.setClickable(true);
                imageView1.setImageResource(R.mipmap.tupian);
                break;
            case R.id.delete2:
                for (int i = 0; i < listFileNames.size(); i++) {
                    if (listFileNames.get(i).equals("pic2")) {
                        //删除
                        listFileNames.remove(i);
                        listFiles.remove(i);
                    }
                }
                MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                delete2.setVisibility(View.GONE);
                imageView2.setClickable(true);
                imageView2.setImageResource(R.mipmap.tupian);
                break;
            case R.id.delete3:
                for (int i = 0; i < listFileNames.size(); i++) {
                    if (listFileNames.get(i).equals("pic3")) {
                        //删除
                        listFileNames.remove(i);
                        listFiles.remove(i);
                    }
                }
                MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                delete3.setVisibility(View.GONE);
                imageView3.setClickable(true);
                imageView3.setImageResource(R.mipmap.tupian);
                break;
            case R.id.delete4:
                for (int i = 0; i < listFileNames.size(); i++) {
                    if (listFileNames.get(i).equals("pic4")) {
                        //删除
                        listFileNames.remove(i);
                        listFiles.remove(i);
                    }
                }
                MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                delete4.setVisibility(View.GONE);
                imageView4.setClickable(true);
                imageView4.setImageResource(R.mipmap.tupian);
                break;
            case R.id.delete5:
                for (int i = 0; i < listFileNames.size(); i++) {
                    if (listFileNames.get(i).equals("pic5")) {
                        //删除
                        listFileNames.remove(i);
                        listFiles.remove(i);
                    }
                }
                MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                delete5.setVisibility(View.GONE);
                imageView5.setClickable(true);
                imageView5.setImageResource(R.mipmap.tupian);
                break;
        }
    }

    private void RequestAddEquipment(String[] fileKeys, File[] files, HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.EQUIPMENT_ADD, fileKeys, files, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddEquipmentActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>添加设备" + response);
                myToast("提交成功");
                finish();
            }
        }, this);

    }

    private boolean match() {
        string1 = editText1.getText().toString().trim();
        if (TextUtils.isEmpty(string1)) {
            showToast("请输入设备名称");
            return false;
        }
        string2 = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(string2)) {
            showToast("请输入台账号");
            return false;
        }
        if (listFileNames.size() < 3) {
            showToast("请认真添加图片");
            return false;
        }
        if (addr.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddEquipmentActivity.this);
            builder.setMessage("请打开手机定位，按确认键重新获取位置信息");
            builder.setTitle("提示");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    myListener = new MyLocationListenner();
                    mLocClient = new LocationClient(AddEquipmentActivity.this);
                    mLocClient.registerLocationListener(myListener);
                    initLocation();
                    mLocClient.start();
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    myListener = new MyLocationListenner();
                    mLocClient = new LocationClient(AddEquipmentActivity.this);
                    mLocClient.registerLocationListener(myListener);
                    initLocation();
                    mLocClient.start();
//                    addr = "暂未获取到经纬度";
                    dialog.dismiss();
                }
            });
            builder.create().show();
            return false;
        }
        return true;
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("发布设备");
            titleView.setRightBtn(R.mipmap.equipment3, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //扫一扫
                    startQrCode();
                }
            });
        }
    }

    // 开始扫码
    private void startQrCode() {
        if (ContextCompat.checkSelfPermission(AddEquipmentActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(AddEquipmentActivity.this, new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
            return;
        }
        // 二维码扫码
        Intent intent = new Intent(AddEquipmentActivity.this, CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    //设备详情
    private void RequestEquipmentDetail(String string) {
        OkHttpClientManager.getAsyn(URLs.EQUIPMENT_DETAIL + string, new OkHttpClientManager.ResultCallback<EquipmentDetailModel1>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")) {
                    localUserInfo.setUserId("");
                    showToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(AddEquipmentActivity.this, LoginActivity.class, true);
                } else {
                    if (!info.equals("")) {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(EquipmentDetailModel1 response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>设备详情" + response);
                if (response != null) {
                    id = response.getId();
                    editText1.setText(response.getTitle());//设备标题
                    editText2.setText(response.getNumber());//设备编号
                    editText2.setFocusable(false);
                } else {
                    showToast("获取设备详情失败");
                }

            }
        });

    }

    /**
     * *****************************************选择图片********************************************
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
                if (scanResult != null && !scanResult.equals("")) {
                    //查询设备详情
                    String string = "?number=" + scanResult//台账号
                            + "&type=" + "2"//1、只能查询通过审核的设备2、能查询到没有通过审核的设备
                            + "&token=" + localUserInfo.getToken();
                    RequestEquipmentDetail(string);
                }
            }


        }
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
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);

                Uri uri1 = Uri.parse("");
                uri1 = Uri.fromFile(new File(imagePath));
                File file1 = new File(FileUtil.getPath(this, uri1));
//                listFiles = new ArrayList<>();
                File newFile = null;
                try {
                    newFile = new Compressor(this).compressToFile(file1);
                    if (iv_tag == 1) {

                        listFileNames.add("pic1");
                        listFiles.add(newFile);

                        imageView1.setImageBitmap(bitmap);
                        //获取经纬度
                        mLocClient.start();
                        delete1.setVisibility(View.VISIBLE);
                        imageView1.setClickable(false);

                    } else if (iv_tag == 2) {

                        listFileNames.add("pic2");
                        listFiles.add(newFile);

                        imageView2.setImageBitmap(bitmap);
                        delete2.setVisibility(View.VISIBLE);
                        imageView2.setClickable(false);

                    } else if (iv_tag == 3) {
                        listFileNames.add("pic3");
                        listFiles.add(newFile);

                        imageView3.setImageBitmap(bitmap);
                        delete3.setVisibility(View.VISIBLE);
                        imageView3.setClickable(false);
                    } else if (iv_tag == 4) {
                        listFileNames.add("pic4");
                        listFiles.add(newFile);

                        imageView4.setImageBitmap(bitmap);
                        delete4.setVisibility(View.VISIBLE);
                        imageView4.setClickable(false);
                    }
                    else if (iv_tag == 5) {
                        listFileNames.add("pic5");
                        listFiles.add(newFile);

                        imageView5.setImageBitmap(bitmap);
                        delete5.setVisibility(View.VISIBLE);
                        imageView5.setClickable(false);
                    }

                    MyLogger.i(">>>>>选择图片结果>>>>>>>>>" + listFileNames.toString() + ">>>>>>" + listFiles.toString());
                    /*String[] filenames = new String[]{};
                    File[] files = new File[]{};
                    for (int i = 0; i < listFiles.size(); i++) {
                        filenames = listFileNames.toArray(new String[i]);
                        files = listFiles.toArray(new File[i]);
                    }*/

                } catch (IOException e) {
                    e.printStackTrace();
                    showToast("图片压缩失败");
                }
            }

        }
    }

    /**
     * ********************************************定位**********************************************
     */
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(60 * 1000);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        option.setPriority(LocationClientOption.GpsFirst); //设置gps优先
        mLocClient.setLocOption(option);
//        mLocClient.start();
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());//纬度
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());//经度
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            sb.append("\npoilist size = : ");
            sb.append(list.size());
            for (Poi p : list) {
                sb.append("\npoi= : ");
                sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
            }
//            Log.e("BaiduLocationApiDem", sb.toString());
            MyLogger.i(">>>>>>>>>>>>详细信息" + sb.toString());
//            editText6.setText(location.getAddrStr()+"");
            longitude = location.getLongitude() + "";
            latitude = location.getLatitude() + "";
            addr = location.getAddrStr() + "";
            mLocClient.stop();
        }

        public void onReceivePoi(BDLocation poiLocation) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        super.onDestroy();
    }
}
