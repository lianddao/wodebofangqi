package com.ushareit.listenit;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

class csl implements Callable<List<? extends cux>> {
    static final /* synthetic */ boolean f8879a = (!csd.class.desiredAssertionStatus());
    final /* synthetic */ cqh f8880b;
    final /* synthetic */ csd f8881c;

    csl(csd com_ushareit_listenit_csd, cqh com_ushareit_listenit_cqh) {
        this.f8881c = com_ushareit_listenit_csd;
        this.f8880b = com_ushareit_listenit_cqh;
    }

    public List<? extends cux> m12531a() {
        csc com_ushareit_listenit_csc;
        cxa com_ushareit_listenit_cxa;
        csc com_ushareit_listenit_csc2;
        cut com_ushareit_listenit_cut;
        cvg a = this.f8880b.mo1582a();
        cqq a2 = a.m13002a();
        cxa com_ushareit_listenit_cxa2 = null;
        cqq com_ushareit_listenit_cqq = a2;
        cui d = this.f8881c.f8845b;
        boolean z = false;
        while (!d.m12753d()) {
            boolean z2;
            cxa com_ushareit_listenit_cxa3;
            com_ushareit_listenit_csc = (csc) d.m12746b();
            if (com_ushareit_listenit_csc != null) {
                if (com_ushareit_listenit_cxa2 == null) {
                    com_ushareit_listenit_cxa2 = com_ushareit_listenit_csc.m12469a(com_ushareit_listenit_cqq);
                }
                z2 = z || com_ushareit_listenit_csc.m12476c();
                com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa2;
            } else {
                z2 = z;
                com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa2;
            }
            d = d.m12742a(com_ushareit_listenit_cqq.m12347h() ? cwc.m13139a("") : com_ushareit_listenit_cqq.m12343d());
            com_ushareit_listenit_cqq = com_ushareit_listenit_cqq.m12344e();
            com_ushareit_listenit_cxa2 = com_ushareit_listenit_cxa3;
            z = z2;
        }
        com_ushareit_listenit_csc = (csc) this.f8881c.f8845b.m12754e(a2);
        csc com_ushareit_listenit_csc3;
        boolean z3;
        if (com_ushareit_listenit_csc == null) {
            com_ushareit_listenit_csc = new csc(this.f8881c.f8851h);
            this.f8881c.f8845b = this.f8881c.f8845b.m12741a(a2, (Object) com_ushareit_listenit_csc);
            com_ushareit_listenit_csc3 = com_ushareit_listenit_csc;
            com_ushareit_listenit_cxa = com_ushareit_listenit_cxa2;
            z3 = z;
            com_ushareit_listenit_csc2 = com_ushareit_listenit_csc3;
        } else {
            z = z || com_ushareit_listenit_csc.m12476c();
            if (com_ushareit_listenit_cxa2 == null) {
                com_ushareit_listenit_cxa2 = com_ushareit_listenit_csc.m12469a(cqq.m12332a());
            }
            com_ushareit_listenit_csc3 = com_ushareit_listenit_csc;
            com_ushareit_listenit_cxa = com_ushareit_listenit_cxa2;
            z3 = z;
            com_ushareit_listenit_csc2 = com_ushareit_listenit_csc3;
        }
        this.f8881c.f8851h.mo1606b(a);
        if (com_ushareit_listenit_cxa != null) {
            com_ushareit_listenit_cut = new cut(cwt.m13243a(com_ushareit_listenit_cxa, a.m13004c()), true, false);
        } else {
            cut a3 = this.f8881c.f8851h.mo1594a(a);
            if (a3.m12777a()) {
                com_ushareit_listenit_cut = a3;
            } else {
                cxa j = cwr.m13215j();
                Iterator it = this.f8881c.f8845b.m12750c(a2).m12749c().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    csc com_ushareit_listenit_csc4 = (csc) ((cui) entry.getValue()).m12746b();
                    if (com_ushareit_listenit_csc4 != null) {
                        cxa a4 = com_ushareit_listenit_csc4.m12469a(cqq.m12332a());
                        if (a4 != null) {
                            com_ushareit_listenit_cxa = j.mo1631a((cwc) entry.getKey(), a4);
                            j = com_ushareit_listenit_cxa;
                        }
                    }
                    com_ushareit_listenit_cxa = j;
                    j = com_ushareit_listenit_cxa;
                }
                for (cwz com_ushareit_listenit_cwz : a3.m12781c()) {
                    if (!j.mo1633a(com_ushareit_listenit_cwz.m13267c())) {
                        j = j.mo1631a(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d());
                    }
                }
                com_ushareit_listenit_cut = new cut(cwt.m13243a(j, a.m13004c()), false, false);
            }
        }
        boolean b = com_ushareit_listenit_csc2.m12475b(a);
        if (!(b || a.m13006e())) {
            if (f8879a || !this.f8881c.f8848e.containsKey(a)) {
                csu f = this.f8881c.m12478a();
                this.f8881c.f8848e.put(a, f);
                this.f8881c.f8847d.put(f, a);
            } else {
                throw new AssertionError("View does not exist but we have a tag");
            }
        }
        List<? extends cux> a5 = com_ushareit_listenit_csc2.m12471a(this.f8880b, this.f8881c.f8846c.m12579a(a2), com_ushareit_listenit_cut);
        if (!(b || r4)) {
            this.f8881c.m12495a(a, com_ushareit_listenit_csc2.m12468a(a));
        }
        return a5;
    }

    public /* synthetic */ Object call() {
        return m12531a();
    }
}
