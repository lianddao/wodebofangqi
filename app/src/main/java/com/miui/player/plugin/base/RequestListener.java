package com.miui.player.plugin.base;

public interface RequestListener<T> {
    void onFinished(String str, String str2, boolean z);

    boolean onPrepared(String str, Parser<T, String> parser);
}
