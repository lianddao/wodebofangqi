package com.ushareit.listenit;

import android.content.Context;

final class esy extends faw {
    final /* synthetic */ Context f11738a;
    final /* synthetic */ String f11739b;
    final /* synthetic */ String f11740c;

    esy(String str, Context context, String str2, String str3) {
        this.f11738a = context;
        this.f11739b = str2;
        this.f11740c = str3;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2288a(this.f11738a, this.f11739b, this.f11740c);
            }
        }
        exw.m18449b("Stats", "onEvent(): " + this.f11739b + ", label = " + this.f11740c);
    }
}
