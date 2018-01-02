package com.ushareit.listenit;

import android.content.Context;
import com.facebook.ads.C0016g;

class alf extends btu {
    final /* synthetic */ Context f4654a;
    final /* synthetic */ alc f4655b;

    alf(alc com_ushareit_listenit_alc, Context context) {
        this.f4655b = com_ushareit_listenit_alc;
        this.f4654a = context;
    }

    public void onAdFailedToLoad(int i) {
        atz.m7169a(this.f4654a, aut.m7225a(this.f4655b.mo699z()) + " Failed with error code: " + i);
        if (this.f4655b.f4640d != null) {
            this.f4655b.f4640d.mo94a(this.f4655b, new C0016g(3001, "AdMob error code: " + i));
        }
    }

    public void onAdOpened() {
        if (this.f4655b.f4640d != null) {
            this.f4655b.f4640d.mo96c(this.f4655b);
        }
    }
}
