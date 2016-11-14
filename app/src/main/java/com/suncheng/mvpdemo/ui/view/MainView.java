package com.suncheng.mvpdemo.ui.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.suncheng.mvpdemo.MainActivity;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.base.RootView;
import com.suncheng.mvpdemo.controller.contract.MainContract;
import com.suncheng.mvpdemo.theme.ColorRelativeLayout;
import com.suncheng.mvpdemo.ui.adapter.ContentPagerAdapter;
import com.suncheng.mvpdemo.ui.fragments.ClassificationFragment;
import com.suncheng.mvpdemo.ui.fragments.DiscoverFragment;
import com.suncheng.mvpdemo.ui.fragments.MyFragment;
import com.suncheng.mvpdemo.ui.fragments.RecommendFragment;
import com.suncheng.mvpdemo.utils.StringUtils;
import com.suncheng.mvpdemo.view.ResideLayout;
import com.suncheng.mvpdemo.view.UnScrollViewPager;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by suncheng on 2016/11/11.
 */
public class MainView extends RootView<MainContract.Presenter> implements RadioGroup.OnCheckedChangeListener {

    ContentPagerAdapter mPagerAdapter;
    MainActivity mActivity;
    @BindView(R.id.avatar)
    RoundedImageView avatar;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.top_menu)
    LinearLayout topMenu;
    @BindView(R.id.tv_collect)
    TextView tvCollect;
    @BindView(R.id.tv_mydown)
    TextView tvMydown;
    @BindView(R.id.tv_fuli)
    TextView tvFuli;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.theme)
    TextView theme;
    @BindView(R.id.bottom_menu)
    LinearLayout bottomMenu;
    @BindView(R.id.menu)
    ColorRelativeLayout menu;
    @BindView(R.id.vp_content)
    UnScrollViewPager vpContent;
    @BindView(R.id.tab_rb_1)
    RadioButton tabRb1;
    @BindView(R.id.tab_rb_2)
    RadioButton tabRb2;
    @BindView(R.id.tab_rb_3)
    RadioButton tabRb3;
    @BindView(R.id.tab_rb_4)
    RadioButton tabRb4;
    @BindView(R.id.tab_rg_menu)
    RadioGroup tabRgMenu;
    @BindView(R.id.resideLayout)
    ResideLayout resideLayout;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {
        mActivity = (MainActivity) mContext;
        List<Fragment> fragments = initFragments();
        vpContent.setScrollable(false);
        mPagerAdapter = new ContentPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        vpContent.setAdapter(mPagerAdapter);
        vpContent.setOffscreenPageLimit(fragments.size());
        StringUtils.setIconDrawable(mContext, tvCollect, MaterialDesignIconic.Icon.gmi_collection_bookmark, 16, 10);
        StringUtils.setIconDrawable(mContext, tvMydown, MaterialDesignIconic.Icon.gmi_download, 16, 10);
        StringUtils.setIconDrawable(mContext, tvFuli, MaterialDesignIconic.Icon.gmi_mood, 16, 10);
        StringUtils.setIconDrawable(mContext, tvShare, MaterialDesignIconic.Icon.gmi_share, 16, 10);
        StringUtils.setIconDrawable(mContext, tvFeedback, MaterialDesignIconic.Icon.gmi_android, 16, 10);
        StringUtils.setIconDrawable(mContext, tvSetting, MaterialDesignIconic.Icon.gmi_settings, 16, 10);
        StringUtils.setIconDrawable(mContext, about, MaterialDesignIconic.Icon.gmi_account, 16, 10);
        StringUtils.setIconDrawable(mContext, theme, MaterialDesignIconic.Icon.gmi_palette, 16, 10);
    }

    @Override
    protected void initEvent() {
        tabRgMenu.setOnCheckedChangeListener(this);
        vpContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) tabRgMenu.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        resideLayout.setPanelSlideListener(new ResideLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                postBannerState(true);
            }

            @Override
            public void onPanelOpened(View panel) {
                postBannerState(true);
            }

            @Override
            public void onPanelClosed(View panel) {
                postBannerState(false);
            }
        });
    }

    private void postBannerState(final boolean stop) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                EventBus.getDefault().post(stop, Banner_Stop);
//            }
//        }, WAIT_TIME);
    }

    private List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment1 = new RecommendFragment();
        Fragment fragment2 = new ClassificationFragment();
        Fragment fragment3 = new DiscoverFragment();
        Fragment mineFragment = new MyFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(mineFragment);
        return fragments;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.tab_rb_1:
                vpContent.setCurrentItem(0, false);
                break;
            case R.id.tab_rb_2:
                vpContent.setCurrentItem(1, false);
                break;
            case R.id.tab_rb_3:
                vpContent.setCurrentItem(2, false);
                break;
            case R.id.tab_rb_4:
                vpContent.setCurrentItem(3, false);
                break;
        }
    }

    @OnClick({R.id.avatar, R.id.desc, R.id.top_menu, R.id.tv_collect, R.id.tv_mydown, R.id.tv_fuli, R.id.tv_share, R.id.tv_feedback, R.id.tv_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.avatar:
                break;
            case R.id.desc:
                break;
            case R.id.top_menu:
                break;
            case R.id.tv_collect:
                break;
            case R.id.tv_mydown:
                break;
            case R.id.tv_fuli:
                break;
            case R.id.tv_share:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.tv_setting:
                break;
        }
    }

    @Subscriber(tag = MyFragment.SET_THEME)
    public void setTheme(String content) {
        Toast.makeText(mContext, "主题" +content, Toast.LENGTH_SHORT).show();
        int selectedColor = getResources().getColor(R.color.colorBluePrimary);
        if(content.equals("change_theme_blue")) {
            selectedColor = getResources().getColor(R.color.colorBluePrimary);
        } else if(content.equals("change_theme_red")) {
            selectedColor = getResources().getColor(R.color.colorRedPrimary);
        } else if(content.equals("change_theme_brown")) {
            selectedColor = getResources().getColor(R.color.colorBrownPrimary);
        } else if(content.equals("change_theme_green")) {
            selectedColor = getResources().getColor(R.color.colorGreenPrimary);
        } else if(content.equals("change_theme_purple")) {
            selectedColor = getResources().getColor(R.color.colorPurplePrimary);
        }

        mActivity.onColorSelection(selectedColor);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }
}
