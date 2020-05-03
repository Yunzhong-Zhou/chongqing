package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/2/14.
 */

public class MyReportDetaiRecycleViewImageAdapter1 extends RecyclerView.Adapter<MyReportDetaiRecycleViewImageAdapter1.ViewHolder>  implements View.OnClickListener{
    private LayoutInflater mInflater;
    private List<String> imageUrlList_1 = new ArrayList<String>();
    Context context;
    private OnItemClickListener mOnItemClickListener = null;
    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public MyReportDetaiRecycleViewImageAdapter1(Context context, List<String> imageUrlList_1)
    {
        mInflater = LayoutInflater.from(context);
        this.imageUrlList_1 = imageUrlList_1;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public int getItemCount()
    {
        return imageUrlList_1.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.item_recyclerview_miantenancerecord,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view.findViewById(R.id.imageView);

        view.setOnClickListener(this);

        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        Glide.with(context).load(imageUrlList_1.get(i)).centerCrop().into(viewHolder.mImg);//加载图片
        //将position保存在itemView的Tag中，以便点击时进行获取
        viewHolder.itemView.setTag(i);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
