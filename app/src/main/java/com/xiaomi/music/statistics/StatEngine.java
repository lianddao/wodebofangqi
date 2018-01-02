package com.xiaomi.music.statistics;

import android.content.Context;
import java.util.List;
import java.util.Map;

public interface StatEngine {
    public static final String CONFIG_DEVICE = "device";
    public static final String CONFIG_SUB_PLATFORM = "subplatform";
    public static final String PARAM_ACCOUNT = "account";
    public static final String PARAM_APK_VERSION = "apk_version";
    public static final String PARAM_DEVICE = "device";
    public static final String PARAM_IMEI = "imei";
    public static final String PARAM_LANGUAGE = "language";
    public static final String PARAM_SDK_VERSION = "sdk_version";
    public static final String PARAM_SYSTEM_VERSION = "sys_verversion";

    void applyTrackEvent(Context context, MusicTrackEvent musicTrackEvent);

    void applyTrackEvents(Context context, List<MusicTrackEvent> list);

    MusicTrackEvent createTrackEvent(String str);

    Map<String, String> getVersionParams(Context context);

    String getVersionParamsAsStr(Context context);

    long uploadPlayDuration(Context context, long j);
}
