package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ViewPagerPhotoViewActivity;
import com.zhitiekeji.equipmentmanagement.model.RepairResultsModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.ArrayList;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：维修记录adapter
 */
public class MaintenanceRecordAdapter2 extends BaseAdapter {
    private Context context;
    private RepairResultsModel model;
    private int selectIndex = 0;

    public MaintenanceRecordAdapter2(Context context, RepairResultsModel model) {
        super();
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return model;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_maintenancerecord2, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.recyclerview = (RecyclerView) convertView.findViewById(R.id.recyclerview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(model.getFlag());
        holder.textView2.setText(model.getEmployee().getName());//名字
//        holder.textView4.setText(model.getCreated_at());
        holder.textView5.setText("竣工时间："+model.getCreated_at());
        holder.textView6.setText("施工描述："+model.getContent());
        if (model.getPic_list() != null){
            MyLogger.i(">>>>>>>>>"+model.getPic_list().toString());
            String str = model.getPic_list().toString().replaceAll("\\[\"", "");
            str = str.replaceAll("\"]","");
            str = str.replaceAll("\\\\","");
            String[] strings = str.split("\",\"");
            final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
            for (int i = 0; i < strings.length; i++) {
                imageUrlList_1.add(URLs.HOST+strings[i]);
            }
            //横向滑动数据
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
        }


        return convertView;
    }

    private static class ViewHolder {

        RecyclerView recyclerview;
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
    }
}
