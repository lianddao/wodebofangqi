package com.ushareit.listenit;

public final class hkb {
    private static boolean f15567a = false;

    public static String m24023a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        String str2 = null;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException e) {
        }
        return str2;
    }

    public static boolean m24025b(String str) {
        String a = m24023a(str);
        if (a == null) {
            return false;
        }
        return a.equalsIgnoreCase("true");
    }

    public static final void m24024a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void m24026c(String str) {
        System.err.println("SLF4J: " + str);
    }
}
