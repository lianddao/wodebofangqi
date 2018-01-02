package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class fhi implements OnClickListener {
    final /* synthetic */ ViewGroup f12727a;
    final /* synthetic */ esi f12728b;
    final /* synthetic */ fhe f12729c;

    fhi(fhe com_ushareit_listenit_fhe, ViewGroup viewGroup, esi com_ushareit_listenit_esi) {
        this.f12729c = com_ushareit_listenit_fhe;
        this.f12727a = viewGroup;
        this.f12728b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12727a.removeAllViews();
        this.f12729c.m19170c(this.f12728b);
    }
}
