package com.example.serenadegx.opensource;

public interface BasePresenter<T> {
    void takeView(T view);

    void dropView();
}
