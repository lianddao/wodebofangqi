package com.miui.player.ui.base;

import android.content.Context;
import android.util.Log;
import com.miui.player.asyncplayer.IPlayerHelper;
import com.miui.player.download.IDownloadInfoManager;
import com.miui.player.download.IDownloader;
import com.miui.player.reporter.IPlayerReporter;
import com.miui.player.util.IDeviceCompat;

public abstract class ApplicationHelper {
    static final String TAG = ApplicationHelper.class.getName();
    private static final ApplicationHelper sInstance = newInstance();

    public abstract IDeviceCompat getDeviceCompat();

    public abstract IDownloadInfoManager getDownloadInfoManager();

    public abstract IDownloader getDownloader();

    public abstract IPlayerHelper getPlayerHelper();

    public abstract IPlayerReporter getReporter();

    public abstract Class<?> getServiceClass();

    protected ApplicationHelper() {
    }

    private static ApplicationHelper newInstance() {
        String[] arr$ = new String[]{"com.miui.player.ui.base.PhoneApplicationHelper"};
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            try {
                Class<?> factory = Class.forName(arr$[i$]);
                if (factory != null) {
                    ApplicationHelper helper = (ApplicationHelper) factory.getConstructor(new Class[0]).newInstance(new Object[0]);
                    Log.d(TAG, "Create ApplicationHelper successfully, class=" + helper);
                    return helper;
                }
                i$++;
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        throw new IllegalStateException("Failed to create ApplicationHelper");
    }

    public static ApplicationHelper instance() {
        return sInstance;
    }

    public void onApplicationCreate(Context context) {
    }

    public void onTrimMemory(int level) {
    }
}
