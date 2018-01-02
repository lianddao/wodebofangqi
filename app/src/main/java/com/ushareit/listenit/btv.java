package com.ushareit.listenit;

import android.content.Context;

public class btv {
    private final bwg f7745a;
    private final Context f7746b;
    private final bxc f7747c;

    btv(Context context, bxc com_ushareit_listenit_bxc) {
        this(context, com_ushareit_listenit_bxc, bwg.m10203a());
    }

    btv(Context context, bxc com_ushareit_listenit_bxc, bwg com_ushareit_listenit_bwg) {
        this.f7746b = context;
        this.f7747c = com_ushareit_listenit_bxc;
        this.f7745a = com_ushareit_listenit_bwg;
    }

    private void m9839a(bvi com_ushareit_listenit_bvi) {
        try {
            this.f7747c.mo1127a(this.f7745a.m10204a(this.f7746b, com_ushareit_listenit_bvi));
        } catch (Throwable e) {
            bze.m10489b("Failed to load ad.", e);
        }
    }

    public void m9840a(btx com_ushareit_listenit_btx) {
        m9839a(com_ushareit_listenit_btx.m9846a());
    }
}
