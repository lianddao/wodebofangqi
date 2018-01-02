package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public enum evy {
    NONE("none"),
    EXECUTED("executed"),
    NOTIFY_SHOWED("notify_showed"),
    NOTIFY_CANCELED("notify_canceled"),
    MSGBOX_SHOWED("msgbox_showed"),
    MSGBOX_CANCELED("msgbox_canceled");
    
    private static final Map<String, evy> f12003h = null;
    private String f12005g;

    static {
        f12003h = new HashMap();
        evy[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            evy com_ushareit_listenit_evy = values[i];
            f12003h.put(com_ushareit_listenit_evy.f12005g, com_ushareit_listenit_evy);
            i++;
        }
    }

    private evy(String str) {
        this.f12005g = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static evy m18253a(String str) {
        return (evy) f12003h.get(str.toLowerCase());
    }

    public String toString() {
        return this.f12005g;
    }
}
