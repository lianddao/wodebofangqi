package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

final class bpm implements bop {
    public static final bpm f7326a = new bpm();
    private final List<bom> f7327b;

    public bpm(bom com_ushareit_listenit_bom) {
        this.f7327b = Collections.singletonList(com_ushareit_listenit_bom);
    }

    private bpm() {
        this.f7327b = Collections.emptyList();
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
        return j >= 0 ? this.f7327b : Collections.emptyList();
    }
}
