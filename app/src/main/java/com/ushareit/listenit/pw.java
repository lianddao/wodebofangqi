package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class pw implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f16293a;

    public pw(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16293a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f16293a.f277v) {
            this.f16293a.m187b(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
