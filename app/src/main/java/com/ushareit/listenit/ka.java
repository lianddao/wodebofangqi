package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ka {
    static final kf f15611a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f15611a = new ke();
        } else if (VERSION.SDK_INT >= 11) {
            f15611a = new kd();
        } else if (VERSION.SDK_INT >= 8) {
            f15611a = new kc();
        } else {
            f15611a = new kb();
        }
    }

    public static int m24383a(ViewConfiguration viewConfiguration) {
        return f15611a.mo2859a(viewConfiguration);
    }
}
