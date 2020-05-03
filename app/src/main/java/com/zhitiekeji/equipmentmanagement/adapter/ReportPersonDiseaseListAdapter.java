package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ViewPagerPhotoViewActivity;
import com.zhitiekeji.equipmentmanagement.model.ReportPersonDiseaseListModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：上报员-病害列表adapter
 */
public class ReportPersonDiseaseListAdapter extends BaseAdapter {
    private Context context;
    private List<ReportPersonDiseaseListModel> list;
    private int selectIndex = 0;

    public ReportPersonDiseaseListAdapter(Context context, List<ReportPersonDiseaseListModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reportpersondiseaselist, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.imageView1 = (ImageView) convertView.findViewById(R.id.imageView1);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.imageView2);
            holder.imageView3 = (ImageView) convertView.findViewById(R.id.imageView3);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getDescription());
        if (list.get(position).getStatus() == 1){
            holder.textView2.setVisibility(View.INVISIBLE);
            holder.textView3.setText("待处理");
            holder.textView3.setBackgroundResource(R.drawable.yuanjiao_2_huise);

            holder.textView2.setText(list.get(position).getCreated_at());
        }else {
            holder.textView2.setVisibility(View.VISIBLE);
            holder.textView3.setText("已处理");
            holder.textView3.setBackgroundResource(R.drawable.yuanjiao_2_lvse);

            holder.textView2.setText(list.get(position).getDeleted_at()+"");
        }

        if (list.get(position).getPic_list() != null){
            String str = list.get(position).getPic_list().toString().replaceAll("\\[\"", "");
            str = str.replaceAll("\"]","");
            str = str.replaceAll("\\\\","");
            String[] strings = str.split("\",\"");
            holder.linearLayout.setVisibility(View.VISIBLE);
            if (strings.length == 1){
                Glide.with(context).load(URLs.HOST+strings[0]).centerCrop().into(holder.imageView1);//加载图片
            }else if (strings.length == 2){
                Glide.with(context).load(URLs.HOST+strings[0]).centerCrop().into(holder.imageView1);//加载图片
                Glide.with(context).load(URLs.HOST+strings[1]).centerCrop().into(holder.imageView2);//加载图片
            }else if (strings.length == 3){
                Glide.with(context).load(URLs.HOST+strings[0]).centerCrop().into(holder.imageView1);//加载图片
                Glide.with(context).load(URLs.HOST+strings[1]).centerCrop().into(holder.imageView2);//加载图片
                Glide.with(context).load(URLs.HOST+strings[2]).centerCrop().into(holder.imageView3);//加载图片
            }else {
                holder.linearLayout.setVisibility(View.GONE);
            }
            final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
            for (int i = 0; i < strings.length; i++) {
                imageUrlList_1.add(URLs.HOST+strings[i]);
            }
            holder.imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, 0, context);
                }
            });
            holder.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, 1, context);
                }
            });
            holder.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, 2, context);
                }
            });

        }else {
            holder.linearLayout.setVisibility(View.GONE);
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textView1,textView2,textView3;
        ImageView imageView1,imageView2,imageView3;
        LinearLayout linearLayout;
    }
}
