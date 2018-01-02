package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgn implements OnClickListener {
    final /* synthetic */ ViewGroup f12672a;
    final /* synthetic */ esi f12673b;
    final /* synthetic */ fgm f12674c;

    fgn(fgm com_ushareit_listenit_fgm, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12674c = com_ushareit_listenit_fgm;
        this.f12672a = viewGroup;
        this.f12673b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12672a.removeAllViews();
        this.f12674c.m19170c(this.f12673b);
    }
}
