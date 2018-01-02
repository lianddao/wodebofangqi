package com.ushareit.listenit;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class awr extends Animation {
    final /* synthetic */ awq f5590a;

    awr(awq com_ushareit_listenit_awq) {
        this.f5590a = com_ushareit_listenit_awq;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        int i = (int) (((float) this.f5590a.f5589a.f5586a) + (((float) (this.f5590a.f5589a.f5587b - this.f5590a.f5589a.f5586a)) * f));
        this.f5590a.f5589a.f5588c.getLayoutParams().width = i;
        this.f5590a.f5589a.f5588c.requestLayout();
        this.f5590a.f5589a.f5588c.f680f.getLayoutParams().width = i - this.f5590a.f5589a.f5587b;
        this.f5590a.f5589a.f5588c.f680f.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
