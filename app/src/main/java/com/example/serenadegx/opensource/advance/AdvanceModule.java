package com.example.serenadegx.opensource.advance;

import com.example.serenadegx.opensource.di.ActivityScoped;
import com.example.serenadegx.opensource.di.ViewScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 这是一个Dagger Module。我们使用它将视图依赖项传递给* {@link AdvancePresenter}。
 */
@Module
public abstract class AdvanceModule {
    @ViewScoped
    @ContributesAndroidInjector
    abstract AdvanceActivity advanceActivity();

    @ActivityScoped
    @Binds
    abstract AdvanceContract.Presenter advancePresenter(AdvancePresenter presenter);
}
