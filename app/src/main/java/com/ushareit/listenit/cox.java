package com.ushareit.listenit;

import java.util.List;
import java.util.Map;

class cox implements cpa {
    final /* synthetic */ cpe f8608a;
    final /* synthetic */ cor f8609b;

    cox(cor com_ushareit_listenit_cor, cpe com_ushareit_listenit_cpe) {
        this.f8609b = com_ushareit_listenit_cor;
        this.f8608a = com_ushareit_listenit_cpe;
    }

    public void mo1539a(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            Map map2 = (Map) map.get("d");
            if (map2.containsKey("w")) {
                this.f8609b.m12083a((List) map2.get("w"), this.f8608a.f8625b);
            }
        }
        if (((cpe) this.f8609b.f8584p.get(this.f8608a.m12160a())) != this.f8608a) {
            return;
        }
        if (str.equals("ok")) {
            this.f8608a.f8624a.mo1571a(null, null);
            return;
        }
        this.f8609b.m12068a(this.f8608a.m12160a());
        this.f8608a.f8624a.mo1571a(str, (String) map.get("d"));
    }
}
