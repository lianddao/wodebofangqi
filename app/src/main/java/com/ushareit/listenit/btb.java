package com.ushareit.listenit;

import android.annotation.TargetApi;
import android.os.Trace;

public final class btb {
    public static void m9756a(String str) {
        if (btc.f7662a >= 18) {
            m9758b(str);
        }
    }

    public static void m9755a() {
        if (btc.f7662a >= 18) {
            m9757b();
        }
    }

    @TargetApi(18)
    private static void m9758b(String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void m9757b() {
        Trace.endSection();
    }
}
