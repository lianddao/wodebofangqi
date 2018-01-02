package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class cvh {
    static final /* synthetic */ boolean f9200a = (!cvh.class.desiredAssertionStatus());
    private final cvg f9201b;
    private final cvk f9202c;
    private cvj f9203d;
    private final List<cqh> f9204e = new ArrayList();
    private final cuz f9205f;

    public cvh(cvg com_ushareit_listenit_cvg, cvj com_ushareit_listenit_cvj) {
        this.f9201b = com_ushareit_listenit_cvg;
        cvq com_ushareit_listenit_cvq = new cvq(com_ushareit_listenit_cvg.m13004c());
        cvs q = com_ushareit_listenit_cvg.m13003b().m12999q();
        this.f9202c = new cvk(q);
        cut c = com_ushareit_listenit_cvj.m13021c();
        cut a = com_ushareit_listenit_cvj.m13017a();
        cwt a2 = cwt.m13243a(cwr.m13215j(), com_ushareit_listenit_cvg.m13004c());
        cwt a3 = com_ushareit_listenit_cvq.mo1618a(a2, c.m12782d(), null);
        a2 = q.mo1618a(a2, a.m12782d(), null);
        this.f9203d = new cvj(new cut(a2, a.m12777a(), q.mo1621c()), new cut(a3, c.m12777a(), com_ushareit_listenit_cvq.mo1621c()));
        this.f9205f = new cuz(com_ushareit_listenit_cvg);
    }

    private List<cuw> m13007a(List<cuv> list, cwt com_ushareit_listenit_cwt, cqh com_ushareit_listenit_cqh) {
        List list2;
        if (com_ushareit_listenit_cqh == null) {
            list2 = this.f9204e;
        } else {
            list2 = Arrays.asList(new cqh[]{com_ushareit_listenit_cqh});
        }
        return this.f9205f.m12970a((List) list, com_ushareit_listenit_cwt, list2);
    }

    public cvg m13008a() {
        return this.f9201b;
    }

    public cvi m13009a(ctk com_ushareit_listenit_ctk, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_ctk.m12611e() == ctl.Merge && com_ushareit_listenit_ctk.m12610d().m12622d() != null) {
            if (!f9200a && this.f9203d.m13022d() == null) {
                throw new AssertionError("We should always have a full cache before handling merges");
            } else if (!f9200a && this.f9203d.m13020b() == null) {
                throw new AssertionError("Missing event cache, even though we have a server cache");
            }
        }
        cvj com_ushareit_listenit_cvj = this.f9203d;
        cvn a = this.f9202c.m13033a(com_ushareit_listenit_cvj, com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa);
        if (f9200a || a.f9214a.m13021c().m12777a() || !com_ushareit_listenit_cvj.m13021c().m12777a()) {
            this.f9203d = a.f9214a;
            return new cvi(m13007a(a.f9215b, a.f9214a.m13017a().m12782d(), null), a.f9215b);
        }
        throw new AssertionError("Once a server snap is complete, it should never go back");
    }

    public cxa m13010a(cqq com_ushareit_listenit_cqq) {
        cxa d = this.f9203d.m13022d();
        return (d == null || (!this.f9201b.m13006e() && (com_ushareit_listenit_cqq.m12347h() || d.mo1637c(com_ushareit_listenit_cqq.m12343d()).mo1635b()))) ? null : d.mo1629a(com_ushareit_listenit_cqq);
    }

    public List<cux> m13011a(cqh com_ushareit_listenit_cqh, ece com_ushareit_listenit_ece) {
        cqh com_ushareit_listenit_cqh2;
        List<cux> list;
        if (com_ushareit_listenit_ece != null) {
            List<cux> arrayList = new ArrayList();
            if (f9200a || com_ushareit_listenit_cqh == null) {
                cqq a = this.f9201b.m13002a();
                for (cqh com_ushareit_listenit_cqh22 : this.f9204e) {
                    arrayList.add(new cuu(com_ushareit_listenit_cqh22, com_ushareit_listenit_ece, a));
                }
                list = arrayList;
            } else {
                throw new AssertionError("A cancel should cancel all event registrations");
            }
        }
        list = Collections.emptyList();
        if (com_ushareit_listenit_cqh != null) {
            int i = 0;
            int i2 = -1;
            while (i < this.f9204e.size()) {
                com_ushareit_listenit_cqh22 = (cqh) this.f9204e.get(i);
                if (com_ushareit_listenit_cqh22.mo1585a(com_ushareit_listenit_cqh)) {
                    if (com_ushareit_listenit_cqh22.m12300c()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            i = i2;
            if (i != -1) {
                com_ushareit_listenit_cqh22 = (cqh) this.f9204e.get(i);
                this.f9204e.remove(i);
                com_ushareit_listenit_cqh22.m12299b();
            }
        } else {
            for (cqh com_ushareit_listenit_cqh222 : this.f9204e) {
                com_ushareit_listenit_cqh222.m12299b();
            }
            this.f9204e.clear();
        }
        return list;
    }

    public void m13012a(cqh com_ushareit_listenit_cqh) {
        this.f9204e.add(com_ushareit_listenit_cqh);
    }

    public cxa m13013b() {
        return this.f9203d.m13021c().m12781c();
    }

    public List<cuw> m13014b(cqh com_ushareit_listenit_cqh) {
        cut a = this.f9203d.m13017a();
        List arrayList = new ArrayList();
        for (cwz com_ushareit_listenit_cwz : a.m12781c()) {
            arrayList.add(cuv.m12952a(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d()));
        }
        if (a.m12777a()) {
            arrayList.add(cuv.m12954a(a.m12782d()));
        }
        return m13007a(arrayList, a.m12782d(), com_ushareit_listenit_cqh);
    }

    public cxa m13015c() {
        return this.f9203d.m13017a().m12781c();
    }

    public boolean m13016d() {
        return this.f9204e.isEmpty();
    }
}
