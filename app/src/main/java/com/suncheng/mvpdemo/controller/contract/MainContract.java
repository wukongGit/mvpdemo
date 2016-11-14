package com.suncheng.mvpdemo.controller.contract;

import com.suncheng.mvpdemo.base.BasePresenter;
import com.suncheng.mvpdemo.base.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
    }
}
