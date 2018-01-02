package com.ushareit.listenit;

import android.content.Context;

final class esv extends faw {
    final /* synthetic */ Context f11733a;
    final /* synthetic */ Throwable f11734b;

    esv(String str, Context context, Throwable th) {
        this.f11733a = context;
        this.f11734b = th;
        super(str);
    }

    public void mo2286a() {
        for (etd com_ushareit_listenit_etd : esr.m17822c().f11724d) {
            if (com_ushareit_listenit_etd.m17852b()) {
                com_ushareit_listenit_etd.mo2290a(this.f11733a, this.f11734b);
            }
        }
        exw.m18449b("Stats", "onError(): error = " + this.f11734b.getClass().getSimpleName());
    }
}
