package com.example.serenadegx.opensource;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.serenadegx.opensource.advance.AdvanceActivity;

public class SplashActivity extends AppCompatActivity {
//    @Inject
//    SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        new SplashPresenter().splash();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                AdvanceActivity.start2AdvanceActivity(SplashActivity.this);
            }
        }, 1500);
    }
}
