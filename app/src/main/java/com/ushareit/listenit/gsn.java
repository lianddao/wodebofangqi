package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gsn implements OnClickListener {
    final /* synthetic */ View f14662a;
    final /* synthetic */ int f14663b;
    final /* synthetic */ gsj f14664c;

    gsn(gsj com_ushareit_listenit_gsj, View view, int i) {
        this.f14664c = com_ushareit_listenit_gsj;
        this.f14662a = view;
        this.f14663b = i;
    }

    public void onClick(View view) {
        if (this.f14664c.f14652i != null) {
            this.f14664c.f14652i.mo2608a(this.f14662a, this.f14664c.f14646c.get(2) + this.f14663b);
        }
    }
}
