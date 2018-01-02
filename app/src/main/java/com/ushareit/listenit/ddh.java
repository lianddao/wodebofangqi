package com.ushareit.listenit;

import java.lang.reflect.Method;

final class ddh extends ddg {
    final /* synthetic */ Method f9585a;
    final /* synthetic */ Object f9586b;

    ddh(Method method, Object obj) {
        this.f9585a = method;
        this.f9586b = obj;
    }

    public <T> T mo1711a(Class<T> cls) {
        return this.f9585a.invoke(this.f9586b, new Object[]{cls});
    }
}
