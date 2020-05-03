package com.zhitiekeji.equipmentmanagement.popupwindow;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ReportDiseaseActivity;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.HashMap;
import java.util.List;


/**
 * Created by zyz on 2016/8/26.
 * Email：1125213018@qq.com
 * description：确认巡检
 */
public class ConfirmInspectionPopupWindow extends PopupWindow {
    private Context mContext;
    private View view;
    String EquipmentID = "";

    private TextView textView1,textView2;

    private ProgressDialog pd;
    int type = 1;
    /**
     * 定位
     */
    // 定位相关
    LocationClient mLocClient = null;
    MyLocationListenner myListener = new MyLocationListenner();
    String longitude="",latitude="";

    public ConfirmInspectionPopupWindow(Context mContext,String EquipmentID,String longitude,String latitude) {
        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_confirminspection, null);
        this.mContext = mContext;

        this.EquipmentID = EquipmentID;
        this.longitude = longitude;
        this.latitude = latitude;

        initView(view);
        initData();

        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = view.findViewById(R.id.pop_layout).getTop();
                int height1 = view.findViewById(R.id.pop_layout).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                    if (y > height1){
                        dismiss();
                    }
                }

                return true;
            }
        });
        /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
        ColorDrawable dw = new ColorDrawable(mContext.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
//        this.setBackgroundDrawable(new BitmapDrawable());//无色

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_pop_anim);
    }

    private void initView(View view) {
        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //未发现病害
                showProgress(true,"正在计算距离，请稍后...");
                initLocation();
                mLocClient.start();
                type = 1;

            }
        });
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发现病害
                showProgress(true,"正在计算距离，请稍后...");
                initLocation();
                mLocClient.start();
                type = 2;
               /* HashMap<String, String> params = new HashMap<>();
                params.put("facility_id",EquipmentID);
                params.put("employee_id",LocalUserInfo.getInstance(mContext).getUserId());
                params.put("status","2");
                params.put("token",LocalUserInfo.getInstance(mContext).getToken());
                RequestCheck(params);*/
            }
        });
    }
    public void RequestCheck(HashMap<String, String> params) {
        OkHttpClientManager.postAsyn(URLs.EQUIPMENT_CHECK ,params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    /*Toast  toast = Toast.makeText(mContext, info, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage(info);
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>设备详情-巡检-是否发现病害" + response);
                /*Toast  toast = Toast.makeText(mContext, "巡检成功！", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("巡检成功！");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

    }

    private void initData() {
        // 定位初始化
        mLocClient = new LocationClient(mContext);
        mLocClient.registerLocationListener(myListener);

    }

    public void showProgress(boolean flag, String message) {
        if (pd == null) {
            pd = new ProgressDialog(mContext);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(flag);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage(message);
            pd.show();
        } else {
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(flag);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage(message);
            pd.show();
        }
    }
    public void hideProgress() {
        if (pd == null){
            return;
        }
        if (pd.isShowing()) {
            pd.dismiss();
        }
    }
    //根据两个经纬度计算之间的距离 （单位： 米）
    public static double getDistance(double longitude1, double latitude1,
                                     double longitude2, double latitude2) {
        double Lat1 = rad(latitude1);
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;
        double b = rad(longitude1) - rad(longitude2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(Lat1) * Math.cos(Lat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;//地球半径
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
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

            mLocClient.stop();
            //定位完毕
            hideProgress();
            //确认巡检 - 检测是否离设备50米
            if (getDistance(Double.valueOf(location.getLongitude() + ""), Double.valueOf(location.getLatitude() + ""), Double.valueOf(longitude), Double.valueOf(latitude)) <= 50) {
                if (type == 1){
                    //未发现病害
                    HashMap<String, String> params = new HashMap<>();
                    params.put("facility_id", EquipmentID);
                    params.put("employee_id", LocalUserInfo.getInstance(mContext).getUserId());
                    params.put("status", "1");
                    params.put("token", LocalUserInfo.getInstance(mContext).getToken());
                    RequestCheck(params);
                    dismiss();
                }else {
                    //已发现病害
                    Intent intent = new Intent();
                    intent.putExtra("EquipmentID", EquipmentID);
                    intent.putExtra("publish_disease_id", "");
                    intent.putExtra("faxianbinghai", "1");
                    intent.setClass(mContext, ReportDiseaseActivity.class);
                    mContext.startActivity(intent);
                    dismiss();
                }
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("您需要距离设备30米内才能巡检");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        }
        public void onReceivePoi(BDLocation poiLocation) {

        }
    }
}
