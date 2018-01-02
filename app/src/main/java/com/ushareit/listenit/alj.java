package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.Locale;

public enum alj {
    UNKNOWN,
    AN,
    ADMOB,
    INMOBI,
    YAHOO;

    public static alj m6049a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return (alj) Enum.valueOf(alj.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
