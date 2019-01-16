package com.example.serenadegx.opensource.business;

import com.example.serenadegx.opensource.di.ActivityScoped;
import com.example.serenadegx.opensource.di.ViewScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * dagger module,我们将视图依赖传递给{@link BusinessPresenter}
 */
@Module
public abstract class BusinessModule {
    @ViewScoped
    @ContributesAndroidInjector
    abstract BusinessActivity businessActivity();

    @ActivityScoped
    @Binds
    abstract BusinessContract.Presenter businessPresenter(BusinessPresenter presenter);
}
