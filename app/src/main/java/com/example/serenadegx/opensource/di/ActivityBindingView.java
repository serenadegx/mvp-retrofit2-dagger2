package com.example.serenadegx.opensource.di;

import com.example.serenadegx.opensource.advance.AdvanceActivity;
import com.example.serenadegx.opensource.advance.AdvanceModule;
import com.example.serenadegx.opensource.business.BusinessActivity;
import com.example.serenadegx.opensource.business.BusinessModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 我们想要的Dagger.Android 创建子组件，该子组件具有ActivityBindingModule所在模块的父组件，在我们的例子中，那将是AppComponent。
 * 这个设置的美妙之处在于，您永远不需要告诉AppComponent它将拥有所有这些子组件,您也不需要告诉这些子组件AppComponent的存在。
 * 我们也在告诉Dagger.Android生成的子组件需要包含指定的模块，并且要知道@ActivityScoped的范围注释
 * 当Dagger.Android annotation processor将为我们创建4个子组件。
 */
@Module
public abstract class ActivityBindingView {
    @ActivityScoped
    @ContributesAndroidInjector(modules = AdvanceModule.class)
    abstract AdvanceActivity advanceActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = BusinessModule.class)
    abstract BusinessActivity businessActivity();

}
