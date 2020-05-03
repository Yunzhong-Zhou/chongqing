package com.zhitiekeji.equipmentmanagement.popupwindow;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;


/**
 * Created by zyz on 2016/8/26.
 * Email：1125213018@qq.com
 * description：导航选择弹框
 */
public class NavigationPopupWindow extends PopupWindow {
    private Context mContext;
    private View view;

    private TextView textView1, textView2, textView3, textView4;

    private String latitude = "", longitude = "";

    public NavigationPopupWindow(Context mContext, String latitude, String longitude) {
        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_navigation, null);
        this.mContext = mContext;
        this.latitude = latitude;
        this.longitude = longitude;
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
                    if (y > height1) {
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
                //百度地图
                Intent naviIntent = new Intent("android.intent.action.VIEW",
                        android.net.Uri.parse("baidumap://map/geocoder?location=" + latitude + "," + longitude));
                mContext.startActivity(naviIntent);

            }
        });
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //高德地图
                Intent naviIntent = new Intent("android.intent.action.VIEW",
                        android.net.Uri.parse("androidamap://route?sourceApplication=appName&slat=&slon=&sname=我的位置&dlat="+ latitude +"&dlon="+ longitude+"&dname=目的地&dev=0&t=2"));
                mContext.startActivity(naviIntent);
            }
        });
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //腾讯地图
                Intent naviIntent = new Intent("android.intent.action.VIEW",
                        android.net.Uri.parse("qqmap://map/routeplan?type=drive&from=&fromcoord=&to=目的地&tocoord=" + latitude + "," + longitude + "&policy=0&referer=appName"));
                mContext.startActivity(naviIntent);
            }
        });
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //网页地图
                Intent naviIntent = new Intent("android.intent.action.VIEW",
                        android.net.Uri.parse("http://api.map.baidu.com/direction?origin=latlng:"+latitude+"|name:"+"我的位置"+"&destination=latlng:"+longitude+"|name:"+"目的地"+"&mode=driving&src=目的地"));
                mContext.startActivity(naviIntent);
            }
        });
        //百度地图
        if (isPackageInstalled(mContext, "com.baidu.BaiduMap") == false) {
            textView1.setVisibility(View.GONE);
        }
        //高德地图
        if (isPackageInstalled(mContext, "com.autonavi.minimap") == false) {
            textView2.setVisibility(View.GONE);
        }
        //腾讯地图
        if (isPackageInstalled(mContext, "com.tencent.map") == false) {
            textView3.setVisibility(View.GONE);
        }
    }

    private void initData() {



    }

    public static boolean isPackageInstalled(Context mContext, String packagename) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        } finally {
            return packageInfo == null ? false : true;
        }
    }
}
