package com.ushareit.listenit;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.nearby.view.SongMenuActivity;

public class gmq implements OnScrollListener {
    final /* synthetic */ SongMenuActivity f14426a;

    public gmq(SongMenuActivity songMenuActivity) {
        this.f14426a = songMenuActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f14426a.f16015t.getHeight() != 0 && i == 0) {
            int height = this.f14426a.f16015t.getHeight() - this.f14426a.f16017z.getHeight();
            int bottom = this.f14426a.f16015t.getBottom() - this.f14426a.f16017z.getHeight();
            erj.m17575f(this.f14426a.f16015t, (float) (-this.f14426a.f16015t.getTop()));
            erj.m17570a(this.f14426a.f16016y, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) bottom) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) height)));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
