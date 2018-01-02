package com.ushareit.listenit;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.mopub.volley.DefaultRetryPolicy;

class aeo implements aew {
    private final int f4243a;

    aeo(int i) {
        this.f4243a = i;
    }

    public Animation mo611a() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        alphaAnimation.setDuration((long) this.f4243a);
        return alphaAnimation;
    }
}
