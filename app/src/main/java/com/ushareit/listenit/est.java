package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;

final class est extends faw {
    final /* synthetic */ Class f11726a;
    final /* synthetic */ Context f11727b;
    final /* synthetic */ String f11728c;
    final /* synthetic */ HashMap f11729d;

    est(String str, Class cls, Context context, String str2, HashMap hashMap) {
        this.f11726a = cls;
        this.f11727b = context;
        this.f11728c = str2;
        this.f11729d = hashMap;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b() && this.f11726a.isInstance(com_ushareit_listenit_etd)) {
                com_ushareit_listenit_etd.mo2289a(this.f11727b, this.f11728c, this.f11729d);
            }
        }
        exw.m18449b("Stats", "onSpecialEvent(): " + this.f11728c + ", info = " + this.f11729d.toString());
    }
}
