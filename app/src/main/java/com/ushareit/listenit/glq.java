package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

final class glq implements gmb<List<fni>> {
    final /* synthetic */ gmb f14373a;

    glq(gmb com_ushareit_listenit_gmb) {
        this.f14373a = com_ushareit_listenit_gmb;
    }

    public void m22398a(List<fni> list) {
        List arrayList = list != null ? new ArrayList(list) : null;
        if (arrayList != null && arrayList.size() > 0) {
            frc.m20593b(arrayList);
            gln.m22371a(arrayList);
        }
        if (this.f14373a != null) {
            this.f14373a.mo2715a(arrayList);
        }
    }
}
