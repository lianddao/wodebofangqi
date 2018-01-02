package com.ushareit.listenit;

import android.text.TextUtils;
import java.util.Locale;

public enum atw {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    public static atw m7149a(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
