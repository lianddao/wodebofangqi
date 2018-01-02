package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class gtj implements OnScrollListener {
    final /* synthetic */ gta f14708a;

    gtj(gta com_ushareit_listenit_gta) {
        this.f14708a = com_ushareit_listenit_gta;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f14708a.ay) {
            this.f14708a.f14696f.m22699b(i);
        } else {
            this.f14708a.f14695e.m22728b(i);
        }
        this.f14708a.m22737X();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
