package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.SchoolBagModel;

import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：党员小书包adapter
 */
public class SchoolBagAdapter extends BaseAdapter {
    private Context context;
    private List<SchoolBagModel> list;
    private int selectIndex = 0;

    public SchoolBagAdapter(Context context, List<SchoolBagModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_schoolbag, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getPublish_time());
        holder.textView3.setText("发布人：" + list.get(position).getUser_name());
        holder.textView4.setText("阅读量："+list.get(position).getRead_count());
        return convertView;
    }

    private static class ViewHolder {
        TextView textView1, textView2, textView3, textView4;
    }
}
