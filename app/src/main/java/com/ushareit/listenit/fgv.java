package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgv implements OnClickListener {
    final /* synthetic */ ViewGroup f12696a;
    final /* synthetic */ esi f12697b;
    final /* synthetic */ fgm f12698c;

    fgv(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12698c = com_ushareit_listenit_fgm;
        this.f12696a = viewGroup;
        this.f12697b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12696a.removeAllViews();
        this.f12698c.m19170c(this.f12697b);
    }
}
