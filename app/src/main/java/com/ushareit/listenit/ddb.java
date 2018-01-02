package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ddb {
    private static final Map<Class<?>, Class<?>> f9580a;
    private static final Map<Class<?>, Class<?>> f9581b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m13829a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m13829a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m13829a(hashMap, hashMap2, Character.TYPE, Character.class);
        m13829a(hashMap, hashMap2, Double.TYPE, Double.class);
        m13829a(hashMap, hashMap2, Float.TYPE, Float.class);
        m13829a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m13829a(hashMap, hashMap2, Long.TYPE, Long.class);
        m13829a(hashMap, hashMap2, Short.TYPE, Short.class);
        m13829a(hashMap, hashMap2, Void.TYPE, Void.class);
        f9580a = Collections.unmodifiableMap(hashMap);
        f9581b = Collections.unmodifiableMap(hashMap2);
    }

    public static <T> Class<T> m13828a(Class<T> cls) {
        Class<T> cls2 = (Class) f9580a.get(dbw.m13748a((Object) cls));
        return cls2 == null ? cls : cls2;
    }

    private static void m13829a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m13830a(Type type) {
        return f9580a.containsKey(type);
    }
}
