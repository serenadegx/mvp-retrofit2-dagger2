package com.example.serenadegx.opensource;

import android.util.Log;

import com.example.serenadegx.opensource.base.BaseApplication;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SplashPresenter {
    @Inject
    Retrofit retrofit;

    public SplashPresenter() {
        DaggerSplashComponent.builder()
                .baseRetrofitComponent(BaseApplication.getComponent())
                .build()
                .inject(this);
    }

    public void splash() {
        Log.i("Mango", "splash--retrofit:" + retrofit);
    }
}
