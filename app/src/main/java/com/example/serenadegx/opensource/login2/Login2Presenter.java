package com.example.serenadegx.opensource.login2;

import android.util.Log;

import com.example.serenadegx.opensource.base.BaseApplication;
import com.example.serenadegx.opensource.login.LoginContract;
import com.example.serenadegx.opensource.login.LoginService;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login2Presenter implements Login2Contract.Presenter {
    @Inject
    Retrofit retrofit;

    Login2Contract.LoginView mLoginView;

    @Inject
    public Login2Presenter(Login2Contract.LoginView view) {
        this.mLoginView = view;
        DaggerRetrofitLoginComponent.builder()
                .baseRetrofitComponent(BaseApplication.getComponent())
                .build()
                .inject(this);
    }

    @Override
    public void login(String account, String pwd) {
        Log.i("Mango", "splash--retrofit:" + retrofit);
        Login2Service loginService = retrofit.create(Login2Service.class);
        LoginParams loginParams = new LoginParams(account, pwd);
        Log.i("Mango", "loginParams:" + new Gson().toJson(loginParams, LoginParams.class));
        loginService.login(loginParams).enqueue(new Callback<Login2Result>() {
            @Override
            public void onResponse(Call<Login2Result> call, Response<Login2Result> response) {
                Log.i("Mango", new Gson().toJson(response.body(), Login2Result.class));
                if (mLoginView != null && mLoginView.isActive()) {
                    if (response.isSuccessful()) {
                        Login2Result loginResult = response.body();
                        if ("0".equals(loginResult.getCode())) {
                            mLoginView.loginSuccess(loginResult);
                        } else {
                            mLoginView.loginError(loginResult.getMessage());
                        }
                    } else {
                        mLoginView.serverError(response.code());
                    }
                }
            }

            @Override
            public void onFailure(Call<Login2Result> call, Throwable t) {
                if (mLoginView != null && mLoginView.isActive()) {
                    mLoginView.netWorkError();
                }
            }
        });
    }
}
