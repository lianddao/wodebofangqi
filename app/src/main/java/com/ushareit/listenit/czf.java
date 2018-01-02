package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class czf {
    private int f9401a;
    private long f9402b;
    private Map<String, czb> f9403c;
    private boolean f9404d;

    public czf() {
        this(-1);
    }

    public czf(int i, long j, Map<String, czb> map, boolean z) {
        Map hashMap;
        this.f9401a = i;
        this.f9402b = j;
        if (map == null) {
            hashMap = new HashMap();
        }
        this.f9403c = hashMap;
        this.f9404d = z;
    }

    public czf(long j) {
        this(0, j, null, false);
    }

    public int m13458a() {
        return this.f9401a;
    }

    public void m13459a(int i) {
        this.f9401a = i;
    }

    public void m13460a(long j) {
        this.f9402b = j;
    }

    public void m13461a(String str) {
        if (this.f9403c.get(str) != null) {
            this.f9403c.remove(str);
        }
    }

    public void m13462a(String str, czb com_ushareit_listenit_czb) {
        this.f9403c.put(str, com_ushareit_listenit_czb);
    }

    public void m13463a(Map<String, czb> map) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        this.f9403c = hashMap;
    }

    public void m13464a(boolean z) {
        this.f9404d = z;
    }

    public boolean m13465b() {
        return this.f9404d;
    }

    public Map<String, czb> m13466c() {
        return this.f9403c;
    }

    public long m13467d() {
        return this.f9402b;
    }
}
