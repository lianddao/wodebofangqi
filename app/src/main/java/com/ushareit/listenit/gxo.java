package com.ushareit.listenit;

import android.graphics.Bitmap;

final class gxo extends hhw {
    final /* synthetic */ Bitmap f14871a;
    final /* synthetic */ int f14872b;
    final /* synthetic */ int f14873c;
    final /* synthetic */ gxs f14874d;
    private Bitmap f14875e = null;

    gxo(String str, Bitmap bitmap, int i, int i2, gxs com_ushareit_listenit_gxs) {
        this.f14871a = bitmap;
        this.f14872b = i;
        this.f14873c = i2;
        this.f14874d = com_ushareit_listenit_gxs;
        super(str);
    }

    public void execute() {
        if (this.f14871a != null) {
            this.f14875e = new gxq().m23104a(this.f14871a, 30.0f, this.f14872b, this.f14873c);
        }
    }

    public void callback() {
        if (this.f14874d != null) {
            this.f14874d.mo2368a(this.f14875e);
        }
    }
}
