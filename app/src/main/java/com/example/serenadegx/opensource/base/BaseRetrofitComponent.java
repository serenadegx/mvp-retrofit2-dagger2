package com.example.serenadegx.opensource.base;

import com.example.serenadegx.opensource.login2.LoginModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = BaseRetrofitModule.class)
public interface BaseRetrofitComponent {
    Retrofit provideRetrofit();
}
