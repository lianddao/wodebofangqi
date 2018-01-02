package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.View;

public final class C0360j {
    private static final C0361k f15599a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f15599a = new C0363m();
        } else {
            f15599a = new C0362l();
        }
    }

    public static void m24131a(View view) {
        f15599a.mo2865a(view);
    }
}
