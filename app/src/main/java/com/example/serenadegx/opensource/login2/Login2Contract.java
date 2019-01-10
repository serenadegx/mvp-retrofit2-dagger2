package com.example.serenadegx.opensource.login2;

public interface Login2Contract {
    interface LoginView {
        boolean isActive();

        void serverError(int code);

        void netWorkError();

        void loginSuccess(Login2Result data);

        void unregistered();

        void loginError(String message);

        void showLoading();
        void hideLoading();
    }

    interface Presenter {
        void login(String account, String pwd);
    }
}
