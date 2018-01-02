package com.ushareit.listenit;

import android.content.Context;
import com.umeng.analytics.C0154a;

public final class euw {
    public static exv m18058a(Context context) {
        long a = euo.m18008a(context, "cmd_pd", 14400000);
        return eya.m18461a(context, "COMMAND", a, a / 2);
    }

    public static exv m18059a(Context context, boolean z, boolean z2) {
        long a = euo.m18008a(context, z2 ? "cmd_pd_wifi" : "cmd_pd_mobile", z2 ? 64800000 : 129600000);
        return eya.m18461a(context, "COMMAND", a, a / 2);
    }

    public static exv m18060b(Context context) {
        long a = euo.m18008a(context, "cmd_pd_alarm", (long) C0154a.f2953i);
        return eya.m18461a(context, "COMMAND", a, a / 2);
    }

    public static exv m18061c(Context context) {
        long a = euo.m18008a(context, "cmd_report_sd", 1800000);
        return eya.m18462a(context, "CMDS_REPORT", a, a / 2, euo.m18007a(context, "cmd_report_ct", 30));
    }
}
