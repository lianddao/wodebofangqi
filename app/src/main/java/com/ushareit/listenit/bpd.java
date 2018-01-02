package com.ushareit.listenit;

import java.util.Collections;
import java.util.List;

final class bpd implements bop {
    private final bom[] f7281a;
    private final long[] f7282b;

    public bpd(bom[] com_ushareit_listenit_bomArr, long[] jArr) {
        this.f7281a = com_ushareit_listenit_bomArr;
        this.f7282b = jArr;
    }

    public int mo1063a(long j) {
        int b = btc.m9773b(this.f7282b, j, false, false);
        return b < this.f7282b.length ? b : -1;
    }

    public int mo1065b() {
        return this.f7282b.length;
    }

    public long mo1064a(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        bsg.m9656a(z);
        if (i >= this.f7282b.length) {
            z2 = false;
        }
        bsg.m9656a(z2);
        return this.f7282b[i];
    }

    public List<bom> mo1066b(long j) {
        int a = btc.m9762a(this.f7282b, j, true, false);
        if (a == -1 || this.f7281a[a] == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.f7281a[a]);
    }
}
