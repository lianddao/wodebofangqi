package com.ushareit.listenit;

import android.view.View;

public class rf {
    public int f16403a;
    public int f16404b;
    public int f16405c;
    public int f16406d;
    public int f16407e = 0;
    public int f16408f = 0;

    public boolean m25940a(ss ssVar) {
        return this.f16404b >= 0 && this.f16404b < ssVar.m26205e();
    }

    public View m25939a(sm smVar) {
        View c = smVar.m26160c(this.f16404b);
        this.f16404b += this.f16405c;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f16403a + ", mCurrentPosition=" + this.f16404b + ", mItemDirection=" + this.f16405c + ", mLayoutDirection=" + this.f16406d + ", mStartLine=" + this.f16407e + ", mEndLine=" + this.f16408f + '}';
    }
}
