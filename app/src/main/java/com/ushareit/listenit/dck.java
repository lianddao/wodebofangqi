package com.ushareit.listenit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class dck implements dda<T> {
    final /* synthetic */ Constructor f9531a;
    final /* synthetic */ dcb f9532b;

    dck(dcb com_ushareit_listenit_dcb, Constructor constructor) {
        this.f9532b = com_ushareit_listenit_dcb;
        this.f9531a = constructor;
    }

    public T mo1710a() {
        String valueOf;
        try {
            return this.f9531a.newInstance(null);
        } catch (Throwable e) {
            valueOf = String.valueOf(this.f9531a);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
        } catch (InvocationTargetException e2) {
            valueOf = String.valueOf(this.f9531a);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
