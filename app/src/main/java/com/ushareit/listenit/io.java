package com.ushareit.listenit;

import android.database.DataSetObserver;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

public class io extends DataSetObserver implements kw, kx {
    final /* synthetic */ PagerTitleStrip f15595a;
    private int f15596b;

    private io(PagerTitleStrip pagerTitleStrip) {
        this.f15595a = pagerTitleStrip;
    }

    public void mo2619a(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.f15595a.mo1a(i, f, false);
    }

    public void mo2618a(int i) {
        float f = 0.0f;
        if (this.f15596b == 0) {
            this.f15595a.m10a(this.f15595a.f40a.getCurrentItem(), this.f15595a.f40a.getAdapter());
            if (this.f15595a.f46g >= 0.0f) {
                f = this.f15595a.f46g;
            }
            this.f15595a.mo1a(this.f15595a.f40a.getCurrentItem(), f, true);
        }
    }

    public void mo2620b(int i) {
        this.f15596b = i;
    }

    public void mo2808a(ViewPager viewPager, ik ikVar, ik ikVar2) {
        this.f15595a.m11a(ikVar, ikVar2);
    }

    public void onChanged() {
        float f = 0.0f;
        this.f15595a.m10a(this.f15595a.f40a.getCurrentItem(), this.f15595a.f40a.getAdapter());
        if (this.f15595a.f46g >= 0.0f) {
            f = this.f15595a.f46g;
        }
        this.f15595a.mo1a(this.f15595a.f40a.getCurrentItem(), f, true);
    }
}
