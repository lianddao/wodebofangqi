package com.ushareit.listenit;

public enum bdi {
    BOTTOM("bottom", 0),
    INLINE("inline", 1),
    TOP("top", 2);
    
    public static bdi f5925d;
    private String f5927e;
    private int f5928f;

    static {
        f5925d = BOTTOM;
    }

    public static bdi m7825a(int i) {
        for (bdi com_ushareit_listenit_bdi : values()) {
            if (com_ushareit_listenit_bdi.m7823a() == i) {
                return com_ushareit_listenit_bdi;
            }
        }
        return null;
    }

    private bdi(String str, int i) {
        this.f5927e = str;
        this.f5928f = i;
    }

    public String toString() {
        return this.f5927e;
    }

    private int m7823a() {
        return this.f5928f;
    }
}
