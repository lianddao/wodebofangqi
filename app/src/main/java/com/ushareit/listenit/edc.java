package com.ushareit.listenit;

import com.google.firebase.database.connection.idl.IPersistentConnectionImpl;
import com.google.firebase.database.connection.idl.RangeParcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class edc extends eeb {
    final /* synthetic */ coq f10851a;

    public edc(coq com_ushareit_listenit_coq) {
        this.f10851a = com_ushareit_listenit_coq;
    }

    public void mo2137a() {
        this.f10851a.mo1557a();
    }

    public void mo2138a(ckg com_ushareit_listenit_ckg) {
        this.f10851a.mo1560a((Map) ckj.m11513a(com_ushareit_listenit_ckg));
    }

    public void mo2139a(List<String> list, ckg com_ushareit_listenit_ckg, boolean z, long j) {
        this.f10851a.mo1558a(list, ckj.m11513a(com_ushareit_listenit_ckg), z, IPersistentConnectionImpl.m2547b(j));
    }

    public void mo2140a(List<String> list, List<RangeParcelable> list2, ckg com_ushareit_listenit_ckg, long j) {
        List list3 = (List) ckj.m11513a(com_ushareit_listenit_ckg);
        List arrayList = new ArrayList(list2.size());
        for (int i = 0; i < list2.size(); i++) {
            arrayList.add(RangeParcelable.m2549a((RangeParcelable) list2.get(i), list3.get(i)));
        }
        this.f10851a.mo1559a(list, arrayList, IPersistentConnectionImpl.m2547b(j));
    }

    public void mo2141a(boolean z) {
        this.f10851a.mo1561a(z);
    }

    public void mo2142b() {
        this.f10851a.mo1562b();
    }
}
