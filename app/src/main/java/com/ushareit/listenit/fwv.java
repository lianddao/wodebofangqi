package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.mopub.volley.DefaultRetryPolicy;

class fwv implements OnScrollListener {
    final /* synthetic */ fwf f13639a;

    fwv(fwf com_ushareit_listenit_fwf) {
        this.f13639a = com_ushareit_listenit_fwf;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f13639a.f13618f.getHeight() != 0 && i == 0) {
            int height = this.f13639a.f13618f.getHeight() - this.f13639a.m19534V();
            int bottom = this.f13639a.f13618f.getBottom() - this.f13639a.m19534V();
            erj.m17575f(this.f13639a.f13618f, (float) (-this.f13639a.f13618f.getTop()));
            this.f13639a.m19536a((((float) bottom) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) height));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
