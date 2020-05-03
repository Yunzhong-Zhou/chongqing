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
import com.zhitiekeji.equipmentmanagement.model.ReportDiseaseListModel;

import java.util.List;


/**
 * Created by zyz on 2016/3/7.
 * Email：1125213018@qq.com
 */
public class ReportDiseaseListAdapter extends BaseAdapter {
    private List<ReportDiseaseListModel> list;
    private Context context;
    String EquipmentID = "";
    String facility_service_apply_id = "";
    String publish_disease_id = "";

    int e_type = 0;
    boolean isShowNotice = false;

    public ReportDiseaseListAdapter(Context context, List<ReportDiseaseListModel> list,
                                    String EquipmentID,
                                    String facility_service_apply_id,
                                    String publish_disease_id,boolean isShowNotice,int e_type) {
        super();
        this.context = context;
        this.list = list;
        this.EquipmentID = EquipmentID;
        this.facility_service_apply_id = facility_service_apply_id;
        this.publish_disease_id = publish_disease_id;
        this.isShowNotice = isShowNotice;
        this.e_type = e_type;
    }

    @Override
    public int getCount() {
        return list.size() + 1;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reported, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);
            holder.linearLayout2 = (LinearLayout) convertView.findViewById(R.id.linearLayout2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position < list.size()) {
            holder.linearLayout1.setVisibility(View.VISIBLE);
            holder.linearLayout2.setVisibility(View.GONE);
//            holder.textView1.setText(list.get(position).getTitle());//病害标题
            holder.textView2.setText(list.get(position).getAmount_money() + "元");

            /*if (!list.get(position).getDescription().equals("")){
                holder.textView3.setText(list.get(position).getDescription()+"");//病害描述
            }else {
                holder.textView3.setText("暂无描述");//病害描述
            }*/
            holder.textView4.setText(list.get(position).getFacility_disease_type().getTitle());//病害类型

            if (list.get(position).getDegree().equals("1")) {
                holder.textView5.setText("轻微");
            }else if (list.get(position).getDegree().equals("2")) {
                holder.textView5.setText("一般");
            } else if (list.get(position).getDegree().equals("3")) {
                holder.textView5.setText("较重");
            } else if (list.get(position).getDegree().equals("4")) {
                holder.textView5.setText("严重");
            }else if (list.get(position).getDegree().equals("5")) {
                holder.textView5.setText("紧急");
            }
            holder.textView6.setText(list.get(position).getArea() + "㎡");//面积

            /*if (list.get(position).getDegree() == 1) {
                //一般
                holder.textView3.setText(list.get(position).getDescription() + "\t\t一般\t\t" + list.get(position).getArea() + "㎡");
            } else if (list.get(position).getDegree() == 2) {
                //较重
                holder.textView3.setText(list.get(position).getDescription() + "\t\t较重\t\t" + list.get(position).getArea() + "㎡");
            } else if (list.get(position).getDegree() == 3) {
                //严重
                holder.textView3.setText(list.get(position).getDescription() + "\t\t严重\t\t" + list.get(position).getArea() + "㎡");
            }*/


        } else {
            //最后一个
            holder.linearLayout1.setVisibility(View.GONE);
            holder.linearLayout2.setVisibility(View.VISIBLE);
        }
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, AddDiseaseActivity.class);
                intent.putExtra("EquipmentID", EquipmentID);
                intent.putExtra("publish_disease_id", publish_disease_id);
                intent.putExtra("facility_service_apply_id", facility_service_apply_id);
                intent.putExtra("isShowNotice", isShowNotice);
                intent.putExtra("e_type", e_type);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        private TextView textView1, textView2, textView3,textView4,textView5,textView6;
        private LinearLayout linearLayout1, linearLayout2;
    }

}
