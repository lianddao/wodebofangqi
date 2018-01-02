package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public class cin {
    public static boolean m11385a() {
        return false;
    }

    @TargetApi(12)
    public static boolean m11386a(Context context, String str) {
        if (!ciu.m11406b()) {
            return false;
        }
        if ("com.google.android.gms".equals(str) && m11385a()) {
            return false;
        }
        try {
            return (dqc.m15265b(context).m15261a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
