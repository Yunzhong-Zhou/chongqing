package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：材料详情adapter
 */
public class StatisticalDetailAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public StatisticalDetailAdapter(Context context, List<String> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_statisticaldetail, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position));
        return convertView;
    }

    private static class ViewHolder {

        TextView textView1;
    }
}
