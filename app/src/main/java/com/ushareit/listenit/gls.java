package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

final class gls implements ecy {
    final /* synthetic */ gmb f14375a;
    final /* synthetic */ long f14376b;
    final /* synthetic */ int f14377c;

    gls(gmb com_ushareit_listenit_gmb, long j, int i) {
        this.f14375a = com_ushareit_listenit_gmb;
        this.f14376b = j;
        this.f14377c = i;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        List arrayList = new ArrayList();
        if (com_ushareit_listenit_ecb.m16703b() > 0) {
            for (ecb com_ushareit_listenit_fni : com_ushareit_listenit_ecb.m16707e()) {
                arrayList.add(new fni(com_ushareit_listenit_fni));
            }
            glp.f14371a = 0;
            glp.m22392c(arrayList);
            gvj.m22928d(((fni) arrayList.get(arrayList.size() - 1)).getSgN() + 1);
            if (this.f14375a != null) {
                this.f14375a.mo2715a(arrayList);
            }
            exw.m18443a("NearbyProvider", "loadNearbyUsersFromCloud, success, size=" + arrayList.size());
            fir.m19396f(System.currentTimeMillis() - this.f14376b);
            return;
        }
        glp.m22387b(this.f14377c, new glt(this));
        fir.m19390d("no more");
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        exw.m18443a("NearbyProvider", "loadNearbyUsersFromCloud, failure");
        fir.m19390d(com_ushareit_listenit_ece.m16715b());
        if (this.f14375a != null) {
            this.f14375a.mo2715a(null);
        }
    }
}
