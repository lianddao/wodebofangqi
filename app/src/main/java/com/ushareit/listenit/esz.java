package com.ushareit.listenit;

import android.content.Context;

final class esz extends faw {
    final /* synthetic */ Context f11741a;
    final /* synthetic */ String f11742b;
    final /* synthetic */ String f11743c;
    final /* synthetic */ exz f11744d;
    final /* synthetic */ String f11745e;

    esz(String str, Context context, String str2, String str3, exz com_ushareit_listenit_exz, String str4) {
        this.f11741a = context;
        this.f11742b = str2;
        this.f11743c = str3;
        this.f11744d = com_ushareit_listenit_exz;
        this.f11745e = str4;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2288a(this.f11741a, this.f11742b, this.f11743c);
            }
        }
        this.f11744d.m17997b(this.f11745e, true);
        exw.m18449b("Stats", "onOnceEvent(): " + this.f11742b + ", label = " + this.f11743c);
    }
}
