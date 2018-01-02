package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class czd {
    private Map<String, Map<String, byte[]>> f9396a;
    private long f9397b;

    public czd(Map<String, Map<String, byte[]>> map, long j) {
        this.f9396a = map;
        this.f9397b = j;
    }

    public Map<String, Map<String, byte[]>> m13450a() {
        return this.f9396a;
    }

    public void m13451a(long j) {
        this.f9397b = j;
    }

    public void m13452a(Map<String, byte[]> map, String str) {
        if (this.f9396a == null) {
            this.f9396a = new HashMap();
        }
        this.f9396a.put(str, map);
    }

    public boolean m13453a(String str) {
        if (str == null) {
            return false;
        }
        boolean z = (!m13455b() || this.f9396a.get(str) == null || ((Map) this.f9396a.get(str)).isEmpty()) ? false : true;
        return z;
    }

    public boolean m13454a(String str, String str2) {
        return m13455b() && m13453a(str2) && m13456b(str, str2) != null;
    }

    public boolean m13455b() {
        return (this.f9396a == null || this.f9396a.isEmpty()) ? false : true;
    }

    public byte[] m13456b(String str, String str2) {
        return (str == null || !m13453a(str2)) ? null : (byte[]) ((Map) this.f9396a.get(str2)).get(str);
    }

    public long m13457c() {
        return this.f9397b;
    }
}
