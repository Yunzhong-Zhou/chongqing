package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.PleaseOverhaulModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：请检修adapter
 */
public class PleaseOverhaulAdapter extends BaseAdapter {
    private Context context;
    private List<PleaseOverhaulModel> list;
    private int selectIndex = 0;

    public PleaseOverhaulAdapter(Context context, List<PleaseOverhaulModel> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pleaseoverhaul, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.textView9 = (TextView) convertView.findViewById(R.id.textView9);
            holder.textView11 = (TextView) convertView.findViewById(R.id.textView11);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            /*holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            holder.textView_feiyong = (TextView) convertView.findViewById(R.id.textView_feiyong);
            holder.textView_binghai = (TextView) convertView.findViewById(R.id.textView_binghai);
            holder.imageView_feiyong = (ImageView) convertView.findViewById(R.id.imageView_feiyong);
            holder.imageView_binghai = (ImageView) convertView.findViewById(R.id.imageView_binghai);
            holder.linearLayout_feiyong = (LinearLayout) convertView.findViewById(R.id.linearLayout_feiyong);
            holder.linearLayout_binghai = (LinearLayout) convertView.findViewById(R.id.linearLayout_binghai);*/
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
        if (list.get(position).getFacility().getType() == 1){//判断是房屋还是构筑物
            holder.textView5.setText(list.get(position).getFacility().getHouse_area()+"㎡");//房屋面积
        }else {
            holder.textView5.setText(list.get(position).getFacility().getStructures_area()+"H㎡");//构筑物面积
        }
        holder.textView6.setText("总计:"+list.get(position).getAmount()+"元");//总计费用

        if (list.get(position).getManhour() != null){
            holder.textView7.setText(list.get(position).getManhour().getMoney()+"元");//工时消耗
        }else {
            holder.textView7.setText("0.0元");//工时消耗
        }
        if (list.get(position).getMileage() != null){
            holder.textView8.setText(list.get(position).getMileage().getMoney()+"元");//汽车消耗
        }else {
            holder.textView8.setText("0.0元");//工时消耗
        }
        double allmoney = 0;
        if (list.get(position).getMaterial() != null && list.get(position).getMaterial().size() != 0){
            for (int i = 0; i < list.get(position).getMaterial().size(); i++) {
                allmoney = allmoney + Double.valueOf(list.get(position).getMaterial().get(i).getMoney());
            }
        }
        holder.textView9.setText(allmoney+"元");//材料消耗
        holder.textView11.setText(list.get(position).getCreated_at());//创建时间

        Glide.with(context).load(URLs.HOST + list.get(position).getFacility().getPic2()).centerCrop().into(holder.imageView);//加载图片


        /*final ViewHolder finalHolder = holder;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context,ReportedPlanDetailActivity.class);
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
        });*/

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView11;

        /*TextView textView_feiyong,textView_binghai;
        ImageView imageView_feiyong,imageView_binghai;
        LinearLayout linearLayout,linearLayout_feiyong,linearLayout_binghai;*/
    }
}
