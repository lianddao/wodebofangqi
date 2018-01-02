package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

class btp implements Runnable {
    final /* synthetic */ Format f7731a;
    final /* synthetic */ btm f7732b;

    btp(btm com_ushareit_listenit_btm, Format format) {
        this.f7732b = com_ushareit_listenit_btm;
        this.f7731a = format;
    }

    public void run() {
        this.f7732b.f7724b.mo915a(this.f7731a);
    }
}
