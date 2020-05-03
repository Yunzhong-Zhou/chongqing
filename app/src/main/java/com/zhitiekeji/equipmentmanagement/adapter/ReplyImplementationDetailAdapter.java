package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.ReplyImplementationDetailModel;

import java.util.List;


/**
 * Created by zyz on 2016/3/7.
 * Email：1125213018@qq.com
 * 批复详情-病害列表
 */
public class ReplyImplementationDetailAdapter extends BaseAdapter {
    private List<ReplyImplementationDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list;
    private Context context;
    public ReplyImplementationDetailAdapter(Context context, List<ReplyImplementationDetailModel.FacilityServiceReportBean.FacilityDiseaseListBean> list) {
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
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.view = (View) convertView.findViewById(R.id.view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getAmount_money()+"元");
        if (!list.get(position).getDescription().equals("")){
            holder.textView3.setText(list.get(position).getDescription());
        }else {
            holder.textView3.setText("暂无描述");
        }
        holder.textView4.setText(list.get(position).getFacility_disease_type().getTitle());
        if (list.get(position).getDegree().equals("1")){
            holder.textView5.setText("轻微");
        }else if (list.get(position).getDegree().equals("2")){
            holder.textView5.setText("一般");
        }else if (list.get(position).getDegree().equals("3")){
            holder.textView5.setText("较重");
        }else if (list.get(position).getDegree().equals("4")){
            holder.textView5.setText("严重");
        }else if (list.get(position).getDegree().equals("5")){
            holder.textView5.setText("紧急");
        }
        holder.textView6.setText(list.get(position).getArea()+"㎡");

        if (position == (list.size()-1)){
            holder.view.setVisibility(View.GONE);
        }else {
            holder.view.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    private class ViewHolder {
        private TextView textView1,textView2,textView3,textView4,textView5,textView6;
        private View view;
    }

}
