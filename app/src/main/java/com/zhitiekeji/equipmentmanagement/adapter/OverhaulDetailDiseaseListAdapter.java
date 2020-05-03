package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.OverhaulDetailDiseaseListModel;

import java.util.List;


/**
 * Created by zyz on 2016/3/7.
 * Email：1125213018@qq.com
 */
public class OverhaulDetailDiseaseListAdapter extends BaseAdapter {
    private List<OverhaulDetailDiseaseListModel> list;
    private Context context;
    public OverhaulDetailDiseaseListAdapter(Context context, List<OverhaulDetailDiseaseListModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reportedplandetail, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.view = (View) convertView.findViewById(R.id.view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getO_task());
        holder.textView2.setText(list.get(position).getO_fee_total()+"元");
        holder.textView3.setText(list.get(position).getLevel());

        if (position == (list.size()-1)){
            holder.view.setVisibility(View.GONE);
        }else {
            holder.view.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    private class ViewHolder {
        private TextView textView1,textView2,textView3;
        private View view;
    }

}
