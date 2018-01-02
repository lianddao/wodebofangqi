package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class pt extends Animation {
    final /* synthetic */ SwipeRefreshLayout f16288a;

    public pt(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16288a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f16288a.setAnimationProgress(f);
    }
}
