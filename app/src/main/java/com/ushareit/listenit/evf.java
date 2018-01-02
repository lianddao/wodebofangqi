package com.ushareit.listenit;

import android.annotation.SuppressLint;
import com.umeng.analytics.pro.C0321x;
import java.util.HashMap;
import java.util.Map;

public enum evf {
    WAITING("waiting"),
    RUNNING("running"),
    COMPLETED("completed"),
    CANCELED("canceled"),
    ERROR(C0321x.aF),
    EXPIRED("expired");
    
    private static final Map<String, evf> f11939h = null;
    private String f11941g;

    static {
        f11939h = new HashMap();
        evf[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            evf com_ushareit_listenit_evf = values[i];
            f11939h.put(com_ushareit_listenit_evf.f11941g, com_ushareit_listenit_evf);
            i++;
        }
    }

    private evf(String str) {
        this.f11941g = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static evf m18164a(String str) {
        return (evf) f11939h.get(str.toLowerCase());
    }

    public String toString() {
        return this.f11941g;
    }
}
