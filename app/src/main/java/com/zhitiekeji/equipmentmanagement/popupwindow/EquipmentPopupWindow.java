package com.zhitiekeji.equipmentmanagement.popupwindow;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.EquipmentDetailActivity;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_MapEquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.model.MapDetailModel;

import java.util.List;


/**
 * Created by zyz on 2016/8/26.
 * Email：1125213018@qq.com
 * description：设备弹框
 */
public class EquipmentPopupWindow extends PopupWindow {
    private Context mContext;
    private View view;
    private ImageView imageView;
    private List<MapDetailModel> poplist;

    public EquipmentPopupWindow(Context mContext, List<MapDetailModel> poplist) {
        this.view = LayoutInflater.from(mContext).inflate(R.layout.pop_equipment3, null);
        this.mContext = mContext;
        this.poplist = poplist;
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
        ListView listView = view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("number", poplist.get(position).getNumber());
                intent.setClass(mContext, EquipmentDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        Pop_MapEquipmentAdapter adapter = new Pop_MapEquipmentAdapter(mContext,poplist);
        listView.setAdapter(adapter);

        /*view.findViewById(R.id.pop_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        TextView textView3 = (TextView) view.findViewById(R.id.textView3);
        TextView textView4 = (TextView) view.findViewById(R.id.textView4);
        TextView textView5 = (TextView) view.findViewById(R.id.textView5);
        TextView textView6 = (TextView) view.findViewById(R.id.textView6);
        TextView textView7 = (TextView) view.findViewById(R.id.textView7);
        TextView textView8 = (TextView) view.findViewById(R.id.textView8);
        TextView textView9 = (TextView) view.findViewById(R.id.textView9);
        TextView textView10 = (TextView) view.findViewById(R.id.textView10);
        TextView textView11 = (TextView) view.findViewById(R.id.textView11);
        textView1.setText(model.getWorkshop().getTitle());//车间
        textView2.setText(model.getTitle());//设备名字
        textView3.setText(model.getNumber());//编号
        textView4.setText(model.getWork_area().getTitle() + model.getStation().getTitle());//工区站区
        textView5.setText(model.getArea() + "㎡");//所占面积
        *//*if (model.getLast_small_service_at() != null && !model.getLast_small_service_at().equals("")) {
            String[] strs = model.getLast_small_service_at().toString().split(" ");
            textView6.setText("上次" + strs[0]);//请检修时间
        } else {
            textView6.setText("暂无");
        }
        if (model.getLast_mid_service_at() != null && !model.getLast_mid_service_at().equals("")) {
            String[] strs = model.getLast_mid_service_at().toString().split(" ");
            textView7.setText("上次" + strs[0]);//综合维修时间
        } else {
            textView7.setText("暂无");
        }
        if (model.getLast_big_service_at() != null && !model.getLast_big_service_at().equals("")) {
            String[] strs = model.getLast_big_service_at().toString().split(" ");
            textView8.setText("上次" + strs[0]);//大修时间
        } else {
            textView8.setText("暂无");
        }*//*
        textView9.setText("["+model.getMinor()+"]");
        textView10.setText("["+model.getMid()+"]");
        textView11.setText("["+model.getBig()+"]");
        textView6.setText(model.getMinor_updated_at());
        textView7.setText(model.getMid_updated_at());
        textView8.setText(model.getBig_updated_at());

        imageView = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(mContext)
                .load(URLs.HOST + model.getPic2())
                .transform(new CenterCrop(mContext), new GlideRoundTransform(mContext))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(imageView);*/
    }

    private void initData() {

    }
}
