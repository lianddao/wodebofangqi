package com.ushareit.listenit;

import android.view.inputmethod.InputMethodManager;

class gtp implements Runnable {
    final /* synthetic */ gta f14714a;

    gtp(gta com_ushareit_listenit_gta) {
        this.f14714a = com_ushareit_listenit_gta;
    }

    public void run() {
        ak m = this.f14714a.m1328m();
        if (m != null) {
            ((InputMethodManager) m.getSystemService("input_method")).showSoftInput(this.f14714a.an, 1);
        }
    }
}
