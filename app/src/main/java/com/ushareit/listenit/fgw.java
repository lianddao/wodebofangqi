package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgw implements OnClickListener {
    final /* synthetic */ ViewGroup f12699a;
    final /* synthetic */ esi f12700b;
    final /* synthetic */ fgm f12701c;

    fgw(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12701c = com_ushareit_listenit_fgm;
        this.f12699a = viewGroup;
        this.f12700b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12699a.removeAllViews();
        this.f12701c.m19170c(this.f12700b);
    }
}
