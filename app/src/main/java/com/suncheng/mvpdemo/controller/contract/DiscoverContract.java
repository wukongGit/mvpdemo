package com.suncheng.mvpdemo.controller.contract;

import com.suncheng.mvpdemo.base.BasePresenter;
import com.suncheng.mvpdemo.base.BaseView;

/**
 * Description: RecommendContract
 * Creator: yxc
 * date: 2016/9/21 15:53
 */
public interface DiscoverContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showContent();

        void hideLoading();
    }

    interface Presenter extends BasePresenter {
        void getData();
    }
}
