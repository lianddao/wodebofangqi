package com.ushareit.listenit;

import android.text.TextUtils;
import android.util.Pair;

public final class ezr {
    public static Pair<Long, Long> m18637a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String substring;
        String trim = str.replace("bytes ", "").trim();
        int indexOf = trim.indexOf(45);
        if (indexOf >= 0) {
            substring = trim.substring(0, indexOf);
        } else {
            substring = trim;
        }
        long parseLong = Long.parseLong(substring);
        indexOf = trim.indexOf(47);
        if (indexOf < 0) {
            return new Pair(Long.valueOf(parseLong), Long.valueOf(parseLong + j));
        }
        return new Pair(Long.valueOf(parseLong), Long.valueOf(Long.parseLong(trim.substring(indexOf + 1))));
    }
}
