package com.ushareit.listenit;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class gyv {
    private static Map<String, String> f14937a = new ConcurrentHashMap();

    public static String m23317a(String str) {
        String uuid = UUID.randomUUID().toString();
        f14937a.put(uuid, str);
        return uuid;
    }

    public static void m23318b(String str) {
        f14937a.remove(str);
    }

    public static boolean m23319c(String str) {
        return f14937a.containsValue(str);
    }
}
