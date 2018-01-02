package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class hc {
    static final hg f15170a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f15170a = new hf();
        } else {
            f15170a = new hd();
        }
    }

    public static boolean m23550a(KeyEvent keyEvent, int i) {
        return f15170a.mo2753a(keyEvent.getMetaState(), i);
    }

    public static boolean m23549a(KeyEvent keyEvent) {
        return f15170a.mo2754b(keyEvent.getMetaState());
    }

    public static void m23551b(KeyEvent keyEvent) {
        f15170a.mo2752a(keyEvent);
    }
}
