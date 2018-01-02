package com.ushareit.listenit;

import java.util.Map;
import java.util.Map.Entry;

public class gnn {
    String m22523a(String str, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (map != null && map.size() > 0) {
            if (!str.contains("?")) {
                stringBuilder.append("?");
            }
            for (Entry entry : map.entrySet()) {
                if (stringBuilder.toString().contains("=")) {
                    stringBuilder.append("&");
                }
                stringBuilder.append((String) entry.getKey()).append("=").append(ezm.m18633a((String) entry.getValue()));
            }
        }
        return stringBuilder.toString();
    }
}
