package com.miui.player.util;

import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.miui.player.C0329R;
import com.miui.player.ui.base.MusicApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import miui.os.Build;

public class Utils {
    public static final boolean DEBUG = true;
    public static final long[] LONG_EMPTY_ARRAY = new long[0];
    public static final Long[] LONG_EMPTY_OBJ_ARRAY = new Long[0];
    public static final String[] STRING_EMPTY_ARRAY = new String[0];
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Deprecated
    public static void debugLog(String tag, Object msg) {
        Log.d(tag, msg != null ? msg.toString() : "null");
    }

    public static void debugLog(String tag, String format, Object... args) {
        Log.d(tag, String.format(format, args));
    }

    public static boolean isExternalStorageMounted() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String getIMEI() {
        CharSequence ret = ((TelephonyManager) MusicApplication.getApplication().getSystemService("phone")).getDeviceId();
        if (ret != null) {
            return DigestUtils.toHexReadable(DigestUtils.get(ret, DigestUtils.ALGORITHM_SHA_1));
        }
        return "0";
    }

    public static boolean isOutOfTime(long last, long interval) {
        long current = System.currentTimeMillis();
        return last > current || current - last > interval;
    }

    public static boolean isOnlineVaild() {
        if (Build.IS_CM_CUSTOMIZATION) {
            return false;
        }
        return MusicApplication.getApplication().getResources().getBoolean(C0329R.bool.enable_online_music);
    }

    public static boolean isCloudSyncEnable() {
        if (Build.IS_CM_CUSTOMIZATION) {
            return false;
        }
        return MusicApplication.getApplication().getResources().getBoolean(C0329R.bool.enable_cloud_sync);
    }

    public static boolean isSupportID3(String trackPath) {
        if (trackPath == null) {
            return false;
        }
        if (StorageConfig.META_TYPE_MP3.equalsIgnoreCase(FileNameUtils.getFileExtension(trackPath))) {
            return true;
        }
        return false;
    }

    public static boolean isSupportAsRingtone(String trackPath) {
        if (trackPath == null) {
            return false;
        }
        String extension = FileNameUtils.getFileExtension(trackPath);
        if ("ape".equalsIgnoreCase(extension) || "flac".equalsIgnoreCase(extension)) {
            return false;
        }
        return true;
    }

    public static boolean isSupportPriorityStorage() {
        if ((!Build.IS_HONGMI_TWO || Build.IS_HONGMI_TWO_A || Build.IS_HONGMI_TWO_S) && Build.IS_HONGMI) {
            return true;
        }
        return false;
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    public static float clamp(float x, float min, float max) {
        if (x > max) {
            return max;
        }
        return x < min ? min : x;
    }

    public static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(v, max));
    }
}
