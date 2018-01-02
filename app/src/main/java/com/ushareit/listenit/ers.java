package com.ushareit.listenit;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ers implements AnimatorListener {
    final /* synthetic */ epl f11624a;
    final /* synthetic */ err f11625b;

    ers(err com_ushareit_listenit_err, epl com_ushareit_listenit_epl) {
        this.f11625b = com_ushareit_listenit_err;
        this.f11624a = com_ushareit_listenit_epl;
    }

    public void onAnimationStart(Animator animator) {
        this.f11624a.mo2229a(null);
    }

    public void onAnimationRepeat(Animator animator) {
        this.f11624a.mo2232d(null);
    }

    public void onAnimationEnd(Animator animator) {
        this.f11624a.mo2230b(null);
    }

    public void onAnimationCancel(Animator animator) {
        this.f11624a.mo2231c(null);
    }
}
