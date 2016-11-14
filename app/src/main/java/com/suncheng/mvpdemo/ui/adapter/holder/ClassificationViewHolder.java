package com.suncheng.mvpdemo.ui.adapter.holder;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.model.VideoInfo;

/**
 * Description: 专题
 * Creator: yxc
 * date: 2016/9/30 11:06
 */

public class ClassificationViewHolder extends BaseViewHolder<VideoInfo> {
    ImageView imgPicture;
    TextView tv_title;

    public ClassificationViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_found);
        imgPicture = $(R.id.img_video);
        tv_title = $(R.id.tv_title);
        imgPicture.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public void setData(VideoInfo data) {
        ViewGroup.LayoutParams params = imgPicture.getLayoutParams();

        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels / 2;//宽度为屏幕宽度一半
//        int height = data.getHeight()*width/data.getWidth();//计算View的高度

        params.height = (int) (width / 1.8);
        imgPicture.setLayoutParams(params);
    }
}
