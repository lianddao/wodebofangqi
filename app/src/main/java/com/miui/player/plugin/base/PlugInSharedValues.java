package com.miui.player.plugin.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlugInSharedValues {
    static final Map<String, Object> sValues = new ConcurrentHashMap();

    public static Object get(String key) {
        return sValues.get(key);
    }

    public static Object put(String key, Object value) {
        return sValues.put(key, value);
    }
}
