package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

final class gma implements ecy {
    final /* synthetic */ gmb f14398a;
    final /* synthetic */ long f14399b;

    gma(gmb com_ushareit_listenit_gmb, long j) {
        this.f14398a = com_ushareit_listenit_gmb;
        this.f14399b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        List arrayList = new ArrayList((int) com_ushareit_listenit_ecb.m16703b());
        if (com_ushareit_listenit_ecb.m16703b() > 0) {
            for (ecb a : com_ushareit_listenit_ecb.m16707e()) {
                String str = (String) a.m16701a(String.class);
                if (str != null) {
                    arrayList.add(str);
                }
            }
        }
        exw.m18443a("NearbyProvider", "loadShareListSongIds, success, size=" + arrayList.size());
        if (this.f14398a != null) {
            this.f14398a.mo2715a(arrayList);
        }
        if (arrayList.size() > 0) {
            fir.m19407j(System.currentTimeMillis() - this.f14399b);
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        exw.m18443a("NearbyProvider", "loadShareListSongIds, failure");
        if (this.f14398a != null) {
            this.f14398a.mo2715a(null);
        }
        fir.m19403h(com_ushareit_listenit_ece.m16715b());
    }
}
