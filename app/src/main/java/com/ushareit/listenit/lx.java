package com.ushareit.listenit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class lx extends AnimatorListenerAdapter {
    final /* synthetic */ ly f15813a;
    final /* synthetic */ View f15814b;

    lx(ly lyVar, View view) {
        this.f15813a = lyVar;
        this.f15814b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f15813a.mo2882c(this.f15814b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f15813a.mo2881b(this.f15814b);
    }

    public void onAnimationStart(Animator animator) {
        this.f15813a.mo2880a(this.f15814b);
    }
}
