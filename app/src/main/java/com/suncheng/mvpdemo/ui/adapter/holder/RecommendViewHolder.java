package com.suncheng.mvpdemo.ui.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.model.VideoInfo;

/**
 * Description: RecommendViewHolder
 * Creator: yxc
 * date: 2016/9/21 9:53
 */

public class RecommendViewHolder extends BaseViewHolder<VideoInfo> {
    ImageView imgPicture;
    TextView tv_title;

    public RecommendViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_video);
        imgPicture = $(R.id.img_video);
        tv_title = $(R.id.tv_title);
        imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

}
