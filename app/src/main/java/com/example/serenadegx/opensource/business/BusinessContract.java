package com.example.serenadegx.opensource.business;

import com.example.serenadegx.opensource.BasePresenter;
import com.example.serenadegx.opensource.BaseView;

public interface BusinessContract {
    interface View extends BaseView<Presenter> {
        void loadDataSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        void getBusiness();
    }
}
