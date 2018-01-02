package com.ushareit.listenit;

import android.view.animation.Interpolator;
import com.mopub.volley.DefaultRetryPolicy;

public final class rt implements Interpolator {
    public float getInterpolation(float f) {
        float f2 = f - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        return (f2 * (((f2 * f2) * f2) * f2)) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }
}
