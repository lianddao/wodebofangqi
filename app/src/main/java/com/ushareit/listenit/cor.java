package com.ushareit.listenit;

import com.umeng.analytics.pro.C0321x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class cor implements cog, cop {
    static final /* synthetic */ boolean f8566a = (!cor.class.desiredAssertionStatus());
    private static long f8567b = 0;
    private ScheduledFuture<?> f8568A = null;
    private long f8569B;
    private boolean f8570C;
    private final coq f8571c;
    private final con f8572d;
    private String f8573e;
    private HashSet<String> f8574f = new HashSet();
    private boolean f8575g = true;
    private long f8576h;
    private cof f8577i;
    private cpb f8578j = cpb.Disconnected;
    private long f8579k = 0;
    private long f8580l = 0;
    private Map<Long, cpa> f8581m;
    private List<cpd> f8582n;
    private Map<Long, cpf> f8583o;
    private Map<cpc, cpe> f8584p;
    private String f8585q;
    private boolean f8586r;
    private final col f8587s;
    private final coj f8588t;
    private final ScheduledExecutorService f8589u;
    private final cvy f8590v;
    private final cps f8591w;
    private String f8592x;
    private long f8593y = 0;
    private int f8594z = 0;

    public cor(col com_ushareit_listenit_col, con com_ushareit_listenit_con, coq com_ushareit_listenit_coq) {
        this.f8571c = com_ushareit_listenit_coq;
        this.f8587s = com_ushareit_listenit_col;
        this.f8589u = com_ushareit_listenit_col.m12027c();
        this.f8588t = com_ushareit_listenit_col.m12026b();
        this.f8572d = com_ushareit_listenit_con;
        this.f8584p = new HashMap();
        this.f8581m = new HashMap();
        this.f8583o = new HashMap();
        this.f8582n = new ArrayList();
        this.f8591w = new cpu(this.f8589u, com_ushareit_listenit_col.m12025a(), "ConnectionRetryHelper").m12220a(1000).m12219a(1.3d).m12222b(30000).m12221b(0.7d).m12218a();
        long j = f8567b;
        f8567b = 1 + j;
        this.f8590v = new cvy(com_ushareit_listenit_col.m12025a(), "PersistentConnection", "pc_" + j);
        this.f8592x = null;
        m12117q();
    }

    private cpe m12068a(cpc com_ushareit_listenit_cpc) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf = String.valueOf(com_ushareit_listenit_cpc);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 15).append("removing query ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f8584p.containsKey(com_ushareit_listenit_cpc)) {
            cpe com_ushareit_listenit_cpe = (cpe) this.f8584p.get(com_ushareit_listenit_cpc);
            this.f8584p.remove(com_ushareit_listenit_cpc);
            m12117q();
            return com_ushareit_listenit_cpe;
        }
        if (this.f8590v.m13094a()) {
            com_ushareit_listenit_cvy = this.f8590v;
            valueOf = String.valueOf(com_ushareit_listenit_cpc);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 64).append("Trying to remove listener for QuerySpec ").append(valueOf).append(" but no listener exists.").toString(), new Object[0]);
        }
        return null;
    }

    private Collection<cpe> m12071a(List<String> list) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf = String.valueOf(list);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 29).append("removing all listens at path ").append(valueOf).toString(), new Object[0]);
        }
        Collection<cpe> arrayList = new ArrayList();
        for (Entry entry : this.f8584p.entrySet()) {
            cpc com_ushareit_listenit_cpc = (cpc) entry.getKey();
            cpe com_ushareit_listenit_cpe = (cpe) entry.getValue();
            if (com_ushareit_listenit_cpc.f8618a.equals(list)) {
                arrayList.add(com_ushareit_listenit_cpe);
            }
        }
        for (cpe com_ushareit_listenit_cpe2 : arrayList) {
            this.f8584p.remove(com_ushareit_listenit_cpe2.m12160a());
        }
        m12117q();
        return arrayList;
    }

    private Map<String, Object> m12072a(List<String> list, Object obj, String str) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("p", com.m12032a((List) list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void m12074a(long j) {
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.f8571c.mo1560a(hashMap);
    }

    private void m12076a(cpe com_ushareit_listenit_cpe) {
        Map hashMap = new HashMap();
        hashMap.put("p", com.m12032a(com_ushareit_listenit_cpe.f8625b.f8618a));
        Long b = com_ushareit_listenit_cpe.m12161b();
        if (b != null) {
            hashMap.put("q", com_ushareit_listenit_cpe.m12160a().f8619b);
            hashMap.put("t", b);
        }
        m12081a("n", hashMap, null);
    }

    private void m12077a(String str, String str2) {
        this.f8590v.m13090a(new StringBuilder((String.valueOf(str).length() + 23) + String.valueOf(str2).length()).append("Auth token revoked: ").append(str).append(" (").append(str2).append(")").toString());
        this.f8585q = null;
        this.f8586r = true;
        this.f8571c.mo1561a(false);
        this.f8577i.m12016b();
    }

    private void m12078a(String str, List<String> list, Object obj, cph com_ushareit_listenit_cph) {
        Map hashMap = new HashMap();
        hashMap.put("p", com.m12032a((List) list));
        hashMap.put("d", obj);
        m12081a(str, hashMap, new cou(this, com_ushareit_listenit_cph));
    }

    private void m12079a(String str, List<String> list, Object obj, String str2, cph com_ushareit_listenit_cph) {
        Map a = m12072a((List) list, obj, str2);
        long j = this.f8579k;
        this.f8579k = 1 + j;
        this.f8583o.put(Long.valueOf(j), new cpf(str, a, com_ushareit_listenit_cph));
        if (m12098g()) {
            m12087b(j);
        }
        this.f8569B = System.currentTimeMillis();
        m12117q();
    }

    private void m12080a(String str, Map<String, Object> map) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf = String.valueOf(map);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(valueOf).length()).append("handleServerMessage: ").append(str).append(" ").append(valueOf).toString(), new Object[0]);
        }
        String str2;
        cvy com_ushareit_listenit_cvy2;
        String str3;
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long a = com.m12031a(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.f8571c.mo1558a(com.m12033a(str2), obj, equals, a);
            } else if (this.f8590v.m13094a()) {
                com_ushareit_listenit_cvy2 = this.f8590v;
                str3 = "ignoring empty merge for path ";
                str2 = String.valueOf(str2);
                com_ushareit_listenit_cvy2.m13093a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
            }
        } else if (str.equals("rm")) {
            str2 = (String) map.get("p");
            List a2 = com.m12033a(str2);
            Object obj2 = map.get("d");
            Long a3 = com.m12031a(map.get("t"));
            List<Map> list = (List) obj2;
            List arrayList = new ArrayList();
            for (Map map2 : list) {
                str3 = (String) map2.get("s");
                String str4 = (String) map2.get("e");
                arrayList.add(new cpg(str3 != null ? com.m12033a(str3) : null, str4 != null ? com.m12033a(str4) : null, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.f8571c.mo1559a(a2, arrayList, a3);
            } else if (this.f8590v.m13094a()) {
                com_ushareit_listenit_cvy2 = this.f8590v;
                str3 = "Ignoring empty range merge for path ";
                str2 = String.valueOf(str2);
                com_ushareit_listenit_cvy2.m13093a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
            }
        } else if (str.equals("c")) {
            m12089b(com.m12033a((String) map.get("p")));
        } else if (str.equals("ac")) {
            m12077a((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals("sd")) {
            m12090b((Map) map);
        } else if (this.f8590v.m13094a()) {
            com_ushareit_listenit_cvy2 = this.f8590v;
            str3 = "Unrecognized action from server: ";
            str2 = String.valueOf(str);
            com_ushareit_listenit_cvy2.m13093a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
        }
    }

    private void m12081a(String str, Map<String, Object> map, cpa com_ushareit_listenit_cpa) {
        m12082a(str, false, (Map) map, com_ushareit_listenit_cpa);
    }

    private void m12082a(String str, boolean z, Map<String, Object> map, cpa com_ushareit_listenit_cpa) {
        long p = m12115p();
        Map hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(p));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.f8577i.m12014a(hashMap, z);
        this.f8581m.put(Long.valueOf(p), com_ushareit_listenit_cpa);
    }

    private void m12083a(List<String> list, cpc com_ushareit_listenit_cpc) {
        if (list.contains("no_index")) {
            String valueOf = String.valueOf(com_ushareit_listenit_cpc.f8619b.get("i"));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 14).append("\".indexOn\": \"").append(valueOf).append("\"").toString();
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf2 = String.valueOf(com.m12032a(com_ushareit_listenit_cpc.f8618a));
            com_ushareit_listenit_cvy.m13090a(new StringBuilder((String.valueOf(valueOf).length() + 118) + String.valueOf(valueOf2).length()).append("Using an unspecified index. Consider adding '").append(valueOf).append("' at ").append(valueOf2).append(" to your security and Firebase Database rules for better performance").toString());
        }
    }

    private void m12084a(boolean z) {
        com.m12035a(m12096f(), "Must be connected to send auth, but was: %s", this.f8578j);
        com.m12035a(this.f8585q != null, "Auth token must be set to authenticate!", new Object[0]);
        cpa com_ushareit_listenit_cov = new cov(this, z);
        Map hashMap = new HashMap();
        cyf a = cyf.m13362a(this.f8585q);
        if (a != null) {
            hashMap.put("cred", a.m13363a());
            if (a.m13364b() != null) {
                hashMap.put("authvar", a.m13364b());
            }
            m12082a("gauth", true, hashMap, com_ushareit_listenit_cov);
            return;
        }
        hashMap.put("cred", this.f8585q);
        m12082a("auth", true, hashMap, com_ushareit_listenit_cov);
    }

    private void m12087b(long j) {
        if (f8566a || m12098g()) {
            cpf com_ushareit_listenit_cpf = (cpf) this.f8583o.get(Long.valueOf(j));
            cph c = com_ushareit_listenit_cpf.m12166c();
            String a = com_ushareit_listenit_cpf.m12164a();
            com_ushareit_listenit_cpf.m12167d();
            m12081a(a, com_ushareit_listenit_cpf.m12165b(), new cow(this, a, j, com_ushareit_listenit_cpf, c));
            return;
        }
        throw new AssertionError("sendPut called when we can't send writes (we're disconnected or writes are paused).");
    }

    private void m12088b(cpe com_ushareit_listenit_cpe) {
        Map hashMap = new HashMap();
        hashMap.put("p", com.m12032a(com_ushareit_listenit_cpe.m12160a().f8618a));
        Long b = com_ushareit_listenit_cpe.m12161b();
        if (b != null) {
            hashMap.put("q", com_ushareit_listenit_cpe.f8625b.f8619b);
            hashMap.put("t", b);
        }
        coo c = com_ushareit_listenit_cpe.m12162c();
        hashMap.put("h", c.mo1576a());
        if (c.mo1578b()) {
            coe c2 = c.mo1579c();
            List arrayList = new ArrayList();
            for (List a : c2.m12000a()) {
                arrayList.add(com.m12032a(a));
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("hs", c2.m12001b());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        m12081a("q", hashMap, new cox(this, com_ushareit_listenit_cpe));
    }

    private void m12089b(List<String> list) {
        Collection<cpe> a = m12071a((List) list);
        if (a != null) {
            for (cpe b : a) {
                b.f8624a.mo1571a("permission_denied", null);
            }
        }
    }

    private void m12090b(Map<String, Object> map) {
        this.f8590v.m13095b((String) map.get("msg"));
    }

    private void m12092c(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put("c", map);
            m12081a("s", hashMap, new coy(this));
        } else if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private boolean m12096f() {
        return this.f8578j == cpb.Authenticating || this.f8578j == cpb.Connected;
    }

    private boolean m12098g() {
        return this.f8578j == cpb.Connected;
    }

    private void m12099h() {
        if (m12140e()) {
            com.m12035a(this.f8578j == cpb.Disconnected, "Not in disconnected state: %s", this.f8578j);
            boolean z = this.f8586r;
            this.f8590v.m13093a("Scheduling connection attempt", new Object[0]);
            this.f8586r = false;
            this.f8591w.m12215a(new cos(this, z));
        }
    }

    private void m12102i() {
        Iterator it = this.f8583o.entrySet().iterator();
        while (it.hasNext()) {
            cpf com_ushareit_listenit_cpf = (cpf) ((Entry) it.next()).getValue();
            if (com_ushareit_listenit_cpf.m12165b().containsKey("h") && com_ushareit_listenit_cpf.m12168e()) {
                com_ushareit_listenit_cpf.m12166c().mo1571a("disconnected", null);
                it.remove();
            }
        }
    }

    private void m12104j() {
        m12084a(false);
    }

    private void m12106k() {
        m12084a(true);
    }

    private void m12108l() {
        com.m12035a(m12096f(), "Must be connected to send unauth.", new Object[0]);
        com.m12035a(this.f8585q == null, "Auth token must not be set.", new Object[0]);
        m12081a("unauth", Collections.emptyMap(), null);
    }

    private void m12110m() {
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("calling restore state", new Object[0]);
        }
        com.m12035a(this.f8578j == cpb.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.f8578j);
        if (this.f8585q == null) {
            if (this.f8590v.m13094a()) {
                this.f8590v.m13093a("Not restoring auth because token is null.", new Object[0]);
            }
            this.f8578j = cpb.Connected;
            m12111n();
            return;
        }
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("Restoring auth.", new Object[0]);
        }
        this.f8578j = cpb.Authenticating;
        m12106k();
    }

    private void m12111n() {
        com.m12035a(this.f8578j == cpb.Connected, "Should be connected if we're restoring state, but we are: %s", this.f8578j);
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("Restoring outstanding listens", new Object[0]);
        }
        for (cpe com_ushareit_listenit_cpe : this.f8584p.values()) {
            if (this.f8590v.m13094a()) {
                cvy com_ushareit_listenit_cvy = this.f8590v;
                String valueOf = String.valueOf(com_ushareit_listenit_cpe.m12160a());
                com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Restoring listen ").append(valueOf).toString(), new Object[0]);
            }
            m12088b(com_ushareit_listenit_cpe);
        }
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("Restoring writes.", new Object[0]);
        }
        Object arrayList = new ArrayList(this.f8583o.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m12087b(((Long) it.next()).longValue());
        }
        for (cpd com_ushareit_listenit_cpd : this.f8582n) {
            m12078a(com_ushareit_listenit_cpd.m12154a(), com_ushareit_listenit_cpd.m12155b(), com_ushareit_listenit_cpd.m12156c(), com_ushareit_listenit_cpd.m12157d());
        }
        this.f8582n.clear();
    }

    private void m12114o() {
        Map hashMap = new HashMap();
        String str;
        String valueOf;
        if (cye.m13360a()) {
            if (this.f8587s.m12028d()) {
                hashMap.put("persistence.android.enabled", Integer.valueOf(1));
            }
            str = "sdk.android.";
            valueOf = String.valueOf(this.f8587s.m12029e().replace('.', '-'));
            hashMap.put(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.valueOf(1));
        } else if (f8566a || !this.f8587s.m12028d()) {
            str = "sdk.java.";
            valueOf = String.valueOf(this.f8587s.m12029e().replace('.', '-'));
            hashMap.put(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.valueOf(1));
        } else {
            throw new AssertionError("Stats for persistence on JVM missing (persistence not yet supported)");
        }
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("Sending first connection stats", new Object[0]);
        }
        m12092c(hashMap);
    }

    private long m12115p() {
        long j = this.f8580l;
        this.f8580l = 1 + j;
        return j;
    }

    private void m12117q() {
        boolean z = false;
        if (m12118r()) {
            if (this.f8568A != null) {
                this.f8568A.cancel(false);
            }
            this.f8568A = this.f8589u.schedule(new coz(this), 60000, TimeUnit.MILLISECONDS);
        } else if (mo1536f("connection_idle")) {
            if (!m12118r()) {
                z = true;
            }
            com.m12034a(z);
            mo1535e("connection_idle");
        }
    }

    private boolean m12118r() {
        return this.f8584p.isEmpty() && this.f8581m.isEmpty() && !this.f8570C && this.f8583o.isEmpty();
    }

    private boolean m12119s() {
        return m12118r() && System.currentTimeMillis() > this.f8569B + 60000;
    }

    public void mo1516a() {
        m12099h();
    }

    public void mo1517a(long j, String str) {
        if (this.f8590v.m13094a()) {
            this.f8590v.m13093a("onReady", new Object[0]);
        }
        this.f8576h = System.currentTimeMillis();
        m12074a(j);
        if (this.f8575g) {
            m12114o();
        }
        m12110m();
        this.f8575g = false;
        this.f8592x = str;
        this.f8571c.mo1557a();
    }

    public void mo1518a(coh com_ushareit_listenit_coh) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String str = "Got on disconnect due to ";
            String valueOf = String.valueOf(com_ushareit_listenit_coh.name());
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.f8578j = cpb.Disconnected;
        this.f8577i = null;
        this.f8570C = false;
        this.f8581m.clear();
        m12102i();
        if (m12140e()) {
            boolean z = this.f8576h > 0 ? System.currentTimeMillis() - this.f8576h > 30000 : false;
            if (com_ushareit_listenit_coh == coh.SERVER_RESET || r0) {
                this.f8591w.m12214a();
            }
            m12099h();
        }
        this.f8576h = 0;
        this.f8571c.mo1562b();
    }

    public void mo1519a(String str) {
        this.f8573e = str;
    }

    public void mo1520a(List<String> list, cph com_ushareit_listenit_cph) {
        if (m12098g()) {
            m12078a("oc", (List) list, null, com_ushareit_listenit_cph);
        } else {
            this.f8582n.add(new cpd("oc", list, null, com_ushareit_listenit_cph));
        }
        m12117q();
    }

    public void mo1521a(List<String> list, Object obj, cph com_ushareit_listenit_cph) {
        m12079a("p", (List) list, obj, null, com_ushareit_listenit_cph);
    }

    public void mo1522a(List<String> list, Object obj, String str, cph com_ushareit_listenit_cph) {
        m12079a("p", (List) list, obj, str, com_ushareit_listenit_cph);
    }

    public void mo1523a(List<String> list, Map<String, Object> map) {
        cpc com_ushareit_listenit_cpc = new cpc(list, map);
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf = String.valueOf(com_ushareit_listenit_cpc);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 15).append("unlistening on ").append(valueOf).toString(), new Object[0]);
        }
        cpe a = m12068a(com_ushareit_listenit_cpc);
        if (a != null && m12096f()) {
            m12076a(a);
        }
        m12117q();
    }

    public void mo1524a(List<String> list, Map<String, Object> map, coo com_ushareit_listenit_coo, Long l, cph com_ushareit_listenit_cph) {
        cpc com_ushareit_listenit_cpc = new cpc(list, map);
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String valueOf = String.valueOf(com_ushareit_listenit_cpc);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 13).append("Listening on ").append(valueOf).toString(), new Object[0]);
        }
        com.m12035a(!this.f8584p.containsKey(com_ushareit_listenit_cpc), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.f8590v.m13094a()) {
            com_ushareit_listenit_cvy = this.f8590v;
            valueOf = String.valueOf(com_ushareit_listenit_cpc);
            com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 21).append("Adding listen query: ").append(valueOf).toString(), new Object[0]);
        }
        cpe com_ushareit_listenit_cpe = new cpe(com_ushareit_listenit_cph, com_ushareit_listenit_cpc, l, com_ushareit_listenit_coo);
        this.f8584p.put(com_ushareit_listenit_cpc, com_ushareit_listenit_cpe);
        if (m12096f()) {
            m12088b(com_ushareit_listenit_cpe);
        }
        m12117q();
    }

    public void mo1525a(List<String> list, Map<String, Object> map, cph com_ushareit_listenit_cph) {
        m12079a("m", (List) list, (Object) map, null, com_ushareit_listenit_cph);
    }

    public void mo1526a(Map<String, Object> map) {
        if (map.containsKey("r")) {
            cpa com_ushareit_listenit_cpa = (cpa) this.f8581m.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (com_ushareit_listenit_cpa != null) {
                com_ushareit_listenit_cpa.mo1539a((Map) map.get("b"));
            }
        } else if (!map.containsKey(C0321x.aF)) {
            if (map.containsKey("a")) {
                m12080a((String) map.get("a"), (Map) map.get("b"));
            } else if (this.f8590v.m13094a()) {
                cvy com_ushareit_listenit_cvy = this.f8590v;
                String valueOf = String.valueOf(map);
                com_ushareit_listenit_cvy.m13093a(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Ignoring unknown message: ").append(valueOf).toString(), new Object[0]);
            }
        }
    }

    public void mo1527b() {
        mo1534d("shutdown");
    }

    public void mo1528b(String str) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String str2 = "Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ";
            String valueOf = String.valueOf(str);
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        mo1534d("server_kill");
    }

    public void mo1529b(List<String> list, Object obj, cph com_ushareit_listenit_cph) {
        this.f8570C = true;
        if (m12098g()) {
            m12078a("o", (List) list, obj, com_ushareit_listenit_cph);
        } else {
            this.f8582n.add(new cpd("o", list, obj, com_ushareit_listenit_cph));
        }
        m12117q();
    }

    public void mo1530b(List<String> list, Map<String, Object> map, cph com_ushareit_listenit_cph) {
        this.f8570C = true;
        if (m12098g()) {
            m12078a("om", (List) list, (Object) map, com_ushareit_listenit_cph);
        } else {
            this.f8582n.add(new cpd("om", list, map, com_ushareit_listenit_cph));
        }
        m12117q();
    }

    public void mo1531c() {
        this.f8590v.m13093a("Auth token refresh requested", new Object[0]);
        mo1534d("token_refresh");
        mo1535e("token_refresh");
    }

    public void mo1532c(String str) {
        this.f8590v.m13093a("Auth token refreshed.", new Object[0]);
        this.f8585q = str;
        if (!m12096f()) {
            return;
        }
        if (str != null) {
            m12104j();
        } else {
            m12108l();
        }
    }

    public void mo1533d() {
        for (cpf com_ushareit_listenit_cpf : this.f8583o.values()) {
            if (com_ushareit_listenit_cpf.f8630c != null) {
                com_ushareit_listenit_cpf.f8630c.mo1571a("write_canceled", null);
            }
        }
        for (cpd com_ushareit_listenit_cpd : this.f8582n) {
            if (com_ushareit_listenit_cpd.f8623d != null) {
                com_ushareit_listenit_cpd.f8623d.mo1571a("write_canceled", null);
            }
        }
        this.f8583o.clear();
        this.f8582n.clear();
        if (!m12096f()) {
            this.f8570C = false;
        }
        m12117q();
    }

    public void mo1534d(String str) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String str2 = "Connection interrupted for: ";
            String valueOf = String.valueOf(str);
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.f8574f.add(str);
        if (this.f8577i != null) {
            this.f8577i.m12016b();
            this.f8577i = null;
        } else {
            this.f8591w.m12217c();
            this.f8578j = cpb.Disconnected;
        }
        this.f8591w.m12214a();
    }

    public void mo1535e(String str) {
        if (this.f8590v.m13094a()) {
            cvy com_ushareit_listenit_cvy = this.f8590v;
            String str2 = "Connection no longer interrupted for: ";
            String valueOf = String.valueOf(str);
            com_ushareit_listenit_cvy.m13093a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.f8574f.remove(str);
        if (m12140e() && this.f8578j == cpb.Disconnected) {
            m12099h();
        }
    }

    boolean m12140e() {
        return this.f8574f.size() == 0;
    }

    public boolean mo1536f(String str) {
        return this.f8574f.contains(str);
    }

    public void m12142g(String str) {
        com.m12035a(this.f8578j == cpb.GettingToken, "Trying to open network connection while in the wrong state: %s", this.f8578j);
        if (str == null) {
            this.f8571c.mo1561a(false);
        }
        this.f8585q = str;
        this.f8578j = cpb.Connecting;
        this.f8577i = new cof(this.f8587s, this.f8572d, this.f8573e, this, this.f8592x);
        this.f8577i.m12011a();
    }
}
