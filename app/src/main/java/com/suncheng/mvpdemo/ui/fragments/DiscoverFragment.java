package com.suncheng.mvpdemo.ui.fragments;

import android.view.LayoutInflater;

import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.BaseFragment;
import com.suncheng.mvpdemo.controller.DiscoverPresenter;
import com.suncheng.mvpdemo.ui.view.DiscoverView;

import butterknife.BindView;

public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.three_view)
    DiscoverView threeView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new DiscoverPresenter(threeView);
    }

    @Override
    protected void lazyFetchData() {
        ((DiscoverPresenter) mPresenter).getData();
    }
}
