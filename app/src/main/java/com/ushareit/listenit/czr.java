package com.ushareit.listenit;

import android.text.TextUtils;
import java.net.URLEncoder;

public class czr {
    public static String m13538a(String str) {
        return TextUtils.isEmpty(str) ? "" : m13539b(URLEncoder.encode(str, "UTF8"));
    }

    public static String m13539b(String str) {
        cfi.m11080a((Object) str);
        return str.replace("%2F", "/");
    }

    public static String m13540c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : str.split("/")) {
            if (!TextUtils.isEmpty(str2)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("/").append(str2);
                } else {
                    stringBuilder.append(str2);
                }
            }
        }
        return stringBuilder.toString();
    }
}
