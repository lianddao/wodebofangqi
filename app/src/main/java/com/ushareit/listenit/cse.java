package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

class cse implements Callable<List<? extends cux>> {
    final /* synthetic */ boolean f8854a;
    final /* synthetic */ cqq f8855b;
    final /* synthetic */ cxa f8856c;
    final /* synthetic */ long f8857d;
    final /* synthetic */ cxa f8858e;
    final /* synthetic */ boolean f8859f;
    final /* synthetic */ csd f8860g;

    cse(csd com_ushareit_listenit_csd, boolean z, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, long j, cxa com_ushareit_listenit_cxa2, boolean z2) {
        this.f8860g = com_ushareit_listenit_csd;
        this.f8854a = z;
        this.f8855b = com_ushareit_listenit_cqq;
        this.f8856c = com_ushareit_listenit_cxa;
        this.f8857d = j;
        this.f8858e = com_ushareit_listenit_cxa2;
        this.f8859f = z2;
    }

    public List<? extends cux> m12524a() {
        if (this.f8854a) {
            this.f8860g.f8851h.mo1601a(this.f8855b, this.f8856c, this.f8857d);
        }
        this.f8860g.f8846c.m12586a(this.f8855b, this.f8858e, Long.valueOf(this.f8857d), this.f8859f);
        return !this.f8859f ? Collections.emptyList() : this.f8860g.m12487a(new cto(ctm.f8954a, this.f8855b, this.f8858e));
    }

    public /* synthetic */ Object call() {
        return m12524a();
    }
}
