package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public final class ciy {
    public static boolean m11422a(Context context, int i) {
        boolean z = false;
        if (!m11423a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return cjk.m11438a(context).m11441a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m11423a(Context context, int i, String str) {
        return dqc.m15265b(context).m15263a(i, str);
    }
}
