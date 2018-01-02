package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gsm implements OnClickListener {
    final /* synthetic */ View f14659a;
    final /* synthetic */ int f14660b;
    final /* synthetic */ gsj f14661c;

    gsm(gsj com_ushareit_listenit_gsj, View view, int i) {
        this.f14661c = com_ushareit_listenit_gsj;
        this.f14659a = view;
        this.f14660b = i;
    }

    public void onClick(View view) {
        if (this.f14661c.f14653j != null) {
            this.f14661c.f14653j.mo2608a(this.f14659a, this.f14661c.f14646c.get(1) + this.f14660b);
        }
    }
}
