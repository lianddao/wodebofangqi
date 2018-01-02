package com.ushareit.listenit;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class jh extends jf {
    static Field f15602b;
    static boolean f15603c = false;

    jh() {
    }

    public boolean mo2825a(View view, int i) {
        return jt.m24353a(view, i);
    }

    public boolean mo2829b(View view, int i) {
        return jt.m24354b(view, i);
    }

    public void mo2819a(View view, gk gkVar) {
        Object obj;
        if (gkVar == null) {
            obj = null;
        } else {
            obj = gkVar.m22115a();
        }
        jt.m24352a(view, obj);
    }

    public boolean mo2828b(View view) {
        boolean z = true;
        if (f15603c) {
            return false;
        }
        if (f15602b == null) {
            try {
                f15602b = View.class.getDeclaredField("mAccessibilityDelegate");
                f15602b.setAccessible(true);
            } catch (Throwable th) {
                f15603c = true;
                return false;
            }
        }
        try {
            if (f15602b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            f15603c = true;
            return false;
        }
    }

    public lj mo2852r(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        lj ljVar = (lj) this.a.get(view);
        if (ljVar != null) {
            return ljVar;
        }
        ljVar = new lj(view);
        this.a.put(view, ljVar);
        return ljVar;
    }
}
