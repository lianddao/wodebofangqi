package com.ushareit.listenit;

public final class ago {
    public static <T> T m5589a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void m5593a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new NullPointerException();
            }
        }
    }

    public static <T> T m5590a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void m5591a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void m5592a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
