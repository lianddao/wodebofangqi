package com.ushareit.listenit;

import android.content.Context;
import android.net.Uri;
import java.util.List;

class ald implements buu {
    final /* synthetic */ Context f4650a;
    final /* synthetic */ alc f4651b;

    ald(alc com_ushareit_listenit_alc, Context context) {
        this.f4651b = com_ushareit_listenit_alc;
        this.f4650a = context;
    }

    public void onAppInstallAdLoaded(but com_ushareit_listenit_but) {
        Uri uri = null;
        this.f4651b.f4639c = com_ushareit_listenit_but;
        this.f4651b.f4643g = true;
        this.f4651b.f4646j = com_ushareit_listenit_but.mo1778b() != null ? com_ushareit_listenit_but.mo1778b().toString() : null;
        this.f4651b.f4647k = com_ushareit_listenit_but.mo1780d() != null ? com_ushareit_listenit_but.mo1780d().toString() : null;
        this.f4651b.f4649m = com_ushareit_listenit_but.mo1784h() != null ? com_ushareit_listenit_but.mo1784h().toString() : null;
        this.f4651b.f4648l = com_ushareit_listenit_but.mo1782f() != null ? com_ushareit_listenit_but.mo1782f().toString() : null;
        List c = com_ushareit_listenit_but.mo1779c();
        alc com_ushareit_listenit_alc = this.f4651b;
        Uri b = (c == null || c.size() <= 0) ? null : ((bup) c.get(0)).mo1762b();
        com_ushareit_listenit_alc.f4644h = b;
        alc com_ushareit_listenit_alc2 = this.f4651b;
        if (com_ushareit_listenit_but.mo1781e() != null) {
            uri = com_ushareit_listenit_but.mo1781e().mo1762b();
        }
        com_ushareit_listenit_alc2.f4645i = uri;
        if (this.f4651b.f4640d != null) {
            atz.m7169a(this.f4650a, aut.m7225a(this.f4651b.mo699z()) + " Loaded");
            this.f4651b.f4640d.mo93a(this.f4651b);
        }
    }
}
