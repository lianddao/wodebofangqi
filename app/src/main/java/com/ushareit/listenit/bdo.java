package com.ushareit.listenit;

public enum bdo {
    STANDARD("standard", 0),
    BUTTON("button", 1),
    BOX_COUNT("box_count", 2);
    
    public static bdo f5949d;
    private String f5951e;
    private int f5952f;

    static {
        f5949d = STANDARD;
    }

    public static bdo m7836a(int i) {
        for (bdo com_ushareit_listenit_bdo : values()) {
            if (com_ushareit_listenit_bdo.m7834a() == i) {
                return com_ushareit_listenit_bdo;
            }
        }
        return null;
    }

    private bdo(String str, int i) {
        this.f5951e = str;
        this.f5952f = i;
    }

    public String toString() {
        return this.f5951e;
    }

    private int m7834a() {
        return this.f5952f;
    }
}
