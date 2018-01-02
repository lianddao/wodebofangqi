package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hbe implements OnClickListener {
    final /* synthetic */ gla f15132a;
    final /* synthetic */ hbd f15133b;

    hbe(hbd com_ushareit_listenit_hbd, gla com_ushareit_listenit_gla) {
        this.f15133b = com_ushareit_listenit_hbd;
        this.f15132a = com_ushareit_listenit_gla;
    }

    public void onClick(View view) {
        if (this.f15133b.h != null) {
            this.f15133b.h.mo2610b(this.f15132a);
        }
    }
}
