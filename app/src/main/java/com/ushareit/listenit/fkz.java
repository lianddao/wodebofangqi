package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class fkz extends fjz {
    final /* synthetic */ long f12881a;
    final /* synthetic */ fjz f12882b;
    final /* synthetic */ List f12883c;
    final /* synthetic */ Map f12884d;
    final /* synthetic */ Map f12885e;
    final /* synthetic */ fkv f12886f;

    fkz(fkv com_ushareit_listenit_fkv, int i, long j, fjz com_ushareit_listenit_fjz, List list, Map map, Map map2) {
        this.f12886f = com_ushareit_listenit_fkv;
        this.f12881a = j;
        this.f12882b = com_ushareit_listenit_fjz;
        this.f12883c = list;
        this.f12884d = map;
        this.f12885e = map2;
        super(i);
    }

    public void mo2390a(boolean z, long j) {
        this.f12886f.m19684a(z, j, this.f12881a, this.f12882b);
        if (z) {
            List arrayList = new ArrayList();
            for (String str : this.f12883c) {
                if (this.f12884d.containsKey(str)) {
                    arrayList.add(new fnm((glg) this.f12884d.get(str)));
                } else if (this.f12885e.containsKey(str)) {
                    arrayList.add(this.f12885e.get(str));
                }
            }
            fka.m19595a(arrayList, "syncall");
        }
    }
}
