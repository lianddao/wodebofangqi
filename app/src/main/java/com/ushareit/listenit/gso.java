package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gso implements OnClickListener {
    final /* synthetic */ View f14665a;
    final /* synthetic */ int f14666b;
    final /* synthetic */ gsj f14667c;

    gso(gsj com_ushareit_listenit_gsj, View view, int i) {
        this.f14667c = com_ushareit_listenit_gsj;
        this.f14665a = view;
        this.f14666b = i;
    }

    public void onClick(View view) {
        if (this.f14667c.f14654k != null) {
            this.f14667c.f14654k.mo2608a(this.f14665a, this.f14667c.f14646c.get(3) + this.f14666b);
        }
    }
}
