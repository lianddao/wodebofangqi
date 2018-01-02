package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class gud implements OnScrollListener {
    final /* synthetic */ gua f14738a;

    gud(gua com_ushareit_listenit_gua) {
        this.f14738a = com_ushareit_listenit_gua;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f14738a.f14730e.m22728b(i);
        this.f14738a.m22707U();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
