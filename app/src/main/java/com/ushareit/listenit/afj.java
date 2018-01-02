package com.ushareit.listenit;

import android.view.View;

public abstract class afj<T extends View, Z> extends aey<Z> {
    private static boolean f4251b = false;
    private static Integer f4252c = null;
    protected final T f4253a;
    private final afk f4254d;

    public afj(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f4253a = t;
        this.f4254d = new afk(t);
    }

    public T m5430a() {
        return this.f4253a;
    }

    public void mo581a(aff com_ushareit_listenit_aff) {
        this.f4254d.m5464a(com_ushareit_listenit_aff);
    }

    public void mo573a(aei com_ushareit_listenit_aei) {
        mo614a((Object) com_ushareit_listenit_aei);
    }

    public aei mo576c() {
        Object g = m5429g();
        if (g == null) {
            return null;
        }
        if (g instanceof aei) {
            return (aei) g;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    private void mo614a(Object obj) {
        if (f4252c == null) {
            f4251b = true;
            this.f4253a.setTag(obj);
            return;
        }
        this.f4253a.setTag(f4252c.intValue(), obj);
    }

    private Object m5429g() {
        if (f4252c == null) {
            return this.f4253a.getTag();
        }
        return this.f4253a.getTag(f4252c.intValue());
    }

    public String toString() {
        return "Target for: " + this.f4253a;
    }
}
