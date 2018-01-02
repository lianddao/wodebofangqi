package com.ushareit.listenit;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.ushareit.listenit.main.StartupActivity;

public class giy implements AnimationListener {
    final /* synthetic */ View f14185a;
    final /* synthetic */ StartupActivity f14186b;

    public giy(StartupActivity startupActivity, View view) {
        this.f14186b = startupActivity;
        this.f14185a = view;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f14185a.postDelayed(new giz(this), 500);
        this.f14186b.findViewById(C0349R.id.shareit_product).setVisibility(0);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
