package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import org.json.JSONArray;
import org.json.JSONObject;

class bbe extends bay {
    boolean f5845e = this.f5847g.f5791m;
    String f5846f;
    final /* synthetic */ bak f5847g;

    bbe(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5847g = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, str, com_ushareit_listenit_bdm);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,application");
        bundle.putString("object", str);
        m7586a(new GraphRequest(AccessToken.m671a(), "me/og.likes", bundle, aji.GET));
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
        JSONArray c = cb.m1606c(com_ushareit_listenit_ajh.m5777b(), "data");
        if (c != null) {
            for (int i = 0; i < c.length(); i++) {
                JSONObject optJSONObject = c.optJSONObject(i);
                if (optJSONObject != null) {
                    this.f5845e = true;
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                    AccessToken a = AccessToken.m671a();
                    if (!(optJSONObject2 == null || a == null || !cb.m1590a(a.m684h(), optJSONObject2.optString("id")))) {
                        this.f5846f = optJSONObject.optString("id");
                    }
                }
            }
        }
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error fetching like status for object '%s' with type '%s' : %s", this.a, this.b, com_ushareit_listenit_aih);
        this.f5847g.m7508a("get_og_object_like", com_ushareit_listenit_aih);
    }
}
