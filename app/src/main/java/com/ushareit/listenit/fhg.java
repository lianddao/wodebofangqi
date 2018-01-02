package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

class fhg implements OnClickListener {
    final /* synthetic */ RelativeLayout f12721a;
    final /* synthetic */ esi f12722b;
    final /* synthetic */ fhe f12723c;

    fhg(fhe com_ushareit_listenit_fhe, RelativeLayout relativeLayout, esi com_ushareit_listenit_esi) {
        this.f12723c = com_ushareit_listenit_fhe;
        this.f12721a = relativeLayout;
        this.f12722b = com_ushareit_listenit_esi;
    }

    public void onClick(View view) {
        this.f12721a.setVisibility(4);
        this.f12723c.m19170c(this.f12722b);
    }
}
