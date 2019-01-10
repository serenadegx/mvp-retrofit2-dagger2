package com.example.serenadegx.opensource.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("mdd-papp-web/base/web/login")
    Call<LoginResult> login(@Body LoginParams params);
}
