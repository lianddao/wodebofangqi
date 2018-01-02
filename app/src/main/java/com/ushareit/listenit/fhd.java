package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fhd implements OnClickListener {
    final /* synthetic */ ViewGroup f12715a;
    final /* synthetic */ esi f12716b;
    final /* synthetic */ fgy f12717c;

    fhd(fgy com_ushareit_listenit_fgy, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12717c = com_ushareit_listenit_fgy;
        this.f12715a = viewGroup;
        this.f12716b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12715a.removeAllViews();
        this.f12717c.m19170c(this.f12716b);
    }
}
