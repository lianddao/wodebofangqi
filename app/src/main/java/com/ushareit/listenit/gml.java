package com.ushareit.listenit;

import java.util.List;

class gml implements gmb<List<fni>> {
    final /* synthetic */ gmk f14419a;

    gml(gmk com_ushareit_listenit_gmk) {
        this.f14419a = com_ushareit_listenit_gmk;
    }

    public void m22456a(List<fni> list) {
        this.f14419a.m22443W();
        if (list == null || list.size() == 0) {
            this.f14419a.f14417e.setVisibility(0);
            this.f14419a.f14415c.setVisibility(4);
        } else if (list != null && list.size() > 0) {
            this.f14419a.f14414b.m18942a((List) list);
            this.f14419a.f14418f = System.currentTimeMillis();
        }
    }
}
