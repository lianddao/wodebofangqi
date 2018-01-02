package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Animation;

class aw extends ax {
    final /* synthetic */ ah f5576a;
    final /* synthetic */ at f5577b;

    aw(at atVar, View view, Animation animation, ah ahVar) {
        this.f5577b = atVar;
        this.f5576a = ahVar;
        super(view, animation);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.f5576a.f1010l != null) {
            this.f5576a.f1010l = null;
            this.f5577b.m7065a(this.f5576a, this.f5576a.f1011m, 0, 0, false);
        }
    }
}
