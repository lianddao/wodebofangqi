package com.ushareit.listenit;

import android.content.Context;

final class esx extends faw {
    final /* synthetic */ Context f11736a;
    final /* synthetic */ String f11737b;

    esx(String str, Context context, String str2) {
        this.f11736a = context;
        this.f11737b = str2;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2287a(this.f11736a, this.f11737b);
            }
        }
        exw.m18449b("Stats", "onEvent(): " + this.f11737b);
    }
}
