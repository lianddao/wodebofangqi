package com.ushareit.listenit;

import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import java.util.List;

public class clq extends dbq<GetAccountInfoUserList> {
    private dao f8435a;

    public GetAccountInfoUserList m11608a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        GetAccountInfoUserList getAccountInfoUserList = new GetAccountInfoUserList();
        dbq a = this.f8435a.m13652a(GetAccountInfoUser.class);
        com_ushareit_listenit_dfu.mo1712a();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            getAccountInfoUserList.m2505a().add((GetAccountInfoUser) a.mo1401b(com_ushareit_listenit_dfu));
        }
        com_ushareit_listenit_dfu.mo1713b();
        return getAccountInfoUserList;
    }

    public void m11609a(dao com_ushareit_listenit_dao) {
        this.f8435a = (dao) cfi.m11080a((Object) com_ushareit_listenit_dao);
    }

    public void m11610a(dfx com_ushareit_listenit_dfx, GetAccountInfoUserList getAccountInfoUserList) {
        int i = 0;
        if (getAccountInfoUserList == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        dbq a = this.f8435a.m13652a(GetAccountInfoUser.class);
        com_ushareit_listenit_dfx.mo1734b();
        List a2 = getAccountInfoUserList.m2505a();
        int size = a2 != null ? a2.size() : 0;
        while (i < size) {
            a.mo1400a(com_ushareit_listenit_dfx, (GetAccountInfoUser) a2.get(i));
            i++;
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m11608a(com_ushareit_listenit_dfu);
    }
}
