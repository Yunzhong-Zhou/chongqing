package com.zhitiekeji.equipmentmanagement.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.SchoolBagAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.SchoolBagModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.zhitiekeji.equipmentmanagement.view.FixedPopupWindow;
import com.zhitiekeji.equipmentmanagement.view.pullview.AbPullToRefreshView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/6/15.
 * 党员小书包
 */

public class SchoolBagActivity extends BaseActivity {
    //分类选择栏
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    private TextView textView1, textView2, textView3, textView4,
            textView1_1, textView2_1, textView3_1, textView4_1;
    private View pop_view;
    private ListView listView;
    SchoolBagAdapter adapter;
    List<SchoolBagModel> list = new ArrayList<SchoolBagModel>();
    int page = 1, searchStatus = 1;

    //分类选择下标
    int i1 = 0;
    String type = "";


    int file_type = 0;
    /**
     * pdf文件打开
     */
    String Strname = "", filename = "";
    private ProgressDialog mProgressDialog;

    // 下载失败
    public static final int DOWNLOAD_ERROR = 2;
    // 下载成功
    public static final int DOWNLOAD_SUCCESS = 1;
    private File file1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolbag);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestServer();//获取数据
    }

    @Override
    protected void initView() {
        //分类选择栏
        linearLayout1 = findViewByID_My(R.id.linearLayout1);
        linearLayout2 = findViewByID_My(R.id.linearLayout2);
        linearLayout3 = findViewByID_My(R.id.linearLayout3);
        linearLayout4 = findViewByID_My(R.id.linearLayout4);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        textView1 = findViewByID_My(R.id.textView1);
        textView2 = findViewByID_My(R.id.textView2);
        textView3 = findViewByID_My(R.id.textView3);
        textView4 = findViewByID_My(R.id.textView4);
        textView1_1 = findViewByID_My(R.id.textView1_1);
        textView2_1 = findViewByID_My(R.id.textView2_1);
        textView3_1 = findViewByID_My(R.id.textView3_1);
        textView4_1 = findViewByID_My(R.id.textView4_1);
        pop_view = findViewByID_My(R.id.pop_view);

        listView = findViewByID_My(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showProgress(true, "正在读取文件，请稍后...");
                Strname = list.get(i).getAttachment();
                filename = list.get(i).getTitle();
                String string = "?id=" + list.get(i).getId()
                        + "&token=" + localUserInfo.getToken();
                Requestead(string);

            }
        });

        pullview.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(AbPullToRefreshView view) {
                //刷新
                page = 1;
                String string = "?searchStatus=" + searchStatus
                        + "&type=" + type + ""
                        + "&page=" + page + ""//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestSchoolBagList(string);
            }
        });
        pullview.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(AbPullToRefreshView view) {
                page = page + 1;
                //加载更多
                String string = "?searchStatus=" + searchStatus
                        + "&type=" + type + ""
                        + "&page=" + page + ""//当前页号
                        + "&count=" + "10"//页面行数
                        + "&token=" + localUserInfo.getToken();
                RequestSchoolBagListMore(string);
            }
        });
    }

    @Override
    protected void initData() {
        /*String string3 = "?token=" + localUserInfo.getToken();
        RequestAreaList1(string3);//区域列表*/

    }

    private void RequestSchoolBagList(String string) {
        OkHttpClientManager.getAsyn(URLs.SchoolBag + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(SchoolBagActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>党员小书包列表" + response);
                JSONObject jObj;
                list = new ArrayList<SchoolBagModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), SchoolBagModel.class);
                    if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {
                        adapter = new SchoolBagAdapter(SchoolBagActivity.this, list);
                        listView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    private void RequestSchoolBagListMore(String string) {
        OkHttpClientManager.getAsyn(URLs.SchoolBag + string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                onHttpResult();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(SchoolBagActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                onHttpResult();
                MyLogger.i(">>>>>>>>>党员小书包更多" + response);
                JSONObject jObj;
                List<SchoolBagModel> list1 = new ArrayList<SchoolBagModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list1 = JSON.parseArray(jsonArray.toString(), SchoolBagModel.class);
                    if (list1.size() == 0) {
                        myToast("没有更多了");
                    } else {
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    private void Requestead(String params) {
        OkHttpClientManager.getAsyn(URLs.SchoolBag_read + params, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                if (!info.equals("")) {
                    if (info.equals("13")) {
                        localUserInfo.setUserId("");
                        showToast("账户登录过期，请重新登录");
                        CommonUtil.gotoActivityWithFinishOtherAll(SchoolBagActivity.this, LoginActivity.class, true);
                    } else {
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                MyLogger.i(">>>>>>>>>党员小书包阅读量" + response);
                //打开附件
                if (!Strname.equals("")) {
                    switch (Strname.substring(Strname.length() - 3)) {
                        case "pdf":
                            //是pdf文件
                            file_type = 1;
                            openFile();
                            break;
                        case "doc":
                            //.doc
                            file_type = 2;
                            openFile();
                            break;
                        case "ocx":
                            //.docx
                            file_type = 3;
                            openFile();
                            break;
                        case "xls":
                            //.xls
                            file_type = 4;
                            openFile();
                            break;
                        default:
                            //其他
                            file_type = 0;
                            Intent intent = new Intent();
                            intent.putExtra("url", Strname);
                            intent.setClass(SchoolBagActivity.this, ShowSignatureActivity.class);
                            startActivity(intent);
                            break;
                    }

                } else {
                    showToast("暂未上传文件");
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        Drawable drawable1 = getResources().getDrawable(R.mipmap.downimg2);//选中-蓝色
        Drawable drawable2 = getResources().getDrawable(R.mipmap.downimg3);//未选-灰色
        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        switch (v.getId()) {
            case R.id.linearLayout1:
                //时间先后
                textView1_1.setBackgroundResource(R.color.blue);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                searchStatus = 1;
                requestServer();
                break;
            case R.id.linearLayout2:
                //阅读量
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.blue);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                searchStatus = 2;
                requestServer();
                break;
            case R.id.linearLayout3:
                //分类
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.blue);
                textView4_1.setBackgroundResource(R.color.transparent);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.blue));
                textView4.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable1, null);
                textView4.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow1(pop_view);
                break;
            case R.id.linearLayout4:
                //历年记录
                textView1_1.setBackgroundResource(R.color.transparent);
                textView2_1.setBackgroundResource(R.color.transparent);
                textView3_1.setBackgroundResource(R.color.transparent);
                textView4_1.setBackgroundResource(R.color.blue);
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView3.setTextColor(getResources().getColor(R.color.black1));
                textView4.setTextColor(getResources().getColor(R.color.blue));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                textView3.setCompoundDrawables(null, null, drawable2, null);
                textView4.setCompoundDrawables(null, null, drawable1, null);

                break;
        }
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("党员小书包");
            /*titleView.showRightTextview("清空", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    station_id = "";//区域id
                    status = "";//状态（1.上报中 2.已上报 3.下达 4.批复 5.实施 6.竣工）
                    year = "";//年份
                    month = "";//月份
                    requestServer();
                }
            });*/
        }
    }

    @Override
    public void requestServer() {
        super.requestServer();
        this.showLoadingPage();
        page = 1;
        String string = "?searchStatus=" + searchStatus
                + "&type=" + type + ""
                + "&page=" + page + ""//当前页号
                + "&count=" + "10"//页面行数
                + "&token=" + localUserInfo.getToken();
        RequestSchoolBagList(string);
    }

    public void onHttpResult() {
        pullview.onHeaderRefreshFinish();
        pullview.onFooterLoadFinish();
    }

    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        final View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_equipment, null);
        final FixedPopupWindow popupWindow = new FixedPopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        contentView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = contentView.findViewById(R.id.pop_listView).getTop();
                int height1 = contentView.findViewById(R.id.pop_listView).getBottom();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                    if (y > height1) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });

        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("全部");
        list.add("党建");
        list.add("技术");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(this, list);
        adapter.setSelectItem(i1);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                i1 = i;
                adapter.setSelectItem(i1);
                adapter.notifyDataSetChanged();
                if (i == 0) {
                    type = "";
                } else {
                    type = (i + 1) + "";
                }
                requestServer();
                popupWindow.dismiss();
            }
        });

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.transparentblack3));
        // 设置弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);
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
//                    Uri uri =  Uri.fromFile(file);
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } else {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    }

                    Uri uri = getUriForFile(SchoolBagActivity.this, file);
                    switch (file_type) {
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
                    startActivity(Intent.createChooser(intent, "请选择您要打开的应用"));
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
     * 打开文件
     */
    private void openFile() {
        mProgressDialog = new ProgressDialog(SchoolBagActivity.this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        //截取最后14位 作为文件名
//                    String s = Strname.substring(Strname.length() - 14);
        String s = filename;
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
