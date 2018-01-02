package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fhf implements OnClickListener {
    final /* synthetic */ ViewGroup f12718a;
    final /* synthetic */ esi f12719b;
    final /* synthetic */ fhe f12720c;

    fhf(fhe com_ushareit_listenit_fhe, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12720c = com_ushareit_listenit_fhe;
        this.f12718a = viewGroup;
        this.f12719b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12718a.removeAllViews();
        this.f12720c.m19170c(this.f12719b);
    }
}
