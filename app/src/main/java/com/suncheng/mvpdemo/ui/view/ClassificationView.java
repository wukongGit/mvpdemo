package com.suncheng.mvpdemo.ui.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.RootView;
import com.suncheng.mvpdemo.controller.contract.RecommendContract;
import com.suncheng.mvpdemo.model.VideoInfo;
import com.suncheng.mvpdemo.theme.ColorRelativeLayout;
import com.suncheng.mvpdemo.theme.ColorTextView;
import com.suncheng.mvpdemo.ui.adapter.ClassificationAdapter;
import com.suncheng.mvpdemo.utils.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ClassificationView extends RootView<RecommendContract.Presenter> implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    ClassificationAdapter adapter;

    public ClassificationView(Context context) {
        super(context);
    }

    public ClassificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_classification_view, this);
    }

    @Override
    protected void initView() {
        titleName.setText("专题");
        recyclerView.setAdapterWithProgress(adapter = new ClassificationAdapter(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setErrorView(R.layout.view_error);
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(RecommendContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent() {
        adapter.clear();
        List<VideoInfo> videoInfos = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            VideoInfo info = new VideoInfo();
            videoInfos.add(info);
        }
        adapter.addAll(videoInfos);
    }

    @Override
    public void onRefresh() {
        mPresenter.onRefresh();
    }
}
