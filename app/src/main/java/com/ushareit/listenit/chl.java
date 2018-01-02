package com.ushareit.listenit;

public final class chl {
    public static final int f8314a = (23 - " PII_LOG".length());
    private static final String f8315b = null;
    private final String f8316c;
    private final String f8317d;

    public chl(String str) {
        this(str, null);
    }

    public chl(String str, String str2) {
        cfi.m11081a((Object) str, (Object) "log tag cannot be null");
        cfi.m11091b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.f8316c = str;
        if (str2 == null || str2.length() <= 0) {
            this.f8317d = null;
        } else {
            this.f8317d = str2;
        }
    }
}
