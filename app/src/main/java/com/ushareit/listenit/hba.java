package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hba implements OnClickListener {
    final /* synthetic */ gla f15111a;
    final /* synthetic */ haz f15112b;

    hba(haz com_ushareit_listenit_haz, gla com_ushareit_listenit_gla) {
        this.f15112b = com_ushareit_listenit_haz;
        this.f15111a = com_ushareit_listenit_gla;
    }

    public void onClick(View view) {
        if (this.f15112b.h != null) {
            this.f15112b.h.mo2610b(this.f15111a);
        }
    }
}
