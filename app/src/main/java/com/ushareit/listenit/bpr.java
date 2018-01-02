package com.ushareit.listenit;

import android.text.Layout.Alignment;

final class bpr extends bom {
    public final long f7353i;
    public final long f7354j;

    public bpr(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public bpr(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public bpr(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.f7353i = j;
        this.f7354j = j2;
    }

    public boolean m9442a() {
        return this.c == Float.MIN_VALUE && this.f == Float.MIN_VALUE;
    }
}
