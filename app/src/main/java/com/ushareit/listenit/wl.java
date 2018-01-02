package com.ushareit.listenit;

import android.os.Handler;
import android.os.Looper;

class wl {
    private boolean f17482a;
    private final Handler f17483b = new Handler(Looper.getMainLooper(), new wn());

    wl() {
    }

    public void m27115a(wk<?> wkVar) {
        afu.m5497a();
        if (this.f17482a) {
            this.f17483b.obtainMessage(1, wkVar).sendToTarget();
            return;
        }
        this.f17482a = true;
        wkVar.mo555d();
        this.f17482a = false;
    }
}
