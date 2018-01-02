package com.ushareit.listenit;

import android.util.SparseArray;

public enum fbi {
    GAME(0),
    NATIVE_APP(1),
    APP(2),
    WIDGET(3);
    
    private static SparseArray<fbi> f12373f;
    private int f12375e;

    static {
        f12373f = new SparseArray();
        fbi[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            fbi com_ushareit_listenit_fbi = values[i];
            f12373f.put(com_ushareit_listenit_fbi.f12375e, com_ushareit_listenit_fbi);
            i++;
        }
    }

    private fbi(int i) {
        this.f12375e = i;
    }

    public static fbi m18781a(int i) {
        return (fbi) f12373f.get(Integer.valueOf(i).intValue());
    }
}
