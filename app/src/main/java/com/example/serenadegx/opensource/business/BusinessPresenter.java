package com.example.serenadegx.opensource.business;

import android.util.Log;

import com.example.serenadegx.opensource.di.ActivityScoped;

import java.util.HashMap;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
@ActivityScoped
public class BusinessPresenter implements BusinessContract.Presenter {
    private BusinessContract.View mView;

    Retrofit mRetrofit;

    @Inject
    public BusinessPresenter(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    @Override
    public void getBusiness() {
        Log.i("Mango", "Business--retrofit:" + mRetrofit);
        mView.loadDataSuccess();
    }

    @Override
    public void takeView(BusinessContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
