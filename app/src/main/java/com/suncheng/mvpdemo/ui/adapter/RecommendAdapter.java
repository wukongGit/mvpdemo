package com.suncheng.mvpdemo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.suncheng.mvpdemo.model.VideoInfo;
import com.suncheng.mvpdemo.ui.adapter.holder.RecommendViewHolder;

/**
 * Description: 推荐
 * Creator: yxc
 * date: 2016/9/30 11:10
 */
public class RecommendAdapter extends RecyclerArrayAdapter<VideoInfo> {

    public RecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendViewHolder(parent);
    }
}
