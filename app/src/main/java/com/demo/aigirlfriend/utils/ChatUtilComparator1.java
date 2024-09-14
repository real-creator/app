package com.demo.aigirlfriend.utils;

import com.demo.aigirlfriend.db.HistoryLite;
import java.util.Comparator;

public final class ChatUtilComparator1 implements Comparator {
    public static final ChatUtilComparator1 INSTANCE = new ChatUtilComparator1();

    private ChatUtilComparator1() {
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return ChatUtil.ChatUtilComparator1Call((HistoryLite) obj, (HistoryLite) obj2);
    }
}
