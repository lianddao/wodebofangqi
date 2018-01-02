package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class py extends Animation {
    final /* synthetic */ SwipeRefreshLayout f16295a;

    public py(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16295a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f16295a.m189c(f);
    }
}
