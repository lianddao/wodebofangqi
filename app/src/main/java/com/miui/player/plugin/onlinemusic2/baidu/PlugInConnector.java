package com.miui.player.plugin.onlinemusic2.baidu;

import com.miui.player.plugin.onlinemusic2.OnlineMusicPlugIn;
import com.miui.player.plugin.onlinemusic2.OnlineMusicWorker;
import com.miui.player.provider.PlayerStore;

public class PlugInConnector implements OnlineMusicPlugIn {
    private static final String NAME = PlayerStore.ID_PROVIDER_BAIDU_STR;
    private static final int VERSION = 1;
    private final OnlineMusicWorker mWorker = new BaiduWorker();

    public String getName() {
        return NAME;
    }

    public int getVersion() {
        return 1;
    }

    public void initialize(String config) {
    }

    public String statistics(boolean success) {
        return null;
    }

    public OnlineMusicWorker getWorker() {
        return this.mWorker;
    }
}
