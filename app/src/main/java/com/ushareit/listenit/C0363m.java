package com.ushareit.listenit;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

class C0363m implements C0361k {
    private TimeInterpolator f15888a;

    C0363m() {
    }

    public void mo2865a(View view) {
        if (this.f15888a == null) {
            this.f15888a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f15888a);
    }
}
