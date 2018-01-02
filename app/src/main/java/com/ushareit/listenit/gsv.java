package com.ushareit.listenit;

import android.view.inputmethod.InputMethodManager;

class gsv implements Runnable {
    final /* synthetic */ gsq f14681a;

    gsv(gsq com_ushareit_listenit_gsq) {
        this.f14681a = com_ushareit_listenit_gsq;
    }

    public void run() {
        ak m = this.f14681a.m1328m();
        if (m != null) {
            ((InputMethodManager) m.getSystemService("input_method")).showSoftInput(this.f14681a.f14669b, 1);
        }
    }
}
