package com.zhitiekeji.equipmentmanagement.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;
import com.zhitiekeji.equipmentmanagement.net.URLs;


/**
 * Created by zyz on 2017/9/16.
 * 查看签名
 */

public class ShowSignatureActivity extends BaseActivity {
    String url = "";
    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsignature);
    }

    @Override
    protected void initView() {
        url = getIntent().getStringExtra("url");
//        name = getIntent().getStringExtra("name");
        ImageView imageView = findViewByID_My(R.id.imageView);
        if (!url.equals(""))
            Glide.with(ShowSignatureActivity.this).load(URLs.HOST+url).fitCenter().into(imageView);//加载图片
        else
            imageView.setImageResource(R.mipmap.noimg);
        /*imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            HttpURLConnection conn = (HttpURLConnection) new URL(URLs.HOST+remittance_voucher).openConnection();
                            conn.setDoInput(true);
                            conn.connect();
                            InputStream is = conn.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            FileOutputStream fos = new FileOutputStream(
                                    new File(Environment.getExternalStorageDirectory() + "/" + name + ".jpg"));
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                            fos.flush();
                            fos.close();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }).start();
                MyLogger.i(">>>>>>>>>>>"+ Environment.getExternalStorageDirectory() + "/" + name + ".jpg");
                Toast.makeText(ShowScreenshotActivity.this,ShowScreenshotActivity.this.getString(R.string.showinformation_hint) + Environment.getExternalStorageDirectory() + "/" + name + ".jpg", Toast.LENGTH_LONG).show();

                return true;
            }
        });*/
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle("查看图片");
        }
    }
}
