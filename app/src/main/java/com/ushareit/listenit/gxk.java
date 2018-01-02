package com.ushareit.listenit;

import java.util.Comparator;
import java.util.List;

final class gxk implements Comparator<gxl> {
    final /* synthetic */ List f14859a;

    gxk(List list) {
        this.f14859a = list;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23092a((gxl) obj, (gxl) obj2);
    }

    public int m23092a(gxl com_ushareit_listenit_gxl, gxl com_ushareit_listenit_gxl2) {
        return m23091a(com_ushareit_listenit_gxl2) - m23091a(com_ushareit_listenit_gxl);
    }

    private int m23091a(gxl com_ushareit_listenit_gxl) {
        return this.f14859a.indexOf(com_ushareit_listenit_gxl.f14861b);
    }
}
