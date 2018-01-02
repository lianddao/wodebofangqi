package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public enum fbc {
    DEVICE_PHONE("phone"),
    DEVICE_PAD("pad");
    
    private static final Map<String, fbc> f12356d = null;
    private String f12358c;

    static {
        f12356d = new HashMap();
        fbc[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            fbc com_ushareit_listenit_fbc = values[i];
            f12356d.put(com_ushareit_listenit_fbc.f12358c, com_ushareit_listenit_fbc);
            i++;
        }
    }

    private fbc(String str) {
        this.f12358c = str;
    }

    public String toString() {
        return this.f12358c;
    }
}
