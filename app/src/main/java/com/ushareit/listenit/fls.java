package com.ushareit.listenit;

import java.util.List;

class fls extends fjz {
    final /* synthetic */ List f12939a;
    final /* synthetic */ int f12940b;
    final /* synthetic */ flr f12941c;

    fls(flr com_ushareit_listenit_flr, int i, List list, int i2) {
        this.f12941c = com_ushareit_listenit_flr;
        this.f12939a = list;
        this.f12940b = i2;
        super(i);
    }

    public void mo2390a(boolean z, long j) {
        exw.m18457e("ShareListSync", "startSyncShareLists, result=" + (z ? "success" : "failure"));
        if (z) {
            this.f12941c.m19787a(this.f12939a.size(), this.f12940b);
            gvj.m22918c(this.f12940b);
            fir.m19401h();
        }
    }
}
