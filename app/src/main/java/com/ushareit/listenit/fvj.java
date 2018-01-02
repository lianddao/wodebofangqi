package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class fvj implements OnScrollListener {
    final /* synthetic */ fva f13577a;

    fvj(fva com_ushareit_listenit_fva) {
        this.f13577a = com_ushareit_listenit_fva;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f13577a.f13563g.m18895a(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
