package com.suncheng.mvpdemo.controller;

import android.support.annotation.NonNull;

import com.suncheng.mvpdemo.base.RxPresenter;
import com.suncheng.mvpdemo.controller.contract.DiscoverContract;
import com.suncheng.mvpdemo.controller.contract.MyContract;

/**
 * Description: DiscoverPresenter
 * Creator: yxc
 * date: 2016/9/21 17:55
 */
public class MyPresenter extends RxPresenter implements MyContract.Presenter {
    MyContract.View mView;

    public MyPresenter(@NonNull MyContract.View fourView) {
        mView = fourView;
        mView.setPresenter(this);
    }

    @Override
    public void getData() {
        if (mView.isActive()) {
            mView.showContent();
        }
    }

}
