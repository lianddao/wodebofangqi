package com.ushareit.listenit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class axd extends AnimatorListenerAdapter {
    final /* synthetic */ axc f5609a;

    axd(axc com_ushareit_listenit_axc) {
        this.f5609a = com_ushareit_listenit_axc;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5609a.f5608a.f5596a.postDelayed(new axe(this), 2000);
    }
}
