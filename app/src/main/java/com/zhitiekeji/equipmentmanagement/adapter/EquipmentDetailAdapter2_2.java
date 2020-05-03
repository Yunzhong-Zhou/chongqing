package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.RepairDetailsActivity;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel2;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：设备详情-adapter-综合维修
 */
public class EquipmentDetailAdapter2_2 extends BaseAdapter {
    private Context context;
    private List<EquipmentDetailModel2.MidBean> list;
    private int selectIndex = 0;

    public EquipmentDetailAdapter2_2(Context context, List<EquipmentDetailModel2.MidBean> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectItem(int selectItem) {
        this.selectIndex = selectItem;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_equipmentdetail, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position < list.size()) {
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView2.setVisibility(View.GONE);
            holder.textView1.setText(list.get(position).getYear()+"");
            if (list.get(position).getIsOpen() == 1) {
                holder.linearLayout.setVisibility(View.VISIBLE);
            } else {
                holder.linearLayout.setVisibility(View.GONE);
            }
            //动态添加数据
            holder.linearLayout.removeAllViews();
            for (int i = 0; i < list.get(position).getData().size(); i++) {
                //设置布局
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.item_equipmentdetail_maintain, null, false);
                view.setLayoutParams(lp);
                //实例化子页面的控件
                TextView textView1 = (TextView) view.findViewById(R.id.textView1);
                TextView textView2 = (TextView) view.findViewById(R.id.textView2);
                TextView textView3 = (TextView) view.findViewById(R.id.textView3);
                textView1.setText(list.get(position).getData().get(i).getCreated_at());
                textView2.setText("第"+(list.get(position).getData().size() - i)+"次维修");
                if (list.get(position).getData().get(i).getStatus() == 1) {
                    textView3.setText("上报中");
                } else if (list.get(position).getData().get(i).getStatus() == 2) {
                    textView3.setText("已上报");
                } else if (list.get(position).getData().get(i).getStatus() == 3) {
                    textView3.setText("下达");
                } else if (list.get(position).getData().get(i).getStatus() == 4) {
                    textView3.setText("批复");
                } else if (list.get(position).getData().get(i).getStatus() == 5) {
                    textView3.setText("实施");
                } else if (list.get(position).getData().get(i).getStatus() == 6) {
                    textView3.setText("竣工");
                }else{
                    textView3.setText("申请中");
                }
                final int finalI = i;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*//跳转病害详情
                        Intent intent = new Intent();
                        intent.putExtra("DiseaseDetailActivity", list.get(position).getFacility_disease_list().get(finalI).getId());
                        intent.putExtra("DiseaseDetailActivity_type", 0);
                        intent.setClass(context, DiseaseDetailActivity.class);
                        context.startActivity(intent);*/
                        //跳转维修详情
                        Intent intent = new Intent();
                        intent.putExtra("facility_service_apply_id", list.get(position).getData().get(finalI).getId());
                        intent.putExtra("EquipmentID", list.get(position).getData().get(finalI).getFacility_id());//设备id
                        intent.setClass(context, RepairDetailsActivity.class);
                        context.startActivity(intent);
                    }
                });
                holder.linearLayout.addView(view);
            }

        } else {
            //最后一个
            holder.textView1.setVisibility(View.GONE);
            holder.textView2.setVisibility(View.VISIBLE);
        }

        //点击收缩列表
        final ViewHolder finalHolder = holder;
        final Drawable image1 = context.getResources().getDrawable(R.mipmap.downimg7);
        image1.setBounds(0, 0, image1.getMinimumWidth(), image1.getMinimumHeight());//非常重要，必须设置，否则图片不会显示
        final Drawable image2 = context.getResources().getDrawable(R.mipmap.upimg7);
        image2.setBounds(0, 0, image2.getMinimumWidth(), image2.getMinimumHeight());//非常重要，必须设置，否则图片不会显示
        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(position).getIsOpen() == 0) {//关闭
                    list.get(position).setIsOpen(1);
                    finalHolder.textView1.setCompoundDrawables(null, null, image2, null);
                } else {
                    list.get(position).setIsOpen(0);
                    finalHolder.textView1.setCompoundDrawables(null, null, image1, null);
                }
                notifyDataSetChanged();
            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent();
                intent.putExtra("DiseaseDetailActivity",1);
                intent.setClass(context, DiseaseDetailActivity.class);
                context.startActivity(intent);*/
                /*Intent intent = new Intent();
                intent.setClass(context, CalendarYearDetailActivity.class);
                context.startActivity(intent);*/
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView textView1, textView2;
        LinearLayout linearLayout;
    }
}
