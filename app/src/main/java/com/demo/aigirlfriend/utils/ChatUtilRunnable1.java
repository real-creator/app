package com.demo.aigirlfriend.utils;

import com.demo.aigirlfriend.event.UpdateChatLiteEvent;

public final class ChatUtilRunnable1 implements Runnable {
    public static final ChatUtilRunnable1 INSTANCE = new ChatUtilRunnable1();

    private ChatUtilRunnable1() {
    }

    @Override
    public void run() {
        UpdateChatLiteEvent.post();
    }
}
