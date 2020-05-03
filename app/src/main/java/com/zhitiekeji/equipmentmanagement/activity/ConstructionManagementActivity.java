package com.zhitiekeji.equipmentmanagement.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.MyReportDetailModel;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zyz on 2018/1/6.
 * 施工管理
 */

public class ConstructionManagementActivity extends BaseActivity{
    MyReportDetailModel.FacilityServiceReportListBean.FacilityServicePlanListBean model;
    TextView textView6,textView7,textView8;
    EditText editText1;


    /**
     * pdf文件打开
     */
    int file_type = 0;
    String Strname = "";
    private ProgressDialog mProgressDialog;

    // 下载失败
    public static final int DOWNLOAD_ERROR = 2;
    // 下载成功
    public static final int DOWNLOAD_SUCCESS = 1;
    private File file1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constructionmanagement);
    }

    @Override
    protected void initView() {
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        editText1 = (EditText) findViewById(R.id.editText1);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Strname.equals("")) {
                    switch (Strname.substring(Strname.length() - 3)) {
                        case "pdf":
                            //是pdf文件
                            file_type = 1;
                            break;
                        case "doc":
                            //.doc
                            file_type = 2;
                            break;
                        case "ocx":
                            //.docx
                            file_type = 3;
                            break;
                        case "xls":
                            //.xls
                            file_type = 4;
                            break;
                        default:
                            //其他
                            file_type = 0;
                            Intent intent = new Intent();
                            intent.putExtra("url", Strname);
                            intent.setClass(ConstructionManagementActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                    mProgressDialog = new ProgressDialog(ConstructionManagementActivity.this);
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

                } else {
                    showToast("暂未上传站区平面图");
                }
            }
        });
    }

    @Override
    protected void initData() {
        model = (MyReportDetailModel.FacilityServiceReportListBean.FacilityServicePlanListBean) getIntent().getSerializableExtra("model");
        MyLogger.i(">>>>>"+model);

        textView6.setText("开工时间:"+model.getStart_at());
        textView7.setText("竣工时间:"+model.getEnd_at());
        editText1.setText(model.getDescription());
        if (!model.getAccessory().equals("")){
            Strname = model.getAccessory();
            textView8.setText("已上传施工计划");
        }else {
            textView8.setText("未上传施工计划");
        }

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("施工管理详情");
        }
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
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    switch (file_type){
                        case 1:
                            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
                            break;
                        case 2:
                            intent.setDataAndType(Uri.fromFile(file), "application/msword");
                            break;
                        case 3:
                            intent.setDataAndType(Uri.fromFile(file), "application/msword");
                            break;
                        case 4:
                            intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-excel");
                            break;
                    }
//              startActivity(intent);
                    startActivity(Intent.createChooser(intent, "标题"));
                    /**
                     * 弹出选择框   把本activity销毁
                     */
//                    finish();
                    break;
                case DOWNLOAD_ERROR:
                    showToast("文件加载失败");
                    break;
            }
        }
    };
/**
 *
 */


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
