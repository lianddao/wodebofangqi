package com.miui.player.plugin.onlineimage;

import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.plugin.base.PlugInInterface;
import com.miui.player.plugin.onlineimage.baidu_miui.PlugInConnector;

public interface ImagePlugIn extends PlugInInterface {

    public static class Factory {
        public static ImagePlugIn create() {
            return new PlugInConnector();
        }
    }

    ImageProvider create(ImageSearchInfo imageSearchInfo, int i);
}
