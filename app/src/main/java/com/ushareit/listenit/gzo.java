package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class gzo implements OnClickListener {
    final /* synthetic */ gzn f14983a;

    gzo(gzn com_ushareit_listenit_gzn) {
        this.f14983a = com_ushareit_listenit_gzn;
    }

    public void onClick(View view) {
        List a = fqs.m20451a(this.f14983a.f14978n);
        if (!a.isEmpty()) {
            gyp.m23277a(a, 0, "");
            fii.m19311c(this.f14983a.f14978n, "main_allsong");
        }
    }
}
