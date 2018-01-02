package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class gzj implements AnimationListener {
    final /* synthetic */ boolean f14954a;
    final /* synthetic */ View f14955b;
    final /* synthetic */ View f14956c;
    final /* synthetic */ gzk f14957d;

    gzj(boolean z, View view, View view2, gzk com_ushareit_listenit_gzk) {
        this.f14954a = z;
        this.f14955b = view;
        this.f14956c = view2;
        this.f14957d = com_ushareit_listenit_gzk;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f14954a) {
            this.f14955b.setVisibility(0);
        } else {
            this.f14955b.setVisibility(4);
        }
        this.f14956c.startAnimation(this.f14957d);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
