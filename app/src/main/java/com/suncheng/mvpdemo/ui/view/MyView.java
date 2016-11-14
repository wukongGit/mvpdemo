package com.suncheng.mvpdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.RootView;
import com.suncheng.mvpdemo.controller.contract.MyContract;
import com.suncheng.mvpdemo.theme.ColorRelativeLayout;
import com.suncheng.mvpdemo.theme.ColorTextView;
import com.suncheng.mvpdemo.ui.fragments.MyFragment;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class MyView extends RootView<MyContract.Presenter> implements MyContract.View {

    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.change_theme_blue)
    Button changeThemeBlue;
    @BindView(R.id.change_theme_red)
    Button changeThemeRed;
    @BindView(R.id.change_theme_brown)
    Button changeThemeBrown;
    @BindView(R.id.change_theme_green)
    Button changeThemeGreen;
    @BindView(R.id.change_theme_purple)
    Button changeThemePurple;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_my_view, this);
    }

    @Override
    protected void initView() {
        titleName.setText("我的");
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(MyContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showContent() {

    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @OnClick({R.id.change_theme_blue, R.id.change_theme_red, R.id.change_theme_brown, R.id.change_theme_green, R.id.change_theme_purple})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_theme_blue:
                EventBus.getDefault().post("change_theme_blue", MyFragment.SET_THEME);
                break;
            case R.id.change_theme_red:
                EventBus.getDefault().post("change_theme_red", MyFragment.SET_THEME);
                break;
            case R.id.change_theme_brown:
                EventBus.getDefault().post("change_theme_brown", MyFragment.SET_THEME);
                break;
            case R.id.change_theme_green:
                EventBus.getDefault().post("change_theme_green", MyFragment.SET_THEME);
                break;
            case R.id.change_theme_purple:
                EventBus.getDefault().post("change_theme_purple", MyFragment.SET_THEME);
                break;
        }
    }
}
