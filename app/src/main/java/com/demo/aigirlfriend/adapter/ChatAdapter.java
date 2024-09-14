package com.demo.aigirlfriend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.aigirlfriend.R;
import com.demo.aigirlfriend.adapter.holder.ReceiveHolder;
import com.demo.aigirlfriend.adapter.holder.SendOutHolder;
import com.demo.aigirlfriend.db.ChatLite;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ChatLite> mChats;
    private final Context mContext;
    private boolean mReceiving;

    public ChatAdapter(Context context, List<ChatLite> list) {
        this.mContext = context;
        this.mChats = list;
    }

    public void startReceive() {
        this.mReceiving = true;
        ChatLite chatLite = new ChatLite();
        chatLite.mMsg = "";
        chatLite.mMsgType = 1;
        this.mChats.add(chatLite);
        notifyDataSetChanged();
    }

    public boolean isReceiving() {
        return this.mReceiving;
    }

    public void endReceive() {
        this.mReceiving = false;
        List<ChatLite> list = this.mChats;
        if (list != null && list.size() > 0) {
            List<ChatLite> list2 = this.mChats;
            if (list2.get(list2.size() - 1).mMsgType == 1) {
                List<ChatLite> list3 = this.mChats;
                list3.remove(list3.size() - 1);
            }
        }
        notifyDataSetChanged();
    }

    public void updateLastItem(String str) {
        List<ChatLite> list;
        if (this.mReceiving && (list = this.mChats) != null && list.size() > 0) {
            int size = this.mChats.size() - 1;
            ChatLite chatLite = this.mChats.get(size);
            chatLite.mMsg = str;
            this.mChats.set(size, chatLite);
            notifyItemChanged(size);
        }
    }

    public void updateData(List<ChatLite> list) {
        if (list != null) {
            this.mChats = list;
            notifyDataSetChanged();
        }
    }

    public void addNewMsg(ChatLite chatLite) {
        List<ChatLite> list = this.mChats;
        if (list != null) {
            list.add(chatLite);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int i) {
        return this.mChats.get(i).mMsgType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new SendOutHolder(LayoutInflater.from(this.mContext).inflate(R.layout.holder_send_out, viewGroup, false));
        }
        return new ReceiveHolder(LayoutInflater.from(this.mContext).inflate(R.layout.holder_receive, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ChatLite chatLite = this.mChats.get(i);
        if (chatLite.mMsgType == 0) {
            ((SendOutHolder) viewHolder).mTvContent.setText(chatLite.mMsg);
        } else {
            ((ReceiveHolder) viewHolder).mTvContent.setText(chatLite.mMsg);
        }
    }

    @Override
    public int getItemCount() {
        return this.mChats.size();
    }
}
