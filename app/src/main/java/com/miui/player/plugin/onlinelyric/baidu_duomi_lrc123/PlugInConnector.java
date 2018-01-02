package com.miui.player.plugin.onlinelyric.baidu_duomi_lrc123;

import android.util.Log;
import com.miui.player.meta.LyricSearchInfo;
import com.miui.player.plugin.onlinelyric.LyricPlugIn;
import com.miui.player.plugin.onlinelyric.LyricProvider;
import java.util.Random;

public class PlugInConnector implements LyricPlugIn {
    private static final String NAME = "baidu_duomi_lrc123";
    private static final int PROVIDER_COUNT = 2;
    private static final String TAG = PlugInConnector.class.getCanonicalName();
    private static final int THREADHELDS = 10;
    private static final int VERSION = 3;
    private int mCurrentIndex = 0;
    private int mFailedCount = 0;

    public LyricProvider create(LyricSearchInfo info) {
        if (info == null) {
            return null;
        }
        int i = this.mCurrentIndex % 2;
        Log.i(TAG, "using provider " + i + ", alread faild " + this.mFailedCount + " times");
        switch (i) {
            case 1:
                return new BaiduTingProvider(info);
            default:
                return new Lrc123Provider(info);
        }
    }

    public int getVersion() {
        return 3;
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
        this.mCurrentIndex = new Random(System.currentTimeMillis()).nextInt() % 2;
    }

    public String getName() {
        return NAME;
    }
}
