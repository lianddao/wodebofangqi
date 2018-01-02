package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class azm extends arv {
    final /* synthetic */ azh f5735a;

    azm(azh com_ushareit_listenit_azh) {
        this.f5735a = com_ushareit_listenit_azh;
    }

    public void mo98a() {
        if (!this.f5735a.f5717d.m7122b()) {
            this.f5735a.f5717d.m7119a();
            Map hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f5735a.f5723j)) {
                this.f5735a.f5714a.m6935a(hashMap);
                hashMap.put("touch", atz.m7161a(this.f5735a.m7427a()));
                apb.m6565a(this.f5735a.f5724k).mo742a(this.f5735a.f5723j, hashMap);
            }
            if (this.f5735a.f5718e != null) {
                this.f5735a.f5718e.mo157a(art.REWARDED_VIDEO_IMPRESSION.m6913a());
            }
        }
    }
}
