package com.ushareit.listenit;

public enum alx {
    UNSPECIFIED,
    VERTICAL,
    HORIZONTAL;

    public static alx m6118a(int i) {
        return i == 0 ? UNSPECIFIED : i == 2 ? HORIZONTAL : VERTICAL;
    }
}
