package com.ushareit.listenit;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public class hhe {
    public static Drawable m23348a(Drawable drawable, int i) {
        return m23349a(drawable, i, Mode.SRC_ATOP);
    }

    public static Drawable m23350b(Drawable drawable, int i) {
        return m23349a(drawable, i, Mode.MULTIPLY);
    }

    public static Drawable m23351c(Drawable drawable, int i) {
        return m23349a(drawable, i, Mode.SRC_IN);
    }

    public static Drawable m23349a(Drawable drawable, int i, Mode mode) {
        if (drawable == null) {
            return null;
        }
        drawable.setColorFilter(i, mode);
        return drawable;
    }

    public static Drawable m23347a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        drawable.clearColorFilter();
        return drawable;
    }
}
