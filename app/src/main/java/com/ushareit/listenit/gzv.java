package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class gzv implements OnClickListener {
    final /* synthetic */ gzs f15015a;

    gzv(gzs com_ushareit_listenit_gzs) {
        this.f15015a = com_ushareit_listenit_gzs;
    }

    public void onClick(View view) {
        List q = fqs.m20484q();
        if (q.size() > 0) {
            gyp.m23277a(q, 11, "");
        }
        fii.m19311c(this.f15015a.o, "main_favrite");
    }
}
