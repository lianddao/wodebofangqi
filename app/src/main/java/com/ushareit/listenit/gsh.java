package com.ushareit.listenit;

import android.database.ContentObserver;
import android.os.Handler;

class gsh extends ContentObserver {
    final /* synthetic */ gsg f14642a;

    gsh(gsg com_ushareit_listenit_gsg, Handler handler) {
        this.f14642a = com_ushareit_listenit_gsg;
        super(handler);
    }

    public void onChange(boolean z) {
        int b = grz.m22656a().m22665b(eys.m18562a());
        if (b == this.f14642a.f14638a) {
            return;
        }
        if (grr.m22621a().m22648d() || grr.m22621a().m22650f()) {
            this.f14642a.f14638a = b;
            grr.m22621a().m22647c();
            this.f14642a.f14639b.removeCallbacks(this.f14642a.f14641d);
            this.f14642a.f14639b.postDelayed(this.f14642a.f14641d, 500);
        }
    }
}
