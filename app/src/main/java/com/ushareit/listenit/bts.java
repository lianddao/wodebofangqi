package com.ushareit.listenit;

import android.view.Surface;

class bts implements Runnable {
    final /* synthetic */ Surface f7741a;
    final /* synthetic */ btm f7742b;

    bts(btm com_ushareit_listenit_btm, Surface surface) {
        this.f7742b = com_ushareit_listenit_btm;
        this.f7741a = surface;
    }

    public void run() {
        this.f7742b.f7724b.mo914a(this.f7741a);
    }
}
