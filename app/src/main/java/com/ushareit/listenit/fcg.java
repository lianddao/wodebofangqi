package com.ushareit.listenit;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public enum fcg {
    MUSIC("music"),
    VIDEO("video"),
    PHOTO("photo"),
    APP("app"),
    GAME("game"),
    FILE("file"),
    DOCUMENT("doc"),
    ZIP("zip"),
    EBOOK("ebook"),
    CONTACT("contact");
    
    private static final Map<String, fcg> f12432l = null;
    private String f12434k;

    static {
        f12432l = new HashMap();
        fcg[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            fcg com_ushareit_listenit_fcg = values[i];
            f12432l.put(com_ushareit_listenit_fcg.f12434k, com_ushareit_listenit_fcg);
            i++;
        }
    }

    private fcg(String str) {
        this.f12434k = str;
    }

    @SuppressLint({"DefaultLocale"})
    public static fcg m18853a(String str) {
        return (fcg) f12432l.get(str.toLowerCase());
    }

    public String toString() {
        return this.f12434k;
    }
}
