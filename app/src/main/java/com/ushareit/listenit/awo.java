package com.ushareit.listenit;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.facebook.ads.internal.view.p003d.p004b.C0033a.C0031a;

public class awo extends Animation {
    final /* synthetic */ int f5583a;
    final /* synthetic */ int f5584b;
    final /* synthetic */ C0031a f5585c;

    public awo(C0031a c0031a, int i, int i2) {
        this.f5585c = c0031a;
        this.f5583a = i;
        this.f5584b = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        int i = (int) (((float) this.f5583a) + (((float) (this.f5584b - this.f5583a)) * f));
        this.f5585c.getLayoutParams().width = i;
        this.f5585c.requestLayout();
        this.f5585c.f680f.getLayoutParams().width = i - this.f5583a;
        this.f5585c.f680f.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
