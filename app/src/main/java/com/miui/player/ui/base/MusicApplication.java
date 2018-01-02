package com.miui.player.ui.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.miui.player.airkan.AirkanConfig.Filter;
import com.miui.player.airkan.DeviceController;
import com.miui.player.util.PreferenceCache;
import com.xiaomi.micloudsdk.request.Request;
import com.xiaomi.music.util.MusicLog;
import com.xiaomi.music.util.NetworkUtil;
import miui.provider.ExtraSettings.Secure;

public class MusicApplication extends Application {
    public static final boolean IS_STRICT_MODE = false;
    public static final String TAG = "MusicApplication";
    private static volatile MusicApplication sContext;

    public MusicApplication() {
        MusicLog.m399i(TAG, "MusicApplication constructed!");
        sContext = this;
    }

    public void onCreate() {
        super.onCreate();
        boolean z = (PreferenceCache.getPrefAsBoolean(this, PreferenceCache.PREF_ENABLE_CONNECT_NETWORK_ALERT) && Secure.isCtaSupported(getContentResolver())) ? false : true;
        NetworkUtil.setNetworkAllow(z);
        DeviceController.instance().initialize(this, new Filter());
        ApplicationHelper.instance().onApplicationCreate(this);
        Request.init(this);
    }

    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ApplicationHelper.instance().onTrimMemory(level);
        Log.w(TAG, "onTrimMemory is called, level=" + level);
    }

    public static Context getApplication() {
        return sContext;
    }
}
