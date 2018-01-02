package com.ushareit.listenit;

import android.util.SparseArray;

enum euj {
    ZIP(1),
    ENCRYPT_CONTENTS(2),
    ENCRYPT_KEY_CONTENTS(3);
    
    private static SparseArray<euj> f11891e;
    private int f11893d;

    static {
        f11891e = new SparseArray();
        euj[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            euj com_ushareit_listenit_euj = values[i];
            f11891e.put(com_ushareit_listenit_euj.f11893d, com_ushareit_listenit_euj);
            i++;
        }
    }

    private euj(int i) {
        this.f11893d = i;
    }

    public int m18006a() {
        return this.f11893d;
    }
}
