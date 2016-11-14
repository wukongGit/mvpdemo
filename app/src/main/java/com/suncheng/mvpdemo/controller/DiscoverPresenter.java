package com.suncheng.mvpdemo.controller;

import android.support.annotation.NonNull;

import com.suncheng.mvpdemo.base.RxPresenter;
import com.suncheng.mvpdemo.controller.contract.DiscoverContract;

/**
 * Description: DiscoverPresenter
 * Creator: yxc
 * date: 2016/9/21 17:55
 */
public class DiscoverPresenter extends RxPresenter implements DiscoverContract.Presenter {
    DiscoverContract.View mView;

    public DiscoverPresenter(@NonNull DiscoverContract.View threeView) {
        mView = threeView;
        mView.setPresenter(this);
    }

    @Override
    public void getData() {
        getNextVideos();
    }

    private void getNextVideos() {
        if (mView.isActive()) {
            mView.showContent();
        }
    }
}
