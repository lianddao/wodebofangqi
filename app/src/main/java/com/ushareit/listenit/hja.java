package com.ushareit.listenit;

import android.content.Context;

final class hja extends hje {
    final /* synthetic */ Context aj;
    final /* synthetic */ int ak;
    final /* synthetic */ int al;
    final /* synthetic */ int am;

    hja(Context context, int i, int i2, int i3) {
        this.aj = context;
        this.ak = i;
        this.al = i2;
        this.am = i3;
    }

    public void mo2309U() {
        hjc.m23927a(this.aj, this.ak, this.al, false, m18408Y());
        fad.m18688a(this.aj, this.aj.getPackageName(), fql.m20387a(), "update_auto_check", false);
        m1342a();
    }

    public void mo2788g(boolean z) {
        if (z) {
            gvj.m22892a(this.al);
        }
    }

    public void mo2310V() {
        hjc.m23927a(this.aj, this.ak, this.al, true, m18408Y());
        m1342a();
        if ((this.am & 4) != 0) {
            gxt.m23106a(this.aj);
        }
    }
}
