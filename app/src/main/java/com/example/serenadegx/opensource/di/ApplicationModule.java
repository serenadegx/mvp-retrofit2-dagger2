package com.example.serenadegx.opensource.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * 这是一个Dagger模块。我们使用它将Application类绑定为AppComponent中的上下文,通过使用Dagger Android，
 * 我们不需要将我们的应用实例传递给任何模块，我们只需要将应用程序作为上下文公开。
 * 匕首的优点之一。安卓是你的Application和Activities将被提供到您的图表中。
 * {@link AppComponent}。
 */
@Module
public abstract class ApplicationModule {
//    将Application公开为可注入上下文
    @Binds
    abstract Context bindContext(Application application);
}
