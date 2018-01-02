package com.miui.player.plugin.base;

public interface Parser<T, S> {
    T parse(S s);
}
