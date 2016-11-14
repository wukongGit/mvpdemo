package com.suncheng.mvpdemo.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.BaseFragment;
import com.suncheng.mvpdemo.controller.ClassificationPresenter;
import com.suncheng.mvpdemo.ui.view.ClassificationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description: ClassificationFragment
 * Creator: yxc
 * date: 2016/9/21 17:45
 */
public class ClassificationFragment extends BaseFragment {

    @BindView(R.id.two_view)
    ClassificationView twoView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_classification;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new ClassificationPresenter(twoView);
    }

    @Override
    protected void lazyFetchData() {
        ((ClassificationPresenter) mPresenter).onRefresh();
    }
}
