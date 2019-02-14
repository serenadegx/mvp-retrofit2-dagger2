package com.example.serenadegx.opensource.advance;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.serenadegx.opensource.di.ActivityScoped;
import com.example.serenadegx.opensource.login2.Login2Result;
import com.example.serenadegx.opensource.login2.Login2Service;
import com.example.serenadegx.opensource.login2.LoginParams;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 通过使用{@code @Inject}标记构造函数，Dagger注入所需的依赖项
 * 创建TasksPresenter的实例(如果失败，它会发出编译器错误)。它使用
 * {@link AdvanceModule}这样做。
 * Dagger生成的代码不需要公共访问构造函数或类，因此，为了确保开发人员不会手动实例化类并绕过Dagger，最好的做法是尽可能减少类/构造函数的可见性。
 */
@ActivityScoped
public class AdvancePresenter implements AdvanceContract.Presenter {
    private Retrofit mRetrofit;

    @Nullable
    private AdvanceContract.View mView;

    @Inject
    public AdvancePresenter(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    @Override
    public void login(String account, String pwd) {
//        Log.i("Mango", "login--retrofit:" + mRetrofit);
        Login2Service loginService = mRetrofit.create(Login2Service.class);
        LoginParams loginParams = new LoginParams(account, pwd);
        Log.i("Mango", "loginParams:" + new Gson().toJson(loginParams, LoginParams.class));
        loginService.login(loginParams).enqueue(new Callback<Login2Result>() {
            @Override
            public void onResponse(Call<Login2Result> call, Response<Login2Result> response) {
                Log.i("Mango", new Gson().toJson(response.body(), Login2Result.class));
                if (mView != null && mView.isActive()) {
                    if (response.isSuccessful()) {
                        Login2Result loginResult = response.body();
                        if ("0".equals(loginResult.getCode())) {
                            mView.loginSuccess(loginResult);
                        } else {
                            mView.loginError(loginResult.getMessage());
                        }
                    } else {
                        mView.serverError(response.code());
                    }
                }
            }

            @Override
            public void onFailure(Call<Login2Result> call, Throwable t) {
                if (mView != null && mView.isActive()) {
                    mView.netWorkError();
                }
            }
        });
    }

    @Override
    public void takeView(AdvanceContract.View view) {
        this.mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
