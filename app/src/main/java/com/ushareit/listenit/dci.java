package com.ushareit.listenit;

import java.lang.reflect.Type;

class dci implements dda<T> {
    final /* synthetic */ Class f9524a;
    final /* synthetic */ Type f9525b;
    final /* synthetic */ dcb f9526c;
    private final ddg f9527d = ddg.m13834a();

    dci(dcb com_ushareit_listenit_dcb, Class cls, Type type) {
        this.f9526c = com_ushareit_listenit_dcb;
        this.f9524a = cls;
        this.f9525b = type;
    }

    public T mo1710a() {
        try {
            return this.f9527d.mo1711a(this.f9524a);
        } catch (Throwable e) {
            String valueOf = String.valueOf(this.f9525b);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
        }
    }
}
