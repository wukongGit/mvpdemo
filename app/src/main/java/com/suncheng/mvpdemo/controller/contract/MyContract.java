package com.suncheng.mvpdemo.controller.contract;

import com.suncheng.mvpdemo.base.BasePresenter;
import com.suncheng.mvpdemo.base.BaseView;

public interface MyContract {

    interface View extends BaseView<Presenter> {
        void showContent();
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void getData();
    }
}
