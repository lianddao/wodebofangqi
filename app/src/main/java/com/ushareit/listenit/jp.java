package com.ushareit.listenit;

import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class jp {
    private static Field f15604a;
    private static boolean f15605b;
    private static Field f15606c;
    private static boolean f15607d;

    static int m24326a(View view) {
        if (!f15605b) {
            try {
                f15604a = View.class.getDeclaredField("mMinWidth");
                f15604a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f15605b = true;
        }
        if (f15604a != null) {
            try {
                return ((Integer) f15604a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m24328b(View view) {
        if (!f15607d) {
            try {
                f15606c = View.class.getDeclaredField("mMinHeight");
                f15606c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f15607d = true;
        }
        if (f15606c != null) {
            try {
                return ((Integer) f15606c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m24330c(View view) {
        return view.getWindowToken() != null;
    }

    static void m24327a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m24329b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
