package com.ushareit.listenit;

import com.facebook.GraphRequest;
import com.facebook.internal.bk;

abstract class bay {
    protected String f5829a;
    protected bdm f5830b;
    aih f5831c;
    final /* synthetic */ bak f5832d;
    private GraphRequest f5833e;

    protected abstract void mo829a(ajh com_ushareit_listenit_ajh);

    protected bay(bak com_ushareit_listenit_bak, String str, bdm com_ushareit_listenit_bdm) {
        this.f5832d = com_ushareit_listenit_bak;
        this.f5829a = str;
        this.f5830b = com_ushareit_listenit_bdm;
    }

    void m7588a(aje com_ushareit_listenit_aje) {
        com_ushareit_listenit_aje.m5757a(this.f5833e);
    }

    protected void m7586a(GraphRequest graphRequest) {
        this.f5833e = graphRequest;
        graphRequest.m765a("v2.4");
        graphRequest.m762a(new baz(this));
    }

    protected void mo828a(aih com_ushareit_listenit_aih) {
        bk.m1465a(ajk.REQUESTS, bak.f5779a, "Error running request for object '%s' with type '%s' : %s", this.f5829a, this.f5830b, com_ushareit_listenit_aih);
    }
}
