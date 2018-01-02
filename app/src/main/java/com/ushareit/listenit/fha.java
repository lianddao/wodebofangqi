package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fha implements OnClickListener {
    final /* synthetic */ View f12706a;
    final /* synthetic */ esi f12707b;
    final /* synthetic */ fgy f12708c;

    fha(fgy com_ushareit_listenit_fgy, View view, esi com_ushareit_listenit_esi) {
        this.f12708c = com_ushareit_listenit_fgy;
        this.f12706a = view;
        this.f12707b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12706a.setVisibility(4);
        this.f12708c.m19170c(this.f12707b);
    }
}
