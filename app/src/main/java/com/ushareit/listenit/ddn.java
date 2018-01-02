package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.util.Collection;

public final class ddn implements dbr {
    private final dcb f9593a;

    public ddn(dcb com_ushareit_listenit_dcb) {
        this.f9593a = com_ushareit_listenit_dcb;
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Type b = com_ushareit_listenit_dft_T.m14121b();
        Class a = com_ushareit_listenit_dft_T.m14120a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = dbx.m13755a(b, a);
        return new ddo(com_ushareit_listenit_dao, a2, com_ushareit_listenit_dao.m13651a(dft.m14117a(a2)), this.f9593a.m13777a((dft) com_ushareit_listenit_dft_T));
    }
}
