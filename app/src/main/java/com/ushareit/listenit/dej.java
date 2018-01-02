package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class dej<T> extends dbq<T> {
    private final dao f9668a;
    private final dbq<T> f9669b;
    private final Type f9670c;

    dej(dao com_ushareit_listenit_dao, dbq<T> com_ushareit_listenit_dbq_T, Type type) {
        this.f9668a = com_ushareit_listenit_dao;
        this.f9669b = com_ushareit_listenit_dbq_T;
        this.f9670c = type;
    }

    private Type m13997a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, T t) {
        dbq com_ushareit_listenit_dbq = this.f9669b;
        Type a = m13997a(this.f9670c, (Object) t);
        if (a != this.f9670c) {
            com_ushareit_listenit_dbq = this.f9668a.m13651a(dft.m14117a(a));
            if ((com_ushareit_listenit_dbq instanceof ded) && !(this.f9669b instanceof ded)) {
                com_ushareit_listenit_dbq = this.f9669b;
            }
        }
        com_ushareit_listenit_dbq.mo1400a(com_ushareit_listenit_dfx, t);
    }

    public T mo1401b(dfu com_ushareit_listenit_dfu) {
        return this.f9669b.mo1401b(com_ushareit_listenit_dfu);
    }
}
