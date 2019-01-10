package com.example.serenadegx.opensource.login2;

import com.example.serenadegx.opensource.base.ActivityScope;
import com.example.serenadegx.opensource.base.BaseRetrofitComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = BaseRetrofitComponent.class)
public interface RetrofitLoginComponent {
    void inject(Login2Presenter presenter);
}
