package com.ushareit.listenit;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

class err extends erl {
    private final WeakReference<ViewPropertyAnimator> f11623a;

    err(View view) {
        this.f11623a = new WeakReference(view.animate());
    }

    public erl mo2272a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    public erl mo2273a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public erl mo2274a(epl com_ushareit_listenit_epl) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            if (com_ushareit_listenit_epl == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new ers(this, com_ushareit_listenit_epl));
            }
        }
        return this;
    }

    public erl mo2271a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    public erl mo2275b(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    public erl mo2276c(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    public erl mo2277d(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    public erl mo2278e(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f11623a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }
}
