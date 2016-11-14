package com.suncheng.mvpdemo.ui.fragments;

import android.view.LayoutInflater;

import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.BaseFragment;
import com.suncheng.mvpdemo.controller.RecommendPresenter;
import com.suncheng.mvpdemo.ui.view.RecommendView;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment {

    @BindView(R.id.one_view)
    RecommendView oneView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new RecommendPresenter(oneView);
    }

    @Override
    protected void lazyFetchData() {
        ((RecommendPresenter) mPresenter).onRefresh();
    }
}
