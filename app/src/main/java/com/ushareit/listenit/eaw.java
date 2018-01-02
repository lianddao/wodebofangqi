package com.ushareit.listenit;

import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class eaw extends eat {
    private final String f10783a;

    eaw(String str) {
        this.f10783a = cfi.m11082a(str);
    }

    public static VerifyAssertionRequest m16642a(eaw com_ushareit_listenit_eaw) {
        cfi.m11080a((Object) com_ushareit_listenit_eaw);
        return new VerifyAssertionRequest(null, com_ushareit_listenit_eaw.m16643a(), com_ushareit_listenit_eaw.m16644b(), null, null);
    }

    public String m16643a() {
        return this.f10783a;
    }

    public String m16644b() {
        return "facebook.com";
    }
}
