package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;

final class glr implements gmb<List<fni>> {
    final /* synthetic */ gmb f14374a;

    glr(gmb com_ushareit_listenit_gmb) {
        this.f14374a = com_ushareit_listenit_gmb;
    }

    public void m22400a(List<fni> list) {
        Object arrayList = list != null ? new ArrayList(list) : null;
        gln.m22371a((List) arrayList);
        gvj.m23005m(eys.m18562a(), System.currentTimeMillis());
        if (arrayList != null && arrayList.size() > 0 && (glp.f14371a == 0 || glp.f14371a == 1)) {
            frc.m20589a((List) arrayList);
        }
        if (!(gef.m21805a().m21835e() || arrayList == null || arrayList.size() <= 5)) {
            arrayList = arrayList.subList(0, 5);
        }
        if (this.f14374a != null) {
            this.f14374a.mo2715a(arrayList);
        }
    }
}
