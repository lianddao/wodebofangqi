package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class pz extends Animation {
    final /* synthetic */ SwipeRefreshLayout f16296a;

    public pz(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16296a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f16296a.setAnimationProgress(this.f16296a.f242B + ((-this.f16296a.f242B) * f));
        this.f16296a.m189c(f);
    }
}
