package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cvk {
    static final /* synthetic */ boolean f9210a = (!cvk.class.desiredAssertionStatus());
    private static cvt f9211c = new cvl();
    private final cvs f9212b;

    public cvk(cvs com_ushareit_listenit_cvs) {
        this.f9212b = com_ushareit_listenit_cvs;
    }

    private cvj m13023a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa, cvp com_ushareit_listenit_cvp) {
        if (f9210a || com_ushareit_listenit_cpz.m12242b() == null) {
            Entry entry;
            cqq a;
            Iterator it = com_ushareit_listenit_cpz.iterator();
            cvj com_ushareit_listenit_cvj2 = com_ushareit_listenit_cvj;
            while (it.hasNext()) {
                entry = (Entry) it.next();
                a = com_ushareit_listenit_cqq.m12337a((cqq) entry.getKey());
                if (m13030a(com_ushareit_listenit_cvj, a.m12343d())) {
                    com_ushareit_listenit_cvj2 = m13027a(com_ushareit_listenit_cvj2, a, (cxa) entry.getValue(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                }
            }
            it = com_ushareit_listenit_cpz.iterator();
            while (it.hasNext()) {
                entry = (Entry) it.next();
                a = com_ushareit_listenit_cqq.m12337a((cqq) entry.getKey());
                if (!m13030a(com_ushareit_listenit_cvj, a.m12343d())) {
                    com_ushareit_listenit_cvj2 = m13027a(com_ushareit_listenit_cvj2, a, (cxa) entry.getValue(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                }
            }
            return com_ushareit_listenit_cvj2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private cvj m13024a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa, boolean z, cvp com_ushareit_listenit_cvp) {
        if (com_ushareit_listenit_cvj.m13021c().m12781c().mo1635b() && !com_ushareit_listenit_cvj.m13021c().m12777a()) {
            return com_ushareit_listenit_cvj;
        }
        if (f9210a || com_ushareit_listenit_cpz.m12242b() == null) {
            cwc com_ushareit_listenit_cwc;
            if (!com_ushareit_listenit_cqq.m12347h()) {
                com_ushareit_listenit_cpz = cpz.m12232a().m12237a(com_ushareit_listenit_cqq, com_ushareit_listenit_cpz);
            }
            cxa c = com_ushareit_listenit_cvj.m13021c().m12781c();
            Map d = com_ushareit_listenit_cpz.m12247d();
            cvj com_ushareit_listenit_cvj2 = com_ushareit_listenit_cvj;
            for (Entry entry : d.entrySet()) {
                com_ushareit_listenit_cwc = (cwc) entry.getKey();
                if (c.mo1633a(com_ushareit_listenit_cwc)) {
                    com_ushareit_listenit_cvj2 = m13028a(com_ushareit_listenit_cvj2, new cqq(com_ushareit_listenit_cwc), ((cpz) entry.getValue()).m12240a(c.mo1637c(com_ushareit_listenit_cwc)), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, z, com_ushareit_listenit_cvp);
                }
            }
            for (Entry entry2 : d.entrySet()) {
                com_ushareit_listenit_cwc = (cwc) entry2.getKey();
                Object obj = (com_ushareit_listenit_cvj.m13021c().m12779a(com_ushareit_listenit_cwc) || ((cpz) entry2.getValue()).m12242b() != null) ? null : 1;
                if (!c.mo1633a(com_ushareit_listenit_cwc) && obj == null) {
                    com_ushareit_listenit_cvj2 = m13028a(com_ushareit_listenit_cvj2, new cqq(com_ushareit_listenit_cwc), ((cpz) entry2.getValue()).m12240a(c.mo1637c(com_ushareit_listenit_cwc)), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, z, com_ushareit_listenit_cvp);
                }
            }
            return com_ushareit_listenit_cvj2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private cvj m13025a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, ctf com_ushareit_listenit_ctf, cvt com_ushareit_listenit_cvt, cvp com_ushareit_listenit_cvp) {
        cut a = com_ushareit_listenit_cvj.m13017a();
        if (com_ushareit_listenit_ctf.m12596a(com_ushareit_listenit_cqq) != null) {
            return com_ushareit_listenit_cvj;
        }
        cwt a2;
        cxa a3;
        if (!com_ushareit_listenit_cqq.m12347h()) {
            cwc d = com_ushareit_listenit_cqq.m12343d();
            if (!d.m13145e()) {
                cxa a4;
                cqq e = com_ushareit_listenit_cqq.m12344e();
                if (a.m12779a(d)) {
                    a3 = com_ushareit_listenit_ctf.m12597a(com_ushareit_listenit_cqq, a.m12781c(), com_ushareit_listenit_cvj.m13021c().m12781c());
                    a4 = a3 != null ? a.m12781c().mo1637c(d).mo1630a(e, a3) : a.m12781c().mo1637c(d);
                } else {
                    a4 = com_ushareit_listenit_ctf.m12598a(d, com_ushareit_listenit_cvj.m13021c());
                }
                a2 = a4 != null ? this.f9212b.mo1617a(a.m12782d(), d, a4, e, com_ushareit_listenit_cvt, com_ushareit_listenit_cvp) : a.m12782d();
            } else if (f9210a || com_ushareit_listenit_cqq.m12348i() == 1) {
                a3 = com_ushareit_listenit_ctf.m12597a(com_ushareit_listenit_cqq, a.m12781c(), com_ushareit_listenit_cvj.m13021c().m12781c());
                a2 = a3 != null ? this.f9212b.mo1619a(a.m12782d(), a3) : a.m12782d();
            } else {
                throw new AssertionError("Can't have a priority with additional path components");
            }
        } else if (f9210a || com_ushareit_listenit_cvj.m13021c().m12777a()) {
            if (com_ushareit_listenit_cvj.m13021c().m12780b()) {
                a3 = com_ushareit_listenit_cvj.m13022d();
                if (!(a3 instanceof cwf)) {
                    a3 = cwr.m13215j();
                }
                a3 = com_ushareit_listenit_ctf.m12602b(a3);
            } else {
                a3 = com_ushareit_listenit_ctf.m12599a(com_ushareit_listenit_cvj.m13022d());
            }
            a2 = this.f9212b.mo1618a(com_ushareit_listenit_cvj.m13017a().m12782d(), cwt.m13243a(a3, this.f9212b.mo1620b()), com_ushareit_listenit_cvp);
        } else {
            throw new AssertionError("If change path is empty, we must have complete server data");
        }
        boolean z = a.m12777a() || com_ushareit_listenit_cqq.m12347h();
        return com_ushareit_listenit_cvj.m13018a(a2, z, this.f9212b.mo1621c());
    }

    private cvj m13026a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, cui<Boolean> com_ushareit_listenit_cui_java_lang_Boolean, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa, cvp com_ushareit_listenit_cvp) {
        if (com_ushareit_listenit_ctf.m12596a(com_ushareit_listenit_cqq) != null) {
            return com_ushareit_listenit_cvj;
        }
        boolean b = com_ushareit_listenit_cvj.m13021c().m12780b();
        cut c = com_ushareit_listenit_cvj.m13021c();
        cpz a;
        if (com_ushareit_listenit_cui_java_lang_Boolean.m12746b() == null) {
            a = cpz.m12232a();
            Iterator it = com_ushareit_listenit_cui_java_lang_Boolean.iterator();
            while (it.hasNext()) {
                cqq com_ushareit_listenit_cqq2 = (cqq) ((Entry) it.next()).getKey();
                cqq a2 = com_ushareit_listenit_cqq.m12337a(com_ushareit_listenit_cqq2);
                if (c.m12778a(a2)) {
                    a = a.m12238a(com_ushareit_listenit_cqq2, c.m12781c().mo1629a(a2));
                }
            }
            return m13024a(com_ushareit_listenit_cvj, com_ushareit_listenit_cqq, a, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, b, com_ushareit_listenit_cvp);
        } else if ((com_ushareit_listenit_cqq.m12347h() && c.m12777a()) || c.m12778a(com_ushareit_listenit_cqq)) {
            return m13028a(com_ushareit_listenit_cvj, com_ushareit_listenit_cqq, c.m12781c().mo1629a(com_ushareit_listenit_cqq), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, b, com_ushareit_listenit_cvp);
        } else if (!com_ushareit_listenit_cqq.m12347h()) {
            return com_ushareit_listenit_cvj;
        } else {
            a = cpz.m12232a();
            for (cwz com_ushareit_listenit_cwz : c.m12781c()) {
                a = a.m12239a(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d());
            }
            return m13024a(com_ushareit_listenit_cvj, com_ushareit_listenit_cqq, a, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, b, com_ushareit_listenit_cvp);
        }
    }

    private cvj m13027a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa2, cvp com_ushareit_listenit_cvp) {
        cut a = com_ushareit_listenit_cvj.m13017a();
        cvt com_ushareit_listenit_cvo = new cvo(com_ushareit_listenit_ctf, com_ushareit_listenit_cvj, com_ushareit_listenit_cxa2);
        if (com_ushareit_listenit_cqq.m12347h()) {
            return com_ushareit_listenit_cvj.m13018a(this.f9212b.mo1618a(com_ushareit_listenit_cvj.m13017a().m12782d(), cwt.m13243a(com_ushareit_listenit_cxa, this.f9212b.mo1620b()), com_ushareit_listenit_cvp), true, this.f9212b.mo1621c());
        }
        cwc d = com_ushareit_listenit_cqq.m12343d();
        if (d.m13145e()) {
            return com_ushareit_listenit_cvj.m13018a(this.f9212b.mo1619a(com_ushareit_listenit_cvj.m13017a().m12782d(), com_ushareit_listenit_cxa), a.m12777a(), a.m12780b());
        }
        cxa com_ushareit_listenit_cxa3;
        cqq e = com_ushareit_listenit_cqq.m12344e();
        cxa c = a.m12781c().mo1637c(d);
        if (e.m12347h()) {
            com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa;
        } else {
            com_ushareit_listenit_cxa3 = com_ushareit_listenit_cvo.mo1615a(d);
            if (com_ushareit_listenit_cxa3 == null) {
                com_ushareit_listenit_cxa3 = cwr.m13215j();
            } else if (!(e.m12346g().m13145e() && com_ushareit_listenit_cxa3.mo1629a(e.m12345f()).mo1635b())) {
                com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa3.mo1630a(e, com_ushareit_listenit_cxa);
            }
        }
        return !c.equals(com_ushareit_listenit_cxa3) ? com_ushareit_listenit_cvj.m13018a(this.f9212b.mo1617a(a.m12782d(), d, com_ushareit_listenit_cxa3, e, com_ushareit_listenit_cvo, com_ushareit_listenit_cvp), a.m12777a(), this.f9212b.mo1621c()) : com_ushareit_listenit_cvj;
    }

    private cvj m13028a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa2, boolean z, cvp com_ushareit_listenit_cvp) {
        cwt a;
        cut c = com_ushareit_listenit_cvj.m13021c();
        cvs a2 = z ? this.f9212b : this.f9212b.mo1616a();
        if (com_ushareit_listenit_cqq.m12347h()) {
            a = a2.mo1618a(c.m12782d(), cwt.m13243a(com_ushareit_listenit_cxa, a2.mo1620b()), null);
        } else if (!a2.mo1621c() || c.m12780b()) {
            cwc d = com_ushareit_listenit_cqq.m12343d();
            if (!c.m12778a(com_ushareit_listenit_cqq) && com_ushareit_listenit_cqq.m12348i() > 1) {
                return com_ushareit_listenit_cvj;
            }
            cqq e = com_ushareit_listenit_cqq.m12344e();
            cxa a3 = c.m12781c().mo1637c(d).mo1630a(e, com_ushareit_listenit_cxa);
            a = d.m13145e() ? a2.mo1619a(c.m12782d(), a3) : a2.mo1617a(c.m12782d(), d, a3, e, f9211c, null);
        } else if (f9210a || !com_ushareit_listenit_cqq.m12347h()) {
            cwc d2 = com_ushareit_listenit_cqq.m12343d();
            a = a2.mo1618a(c.m12782d(), c.m12782d().m13246a(d2, c.m12781c().mo1637c(d2).mo1630a(com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cxa)), null);
        } else {
            throw new AssertionError("An empty path should have been caught in the other branch");
        }
        boolean z2 = c.m12777a() || com_ushareit_listenit_cqq.m12347h();
        cvj b = com_ushareit_listenit_cvj.m13019b(a, z2, a2.mo1621c());
        return m13025a(b, com_ushareit_listenit_cqq, com_ushareit_listenit_ctf, new cvo(com_ushareit_listenit_ctf, b, com_ushareit_listenit_cxa2), com_ushareit_listenit_cvp);
    }

    private void m13029a(cvj com_ushareit_listenit_cvj, cvj com_ushareit_listenit_cvj2, List<cuv> list) {
        cut a = com_ushareit_listenit_cvj2.m13017a();
        if (a.m12777a()) {
            Object obj = (a.m12781c().mo1639e() || a.m12781c().mo1635b()) ? 1 : null;
            if (!list.isEmpty() || !com_ushareit_listenit_cvj.m13017a().m12777a() || ((obj != null && !a.m12781c().equals(com_ushareit_listenit_cvj.m13020b())) || !a.m12781c().mo1640f().equals(com_ushareit_listenit_cvj.m13020b().mo1640f()))) {
                list.add(cuv.m12954a(a.m12782d()));
            }
        }
    }

    private static boolean m13030a(cvj com_ushareit_listenit_cvj, cwc com_ushareit_listenit_cwc) {
        return com_ushareit_listenit_cvj.m13017a().m12779a(com_ushareit_listenit_cwc);
    }

    private cvj m13031b(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa, cvp com_ushareit_listenit_cvp) {
        cut c = com_ushareit_listenit_cvj.m13021c();
        cwt d = c.m12782d();
        boolean z = c.m12777a() || com_ushareit_listenit_cqq.m12347h();
        return m13025a(com_ushareit_listenit_cvj.m13019b(d, z, c.m12780b()), com_ushareit_listenit_cqq, com_ushareit_listenit_ctf, f9211c, com_ushareit_listenit_cvp);
    }

    public cvj m13032a(cvj com_ushareit_listenit_cvj, cqq com_ushareit_listenit_cqq, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa, cvp com_ushareit_listenit_cvp) {
        if (com_ushareit_listenit_ctf.m12596a(com_ushareit_listenit_cqq) != null) {
            return com_ushareit_listenit_cvj;
        }
        cvt com_ushareit_listenit_cvo = new cvo(com_ushareit_listenit_ctf, com_ushareit_listenit_cvj, com_ushareit_listenit_cxa);
        cwt d = com_ushareit_listenit_cvj.m13017a().m12782d();
        if (com_ushareit_listenit_cqq.m12347h() || com_ushareit_listenit_cqq.m12343d().m13145e()) {
            d = this.f9212b.mo1618a(d, cwt.m13243a(com_ushareit_listenit_cvj.m13021c().m12777a() ? com_ushareit_listenit_ctf.m12599a(com_ushareit_listenit_cvj.m13022d()) : com_ushareit_listenit_ctf.m12602b(com_ushareit_listenit_cvj.m13021c().m12781c()), this.f9212b.mo1620b()), com_ushareit_listenit_cvp);
        } else {
            cwc d2 = com_ushareit_listenit_cqq.m12343d();
            cxa a = com_ushareit_listenit_ctf.m12598a(d2, com_ushareit_listenit_cvj.m13021c());
            if (a == null && com_ushareit_listenit_cvj.m13021c().m12779a(d2)) {
                a = d.m13247a().mo1637c(d2);
            }
            if (a != null) {
                d = this.f9212b.mo1617a(d, d2, a, com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cvo, com_ushareit_listenit_cvp);
            } else if (a == null && com_ushareit_listenit_cvj.m13017a().m12781c().mo1633a(d2)) {
                d = this.f9212b.mo1617a(d, d2, cwr.m13215j(), com_ushareit_listenit_cqq.m12344e(), com_ushareit_listenit_cvo, com_ushareit_listenit_cvp);
            }
            if (d.m13247a().mo1635b() && com_ushareit_listenit_cvj.m13021c().m12777a()) {
                cxa a2 = com_ushareit_listenit_ctf.m12599a(com_ushareit_listenit_cvj.m13022d());
                if (a2.mo1639e()) {
                    d = this.f9212b.mo1618a(d, cwt.m13243a(a2, this.f9212b.mo1620b()), com_ushareit_listenit_cvp);
                }
            }
        }
        boolean z = com_ushareit_listenit_cvj.m13021c().m12777a() || com_ushareit_listenit_ctf.m12596a(cqq.m12332a()) != null;
        return com_ushareit_listenit_cvj.m13018a(d, z, this.f9212b.mo1621c());
    }

    public cvn m13033a(cvj com_ushareit_listenit_cvj, ctk com_ushareit_listenit_ctk, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa) {
        cvj a;
        cvp com_ushareit_listenit_cvp = new cvp();
        boolean z;
        switch (cvm.f9213a[com_ushareit_listenit_ctk.m12611e().ordinal()]) {
            case 1:
                cto com_ushareit_listenit_cto = (cto) com_ushareit_listenit_ctk;
                if (com_ushareit_listenit_cto.m12610d().m12619a()) {
                    a = m13027a(com_ushareit_listenit_cvj, com_ushareit_listenit_cto.m12609c(), com_ushareit_listenit_cto.m12624a(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                    break;
                } else if (f9210a || com_ushareit_listenit_cto.m12610d().m12620b()) {
                    z = com_ushareit_listenit_cto.m12610d().m12621c() || (com_ushareit_listenit_cvj.m13021c().m12780b() && !com_ushareit_listenit_cto.m12609c().m12347h());
                    a = m13028a(com_ushareit_listenit_cvj, com_ushareit_listenit_cto.m12609c(), com_ushareit_listenit_cto.m12624a(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, z, com_ushareit_listenit_cvp);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case 2:
                ctj com_ushareit_listenit_ctj = (ctj) com_ushareit_listenit_ctk;
                if (com_ushareit_listenit_ctj.m12610d().m12619a()) {
                    a = m13023a(com_ushareit_listenit_cvj, com_ushareit_listenit_ctj.m12609c(), com_ushareit_listenit_ctj.m12616a(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                    break;
                } else if (f9210a || com_ushareit_listenit_ctj.m12610d().m12620b()) {
                    z = com_ushareit_listenit_ctj.m12610d().m12621c() || com_ushareit_listenit_cvj.m13021c().m12780b();
                    a = m13024a(com_ushareit_listenit_cvj, com_ushareit_listenit_ctj.m12609c(), com_ushareit_listenit_ctj.m12616a(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, z, com_ushareit_listenit_cvp);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case 3:
                cth com_ushareit_listenit_cth = (cth) com_ushareit_listenit_ctk;
                if (!com_ushareit_listenit_cth.m12614b()) {
                    a = m13026a(com_ushareit_listenit_cvj, com_ushareit_listenit_cth.m12609c(), com_ushareit_listenit_cth.m12613a(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                    break;
                }
                a = m13032a(com_ushareit_listenit_cvj, com_ushareit_listenit_cth.m12609c(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                break;
            case 4:
                a = m13031b(com_ushareit_listenit_cvj, com_ushareit_listenit_ctk.m12609c(), com_ushareit_listenit_ctf, com_ushareit_listenit_cxa, com_ushareit_listenit_cvp);
                break;
            default:
                String valueOf = String.valueOf(com_ushareit_listenit_ctk.m12611e());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        List arrayList = new ArrayList(com_ushareit_listenit_cvp.m13040a());
        m13029a(com_ushareit_listenit_cvj, a, arrayList);
        return new cvn(a, arrayList);
    }
}
