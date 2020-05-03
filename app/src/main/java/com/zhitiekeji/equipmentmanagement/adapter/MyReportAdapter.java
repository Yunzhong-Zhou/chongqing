package com.zhitiekeji.equipmentmanagement.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.DiseaseDetailActivity;
import com.zhitiekeji.equipmentmanagement.model.MyReportModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.LocalUserInfo;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：设备adapter
 */
public class MyReportAdapter extends BaseAdapter {
    private Context context;
    private List<MyReportModel> list;
    private int selectIndex = 0;

    public MyReportAdapter(Context context, List<MyReportModel> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_myreport, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            holder.textView6 = (TextView) convertView.findViewById(R.id.textView6);
            holder.textView7 = (TextView) convertView.findViewById(R.id.textView7);
            holder.textView8 = (TextView) convertView.findViewById(R.id.textView8);
            holder.textView9 = (TextView) convertView.findViewById(R.id.textView9);
            holder.textView10 = (TextView) convertView.findViewById(R.id.textView10);
            holder.textView11 = (TextView) convertView.findViewById(R.id.textView11);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.imageView_more = (ImageView) convertView.findViewById(R.id.imageView_more);
            holder.linearLayout_add = (LinearLayout) convertView.findViewById(R.id.linearLayout_add);
            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);
            holder.linearLayout2 = (LinearLayout) convertView.findViewById(R.id.linearLayout2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getFacility().getCompany().getTitle());//所属车间

        holder.textView2.setText(list.get(position).getFacility().getTitle());//设备名称
        holder.textView3.setText(list.get(position).getFacility().getNumber());//设备账号
        holder.textView4.setText(list.get(position).getFacility().getWork_area().getTitle() +
                list.get(position).getFacility().getStation().getTitle());//所属车辆段
        if (list.get(position).getFacility().getType().equals("1")) {//判断是房屋还是构筑物
            holder.textView5.setText(list.get(position).getFacility().getHouse_area() + "㎡");//房屋面积
        } else {
            holder.textView5.setText(list.get(position).getFacility().getStructures_area() + "H㎡");//构筑物面积
        }
//        holder.textView6.setText(list.get(position).getFacility().getNumber());//批复号
        Glide.with(context).load(URLs.HOST + list.get(position).getFacility().getPic2()).centerCrop().into(holder.imageView);//加载图片
        holder.textView7.setText("共" + list.get(position).getFacility_disease_list().size() + "条");

        if (list.get(position).getType().equals("1")){
            holder.textView10.setText("请检修");
        }else if (list.get(position).getType().equals("2")){
            holder.textView10.setText("综合维修");
        }else if (list.get(position).getType().equals("3")){
            holder.textView10.setText("大修");
        }
        holder.textView11.setText(list.get(position).getCreated_at());
        //动态添加数据
        holder.linearLayout_add.removeAllViews();
        int size = 0;
        final boolean[] isDown = {false};
        if (list.get(position).getFacility_disease_list().size() <= 2) {
            size = list.get(position).getFacility_disease_list().size();
            holder.imageView_more.setImageResource(R.mipmap.next);
        } else {
            size = 2;
            holder.imageView_more.setImageResource(R.mipmap.icon_down);
        }
        for (int i = 0; i < size; i++) {
            //设置布局
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_myreport_disease, null, false);
            view.setLayoutParams(lp);
            //实例化子页面的控件
            TextView textView1 = (TextView) view.findViewById(R.id.textView1);
            TextView textView2 = (TextView) view.findViewById(R.id.textView2);
            TextView textView3 = (TextView) view.findViewById(R.id.textView3);
            TextView textView4 = (TextView) view.findViewById(R.id.textView4);
            TextView textView5 = (TextView) view.findViewById(R.id.textView5);

            /*if (list.get(position).getFacility().getType().equals("1")){//判断是房屋还是构筑物
                textView2.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//房屋
                textView1.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
            }else {
                textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//构筑物
                textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
            }*/
            textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());
            textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
            if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("1")) {
                textView3.setText("轻微");
            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("2")) {
                textView3.setText("一般");
            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("3")) {
                textView3.setText("较重");
            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("4")) {
                textView3.setText("严重");
            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("5")) {
                textView3.setText("紧急");
            }
            textView4.setText(list.get(position).getFacility_disease_list().get(i).getArea() + "㎡");
            textView5.setText(list.get(position).getFacility_disease_list().get(i).getAmount_money() + "元");

            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("DiseaseDetailActivity", list.get(position).getFacility_disease_list().get(finalI).getId());
                    bundle.putInt("DiseaseDetailActivity_type", 0);
                    CommonUtil.gotoActivityWithData(context, DiseaseDetailActivity.class, bundle, false);
                }
            });
            holder.linearLayout_add.addView(view);
        }
        final ViewHolder finalHolder = holder;
        final int finalSize = size;
        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).getFacility_disease_list().size() > 2) {
                    isDown[0] = !isDown[0];
                    if (isDown[0]) {
                        finalHolder.imageView_more.setImageResource(R.mipmap.icon_up);
                        finalHolder.linearLayout_add.removeAllViews();
                        for (int i = 0; i < list.get(position).getFacility_disease_list().size(); i++) {
                            //设置布局
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            LayoutInflater inflater = LayoutInflater.from(context);
                            View view = inflater.inflate(R.layout.item_myreport_disease, null, false);
                            view.setLayoutParams(lp);
                            //实例化子页面的控件
                            TextView textView1 = (TextView) view.findViewById(R.id.textView1);
                            TextView textView2 = (TextView) view.findViewById(R.id.textView2);
                            TextView textView3 = (TextView) view.findViewById(R.id.textView3);
                            TextView textView4 = (TextView) view.findViewById(R.id.textView4);
                            TextView textView5 = (TextView) view.findViewById(R.id.textView5);
                            /*if (list.get(position).getFacility().getType().equals("1")){//判断是房屋还是构筑物
                                textView2.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//房屋
                                textView1.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
                            }else {
                                textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//构筑物
                                textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
                            }*/
                            textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());
                            textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());

                            if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("1")) {
                                textView3.setText("轻微");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("2")) {
                                textView3.setText("一般");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("3")) {
                                textView3.setText("较重");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("4")) {
                                textView3.setText("严重");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("5")) {
                                textView3.setText("紧急");
                            }
                            textView4.setText(list.get(position).getFacility_disease_list().get(i).getArea() + "㎡");
                            textView5.setText(list.get(position).getFacility_disease_list().get(i).getAmount_money() + "元");

                            final int finalI = i;
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("DiseaseDetailActivity", list.get(position).getFacility_disease_list().get(finalI).getId());
                                    bundle.putInt("DiseaseDetailActivity_type", 0);
                                    CommonUtil.gotoActivityWithData(context, DiseaseDetailActivity.class, bundle, false);
                                }
                            });
                            finalHolder.linearLayout_add.addView(view);
                        }
                    } else {
                        finalHolder.imageView_more.setImageResource(R.mipmap.icon_down);
                        finalHolder.linearLayout_add.removeAllViews();
                        for (int i = 0; i < finalSize; i++) {
                            //设置布局
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            LayoutInflater inflater = LayoutInflater.from(context);
                            View view = inflater.inflate(R.layout.item_myreport_disease, null, false);
                            view.setLayoutParams(lp);
                            //实例化子页面的控件
                            TextView textView1 = (TextView) view.findViewById(R.id.textView1);
                            TextView textView2 = (TextView) view.findViewById(R.id.textView2);
                            TextView textView3 = (TextView) view.findViewById(R.id.textView3);
                            TextView textView4 = (TextView) view.findViewById(R.id.textView4);
                            TextView textView5 = (TextView) view.findViewById(R.id.textView5);
                            /*if (list.get(position).getFacility().getType().equals("1")){//判断是房屋还是构筑物
                                textView2.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//房屋
                                textView1.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
                            }else {
                                textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());//构筑物
                                textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());
                            }*/
                            textView1.setText(list.get(position).getFacility_disease_list().get(i).getTitle());
                            textView2.setText(list.get(position).getFacility_disease_list().get(i).getFacility_disease_type().getTitle());

                            if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("1")) {
                                textView3.setText("轻微");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("2")) {
                                textView3.setText("一般");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("3")) {
                                textView3.setText("较重");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("4")) {
                                textView3.setText("严重");
                            } else if (list.get(position).getFacility_disease_list().get(i).getDegree().equals("5")) {
                                textView3.setText("紧急");
                            }
                            textView4.setText(list.get(position).getFacility_disease_list().get(i).getArea() + "㎡");
                            textView5.setText(list.get(position).getFacility_disease_list().get(i).getAmount_money() + "元");

                            final int finalI = i;
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("DiseaseDetailActivity", list.get(position).getFacility_disease_list().get(finalI).getId());
                                    bundle.putInt("DiseaseDetailActivity_type", 0);
                                    CommonUtil.gotoActivityWithData(context, DiseaseDetailActivity.class, bundle, false);
                                }
                            });
                            finalHolder.linearLayout_add.addView(view);
                        }
                    }

                }
            }
        });

        //未通过
        if (list.get(position).getAgree().equals("2")) {
            holder.linearLayout2.setVisibility(View.VISIBLE);
            holder.textView8.setText("未通过理由:" + list.get(position).getReason());//未通过理由
        } else {
            holder.linearLayout2.setVisibility(View.GONE);
        }

        /*if (position == 0){
            holder.linearLayout1.setVisibility(View.VISIBLE);
            holder.linearLayout2.setVisibility(View.VISIBLE);
            holder.imageView.setImageResource(R.mipmap.itemimg1);
        }else{
            holder.linearLayout1.setVisibility(View.GONE);
            holder.linearLayout2.setVisibility(View.GONE);
            holder.imageView.setImageResource(R.mipmap.itemimg2);
        }*/
        holder.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //再次提交申请
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定再次提交申请吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("id", list.get(position).getId());//id
                        params.put("facility_id", list.get(position).getFacility_id());//设备id
                        params.put("token", LocalUserInfo.getInstance(context).getToken());//token
                        RequestUpLoad(params,position);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView, imageView_more;
        TextView textView1, textView2, textView3, textView4, textView5, textView6,
                textView7, textView8, textView9,textView10,textView11;
        LinearLayout linearLayout1, linearLayout2, linearLayout_add;
    }

    private void RequestUpLoad(Map<String, String> params, final int i) {
        OkHttpClientManager.postAsyn(URLs.AgainReport, params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                if (!info.equals("")) {
                    Toast.makeText(context,info,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onResponse(String response) {
                MyLogger.i(">>>>>>>>>再次申请" + response);
                Toast.makeText(context,"提交成功",Toast.LENGTH_SHORT).show();
                list.get(i).setAgree("1");
                notifyDataSetChanged();
            }
        });

    }
}
