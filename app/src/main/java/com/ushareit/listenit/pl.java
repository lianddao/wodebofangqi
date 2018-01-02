package com.ushareit.listenit;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

public class pl extends qe {
    final /* synthetic */ SlidingPaneLayout f16114a;

    private pl(SlidingPaneLayout slidingPaneLayout) {
        this.f16114a = slidingPaneLayout;
    }

    public boolean mo2646a(View view, int i) {
        if (this.f16114a.f229l) {
            return false;
        }
        return ((LayoutParams) view.getLayoutParams()).f214b;
    }

    public void mo2652a(int i) {
        if (this.f16114a.f234q.m25685a() != 0) {
            return;
        }
        if (this.f16114a.f226i == 0.0f) {
            this.f16114a.m166d(this.f16114a.f225h);
            this.f16114a.m164c(this.f16114a.f225h);
            this.f16114a.f235r = false;
            return;
        }
        this.f16114a.m162b(this.f16114a.f225h);
        this.f16114a.f235r = true;
    }

    public void mo2970b(View view, int i) {
        this.f16114a.setAllChildrenVisible();
    }

    public void mo2653a(View view, int i, int i2, int i3, int i4) {
        this.f16114a.m142a(i);
        this.f16114a.invalidate();
    }

    public void mo2645a(View view, float f, float f2) {
        int paddingRight;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f16114a.m153e()) {
            paddingRight = layoutParams.rightMargin + this.f16114a.getPaddingRight();
            if (f < 0.0f || (f == 0.0f && this.f16114a.f226i > 0.5f)) {
                paddingRight += this.f16114a.f228k;
            }
            paddingRight = (this.f16114a.getWidth() - paddingRight) - this.f16114a.f225h.getWidth();
        } else {
            paddingRight = layoutParams.leftMargin + this.f16114a.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.f16114a.f226i > 0.5f)) {
                paddingRight += this.f16114a.f228k;
            }
        }
        this.f16114a.f234q.m25689a(paddingRight, view.getTop());
        this.f16114a.invalidate();
    }

    public int mo2967a(View view) {
        return this.f16114a.f228k;
    }

    public int mo2644a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.f16114a.f225h.getLayoutParams();
        if (this.f16114a.m153e()) {
            int width = this.f16114a.getWidth() - ((layoutParams.rightMargin + this.f16114a.getPaddingRight()) + this.f16114a.f225h.getWidth());
            return Math.max(Math.min(i, width), width - this.f16114a.f228k);
        }
        width = layoutParams.leftMargin + this.f16114a.getPaddingLeft();
        return Math.min(Math.max(i, width), this.f16114a.f228k + width);
    }

    public int mo2655b(View view, int i, int i2) {
        return view.getTop();
    }

    public void mo2969b(int i, int i2) {
        this.f16114a.f234q.m25688a(this.f16114a.f225h, i2);
    }
}
