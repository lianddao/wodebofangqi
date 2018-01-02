package com.ushareit.listenit;

import android.util.SparseArray;

public enum eyz {
    UNKNOWN(0),
    MOBILE_2G(1),
    MOBILE_3G(2),
    MOBILE_4G(3);
    
    private static final SparseArray<eyz> f12215f = null;
    private int f12217e;

    static {
        f12215f = new SparseArray();
        eyz[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            eyz com_ushareit_listenit_eyz = values[i];
            f12215f.put(com_ushareit_listenit_eyz.f12217e, com_ushareit_listenit_eyz);
            i++;
        }
    }

    private eyz(int i) {
        this.f12217e = i;
    }

    public int m18579a() {
        return this.f12217e;
    }
}
