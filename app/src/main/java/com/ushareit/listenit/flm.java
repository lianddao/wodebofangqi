package com.ushareit.listenit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class flm extends fjz {
    final /* synthetic */ long f12921a;
    final /* synthetic */ fjz f12922b;
    final /* synthetic */ long f12923c;
    final /* synthetic */ Map f12924d;
    final /* synthetic */ Map f12925e;
    final /* synthetic */ Map f12926f;
    final /* synthetic */ fli f12927g;

    flm(fli com_ushareit_listenit_fli, int i, long j, fjz com_ushareit_listenit_fjz, long j2, Map map, Map map2, Map map3) {
        this.f12927g = com_ushareit_listenit_fli;
        this.f12921a = j;
        this.f12922b = com_ushareit_listenit_fjz;
        this.f12923c = j2;
        this.f12924d = map;
        this.f12925e = map2;
        this.f12926f = map3;
        super(i);
    }

    public void mo2390a(boolean z, long j) {
        this.f12927g.m19772a(z, j, this.f12921a, this.f12922b);
        if (z) {
            if (this.f12921a != this.f12923c && this.f12924d.size() > 0) {
                this.f12927g.m19769a(this.f12924d);
            }
            List arrayList = new ArrayList();
            for (String str : this.f12924d.keySet()) {
                if (this.f12925e.containsKey(str)) {
                    arrayList.add(new fnj((glc) this.f12925e.get(str)));
                } else if (this.f12926f.containsKey(str)) {
                    arrayList.add(this.f12926f.get(str));
                }
            }
            fka.m19594a(arrayList);
        }
    }
}
