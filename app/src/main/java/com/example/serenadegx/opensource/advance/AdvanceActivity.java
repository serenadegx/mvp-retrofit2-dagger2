package com.example.serenadegx.opensource.advance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.serenadegx.opensource.R;
import com.example.serenadegx.opensource.di.ActivityScoped;
import com.example.serenadegx.opensource.login2.Login2Result;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

@ActivityScoped
public class AdvanceActivity extends DaggerActivity implements AdvanceContract.View {
    @Inject
    AdvanceContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout tilPhone = findViewById(R.id.til_phone);
        TextInputLayout tilPwd = findViewById(R.id.til_pwd);
        final TextInputEditText etPhone = findViewById(R.id.et_phone);
        final TextInputEditText etPwd = findViewById(R.id.et_pwd);
        etPhone.setText("13356892296");
        etPwd.setText("a123456");
        Button btSure = findViewById(R.id.bt_sure);

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(etPhone.getText().toString(), etPwd.getText().toString());
            }
        });
    }

    @Override
    protected void onResume() {
        presenter.takeView(this);
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.dropView();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void serverError(int code) {

    }

    @Override
    public void netWorkError() {

    }

    @Override
    public void loginSuccess(Login2Result data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
    }


    @Override
    public void unregistered() {

    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static void start2AdvanceActivity(Context context) {
        context.startActivity(new Intent(context, AdvanceActivity.class));
    }
}
