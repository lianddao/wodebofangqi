package com.ushareit.listenit;

import java.util.Iterator;

public class cvr implements cvs {
    static final /* synthetic */ boolean f9223a = (!cvr.class.desiredAssertionStatus());
    private final cvu f9224b;
    private final cws f9225c;
    private final int f9226d;
    private final boolean f9227e;

    public cvr(cvd com_ushareit_listenit_cvd) {
        this.f9224b = new cvu(com_ushareit_listenit_cvd);
        this.f9225c = com_ushareit_listenit_cvd.m12992j();
        this.f9226d = com_ushareit_listenit_cvd.m12991i();
        this.f9227e = !com_ushareit_listenit_cvd.m12993k();
    }

    private cwt m13054a(cwt com_ushareit_listenit_cwt, cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cvt com_ushareit_listenit_cvt, cvp com_ushareit_listenit_cvp) {
        if (f9223a || com_ushareit_listenit_cwt.m13247a().mo1636c() == this.f9226d) {
            cwz com_ushareit_listenit_cwz = new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
            cwz c = this.f9227e ? com_ushareit_listenit_cwt.m13251c() : com_ushareit_listenit_cwt.m13252d();
            boolean a = this.f9224b.m13067a(com_ushareit_listenit_cwz);
            if (com_ushareit_listenit_cwt.m13247a().mo1633a(com_ushareit_listenit_cwc)) {
                cxa c2 = com_ushareit_listenit_cwt.m13247a().mo1637c(com_ushareit_listenit_cwc);
                cwz a2 = com_ushareit_listenit_cvt.mo1614a(this.f9225c, c, this.f9227e);
                while (a2 != null && (a2.m13267c().equals(com_ushareit_listenit_cwc) || com_ushareit_listenit_cwt.m13247a().mo1633a(a2.m13267c()))) {
                    a2 = com_ushareit_listenit_cvt.mo1614a(this.f9225c, a2, this.f9227e);
                }
                Object obj = (!a || com_ushareit_listenit_cxa.mo1635b() || (a2 == null ? 1 : this.f9225c.m13235a(a2, com_ushareit_listenit_cwz, this.f9227e)) < 0) ? null : 1;
                if (obj != null) {
                    if (com_ushareit_listenit_cvp != null) {
                        com_ushareit_listenit_cvp.m13041a(cuv.m12953a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa, c2));
                    }
                    return com_ushareit_listenit_cwt.m13246a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
                }
                if (com_ushareit_listenit_cvp != null) {
                    com_ushareit_listenit_cvp.m13041a(cuv.m12956b(com_ushareit_listenit_cwc, c2));
                }
                com_ushareit_listenit_cwt = com_ushareit_listenit_cwt.m13246a(com_ushareit_listenit_cwc, cwr.m13215j());
                obj = (a2 == null || !this.f9224b.m13067a(a2)) ? null : 1;
                if (obj == null) {
                    return com_ushareit_listenit_cwt;
                }
                if (com_ushareit_listenit_cvp != null) {
                    com_ushareit_listenit_cvp.m13041a(cuv.m12952a(a2.m13267c(), a2.m13268d()));
                }
                return com_ushareit_listenit_cwt.m13246a(a2.m13267c(), a2.m13268d());
            } else if (com_ushareit_listenit_cxa.mo1635b() || !a || this.f9225c.m13235a(c, com_ushareit_listenit_cwz, this.f9227e) < 0) {
                return com_ushareit_listenit_cwt;
            } else {
                if (com_ushareit_listenit_cvp != null) {
                    com_ushareit_listenit_cvp.m13041a(cuv.m12956b(c.m13267c(), c.m13268d()));
                    com_ushareit_listenit_cvp.m13041a(cuv.m12952a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa));
                }
                return com_ushareit_listenit_cwt.m13246a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa).m13246a(c.m13267c(), cwr.m13215j());
            }
        }
        throw new AssertionError();
    }

    public cvs mo1616a() {
        return this.f9224b.mo1616a();
    }

    public cwt mo1617a(cwt com_ushareit_listenit_cwt, cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cqq com_ushareit_listenit_cqq, cvt com_ushareit_listenit_cvt, cvp com_ushareit_listenit_cvp) {
        cxa j = !this.f9224b.m13067a(new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa)) ? cwr.m13215j() : com_ushareit_listenit_cxa;
        return com_ushareit_listenit_cwt.m13247a().mo1637c(com_ushareit_listenit_cwc).equals(j) ? com_ushareit_listenit_cwt : com_ushareit_listenit_cwt.m13247a().mo1636c() < this.f9226d ? this.f9224b.mo1616a().mo1617a(com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, j, com_ushareit_listenit_cqq, com_ushareit_listenit_cvt, com_ushareit_listenit_cvp) : m13054a(com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, j, com_ushareit_listenit_cvt, com_ushareit_listenit_cvp);
    }

    public cwt mo1618a(cwt com_ushareit_listenit_cwt, cwt com_ushareit_listenit_cwt2, cvp com_ushareit_listenit_cvp) {
        cwt a;
        if (com_ushareit_listenit_cwt2.m13247a().mo1639e() || com_ushareit_listenit_cwt2.m13247a().mo1635b()) {
            a = cwt.m13243a(cwr.m13215j(), this.f9225c);
        } else {
            Object d;
            Iterator it;
            int i;
            cwt b = com_ushareit_listenit_cwt2.m13249b(cxg.m13288a());
            if (this.f9227e) {
                Iterator b2 = com_ushareit_listenit_cwt2.m13250b();
                Object e = this.f9224b.m13071e();
                d = this.f9224b.m13070d();
                it = b2;
                i = -1;
            } else {
                Iterator it2 = com_ushareit_listenit_cwt2.iterator();
                cwz d2 = this.f9224b.m13070d();
                cwz e2 = this.f9224b.m13071e();
                cwz com_ushareit_listenit_cwz = d2;
                i = 1;
                it = it2;
            }
            int i2 = 0;
            a = b;
            Object obj = null;
            while (it.hasNext()) {
                int i3;
                cwt com_ushareit_listenit_cwt3;
                cwz com_ushareit_listenit_cwz2 = (cwz) it.next();
                if (obj == null && this.f9225c.compare(r5, com_ushareit_listenit_cwz2) * i <= 0) {
                    obj = 1;
                }
                Object obj2 = (obj == null || i2 >= this.f9226d || this.f9225c.compare(com_ushareit_listenit_cwz2, d) * i > 0) ? null : 1;
                if (obj2 != null) {
                    i3 = i2 + 1;
                    com_ushareit_listenit_cwt3 = a;
                } else {
                    a = a.m13246a(com_ushareit_listenit_cwz2.m13267c(), cwr.m13215j());
                    i3 = i2;
                    com_ushareit_listenit_cwt3 = a;
                }
                a = com_ushareit_listenit_cwt3;
                i2 = i3;
            }
        }
        return this.f9224b.mo1616a().mo1618a(com_ushareit_listenit_cwt, a, com_ushareit_listenit_cvp);
    }

    public cwt mo1619a(cwt com_ushareit_listenit_cwt, cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cwt;
    }

    public cws mo1620b() {
        return this.f9225c;
    }

    public boolean mo1621c() {
        return true;
    }
}
