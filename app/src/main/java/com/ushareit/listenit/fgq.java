package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgq implements OnClickListener {
    final /* synthetic */ ViewGroup f12681a;
    final /* synthetic */ esi f12682b;
    final /* synthetic */ fgm f12683c;

    fgq(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12683c = com_ushareit_listenit_fgm;
        this.f12681a = viewGroup;
        this.f12682b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12681a.removeAllViews();
        this.f12683c.m19170c(this.f12682b);
    }
}
