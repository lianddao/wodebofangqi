package com.ushareit.listenit;

import java.util.HashMap;
import java.util.Map;

public class aec {
    private static final aft f4191a = new aft();
    private final Map<aft, aeb<?, ?>> f4192b = new HashMap();

    public <T, Z> void m5337a(Class<T> cls, Class<Z> cls2, aeb<T, Z> com_ushareit_listenit_aeb_T__Z) {
        this.f4192b.put(new aft(cls, cls2), com_ushareit_listenit_aeb_T__Z);
    }

    public <T, Z> aeb<T, Z> m5336a(Class<T> cls, Class<Z> cls2) {
        synchronized (f4191a) {
            f4191a.m5489a(cls, cls2);
            aeb<T, Z> com_ushareit_listenit_aeb_T__Z = (aeb) this.f4192b.get(f4191a);
        }
        if (com_ushareit_listenit_aeb_T__Z == null) {
            return aed.m5338e();
        }
        return com_ushareit_listenit_aeb_T__Z;
    }
}
