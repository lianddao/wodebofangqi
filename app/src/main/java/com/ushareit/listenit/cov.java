package com.ushareit.listenit;

import java.util.Map;

class cov implements cpa {
    final /* synthetic */ boolean f8601a;
    final /* synthetic */ cor f8602b;

    cov(cor com_ushareit_listenit_cor, boolean z) {
        this.f8602b = com_ushareit_listenit_cor;
        this.f8601a = z;
    }

    public void mo1539a(Map<String, Object> map) {
        this.f8602b.f8578j = cpb.Connected;
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.f8602b.f8594z = 0;
            this.f8602b.f8571c.mo1561a(true);
            if (this.f8601a) {
                this.f8602b.m12111n();
                return;
            }
            return;
        }
        this.f8602b.f8585q = null;
        this.f8602b.f8586r = true;
        this.f8602b.f8571c.mo1561a(false);
        String str2 = (String) map.get("d");
        this.f8602b.f8590v.m13093a(new StringBuilder((String.valueOf(str).length() + 26) + String.valueOf(str2).length()).append("Authentication failed: ").append(str).append(" (").append(str2).append(")").toString(), new Object[0]);
        this.f8602b.f8577i.m12016b();
        if (str.equals("invalid_token")) {
            this.f8602b.f8594z = this.f8602b.f8594z + 1;
            if (((long) this.f8602b.f8594z) >= 3) {
                this.f8602b.f8591w.m12216b();
                this.f8602b.f8590v.m13090a("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
            }
        }
    }
}
