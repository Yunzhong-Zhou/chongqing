package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.StaffManagementDetailModel;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：员工管理详情adapter
 */
public class StaffManagementDetailAdapter extends BaseAdapter {
    private Context context;
    private List<StaffManagementDetailModel> list;
    private int selectIndex = 0;

    public StaffManagementDetailAdapter(Context context, List<StaffManagementDetailModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_staffmanagementdetail, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.linearLayout = convertView.findViewById(R.id.linearLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        if (position < list.size()) {
//            holder.linearLayout.setVisibility(View.VISIBLE);
//            holder.textView4.setVisibility(View.GONE);
            holder.textView1.setText(list.get(position).getFacility_name());
            holder.textView2.setText(list.get(position).getCreated_at());
            if (list.get(position).getStatus() == 1){
                holder.textView3.setText("无病害");
                holder.textView3.setTextColor(context.getResources().getColor(R.color.green));
            }else {
                holder.textView3.setText("有病害");
                holder.textView3.setTextColor(context.getResources().getColor(R.color.red));
            }
//        }else {
//            //最后一个
//            holder.linearLayout.setVisibility(View.GONE);
//            holder.textView4.setVisibility(View.VISIBLE);
//        }


        return convertView;
    }

    private static class ViewHolder {
        TextView textView1,textView2,textView3,textView4;
        LinearLayout linearLayout;
    }
}
