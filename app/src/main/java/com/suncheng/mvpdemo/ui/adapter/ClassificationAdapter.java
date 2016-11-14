package com.suncheng.mvpdemo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.suncheng.mvpdemo.model.VideoInfo;
import com.suncheng.mvpdemo.ui.adapter.holder.ClassificationViewHolder;

/**
 * Description: 专题
 * Creator: yxc
 * date: 2016/9/30 11:07 
 */
public class ClassificationAdapter extends RecyclerArrayAdapter<VideoInfo> {

    public ClassificationAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassificationViewHolder(parent);
    }

}
