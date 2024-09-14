package com.demo.aigirlfriend.db;

import org.litepal.crud.LitePalSupport;

public class ChatLite extends LitePalSupport {
    public String mMessageId;
    public String mMsg;
    public int mMsgType;
    public long mTime;

    @Override
    public long getBaseObjId() {
        return super.getBaseObjId();
    }
}
