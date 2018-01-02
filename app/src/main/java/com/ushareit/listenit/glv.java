package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

final class glv implements ecy {
    final /* synthetic */ String f14381a;
    final /* synthetic */ long f14382b;
    final /* synthetic */ gmb f14383c;
    final /* synthetic */ fni f14384d;

    glv(String str, long j, gmb com_ushareit_listenit_gmb, fni com_ushareit_listenit_fni) {
        this.f14381a = str;
        this.f14382b = j;
        this.f14383c = com_ushareit_listenit_gmb;
        this.f14384d = com_ushareit_listenit_fni;
    }

    public void mo2135a(ecb com_ushareit_listenit_ecb) {
        List arrayList = new ArrayList();
        if (com_ushareit_listenit_ecb.m16703b() > 0) {
            String uuid = UUID.nameUUIDFromBytes(eys.m18562a().getResources().getString(C0349R.string.main_card_feature_favorite).getBytes()).toString();
            for (ecb com_ushareit_listenit_fnl : com_ushareit_listenit_ecb.m16707e()) {
                fnl com_ushareit_listenit_fnl2 = new fnl(com_ushareit_listenit_fnl);
                if (!(com_ushareit_listenit_fnl2.getId() == null || com_ushareit_listenit_fnl2.getId().equals(uuid))) {
                    arrayList.add(com_ushareit_listenit_fnl2);
                }
            }
        }
        exw.m18443a("NearbyProvider", "loadShareListsFromCloud, success size=" + arrayList.size());
        m22407a(arrayList);
        if (arrayList.size() > 0) {
            frc.m20588a(this.f14381a, arrayList);
            fir.m19402h(System.currentTimeMillis() - this.f14382b);
        }
        if (this.f14383c != null) {
            this.f14383c.mo2715a(arrayList);
        }
    }

    private void m22407a(List<fnl> list) {
        int size = list.size();
        int i = 0;
        for (fnl sgN : list) {
            i = sgN.getSgN() + i;
        }
        exw.m18443a("NearbyProvider", "start checkAndUpdateNearbyUser, playlistNumber=" + size + ", songNumber=" + i);
        if (this.f14384d.getPlN() != size) {
            frc.m20592b(this.f14384d.getId(), size);
        }
        if (this.f14384d.getSgN() != i) {
            frc.m20586a(this.f14384d.getId(), i);
        }
    }

    public void mo2136a(ece com_ushareit_listenit_ece) {
        exw.m18443a("NearbyProvider", "loadShareListsFromCloud, failure");
        if (this.f14383c != null) {
            this.f14383c.mo2715a(null);
        }
        fir.m19397f(com_ushareit_listenit_ece.m16715b());
    }
}
