package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class cub {
    static final /* synthetic */ boolean f8985a = (!cub.class.desiredAssertionStatus());
    private static final cum<Map<cvd, cua>> f8986b = new cuc();
    private static final cum<Map<cvd, cua>> f8987c = new cud();
    private static final cum<cua> f8988d = new cue();
    private static final cum<cua> f8989e = new cuf();
    private cui<Map<cvd, cua>> f8990f;
    private final ctv f8991g;
    private final cvy f8992h;
    private final cyh f8993i;
    private long f8994j = 0;

    public cub(ctv com_ushareit_listenit_ctv, cvy com_ushareit_listenit_cvy, cyh com_ushareit_listenit_cyh) {
        this.f8991g = com_ushareit_listenit_ctv;
        this.f8992h = com_ushareit_listenit_cvy;
        this.f8993i = com_ushareit_listenit_cyh;
        this.f8990f = new cui(null);
        m12708c();
        for (cua com_ushareit_listenit_cua : this.f8991g.mo1478c()) {
            this.f8994j = Math.max(com_ushareit_listenit_cua.f8980a + 1, this.f8994j);
            m12703a(com_ushareit_listenit_cua);
        }
    }

    private static long m12701a(ctp com_ushareit_listenit_ctp, long j) {
        return j - Math.min((long) Math.floor((double) ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - com_ushareit_listenit_ctp.mo1590a()) * ((float) j))), com_ushareit_listenit_ctp.mo1593b());
    }

    private List<cua> m12702a(cum<cua> com_ushareit_listenit_cum_com_ushareit_listenit_cua) {
        List<cua> arrayList = new ArrayList();
        Iterator it = this.f8990f.iterator();
        while (it.hasNext()) {
            for (cua com_ushareit_listenit_cua : ((Map) ((Entry) it.next()).getValue()).values()) {
                if (com_ushareit_listenit_cum_com_ushareit_listenit_cua.mo1587a(com_ushareit_listenit_cua)) {
                    arrayList.add(com_ushareit_listenit_cua);
                }
            }
        }
        return arrayList;
    }

    private void m12703a(cua com_ushareit_listenit_cua) {
        Map map;
        m12711g(com_ushareit_listenit_cua.f8981b);
        Map map2 = (Map) this.f8990f.m12754e(com_ushareit_listenit_cua.f8981b.m13002a());
        if (map2 == null) {
            map2 = new HashMap();
            this.f8990f = this.f8990f.m12741a(com_ushareit_listenit_cua.f8981b.m13002a(), (Object) map2);
            map = map2;
        } else {
            map = map2;
        }
        cua com_ushareit_listenit_cua2 = (cua) map.get(com_ushareit_listenit_cua.f8981b.m13003b());
        boolean z = com_ushareit_listenit_cua2 == null || com_ushareit_listenit_cua2.f8980a == com_ushareit_listenit_cua.f8980a;
        cyr.m13387a(z);
        map.put(com_ushareit_listenit_cua.f8981b.m13003b(), com_ushareit_listenit_cua);
    }

    private void m12705a(cvg com_ushareit_listenit_cvg, boolean z) {
        cvg h = m12712h(com_ushareit_listenit_cvg);
        cua a = m12715a(h);
        long a2 = this.f8993i.mo1664a();
        if (a != null) {
            a = a.m12699a(a2).m12700a(z);
        } else if (f8985a || z) {
            long j = this.f8994j;
            this.f8994j = 1 + j;
            a = new cua(j, h, a2, false, z);
        } else {
            throw new AssertionError("If we're setting the query to inactive, we should already be tracking it!");
        }
        m12707b(a);
    }

    private void m12707b(cua com_ushareit_listenit_cua) {
        m12703a(com_ushareit_listenit_cua);
        this.f8991g.mo1474a(com_ushareit_listenit_cua);
    }

    private void m12708c() {
        try {
            this.f8991g.mo1481d();
            this.f8991g.mo1479c(this.f8993i.mo1664a());
            this.f8991g.mo1483f();
        } finally {
            this.f8991g.mo1482e();
        }
    }

    private boolean m12709e(cqq com_ushareit_listenit_cqq) {
        return this.f8990f.m12739a(com_ushareit_listenit_cqq, f8986b) != null;
    }

    private Set<Long> m12710f(cqq com_ushareit_listenit_cqq) {
        Set<Long> hashSet = new HashSet();
        Map map = (Map) this.f8990f.m12754e(com_ushareit_listenit_cqq);
        if (map != null) {
            for (cua com_ushareit_listenit_cua : map.values()) {
                if (!com_ushareit_listenit_cua.f8981b.m13006e()) {
                    hashSet.add(Long.valueOf(com_ushareit_listenit_cua.f8980a));
                }
            }
        }
        return hashSet;
    }

    private static void m12711g(cvg com_ushareit_listenit_cvg) {
        boolean z = !com_ushareit_listenit_cvg.m13006e() || com_ushareit_listenit_cvg.m13005d();
        cyr.m13388a(z, "Can't have tracked non-default query that loads all data");
    }

    private static cvg m12712h(cvg com_ushareit_listenit_cvg) {
        return com_ushareit_listenit_cvg.m13006e() ? cvg.m13000a(com_ushareit_listenit_cvg.m13002a()) : com_ushareit_listenit_cvg;
    }

    public long m12713a() {
        return (long) m12702a(f8988d).size();
    }

    public ctw m12714a(ctp com_ushareit_listenit_ctp) {
        List a = m12702a(f8988d);
        long a2 = m12701a(com_ushareit_listenit_ctp, (long) a.size());
        ctw com_ushareit_listenit_ctw = new ctw();
        if (this.f8992h.m13094a()) {
            this.f8992h.m13093a("Pruning old queries.  Prunable: " + a.size() + " Count to prune: " + a2, new Object[0]);
        }
        Collections.sort(a, new cuh(this));
        for (int i = 0; ((long) i) < a2; i++) {
            cua com_ushareit_listenit_cua = (cua) a.get(i);
            com_ushareit_listenit_ctw = com_ushareit_listenit_ctw.m12689c(com_ushareit_listenit_cua.f8981b.m13002a());
            m12718b(com_ushareit_listenit_cua.f8981b);
        }
        ctw com_ushareit_listenit_ctw2 = com_ushareit_listenit_ctw;
        for (int i2 = (int) a2; i2 < a.size(); i2++) {
            com_ushareit_listenit_ctw2 = com_ushareit_listenit_ctw2.m12690d(((cua) a.get(i2)).f8981b.m13002a());
        }
        List<cua> a3 = m12702a(f8989e);
        if (this.f8992h.m13094a()) {
            this.f8992h.m13093a("Unprunable queries: " + a3.size(), new Object[0]);
        }
        for (cua com_ushareit_listenit_cua2 : a3) {
            com_ushareit_listenit_ctw2 = com_ushareit_listenit_ctw2.m12690d(com_ushareit_listenit_cua2.f8981b.m13002a());
        }
        return com_ushareit_listenit_ctw2;
    }

    public cua m12715a(cvg com_ushareit_listenit_cvg) {
        cvg h = m12712h(com_ushareit_listenit_cvg);
        Map map = (Map) this.f8990f.m12754e(h.m13002a());
        return map != null ? (cua) map.get(h.m13003b()) : null;
    }

    public void m12716a(cqq com_ushareit_listenit_cqq) {
        this.f8990f.m12750c(com_ushareit_listenit_cqq).m12744a(new cug(this));
    }

    public Set<cwc> m12717b(cqq com_ushareit_listenit_cqq) {
        if (f8985a || !m12724f(cvg.m13000a(com_ushareit_listenit_cqq))) {
            Set<cwc> hashSet = new HashSet();
            Set f = m12710f(com_ushareit_listenit_cqq);
            if (!f.isEmpty()) {
                hashSet.addAll(this.f8991g.mo1465a(f));
            }
            Iterator it = this.f8990f.m12750c(com_ushareit_listenit_cqq).m12749c().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                cwc com_ushareit_listenit_cwc = (cwc) entry.getKey();
                cui com_ushareit_listenit_cui = (cui) entry.getValue();
                if (com_ushareit_listenit_cui.m12746b() != null && f8986b.mo1587a((Map) com_ushareit_listenit_cui.m12746b())) {
                    hashSet.add(com_ushareit_listenit_cwc);
                }
            }
            return hashSet;
        }
        throw new AssertionError("Path is fully complete.");
    }

    public void m12718b(cvg com_ushareit_listenit_cvg) {
        cvg h = m12712h(com_ushareit_listenit_cvg);
        cua a = m12715a(h);
        if (f8985a || a != null) {
            this.f8991g.mo1476b(a.f8980a);
            Map map = (Map) this.f8990f.m12754e(h.m13002a());
            map.remove(h.m13003b());
            if (map.isEmpty()) {
                this.f8990f = this.f8990f.m12752d(h.m13002a());
                return;
            }
            return;
        }
        throw new AssertionError("Query must exist to be removed.");
    }

    public void m12719c(cqq com_ushareit_listenit_cqq) {
        if (!m12709e(com_ushareit_listenit_cqq)) {
            cvg a = cvg.m13000a(com_ushareit_listenit_cqq);
            cua a2 = m12715a(a);
            if (a2 == null) {
                long j = this.f8994j;
                this.f8994j = 1 + j;
                a2 = new cua(j, a, this.f8993i.mo1664a(), true, false);
            } else if (f8985a || !a2.f8983d) {
                a2 = a2.m12698a();
            } else {
                throw new AssertionError("This should have been handled above!");
            }
            m12707b(a2);
        }
    }

    public void m12720c(cvg com_ushareit_listenit_cvg) {
        m12705a(com_ushareit_listenit_cvg, true);
    }

    public void m12721d(cvg com_ushareit_listenit_cvg) {
        m12705a(com_ushareit_listenit_cvg, false);
    }

    public boolean m12722d(cqq com_ushareit_listenit_cqq) {
        return this.f8990f.m12748b(com_ushareit_listenit_cqq, f8987c) != null;
    }

    public void m12723e(cvg com_ushareit_listenit_cvg) {
        cua a = m12715a(m12712h(com_ushareit_listenit_cvg));
        if (a != null && !a.f8983d) {
            m12707b(a.m12698a());
        }
    }

    public boolean m12724f(cvg com_ushareit_listenit_cvg) {
        if (m12709e(com_ushareit_listenit_cvg.m13002a())) {
            return true;
        }
        if (com_ushareit_listenit_cvg.m13006e()) {
            return false;
        }
        Map map = (Map) this.f8990f.m12754e(com_ushareit_listenit_cvg.m13002a());
        boolean z = map != null && map.containsKey(com_ushareit_listenit_cvg.m13003b()) && ((cua) map.get(com_ushareit_listenit_cvg.m13003b())).f8983d;
        return z;
    }
}
