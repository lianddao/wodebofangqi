package com.ushareit.listenit;

import android.graphics.Bitmap;

class gmy implements Runnable {
    final /* synthetic */ Bitmap f14434a;
    final /* synthetic */ gmx f14435b;

    gmy(gmx com_ushareit_listenit_gmx, Bitmap bitmap) {
        this.f14435b = com_ushareit_listenit_gmx;
        this.f14434a = bitmap;
    }

    public void run() {
        this.f14435b.f14433a.f16020c.setImageBitmap(this.f14434a);
        this.f14435b.f14433a.m25202a();
    }
}
