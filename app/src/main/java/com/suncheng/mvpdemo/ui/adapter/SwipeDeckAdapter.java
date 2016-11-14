package com.suncheng.mvpdemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.suncheng.mvpdemo.R;
import com.suncheng.mvpdemo.model.VideoInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description: SwipeDeckAdapter
 * Creator: yxc
 * date: 2016/9/30 11:10
 */
public class SwipeDeckAdapter extends BaseAdapter {

    private List<VideoInfo> data;
    private Context context;
    private LayoutInflater inflater;

    public SwipeDeckAdapter(List<VideoInfo> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void refresh(List<VideoInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.offer_image)
        RoundedImageView offerImage;
        @BindView(R.id.tv_introduction)
        TextView tvIntroduction;
        @BindView(R.id.card_view)
        android.support.v7.widget.CardView cardView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}