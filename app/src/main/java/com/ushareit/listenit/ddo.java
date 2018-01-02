package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.util.Collection;

final class ddo<E> extends dbq<Collection<E>> {
    private final dbq<E> f9594a;
    private final dda<? extends Collection<E>> f9595b;

    public ddo(dao com_ushareit_listenit_dao, Type type, dbq<E> com_ushareit_listenit_dbq_E, dda<? extends Collection<E>> com_ushareit_listenit_dda__extends_java_util_Collection_E) {
        this.f9594a = new dej(com_ushareit_listenit_dao, com_ushareit_listenit_dbq_E, type);
        this.f9595b = com_ushareit_listenit_dda__extends_java_util_Collection_E;
    }

    public Collection<E> m13844a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        Collection<E> collection = (Collection) this.f9595b.mo1710a();
        com_ushareit_listenit_dfu.mo1712a();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            collection.add(this.f9594a.mo1401b(com_ushareit_listenit_dfu));
        }
        com_ushareit_listenit_dfu.mo1713b();
        return collection;
    }

    public void m13846a(dfx com_ushareit_listenit_dfx, Collection<E> collection) {
        if (collection == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        com_ushareit_listenit_dfx.mo1734b();
        for (E a : collection) {
            this.f9594a.mo1400a(com_ushareit_listenit_dfx, a);
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m13844a(com_ushareit_listenit_dfu);
    }
}
