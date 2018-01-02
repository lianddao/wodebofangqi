package com.ushareit.listenit;

public enum bdm {
    UNKNOWN("unknown", 0),
    OPEN_GRAPH("open_graph", 1),
    PAGE("page", 2);
    
    public static bdm f5942d;
    private String f5944e;
    private int f5945f;

    static {
        f5942d = UNKNOWN;
    }

    public static bdm m7831a(int i) {
        for (bdm com_ushareit_listenit_bdm : values()) {
            if (com_ushareit_listenit_bdm.m7832a() == i) {
                return com_ushareit_listenit_bdm;
            }
        }
        return null;
    }

    private bdm(String str, int i) {
        this.f5944e = str;
        this.f5945f = i;
    }

    public String toString() {
        return this.f5944e;
    }

    public int m7832a() {
        return this.f5945f;
    }
}
