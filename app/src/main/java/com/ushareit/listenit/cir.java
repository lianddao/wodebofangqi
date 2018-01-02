package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class cir {
    private static Boolean f8355a;
    private static Boolean f8356b;
    private static Boolean f8357c;

    @TargetApi(20)
    public static boolean m11399a(Context context) {
        if (f8357c == null) {
            boolean z = ciu.m11413i() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f8357c = Boolean.valueOf(z);
        }
        return f8357c.booleanValue();
    }

    public static boolean m11400a(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f8355a == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((ciu.m11404a() && z2) || m11401b(resources)) {
                z = true;
            }
            f8355a = Boolean.valueOf(z);
        }
        return f8355a.booleanValue();
    }

    @TargetApi(13)
    private static boolean m11401b(Resources resources) {
        if (f8356b == null) {
            Configuration configuration = resources.getConfiguration();
            boolean z = ciu.m11407c() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
            f8356b = Boolean.valueOf(z);
        }
        return f8356b.booleanValue();
    }
}
