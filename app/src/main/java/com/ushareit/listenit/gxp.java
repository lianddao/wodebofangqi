package com.ushareit.listenit;

import android.graphics.Bitmap;

final class gxp extends hhw {
    final /* synthetic */ Bitmap f14876a;
    final /* synthetic */ int f14877b;
    final /* synthetic */ gxs f14878c;
    private Bitmap f14879d = null;

    gxp(String str, Bitmap bitmap, int i, gxs com_ushareit_listenit_gxs) {
        this.f14876a = bitmap;
        this.f14877b = i;
        this.f14878c = com_ushareit_listenit_gxs;
        super(str);
    }

    public void execute() {
        if (this.f14876a != null) {
            this.f14879d = new gxq().m23103a(this.f14876a, (float) this.f14877b);
        }
    }

    public void callback() {
        if (this.f14878c != null) {
            this.f14878c.mo2368a(this.f14879d);
        }
    }
}
