package com.ushareit.listenit;

import android.app.Service;
import android.graphics.Bitmap;

final class gnr extends hhv {
    final /* synthetic */ Service f14477a;
    final /* synthetic */ glg f14478b;
    final /* synthetic */ Bitmap f14479c;
    final /* synthetic */ boolean f14480d;

    gnr(String str, Service service, glg com_ushareit_listenit_glg, Bitmap bitmap, boolean z) {
        this.f14477a = service;
        this.f14478b = com_ushareit_listenit_glg;
        this.f14479c = bitmap;
        this.f14480d = z;
        super(str);
    }

    public void e_() {
        gnp.m22543d(this.f14477a, this.f14478b, this.f14479c, this.f14480d);
    }
}
