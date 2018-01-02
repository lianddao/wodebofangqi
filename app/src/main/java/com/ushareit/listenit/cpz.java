package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cpz implements Iterable<Entry<cqq, cxa>> {
    static final /* synthetic */ boolean f8682a = (!cpz.class.desiredAssertionStatus());
    private static final cpz f8683b = new cpz(new cui(null));
    private final cui<cxa> f8684c;

    private cpz(cui<cxa> com_ushareit_listenit_cui_com_ushareit_listenit_cxa) {
        this.f8684c = com_ushareit_listenit_cui_com_ushareit_listenit_cxa;
    }

    public static cpz m12232a() {
        return f8683b;
    }

    public static cpz m12233a(Map<String, Object> map) {
        cui a = cui.m12736a();
        cui com_ushareit_listenit_cui = a;
        for (Entry entry : map.entrySet()) {
            com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12740a(new cqq((String) entry.getKey()), new cui(cxd.m13275a(entry.getValue())));
        }
        return new cpz(com_ushareit_listenit_cui);
    }

    private cxa m12234a(cqq com_ushareit_listenit_cqq, cui<cxa> com_ushareit_listenit_cui_com_ushareit_listenit_cxa, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cui_com_ushareit_listenit_cxa.m12746b() != null) {
            return com_ushareit_listenit_cxa.mo1630a(com_ushareit_listenit_cqq, (cxa) com_ushareit_listenit_cui_com_ushareit_listenit_cxa.m12746b());
        }
        cxa com_ushareit_listenit_cxa2 = null;
        Iterator it = com_ushareit_listenit_cui_com_ushareit_listenit_cxa.m12749c().iterator();
        cxa com_ushareit_listenit_cxa3 = com_ushareit_listenit_cxa;
        while (it.hasNext()) {
            cxa a;
            cxa com_ushareit_listenit_cxa4;
            Entry entry = (Entry) it.next();
            cui com_ushareit_listenit_cui = (cui) entry.getValue();
            cwc com_ushareit_listenit_cwc = (cwc) entry.getKey();
            if (!com_ushareit_listenit_cwc.m13145e()) {
                a = m12234a(com_ushareit_listenit_cqq.m12338a(com_ushareit_listenit_cwc), com_ushareit_listenit_cui, com_ushareit_listenit_cxa3);
                com_ushareit_listenit_cxa4 = com_ushareit_listenit_cxa2;
            } else if (f8682a || com_ushareit_listenit_cui.m12746b() != null) {
                com_ushareit_listenit_cxa4 = (cxa) com_ushareit_listenit_cui.m12746b();
                a = com_ushareit_listenit_cxa3;
            } else {
                throw new AssertionError("Priority writes must always be leaf nodes");
            }
            com_ushareit_listenit_cxa2 = com_ushareit_listenit_cxa4;
            com_ushareit_listenit_cxa3 = a;
        }
        return (com_ushareit_listenit_cxa3.mo1629a(com_ushareit_listenit_cqq).mo1635b() || com_ushareit_listenit_cxa2 == null) ? com_ushareit_listenit_cxa3 : com_ushareit_listenit_cxa3.mo1630a(com_ushareit_listenit_cqq.m12338a(cwc.m13142c()), com_ushareit_listenit_cxa2);
    }

    public static cpz m12235b(Map<cqq, cxa> map) {
        cui a = cui.m12736a();
        cui com_ushareit_listenit_cui = a;
        for (Entry entry : map.entrySet()) {
            com_ushareit_listenit_cui = com_ushareit_listenit_cui.m12740a((cqq) entry.getKey(), new cui((cxa) entry.getValue()));
        }
        return new cpz(com_ushareit_listenit_cui);
    }

    public cpz m12236a(cqq com_ushareit_listenit_cqq) {
        return com_ushareit_listenit_cqq.m12347h() ? f8683b : new cpz(this.f8684c.m12740a(com_ushareit_listenit_cqq, cui.m12736a()));
    }

    public cpz m12237a(cqq com_ushareit_listenit_cqq, cpz com_ushareit_listenit_cpz) {
        return (cpz) com_ushareit_listenit_cpz.f8684c.m12743a((Object) this, new cqa(this, com_ushareit_listenit_cqq));
    }

    public cpz m12238a(cqq com_ushareit_listenit_cqq, cxa com_ushareit_listenit_cxa) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return new cpz(new cui(com_ushareit_listenit_cxa));
        }
        cqq a = this.f8684c.m12738a(com_ushareit_listenit_cqq);
        if (a != null) {
            cqq a2 = cqq.m12333a(a, com_ushareit_listenit_cqq);
            cxa com_ushareit_listenit_cxa2 = (cxa) this.f8684c.m12754e(a);
            cwc g = a2.m12346g();
            if (g != null && g.m13145e() && com_ushareit_listenit_cxa2.mo1629a(a2.m12345f()).mo1635b()) {
                return this;
            }
            return new cpz(this.f8684c.m12741a(a, com_ushareit_listenit_cxa2.mo1630a(a2, com_ushareit_listenit_cxa)));
        }
        return new cpz(this.f8684c.m12740a(com_ushareit_listenit_cqq, new cui(com_ushareit_listenit_cxa)));
    }

    public cpz m12239a(cwc com_ushareit_listenit_cwc, cxa com_ushareit_listenit_cxa) {
        return m12238a(new cqq(com_ushareit_listenit_cwc), com_ushareit_listenit_cxa);
    }

    public cxa m12240a(cxa com_ushareit_listenit_cxa) {
        return m12234a(cqq.m12332a(), this.f8684c, com_ushareit_listenit_cxa);
    }

    public Map<String, Object> m12241a(boolean z) {
        Map<String, Object> hashMap = new HashMap();
        this.f8684c.m12744a(new cqb(this, hashMap, z));
        return hashMap;
    }

    public cxa m12242b() {
        return (cxa) this.f8684c.m12746b();
    }

    public boolean m12243b(cqq com_ushareit_listenit_cqq) {
        return m12244c(com_ushareit_listenit_cqq) != null;
    }

    public cxa m12244c(cqq com_ushareit_listenit_cqq) {
        cqq a = this.f8684c.m12738a(com_ushareit_listenit_cqq);
        return a != null ? ((cxa) this.f8684c.m12754e(a)).mo1629a(cqq.m12333a(a, com_ushareit_listenit_cqq)) : null;
    }

    public List<cwz> m12245c() {
        List<cwz> arrayList = new ArrayList();
        if (this.f8684c.m12746b() != null) {
            for (cwz com_ushareit_listenit_cwz : (cxa) this.f8684c.m12746b()) {
                arrayList.add(new cwz(com_ushareit_listenit_cwz.m13267c(), com_ushareit_listenit_cwz.m13268d()));
            }
        } else {
            Iterator it = this.f8684c.m12749c().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                cui com_ushareit_listenit_cui = (cui) entry.getValue();
                if (com_ushareit_listenit_cui.m12746b() != null) {
                    arrayList.add(new cwz((cwc) entry.getKey(), (cxa) com_ushareit_listenit_cui.m12746b()));
                }
            }
        }
        return arrayList;
    }

    public cpz m12246d(cqq com_ushareit_listenit_cqq) {
        if (com_ushareit_listenit_cqq.m12347h()) {
            return this;
        }
        cxa c = m12244c(com_ushareit_listenit_cqq);
        return c != null ? new cpz(new cui(c)) : new cpz(this.f8684c.m12750c(com_ushareit_listenit_cqq));
    }

    public Map<cwc, cpz> m12247d() {
        Map<cwc, cpz> hashMap = new HashMap();
        Iterator it = this.f8684c.m12749c().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put((cwc) entry.getKey(), new cpz((cui) entry.getValue()));
        }
        return hashMap;
    }

    public boolean m12248e() {
        return this.f8684c.m12753d();
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || obj.getClass() != getClass()) ? false : ((cpz) obj).m12241a(true).equals(m12241a(true));
    }

    public int hashCode() {
        return m12241a(true).hashCode();
    }

    public Iterator<Entry<cqq, cxa>> iterator() {
        return this.f8684c.iterator();
    }

    public String toString() {
        String valueOf = String.valueOf(m12241a(true).toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 15).append("CompoundWrite{").append(valueOf).append("}").toString();
    }
}
