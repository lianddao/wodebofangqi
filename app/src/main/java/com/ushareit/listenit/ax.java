package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ax implements AnimationListener {
    private AnimationListener f5573a;
    private boolean f5574b;
    private View f5575c;

    public ax(View view, Animation animation) {
        if (view != null && animation != null) {
            this.f5575c = view;
        }
    }

    public ax(View view, Animation animation, AnimationListener animationListener) {
        if (view != null && animation != null) {
            this.f5573a = animationListener;
            this.f5575c = view;
            this.f5574b = true;
        }
    }

    public void onAnimationStart(Animation animation) {
        if (this.f5573a != null) {
            this.f5573a.onAnimationStart(animation);
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f5575c != null && this.f5574b) {
            if (ja.m24177w(this.f5575c) || fc.m18842a()) {
                this.f5575c.post(new ay(this));
            } else {
                ja.m24137a(this.f5575c, 0, null);
            }
        }
        if (this.f5573a != null) {
            this.f5573a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.f5573a != null) {
            this.f5573a.onAnimationRepeat(animation);
        }
    }
}
