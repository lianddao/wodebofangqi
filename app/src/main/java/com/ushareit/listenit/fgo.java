package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgo implements OnClickListener {
    final /* synthetic */ ViewGroup f12675a;
    final /* synthetic */ esi f12676b;
    final /* synthetic */ fgm f12677c;

    fgo(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12677c = com_ushareit_listenit_fgm;
        this.f12675a = viewGroup;
        this.f12676b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12675a.removeAllViews();
        this.f12677c.m19170c(this.f12676b);
    }
}
