package com.miui.player.util;

import android.content.Context;
import android.net.Uri;
import android.os.SystemProperties;
import com.miui.player.reporter.OnlinePlayStatus;
import java.io.File;
import miui.provider.ExtraSettings.AntiSpam;
import miui.provider.ExtraTelephony;

public class PhoneCompat implements IDeviceCompat {
    public boolean isLPADecode() {
        return SystemProperties.getBoolean("persist.sys.lpa.decode", false);
    }

    public File getMIUIExternalStorageDirectory() {
        return new File(StorageUtils.getMIUIRoot());
    }

    public boolean shouldPauseWhenInComingCall(Context context, String number) {
        if (!AntiSpam.isQuietModeEnable(context)) {
            return true;
        }
        if (!AntiSpam.isVipCallActionEnable(context)) {
            return false;
        }
        if (ExtraTelephony.isVipOfDndm(context, number, false, true)) {
            return true;
        }
        return false;
    }

    public String getSortKey(String displayName) {
        return LocaleSortUtils.getSortKey(displayName);
    }

    public boolean supportDolby(Context context) {
        return context.getResources().getBoolean(101253139);
    }

    public void trackDownloadEvent(Context context, String xiaomiId, String onlineId, String url, int bitRate, boolean isSuccess, String errorMessage) {
        MusicAnalyticsUtils.trackDownloadEvent(context, xiaomiId, onlineId, url, bitRate, isSuccess, errorMessage);
    }

    public void trackSkipEvent(Context context, OnlinePlayStatus playStatus) {
        MusicAnalyticsUtils.trackSkipEvent(context, playStatus);
    }

    public String toSafeString(Uri uri) {
        return uri != null ? uri.toSafeString() : null;
    }
}
