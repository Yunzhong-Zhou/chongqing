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
import com.zhitiekeji.equipmentmanagement.activity.DiseaseDetailActivity;
import com.zhitiekeji.equipmentmanagement.activity.ReportedPlanDetailActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportedPlanModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：上报计划adapter（大修）
 */
public class ReportedPlanAdapter extends BaseAdapter {
    private Context context;
    private List<ReportedPlanModel> list;
    private int selectIndex = 0;

    public ReportedPlanAdapter(Context context, List<ReportedPlanModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reportedplan, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.textView9 = (TextView) convertView.findViewById(R.id.textView9);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            holder.textView_feiyong = (TextView) convertView.findViewById(R.id.textView_feiyong);
            holder.textView_binghai = (TextView) convertView.findViewById(R.id.textView_binghai);
            holder.imageView_feiyong = (ImageView) convertView.findViewById(R.id.imageView_feiyong);
            holder.imageView_binghai = (ImageView) convertView.findViewById(R.id.imageView_binghai);
            holder.linearLayout_feiyong = (LinearLayout) convertView.findViewById(R.id.linearLayout_feiyong);
            holder.linearLayout_binghai = (LinearLayout) convertView.findViewById(R.id.linearLayout_binghai);

            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);
            holder.linearLayout2 = (LinearLayout) convertView.findViewById(R.id.linearLayout2);

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
        if (list.get(position).getFacility_service_apply() != null){
            holder.textView6.setText("[" + list.get(position).getFacility_service_apply().getBatch_year() + "年第" +
                    list.get(position).getFacility_service_apply().getBatch() + "批次]");//概审大
        }

//        holder.textView6.setText(list.get(position).getFacility_service_apply().);
        holder.textView7.setText(list.get(position).getEvaluate() + "元");//上报费用
        holder.textView8.setText(list.get(position).getMoney() + "元");//评估费用
        if (list.get(position).getFacility_service_report() !=null){
            holder.textView9.setText("共" + list.get(position).getFacility_service_report().getFacility_disease_list().size() + "条");//病害条数
        }
        Glide.with(context).load(URLs.HOST + list.get(position).getFacility().getPic2()).centerCrop().into(holder.imageView);//加载图片
        //添加布局
        holder.linearLayout1.removeAllViews();
        if (list.get(position).getFacility_service_report() != null){
            for (int i = 0; i < list.get(position).getFacility_service_report().getFacility_disease_list().size(); i++) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.item_reportedplan_disease, null, false);
                view.setLayoutParams(lp);
                //实例化子页面的控件
                TextView textView_1 = (TextView) view.findViewById(R.id.textView_1);
                TextView textView_2 = (TextView) view.findViewById(R.id.textView_2);
                TextView textView_3 = (TextView) view.findViewById(R.id.textView_3);
                TextView textView_4 = (TextView) view.findViewById(R.id.textView_4);
                TextView textView_5 = (TextView) view.findViewById(R.id.textView_5);
                textView_1.setText(list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getTitle());
                textView_2.setText(list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
                if (list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getDegree().equals("1")) {
                    textView_3.setText("轻微");
                } else if (list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getDegree().equals("2")) {
                    textView_3.setText("一般");
                } else if (list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getDegree().equals("3")) {
                    textView_3.setText("较重");
                } else if (list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getDegree().equals("4")) {
                    textView_3.setText("严重");
                } else if (list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getDegree().equals("5")) {
                    textView_3.setText("紧急");
                }
                textView_4.setText(list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getArea() + "㎡");
                textView_5.setText(list.get(position).getFacility_service_report().getFacility_disease_list().get(i).getAmount_money() + "元");
                final int finalI = i;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyLogger.i(">>>>>>>>" + (list.get(position).getFacility_service_report().getFacility_disease_list().get(finalI).getId()));
                        Intent intent = new Intent();
                        intent.putExtra("DiseaseDetailActivity", list.get(position).getFacility_service_report().getFacility_disease_list().get(finalI).getId());
                        intent.putExtra("DiseaseDetailActivity_type",1);
                        intent.setClass(context, DiseaseDetailActivity.class);
                        context.startActivity(intent);
                    }
                });
                holder.linearLayout1.addView(view);
            }
        }


        final ViewHolder finalHolder = holder;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("EquipmentID", list.get(position).getId());
                intent.setClass(context, ReportedPlanDetailActivity.class);
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
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9;

        TextView textView_feiyong, textView_binghai;
        ImageView imageView_feiyong, imageView_binghai;
        LinearLayout linearLayout, linearLayout_feiyong, linearLayout_binghai, linearLayout1, linearLayout2;
    }
}
