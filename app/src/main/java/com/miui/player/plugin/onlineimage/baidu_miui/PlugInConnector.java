package com.miui.player.plugin.onlineimage.baidu_miui;

import com.miui.player.meta.ImageSearchInfo;
import com.miui.player.plugin.onlineimage.ImagePlugIn;
import com.miui.player.plugin.onlineimage.ImageProvider;
import java.util.Random;

public class PlugInConnector implements ImagePlugIn {
    public static final int IMAGE_MIUIPROVIDER = 1;
    private static final String NAME = "baidu_miui";
    private static final int PROVIDER_COUNT = 3;
    private static final int THREADHELDS = 10;
    private static final int VERSION = 1;
    private int mCurrentIndex = 0;
    private int mFailedCount = 0;

    public ImageProvider create(ImageSearchInfo info, int type) {
        if (info == null) {
            return null;
        }
        return new MIUIProvider(info);
    }

    public int getVersion() {
        return 1;
    }

    public String statistics(boolean success) {
        if (success) {
            this.mFailedCount = 0;
            return null;
        } else if (this.mFailedCount < 10) {
            this.mFailedCount++;
            return null;
        } else {
            this.mCurrentIndex++;
            this.mFailedCount = 0;
            return String.valueOf(this.mCurrentIndex);
        }
    }

    public void initialize(String config) {
        if (config != null) {
            try {
                this.mCurrentIndex = Integer.valueOf(config).intValue();
                return;
            } catch (NumberFormatException e) {
                return;
            }
        }
        this.mCurrentIndex = new Random(System.currentTimeMillis()).nextInt() % 3;
    }

    public String getName() {
        return NAME;
    }
}
