package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;
import org.json.JSONObject;

class bbd extends bay {
    String f5843e;
    final /* synthetic */ bak f5844f;

    bbd(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5844f = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, str, com_ushareit_listenit_bdm);
        Bundle bundle = new Bundle();
        bundle.putString("fields", "og_object.fields(id)");
        bundle.putString("ids", str);
        m7586a(new GraphRequest(AccessToken.m671a(), "", bundle, aji.GET));
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        if (com_ushareit_listenit_aih.m5695d().contains("og_object")) {
            this.c = null;
            return;
        }
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error getting the FB id for object '%s' with type '%s' : %s", this.a, this.b, com_ushareit_listenit_aih);
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
        JSONObject b = cb.m1598b(com_ushareit_listenit_ajh.m5777b(), this.a);
        if (b != null) {
            b = b.optJSONObject("og_object");
            if (b != null) {
                this.f5843e = b.optString("id");
            }
        }
    }
}
