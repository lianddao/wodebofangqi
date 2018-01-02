package com.ushareit.listenit;

import android.util.SparseArray;

public enum fku {
    AUTO(0),
    MANUAL(1),
    LOGIN(2),
    DESTORY(3),
    NETWORK_CHANGED(4);
    
    private static SparseArray<fku> f12869g;
    private int f12871f;

    static {
        f12869g = new SparseArray();
        fku[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            fku com_ushareit_listenit_fku = values[i];
            f12869g.put(com_ushareit_listenit_fku.f12871f, com_ushareit_listenit_fku);
            i++;
        }
    }

    private fku(int i) {
        this.f12871f = i;
    }

    public int m19674a() {
        return this.f12871f;
    }

    public static fku m19673a(int i) {
        return (fku) f12869g.get(Integer.valueOf(i).intValue());
    }
}
