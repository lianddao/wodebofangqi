package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.widget.dragsortlistview.DragSortListView;

public class hew extends hez {
    final /* synthetic */ DragSortListView f15318a;
    private float f15319d;
    private float f15320e;

    public void mo2759a() {
        this.f15319d = (float) this.f15318a.f17461o;
        this.f15320e = (float) this.f15318a.f17471y;
    }

    public void mo2760a(float f, float f2) {
        if (this.f15318a.f17468v != 4) {
            m23644d();
            return;
        }
        this.f15318a.f17461o = (int) ((this.f15320e * f2) + ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f2) * this.f15319d));
        this.f15318a.f17448b.y = this.f15318a.f17437N - this.f15318a.f17461o;
        this.f15318a.m27042b(true);
    }
}
