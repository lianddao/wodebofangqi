package com.ushareit.listenit;

import android.os.Bundle;

class bav implements ajf {
    final /* synthetic */ bbi f5822a;
    final /* synthetic */ Bundle f5823b;
    final /* synthetic */ bak f5824c;

    bav(bak com_ushareit_listenit_bak, bbi com_ushareit_listenit_bbi, Bundle bundle) {
        this.f5824c = com_ushareit_listenit_bak;
        this.f5822a = com_ushareit_listenit_bbi;
        this.f5823b = bundle;
    }

    public void mo634a(aje com_ushareit_listenit_aje) {
        this.f5824c.f5800v = false;
        if (this.f5822a.c != null) {
            this.f5824c.m7512a(true);
            return;
        }
        this.f5824c.f5796r = null;
        this.f5824c.f5799u = false;
        this.f5824c.m7555l().m1207a("fb_like_control_did_unlike", null, this.f5823b);
        this.f5824c.m7541e(this.f5823b);
    }
}
