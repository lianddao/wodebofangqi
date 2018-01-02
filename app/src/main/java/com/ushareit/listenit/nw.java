package com.ushareit.listenit;

import android.view.animation.Interpolator;
import com.mopub.volley.DefaultRetryPolicy;

abstract class nw implements Interpolator {
    private final float[] f16042a;
    private final float f16043b = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / ((float) (this.f16042a.length - 1)));

    public nw(float[] fArr) {
        this.f16042a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f16042a.length - 1)) * f), this.f16042a.length - 2);
        float f2 = (f - (((float) min) * this.f16043b)) / this.f16043b;
        return ((this.f16042a[min + 1] - this.f16042a[min]) * f2) + this.f16042a[min];
    }
}
