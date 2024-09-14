package com.demo.aigirlfriend.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.aigirlfriend.HelperResizer;
import com.demo.aigirlfriend.R;

public class SendOutHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public TextView mTvContent;

    public SendOutHolder(View view) {
        super(view);
        this.mTvContent = (TextView) view.findViewById(R.id.mTvContent);
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
        HelperResizer.getheightandwidth(view.getContext());
        HelperResizer.setSize(this.imageView, 122, 122, true);
    }
}
