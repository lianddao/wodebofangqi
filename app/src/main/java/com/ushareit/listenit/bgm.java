package com.ushareit.listenit;

import com.google.android.exoplayer2.Format;

class bgm implements Runnable {
    final /* synthetic */ Format f6188a;
    final /* synthetic */ bgj f6189b;

    bgm(bgj com_ushareit_listenit_bgj, Format format) {
        this.f6189b = com_ushareit_listenit_bgj;
        this.f6188a = format;
    }

    public void run() {
        this.f6189b.f6181b.mo920b(this.f6188a);
    }
}
