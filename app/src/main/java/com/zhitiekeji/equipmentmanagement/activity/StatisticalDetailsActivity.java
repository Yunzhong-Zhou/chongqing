package com.zhitiekeji.equipmentmanagement.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.adapter.Pop_EquipmentAdapter;
import com.zhitiekeji.equipmentmanagement.adapter.StatisticalDetailAdapter;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fafukeji01 on 2017/2/24.
 * 统计详情
 */

public class StatisticalDetailsActivity extends BaseActivity{
    /*搜索框*/
    private EditText editText;
    /*分类选择栏*/
    private RelativeLayout relativeLayout1, relativeLayout2;
    private TextView textView1, textView2;
    private View pop_view;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statisticaldetails);
    }

    @Override
    protected void initView() {
        editText =findViewByID_My(R.id.editText);
        relativeLayout1 =findViewByID_My(R.id.relativeLayout1);
        relativeLayout2 =findViewByID_My(R.id.relativeLayout2);
        textView1 =findViewByID_My(R.id.textView1);
        textView2 =findViewByID_My(R.id.textView2);
        pop_view =findViewByID_My(R.id.pop_view);
        listView =findViewByID_My(R.id.listView);
    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<String>();
        list.add("电类材料");
        list.add("气类材料");
        list.add("建筑类材料");
        StatisticalDetailAdapter adapter = new StatisticalDetailAdapter(StatisticalDetailsActivity.this, list);
        listView.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        Drawable drawable1 = getResources().getDrawable(R.mipmap.downimg2);//选中-蓝色
        Drawable drawable2 = getResources().getDrawable(R.mipmap.downimg3);//未选-灰色
        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        switch (v.getId()) {
            /*分类选择栏*/
            case R.id.relativeLayout1:
                //分类
                textView1.setTextColor(getResources().getColor(R.color.blue));
                textView2.setTextColor(getResources().getColor(R.color.black1));
                textView1.setCompoundDrawables(null, null, drawable1, null);
                textView2.setCompoundDrawables(null, null, drawable2, null);
                showPopupWindow1(pop_view);
                break;
            case R.id.relativeLayout2:
                //距离
                textView1.setTextColor(getResources().getColor(R.color.black1));
                textView2.setTextColor(getResources().getColor(R.color.blue));
                textView1.setCompoundDrawables(null, null, drawable2, null);
                textView2.setCompoundDrawables(null, null, drawable1, null);
                showPopupWindow1(pop_view);
                break;
        }
    }
    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("材料费用");
        }
    }
    private void showPopupWindow1(View v) {
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(StatisticalDetailsActivity.this).inflate(
                R.layout.pop_equipment, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        /*//在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //点击空白处时，隐藏掉pop窗口
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        backgroundAlpha(0.1f);

        //添加pop窗口关闭事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });*/
        // 设置按钮的点击事件
        ListView pop_listView = (ListView) contentView.findViewById(R.id.pop_listView);
        List<String> list = new ArrayList<String>();
        list.add("风雨棚");
        list.add("站台");
        list.add("风雨棚2");
        list.add("站台2");
        final Pop_EquipmentAdapter adapter = new Pop_EquipmentAdapter(StatisticalDetailsActivity.this, list);
        pop_listView.setAdapter(adapter);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setSelectItem(i);
                adapter.notifyDataSetChanged();
//                popupWindow.dismiss();
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

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.yuanjiao_0_baise));
        // 设置好参数之后再show
        popupWindow.showAsDropDown(v);

    }
}
