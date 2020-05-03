package com.zhitiekeji.equipmentmanagement.popupwindow;

import android.content.Context;
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
 * description：通知选择弹框
 */
public class NoticeListPopupWindow extends PopupWindow {
    private Context mContext;
    private View view;

    private TextView textView1, textView2, textView3, textView4;

//    private String latitude = "", longitude = "";

    public NoticeListPopupWindow(Context mContext) {
        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_noticelist, null);
        this.mContext = mContext;
        /*this.latitude = latitude;
        this.longitude = longitude;*/
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

    }

    private void initData() {



    }

}
