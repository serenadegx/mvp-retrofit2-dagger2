package com.example.serenadegx.opensource.login2;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login2Service {
    @POST("mdd-papp-web/base/web/login")
    Observable<Login2Result> login(@Body LoginParams params, int i);

    @POST("mdd-papp-web/base/web/login")
    Call<Login2Result> login(@Body LoginParams params);
}
