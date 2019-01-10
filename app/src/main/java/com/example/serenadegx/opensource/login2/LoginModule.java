package com.example.serenadegx.opensource.login2;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    private Login2Contract.LoginView mLoginView;

    public LoginModule(Login2Contract.LoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    @Provides
    public Login2Contract.LoginView provideLoginView() {
        return mLoginView;
    }
}
