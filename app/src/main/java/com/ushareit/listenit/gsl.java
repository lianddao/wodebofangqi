package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gsl implements OnClickListener {
    final /* synthetic */ View f14656a;
    final /* synthetic */ int f14657b;
    final /* synthetic */ gsj f14658c;

    gsl(gsj com_ushareit_listenit_gsj, View view, int i) {
        this.f14658c = com_ushareit_listenit_gsj;
        this.f14656a = view;
        this.f14657b = i;
    }

    public void onClick(View view) {
        if (this.f14658c.f14651h != null && this.f14658c.f14646c.size() != 0) {
            this.f14658c.f14651h.mo2608a(this.f14656a, this.f14658c.f14646c.get(0) + this.f14657b);
        }
    }
}
