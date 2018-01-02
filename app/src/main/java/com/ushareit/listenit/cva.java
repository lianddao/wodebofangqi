package com.ushareit.listenit;

import java.util.Comparator;

class cva implements Comparator<cuv> {
    static final /* synthetic */ boolean f9178a = (!cuz.class.desiredAssertionStatus());
    final /* synthetic */ cuz f9179b;

    cva(cuz com_ushareit_listenit_cuz) {
        this.f9179b = com_ushareit_listenit_cuz;
    }

    public int m12974a(cuv com_ushareit_listenit_cuv, cuv com_ushareit_listenit_cuv2) {
        if (f9178a || !(com_ushareit_listenit_cuv.m12959a() == null || com_ushareit_listenit_cuv2.m12959a() == null)) {
            return this.f9179b.f9176b.compare(new cwz(com_ushareit_listenit_cuv.m12959a(), com_ushareit_listenit_cuv.m12961c().m13247a()), new cwz(com_ushareit_listenit_cuv2.m12959a(), com_ushareit_listenit_cuv2.m12961c().m13247a()));
        }
        throw new AssertionError();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12974a((cuv) obj, (cuv) obj2);
    }
}
