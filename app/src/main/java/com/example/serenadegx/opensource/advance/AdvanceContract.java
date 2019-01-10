package com.example.serenadegx.opensource.advance;


import com.example.serenadegx.opensource.BasePresenter;
import com.example.serenadegx.opensource.BaseView;
import com.example.serenadegx.opensource.login2.Login2Result;

public interface AdvanceContract {
    interface Presenter extends BasePresenter<View>{
        void login(String account, String pwd);
    }

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void serverError(int code);

        void netWorkError();

        void loginSuccess(Login2Result data);

        void unregistered();

        void loginError(String message);
    }
}
