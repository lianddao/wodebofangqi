package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;

final class eta extends faw {
    final /* synthetic */ Context f11746a;
    final /* synthetic */ String f11747b;
    final /* synthetic */ HashMap f11748c;
    final /* synthetic */ exz f11749d;
    final /* synthetic */ String f11750e;

    eta(String str, Context context, String str2, HashMap hashMap, exz com_ushareit_listenit_exz, String str3) {
        this.f11746a = context;
        this.f11747b = str2;
        this.f11748c = hashMap;
        this.f11749d = com_ushareit_listenit_exz;
        this.f11750e = str3;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2289a(this.f11746a, this.f11747b, this.f11748c);
            }
        }
        this.f11749d.m17997b(this.f11750e, true);
        exw.m18449b("Stats", "onOnceEvent(): " + this.f11747b + ", info = " + this.f11748c.toString());
    }
}
