package com.ushareit.listenit;

import android.text.TextUtils;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;

public class ebm extends eat {
    private final String f10794a;
    private final String f10795b;

    ebm(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.f10794a = m16654a(str, "idToken");
        this.f10795b = m16654a(str2, "accessToken");
    }

    public static VerifyAssertionRequest m16653a(ebm com_ushareit_listenit_ebm) {
        cfi.m11080a((Object) com_ushareit_listenit_ebm);
        return new VerifyAssertionRequest(com_ushareit_listenit_ebm.m16656b(), com_ushareit_listenit_ebm.m16655a(), com_ushareit_listenit_ebm.m16657c(), null, null);
    }

    private static String m16654a(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    public String m16655a() {
        return this.f10795b;
    }

    public String m16656b() {
        return this.f10794a;
    }

    public String m16657c() {
        return "google.com";
    }
}
