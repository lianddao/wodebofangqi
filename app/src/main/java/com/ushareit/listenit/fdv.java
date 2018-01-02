package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fdv implements OnClickListener {
    final /* synthetic */ gla f12501a;
    final /* synthetic */ hbg f12502b;
    final /* synthetic */ int f12503c;
    final /* synthetic */ View f12504d;
    final /* synthetic */ fdu f12505e;

    fdv(fdu com_ushareit_listenit_fdu, gla com_ushareit_listenit_gla, hbg com_ushareit_listenit_hbg, int i, View view) {
        this.f12505e = com_ushareit_listenit_fdu;
        this.f12501a = com_ushareit_listenit_gla;
        this.f12502b = com_ushareit_listenit_hbg;
        this.f12503c = i;
        this.f12504d = view;
    }

    public void onClick(View view) {
        if (this.f12505e.f12495b) {
            this.f12501a.m20775a(!this.f12501a.m20780f());
            this.f12502b.mo2577a(this.f12501a, this.f12505e.f12495b, this.f12503c + 1, this.f12505e.f12497d);
            if (this.f12505e.f12496c != null) {
                this.f12505e.f12496c.mo2609a(this.f12501a);
            }
        } else if (this.f12505e.f12496c != null) {
            this.f12505e.f12496c.mo2608a(this.f12504d, this.f12503c);
        }
    }
}
