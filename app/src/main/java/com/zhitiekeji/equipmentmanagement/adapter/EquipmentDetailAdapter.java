package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.CalendarYearDetailActivity;
import com.zhitiekeji.equipmentmanagement.model.EquipmentDetailModel;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：设备详情adapter
 */
public class EquipmentDetailAdapter extends BaseAdapter {
    private Context context;
    private List<EquipmentDetailModel> list;
    private int selectIndex = 0;

    public EquipmentDetailAdapter(Context context, List<EquipmentDetailModel> list) {
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
    public void setSelectItem(int selectItem) {
        this.selectIndex = selectItem;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_equipmentdetail, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getStr());
        if (selectIndex == position) {
            holder.linearLayout.setVisibility(View.VISIBLE);
        } else {
            holder.linearLayout.setVisibility(View.GONE);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent();
                intent.putExtra("DiseaseDetailActivity",1);
                intent.setClass(context, DiseaseDetailActivity.class);
                context.startActivity(intent);*/
                Intent intent = new Intent();
                intent.setClass(context, CalendarYearDetailActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView textView1;
        LinearLayout linearLayout;
    }
}
