package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ctc {
    static final /* synthetic */ boolean f8927a = (!ctc.class.desiredAssertionStatus());
    private static final cum<csz> f8928e = new cte();
    private cpz f8929b = cpz.m12232a();
    private List<csz> f8930c = new ArrayList();
    private Long f8931d = Long.valueOf(-1);

    private static cpz m12575a(List<csz> list, cum<csz> com_ushareit_listenit_cum_com_ushareit_listenit_csz, cqq com_ushareit_listenit_cqq) {
        cpz a = cpz.m12232a();
        cpz com_ushareit_listenit_cpz = a;
        for (csz com_ushareit_listenit_csz : list) {
            if (com_ushareit_listenit_cum_com_ushareit_listenit_csz.mo1587a(com_ushareit_listenit_csz)) {
                cqq b = com_ushareit_listenit_csz.m12552b();
                if (com_ushareit_listenit_csz.m12555e()) {
                    if (com_ushareit_listenit_cqq.m12340b(b)) {
                        a = com_ushareit_listenit_cpz.m12238a(cqq.m12333a(com_ushareit_listenit_cqq, b), com_ushareit_listenit_csz.m12553c());
                    } else if (b.m12340b(com_ushareit_listenit_cqq)) {
                        a = com_ushareit_listenit_cpz.m12238a(cqq.m12332a(), com_ushareit_listenit_csz.m12553c().mo1629a(cqq.m12333a(b, com_ushareit_listenit_cqq)));
                    }
                    com_ushareit_listenit_cpz = a;
                } else {
                    if (com_ushareit_listenit_cqq.m12340b(b)) {
                        a = com_ushareit_listenit_cpz.m12237a(cqq.m12333a(com_ushareit_listenit_cqq, b), com_ushareit_listenit_csz.m12554d());
                    } else if (b.m12340b(com_ushareit_listenit_cqq)) {
                        b = cqq.m12333a(b, com_ushareit_listenit_cqq);
                        if (b.m12347h()) {
                            a = com_ushareit_listenit_cpz.m12237a(cqq.m12332a(), com_ushareit_listenit_csz.m12554d());
                        } else {
                            cxa c = com_ushareit_listenit_csz.m12554d().m12244c(b);
                            if (c != null) {
                                a = com_ushareit_listenit_cpz.m12238a(cqq.m12332a(), c);
                            }
                        }
                    }
                    com_ushareit_listenit_cpz = a;
                }
            }
            a = com_ushareit_listenit_cpz;
            com_ushareit_listenit_cpz = a;
        }
        return com_ushareit_listenit_cpz;
    }

    private void m12576a() {
        this.f8929b = m12575a(this.f8930c, f8928e, cqq.m12332a());
        if (this.f8930c.size() > 0) {
            this.f8931d = Long.valueOf(((csz) this.f8930c.get(this.f8930c.size() - 1)).m12551a());
        } else {
            this.f8931d = Long.valueOf(-1);
        }
    }

    private boolean m12577a(csz com_ushareit_listenit_csz, cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_csz.m12555e()) {
            return com_ushareit_listenit_csz.m12552b().m12340b(com_ushareit_listenit_cqq);
        }
        Iterator it = com_ushareit_listenit_csz.m12554d().iterator();
        while (it.hasNext()) {
            if (com_ushareit_listenit_csz.m12552b().m12337a((cqq) ((Entry) it.next()).getKey()).m12340b(com_ushareit_listenit_cqq)) {
                return true;
            }
        }
        return false;
    }

    public csz m12578a(long j) {
        for (csz com_ushareit_listenit_csz : this.f8930c) {
            if (com_ushareit_listenit_csz.m12551a() == j) {
                return com_ushareit_listenit_csz;
            }
        }
        return null;
    }

    public ctf m12579a(cqq com_ushareit_listenit_cqq) {
        return new ctf(com_ushareit_listenit_cqq, this);
    }

    public cwz m12580a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, cwz com_ushareit_listenit_cwz, boolean z, cws com_ushareit_listenit_cws) {
        cwz com_ushareit_listenit_cwz2 = null;
        cpz d = this.f8929b.m12246d(com_ushareit_listenit_cqq);
        cxa c = d.m12244c(cqq.m12332a());
        if (c == null) {
            if (com_ushareit_listenit_cxa != null) {
                c = d.m12240a(com_ushareit_listenit_cxa);
            }
            return com_ushareit_listenit_cwz2;
        }
        for (cwz com_ushareit_listenit_cwz3 : r0) {
            cwz com_ushareit_listenit_cwz32;
            if (com_ushareit_listenit_cws.m13235a(com_ushareit_listenit_cwz32, com_ushareit_listenit_cwz, z) <= 0 || (com_ushareit_listenit_cwz2 != null && com_ushareit_listenit_cws.m13235a(com_ushareit_listenit_cwz32, com_ushareit_listenit_cwz2, z) >= 0)) {
                com_ushareit_listenit_cwz32 = com_ushareit_listenit_cwz2;
            }
            com_ushareit_listenit_cwz2 = com_ushareit_listenit_cwz32;
        }
        return com_ushareit_listenit_cwz2;
    }

    public cxa m12581a(cqq com_ushareit_listenit_cqq, cqq com_ushareit_listenit_cqq2, cxa com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa2) {
        if (!f8927a && com_ushareit_listenit_cxa == null && com_ushareit_listenit_cxa2 == null) {
            throw new AssertionError("Either existingEventSnap or existingServerSnap must exist");
        }
        cqq a = com_ushareit_listenit_cqq.m12337a(com_ushareit_listenit_cqq2);
        if (this.f8929b.m12243b(a)) {
            return null;
        }
        cpz d = this.f8929b.m12246d(a);
        return d.m12248e() ? com_ushareit_listenit_cxa2.mo1629a(com_ushareit_listenit_cqq2) : d.m12240a(com_ushareit_listenit_cxa2.mo1629a(com_ushareit_listenit_cqq2));
    }

    public cxa m12582a(cqq com_ushareit_listenit_cqq, cwc com_ushareit_listenit_cwc, cut com_ushareit_listenit_cut) {
        cqq a = com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwc);
        cxa c = this.f8929b.m12244c(a);
        return c != null ? c : com_ushareit_listenit_cut.m12779a(com_ushareit_listenit_cwc) ? this.f8929b.m12246d(a).m12240a(com_ushareit_listenit_cut.m12781c().mo1637c(com_ushareit_listenit_cwc)) : null;
    }

    public cxa m12583a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        cwr j = cwr.m13215j();
        cxa<cwz> c = this.f8929b.m12244c(com_ushareit_listenit_cqq);
        cxa com_ushareit_listenit_cxa2;
        if (c == null) {
            cpz d = this.f8929b.m12246d(com_ushareit_listenit_cqq);
            com_ushareit_listenit_cxa2 = j;
            for (cwz com_ushareit_listenit_cwz : com_ushareit_listenit_cxa) {
                com_ushareit_listenit_cxa2 = com_ushareit_listenit_cxa2.mo1631a(com_ushareit_listenit_cwz.m13267c(), d.m12246d(new cqq(com_ushareit_listenit_cwz.m13267c())).m12240a(com_ushareit_listenit_cwz.m13268d()));
            }
            for (cwz com_ushareit_listenit_cwz2 : d.m12245c()) {
                com_ushareit_listenit_cxa2 = com_ushareit_listenit_cxa2.mo1631a(com_ushareit_listenit_cwz2.m13267c(), com_ushareit_listenit_cwz2.m13268d());
            }
            return com_ushareit_listenit_cxa2;
        } else if (c.mo1639e()) {
            return j;
        } else {
            com_ushareit_listenit_cxa2 = j;
            for (cwz com_ushareit_listenit_cwz22 : c) {
                com_ushareit_listenit_cxa2 = com_ushareit_listenit_cxa2.mo1631a(com_ushareit_listenit_cwz22.m13267c(), com_ushareit_listenit_cwz22.m13268d());
            }
            return com_ushareit_listenit_cxa2;
        }
    }

    public cxa m12584a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, List<Long> list, boolean z) {
        cpz d;
        if (!list.isEmpty() || z) {
            d = this.f8929b.m12246d(com_ushareit_listenit_cqq);
            if (!z && d.m12248e()) {
                return com_ushareit_listenit_cxa;
            }
            if (!z && com_ushareit_listenit_cxa == null && !d.m12243b(cqq.m12332a())) {
                return null;
            }
            d = m12575a(this.f8930c, new ctd(this, z, list, com_ushareit_listenit_cqq), com_ushareit_listenit_cqq);
            if (com_ushareit_listenit_cxa == null) {
                com_ushareit_listenit_cxa = cwr.m13215j();
            }
            return d.m12240a(com_ushareit_listenit_cxa);
        }
        cxa c = this.f8929b.m12244c(com_ushareit_listenit_cqq);
        if (c != null) {
            return c;
        }
        d = this.f8929b.m12246d(com_ushareit_listenit_cqq);
        if (d.m12248e()) {
            return com_ushareit_listenit_cxa;
        }
        if (com_ushareit_listenit_cxa == null && !d.m12243b(cqq.m12332a())) {
            return null;
        }
        if (com_ushareit_listenit_cxa == null) {
            com_ushareit_listenit_cxa = cwr.m13215j();
        }
        return d.m12240a(com_ushareit_listenit_cxa);
    }

    public void m12585a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, Long l) {
        if (f8927a || l.longValue() > this.f8931d.longValue()) {
            this.f8930c.add(new csz(l.longValue(), com_ushareit_listenit_cqq, com_ushareit_listenit_cpz));
            this.f8929b = this.f8929b.m12237a(com_ushareit_listenit_cqq, com_ushareit_listenit_cpz);
            this.f8931d = l;
            return;
        }
        throw new AssertionError();
    }

    public void m12586a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, Long l, boolean z) {
        if (f8927a || l.longValue() > this.f8931d.longValue()) {
            this.f8930c.add(new csz(l.longValue(), com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, z));
            if (z) {
                this.f8929b = this.f8929b.m12238a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
            }
            this.f8931d = l;
            return;
        }
        throw new AssertionError();
    }

    public cxa m12587b(cqq com_ushareit_listenit_cqq) {
        return this.f8929b.m12244c(com_ushareit_listenit_cqq);
    }

    public boolean m12588b(long j) {
        csz com_ushareit_listenit_csz = null;
        int i = 0;
        for (csz com_ushareit_listenit_csz2 : this.f8930c) {
            csz com_ushareit_listenit_csz22;
            if (com_ushareit_listenit_csz22.m12551a() == j) {
                com_ushareit_listenit_csz = com_ushareit_listenit_csz22;
                break;
            }
            i++;
        }
        if (f8927a || com_ushareit_listenit_csz != null) {
            this.f8930c.remove(com_ushareit_listenit_csz);
            boolean f = com_ushareit_listenit_csz.m12556f();
            int size = this.f8930c.size() - 1;
            boolean z = false;
            while (f && size >= 0) {
                boolean z2;
                com_ushareit_listenit_csz22 = (csz) this.f8930c.get(size);
                if (com_ushareit_listenit_csz22.m12556f()) {
                    if (size >= i && m12577a(com_ushareit_listenit_csz22, com_ushareit_listenit_csz.m12552b())) {
                        z2 = z;
                        z = false;
                        size--;
                        f = z;
                        z = z2;
                    } else if (com_ushareit_listenit_csz.m12552b().m12340b(com_ushareit_listenit_csz22.m12552b())) {
                        z2 = true;
                        z = f;
                        size--;
                        f = z;
                        z = z2;
                    }
                }
                z2 = z;
                z = f;
                size--;
                f = z;
                z = z2;
            }
            if (!f) {
                return false;
            }
            if (z) {
                m12576a();
                return true;
            } else if (com_ushareit_listenit_csz.m12555e()) {
                this.f8929b = this.f8929b.m12236a(com_ushareit_listenit_csz.m12552b());
                return true;
            } else {
                Iterator it = com_ushareit_listenit_csz.m12554d().iterator();
                while (it.hasNext()) {
                    this.f8929b = this.f8929b.m12236a(com_ushareit_listenit_csz.m12552b().m12337a((cqq) ((Entry) it.next()).getKey()));
                }
                return true;
            }
        }
        throw new AssertionError("removeWrite called with nonexistent writeId");
    }
}
