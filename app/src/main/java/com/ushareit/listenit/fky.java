package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

class fky implements ecy {
    final /* synthetic */ fjz f12878a;
    final /* synthetic */ long f12879b;
    final /* synthetic */ fkv f12880c;

    fky(fkv com_ushareit_listenit_fkv, fjz com_ushareit_listenit_fjz, long j) {
        this.f12880c = com_ushareit_listenit_fkv;
        this.f12878a = com_ushareit_listenit_fjz;
        this.f12879b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Map hashMap = new HashMap();
        if (com_ushareit_listenit_ecb.m16703b() > 0) {
            for (ecb com_ushareit_listenit_fnm : com_ushareit_listenit_ecb.m16707e()) {
                fnm com_ushareit_listenit_fnm2 = new fnm(com_ushareit_listenit_fnm);
                if (!fbb.m18763c(com_ushareit_listenit_fnm2.getId())) {
                    hashMap.put(com_ushareit_listenit_fnm2.getId(), com_ushareit_listenit_fnm2);
                }
            }
        }
        exw.m18443a("LibrarySongSync", "syncAll: get cloud song:" + hashMap.size() + ", childCount=" + com_ushareit_listenit_ecb.m16703b());
        this.f12880c.m19683a(hashMap, this.f12878a, this.f12879b);
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f12878a != null) {
            this.f12878a.m19580a();
        }
    }
}
