package com.ushareit.listenit;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.api.model.GetTokenResponse;

public class ebc implements cmk {
    final /* synthetic */ FirebaseAuth f10789a;

    public ebc(FirebaseAuth firebaseAuth) {
        this.f10789a = firebaseAuth;
    }

    public void mo2133a(GetTokenResponse getTokenResponse, ebj com_ushareit_listenit_ebj) {
        cfi.m11080a((Object) getTokenResponse);
        cfi.m11080a((Object) com_ushareit_listenit_ebj);
        com_ushareit_listenit_ebj.mo1435a(getTokenResponse);
        this.f10789a.m2477a(com_ushareit_listenit_ebj, getTokenResponse, true);
        this.f10789a.m2478a(com_ushareit_listenit_ebj, true, true);
    }
}
