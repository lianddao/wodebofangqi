package com.ushareit.listenit;

import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ks implements ij {
    final /* synthetic */ ViewPager f15614a;
    private final Rect f15615b = new Rect();

    public ks(ViewPager viewPager) {
        this.f15614a = viewPager;
    }

    public lz mo2861a(View view, lz lzVar) {
        lz a = ja.m24134a(view, lzVar);
        if (a.mo2892e()) {
            return a;
        }
        Rect rect = this.f15615b;
        rect.left = a.mo2887a();
        rect.top = a.mo2889b();
        rect.right = a.mo2890c();
        rect.bottom = a.mo2891d();
        int childCount = this.f15614a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            lz b = ja.m24146b(this.f15614a.getChildAt(i), a);
            rect.left = Math.min(b.mo2887a(), rect.left);
            rect.top = Math.min(b.mo2889b(), rect.top);
            rect.right = Math.min(b.mo2890c(), rect.right);
            rect.bottom = Math.min(b.mo2891d(), rect.bottom);
        }
        return a.mo2888a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
