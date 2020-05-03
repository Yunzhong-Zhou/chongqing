package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.model.EquipmentListModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;

import java.util.List;

import static com.zhitiekeji.equipmentmanagement.R.id.textView6;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：设备adapter
 */
public class EquipmentAdapter extends BaseAdapter {
    private Context context;
    private List<EquipmentListModel> list;
    private int selectIndex = 0;

    public EquipmentAdapter(Context context, List<EquipmentListModel> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_equipment, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.textView9 = (TextView) convertView.findViewById(R.id.textView9);
            holder.textView10 = (TextView) convertView.findViewById(R.id.textView10);
            holder.textView11 = (TextView) convertView.findViewById(R.id.textView11);
            holder.imageView1 = (ImageView) convertView.findViewById(R.id.imageView1);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.imageView2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getCompany().getTitle());//车间
        holder.textView2.setText(list.get(position).getTitle());//设备名字
        holder.textView3.setText(list.get(position).getNumber());//编号
        holder.textView4.setText(list.get(position).getWork_area().getTitle()+list.get(position).getStation().getTitle());//工区站区

        if (list.get(position).getType() == 1){//判断是房屋还是构筑物
            holder.textView5.setText(list.get(position).getHouse_area()+"㎡");//房屋面积
        }else {
            holder.textView5.setText(list.get(position).getStructures_area()+"H㎡");//构筑物面积
        }
        /*if (list.get(position).getLast_small_service_at()!=null && !list.get(position).getLast_small_service_at().equals("")){
            String[] strs=list.get(position).getLast_small_service_at().toString().split(" ");
            holder.textView7.setText("上次"+strs[0]);//请检修时间
        }else {
            holder.textView7.setText("暂无");
        }
        if (list.get(position).getLast_mid_service_at()!=null && !list.get(position).getLast_mid_service_at().equals("")){
            String[] strs=list.get(position).getLast_mid_service_at().toString().split(" ");
            holder.textView9.setText("上次"+strs[0]);//综合维修时间
        }else {
            holder.textView9.setText("暂无");
        }
        if (list.get(position).getLast_big_service_at()!=null && !list.get(position).getLast_big_service_at().equals("")){
            String[] strs=list.get(position).getLast_big_service_at().toString().split(" ");
            holder.textView11.setText("上次"+strs[0]);//大修时间
        }else {
            holder.textView11.setText("暂无");
        }*/
        //请检修
        holder.textView6.setText("["+list.get(position).getMinor()+"]");
        holder.textView7.setText(list.get(position).getMinor_updated_at());
        //综合维修
        holder.textView8.setText("["+list.get(position).getMid()+"]");
        holder.textView9.setText(list.get(position).getMid_updated_at());
        //大修
        holder.textView10.setText("["+list.get(position).getBig()+"]");
        holder.textView11.setText(list.get(position).getBig_updated_at());

        Glide.with(context).load(URLs.HOST+list.get(position).getPic2()).centerCrop().into(holder.imageView1);//加载图片

        //是否检修
        if (list.get(position).getIs_inspect().equals("1")){
            //未检修
            holder.imageView2.setImageResource(R.mipmap.weijianxiu);
        }else {
            //已检修
            holder.imageView2.setImageResource(R.mipmap.yixunjian);
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,
                textView9,textView10,textView11;
    }
}
