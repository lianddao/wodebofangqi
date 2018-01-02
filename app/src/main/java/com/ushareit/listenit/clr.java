package com.ushareit.listenit;

import com.google.firebase.auth.api.model.GetAccountInfoUserList;
import com.google.firebase.auth.api.model.ProviderUserInfoList;
import com.google.firebase.auth.api.model.StringList;

public class clr {
    public static dao m11613a() {
        clq com_ushareit_listenit_clq = new clq();
        cmi com_ushareit_listenit_cmi = new cmi();
        cmh com_ushareit_listenit_cmh = new cmh();
        dao b = new dav().m13685a(8, 128, 64).m13683a().m13686a(new clc()).m13684a(GetAccountInfoUserList.class, com_ushareit_listenit_clq).m13684a(StringList.class, com_ushareit_listenit_cmi).m13684a(ProviderUserInfoList.class, com_ushareit_listenit_cmh).m13687b();
        com_ushareit_listenit_clq.m11609a(b);
        com_ushareit_listenit_cmi.m11685a(b);
        com_ushareit_listenit_cmh.m11680a(b);
        return b;
    }
}
