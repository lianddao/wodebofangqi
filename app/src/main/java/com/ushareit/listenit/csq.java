package com.ushareit.listenit;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

class csq implements Callable<List<? extends cux>> {
    final /* synthetic */ boolean f8899a;
    final /* synthetic */ long f8900b;
    final /* synthetic */ boolean f8901c;
    final /* synthetic */ cyh f8902d;
    final /* synthetic */ csd f8903e;

    csq(csd com_ushareit_listenit_csd, boolean z, long j, boolean z2, cyh com_ushareit_listenit_cyh) {
        this.f8903e = com_ushareit_listenit_csd;
        this.f8899a = z;
        this.f8900b = j;
        this.f8901c = z2;
        this.f8902d = com_ushareit_listenit_cyh;
    }

    public List<? extends cux> m12538a() {
        if (this.f8899a) {
            this.f8903e.f8851h.mo1597a(this.f8900b);
        }
        csz a = this.f8903e.f8846c.m12578a(this.f8900b);
        boolean b = this.f8903e.f8846c.m12588b(this.f8900b);
        if (a.m12556f() && !this.f8901c) {
            Map a2 = cru.m12453a(this.f8902d);
            if (a.m12555e()) {
                this.f8903e.f8851h.mo1600a(a.m12552b(), cru.m12451a(a.m12553c(), a2));
            } else {
                this.f8903e.f8851h.mo1598a(a.m12552b(), cru.m12449a(a.m12554d(), a2));
            }
        }
        if (!b) {
            return Collections.emptyList();
        }
        cui a3;
        cui a4 = cui.m12736a();
        if (a.m12555e()) {
            a3 = a4.m12741a(cqq.m12332a(), Boolean.valueOf(true));
        } else {
            Iterator it = a.m12554d().iterator();
            a3 = a4;
            while (it.hasNext()) {
                a3 = a3.m12741a((cqq) ((Entry) it.next()).getKey(), Boolean.valueOf(true));
            }
        }
        return this.f8903e.m12487a(new cth(a.m12552b(), a3, this.f8901c));
    }

    public /* synthetic */ Object call() {
        return m12538a();
    }
}
