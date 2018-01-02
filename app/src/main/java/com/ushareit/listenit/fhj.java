package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fhj implements OnClickListener {
    final /* synthetic */ ViewGroup f12730a;
    final /* synthetic */ esi f12731b;
    final /* synthetic */ fhe f12732c;

    fhj(fhe com_ushareit_listenit_fhe, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12732c = com_ushareit_listenit_fhe;
        this.f12730a = viewGroup;
        this.f12731b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12730a.removeAllViews();
        this.f12732c.m19170c(this.f12731b);
    }
}
