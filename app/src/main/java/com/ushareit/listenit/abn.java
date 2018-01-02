package com.ushareit.listenit;

import android.graphics.drawable.Drawable;

public abstract class abn<T extends Drawable> implements wk<T> {
    protected final T f4023a;

    public /* synthetic */ Object mo553b() {
        return m5059a();
    }

    public abn(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f4023a = t;
    }

    public final T m5059a() {
        return this.f4023a.getConstantState().newDrawable();
    }
}
