package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public enum exl {
    APPSTORE("appstore"),
    URL("url"),
    URLS("urls"),
    URLS_CFG("urls_cfg");
    
    private static final Map<String, exl> f12129f = null;
    private String f12131e;

    static {
        f12129f = new HashMap();
        exl[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            exl com_ushareit_listenit_exl = values[i];
            f12129f.put(com_ushareit_listenit_exl.f12131e, com_ushareit_listenit_exl);
            i++;
        }
    }

    private exl(String str) {
        this.f12131e = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static exl m18387a(String str) {
        return (exl) f12129f.get(str.toLowerCase());
    }

    public String toString() {
        return this.f12131e;
    }
}
