package com.miui.player.util;

import android.content.Context;
import android.net.Uri;
import com.miui.player.reporter.OnlinePlayStatus;
import java.io.File;

public interface IDeviceCompat {
    File getMIUIExternalStorageDirectory();

    String getSortKey(String str);

    boolean isLPADecode();

    boolean shouldPauseWhenInComingCall(Context context, String str);

    boolean supportDolby(Context context);

    String toSafeString(Uri uri);

    void trackDownloadEvent(Context context, String str, String str2, String str3, int i, boolean z, String str4);

    void trackSkipEvent(Context context, OnlinePlayStatus onlinePlayStatus);
}
