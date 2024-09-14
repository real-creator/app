package com.demo.aigirlfriend.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.demo.aigirlfriend.HelperResizer;
import com.demo.aigirlfriend.MainActivity;
import com.demo.aigirlfriend.adapter.ChatListAdapter;
import com.demo.aigirlfriend.databinding.FragmentChatBinding;
import com.demo.aigirlfriend.db.HistoryLite;
import com.demo.aigirlfriend.utils.ChatUtil;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;
    private ChatListAdapter mAdapter;
    private ImageView mImageCrown;
    List<String> obtainChats1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ChatListAdapter chatListAdapter = this.mAdapter;
        if (chatListAdapter != null) {
            chatListAdapter.notifyDataSetChanged();
        }
        showChatList();
    }

    private void showChatList() {
        final List<HistoryLite> obtainChats = ChatUtil.obtainChats();
        this.obtainChats1 = new ArrayList();
        Log.d("TAG", "showChatList: " + obtainChats.size());
        if (this.mAdapter == null) {
            this.binding.mRvChats.setLayoutManager(new LinearLayoutManager(requireContext()));
            for (int i = 0; i < obtainChats.size(); i++) {
                if (obtainChats.get(i).mChats.size() > 1) {
                    if (this.obtainChats1.size() == 0) {
                        this.obtainChats1.add(obtainChats.get(i).mName);
                    } else {
                        for (int i2 = 0; i2 < this.obtainChats1.size(); i2++) {
                            if (!obtainChats.get(i).mName.equalsIgnoreCase(this.obtainChats1.get(i2))) {
                                this.obtainChats1.add(obtainChats.get(i).mName);
                            }
                        }
                    }
                }
            }
            Log.d("TAG", "showChatList: " + obtainChats.size());
            if (this.obtainChats1.size() == 0) {
                this.binding.mRvChats.setVisibility(8);
                this.binding.conLoadLayout.setVisibility(0);
                HelperResizer.getheightandwidth(requireContext());
                HelperResizer.setSize(this.binding.imgLogo, 494, 499, true);
            } else {
                this.binding.mRvChats.setVisibility(0);
                this.binding.conLoadLayout.setVisibility(8);
            }
            ChatListAdapter chatLadpter = new ChatListAdapter(obtainChats, requireContext(), this.obtainChats1) {
                @Override
                public void onItemClick(final int i) {
                    super.onItemClick(i);
                    ChatUtil.setEditHistory((HistoryLite) obtainChats.get(i));
                    ChatActivity.chat(ChatFragment.this.requireContext());
                    MainActivity.intentClick = 0;
                }
            };
            this.mAdapter = chatLadpter;
            this.binding.mRvChats.setAdapter(chatLadpter);
        }
    }

    @Override
    public void onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentChatBinding inflate = FragmentChatBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        return inflate.getRoot();
    }
}
