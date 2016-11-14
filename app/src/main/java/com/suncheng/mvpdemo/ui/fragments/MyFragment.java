package com.suncheng.mvpdemo.ui.fragments;

import android.view.LayoutInflater;

import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.BaseFragment;
import com.suncheng.mvpdemo.controller.MyPresenter;
import com.suncheng.mvpdemo.ui.view.MyView;

import butterknife.BindView;

public class MyFragment extends BaseFragment {
    public static final String SET_THEME = "SET_THEME";

    @BindView(R.id.four_view)
    MyView fourView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new MyPresenter(fourView);
    }

    @Override
    protected void lazyFetchData() {
        ((MyPresenter) mPresenter).getData();
    }
}
