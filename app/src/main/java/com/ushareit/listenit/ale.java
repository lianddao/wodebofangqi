package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import java.util.List;

class ale implements buw {
    final /* synthetic */ Context f4652a;
    final /* synthetic */ alc f4653b;

    ale(alc com_ushareit_listenit_alc, Context context) {
        this.f4653b = com_ushareit_listenit_alc;
        this.f4652a = context;
    }

    public void onContentAdLoaded(buv com_ushareit_listenit_buv) {
        Uri uri = null;
        this.f4653b.f4639c = com_ushareit_listenit_buv;
        this.f4653b.f4643g = true;
        this.f4653b.f4646j = com_ushareit_listenit_buv.mo1797b() != null ? com_ushareit_listenit_buv.mo1797b().toString() : null;
        this.f4653b.f4647k = com_ushareit_listenit_buv.mo1799d() != null ? com_ushareit_listenit_buv.mo1799d().toString() : null;
        this.f4653b.f4649m = com_ushareit_listenit_buv.mo1802g() != null ? com_ushareit_listenit_buv.mo1802g().toString() : null;
        this.f4653b.f4648l = com_ushareit_listenit_buv.mo1801f() != null ? com_ushareit_listenit_buv.mo1801f().toString() : null;
        List c = com_ushareit_listenit_buv.mo1798c();
        alc com_ushareit_listenit_alc = this.f4653b;
        Uri b = (c == null || c.size() <= 0) ? null : ((bup) c.get(0)).mo1762b();
        com_ushareit_listenit_alc.f4644h = b;
        alc com_ushareit_listenit_alc2 = this.f4653b;
        if (com_ushareit_listenit_buv.mo1800e() != null) {
            uri = com_ushareit_listenit_buv.mo1800e().mo1762b();
        }
        com_ushareit_listenit_alc2.f4645i = uri;
        if (this.f4653b.f4640d != null) {
            atz.m7169a(this.f4652a, aut.m7225a(this.f4653b.mo699z()) + " Loaded");
            this.f4653b.f4640d.mo93a(this.f4653b);
        }
    }
}
