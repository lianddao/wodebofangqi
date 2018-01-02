package com.ushareit.listenit;

import android.view.View;
import com.ushareit.listenit.lockscreen.view.VerticalDragLayout;

public class gdn extends qe {
    final /* synthetic */ VerticalDragLayout f13960a;

    public gdn(VerticalDragLayout verticalDragLayout) {
        this.f13960a = verticalDragLayout;
    }

    public boolean mo2646a(View view, int i) {
        boolean z = true;
        if (view == this.f13960a.f15740d && this.f13960a.f15751o && this.f13960a.f15752p) {
            this.f13960a.f15737a.m25688a(this.f13960a.f15739c, i);
            return false;
        }
        boolean z2;
        String str = "Drag.Layout";
        StringBuilder append = new StringBuilder().append(" tryCaptureView= ");
        if (view == this.f13960a.f15739c) {
            z2 = true;
        } else {
            z2 = false;
        }
        exw.m18449b(str, append.append(z2).toString());
        if (!(view == this.f13960a.f15739c && this.f13960a.f15752p)) {
            z = false;
        }
        return z;
    }

    public void mo2653a(View view, int i, int i2, int i3, int i4) {
        super.mo2653a(view, i, i2, i3, i4);
        this.f13960a.f15741e = i2;
        this.f13960a.requestLayout();
        this.f13960a.m24588a((float) this.f13960a.f15741e);
        this.f13960a.m24598d();
    }

    public int mo2654b(View view) {
        return this.f13960a.f15738b;
    }

    public int mo2655b(View view, int i, int i2) {
        if (this.f13960a.f15747k) {
            return Math.max(i, this.f13960a.getPaddingTop() + this.f13960a.f15748l);
        }
        return Math.min(this.f13960a.f15742f, Math.max(i, this.f13960a.getPaddingTop() + this.f13960a.f15748l));
    }

    public void mo2645a(View view, float f, float f2) {
        int k;
        super.mo2645a(view, f, f2);
        if (f2 > 0.0f || this.f13960a.f15741e > this.f13960a.f15742f) {
            k = this.f13960a.f15742f + this.f13960a.getPaddingTop();
        } else {
            k = this.f13960a.getPaddingTop() + this.f13960a.f15748l;
        }
        this.f13960a.f15737a.m25689a(view.getLeft(), k);
        this.f13960a.postInvalidate();
    }

    public void mo2652a(int i) {
        super.mo2652a(i);
        exw.m18449b("Drag.Layout", "onViewDragStateChanged  state = " + i);
    }
}
