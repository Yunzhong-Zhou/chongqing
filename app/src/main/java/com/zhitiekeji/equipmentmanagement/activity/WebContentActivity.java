package com.zhitiekeji.equipmentmanagement.activity;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.zhitiekeji.equipmentmanagement.R;
import com.zhitiekeji.equipmentmanagement.base.BaseActivity;


/**
 * Created by zyz on 2017/9/12.
 * 文章详情
 */

public class WebContentActivity extends BaseActivity {
    String article_id = "";
    WebView webView;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontent);

    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webView);
//        title = findViewByID_My(R.id.title);
        String url = getIntent().getStringExtra("HelpCenterDetailActivity_content");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webView.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webView.getSettings().setSupportZoom(false);//是否可以缩放，默认true
        webView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webView.getSettings().setDomStorageEnabled(true);//DOM Storage
//        webView.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
        //页面打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //页面标题
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
            }
        });
        WebViewClient client = new WebViewClient() {
            /* TODO Android2.2及以上版本才能使用该方法，目前https://open.t.qq.com中存在http资源会引起sslerror，待网站修正后可去掉该方*/
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                if ((null != view.getUrl()) && (view.getUrl().startsWith("https://open.t.qq.com"))) {
                    handler.proceed();// 接受证书
                } else {
                    handler.cancel(); // 默认的处理方式，WebView变成空白
                }
                // handleMessage(Message msg); 其他处理
            }
        };
        webView.setWebViewClient(client);
        webView.loadUrl(url);//加载web资源
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    protected void initData() {
        /*title.setText(getIntent().getStringExtra("title"));
        article_id = getIntent().getStringExtra("article_id");
        if (!article_id.equals("")){
            String string = "?article_id=" + article_id
                    + "&token=" + localUserInfo.getToken();
            RequestNoticeBrowse(string);//创建公告浏览
        }*/
    }

    @Override
    protected void updateView() {
        if (titleView != null) {
            titleView.setTitle(getIntent().getStringExtra("HelpCenterDetailActivity_title"));
        }
    }
}
