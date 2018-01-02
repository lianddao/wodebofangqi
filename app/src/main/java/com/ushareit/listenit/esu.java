package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;

final class esu extends faw {
    final /* synthetic */ Context f11730a;
    final /* synthetic */ String f11731b;
    final /* synthetic */ HashMap f11732c;

    esu(String str, Context context, String str2, HashMap hashMap) {
        this.f11730a = context;
        this.f11731b = str2;
        this.f11732c = hashMap;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2289a(this.f11730a, this.f11731b, this.f11732c);
            }
        }
        exw.m18449b("Stats", "onRandomEvent(): " + this.f11731b + ", info = " + this.f11732c.toString());
    }
}
