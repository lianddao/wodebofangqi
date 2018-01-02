package com.ushareit.listenit;

import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import java.util.List;

public class cmh extends dbq<ProviderUserInfoList> {
    private dao f8444a;

    public ProviderUserInfoList m11679a(dfu com_ushareit_listenit_dfu) {
        if (com_ushareit_listenit_dfu.mo1718f() == dfw.NULL) {
            com_ushareit_listenit_dfu.mo1722j();
            return null;
        }
        ProviderUserInfoList providerUserInfoList = new ProviderUserInfoList();
        dbq a = this.f8444a.m13652a(ProviderUserInfo.class);
        com_ushareit_listenit_dfu.mo1712a();
        while (com_ushareit_listenit_dfu.mo1717e()) {
            providerUserInfoList.m2520a().add((ProviderUserInfo) a.mo1401b(com_ushareit_listenit_dfu));
        }
        com_ushareit_listenit_dfu.mo1713b();
        return providerUserInfoList;
    }

    public void m11680a(dao com_ushareit_listenit_dao) {
        this.f8444a = (dao) cfi.m11080a((Object) com_ushareit_listenit_dao);
    }

    public void m11681a(dfx com_ushareit_listenit_dfx, ProviderUserInfoList providerUserInfoList) {
        int i = 0;
        if (providerUserInfoList == null) {
            com_ushareit_listenit_dfx.mo1740f();
            return;
        }
        dbq a = this.f8444a.m13652a(ProviderUserInfo.class);
        com_ushareit_listenit_dfx.mo1734b();
        List a2 = providerUserInfoList.m2520a();
        int size = a2 != null ? a2.size() : 0;
        while (i < size) {
            a.mo1400a(com_ushareit_listenit_dfx, (ProviderUserInfo) a2.get(i));
            i++;
        }
        com_ushareit_listenit_dfx.mo1736c();
    }

    public /* synthetic */ Object mo1401b(dfu com_ushareit_listenit_dfu) {
        return m11679a(com_ushareit_listenit_dfu);
    }
}
