package com.ushareit.listenit;

import java.util.Arrays;

final class bpv {
    private static final String[] f7369e = new String[0];
    public final String f7370a;
    public final int f7371b;
    public final String f7372c;
    public final String[] f7373d;

    private bpv(String str, int i, String str2, String[] strArr) {
        this.f7371b = i;
        this.f7370a = str;
        this.f7372c = str2;
        this.f7373d = strArr;
    }

    public static bpv m9472a(String str, int i) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        String str2;
        int indexOf = trim.indexOf(" ");
        if (indexOf == -1) {
            str2 = trim;
            trim = "";
        } else {
            String trim2 = trim.substring(indexOf).trim();
            str2 = trim.substring(0, indexOf);
            trim = trim2;
        }
        String[] split = str2.split("\\.");
        String str3 = split[0];
        if (split.length > 1) {
            split = (String[]) Arrays.copyOfRange(split, 1, split.length);
        } else {
            split = f7369e;
        }
        return new bpv(str3, i, trim, split);
    }

    public static bpv m9471a() {
        return new bpv("", 0, "", new String[0]);
    }
}
