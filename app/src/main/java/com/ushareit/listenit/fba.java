package com.ushareit.listenit;

public final class fba {
    public static boolean m18746a(long j) {
        return j != -1 && System.currentTimeMillis() < j;
    }

    public static boolean m18748b(long j) {
        return j != -1 && System.currentTimeMillis() > j;
    }

    public static boolean m18747a(long j, long j2) {
        return j != -1 && System.currentTimeMillis() > j + j2;
    }
}
