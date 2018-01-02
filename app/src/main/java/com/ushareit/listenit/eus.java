package com.ushareit.listenit;

import android.content.Context;

public final class eus {
    public static exv m18026a(Context context) {
        long a = euo.m18008a(context, "cfg_pd", 14400000);
        return eya.m18461a(context, "COMMON_CONFIGS", a, a / 2);
    }

    public static exv m18028a(Context context, boolean z, boolean z2) {
        long a = euo.m18008a(context, z2 ? "cfg_pd_wifi" : "cfg_pd_mobile", z2 ? 64800000 : 129600000);
        return eya.m18461a(context, "COMMON_CONFIGS", a, a / 2);
    }

    public static exv m18027a(Context context, String str, long j, long j2) {
        return eya.m18461a(context, str, j, j2);
    }
}
