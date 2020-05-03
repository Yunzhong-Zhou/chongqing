package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ReplyPlanDetailActivity;
import com.zhitiekeji.equipmentmanagement.model.ReplyPlanModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：下达-综合维修adapter
 */
public class ReplyPlanAdapter1 extends BaseAdapter {
    private Context context;
    private List<ReplyPlanModel> list;
    private int selectIndex = 0;

    public ReplyPlanAdapter1(Context context, List<ReplyPlanModel> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_replyplan1, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            holder.textView_feiyong = (TextView) convertView.findViewById(R.id.textView_feiyong);
            holder.textView_binghai = (TextView) convertView.findViewById(R.id.textView_binghai);
            holder.imageView_feiyong = (ImageView) convertView.findViewById(R.id.imageView_feiyong);
            holder.imageView_binghai = (ImageView) convertView.findViewById(R.id.imageView_binghai);
            holder.linearLayout_feiyong = (LinearLayout) convertView.findViewById(R.id.linearLayout_feiyong);
            holder.linearLayout_binghai = (LinearLayout) convertView.findViewById(R.id.linearLayout_binghai);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getFacility().getCompany().getTitle());//所属工区
        holder.textView2.setText(list.get(position).getFacility().getTitle());//设备名字
        holder.textView3.setText(list.get(position).getFacility().getNumber());//设备编号
        holder.textView4.setText(list.get(position).getFacility().getWorkshop().getTitle() +
                list.get(position).getFacility().getWork_area().getTitle() +
                list.get(position).getFacility().getStation().getTitle());//所属车辆段
        if (list.get(position).getFacility().getType().equals("1")){//判断是房屋还是构筑物
            holder.textView5.setText(list.get(position).getFacility().getHouse_area()+"㎡");//房屋面积
        }else {
            holder.textView5.setText(list.get(position).getFacility().getStructures_area()+"H㎡");//构筑物面积
        }
        /*holder.textView6.setText("[" + list.get(position).getFacility_service_apply().getBatch_year() + "年第" +
                list.get(position).getFacility_service_apply().getBatch() + "批次]");//概审大*/
        holder.textView6.setText(list.get(position).getPlan_number());
        holder.textView7.setText(list.get(position).getCost_money() + "元");//技物科批复费用
        holder.textView8.setText(list.get(position).getRenovate_content());//工程范围
        Glide.with(context).load(URLs.HOST + list.get(position).getFacility().getPic2()).centerCrop().into(holder.imageView);//加载图片

        final ViewHolder finalHolder = holder;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context,ReplyPlanDetailActivity.class);
                intent.putExtra("EquipmentID", list.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.textView_feiyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalHolder.textView_feiyong.setTextColor(context.getResources().getColor(R.color.blue));
                finalHolder.textView_binghai.setTextColor(context.getResources().getColor(R.color.black2));
                finalHolder.linearLayout_feiyong.setVisibility(View.VISIBLE);
                finalHolder.linearLayout_binghai.setVisibility(View.GONE);
                finalHolder.imageView_feiyong.setVisibility(View.VISIBLE);
                finalHolder.imageView_binghai.setVisibility(View.GONE);
            }
        });
        holder.textView_binghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalHolder.textView_feiyong.setTextColor(context.getResources().getColor(R.color.black2));
                finalHolder.textView_binghai.setTextColor(context.getResources().getColor(R.color.blue));
                finalHolder.linearLayout_feiyong.setVisibility(View.GONE);
                finalHolder.linearLayout_binghai.setVisibility(View.VISIBLE);
                finalHolder.imageView_feiyong.setVisibility(View.GONE);
                finalHolder.imageView_binghai.setVisibility(View.VISIBLE);
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;

        TextView textView_feiyong,textView_binghai;
        ImageView imageView_feiyong,imageView_binghai;
        LinearLayout linearLayout,linearLayout_feiyong,linearLayout_binghai;
    }
}
