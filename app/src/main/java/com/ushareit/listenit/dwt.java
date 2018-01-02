package com.ushareit.listenit;

import android.os.Looper;

class dwt implements Runnable {
    final /* synthetic */ dws f10491a;

    dwt(dws com_ushareit_listenit_dws) {
        this.f10491a = com_ushareit_listenit_dws;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f10491a.f10411a.m16457h().m16380a((Runnable) this);
            return;
        }
        boolean b = this.f10491a.m15827b();
        this.f10491a.f10413d = 0;
        if (b && this.f10491a.f10414e) {
            this.f10491a.mo2099a();
        }
    }
}
