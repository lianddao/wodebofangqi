package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fhc implements OnClickListener {
    final /* synthetic */ ViewGroup f12712a;
    final /* synthetic */ esi f12713b;
    final /* synthetic */ fgy f12714c;

    fhc(fgy com_ushareit_listenit_fgy, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12714c = com_ushareit_listenit_fgy;
        this.f12712a = viewGroup;
        this.f12713b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12712a.removeAllViews();
        this.f12714c.m19170c(this.f12713b);
    }
}
