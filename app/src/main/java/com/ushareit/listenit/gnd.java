package com.ushareit.listenit;

import android.graphics.Bitmap;

class gnd implements Runnable {
    final /* synthetic */ Bitmap f14442a;
    final /* synthetic */ gnc f14443b;

    gnd(gnc com_ushareit_listenit_gnc, Bitmap bitmap) {
        this.f14443b = com_ushareit_listenit_gnc;
        this.f14442a = bitmap;
    }

    public void run() {
        this.f14443b.f14441a.f16033c.setImageBitmap(this.f14442a);
        this.f14443b.f14441a.m25212a();
    }
}
