package com.ushareit.listenit;

public final class exu {
    public static void m18432a(String str) {
        if (str == null) {
            str = "invoke trace";
        }
        exw.m18455c("ASSERTION-FAILED", str, new Exception(str));
    }

    public static void m18434a(boolean z, String str) {
        if (!z) {
            m18432a(str);
        }
    }

    public static void m18433a(boolean z) {
        m18434a(z, null);
    }

    public static void m18430a(Object obj) {
        m18434a(obj != null, null);
    }

    public static void m18431a(Object obj, String str) {
        m18434a(obj != null, str);
    }
}
