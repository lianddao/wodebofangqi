package com.miui.player.plugin.onlinemusic2;

import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlinemusic2.baidu.PlugInConnector;

public interface OnlineMusicPlugIn extends PlugInInterface {

    public static class Factory {
        public static OnlineMusicPlugIn create() {
            return new PlugInConnector();
        }
    }

    OnlineMusicWorker getWorker();
}
