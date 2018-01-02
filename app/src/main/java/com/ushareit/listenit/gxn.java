package com.ushareit.listenit;

import android.graphics.Bitmap;

final class gxn extends fay {
    final /* synthetic */ Bitmap f14867a;
    final /* synthetic */ int f14868b;
    final /* synthetic */ gxs f14869g;
    private Bitmap f14870h;

    public void mo2280a() {
        if (this.f14867a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f14870h = new gxq().m23103a(this.f14867a, (float) this.f14868b);
            exw.m18443a("BlurUtils", "blurImage: usedTime=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void mo2281a(Exception exception) {
        if (this.f14869g != null) {
            this.f14869g.mo2368a(this.f14870h);
        }
    }
}
