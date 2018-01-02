package com.ushareit.listenit;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.mopub.volley.DefaultRetryPolicy;

class ov implements AnimationListener {
    final /* synthetic */ ox f16081a;
    final /* synthetic */ ot f16082b;

    ov(ot otVar, ox oxVar) {
        this.f16082b = otVar;
        this.f16081a = oxVar;
    }

    public void onAnimationStart(Animation animation) {
        this.f16082b.f16075k = 0.0f;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
        this.f16081a.m25410l();
        this.f16081a.m25393b();
        this.f16081a.m25394b(this.f16081a.m25407i());
        if (this.f16082b.f16067a) {
            this.f16082b.f16067a = false;
            animation.setDuration(1332);
            this.f16081a.m25391a(false);
            return;
        }
        this.f16082b.f16075k = (this.f16082b.f16075k + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) % 5.0f;
    }
}
