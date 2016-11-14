package com.suncheng.mvpdemo.ui.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.hintview.IconHintView;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.RootView;
import com.suncheng.mvpdemo.controller.contract.RecommendContract;
import com.suncheng.mvpdemo.model.VideoInfo;
import com.suncheng.mvpdemo.theme.ColorRelativeLayout;
import com.suncheng.mvpdemo.theme.ColorTextView;
import com.suncheng.mvpdemo.ui.adapter.BannerAdapter;
import com.suncheng.mvpdemo.ui.adapter.RecommendAdapter;
import com.suncheng.mvpdemo.utils.EventUtil;
import com.suncheng.mvpdemo.utils.ScreenUtil;
import com.suncheng.mvpdemo.view.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendView extends RootView<RecommendContract.Presenter> implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.title)
    ColorRelativeLayout title;
    RecommendAdapter adapter;
    View headerView;
    RollPagerView banner;

    public RecommendView(Context context) {
        super(context);
    }

    public RecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_recommend_view, this);
    }

    @Override
    protected void initView() {
        title.setVisibility(View.GONE);
        titleName.setText("精选");
        headerView = LayoutInflater.from(mContext).inflate(R.layout.recommend_header, null);
        banner = ButterKnife.findById(headerView, R.id.banner);
        banner.setPlayDelay(2000);
        recyclerView.setAdapterWithProgress(adapter = new RecommendAdapter(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setErrorView(R.layout.view_error);
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void initEvent() {
        title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EventUtil.isFastDoubleClick()) {
                    recyclerView.scrollToPosition(0);
                }
            }
        });
        recyclerView.setRefreshListener(this);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (getHeaderScroll() <= ScreenUtil.dip2px(mContext, 150)) {
                    new Handler().postAtTime(new Runnable() {
                        @Override
                        public void run() {
                            float percentage = (float) getHeaderScroll() / ScreenUtil.dip2px(mContext, 150);
                            title.setAlpha(percentage);
                            if (percentage > 0)
                                title.setVisibility(View.VISIBLE);
                            else
                                title.setVisibility(View.GONE);

                        }
                    }, 300);
                } else {
                    title.setAlpha(1.0f);
                    title.setVisibility(View.VISIBLE);
                }
            }
        });
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
        final List<VideoInfo> top = videoInfos.subList(0, 10);
        if (adapter.getHeaderCount() == 0) {
            adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
                @Override
                public View onCreateView(ViewGroup parent) {
                    banner.setHintView(new IconHintView(getContext(), R.mipmap.ic_page_indicator_focused, R.mipmap.ic_page_indicator, ScreenUtil.dip2px(getContext(), 10)));
                    banner.setHintPadding(0, 0, 0, ScreenUtil.dip2px(getContext(), 8));
                    banner.setAdapter(new BannerAdapter(getContext(), top));
                    return headerView;
                }

                @Override
                public void onBindView(View headerView) {

                }
            });
        }
    }

    private int getHeaderScroll() {
        if (headerView == null) {
            return 0;
        }
        int distance = headerView.getTop();
        distance = Math.abs(distance);
        return distance;
    }

    @Override
    public void onRefresh() {
        mPresenter.onRefresh();
    }
}
