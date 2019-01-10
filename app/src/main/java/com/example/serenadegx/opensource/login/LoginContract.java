package com.example.serenadegx.opensource.login;

public interface LoginContract {
    interface LoginView {
        boolean isActive();

        void serverError(int code);

        void netWorkError();

        void loginSuccess(LoginResult data);

        void unregistered();

        void loginError(String message);

        void showLoading();
        void hideLoading();
    }

    interface Presenter {
        void login(String account, String pwd);
    }
}
