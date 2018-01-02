package com.ushareit.listenit;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class ddm implements dbr {
    ddm() {
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Type b = com_ushareit_listenit_dft_T.m14121b();
        if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
            return null;
        }
        b = dbx.m13769g(b);
        return new ddl(com_ushareit_listenit_dao, com_ushareit_listenit_dao.m13651a(dft.m14117a(b)), dbx.m13767e(b));
    }
}
