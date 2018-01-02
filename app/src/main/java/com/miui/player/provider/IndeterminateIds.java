package com.miui.player.provider;

import android.text.TextUtils;

public class IndeterminateIds {
    public static final long INVALID_ID = -1;
    public static final String SPLIT = String.valueOf(SPLIT_CHAR);
    public static final char SPLIT_CHAR = '$';
    private static final int SPLIT_LEN = SPLIT.length();

    public static String toIndeterminateId(String id, String source) {
        return source + SPLIT + id;
    }

    public static String getSource(String globalId) {
        return String.valueOf(globalId.charAt(0));
    }

    public static String getId(String globalId) {
        return globalId.substring(SPLIT_LEN + 1);
    }

    public static boolean equals(String a, String b) {
        return TextUtils.equals(a, b);
    }

    public static boolean isValid(String id) {
        return id != null && id.length() > 2 && SPLIT_CHAR == id.charAt(1);
    }
}
