package com.ushareit.listenit;

import android.os.Handler;

class cna extends cyj {
    final /* synthetic */ cvy f8487a;
    final /* synthetic */ cmz f8488b;

    cna(cmz com_ushareit_listenit_cmz, cvy com_ushareit_listenit_cvy) {
        this.f8488b = com_ushareit_listenit_cmz;
        this.f8487a = com_ushareit_listenit_cvy;
    }

    public void mo1461a(Throwable th) {
        String b = cyj.m11792b(th);
        this.f8487a.m13091a(b, th);
        new Handler(this.f8488b.f8483a.getMainLooper()).post(new cnb(this, b, th));
        m11798d().shutdownNow();
    }
}
