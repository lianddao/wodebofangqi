package com.ushareit.listenit;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class yo {
    private static final ze f17573c = new yp();
    private final Map<Class, Map<Class, zf>> f17574a = new HashMap();
    private final Map<Class, Map<Class, ze>> f17575b = new HashMap();
    private final Context f17576d;

    public yo(Context context) {
        this.f17576d = context.getApplicationContext();
    }

    public synchronized <T, Y> zf<T, Y> m27250a(Class<T> cls, Class<Y> cls2, zf<T, Y> zfVar) {
        zf<T, Y> zfVar2;
        this.f17575b.clear();
        Map map = (Map) this.f17574a.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f17574a.put(cls, map);
        }
        zfVar2 = (zf) map.put(cls2, zfVar);
        if (zfVar2 != null) {
            for (Map containsValue : this.f17574a.values()) {
                if (containsValue.containsValue(zfVar2)) {
                    zfVar2 = null;
                    break;
                }
            }
        }
        return zfVar2;
    }

    public synchronized <T, Y> ze<T, Y> m27249a(Class<T> cls, Class<Y> cls2) {
        ze<T, Y> c;
        c = m27247c(cls, cls2);
        if (c == null) {
            zf d = m27248d(cls, cls2);
            if (d != null) {
                ze a = d.mo547a(this.f17576d, this);
                m27245a((Class) cls, (Class) cls2, a);
            } else {
                m27246b(cls, cls2);
            }
        } else if (f17573c.equals(c)) {
            c = null;
        }
        return c;
    }

    private <T, Y> void m27246b(Class<T> cls, Class<Y> cls2) {
        m27245a((Class) cls, (Class) cls2, f17573c);
    }

    private <T, Y> void m27245a(Class<T> cls, Class<Y> cls2, ze<T, Y> zeVar) {
        Map map = (Map) this.f17575b.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f17575b.put(cls, map);
        }
        map.put(cls2, zeVar);
    }

    private <T, Y> ze<T, Y> m27247c(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.f17575b.get(cls);
        if (map != null) {
            return (ze) map.get(cls2);
        }
        return null;
    }

    private <T, Y> zf<T, Y> m27248d(Class<T> cls, Class<Y> cls2) {
        zf<T, Y> zfVar;
        Map map = (Map) this.f17574a.get(cls);
        if (map != null) {
            zfVar = (zf) map.get(cls2);
        } else {
            zfVar = null;
        }
        if (zfVar != null) {
            return zfVar;
        }
        zf<T, Y> zfVar2 = zfVar;
        for (Class cls3 : this.f17574a.keySet()) {
            if (cls3.isAssignableFrom(cls)) {
                map = (Map) this.f17574a.get(cls3);
                if (map != null) {
                    zfVar = (zf) map.get(cls2);
                    if (zfVar != null) {
                        return zfVar;
                    }
                    zfVar2 = zfVar;
                }
            }
            zfVar = zfVar2;
            zfVar2 = zfVar;
        }
        return zfVar2;
    }
}
