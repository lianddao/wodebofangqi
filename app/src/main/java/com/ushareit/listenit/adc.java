package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class adc {
    private static final aft f4152a = new aft();
    private final Map<aft, adb<?, ?>> f4153b = new HashMap();

    public <Z, R> void m5263a(Class<Z> cls, Class<R> cls2, adb<Z, R> com_ushareit_listenit_adb_Z__R) {
        this.f4153b.put(new aft(cls, cls2), com_ushareit_listenit_adb_Z__R);
    }

    public <Z, R> adb<Z, R> m5262a(Class<Z> cls, Class<R> cls2) {
        if (cls.equals(cls2)) {
            return add.m5264b();
        }
        synchronized (f4152a) {
            f4152a.m5489a(cls, cls2);
            adb<Z, R> com_ushareit_listenit_adb_Z__R = (adb) this.f4153b.get(f4152a);
        }
        if (com_ushareit_listenit_adb_Z__R != null) {
            return com_ushareit_listenit_adb_Z__R;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }
}
