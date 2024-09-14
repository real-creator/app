package com.demo.aigirlfriend.event;

import org.greenrobot.eventbus.EventBus;

public class UpdateChatLiteEvent {
    public long eventId;

    public static void post() {
        EventBus.getDefault().post(new UpdateChatLiteEvent());
    }
}
