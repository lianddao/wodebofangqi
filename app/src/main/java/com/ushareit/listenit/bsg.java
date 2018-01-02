package com.ushareit.listenit;

import android.text.TextUtils;

public final class bsg {
    public static void m9656a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m9657a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int m9653a(int i, int i2, int i3) {
        if (i >= i2 && i < i3) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void m9658b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m9659b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T m9654a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static String m9655a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}
