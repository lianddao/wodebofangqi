package com.miui.player.plugin.onlinelyric;

import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123.PlugInConnector;

public interface LyricPlugIn extends PlugInInterface {

    public static class Factory {
        public static LyricPlugIn create() {
            return new PlugInConnector();
        }
    }

    LyricProvider create(LyricSearchInfo lyricSearchInfo);
}
