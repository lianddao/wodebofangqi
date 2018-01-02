package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mopub.volley.DefaultRetryPolicy;

public class pu extends Animation {
    final /* synthetic */ SwipeRefreshLayout f16289a;

    public pu(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16289a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f16289a.setAnimationProgress(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - f);
    }
}
