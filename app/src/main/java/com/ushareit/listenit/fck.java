package com.ushareit.listenit;

import android.util.SparseArray;

public enum fck {
    UNKNOWN(0),
    SYSTEM(1),
    SDCARD(2);
    
    private static SparseArray<fck> f12439e;
    private int f12441d;

    static {
        f12439e = new SparseArray();
        fck[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            fck com_ushareit_listenit_fck = values[i];
            f12439e.put(com_ushareit_listenit_fck.f12441d, com_ushareit_listenit_fck);
            i++;
        }
    }

    private fck(int i) {
        this.f12441d = i;
    }

    public static fck m18854a(int i) {
        return (fck) f12439e.get(Integer.valueOf(i).intValue());
    }
}
