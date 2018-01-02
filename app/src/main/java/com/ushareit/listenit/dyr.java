package com.ushareit.listenit;

import com.google.android.gms.measurement.internal.AppMetadata;
import java.util.List;
import java.util.concurrent.Callable;

class dyr implements Callable<List<dwj>> {
    final /* synthetic */ AppMetadata f10716a;
    final /* synthetic */ dyk f10717b;

    dyr(dyk com_ushareit_listenit_dyk, AppMetadata appMetadata) {
        this.f10717b = com_ushareit_listenit_dyk;
        this.f10716a = appMetadata;
    }

    public List<dwj> m16495a() {
        this.f10717b.f10695a.m16429K();
        return this.f10717b.f10695a.m16465p().m16091a(this.f10716a.f1886b);
    }

    public /* synthetic */ Object call() {
        return m16495a();
    }
}
