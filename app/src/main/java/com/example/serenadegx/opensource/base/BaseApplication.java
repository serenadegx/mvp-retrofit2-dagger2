package com.example.serenadegx.opensource.base;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseRetrofitComponent mComponent;

    public static BaseRetrofitComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerBaseRetrofitComponent.builder().baseRetrofitModule(new BaseRetrofitModule()).build();
    }
}
