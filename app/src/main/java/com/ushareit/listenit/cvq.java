package com.ushareit.listenit;

public class cvq implements cvs {
    static final /* synthetic */ boolean f9221a = (!cvq.class.desiredAssertionStatus());
    private final cws f9222b;

    public cvq(cws com_ushareit_listenit_cws) {
        this.f9222b = com_ushareit_listenit_cws;
    }

    public cvs mo1616a() {
        return this;
    }

    public cwt mo1617a(cwt com_ushareit_listenit_cwt, cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa, cqq com_ushareit_listenit_cqq, cvt com_ushareit_listenit_cvt, cvp com_ushareit_listenit_cvp) {
        if (f9221a || com_ushareit_listenit_cwt.m13248a(this.f9222b)) {
            cxa a = com_ushareit_listenit_cwt.m13247a();
            cxa c = a.mo1637c(com_ushareit_listenit_cwc);
            if (c.mo1629a(com_ushareit_listenit_cqq).equals(com_ushareit_listenit_cxa.mo1629a(com_ushareit_listenit_cqq)) && c.mo1635b() == com_ushareit_listenit_cxa.mo1635b()) {
                return com_ushareit_listenit_cwt;
            }
            if (com_ushareit_listenit_cvp != null) {
                if (com_ushareit_listenit_cxa.mo1635b()) {
                    if (a.mo1633a(com_ushareit_listenit_cwc)) {
                        com_ushareit_listenit_cvp.m13041a(cuv.m12956b(com_ushareit_listenit_cwc, c));
                    } else if (!(f9221a || a.mo1639e())) {
                        throw new AssertionError("A child remove without an old child only makes sense on a leaf node");
                    }
                } else if (c.mo1635b()) {
                    com_ushareit_listenit_cvp.m13041a(cuv.m12952a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa));
                } else {
                    com_ushareit_listenit_cvp.m13041a(cuv.m12953a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa, c));
                }
            }
            return (a.mo1639e() && com_ushareit_listenit_cxa.mo1635b()) ? com_ushareit_listenit_cwt : com_ushareit_listenit_cwt.m13246a(com_ushareit_listenit_cwc, com_ushareit_listenit_cxa);
        } else {
            throw new AssertionError("The index must match the filter");
        }
    }

    public cwt mo1618a(cwt com_ushareit_listenit_cwt, cwt com_ushareit_listenit_cwt2, cvp com_ushareit_listenit_cvp) {
        if (f9221a || com_ushareit_listenit_cwt2.m13248a(this.f9222b)) {
            if (com_ushareit_listenit_cvp != null) {
                for (cwz com_ushareit_listenit_cwz : com_ushareit_listenit_cwt.m13247a()) {
                    if (!com_ushareit_listenit_cwt2.m13247a().mo1633a(com_ushareit_listenit_cwz.m13267c())) {
                        com_ushareit_listenit_cvp.m13041a(cuv.m12956b(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d()));
                    }
                }
                if (!com_ushareit_listenit_cwt2.m13247a().mo1639e()) {
                    for (cwz com_ushareit_listenit_cwz2 : com_ushareit_listenit_cwt2.m13247a()) {
                        if (com_ushareit_listenit_cwt.m13247a().mo1633a(com_ushareit_listenit_cwz2.m13267c())) {
                            cxa c = com_ushareit_listenit_cwt.m13247a().mo1637c(com_ushareit_listenit_cwz2.m13267c());
                            if (!c.equals(com_ushareit_listenit_cwz2.m13268d())) {
                                com_ushareit_listenit_cvp.m13041a(cuv.m12953a(com_ushareit_listenit_cwz2.m13267c(), com_ushareit_listenit_cwz2.m13268d(), c));
                            }
                        } else {
                            com_ushareit_listenit_cvp.m13041a(cuv.m12952a(com_ushareit_listenit_cwz2.m13267c(), com_ushareit_listenit_cwz2.m13268d()));
                        }
                    }
                }
            }
            return com_ushareit_listenit_cwt2;
        }
        throw new AssertionError("Can't use IndexedNode that doesn't have filter's index");
    }

    public cwt mo1619a(cwt com_ushareit_listenit_cwt, cxa com_ushareit_listenit_cxa) {
        return com_ushareit_listenit_cwt.m13247a().mo1635b() ? com_ushareit_listenit_cwt : com_ushareit_listenit_cwt.m13249b(com_ushareit_listenit_cxa);
    }

    public cws mo1620b() {
        return this.f9222b;
    }

    public boolean mo1621c() {
        return false;
    }
}
