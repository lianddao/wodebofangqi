package com.ushareit.listenit;

import android.util.SparseArray;

public enum exs {
    PRESET_ALARM(0),
    WRAPPER_EVENT(1),
    SYSTEM_EVENT(2),
    OPERATE_APP(3);
    
    private static SparseArray<exs> f12139f;
    private int f12141e;

    static {
        f12139f = new SparseArray();
        exs[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            exs com_ushareit_listenit_exs = values[i];
            f12139f.put(com_ushareit_listenit_exs.f12141e, com_ushareit_listenit_exs);
            i++;
        }
    }

    private exs(int i) {
        this.f12141e = i;
    }
}
