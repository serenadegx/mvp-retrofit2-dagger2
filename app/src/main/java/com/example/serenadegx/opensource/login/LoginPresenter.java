package com.example.serenadegx.opensource.login;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.LoginView mLoginView;

    public LoginPresenter(LoginContract.LoginView view) {
        this.mLoginView = view;
    }

    @Override
    public void login(String account, String pwd) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.10.10.205:7109/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService loginService = retrofit.create(LoginService.class);
        LoginParams loginParams = new LoginParams(account, pwd);
        Log.i("Mango", "loginParams:" + new Gson().toJson(loginParams, LoginParams.class));
        loginService.login(loginParams).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                Log.i("Mango", new Gson().toJson(response.body(), LoginResult.class));
                if (mLoginView != null && mLoginView.isActive()) {
                    if (response.isSuccessful()) {
                        LoginResult loginResult = response.body();
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
            public void onFailure(Call<LoginResult> call, Throwable t) {
                if (mLoginView != null && mLoginView.isActive()) {
                    mLoginView.netWorkError();
                }
            }
        });
    }
}
