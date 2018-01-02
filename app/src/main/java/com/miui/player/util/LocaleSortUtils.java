package com.miui.player.util;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import miui.util.LocaleUtils;

public final class LocaleSortUtils {
    private static final String TAG = LocaleSortUtils.class.getName();
    private static LocaleUtils sLocalUtils = LocaleUtils.getIntance();
    private static Map<String, String> sPinyinMap = new ConcurrentHashMap(50);

    private LocaleSortUtils() {
    }

    public static String getSortKey(String displayName) {
        String key = null;
        if (displayName != null && displayName.length() > 0) {
            StringBuilder sb = new StringBuilder(displayName.length());
            for (int i = 0; i < displayName.length(); i++) {
                sb.append(getPinyinInitialChar(displayName.substring(i, i + 1)));
            }
            key = sb.toString();
        }
        return key != null ? key : " ";
    }

    private static String getPinyinInitialChar(String str) {
        String sortKey = (String) sPinyinMap.get(str);
        if (sortKey != null) {
            return sortKey;
        }
        String pinyin = null;
        try {
            pinyin = sLocalUtils.getSortKey(str);
        } catch (Exception e) {
            Log.e(TAG, "getSortKey failed, displayName=" + str);
        }
        if (pinyin == null) {
            pinyin = str;
        }
        if (pinyin != null && pinyin.length() > 0) {
            sortKey = pinyin.substring(0, 1).toUpperCase();
            sPinyinMap.put(str, sortKey);
        }
        return sortKey;
    }
}
