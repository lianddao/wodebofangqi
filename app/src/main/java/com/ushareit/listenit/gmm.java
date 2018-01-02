package com.ushareit.listenit;

import java.util.List;

class gmm implements gmb<List<fni>> {
    final /* synthetic */ long f14420a;
    final /* synthetic */ gmk f14421b;

    gmm(gmk com_ushareit_listenit_gmk, long j) {
        this.f14421b = com_ushareit_listenit_gmk;
        this.f14420a = j;
    }

    public void m22458a(List<fni> list) {
        long j = 1000;
        if (System.currentTimeMillis() - this.f14420a > 1000) {
            j = 0;
        }
        hhx.m23869a(new gmn(this, list), 0, (int) j);
    }
}
