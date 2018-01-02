package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gsy implements OnClickListener {
    final /* synthetic */ View f14686a;
    final /* synthetic */ int f14687b;
    final /* synthetic */ gsx f14688c;

    gsy(gsx com_ushareit_listenit_gsx, View view, int i) {
        this.f14688c = com_ushareit_listenit_gsx;
        this.f14686a = view;
        this.f14687b = i;
    }

    public void onClick(View view) {
        if (this.f14688c.f14684c != null) {
            this.f14688c.f14684c.mo2608a(this.f14686a, this.f14687b);
        }
    }
}
