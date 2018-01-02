package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class fss implements OnClickListener {
    final /* synthetic */ gla f13414a;
    final /* synthetic */ fsr f13415b;

    fss(fsr com_ushareit_listenit_fsr, gla com_ushareit_listenit_gla) {
        this.f13415b = com_ushareit_listenit_fsr;
        this.f13414a = com_ushareit_listenit_gla;
    }

    public void onClick(View view) {
        if (this.f13415b.h != null) {
            this.f13415b.h.mo2610b(this.f13414a);
        }
    }
}
