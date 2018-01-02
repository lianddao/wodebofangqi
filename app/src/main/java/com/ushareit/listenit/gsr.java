package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;

class gsr implements OnClickListener {
    final /* synthetic */ gsq f14677a;

    gsr(gsq com_ushareit_listenit_gsq) {
        this.f14677a = com_ushareit_listenit_gsq;
    }

    public void onClick(View view) {
        if (this.f14677a.al != null) {
            this.f14677a.al.mo2741a(this.f14677a.f14669b.getText().toString().trim());
        }
    }
}
