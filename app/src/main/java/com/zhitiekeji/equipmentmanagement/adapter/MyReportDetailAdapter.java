package com.zhitiekeji.equipmentmanagement.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.activity.ConstructionManagementActivity;
import com.zhitiekeji.equipmentmanagement.activity.DiseaseDetailActivity;
import com.zhitiekeji.equipmentmanagement.activity.ShowSignatureActivity;
import com.zhitiekeji.equipmentmanagement.model.MyReportDetailModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static com.zhitiekeji.equipmentmanagement.R.id.textView1;

/**
 * Created by zyz on 2016/7/6.
 * Email：1125213018@qq.com
 * description：我的上报adapter
 */
public class MyReportDetailAdapter extends BaseAdapter {
    private Context context;
    private List<MyReportDetailModel.FacilityServiceReportListBean> list;
    private int selectIndex = 0;

    int type = 0;
    String string = "";
    /**
     * pdf文件打开
     */
    String Strname = "";
    private ProgressDialog mProgressDialog;

    // 下载失败
    public static final int DOWNLOAD_ERROR = 2;
    // 下载成功
    public static final int DOWNLOAD_SUCCESS = 1;
    private File file1;

    public MyReportDetailAdapter(Context context, List<MyReportDetailModel.FacilityServiceReportListBean> list,String string) {
        super();
        this.context = context;
        this.list = list;
        this.string = string;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_maintenancerecorddetail, null);
            holder.textView1 = (TextView) convertView.findViewById(textView1);
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
            holder.linearLayout1 = (LinearLayout) convertView.findViewById(R.id.linearLayout1);//底部伸缩
            holder.linearLayout_1 = (LinearLayout) convertView.findViewById(R.id.linearLayout_1);//上传文件
            holder.linearLayout_2 = (LinearLayout) convertView.findViewById(R.id.linearLayout_2);//工程预算
            holder.linearLayout_3 = (LinearLayout) convertView.findViewById(R.id.linearLayout_3);//不通过
            holder.linearLayout_4 = (LinearLayout) convertView.findViewById(R.id.linearLayout_4);//签字
            holder.linearLayout_5 = (LinearLayout) convertView.findViewById(R.id.linearLayout_5);//施工管理
            holder.linearLayout_add = (LinearLayout) convertView.findViewById(R.id.linearLayout_add);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).getType().equals("1")) {
            holder.textView1.setText("巡检");
            holder.linearLayout_4.setVisibility(View.GONE);
        } else if (list.get(position).getType().equals("2")) {
            holder.textView1.setText("工长");
            holder.linearLayout_4.setVisibility(View.VISIBLE);
        } else if (list.get(position).getType().equals("3")) {
            holder.textView1.setText("主任");
            holder.linearLayout_4.setVisibility(View.VISIBLE);
        } else if (list.get(position).getType().equals("4")) {
            holder.textView1.setText("科长");
            holder.linearLayout_4.setVisibility(View.VISIBLE);
        } else if (list.get(position).getType().equals("5")) {
            holder.textView1.setText("段长");
            holder.linearLayout_4.setVisibility(View.VISIBLE);
        }
        if (string.equals("1")){
            holder.textView11.setText("请检修");
        }else if (string.equals("2")){
            holder.textView11.setText("综合维修");
        }else if (string.equals("3")){
            holder.textView11.setText("大修");
        }

        //判断是否有附件
        if (list.get(position).getFacility_service_plan_list() != null) {
            if (!list.get(position).getFacility_service_plan_list().get(0).getAccessory().equals("")) {
                Strname = list.get(position).getFacility_service_plan_list().get(0).getAccessory();
                holder.linearLayout_1.setVisibility(View.VISIBLE);
            } else {
                holder.linearLayout_1.setVisibility(View.GONE);
            }
            holder.linearLayout_5.setVisibility(View.VISIBLE);
        } else {
            holder.linearLayout_1.setVisibility(View.GONE);
            holder.linearLayout_5.setVisibility(View.GONE);
        }

        //（发布者）第一项不显示签名
        if (position == 0) {
            holder.linearLayout_4.setVisibility(View.GONE);
        }

        holder.textView2.setText(list.get(position).getEmployee().getName());
        if (list.get(position).getStatus().equals("1")) {
            //如果为最后一项，并且不是段长,显示待审核
            if (position == (list.size() - 1) && !list.get(position).getType().equals("5")) {
                holder.textView3.setText("待审核");
                holder.textView3.setBackgroundResource(R.drawable.yuanjiao_2_huise);
                holder.linearLayout_2.setVisibility(View.VISIBLE);
                holder.linearLayout_3.setVisibility(View.GONE);
            } else {
                holder.textView3.setText("已通过");
                holder.textView3.setBackgroundResource(R.drawable.yuanjiao_2_lvse);
                holder.linearLayout_2.setVisibility(View.VISIBLE);
                holder.linearLayout_3.setVisibility(View.GONE);
            }

        } else {
            holder.textView3.setText("未通过");
            holder.textView3.setBackgroundResource(R.drawable.yuanjiao_2_hongse);
            holder.linearLayout_2.setVisibility(View.GONE);
            holder.linearLayout_3.setVisibility(View.VISIBLE);
            holder.linearLayout_4.setVisibility(View.GONE);
            holder.textView8.setText("未通过理由：" + list.get(position).getReason());
        }
        holder.textView4.setText(list.get(position).getCreated_at());
        holder.textView7.setText(list.get(position).getMoney() + "元");

        //动态添加数据
        holder.linearLayout_add.removeAllViews();
        if (list.get(position).getFacility_disease_list() != null) {
            for (int i = 0; i < list.get(position).getFacility_disease_list().size(); i++) {
                //设置布局
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.item_myreportdetail_disease, null, false);
                view.setLayoutParams(lp);
                //实例化子页面的控件
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
                TextView textView1 = (TextView) view.findViewById(R.id.textView1);
                TextView textView2 = (TextView) view.findViewById(R.id.textView2);
                TextView textView3 = (TextView) view.findViewById(R.id.textView3);
                TextView textView4 = (TextView) view.findViewById(R.id.textView4);
                TextView textView5 = (TextView) view.findViewById(R.id.textView5);
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
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("DiseaseDetailActivity", list.get(position).getFacility_disease_list().get(finalI).getId());
                        bundle.putInt("DiseaseDetailActivity_type", 0);
                        CommonUtil.gotoActivityWithData(context, DiseaseDetailActivity.class, bundle, false);
                    }
                });
                holder.linearLayout_add.addView(view);
            }

        }
        holder.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //施工计划
                if (!Strname.equals("")) {
                    switch (Strname.substring(Strname.length() - 3)) {
                        case "pdf":
                            //是pdf文件
                            type = 1;
                            break;
                        case "doc":
                            //.doc
                            type = 2;
                            break;
                        case "ocx":
                            //.docx
                            type = 3;
                            break;
                        case "xls":
                            //.xls
                            type = 4;
                            break;
                        default:
                            //其他
                            type = 0;
                            Intent intent = new Intent();
                            intent.putExtra("url", Strname);
                            intent.setClass(context, ShowSignatureActivity.class);
                            context.startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(context);
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mProgressDialog.setCancelable(false);
                    mProgressDialog.show();
                    //截取最后14位 作为文件名
                    String s = Strname.substring(Strname.length() - 14);
                    //文件存储
                    file1 = new File(Environment.getExternalStorageDirectory(), getFileName(s));
                    new Thread() {
                        public void run() {
                            File haha = new File(file1.getAbsolutePath());
                            //判断是否有此文件
                            if (haha.exists()) {
                                //有缓存文件,拿到路径 直接打开
                                Message msg = Message.obtain();
                                msg.obj = haha;
                                msg.what = DOWNLOAD_SUCCESS;
                                handler.sendMessage(msg);
                                mProgressDialog.dismiss();
                                return;
                            }
//              本地没有此文件 则从网上下载打开
                            File downloadfile = downLoad(URLs.HOST + Strname, file1.getAbsolutePath(), mProgressDialog);
//              Log.i("Log",file1.getAbsolutePath());
                            Message msg = Message.obtain();
                            if (downloadfile != null) {
                                // 下载成功,安装....
                                msg.obj = downloadfile;
                                msg.what = DOWNLOAD_SUCCESS;
                            } else {
                                // 提示用户下载失败.
                                msg.what = DOWNLOAD_ERROR;
                            }
                            handler.sendMessage(msg);
                            mProgressDialog.dismiss();
                        }
                    }.start();
                   /* if (Strname.substring(Strname.length() - 3).equals("pdf")) {

                    } else {
                        //不是pdf文件

                    }*/

                } else {
                    Toast.makeText(context, "暂未上传站区平面图", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转施工管理详情
                Intent intent = new Intent();
                intent.putExtra("model", (MyReportDetailModel.FacilityServiceReportListBean.FacilityServicePlanListBean) list.get(position).getFacility_service_plan_list().get(0));
                intent.setClass(context, ConstructionManagementActivity.class);
                context.startActivity(intent);
            }
        });
        holder.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //查看签名
                Intent intent = new Intent();
                intent.putExtra("url", list.get(position).getSignature_pic());
                intent.setClass(context, ShowSignatureActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        LinearLayout linearLayout1, linearLayout_1, linearLayout_2, linearLayout_3,
                linearLayout_4, linearLayout_5, linearLayout_add;
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7,
                textView8, textView9, textView10,textView11;
    }
    /**************************pdf文件下载及打开**************************************************/
    /**
     * 下载完成后  直接打开文件
     */
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case DOWNLOAD_SUCCESS:
                    File file = (File) msg.obj;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } else {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    }

                    Uri uri = getUriForFile(context, file);
                    switch (type){
                        case 1:
                            intent.setDataAndType(uri, "application/pdf");
                            break;
                        case 2:
                            intent.setDataAndType(uri, "application/msword");
                            break;
                        case 3:
                            intent.setDataAndType(uri, "application/msword");
                            break;
                        case 4:
                            intent.setDataAndType(uri, "application/vnd.ms-excel");
                            break;
                    }
//              startActivity(intent);
                    context.startActivity(Intent.createChooser(intent, "请选择您要打开的应用"));
                    /**
                     * 弹出选择框   把本activity销毁
                     */
//                    finish();
                    break;
                case DOWNLOAD_ERROR:
                    Toast.makeText(context, "文件加载失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private static Uri getUriForFile(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "com.zhitiekeji.equipmentmanagement.fileprovider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }


    /**
     * 传入文件 url  文件路径  和 弹出的dialog  进行 下载文档
     */
    public static File downLoad(String serverpath, String savedfilepath, ProgressDialog pd) {
        try {
            URL url = new URL(serverpath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() == 200) {
                int max = conn.getContentLength();
                pd.setMax(max);
                InputStream is = conn.getInputStream();
                File file = new File(savedfilepath);
                FileOutputStream fos = new FileOutputStream(file);
                int len = 0;
                byte[] buffer = new byte[1024];
                int total = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                    total += len;
                    pd.setProgress(total);
                }
                fos.flush();
                fos.close();
                is.close();
                return file;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getFileName(String serverurl) {
        return serverurl.substring(serverurl.lastIndexOf("/") + 1);
    }
}
