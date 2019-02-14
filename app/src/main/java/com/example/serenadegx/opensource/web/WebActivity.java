package com.example.serenadegx.opensource.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.serenadegx.opensource.R;
import com.example.xrwebviewlibrary.BaseWebViewListener;
import com.example.xrwebviewlibrary.XRWebView;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        final ProgressBar pb = findViewById(R.id.pb);
        XRWebView.with((WebView) findViewById(R.id.web))
                .simple()
                .serZoomEnable(true)
                .setImageLoadEnable(true)
                .setSslEnable(true)
                .build().loadUrl("https://www.baidu.com/", new BaseWebViewListener() {
            @Override
            public void onLoadError(int errorCode, String description) {

            }

            @Override
            public void onGetTitle(String title) {
                setTitle(title);
            }

            @Override
            public void onProgress(int progress) {
                if (progress == 100) {
                    pb.setVisibility(View.GONE);
                } else {
                    pb.setVisibility(View.VISIBLE);
                    pb.setProgress(progress);
                }
            }
        });
    }

    public static void start2WebActivity(Context context) {
        context.startActivity(new Intent(context, WebActivity.class));
    }
}
