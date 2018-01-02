package com.ushareit.listenit;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class ctr implements ctu {
    static final /* synthetic */ boolean f8965a = (!ctr.class.desiredAssertionStatus());
    private final ctv f8966b;
    private final cub f8967c;
    private final cvy f8968d;
    private final ctp f8969e;
    private long f8970f;

    public ctr(cqd com_ushareit_listenit_cqd, ctv com_ushareit_listenit_ctv, ctp com_ushareit_listenit_ctp) {
        this(com_ushareit_listenit_cqd, com_ushareit_listenit_ctv, com_ushareit_listenit_ctp, new cyi());
    }

    public ctr(cqd com_ushareit_listenit_cqd, ctv com_ushareit_listenit_ctv, ctp com_ushareit_listenit_ctp, cyh com_ushareit_listenit_cyh) {
        this.f8970f = 0;
        this.f8966b = com_ushareit_listenit_ctv;
        this.f8968d = com_ushareit_listenit_cqd.m12268a("Persistence");
        this.f8967c = new cub(this.f8966b, this.f8968d, com_ushareit_listenit_cyh);
        this.f8969e = com_ushareit_listenit_ctp;
    }

    private void m12648b() {
        this.f8970f++;
        if (this.f8969e.mo1591a(this.f8970f)) {
            if (this.f8968d.m13094a()) {
                this.f8968d.m13093a("Reached prune check threshold.", new Object[0]);
            }
            this.f8970f = 0;
            int i = 1;
            long b = this.f8966b.mo1475b();
            if (this.f8968d.m13094a()) {
                this.f8968d.m13093a("Cache size: " + b, new Object[0]);
            }
            while (i != 0 && this.f8969e.mo1592a(r2, this.f8967c.m12713a())) {
                ctw a = this.f8967c.m12714a(this.f8969e);
                if (a.m12686a()) {
                    this.f8966b.mo1471a(cqq.m12332a(), a);
                } else {
                    i = 0;
                }
                b = this.f8966b.mo1475b();
                if (this.f8968d.m13094a()) {
                    this.f8968d.m13093a("Cache size after prune: " + b, new Object[0]);
                }
            }
        }
    }

    public cut mo1594a(cvg com_ushareit_listenit_cvg) {
        boolean z;
        Set d;
        if (this.f8967c.m12724f(com_ushareit_listenit_cvg)) {
            cua a = this.f8967c.m12715a(com_ushareit_listenit_cvg);
            d = (com_ushareit_listenit_cvg.m13006e() || a == null || !a.f8983d) ? null : this.f8966b.mo1480d(a.f8980a);
            z = true;
        } else {
            d = this.f8967c.m12717b(com_ushareit_listenit_cvg.m13002a());
            z = false;
        }
        cxa a2 = this.f8966b.mo1463a(com_ushareit_listenit_cvg.m13002a());
        if (r0 == null) {
            return new cut(cwt.m13243a(a2, com_ushareit_listenit_cvg.m13004c()), z, false);
        }
        cxa j = cwr.m13215j();
        for (cwc com_ushareit_listenit_cwc : r0) {
            j = j.mo1631a(com_ushareit_listenit_cwc, a2.mo1637c(com_ushareit_listenit_cwc));
        }
        return new cut(cwt.m13243a(j, com_ushareit_listenit_cvg.m13004c()), z, true);
    }

    public <T> T mo1595a(Callable<T> callable) {
        this.f8966b.mo1481d();
        try {
            T call = callable.call();
            this.f8966b.mo1483f();
            this.f8966b.mo1482e();
            return call;
        } catch (Throwable th) {
            this.f8966b.mo1482e();
        }
    }

    public List<csz> mo1596a() {
        return this.f8966b.mo1464a();
    }

    public void mo1597a(long j) {
        this.f8966b.mo1466a(j);
    }

    public void mo1598a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        Iterator it = com_ushareit_listenit_cpz.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            mo1600a(com_ushareit_listenit_cqq.m12337a((cqq) entry.getKey()), (cxa) entry.getValue());
        }
    }

    public void mo1599a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, long j) {
        this.f8966b.mo1470a(com_ushareit_listenit_cqq, com_ushareit_listenit_cpz, j);
    }

    public void mo1600a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        if (!this.f8967c.m12722d(com_ushareit_listenit_cqq)) {
            this.f8966b.mo1472a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
            this.f8967c.m12719c(com_ushareit_listenit_cqq);
        }
    }

    public void mo1601a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, long j) {
        this.f8966b.mo1473a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, j);
    }

    public void mo1602a(cvg com_ushareit_listenit_cvg, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cvg.m13006e()) {
            this.f8966b.mo1472a(com_ushareit_listenit_cvg.m13002a(), com_ushareit_listenit_cxa);
        } else {
            this.f8966b.mo1477b(com_ushareit_listenit_cvg.m13002a(), com_ushareit_listenit_cxa);
        }
        mo1608d(com_ushareit_listenit_cvg);
        m12648b();
    }

    public void mo1603a(cvg com_ushareit_listenit_cvg, Set<cwc> set) {
        if (f8965a || !com_ushareit_listenit_cvg.m13006e()) {
            cua a = this.f8967c.m12715a(com_ushareit_listenit_cvg);
            if (f8965a || (a != null && a.f8984e)) {
                this.f8966b.mo1467a(a.f8980a, (Set) set);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void mo1604a(cvg com_ushareit_listenit_cvg, Set<cwc> set, Set<cwc> set2) {
        if (f8965a || !com_ushareit_listenit_cvg.m13006e()) {
            cua a = this.f8967c.m12715a(com_ushareit_listenit_cvg);
            if (f8965a || (a != null && a.f8984e)) {
                this.f8966b.mo1468a(a.f8980a, (Set) set, (Set) set2);
                return;
            }
            throw new AssertionError("We only expect tracked keys for currently-active queries.");
        }
        throw new AssertionError("We should only track keys for filtered queries.");
    }

    public void mo1605b(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        this.f8966b.mo1469a(com_ushareit_listenit_cqq, com_ushareit_listenit_cpz);
        m12648b();
    }

    public void mo1606b(cvg com_ushareit_listenit_cvg) {
        this.f8967c.m12720c(com_ushareit_listenit_cvg);
    }

    public void mo1607c(cvg com_ushareit_listenit_cvg) {
        this.f8967c.m12721d(com_ushareit_listenit_cvg);
    }

    public void mo1608d(cvg com_ushareit_listenit_cvg) {
        if (com_ushareit_listenit_cvg.m13006e()) {
            this.f8967c.m12716a(com_ushareit_listenit_cvg.m13002a());
        } else {
            this.f8967c.m12723e(com_ushareit_listenit_cvg);
        }
    }
}
