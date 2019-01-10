package com.example.serenadegx.opensource.base;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class BaseRetrofitModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://10.10.10.205:7109/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
