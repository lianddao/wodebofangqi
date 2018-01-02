package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class ftb implements OnClickListener {
    final /* synthetic */ int f13440a;
    final /* synthetic */ fsg f13441b;
    final /* synthetic */ fta f13442c;

    ftb(fta com_ushareit_listenit_fta, int i, fsg com_ushareit_listenit_fsg) {
        this.f13442c = com_ushareit_listenit_fta;
        this.f13440a = i;
        this.f13441b = com_ushareit_listenit_fsg;
    }

    public void onClick(View view) {
        this.f13442c.h.mo2608a(view, this.f13440a - 1);
        fij.m19324a((int) this.f13441b.f13355a);
    }
}
