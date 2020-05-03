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
import com.zhitiekeji.equipmentmanagement.model.MaintenanceRecordModel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：报审记录adapter
 */
public class MaintenanceRecordAdapter1 extends BaseAdapter {
    private Context context;
    private List<MaintenanceRecordModel1> list;
    private int selectIndex = 0;

    public MaintenanceRecordAdapter1(Context context, List<MaintenanceRecordModel1> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_maintenancerecord1, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.recyclerview = (RecyclerView) convertView.findViewById(R.id.recyclerview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getStr());

        //横向滑动数据
        List<Integer> mDatas = new ArrayList<>(Arrays.asList(R.mipmap.itemimg1,
                R.mipmap.itemimg2, R.mipmap.itemimg1));
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerview.setLayoutManager(linearLayoutManager);
        //设置适配器
        RecycleViewImageAdapter mAdapter = new RecycleViewImageAdapter(context, mDatas);
        holder.recyclerview.setAdapter(mAdapter);


        return convertView;
    }

    private static class ViewHolder {

        RecyclerView recyclerview;
        TextView textView1;
    }
}
