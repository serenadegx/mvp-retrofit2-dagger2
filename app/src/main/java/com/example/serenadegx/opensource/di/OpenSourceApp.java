package com.example.serenadegx.opensource.di;

import android.app.Application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * 我们创建一个自定义的{@link Application}类，该类继承了{@link DaggerApplication}。
 * 然后重写applicationInjector()，它告诉Dagger如何创建我们的@Singleton组件
 * 我们永远不需要调用component.inject(this)，因为{@link DaggerApplication}会为我们做这个
 */
public class OpenSourceApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
