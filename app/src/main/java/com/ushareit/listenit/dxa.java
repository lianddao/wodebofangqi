package com.ushareit.listenit;

public final class dxa<V> {
    private final V f10539a;
    private final dpc<V> f10540b;
    private final String f10541c;

    private dxa(String str, dpc<V> com_ushareit_listenit_dpc_V, V v) {
        cfi.m11080a((Object) com_ushareit_listenit_dpc_V);
        this.f10540b = com_ushareit_listenit_dpc_V;
        this.f10539a = v;
        this.f10541c = str;
    }

    static dxa<Integer> m16169a(String str, int i) {
        return m16170a(str, i, i);
    }

    static dxa<Integer> m16170a(String str, int i, int i2) {
        return new dxa(str, dpc.m15217a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    static dxa<Long> m16171a(String str, long j) {
        return m16172a(str, j, j);
    }

    static dxa<Long> m16172a(String str, long j, long j2) {
        return new dxa(str, dpc.m15218a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    static dxa<String> m16173a(String str, String str2) {
        return m16174a(str, str2, str2);
    }

    static dxa<String> m16174a(String str, String str2, String str3) {
        return new dxa(str, dpc.m15219a(str, str3), str2);
    }

    static dxa<Boolean> m16175a(String str, boolean z) {
        return m16176a(str, z, z);
    }

    static dxa<Boolean> m16176a(String str, boolean z, boolean z2) {
        return new dxa(str, dpc.m15220a(str, z2), Boolean.valueOf(z));
    }

    public V m16177a(V v) {
        return v != null ? v : this.f10539a;
    }

    public String m16178a() {
        return this.f10541c;
    }

    public V m16179b() {
        return this.f10539a;
    }
}
