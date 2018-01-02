package com.ushareit.listenit;

import android.util.SparseArray;

public enum gul {
    AppDestory(0),
    ConnChange(1);
    
    private static SparseArray<gul> f14754d;
    private int f14756c;

    static {
        f14754d = new SparseArray();
        gul[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            gul com_ushareit_listenit_gul = values[i];
            f14754d.put(com_ushareit_listenit_gul.f14756c, com_ushareit_listenit_gul);
            i++;
        }
    }

    private gul(int i) {
        this.f14756c = i;
    }

    public static gul m22820a(int i) {
        return (gul) f14754d.get(Integer.valueOf(i).intValue());
    }

    public int m22821a() {
        return this.f14756c;
    }
}
