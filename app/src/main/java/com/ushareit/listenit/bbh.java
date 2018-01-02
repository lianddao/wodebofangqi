package com.ushareit.listenit;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;
import com.facebook.internal.cb;

class bbh extends bay {
    String f5854e;
    final /* synthetic */ bak f5855f;

    bbh(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5855f = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, str, com_ushareit_listenit_bdm);
        Bundle bundle = new Bundle();
        bundle.putString("object", str);
        m7586a(new GraphRequest(AccessToken.m671a(), "me/og.likes", bundle, aji.POST));
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
        this.f5854e = cb.m1566a(com_ushareit_listenit_ajh.m5777b(), "id");
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        if (com_ushareit_listenit_aih.m5693b() == 3501) {
            this.c = null;
            return;
        }
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error liking object '%s' with type '%s' : %s", this.a, this.b, com_ushareit_listenit_aih);
        this.f5855f.m7508a("publish_like", com_ushareit_listenit_aih);
    }
}
