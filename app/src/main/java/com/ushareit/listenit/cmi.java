package com.ushareit.listenit;

import com.google.firebase.auth.api.model.StringList;
import java.util.List;

public class cmi extends dbq<StringList> {
    private dao f8445a;

    public StringList m11684a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        StringList stringList = new StringList();
        dbq a = this.f8445a.m13652a(String.class);
        com_ushareit_listenit_dfu.mo1712a();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            stringList.m2523a().add((String) a.mo1401b(com_ushareit_listenit_dfu));
        }
        com_ushareit_listenit_dfu.mo1713b();
        return stringList;
    }

    public void m11685a(dao com_ushareit_listenit_dao) {
        this.f8445a = (dao) cfi.m11080a((Object) com_ushareit_listenit_dao);
    }

    public void m11686a(dfx com_ushareit_listenit_dfx, StringList stringList) {
        int i = 0;
        if (stringList == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        dbq a = this.f8445a.m13652a(String.class);
        com_ushareit_listenit_dfx.mo1734b();
        List a2 = stringList.m2523a();
        int size = a2 != null ? a2.size() : 0;
        while (i < size) {
            a.mo1400a(com_ushareit_listenit_dfx, (String) a2.get(i));
            i++;
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m11684a(com_ushareit_listenit_dfu);
    }
}
