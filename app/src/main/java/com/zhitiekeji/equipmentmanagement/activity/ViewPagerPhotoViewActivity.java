/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zhitiekeji.equipmentmanagement.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.view.HackyViewPager;

import java.util.ArrayList;

import cn.finalteam.galleryfinal.widget.zoonview.PhotoView;


/**
 * Created by zyz on 2015/10/26.
 * description:可滑动放大的图片
 */

public class ViewPagerPhotoViewActivity extends Activity {
    //    private PhotoViewAttacher mAttacher;
    private ViewPager mViewPager;//可滑动放大的图片
    private TextView tv_currentPosition;//显示页数
    private TextView titleView;
    private ImageView left_btn;
    private ArrayList<String> imgList;//图片路径
    private int position;//得到的是第几张

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (HackyViewPager) findViewById(R.id.view_pager);
        tv_currentPosition = (TextView) findViewById(R.id.tv_currentPosition);
        titleView = (TextView) findViewById(R.id.titleView);
        left_btn = (ImageView) findViewById(R.id.left_btn);
        //setContentView(mViewPager);
        imgList = getIntent().getStringArrayListExtra("imgList");
        position = getIntent().getIntExtra("position", 0);
        if (imgList != null) {
            titleView.setText(position + 1 + "/" + imgList.size());
//            titleView.setText("查看所有图片");
//            ImageViewAdapter adapter = new ImageViewAdapter(this,imgList);
            mViewPager.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return imgList.size();
                }
                //instantiateItem和destroyItem中的方法要自己去实现
                @Override
                public View instantiateItem(ViewGroup container, int position) {
                    final PhotoView photoView = new PhotoView(ViewPagerPhotoViewActivity.this);
//                    Bitmap bitmap= BitmapFactory.decodeStream(this.getClass().getClassLoader().getResourceAsStream("assets/" + imgList.get(position).toString()));
//                    photoView.setImageBitmap(bitmap);
//                    photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    Glide.with(ViewPagerPhotoViewActivity.this).load(imgList.get(position).toString()).fitCenter().into(photoView);
//                    Glide.with(ViewPagerPhotoViewActivity.this).load(imgList.get(position).toString()).centerCrop().into(photoView);//加载图片
                    Glide.with(ViewPagerPhotoViewActivity.this).load(imgList.get(position).toString()).asBitmap().into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            photoView.setImageBitmap(resource);
                        }
                    });
                    // Now just add PhotoView to ViewPager and return it
                    container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                    return photoView;
                }
                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

            });

            mViewPager.setCurrentItem(position);
        }
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                tv_currentPosition.setText(position + 1 + "/" + imgList.size());
                titleView.setText(position + 1 + "/" + imgList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void startThisActivity(ArrayList<String> imgList, int position, Activity context) {
        Intent intent = new Intent(context, ViewPagerPhotoViewActivity.class);
        intent.putStringArrayListExtra("imgList", imgList);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }
    public static void startThisActivity(ArrayList<String> imgList, int position, Context context) {
        Intent intent = new Intent(context, ViewPagerPhotoViewActivity.class);
        intent.putStringArrayListExtra("imgList", imgList);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }


   /* private class PhotoTapListener implements PhotoViewAttacher.OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {
            ViewPagerPhotoViewActivity.this.finish();
        }
    }*/
}
