package com.ushareit.listenit;

import java.util.concurrent.ConcurrentHashMap;

public class gxu<K, V> extends ConcurrentHashMap<K, V> {
    private Object m23107a(Object obj) {
        for (Object next : keySet()) {
            if (obj != null && next.equals(obj)) {
                return next;
            }
        }
        return obj;
    }

    public V get(Object obj) {
        return super.get(m23107a(obj));
    }

    public boolean containsKey(Object obj) {
        return super.containsKey(m23107a(obj));
    }

    public V put(K k, V v) {
        if (containsKey(k)) {
            return null;
        }
        return super.put(k, v);
    }

    public V putIfAbsent(K k, V v) {
        if (containsKey(k)) {
            return null;
        }
        return super.putIfAbsent(k, v);
    }

    public V remove(Object obj) {
        return super.remove(m23107a(obj));
    }

    public boolean remove(Object obj, Object obj2) {
        return super.remove(m23107a(obj), obj2);
    }

    public boolean replace(K k, V v, V v2) {
        return super.replace(m23107a(k), v, v2);
    }

    public V replace(K k, V v) {
        return super.replace(m23107a(k), v);
    }
}
