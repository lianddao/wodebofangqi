package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class kh {
    static final kk f15612a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f15612a = new km();
        } else if (i >= 18) {
            f15612a = new kl();
        } else if (i >= 14) {
            f15612a = new kj();
        } else if (i >= 11) {
            f15612a = new ki();
        } else {
            f15612a = new kn();
        }
    }

    public static void m24388a(ViewGroup viewGroup, boolean z) {
        f15612a.mo2860a(viewGroup, z);
    }
}
