package com.ushareit.listenit;

import java.lang.reflect.Type;
import java.util.Map;

public final class ddw implements dbr {
    private final dcb f9636a;
    private final boolean f9637b;

    public ddw(dcb com_ushareit_listenit_dcb, boolean z) {
        this.f9636a = com_ushareit_listenit_dcb;
        this.f9637b = z;
    }

    private dbq<?> m13956a(dao com_ushareit_listenit_dao, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? dek.f9694f : com_ushareit_listenit_dao.m13651a(dft.m14117a(type));
    }

    public <T> dbq<T> mo1709a(dao com_ushareit_listenit_dao, dft<T> com_ushareit_listenit_dft_T) {
        Type b = com_ushareit_listenit_dft_T.m14121b();
        if (!Map.class.isAssignableFrom(com_ushareit_listenit_dft_T.m14120a())) {
            return null;
        }
        Type[] b2 = dbx.m13764b(b, dbx.m13767e(b));
        dbq a = m13956a(com_ushareit_listenit_dao, b2[0]);
        dbq a2 = com_ushareit_listenit_dao.m13651a(dft.m14117a(b2[1]));
        dda a3 = this.f9636a.m13777a((dft) com_ushareit_listenit_dft_T);
        return new ddx(this, com_ushareit_listenit_dao, b2[0], a, b2[1], a2, a3);
    }
}
