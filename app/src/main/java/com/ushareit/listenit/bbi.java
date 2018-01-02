package com.ushareit.listenit;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.bk;

class bbi extends bay {
    final /* synthetic */ bak f5856e;
    private String f5857f;

    bbi(bak com_ushareit_listenit_bak, String str) {
        this.f5856e = com_ushareit_listenit_bak;
        super(com_ushareit_listenit_bak, null, null);
        this.f5857f = str;
        m7586a(new GraphRequest(AccessToken.m671a(), str, null, aji.DELETE));
    }

    protected void mo829a(ajh com_ushareit_listenit_ajh) {
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error unliking object with unlike token '%s' : %s", this.f5857f, com_ushareit_listenit_aih);
        this.f5856e.m7508a("publish_unlike", com_ushareit_listenit_aih);
    }
}
