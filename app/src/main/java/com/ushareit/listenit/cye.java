package com.ushareit.listenit;

public class cye {
    private static final boolean f9358a = m13361b();

    public static boolean m13360a() {
        return f9358a;
    }

    private static boolean m13361b() {
        try {
            Class.forName("android.app.Activity");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
