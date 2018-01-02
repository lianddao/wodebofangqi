package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class cwt implements Iterable<cwz> {
    private static final cno<cwz> f9282a = new cno(Collections.emptyList(), null);
    private final cxa f9283b;
    private cno<cwz> f9284c;
    private final cws f9285d;

    private cwt(cxa com_ushareit_listenit_cxa, cws com_ushareit_listenit_cws) {
        this.f9285d = com_ushareit_listenit_cws;
        this.f9283b = com_ushareit_listenit_cxa;
        this.f9284c = null;
    }

    private cwt(cxa com_ushareit_listenit_cxa, cws com_ushareit_listenit_cws, cno<cwz> com_ushareit_listenit_cno_com_ushareit_listenit_cwz) {
        this.f9285d = com_ushareit_listenit_cws;
        this.f9283b = com_ushareit_listenit_cxa;
        this.f9284c = com_ushareit_listenit_cno_com_ushareit_listenit_cwz;
    }

    public static cwt m13242a(cxa com_ushareit_listenit_cxa) {
        return new cwt(com_ushareit_listenit_cxa, cxf.m13282d());
    }

    public static cwt m13243a(cxa com_ushareit_listenit_cxa, cws com_ushareit_listenit_cws) {
        return new cwt(com_ushareit_listenit_cxa, com_ushareit_listenit_cws);
    }

    private void m13244e() {
        if (this.f9284c != null) {
            return;
        }
        if (this.f9285d.equals(cwu.m13253d())) {
            this.f9284c = f9282a;
            return;
        }
        List arrayList = new ArrayList();
        Object obj = null;
        for (cwz com_ushareit_listenit_cwz : this.f9283b) {
            obj = (obj != null || this.f9285d.mo1659a(com_ushareit_listenit_cwz.m13268d())) ? 1 : null;
            arrayList.add(new cwz(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d()));
        }
        if (obj != null) {
            this.f9284c = new cno(arrayList, this.f9285d);
        } else {
            this.f9284c = f9282a;
        }
    }

    public cwc m13245a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cws com_ushareit_listenit_cws) {
        if (this.f9285d.equals(cwu.m13253d()) || this.f9285d.equals(com_ushareit_listenit_cws)) {
            m13244e();
            if (this.f9284c == f9282a) {
                return this.f9283b.mo1634b(com_ushareit_listenit_cwc);
            }
            cwz com_ushareit_listenit_cwz = (cwz) this.f9284c.m11916c(new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa));
            return com_ushareit_listenit_cwz != null ? com_ushareit_listenit_cwz.m13267c() : null;
        } else {
            throw new IllegalArgumentException("Index not available in IndexedNode!");
        }
    }

    public cwt m13246a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        cxa a = this.f9283b.mo1631a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
        if (this.f9284c == f9282a && !this.f9285d.mo1659a(com_ushareit_listenit_cxa)) {
            return new cwt(a, this.f9285d, f9282a);
        }
        if (this.f9284c == null || this.f9284c == f9282a) {
            return new cwt(a, this.f9285d, null);
        }
        cno a2 = this.f9284c.m11912a(new cwz(com_ushareit_listenit_cwc, this.f9283b.mo1637c(com_ushareit_listenit_cwc)));
        if (!com_ushareit_listenit_cxa.mo1635b()) {
            a2 = a2.m11914b(new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa));
        }
        return new cwt(a, this.f9285d, a2);
    }

    public cxa m13247a() {
        return this.f9283b;
    }

    public boolean m13248a(cws com_ushareit_listenit_cws) {
        return this.f9285d.equals(com_ushareit_listenit_cws);
    }

    public cwt m13249b(cxa com_ushareit_listenit_cxa) {
        return new cwt(this.f9283b.mo1645b(com_ushareit_listenit_cxa), this.f9285d, this.f9284c);
    }

    public Iterator<cwz> m13250b() {
        m13244e();
        return this.f9284c == f9282a ? this.f9283b.mo1641i() : this.f9284c.m11917c();
    }

    public cwz m13251c() {
        if (!(this.f9283b instanceof cwf)) {
            return null;
        }
        m13244e();
        if (this.f9284c != f9282a) {
            return (cwz) this.f9284c.m11913a();
        }
        cwc g = ((cwf) this.f9283b).m13170g();
        return new cwz(g, this.f9283b.mo1637c(g));
    }

    public cwz m13252d() {
        if (!(this.f9283b instanceof cwf)) {
            return null;
        }
        m13244e();
        if (this.f9284c != f9282a) {
            return (cwz) this.f9284c.m11915b();
        }
        cwc h = ((cwf) this.f9283b).m13171h();
        return new cwz(h, this.f9283b.mo1637c(h));
    }

    public Iterator<cwz> iterator() {
        m13244e();
        return this.f9284c == f9282a ? this.f9283b.iterator() : this.f9284c.iterator();
    }
}
