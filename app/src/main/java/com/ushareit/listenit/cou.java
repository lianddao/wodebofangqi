package com.ushareit.listenit;

import java.util.Map;

class cou implements cpa {
    final /* synthetic */ cph f8599a;
    final /* synthetic */ cor f8600b;

    cou(cor com_ushareit_listenit_cor, cph com_ushareit_listenit_cph) {
        this.f8600b = com_ushareit_listenit_cor;
        this.f8599a = com_ushareit_listenit_cph;
    }

    public void mo1539a(Map<String, Object> map) {
        String str = null;
        String str2 = (String) map.get("s");
        if (str2.equals("ok")) {
            str2 = null;
        } else {
            str = (String) map.get("d");
        }
        if (this.f8599a != null) {
            this.f8599a.mo1571a(str2, str);
        }
    }
}
