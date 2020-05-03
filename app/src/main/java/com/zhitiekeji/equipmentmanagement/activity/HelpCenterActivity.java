package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.HelpCenterAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.model.HelpCenterModel;
import com.zhitiekeji.equipmentmanagement.net.OkHttpClientManager;
import com.zhitiekeji.equipmentmanagement.net.URLs;
import com.zhitiekeji.equipmentmanagement.utils.CommonUtil;
import com.zhitiekeji.equipmentmanagement.utils.MyLogger;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/2/15.
 * 帮助中心
 */

public class HelpCenterActivity extends BaseActivity{
    private ListView listView;
    List<HelpCenterModel> list;
    HelpCenterAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpcenter);
    }

    @Override
    protected void initView() {
        listView =findViewByID_My(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("HelpCenterDetailActivity_title",list.get(i).getTitle());
                bundle.putString("HelpCenterDetailActivity_content",list.get(i).getDetailURL());
//                CommonUtil.gotoActivityWithData(HelpCenterActivity.this,HelpCenterDetailActivity.class,bundle,false);
                CommonUtil.gotoActivityWithData(HelpCenterActivity.this,WebContentActivity.class,bundle,false);

            }
        });
//        String sign = org.apache.commons.codec.digest.DigestUtils.shaHex(codes).toUpperCase();
    }

    @Override
    protected void initData() {
        /*list = new ArrayList<String>();
        list.add("如何上传设备");
        list.add("如何增加病害");
        list.add("我的初始密码忘记了怎么办");
        list.add("如何上传设备");
        list.add("从哪里添加我的设备");
        list.add("如何批量审核");
        HelpCenterAdapter adapter = new HelpCenterAdapter(HelpCenterActivity.this, list);
        listView.setAdapter(adapter);*/
        String string = "?token=" + localUserInfo.getToken();
        RequestHelpList(string);
    }
    private void RequestHelpList(String string) {
        OkHttpClientManager.getAsyn(URLs.HELPLIST+string, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, String info, Exception e) {
                hideProgress();
                showErrorPage();
                if (info.equals("13")){
                    localUserInfo.setUserId("");
                    myToast("账户登录过期，请重新登录");
                    CommonUtil.gotoActivityWithFinishOtherAll(HelpCenterActivity.this, LoginActivity.class,true);
                }else {
                    if (!info.equals("")){
                        showToast(info);
                    }
                }
            }

            @Override
            public void onResponse(String response) {
                hideProgress();
                showContentPage();
                MyLogger.i(">>>>>>>>>帮助中心列表" + response);
                JSONObject jObj;
                list = new ArrayList<HelpCenterModel>();
                try {
                    jObj = new JSONObject(response);
                    JSONArray jsonArray = jObj.getJSONArray("data");
                    list = JSON.parseArray(jsonArray.toString(), HelpCenterModel.class);
                   /* if (list.size() == 0) {
                        showEmptyPage();//空数据
                    } else {

                    }*/
                    adapter = new HelpCenterAdapter(HelpCenterActivity.this, list);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("帮助中心");
        }
    }
}
