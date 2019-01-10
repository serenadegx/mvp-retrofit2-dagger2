package com.example.serenadegx.opensource.login2;

import com.example.serenadegx.opensource.base.ActivityScope;
import com.example.serenadegx.opensource.base.BaseRetrofitComponent;

import dagger.Component;

@ActivityScope
@Component(modules = LoginModule.class,
        dependencies = BaseRetrofitComponent.class)
public interface LoginComponent {
    /**
     * @param view 不可以传父类
     */
    void inject(Login2Activity view);

    void inject(Login2Presenter presenter);


}
