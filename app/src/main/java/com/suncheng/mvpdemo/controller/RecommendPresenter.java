package com.suncheng.mvpdemo.controller;

import android.support.annotation.NonNull;

import com.suncheng.mvpdemo.base.RxPresenter;
import com.suncheng.mvpdemo.controller.contract.RecommendContract;

/**
 * Description: RecommendPresenter
 * Creator: yxc
 * date: 2016/9/21 16:26
 */
public class RecommendPresenter extends RxPresenter implements RecommendContract.Presenter {
    RecommendContract.View mView;
    int page = 0;

    public RecommendPresenter(@NonNull RecommendContract.View oneView) {
        mView = oneView;
        mView.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        page = 0;
        getPageHomeInfo();
    }

    private void getPageHomeInfo() {
        if(mView.isActive()) {
            mView.showContent();
        }
    }

}
