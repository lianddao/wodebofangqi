package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.nearby.view.MyHomePageActivity;

public class gme implements OnScrollListener {
    final /* synthetic */ MyHomePageActivity f14401a;

    public gme(MyHomePageActivity myHomePageActivity) {
        this.f14401a = myHomePageActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f14401a.f15987q.getHeight() != 0 && i == 0) {
            int height = this.f14401a.f15987q.getHeight() - this.f14401a.f15989s.getHeight();
            int bottom = this.f14401a.f15987q.getBottom() - this.f14401a.f15989s.getHeight();
            erj.m17575f(this.f14401a.f15987q, (float) (-this.f14401a.f15987q.getTop()));
            erj.m17570a(this.f14401a.f15989s, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) bottom) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) height)));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
