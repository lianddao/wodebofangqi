package com.ushareit.listenit;

import java.lang.reflect.Method;

final class ddi extends ddg {
    final /* synthetic */ Method f9587a;
    final /* synthetic */ int f9588b;

    ddi(Method method, int i) {
        this.f9587a = method;
        this.f9588b = i;
    }

    public <T> T mo1711a(Class<T> cls) {
        return this.f9587a.invoke(null, new Object[]{cls, Integer.valueOf(this.f9588b)});
    }
}
