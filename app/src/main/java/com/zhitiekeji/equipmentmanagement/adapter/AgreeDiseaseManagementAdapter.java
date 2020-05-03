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
import com.zhitiekeji.equipmentmanagement.activity.AddDiseaseActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportedModel;

import java.util.List;


/**
 * Created by zyz on 2016/3/7.
 * Email：1125213018@qq.com
 */
public class AgreeDiseaseManagementAdapter extends BaseAdapter {
    private List<ReportedModel> list;
    private Context context;
    public AgreeDiseaseManagementAdapter(Context context, List<ReportedModel> list) {
        super();
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size()+1;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reported, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);
            holder.linearLayout2 = (LinearLayout) convertView.findViewById(R.id.linearLayout2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position < list.size()){
            holder.linearLayout1.setVisibility(View.VISIBLE);
            holder.linearLayout2.setVisibility(View.GONE);
            holder.textView1.setText(list.get(position).getStr());
        }else {
            //最后一个
            holder.linearLayout1.setVisibility(View.GONE);
            holder.linearLayout2.setVisibility(View.VISIBLE);
        }
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddDiseaseActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    private class ViewHolder {
        private TextView textView1;
        private LinearLayout linearLayout1,linearLayout2;
    }

}
