package com.ushareit.listenit;

import com.facebook.internal.cb;

class bau implements ajf {
    final /* synthetic */ bbh f5820a;
    final /* synthetic */ bat f5821b;

    bau(bat com_ushareit_listenit_bat, bbh com_ushareit_listenit_bbh) {
        this.f5821b = com_ushareit_listenit_bat;
        this.f5820a = com_ushareit_listenit_bbh;
    }

    public void mo634a(aje com_ushareit_listenit_aje) {
        this.f5821b.f5819b.f5800v = false;
        if (this.f5820a.c != null) {
            this.f5821b.f5819b.m7512a(false);
            return;
        }
        this.f5821b.f5819b.f5796r = cb.m1563a(this.f5820a.f5854e, null);
        this.f5821b.f5819b.f5799u = true;
        this.f5821b.f5819b.m7555l().m1207a("fb_like_control_did_like", null, this.f5821b.f5818a);
        this.f5821b.f5819b.m7541e(this.f5821b.f5818a);
    }
}
