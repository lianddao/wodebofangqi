package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class goc implements OnClickListener {
    final /* synthetic */ glg f14493a;
    final /* synthetic */ gob f14494b;

    goc(gob com_ushareit_listenit_gob, glg com_ushareit_listenit_glg) {
        this.f14494b = com_ushareit_listenit_gob;
        this.f14493a = com_ushareit_listenit_glg;
    }

    public void onClick(View view) {
        this.f14494b.f14490a.f16118d.m22556a(this.f14493a);
        if (this.f14494b.f14490a.f16122h != null) {
            this.f14494b.f14490a.f16122h.mo2448f(this.f14493a);
        }
        this.f14494b.f14490a.m25515a(this.f14494b.f14490a.f16118d.getCount());
    }
}
