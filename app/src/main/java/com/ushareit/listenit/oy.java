package com.ushareit.listenit;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

public class oy extends gk {
    public boolean mo2863a(View view, int i, Bundle bundle) {
        if (super.mo2863a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case 4096:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m137b(0, min);
                return true;
            case 8192:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m137b(0, min);
                return true;
            default:
                return false;
        }
    }

    public void mo2862a(View view, mh mhVar) {
        super.mo2862a(view, mhVar);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        mhVar.m24894b(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int a = nestedScrollView.getScrollRange();
            if (a > 0) {
                mhVar.m24914i(true);
                if (nestedScrollView.getScrollY() > 0) {
                    mhVar.m24884a(8192);
                }
                if (nestedScrollView.getScrollY() < a) {
                    mhVar.m24884a(4096);
                }
            }
        }
    }

    public void mo2864d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo2864d(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        nn a = mb.m24868a(accessibilityEvent);
        a.m25229a(nestedScrollView.getScrollRange() > 0);
        a.m25232d(nestedScrollView.getScrollX());
        a.m25233e(nestedScrollView.getScrollY());
        a.m25234f(nestedScrollView.getScrollX());
        a.m25235g(nestedScrollView.getScrollRange());
    }
}
