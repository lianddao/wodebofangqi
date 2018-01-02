package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public enum evv {
    NONE("none"),
    DOWNLOAD_STARTED("download_started"),
    DOWNLOAD_COMPLETED("download_completed"),
    NOTIFY_SHOWED("notify_showed"),
    USER_INSTALL_STARTED("user_install_started"),
    INSTALL_COMPLETED("install_completed");
    
    private static final Map<String, evv> f11994h = null;
    private String f11996g;

    static {
        f11994h = new HashMap();
        evv[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            evv com_ushareit_listenit_evv = values[i];
            f11994h.put(com_ushareit_listenit_evv.f11996g, com_ushareit_listenit_evv);
            i++;
        }
    }

    private evv(String str) {
        this.f11996g = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static evv m18240a(String str) {
        return (evv) f11994h.get(str.toLowerCase());
    }

    public String toString() {
        return this.f11996g;
    }
}
