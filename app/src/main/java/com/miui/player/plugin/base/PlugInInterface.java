package com.miui.player.plugin.base;

public interface PlugInInterface {
    String getName();

    int getVersion();

    void initialize(String str);

    String statistics(boolean z);
}
