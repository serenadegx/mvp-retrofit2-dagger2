package com.example.serenadegx.opensource.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import retrofit2.Retrofit;

/**
 * 这是Dagger组件。有关Dagger组件的列表，请参阅{@link OpenSourceApp}在本应用程序中使用。
 * 即使Dagger允许将{@link Component}注解为单例，代码本身必须确保只创建类的一个实例。这是在{@link OpenSourceApp}中完成的。
 * {@link AndroidSupportInjectionModule}是Dagger.Android的模块，它帮助生成和定位子组件。
 */
@Singleton
@Component(modules = {RetrofitModule.class,
        ApplicationModule.class,
        ActivityBindingView.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<OpenSourceApp> {

    Retrofit getRetrofit();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
