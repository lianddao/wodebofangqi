package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;

final class etb extends faw {
    final /* synthetic */ Context f11751a;
    final /* synthetic */ String f11752b;
    final /* synthetic */ HashMap f11753c;

    etb(String str, Context context, String str2, HashMap hashMap) {
        this.f11751a = context;
        this.f11752b = str2;
        this.f11753c = hashMap;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2289a(this.f11751a, this.f11752b, this.f11753c);
            }
        }
        exw.m18449b("Stats", "onEvent(): " + this.f11752b + ", info = " + this.f11753c.toString());
    }
}
