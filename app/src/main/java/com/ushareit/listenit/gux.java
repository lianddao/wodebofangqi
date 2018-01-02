package com.ushareit.listenit;

import android.content.Context;

class gux extends hhv {
    final /* synthetic */ gum f14773a;
    final /* synthetic */ boolean f14774b;
    final /* synthetic */ Context f14775c;
    final /* synthetic */ guw f14776d;

    gux(guw com_ushareit_listenit_guw, gum com_ushareit_listenit_gum, boolean z, Context context) {
        this.f14776d = com_ushareit_listenit_guw;
        this.f14773a = com_ushareit_listenit_gum;
        this.f14774b = z;
        this.f14775c = context;
    }

    public void e_() {
        String a = this.f14776d.m22838b(this.f14773a);
        if (this.f14774b) {
            this.f14776d.m22835a(this.f14773a);
        }
        gvj.m22897a(this.f14775c, a);
        exw.m18443a(hhw.TAG, "savePlayState: playState=" + a);
        this.f14776d.f14771b = false;
    }
}
