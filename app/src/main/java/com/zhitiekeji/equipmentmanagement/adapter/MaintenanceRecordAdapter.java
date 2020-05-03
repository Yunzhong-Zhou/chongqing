package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.MaintenanceRecordModel;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：维修记录adapter
 */
public class MaintenanceRecordAdapter extends BaseAdapter {
    private Context context;
    private List<MaintenanceRecordModel> list;
    private int selectIndex = 0;

    public MaintenanceRecordAdapter(Context context, List<MaintenanceRecordModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_maintenancerecorddetail, null);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);
            holder.linearLayout_1 = (LinearLayout) convertView.findViewById(R.id.linearLayout_1);
            holder.linearLayout_2 = (LinearLayout) convertView.findViewById(R.id.linearLayout_2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0){
            holder.linearLayout1.setVisibility(View.VISIBLE);
        }else {
            holder.linearLayout1.setVisibility(View.GONE);
        }
        if (position==0) {
            holder.textView2.setText("巡");
            holder.linearLayout_1.setVisibility(View.GONE);
            holder.linearLayout_2.setVisibility(View.GONE);
        } else if (position==1) {
            holder.textView2.setText("工");
            holder.linearLayout_1.setVisibility(View.VISIBLE);
            holder.linearLayout_2.setVisibility(View.GONE);
        } else if (position==2) {
            holder.textView2.setText("车");
            holder.linearLayout_1.setVisibility(View.VISIBLE);
            holder.linearLayout_2.setVisibility(View.VISIBLE);
        } else if (position==3) {
            holder.textView2.setText("科");
            holder.linearLayout_1.setVisibility(View.GONE);
            holder.linearLayout_2.setVisibility(View.VISIBLE);
        } else if (position==4) {
            holder.textView2.setText("段");
            holder.linearLayout_1.setVisibility(View.GONE);
            holder.linearLayout_2.setVisibility(View.GONE);
        }
        return convertView;
    }

    private static class ViewHolder {
        LinearLayout linearLayout1,linearLayout_1,linearLayout_2;
        TextView textView1,textView2;
    }
}
