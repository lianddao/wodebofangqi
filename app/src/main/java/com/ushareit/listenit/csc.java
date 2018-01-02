package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class csc {
    static final /* synthetic */ boolean f8841a = (!csc.class.desiredAssertionStatus());
    private final Map<cvd, cvh> f8842b = new HashMap();
    private final ctu f8843c;

    public csc(ctu com_ushareit_listenit_ctu) {
        this.f8843c = com_ushareit_listenit_ctu;
    }

    private List<cuw> m12467a(cvh com_ushareit_listenit_cvh, ctk com_ushareit_listenit_ctk, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa) {
        cvi a = com_ushareit_listenit_cvh.m13009a(com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa);
        if (!com_ushareit_listenit_cvh.m13008a().m13006e()) {
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            for (cuv com_ushareit_listenit_cuv : a.f9207b) {
                cuy b = com_ushareit_listenit_cuv.m12960b();
                if (b == cuy.CHILD_ADDED) {
                    hashSet2.add(com_ushareit_listenit_cuv.m12959a());
                } else if (b == cuy.CHILD_REMOVED) {
                    hashSet.add(com_ushareit_listenit_cuv.m12959a());
                }
            }
            if (!(hashSet2.isEmpty() && hashSet.isEmpty())) {
                this.f8843c.mo1604a(com_ushareit_listenit_cvh.m13008a(), hashSet2, hashSet);
            }
        }
        return a.f9206a;
    }

    public cvh m12468a(cvg com_ushareit_listenit_cvg) {
        return com_ushareit_listenit_cvg.m13006e() ? m12477d() : (cvh) this.f8842b.get(com_ushareit_listenit_cvg.m13003b());
    }

    public cxa m12469a(cqq com_ushareit_listenit_cqq) {
        for (cvh com_ushareit_listenit_cvh : this.f8842b.values()) {
            if (com_ushareit_listenit_cvh.m13010a(com_ushareit_listenit_cqq) != null) {
                return com_ushareit_listenit_cvh.m13010a(com_ushareit_listenit_cqq);
            }
        }
        return null;
    }

    public cyp<List<cvg>, List<cux>> m12470a(cvg com_ushareit_listenit_cvg, cqh com_ushareit_listenit_cqh, ece com_ushareit_listenit_ece) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        boolean c = m12476c();
        cvh com_ushareit_listenit_cvh;
        if (com_ushareit_listenit_cvg.m13005d()) {
            Iterator it = this.f8842b.entrySet().iterator();
            while (it.hasNext()) {
                com_ushareit_listenit_cvh = (cvh) ((Entry) it.next()).getValue();
                arrayList2.addAll(com_ushareit_listenit_cvh.m13011a(com_ushareit_listenit_cqh, com_ushareit_listenit_ece));
                if (com_ushareit_listenit_cvh.m13016d()) {
                    it.remove();
                    if (!com_ushareit_listenit_cvh.m13008a().m13006e()) {
                        arrayList.add(com_ushareit_listenit_cvh.m13008a());
                    }
                }
            }
        } else {
            com_ushareit_listenit_cvh = (cvh) this.f8842b.get(com_ushareit_listenit_cvg.m13003b());
            if (com_ushareit_listenit_cvh != null) {
                arrayList2.addAll(com_ushareit_listenit_cvh.m13011a(com_ushareit_listenit_cqh, com_ushareit_listenit_ece));
                if (com_ushareit_listenit_cvh.m13016d()) {
                    this.f8842b.remove(com_ushareit_listenit_cvg.m13003b());
                    if (!com_ushareit_listenit_cvh.m13008a().m13006e()) {
                        arrayList.add(com_ushareit_listenit_cvh.m13008a());
                    }
                }
            }
        }
        if (c && !m12476c()) {
            arrayList.add(cvg.m13000a(com_ushareit_listenit_cvg.m13002a()));
        }
        return new cyp(arrayList, arrayList2);
    }

    public List<cuw> m12471a(cqh com_ushareit_listenit_cqh, ctf com_ushareit_listenit_ctf, cut com_ushareit_listenit_cut) {
        cvg a = com_ushareit_listenit_cqh.mo1582a();
        cvh com_ushareit_listenit_cvh = (cvh) this.f8842b.get(a.m13003b());
        if (com_ushareit_listenit_cvh == null) {
            boolean z;
            cxa a2 = com_ushareit_listenit_ctf.m12599a(com_ushareit_listenit_cut.m12777a() ? com_ushareit_listenit_cut.m12781c() : null);
            if (a2 != null) {
                z = true;
            } else {
                a2 = com_ushareit_listenit_ctf.m12602b(com_ushareit_listenit_cut.m12781c());
                z = false;
            }
            cvh com_ushareit_listenit_cvh2 = new cvh(a, new cvj(new cut(cwt.m13243a(a2, a.m13004c()), z, false), com_ushareit_listenit_cut));
            if (!a.m13006e()) {
                Set hashSet = new HashSet();
                for (cwz c : com_ushareit_listenit_cvh2.m13015c()) {
                    hashSet.add(c.m13267c());
                }
                this.f8843c.mo1603a(a, hashSet);
            }
            this.f8842b.put(a.m13003b(), com_ushareit_listenit_cvh2);
            com_ushareit_listenit_cvh = com_ushareit_listenit_cvh2;
        }
        com_ushareit_listenit_cvh.m13012a(com_ushareit_listenit_cqh);
        return com_ushareit_listenit_cvh.m13014b(com_ushareit_listenit_cqh);
    }

    public List<cuw> m12472a(ctk com_ushareit_listenit_ctk, ctf com_ushareit_listenit_ctf, cxa com_ushareit_listenit_cxa) {
        cvd d = com_ushareit_listenit_ctk.m12610d().m12622d();
        if (d != null) {
            cvh com_ushareit_listenit_cvh = (cvh) this.f8842b.get(d);
            if (f8841a || com_ushareit_listenit_cvh != null) {
                return m12467a(com_ushareit_listenit_cvh, com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa);
            }
            throw new AssertionError();
        }
        List<cuw> arrayList = new ArrayList();
        for (Entry value : this.f8842b.entrySet()) {
            arrayList.addAll(m12467a((cvh) value.getValue(), com_ushareit_listenit_ctk, com_ushareit_listenit_ctf, com_ushareit_listenit_cxa));
        }
        return arrayList;
    }

    public boolean m12473a() {
        return this.f8842b.isEmpty();
    }

    public List<cvh> m12474b() {
        List<cvh> arrayList = new ArrayList();
        for (Entry value : this.f8842b.entrySet()) {
            cvh com_ushareit_listenit_cvh = (cvh) value.getValue();
            if (!com_ushareit_listenit_cvh.m13008a().m13006e()) {
                arrayList.add(com_ushareit_listenit_cvh);
            }
        }
        return arrayList;
    }

    public boolean m12475b(cvg com_ushareit_listenit_cvg) {
        return m12468a(com_ushareit_listenit_cvg) != null;
    }

    public boolean m12476c() {
        return m12477d() != null;
    }

    public cvh m12477d() {
        for (Entry value : this.f8842b.entrySet()) {
            cvh com_ushareit_listenit_cvh = (cvh) value.getValue();
            if (com_ushareit_listenit_cvh.m13008a().m13006e()) {
                return com_ushareit_listenit_cvh;
            }
        }
        return null;
    }
}
