package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fgz implements OnClickListener {
    final /* synthetic */ ViewGroup f12702a;
    final /* synthetic */ esi f12703b;
    final /* synthetic */ fgy f12704c;

    fgz(fgy com_ushareit_listenit_fgy, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12704c = com_ushareit_listenit_fgy;
        this.f12702a = viewGroup;
        this.f12703b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12702a.removeAllViews();
        this.f12704c.m19170c(this.f12703b);
    }
}
