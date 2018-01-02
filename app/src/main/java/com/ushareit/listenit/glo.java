package com.ushareit.listenit;

import java.util.Comparator;

final class glo implements Comparator<fni> {
    final /* synthetic */ long f14370a;

    glo(long j) {
        this.f14370a = j;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m22376a((fni) obj, (fni) obj2);
    }

    public int m22376a(fni com_ushareit_listenit_fni, fni com_ushareit_listenit_fni2) {
        long abs = Math.abs(this.f14370a - com_ushareit_listenit_fni.getLg());
        long abs2 = Math.abs(this.f14370a - com_ushareit_listenit_fni2.getLg());
        if (abs > abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }
}
