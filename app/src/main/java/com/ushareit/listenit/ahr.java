package com.ushareit.listenit;

import org.json.JSONObject;

class ahr implements aix {
    final /* synthetic */ aht f4377a;
    final /* synthetic */ aho f4378b;

    ahr(aho com_ushareit_listenit_aho, aht com_ushareit_listenit_aht) {
        this.f4378b = com_ushareit_listenit_aho;
        this.f4377a = com_ushareit_listenit_aht;
    }

    public void mo166a(ajh com_ushareit_listenit_ajh) {
        JSONObject b = com_ushareit_listenit_ajh.m5777b();
        if (b != null) {
            this.f4377a.f4385a = b.optString("access_token");
            this.f4377a.f4386b = b.optInt("expires_at");
        }
    }
}
