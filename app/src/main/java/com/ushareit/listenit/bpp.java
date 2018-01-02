package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

final class bpp implements bop {
    private final List<bom> f7336a;

    public bpp(List<bom> list) {
        this.f7336a = Collections.unmodifiableList(list);
    }

    public int mo1063a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int mo1065b() {
        return 1;
    }

    public long mo1064a(int i) {
        bsg.m9656a(i == 0);
        return 0;
    }

    public List<bom> mo1066b(long j) {
        return j >= 0 ? this.f7336a : Collections.emptyList();
    }
}
