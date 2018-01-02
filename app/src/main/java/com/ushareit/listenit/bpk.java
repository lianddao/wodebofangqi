package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class bpk implements bop {
    private final bpg f7321a;
    private final long[] f7322b;
    private final Map<String, bpj> f7323c;
    private final Map<String, bph> f7324d;

    public bpk(bpg com_ushareit_listenit_bpg, Map<String, bpj> map, Map<String, bph> map2) {
        this.f7321a = com_ushareit_listenit_bpg;
        this.f7324d = map2;
        this.f7323c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f7322b = com_ushareit_listenit_bpg.m9359b();
    }

    public int mo1063a(long j) {
        int b = btc.m9773b(this.f7322b, j, false, false);
        return b < this.f7322b.length ? b : -1;
    }

    public int mo1065b() {
        return this.f7322b.length;
    }

    public long mo1064a(int i) {
        return this.f7322b[i];
    }

    public List<bom> mo1066b(long j) {
        return this.f7321a.m9356a(j, this.f7323c, this.f7324d);
    }
}
