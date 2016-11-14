package com.suncheng.mvpdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daprlabs.cardstack.SwipeFrameLayout;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.RootView;
import com.suncheng.mvpdemo.controller.contract.DiscoverContract;
import com.suncheng.mvpdemo.model.VideoInfo;
import com.suncheng.mvpdemo.theme.ColorRelativeLayout;
import com.suncheng.mvpdemo.theme.ColorTextView;
import com.suncheng.mvpdemo.ui.adapter.SwipeDeckAdapter;
import com.suncheng.mvpdemo.utils.ScreenUtil;
import com.suncheng.mvpdemo.view.LVGhost;
import com.suncheng.mvpdemo.view.SwipeDeck;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DiscoverView extends RootView<DiscoverContract.Presenter> implements DiscoverContract.View {

    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.tv_nomore)
    TextView tvNomore;
    @BindView(R.id.swipe_deck)
    SwipeDeck swipeDeck;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.swipeLayout)
    SwipeFrameLayout swipeLayout;
    @BindView(R.id.loading)
    LVGhost loading;

    private SwipeDeckAdapter adapter;
    private List<VideoInfo> videos = new ArrayList<>();

    public DiscoverView(Context context) {
        super(context);
    }

    public DiscoverView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_discover_view, this);
    }

    @Override
    protected void initView() {
        titleName.setText("发现");
        ViewGroup.LayoutParams lp = swipeDeck.getLayoutParams();
        lp.height = ScreenUtil.getScreenHeight(getContext()) / 3 * 2;
        swipeDeck.setLayoutParams(lp);
        swipeDeck.setHardwareAccelerationEnabled(true);
    }

    @Override
    protected void initEvent() {
        swipeDeck.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {

            }

            @Override
            public void cardSwipedRight(int position) {

            }

            @Override
            public void cardsDepleted() {
                swipeDeck.setVisibility(View.GONE);
            }

            @Override
            public void cardActionDown() {

            }

            @Override
            public void cardActionUp() {

            }
        });
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent() {
        videos.clear();
        List<VideoInfo> videoInfos = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            VideoInfo info = new VideoInfo();
            videoInfos.add(info);
        }
        hideLoading();
        videos.addAll(videoInfos);
        swipeDeck.removeAllViews();
        adapter = new SwipeDeckAdapter(videos, getContext());
        swipeDeck.setAdapter(adapter);
        tvNomore.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(GONE);
    }

    @Override
    public void setPresenter(DiscoverContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
