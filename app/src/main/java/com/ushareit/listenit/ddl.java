package com.ushareit.listenit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ddl<E> extends dbq<Object> {
    public static final dbr f9590a = new ddm();
    private final Class<E> f9591b;
    private final dbq<E> f9592c;

    public ddl(dao com_ushareit_listenit_dao, dbq<E> com_ushareit_listenit_dbq_E, Class<E> cls) {
        this.f9592c = new dej(com_ushareit_listenit_dao, com_ushareit_listenit_dbq_E, cls);
        this.f9591b = cls;
    }

    public void mo1400a(dfx com_ushareit_listenit_dfx, Object obj) {
        if (obj == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        com_ushareit_listenit_dfx.mo1734b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f9592c.mo1400a(com_ushareit_listenit_dfx, Array.get(obj, i));
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public Object mo1401b(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        List arrayList = new ArrayList();
        com_ushareit_listenit_dfu.mo1712a();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            arrayList.add(this.f9592c.mo1401b(com_ushareit_listenit_dfu));
        }
        com_ushareit_listenit_dfu.mo1713b();
        Object newInstance = Array.newInstance(this.f9591b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
