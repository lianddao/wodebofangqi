package com.ushareit.listenit;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class ps implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f16287a;

    public ps(SwipeRefreshLayout swipeRefreshLayout) {
        this.f16287a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f16287a.f261f) {
            this.f16287a.f243C.setAlpha(255);
            this.f16287a.f243C.start();
            if (this.f16287a.f250J && this.f16287a.f260e != null) {
                this.f16287a.f260e.mo2554a();
            }
            this.f16287a.f271p = this.f16287a.f280z.getTop();
            return;
        }
        this.f16287a.m183b();
    }
}
