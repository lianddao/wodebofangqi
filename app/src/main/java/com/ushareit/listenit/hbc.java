package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class hbc implements OnClickListener {
    final /* synthetic */ gla f15121a;
    final /* synthetic */ hbb f15122b;

    hbc(hbb com_ushareit_listenit_hbb, gla com_ushareit_listenit_gla) {
        this.f15122b = com_ushareit_listenit_hbb;
        this.f15121a = com_ushareit_listenit_gla;
    }

    public void onClick(View view) {
        if (this.f15122b.h != null) {
            this.f15122b.h.mo2610b(this.f15121a);
        }
    }
}
