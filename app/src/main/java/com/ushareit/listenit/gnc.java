package com.ushareit.listenit;

import android.graphics.Bitmap;
import com.ushareit.listenit.nearby.widget.SongsMenuBlurView;

public class gnc implements gxs {
    final /* synthetic */ SongsMenuBlurView f14441a;

    public gnc(SongsMenuBlurView songsMenuBlurView) {
        this.f14441a = songsMenuBlurView;
    }

    public void mo2368a(Bitmap bitmap) {
        this.f14441a.f16033c.post(new gnd(this, bitmap));
    }
}
