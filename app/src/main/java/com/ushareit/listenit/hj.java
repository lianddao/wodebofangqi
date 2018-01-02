package com.ushareit.listenit;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class hj {
    static final hk f15517a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f15517a = new hn();
        } else if (i >= 11) {
            f15517a = new hm();
        } else {
            f15517a = new hl();
        }
    }

    public static void m23919a(LayoutInflater layoutInflater, ht htVar) {
        f15517a.mo2798a(layoutInflater, htVar);
    }
}
