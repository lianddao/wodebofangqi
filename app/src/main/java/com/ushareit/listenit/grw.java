package com.ushareit.listenit;

import android.content.Context;

class grw extends gww {
    final /* synthetic */ Context f14618a;
    final /* synthetic */ gxx f14619b;
    final /* synthetic */ grr f14620c;

    grw(grr com_ushareit_listenit_grr, Context context, gxx com_ushareit_listenit_gxx) {
        this.f14620c = com_ushareit_listenit_grr;
        this.f14618a = context;
        this.f14619b = com_ushareit_listenit_gxx;
    }

    public void execute() {
        this.f14620c.m22623a(this.f14618a, this.f14619b);
        synchronized (this.f14620c.f14604e) {
            if (this.f14620c.f14604e.decrementAndGet() == 0) {
                this.f14620c.f14603d.m22616d();
            }
        }
    }
}
