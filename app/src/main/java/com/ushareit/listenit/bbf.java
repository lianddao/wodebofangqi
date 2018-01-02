package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import org.json.JSONObject;

class bbf extends bay {
    String f5848e;
    boolean f5849f;
    final /* synthetic */ bak f5850g;

    bbf(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5850g = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, str, com_ushareit_listenit_bdm);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("ids", str);
        m7586a(new GraphRequest(AccessToken.m671a(), "", bundle, aji.GET));
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
        JSONObject b = cb.m1598b(com_ushareit_listenit_ajh.m5777b(), this.a);
        if (b != null) {
            this.f5848e = b.optString("id");
            this.f5849f = !cb.m1591a(this.f5848e);
        }
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error getting the FB id for object '%s' with type '%s' : %s", this.a, this.b, com_ushareit_listenit_aih);
    }
}
