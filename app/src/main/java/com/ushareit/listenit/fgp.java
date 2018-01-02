package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgp implements OnClickListener {
    final /* synthetic */ ViewGroup f12678a;
    final /* synthetic */ esi f12679b;
    final /* synthetic */ fgm f12680c;

    fgp(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12680c = com_ushareit_listenit_fgm;
        this.f12678a = viewGroup;
        this.f12679b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12678a.removeAllViews();
        this.f12680c.m19170c(this.f12679b);
    }
}
