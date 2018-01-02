package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class amc implements Runnable {
    final /* synthetic */ Map f4806a;
    final /* synthetic */ Map f4807b;
    final /* synthetic */ amb f4808c;

    amc(amb com_ushareit_listenit_amb, Map map, Map map2) {
        this.f4808c = com_ushareit_listenit_amb;
        this.f4806a = map;
        this.f4807b = map2;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.f4808c.f4772H)) {
            Map hashMap = new HashMap();
            hashMap.putAll(this.f4806a);
            hashMap.putAll(this.f4807b);
            if (this.f4808c.f4780P != null) {
                this.f4808c.f4780P.mo748d(this.f4808c.f4772H, hashMap);
            }
        }
    }
}
