package com.ushareit.listenit;

import android.graphics.Rect;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class pj extends gk {
    final /* synthetic */ SlidingPaneLayout f16110b;
    private final Rect f16111c = new Rect();

    public pj(SlidingPaneLayout slidingPaneLayout) {
        this.f16110b = slidingPaneLayout;
    }

    public void mo2862a(View view, mh mhVar) {
        mh a = mh.m24879a(mhVar);
        super.mo2862a(view, a);
        m25489a(mhVar, a);
        a.m24926t();
        mhVar.m24894b(SlidingPaneLayout.class.getName());
        mhVar.m24886a(view);
        ViewParent i = ja.m24163i(view);
        if (i instanceof View) {
            mhVar.m24899c((View) i);
        }
        int childCount = this.f16110b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f16110b.getChildAt(i2);
            if (!m25492b(childAt) && childAt.getVisibility() == 0) {
                ja.m24151c(childAt, 1);
                mhVar.m24893b(childAt);
            }
        }
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2864d(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    public boolean mo2960a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (m25492b(view)) {
            return false;
        }
        return super.mo2960a(viewGroup, view, accessibilityEvent);
    }

    public boolean m25492b(View view) {
        return this.f16110b.m168e(view);
    }

    private void m25489a(mh mhVar, mh mhVar2) {
        Rect rect = this.f16111c;
        mhVar2.m24885a(rect);
        mhVar.m24892b(rect);
        mhVar2.m24898c(rect);
        mhVar.m24903d(rect);
        mhVar.m24902c(mhVar2.m24913h());
        mhVar.m24887a(mhVar2.m24922p());
        mhVar.m24894b(mhVar2.m24923q());
        mhVar.m24900c(mhVar2.m24925s());
        mhVar.m24912h(mhVar2.m24919m());
        mhVar.m24908f(mhVar2.m24917k());
        mhVar.m24888a(mhVar2.m24909f());
        mhVar.m24896b(mhVar2.m24911g());
        mhVar.m24904d(mhVar2.m24915i());
        mhVar.m24906e(mhVar2.m24916j());
        mhVar.m24910g(mhVar2.m24918l());
        mhVar.m24884a(mhVar2.m24890b());
        mhVar.m24891b(mhVar2.m24897c());
    }
}
