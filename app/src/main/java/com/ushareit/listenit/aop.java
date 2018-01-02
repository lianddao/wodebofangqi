package com.ushareit.listenit;

import java.util.UUID;

public class aop {
    private static final String f5078a = aop.class.getSimpleName();
    private static volatile boolean f5079b = false;
    private static double f5080c;
    private static String f5081d;

    public static void m6483a() {
        if (!f5079b) {
            synchronized (f5078a) {
                if (!f5079b) {
                    f5079b = true;
                    f5080c = ((double) System.currentTimeMillis()) / 1000.0d;
                    f5081d = UUID.randomUUID().toString();
                }
            }
        }
    }

    public static double m6484b() {
        return f5080c;
    }

    public static String m6485c() {
        return f5081d;
    }
}
