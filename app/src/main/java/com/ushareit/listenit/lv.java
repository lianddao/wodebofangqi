package com.ushareit.listenit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class lv extends AnimatorListenerAdapter {
    final /* synthetic */ ly f15811a;
    final /* synthetic */ View f15812b;

    lv(ly lyVar, View view) {
        this.f15811a = lyVar;
        this.f15812b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f15811a.mo2882c(this.f15812b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f15811a.mo2881b(this.f15812b);
    }

    public void onAnimationStart(Animator animator) {
        this.f15811a.mo2880a(this.f15812b);
    }
}
