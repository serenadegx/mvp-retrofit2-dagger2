package com.example.serenadegx.opensource;

import com.example.serenadegx.opensource.base.ActivityScope;
import com.example.serenadegx.opensource.base.BaseRetrofitComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = BaseRetrofitComponent.class)
public interface SplashComponent {
    void inject(SplashPresenter presenter);
}
