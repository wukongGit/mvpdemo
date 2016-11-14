package com.suncheng.mvpdemo.controller;

import android.support.annotation.NonNull;

import com.suncheng.mvpdemo.base.RxPresenter;
import com.suncheng.mvpdemo.controller.contract.RecommendContract;

/**
 * Description: ClassificationPresenter
 * Creator: yxc
 * date: 2016/9/21 17:55
 */
public class ClassificationPresenter extends RxPresenter implements RecommendContract.Presenter {
    RecommendContract.View mView;
    int page = 0;

    public ClassificationPresenter(@NonNull RecommendContract.View twoView) {
        mView = twoView;
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
