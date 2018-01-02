package com.ushareit.listenit;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.ads.internal.view.p003d.p004b.C0033a.C0031a;

public class awp implements AnimationListener {
    final /* synthetic */ int f5586a;
    final /* synthetic */ int f5587b;
    final /* synthetic */ C0031a f5588c;

    public awp(C0031a c0031a, int i, int i2) {
        this.f5588c = c0031a;
        this.f5586a = i;
        this.f5587b = i2;
    }

    public void onAnimationEnd(Animation animation) {
        new Handler().postDelayed(new awq(this), 3000);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
