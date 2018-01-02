package com.ushareit.listenit;

public enum bac {
    AUTOMATIC("automatic", 0),
    DISPLAY_ALWAYS("display_always", 1),
    NEVER_DISPLAY("never_display", 2);
    
    public static bac f5768d;
    private String f5770e;
    private int f5771f;

    static {
        f5768d = AUTOMATIC;
    }

    public static bac m7484a(int i) {
        for (bac com_ushareit_listenit_bac : values()) {
            if (com_ushareit_listenit_bac.m7485a() == i) {
                return com_ushareit_listenit_bac;
            }
        }
        return null;
    }

    private bac(String str, int i) {
        this.f5770e = str;
        this.f5771f = i;
    }

    public String toString() {
        return this.f5770e;
    }

    public int m7485a() {
        return this.f5771f;
    }
}
