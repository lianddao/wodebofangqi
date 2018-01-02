package com.ushareit.listenit;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class gzu implements OnClickListener {
    final /* synthetic */ gzs f15014a;

    gzu(gzs com_ushareit_listenit_gzs) {
        this.f15014a = com_ushareit_listenit_gzs;
    }

    public void onClick(View view) {
        List s = fqs.m20486s();
        if (s.size() > 0) {
            gyp.m23277a(s, 10, "");
        }
        fii.m19311c(this.f15014a.o, "main_lastplayed");
    }
}
