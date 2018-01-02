package com.ushareit.listenit;

public enum bdj {
    CENTER("center", 0),
    LEFT("left", 1),
    RIGHT("right", 2);
    
    public static bdj f5932d;
    private String f5934e;
    private int f5935f;

    static {
        f5932d = CENTER;
    }

    public static bdj m7828a(int i) {
        for (bdj com_ushareit_listenit_bdj : values()) {
            if (com_ushareit_listenit_bdj.m7826a() == i) {
                return com_ushareit_listenit_bdj;
            }
        }
        return null;
    }

    private bdj(String str, int i) {
        this.f5934e = str;
        this.f5935f = i;
    }

    public String toString() {
        return this.f5934e;
    }

    private int m7826a() {
        return this.f5935f;
    }
}
