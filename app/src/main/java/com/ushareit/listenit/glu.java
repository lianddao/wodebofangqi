package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

final class glu implements ecy {
    final /* synthetic */ gmb f14379a;
    final /* synthetic */ long f14380b;

    glu(gmb com_ushareit_listenit_gmb, long j) {
        this.f14379a = com_ushareit_listenit_gmb;
        this.f14380b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        List arrayList = new ArrayList();
        if (com_ushareit_listenit_ecb.m16703b() > 0) {
            long b = gln.m22373b();
            long am = gvj.am(eys.m18562a());
            for (ecb com_ushareit_listenit_fni : com_ushareit_listenit_ecb.m16707e()) {
                fni com_ushareit_listenit_fni2 = new fni(com_ushareit_listenit_fni);
                com_ushareit_listenit_fni2.setLg(gln.m22370a(am, b));
                arrayList.add(com_ushareit_listenit_fni2);
            }
        }
        exw.m18443a("NearbyProvider", "loadNearbyRobotUsers success, size=" + arrayList.size());
        glp.f14371a = 1;
        gvj.m22928d(fqk.m20386l());
        if (this.f14379a != null) {
            this.f14379a.mo2715a(arrayList);
        }
        if (arrayList == null || arrayList.size() <= 0) {
            fir.m19394e("no more");
            return;
        }
        fir.m19386c("robot");
        fir.m19399g(System.currentTimeMillis() - this.f14380b);
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f14379a != null) {
            this.f14379a.mo2715a(null);
        }
        exw.m18443a("NearbyProvider", "loadNearbyRobotUsers failure");
        fir.m19394e(com_ushareit_listenit_ece.m16715b());
    }
}
