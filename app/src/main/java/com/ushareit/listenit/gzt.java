package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class gzt implements OnClickListener {
    final /* synthetic */ gzs f15013a;

    gzt(gzs com_ushareit_listenit_gzs) {
        this.f15013a = com_ushareit_listenit_gzs;
    }

    public void onClick(View view) {
        List r = fqs.m20485r();
        if (r.size() > 0) {
            gyp.m23277a(r, 9, "");
        }
        fii.m19311c(this.f15013a.o, "main_recentadd");
    }
}
