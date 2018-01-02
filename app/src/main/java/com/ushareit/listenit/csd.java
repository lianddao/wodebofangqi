package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class csd {
    static final /* synthetic */ boolean f8844a = (!csd.class.desiredAssertionStatus());
    private cui<csc> f8845b = cui.m12736a();
    private final ctc f8846c = new ctc();
    private final Map<csu, cvg> f8847d = new HashMap();
    private final Map<cvg, csu> f8848e = new HashMap();
    private final Set<cvg> f8849f = new HashSet();
    private final cst f8850g;
    private final ctu f8851h;
    private final cvy f8852i;
    private long f8853j = 1;

    public csd(cqd com_ushareit_listenit_cqd, ctu com_ushareit_listenit_ctu, cst com_ushareit_listenit_cst) {
        this.f8850g = com_ushareit_listenit_cst;
        this.f8851h = com_ushareit_listenit_ctu;
        this.f8852i = com_ushareit_listenit_cqd.m12268a("SyncTree");
    }

    private csu m12478a() {
        long j = this.f8853j;
        this.f8853j = 1 + j;
        return new csu(j);
    }

    private cvg m12482a(cvg com_ushareit_listenit_cvg) {
        return (!com_ushareit_listenit_cvg.m13006e() || com_ushareit_listenit_cvg.m13005d()) ? com_ushareit_listenit_cvg : cvg.m13000a(com_ushareit_listenit_cvg.m13002a());
    }

    private List<cux> m12487a(ctk com_ushareit_listenit_ctk) {
        return m12488a(com_ushareit_listenit_ctk, this.f8845b, null, this.f8846c.m12579a(cqq.m12332a()));
    }

    private List<cux> m12488a(ctk com_ushareit_listenit_ctk, cui<csc> com_ushareit_listenit_cui_com_ushareit_listenit_csc, cxa com_ushareit_listenit_cxa, ctf com_ushareit_listenit_ctf) {
        if (com_ushareit_listenit_ctk.m12609c().m12347h()) {
            return m12502b(com_ushareit_listenit_ctk, com_ushareit_listenit_cui_com_ushareit_listenit_csc, com_ushareit_listenit_cxa, com_ushareit_listenit_ctf);
        }
        csc com_ushareit_listenit_csc = (csc) com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12746b();
        if (com_ushareit_listenit_cxa == null && com_ushareit_listenit_csc != null) {
            com_ushareit_listenit_cxa = com_ushareit_listenit_csc.m12469a(cqq.m12332a());
        }
        List<cux> arrayList = new ArrayList();
        cwc d = com_ushareit_listenit_ctk.m12609c().m12343d();
        ctk a = com_ushareit_listenit_ctk.mo1589a(d);
        cui com_ushareit_listenit_cui = (cui) com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12749c().mo1490b(d);
        if (!(com_ushareit_listenit_cui == null || a == null)) {
            arrayList.addAll(m12488a(a, com_ushareit_listenit_cui, com_ushareit_listenit_cxa != null ? com_ushareit_listenit_cxa.mo1637c(d) : null, com_ushareit_listenit_ctf.m12594a(d)));
        }
        if (com_ushareit_listenit_csc != null) {
            arrayList.addAll(com_ushareit_listenit_csc.m12472a(com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa));
        }
        return arrayList;
    }

    private List<cvh> m12489a(cui<csc> com_ushareit_listenit_cui_com_ushareit_listenit_csc) {
        List arrayList = new ArrayList();
        m12494a((cui) com_ushareit_listenit_cui_com_ushareit_listenit_csc, arrayList);
        return arrayList;
    }

    private List<cux> m12490a(cvg com_ushareit_listenit_cvg, cqh com_ushareit_listenit_cqh, ece com_ushareit_listenit_ece) {
        return (List) this.f8851h.mo1595a(new csm(this, com_ushareit_listenit_cvg, com_ushareit_listenit_cqh, com_ushareit_listenit_ece));
    }

    private List<? extends cux> m12491a(cvg com_ushareit_listenit_cvg, ctk com_ushareit_listenit_ctk) {
        cqq a = com_ushareit_listenit_cvg.m13002a();
        csc com_ushareit_listenit_csc = (csc) this.f8845b.m12754e(a);
        if (f8844a || com_ushareit_listenit_csc != null) {
            return com_ushareit_listenit_csc.m12472a(com_ushareit_listenit_ctk, this.f8846c.m12579a(a), null);
        }
        throw new AssertionError("Missing sync point for query tag that we're tracking");
    }

    private void m12494a(cui<csc> com_ushareit_listenit_cui_com_ushareit_listenit_csc, List<cvh> list) {
        csc com_ushareit_listenit_csc = (csc) com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12746b();
        if (com_ushareit_listenit_csc == null || !com_ushareit_listenit_csc.m12476c()) {
            if (com_ushareit_listenit_csc != null) {
                list.addAll(com_ushareit_listenit_csc.m12474b());
            }
            Iterator it = com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12749c().iterator();
            while (it.hasNext()) {
                m12494a((cui) ((Entry) it.next()).getValue(), (List) list);
            }
            return;
        }
        list.add(com_ushareit_listenit_csc.m12477d());
    }

    private void m12495a(cvg com_ushareit_listenit_cvg, cvh com_ushareit_listenit_cvh) {
        cqq a = com_ushareit_listenit_cvg.m13002a();
        csu b = m12497b(com_ushareit_listenit_cvg);
        Object com_ushareit_listenit_css = new css(this, com_ushareit_listenit_cvh);
        this.f8850g.mo1570a(m12482a(com_ushareit_listenit_cvg), b, com_ushareit_listenit_css, com_ushareit_listenit_css);
        cui c = this.f8845b.m12750c(a);
        if (b == null) {
            c.m12744a(new csn(this));
        } else if (!f8844a && ((csc) c.m12746b()).m12476c()) {
            throw new AssertionError("If we're adding a query, it shouldn't be shadowed");
        }
    }

    private void m12496a(List<cvg> list) {
        for (cvg com_ushareit_listenit_cvg : list) {
            if (!com_ushareit_listenit_cvg.m13006e()) {
                csu b = m12497b(com_ushareit_listenit_cvg);
                if (f8844a || b != null) {
                    this.f8848e.remove(com_ushareit_listenit_cvg);
                    this.f8847d.remove(b);
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    private csu m12497b(cvg com_ushareit_listenit_cvg) {
        return (csu) this.f8848e.get(com_ushareit_listenit_cvg);
    }

    private cvg m12500b(csu com_ushareit_listenit_csu) {
        return (cvg) this.f8847d.get(com_ushareit_listenit_csu);
    }

    private List<cux> m12502b(ctk com_ushareit_listenit_ctk, cui<csc> com_ushareit_listenit_cui_com_ushareit_listenit_csc, cxa com_ushareit_listenit_cxa, ctf com_ushareit_listenit_ctf) {
        csc com_ushareit_listenit_csc = (csc) com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12746b();
        cxa a = (com_ushareit_listenit_cxa != null || com_ushareit_listenit_csc == null) ? com_ushareit_listenit_cxa : com_ushareit_listenit_csc.m12469a(cqq.m12332a());
        List<cux> arrayList = new ArrayList();
        com_ushareit_listenit_cui_com_ushareit_listenit_csc.m12749c().mo1487a(new cso(this, a, com_ushareit_listenit_ctf, com_ushareit_listenit_ctk, arrayList));
        if (com_ushareit_listenit_csc != null) {
            arrayList.addAll(com_ushareit_listenit_csc.m12472a(com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, a));
        }
        return arrayList;
    }

    public List<? extends cux> m12509a(long j, boolean z, boolean z2, cyh com_ushareit_listenit_cyh) {
        return (List) this.f8851h.mo1595a(new csq(this, z2, j, z, com_ushareit_listenit_cyh));
    }

    public List<? extends cux> m12510a(cqh com_ushareit_listenit_cqh) {
        return (List) this.f8851h.mo1595a(new csl(this, com_ushareit_listenit_cqh));
    }

    public List<? extends cux> m12511a(cqq com_ushareit_listenit_cqq) {
        return (List) this.f8851h.mo1595a(new csh(this, com_ushareit_listenit_cqq));
    }

    public List<? extends cux> m12512a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz, cpz com_ushareit_listenit_cpz2, long j, boolean z) {
        return (List) this.f8851h.mo1595a(new csp(this, z, com_ushareit_listenit_cqq, com_ushareit_listenit_cpz, j, com_ushareit_listenit_cpz2));
    }

    public List<? extends cux> m12513a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        return (List) this.f8851h.mo1595a(new csf(this, com_ushareit_listenit_cqq, com_ushareit_listenit_cxa));
    }

    public List<? extends cux> m12514a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, csu com_ushareit_listenit_csu) {
        return (List) this.f8851h.mo1595a(new csj(this, com_ushareit_listenit_csu, com_ushareit_listenit_cqq, com_ushareit_listenit_cxa));
    }

    public List<? extends cux> m12515a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa2, long j, boolean z, boolean z2) {
        boolean z3 = z || !z2;
        cyr.m13388a(z3, "We shouldn't be persisting non-visible writes.");
        return (List) this.f8851h.mo1595a(new cse(this, z2, com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, j, com_ushareit_listenit_cxa2, z));
    }

    public List<? extends cux> m12516a(cqq com_ushareit_listenit_cqq, List<cxh> list) {
        csc com_ushareit_listenit_csc = (csc) this.f8845b.m12754e(com_ushareit_listenit_cqq);
        if (com_ushareit_listenit_csc == null) {
            return Collections.emptyList();
        }
        cvh d = com_ushareit_listenit_csc.m12477d();
        if (d == null) {
            return Collections.emptyList();
        }
        cxa b = d.m13013b();
        cxa com_ushareit_listenit_cxa = b;
        for (cxh a : list) {
            com_ushareit_listenit_cxa = a.m13292a(com_ushareit_listenit_cxa);
        }
        return m12513a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa);
    }

    public List<? extends cux> m12517a(cqq com_ushareit_listenit_cqq, List<cxh> list, csu com_ushareit_listenit_csu) {
        cvg b = m12500b(com_ushareit_listenit_csu);
        if (b == null) {
            return Collections.emptyList();
        }
        if (f8844a || com_ushareit_listenit_cqq.equals(b.m13002a())) {
            csc com_ushareit_listenit_csc = (csc) this.f8845b.m12754e(b.m13002a());
            if (f8844a || com_ushareit_listenit_csc != null) {
                cvh a = com_ushareit_listenit_csc.m12468a(b);
                if (f8844a || a != null) {
                    cxa b2 = a.m13013b();
                    cxa com_ushareit_listenit_cxa = b2;
                    for (cxh a2 : list) {
                        com_ushareit_listenit_cxa = a2.m13292a(com_ushareit_listenit_cxa);
                    }
                    return m12514a(com_ushareit_listenit_cqq, com_ushareit_listenit_cxa, com_ushareit_listenit_csu);
                }
                throw new AssertionError("Missing view for query tag that we're tracking");
            }
            throw new AssertionError("Missing sync point for query tag that we're tracking");
        }
        throw new AssertionError();
    }

    public List<? extends cux> m12518a(cqq com_ushareit_listenit_cqq, Map<cqq, cxa> map) {
        return (List) this.f8851h.mo1595a(new csg(this, map, com_ushareit_listenit_cqq));
    }

    public List<? extends cux> m12519a(cqq com_ushareit_listenit_cqq, Map<cqq, cxa> map, csu com_ushareit_listenit_csu) {
        return (List) this.f8851h.mo1595a(new csk(this, com_ushareit_listenit_csu, com_ushareit_listenit_cqq, map));
    }

    public List<? extends cux> m12520a(csu com_ushareit_listenit_csu) {
        return (List) this.f8851h.mo1595a(new csi(this, com_ushareit_listenit_csu));
    }

    public List<cux> m12521a(cvg com_ushareit_listenit_cvg, ece com_ushareit_listenit_ece) {
        return m12490a(com_ushareit_listenit_cvg, null, com_ushareit_listenit_ece);
    }

    public cxa m12522b(cqq com_ushareit_listenit_cqq, List<Long> list) {
        cxa a;
        cui com_ushareit_listenit_cui = this.f8845b;
        csc com_ushareit_listenit_csc = (csc) com_ushareit_listenit_cui.m12746b();
        cxa com_ushareit_listenit_cxa = null;
        cqq a2 = cqq.m12332a();
        cui com_ushareit_listenit_cui2 = com_ushareit_listenit_cui;
        cqq com_ushareit_listenit_cqq2 = com_ushareit_listenit_cqq;
        while (true) {
            cwc d = com_ushareit_listenit_cqq2.m12343d();
            cqq e = com_ushareit_listenit_cqq2.m12344e();
            com_ushareit_listenit_cqq2 = a2.m12338a(d);
            cqq a3 = cqq.m12333a(com_ushareit_listenit_cqq2, com_ushareit_listenit_cqq);
            com_ushareit_listenit_cui2 = d != null ? com_ushareit_listenit_cui2.m12742a(d) : cui.m12736a();
            com_ushareit_listenit_csc = (csc) com_ushareit_listenit_cui2.m12746b();
            a = com_ushareit_listenit_csc != null ? com_ushareit_listenit_csc.m12469a(a3) : com_ushareit_listenit_cxa;
            if (!e.m12347h() && a == null) {
                com_ushareit_listenit_cxa = a;
                a2 = com_ushareit_listenit_cqq2;
                com_ushareit_listenit_cqq2 = e;
            }
        }
        return this.f8846c.m12584a(com_ushareit_listenit_cqq, a, (List) list, true);
    }

    public List<cux> m12523b(cqh com_ushareit_listenit_cqh) {
        return m12490a(com_ushareit_listenit_cqh.mo1582a(), com_ushareit_listenit_cqh, null);
    }
}
