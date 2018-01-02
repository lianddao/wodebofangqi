package com.ushareit.listenit;

import android.util.SparseArray;

public enum eza {
    UNKNOWN(0),
    OFFLINE(1),
    WIFI(2),
    MOBILE(3);
    
    private static final SparseArray<eza> f12222f = null;
    private int f12224e;

    static {
        f12222f = new SparseArray();
        eza[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            eza com_ushareit_listenit_eza = values[i];
            f12222f.put(com_ushareit_listenit_eza.f12224e, com_ushareit_listenit_eza);
            i++;
        }
    }

    private eza(int i) {
        this.f12224e = i;
    }

    public int m18581a() {
        return this.f12224e;
    }
}
