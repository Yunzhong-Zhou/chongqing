package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhitiekeji.equipmentmanagement.R;

import java.util.ArrayList;
/**
 * Created by zyz on 2016/9/12.
 * Email：1125213018@qq.com
 * description：引导页面开始
 */
public class GuideActivity extends Activity {
    private ViewPager viewPager;

    /**
     * 装分页显示的view的数组
     */
    private ArrayList<View> pageViews;
    private ImageView imageView;

    /**
     * 将小圆点的图片用数组表示
     */
    private ImageView[] imageViews;

    //包裹滑动图片的LinearLayout
    private ViewGroup viewPics;

    //包裹小圆点的LinearLayout
    private ViewGroup viewPoints;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将要分页显示的View装入数组中
        LayoutInflater inflater = getLayoutInflater();
        pageViews = new ArrayList<View>();
        pageViews.add(inflater.inflate(R.layout.viewpager_page1, null));
        pageViews.add(inflater.inflate(R.layout.viewpager_page2, null));
        pageViews.add(inflater.inflate(R.layout.viewpager_page3, null));

        //创建imageviews数组，大小是要显示的图片的数量
        imageViews = new ImageView[pageViews.size()];
        //从指定的XML文件加载视图
        viewPics = (ViewGroup) inflater.inflate(R.layout.activity_guide, null);

        //实例化小圆点的linearLayout和viewpager
        viewPoints = (ViewGroup) viewPics.findViewById(R.id.viewGroup);
        viewPager = (ViewPager) viewPics.findViewById(R.id.guidePages);

        //添加小圆点的图片
        for (int i = 0; i < pageViews.size(); i++) {
            imageView = new ImageView(GuideActivity.this);
            //设置小圆点imageview的参数
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(40, 30));//创建一个宽高均为20 的布局

            //将小圆点layout添加到数组中
            imageViews[i] = imageView;
            //默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
            if (i == 0) {
                imageViews[i].setBackgroundResource(R.mipmap.xuanzhong);
            } else {
                imageViews[i].setBackgroundResource(R.mipmap.weixuan);
            }

            //将imageviews添加到小圆点视图组
            viewPoints.addView(imageViews[i]);
        }

        //显示滑动图片的视图
        setContentView(viewPics);

        //设置viewpager的适配器和监听事件
        viewPager.setAdapter(new GuidePageAdapter());
        viewPager.setOnPageChangeListener(new GuidePageChangeListener());

        TextView textView = (TextView) pageViews.get(2).findViewById(R.id.textView);//第三个布局里面的控件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置已经引导
                setGuided();
                //跳转
                Intent mIntent = new Intent();
                mIntent.setClass(GuideActivity.this, LoginActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mIntent);
                finish();
            }
        });
    }

    /*private Button.OnClickListener Button_OnClickListener = new Button.OnClickListener() {
        public void onClick(View v) {

        }
    };*/

    private static final String SHAREDPREFERENCES_NAME = "my_pref";
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";

    private void setGuided() {
        SharedPreferences settings = getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(KEY_GUIDE_ACTIVITY, "false");
        editor.commit();
    }
    class GuidePageAdapter extends PagerAdapter {

        //销毁position位置的界面
        @Override
        public void destroyItem(View v, int position, Object arg2) {
            // TODO Auto-generated method stub
            ((ViewPager) v).removeView(pageViews.get(position));

        }

        @Override
        public void finishUpdate(View arg0) {
            // TODO Auto-generated method stub

        }

        //获取当前窗体界面数
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return pageViews.size();
        }

        //初始化position位置的界面
        @Override
        public Object instantiateItem(View v, int position) {
            // TODO Auto-generated method stub
            ((ViewPager) v).addView(pageViews.get(position));
            return pageViews.get(position);
        }

        // 判断是否由对象生成界面
        @Override
        public boolean isViewFromObject(View v, Object arg1) {
            // TODO Auto-generated method stub
            return v == arg1;
        }

        @Override
        public void startUpdate(View arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }
    }

    class GuidePageChangeListener implements ViewPager.OnPageChangeListener {
        private int pos = 0;
        private int maxPos = pageViews.size() - 1;//最后一页
        private int currentPageScrollStatus;
        private Toast toast;

        @Override
        public void onPageScrollStateChanged(int state) {
            // TODO Auto-generated method stub
            //记录page滑动状态，如果滑动了state就是1
            currentPageScrollStatus = state;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // TODO Auto-generated method stub
            if (pos == 0) {
                //如果offsetPixels是0页面也被滑动了，代表在第一页还要往左划
                if (positionOffsetPixels == 0 && currentPageScrollStatus == 1) {
                    /*if (toast == null || !toast.getView().isShown()) {
                        toast = Toast.makeText(GuideActivity.this, "已经是第一页", Toast.LENGTH_SHORT);
                        toast.show();
                    }*/
                }
            } else if (pos == maxPos) {
                //已经在最后一页还想往右划
                if (positionOffsetPixels == 0 && currentPageScrollStatus == 1) {
                    /*if (toast == null || !toast.getView().isShown()) {
                        toast = Toast.makeText(GuideActivity.this, "已经是最后一页", Toast.LENGTH_SHORT);
                        toast.show();
                    }*/
                    //设置已经引导
                    setGuided();
                    //跳转
                    Intent mIntent = new Intent();
                    mIntent.setClass(GuideActivity.this, LoginActivity.class);
                    mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mIntent);
                    finish();
                }
            }
        }

        @Override
        public void onPageSelected(int position) {
            // TODO Auto-generated method stub
            setCurrentPos(position);
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[position].setBackgroundResource(R.mipmap.xuanzhong);
                //不是当前选中的page，其小圆点设置为未选中的状态
                if (position != i) {
                    imageViews[i].setBackgroundResource(R.mipmap.weixuan);
                }
            }

        }

        public void setMaxPage(int position) {
            //设置最后一页的position值
            maxPos = position;
        }

        public void setCurrentPos(int position) {
            //设置当前页的position值
            pos = position;
        }
    }
}
