package com.ushareit.listenit;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class jx {
    private static ThreadLocal<Rect> f15609a;

    public static void m24373a(View view, float f) {
        view.setElevation(f);
    }

    public static float m24370a(View view) {
        return view.getElevation();
    }

    public static void m24375a(View view, ij ijVar) {
        if (ijVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new jy(ijVar));
        }
    }

    public static lz m24372a(View view, lz lzVar) {
        if (!(lzVar instanceof ma)) {
            return lzVar;
        }
        WindowInsets f = ((ma) lzVar).m24794f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (onApplyWindowInsets != f) {
            return new ma(onApplyWindowInsets);
        }
        return lzVar;
    }

    public static lz m24376b(View view, lz lzVar) {
        if (!(lzVar instanceof ma)) {
            return lzVar;
        }
        WindowInsets f = ((ma) lzVar).m24794f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        if (dispatchApplyWindowInsets != f) {
            return new ma(dispatchApplyWindowInsets);
        }
        return lzVar;
    }

    public static boolean m24378b(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m24379c(View view) {
        view.stopNestedScroll();
    }

    static void m24374a(View view, int i) {
        Object obj;
        Rect a = m24371a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        js.m24338a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m24377b(View view, int i) {
        Object obj;
        Rect a = m24371a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        js.m24343b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    private static Rect m24371a() {
        if (f15609a == null) {
            f15609a = new ThreadLocal();
        }
        Rect rect = (Rect) f15609a.get();
        if (rect == null) {
            rect = new Rect();
            f15609a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
