package com.ushareit.listenit;

import java.util.Iterator;

public class cvu implements cvs {
    private final cvq f9228a;
    private final cws f9229b;
    private final cwz f9230c;
    private final cwz f9231d;

    public cvu(cvd com_ushareit_listenit_cvd) {
        this.f9228a = new cvq(com_ushareit_listenit_cvd.m12992j());
        this.f9229b = com_ushareit_listenit_cvd.m12992j();
        this.f9230c = m13061a(com_ushareit_listenit_cvd);
        this.f9231d = m13062b(com_ushareit_listenit_cvd);
    }

    private static cwz m13061a(cvd com_ushareit_listenit_cvd) {
        if (!com_ushareit_listenit_cvd.m12983a()) {
            return com_ushareit_listenit_cvd.m12992j().m13236a();
        }
        return com_ushareit_listenit_cvd.m12992j().mo1658a(com_ushareit_listenit_cvd.m12985c(), com_ushareit_listenit_cvd.m12984b());
    }

    private static cwz m13062b(cvd com_ushareit_listenit_cvd) {
        if (!com_ushareit_listenit_cvd.m12986d()) {
            return com_ushareit_listenit_cvd.m12992j().mo1660b();
        }
        return com_ushareit_listenit_cvd.m12992j().mo1658a(com_ushareit_listenit_cvd.m12988f(), com_ushareit_listenit_cvd.m12987e());
    }

    public cvs mo1616a() {
        return this.f9228a;
    }

    public cwt mo1617a(cwt com_ushareit_listenit_cwt, cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cqq com_ushareit_listenit_cqq, cvt com_ushareit_listenit_cvt, cvp com_ushareit_listenit_cvp) {
        return this.f9228a.mo1617a(com_ushareit_listenit_cwt, com_ushareit_listenit_cwc, !m13067a(new cwz(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa)) ? cwr.m13215j() : com_ushareit_listenit_cxa, com_ushareit_listenit_cqq, com_ushareit_listenit_cvt, com_ushareit_listenit_cvp);
    }

    public cwt mo1618a(cwt com_ushareit_listenit_cwt, cwt com_ushareit_listenit_cwt2, cvp com_ushareit_listenit_cvp) {
        cwt a;
        if (com_ushareit_listenit_cwt2.m13247a().mo1639e()) {
            a = cwt.m13243a(cwr.m13215j(), this.f9229b);
        } else {
            cwt b = com_ushareit_listenit_cwt2.m13249b(cxg.m13288a());
            Iterator it = com_ushareit_listenit_cwt2.iterator();
            a = b;
            while (it.hasNext()) {
                cwz com_ushareit_listenit_cwz = (cwz) it.next();
                a = !m13067a(com_ushareit_listenit_cwz) ? a.m13246a(com_ushareit_listenit_cwz.m13267c(), cwr.m13215j()) : a;
            }
        }
        return this.f9228a.mo1618a(com_ushareit_listenit_cwt, a, com_ushareit_listenit_cvp);
    }

    public cwt mo1619a(cwt com_ushareit_listenit_cwt, cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cwt;
    }

    public boolean m13067a(cwz com_ushareit_listenit_cwz) {
        return this.f9229b.compare(m13070d(), com_ushareit_listenit_cwz) <= 0 && this.f9229b.compare(com_ushareit_listenit_cwz, m13071e()) <= 0;
    }

    public cws mo1620b() {
        return this.f9229b;
    }

    public boolean mo1621c() {
        return true;
    }

    public cwz m13070d() {
        return this.f9230c;
    }

    public cwz m13071e() {
        return this.f9231d;
    }
}
