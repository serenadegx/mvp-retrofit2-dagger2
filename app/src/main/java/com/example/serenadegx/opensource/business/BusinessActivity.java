package com.example.serenadegx.opensource.business;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.serenadegx.opensource.di.ActivityScoped;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

@ActivityScoped
public class BusinessActivity extends DaggerActivity implements BusinessContract.View {
    @Inject
    BusinessContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.takeView(this);
        presenter.getBusiness();
    }

    @Override
    public void loadDataSuccess() {
        Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show();
    }

    public static void start2BusinessActivity(Context context) {
        context.startActivity(new Intent(context, BusinessActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
