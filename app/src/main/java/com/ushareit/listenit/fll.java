package com.ushareit.listenit;

import java.util.LinkedHashMap;
import java.util.Map;

class fll implements ecy {
    final /* synthetic */ fjz f12918a;
    final /* synthetic */ long f12919b;
    final /* synthetic */ fli f12920c;

    fll(fli com_ushareit_listenit_fli, fjz com_ushareit_listenit_fjz, long j) {
        this.f12920c = com_ushareit_listenit_fli;
        this.f12918a = com_ushareit_listenit_fjz;
        this.f12919b = j;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        Map linkedHashMap = new LinkedHashMap((int) com_ushareit_listenit_ecb.m16703b());
        if (com_ushareit_listenit_ecb.m16703b() != 0) {
            for (ecb a : com_ushareit_listenit_ecb.m16707e()) {
                fnj com_ushareit_listenit_fnj = (fnj) a.m16701a(fnj.class);
                linkedHashMap.put(com_ushareit_listenit_fnj.getId(), com_ushareit_listenit_fnj);
            }
        }
        exw.m18443a("PlaylistSync", "syncPlaylist: get cloud playlist : " + linkedHashMap.size());
        this.f12920c.m19770a(linkedHashMap, this.f12918a, this.f12919b);
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        if (this.f12918a != null) {
            this.f12918a.m19580a();
        }
    }
}
