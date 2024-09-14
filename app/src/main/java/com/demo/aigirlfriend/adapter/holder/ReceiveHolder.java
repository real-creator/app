package com.demo.aigirlfriend.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.demo.aigirlfriend.HelperResizer;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.db.HistoryLite;
import com.demo.aigirlfriend.utils.ChatUtil;

public class ReceiveHolder extends RecyclerView.ViewHolder {
    public TextView mTvContent;

    public ReceiveHolder(View view) {
        super(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.mImageHead);
        HelperResizer.getheightandwidth(view.getContext());
        HelperResizer.setSize(imageView, 122, 122, true);
        HelperResizer.setSize((CardView) view.findViewById(R.id.cardView), 122, 122, true);
        HistoryLite editHistory = ChatUtil.getEditHistory();
        if (editHistory != null) {
            Glide.with(view.getContext()).load(Integer.valueOf(view.getContext().getResources().getIdentifier(editHistory.mPic, "drawable", view.getContext().getPackageName()))).into(imageView);
        }
        this.mTvContent = (TextView) view.findViewById(R.id.mTvContent);
    }
}
