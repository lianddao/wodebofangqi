package com.ushareit.listenit;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.mopub.volley.DefaultRetryPolicy;
import java.util.List;

public final class bqx implements bfk, bgc, box {
    final /* synthetic */ SimpleExoPlayerView f7446a;

    private bqx(SimpleExoPlayerView simpleExoPlayerView) {
        this.f7446a = simpleExoPlayerView;
    }

    public void mo243a(List<bom> list) {
        this.f7446a.f1485c.mo243a(list);
    }

    public void mo110a(int i, int i2, int i3, float f) {
        this.f7446a.f1486d.setAspectRatio(i2 == 0 ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : (((float) i) * f) / ((float) i2));
    }

    public void mo109a() {
        this.f7446a.f1484b.setVisibility(8);
    }

    public void mo115b() {
        this.f7446a.f1484b.setVisibility(0);
    }

    public void mo116b(boolean z) {
    }

    public void mo114a(boolean z, int i) {
        this.f7446a.m2121a(false);
    }

    public void mo111a(bfi com_ushareit_listenit_bfi) {
    }

    public void mo119e() {
    }

    public void mo112a(bgd com_ushareit_listenit_bgd, Object obj) {
    }
}
