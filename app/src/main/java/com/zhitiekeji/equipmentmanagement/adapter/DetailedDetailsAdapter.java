package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ViewPagerPhotoViewActivity;
import com.zhitiekeji.equipmentmanagement.model.DetailedDetailsModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：细部描述adapter
 */
public class DetailedDetailsAdapter extends BaseAdapter {
    private Context context;
    private List<DetailedDetailsModel> list;
    private int selectIndex = 0;

    public DetailedDetailsAdapter(Context context, List<DetailedDetailsModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_detaileddetails, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.recyclerview1 = (RecyclerView) convertView.findViewById(R.id.recyclerview1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getCreated_at() + "");
        holder.textView3.setText("细部描述：" + list.get(position).getContent());
        //横向滑动数据
        if (list.get(position).getPic_list() != null) {
            MyLogger.i(">>>>>>>>>" + list.get(position).getPic_list().toString());
           /* String str = list.get(position).getPic_list().toString().replaceAll("\\[\"", "");
            str = str.replaceAll("\"]", "");
            str = str.replaceAll("\\\\", "");
            String[] strings = str.split("\",\"");
            final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
            for (int i = 0; i < strings.length; i++) {
                imageUrlList_1.add(URLs.HOST+strings[i]);
            }*/

            final ArrayList<String> imageUrlList_1 = new ArrayList<String>();
            for (int i = 0; i < list.get(position).getPic_list().size(); i++) {
                imageUrlList_1.add(URLs.HOST + list.get(position).getPic_list().get(i));
            }
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.recyclerview1.setLayoutManager(linearLayoutManager);
            //设置适配器
            MyReportDetaiRecycleViewImageAdapter1 mAdapter = new MyReportDetaiRecycleViewImageAdapter1(context, imageUrlList_1);
            holder.recyclerview1.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new MyReportDetaiRecycleViewImageAdapter1.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    ViewPagerPhotoViewActivity.startThisActivity(imageUrlList_1, position, context);
                }
            });

        } else {
            //没有图片

        }
        return convertView;
    }

    private static class ViewHolder {
        TextView textView1, textView2, textView3;
        RecyclerView recyclerview1;
    }
}
