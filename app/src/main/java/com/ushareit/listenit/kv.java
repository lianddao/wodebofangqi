package com.ushareit.listenit;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class kv extends gk {
    final /* synthetic */ ViewPager f15621b;

    public kv(ViewPager viewPager) {
        this.f15621b = viewPager;
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2864d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        nn a = mb.m24868a(accessibilityEvent);
        a.m25229a(m24395b());
        if (accessibilityEvent.getEventType() == 4096 && this.f15621b.f109h != null) {
            a.m25228a(this.f15621b.f109h.mo2352b());
            a.m25230b(this.f15621b.f110i);
            a.m25231c(this.f15621b.f110i);
        }
    }

    public void mo2862a(View view, mh mhVar) {
        super.mo2862a(view, mhVar);
        mhVar.m24894b(ViewPager.class.getName());
        mhVar.m24914i(m24395b());
        if (this.f15621b.canScrollHorizontally(1)) {
            mhVar.m24884a(4096);
        }
        if (this.f15621b.canScrollHorizontally(-1)) {
            mhVar.m24884a(8192);
        }
    }

    public boolean mo2863a(View view, int i, Bundle bundle) {
        if (super.mo2863a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f15621b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f15621b.setCurrentItem(this.f15621b.f110i + 1);
                return true;
            case 8192:
                if (!this.f15621b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f15621b.setCurrentItem(this.f15621b.f110i - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean m24395b() {
        return this.f15621b.f109h != null && this.f15621b.f109h.mo2352b() > 1;
    }
}
