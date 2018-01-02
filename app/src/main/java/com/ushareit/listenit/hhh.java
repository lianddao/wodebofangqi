package com.ushareit.listenit;

import android.util.Pair;

public class hhh {
    public static boolean m23858a() {
        Pair a = eyw.m18568a(eys.m18562a());
        return ((Boolean) a.first).booleanValue() || ((Boolean) a.second).booleanValue();
    }

    public static boolean m23859a(String str) {
        return !fbb.m18763c(str) && (str.startsWith("https://") || str.startsWith("http://"));
    }

    public static String m23860b(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(".");
            int length = str.length();
            return (lastIndexOf <= 0 || lastIndexOf >= length) ? "" : str.substring(lastIndexOf + 1, length);
        } catch (Exception e) {
            return "";
        }
    }
}
