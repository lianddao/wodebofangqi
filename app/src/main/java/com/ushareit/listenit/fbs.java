package com.ushareit.listenit;

import android.content.Context;

final class fbs implements Runnable {
    final /* synthetic */ Context f12402a;

    public void run() {
        fbr.m18810a(this.f12402a);
        int a = fbr.m18807a();
        exw.m18449b("RootUtils", "RootUtils_init:" + a);
        if (a != -1 && (a & 2) != 0) {
            fbq.m18802a().m18806a(this.f12402a);
        }
    }
}
