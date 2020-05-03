package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ImplementationPlanDetailActivity;
import com.zhitiekeji.equipmentmanagement.activity.ViewPagerPhotoViewActivity;
import com.zhitiekeji.equipmentmanagement.model.ImplementationPlanModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：批复实施adapter
 */
public class ImplementationPlanAdapter extends BaseAdapter {
    private Context context;
    private List<ImplementationPlanModel> list;
    private int selectIndex = 0;

    public ImplementationPlanAdapter(Context context, List<ImplementationPlanModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_implementationplan, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.textView9 = (TextView) convertView.findViewById(R.id.textView9);
            holder.textView10 = (TextView) convertView.findViewById(R.id.textView10);
            holder.textView11 = (TextView) convertView.findViewById(R.id.textView11);
            holder.textView12 = (TextView) convertView.findViewById(R.id.textView12);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            holder.textView_feiyong = (TextView) convertView.findViewById(R.id.textView_feiyong);
            holder.textView_binghai = (TextView) convertView.findViewById(R.id.textView_binghai);
            holder.imageView_feiyong = (ImageView) convertView.findViewById(R.id.imageView_feiyong);
            holder.imageView_binghai = (ImageView) convertView.findViewById(R.id.imageView_binghai);
            holder.linearLayout_feiyong = (LinearLayout) convertView.findViewById(R.id.linearLayout_feiyong);
            holder.linearLayout_binghai = (LinearLayout) convertView.findViewById(R.id.linearLayout_binghai);

            holder.recyclerview = (RecyclerView) convertView.findViewById(R.id.recyclerview);
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
        holder.textView6.setText("[" + list.get(position).getFacility_service_apply().getBatch_year() + "年第" +
                list.get(position).getFacility_service_apply().getBatch() + "批次]");//概审大
        holder.textView7.setText(list.get(position).getContract_money()+"元");//合同金额
        holder.textView8.setText(list.get(position).getStart_at().split(" ")[0]+"—"+list.get(position).getEnd_at().split(" ")[0]);//开竣工时间
        holder.textView9.setText(list.get(position).getSupervisor_company());//监理单位
        holder.textView10.setText(list.get(position).getConstruction_company());//施工单位
        holder.textView11.setText(list.get(position).getDesign_company());//设计单位
        holder.textView12.setText(list.get(position).getContent());//描述
        Glide.with(context).load(URLs.HOST + list.get(position).getFacility().getPic2()).centerCrop().into(holder.imageView);//加载图片

        //横向滑动数据
        if (list.get(position).getPic_list() != null){
            MyLogger.i(">>>>>>>>>"+list.get(position).getPic_list().toString());
            String str = list.get(position).getPic_list().toString().replaceAll("\\[\"", "");
            str = str.replaceAll("\"]","");
            str = str.replaceAll("\\\\","");
            String[] strings = str.split("\",\"");
            final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
            for (int i = 0; i < strings.length; i++) {
                imageUrlList_1.add(URLs.HOST+strings[i]);
            }
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.recyclerview.setLayoutManager(linearLayoutManager);
            //设置适配器
            MyReportDetaiRecycleViewImageAdapter mAdapter = new MyReportDetaiRecycleViewImageAdapter(context, strings);
            holder.recyclerview.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, context);
                }
            });
        }else {
            //没有图片
        }


        final ViewHolder finalHolder = holder;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context,ImplementationPlanDetailActivity.class);
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
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,
                textView9,textView10,textView11,textView12;

        TextView textView_feiyong,textView_binghai;
        ImageView imageView_feiyong,imageView_binghai;
        LinearLayout linearLayout,linearLayout_feiyong,linearLayout_binghai;
        RecyclerView recyclerview;
    }
}
