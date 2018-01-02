package com.ushareit.listenit;

import com.google.firebase.database.connection.idl.IPersistentConnectionImpl;
import com.google.firebase.database.connection.idl.RangeParcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class edd implements coq {
    final /* synthetic */ eea f10852a;

    public edd(eea com_ushareit_listenit_eea) {
        this.f10852a = com_ushareit_listenit_eea;
    }

    public void mo1557a() {
        try {
            this.f10852a.mo2137a();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1558a(List<String> list, Object obj, boolean z, Long l) {
        try {
            this.f10852a.mo2139a((List) list, ckj.m11512a(obj), z, IPersistentConnectionImpl.m2546b(l));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1559a(List<String> list, List<cpg> list2, Long l) {
        List arrayList = new ArrayList(list2.size());
        Object arrayList2 = new ArrayList(list2.size());
        for (cpg com_ushareit_listenit_cpg : list2) {
            arrayList.add(RangeParcelable.m2548a(com_ushareit_listenit_cpg));
            arrayList2.add(com_ushareit_listenit_cpg.m12171c());
        }
        try {
            this.f10852a.mo2140a((List) list, arrayList, ckj.m11512a(arrayList2), IPersistentConnectionImpl.m2546b(l));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1560a(Map<String, Object> map) {
        try {
            this.f10852a.mo2138a(ckj.m11512a((Object) map));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1561a(boolean z) {
        try {
            this.f10852a.mo2141a(z);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo1562b() {
        try {
            this.f10852a.mo2142b();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
