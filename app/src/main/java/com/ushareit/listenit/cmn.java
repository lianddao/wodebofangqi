package com.ushareit.listenit;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;

public class cmn implements ebq {
    @dbt(a = "userId")
    private String f8447a;
    @dbt(a = "providerId")
    private String f8448b;
    @dbt(a = "displayName")
    private String f8449c;
    @dbt(a = "photoUrl")
    private String f8450d;
    @cmc
    private Uri f8451e;
    @dbt(a = "email")
    private String f8452f;
    @dbt(a = "isEmailVerified")
    private boolean f8453g;

    public cmn(GetAccountInfoUser getAccountInfoUser, String str) {
        cfi.m11080a((Object) getAccountInfoUser);
        cfi.m11082a(str);
        this.f8447a = cfi.m11082a(getAccountInfoUser.m2498c());
        this.f8448b = str;
        this.f8452f = getAccountInfoUser.m2496a();
        this.f8449c = getAccountInfoUser.m2499d();
        Uri f = getAccountInfoUser.m2501f();
        if (f != null) {
            this.f8450d = f.toString();
            this.f8451e = f;
        }
        this.f8453g = getAccountInfoUser.m2497b();
    }

    public cmn(ProviderUserInfo providerUserInfo) {
        cfi.m11080a((Object) providerUserInfo);
        this.f8447a = cfi.m11082a(providerUserInfo.m2513a());
        this.f8448b = cfi.m11082a(providerUserInfo.m2517e());
        this.f8449c = providerUserInfo.m2514b();
        Uri d = providerUserInfo.m2516d();
        if (d != null) {
            this.f8450d = d.toString();
            this.f8451e = d;
        }
        this.f8452f = null;
        this.f8453g = false;
    }

    public cmn(ebq com_ushareit_listenit_ebq) {
        cfi.m11080a((Object) com_ushareit_listenit_ebq);
        this.f8447a = cfi.m11082a(com_ushareit_listenit_ebq.mo1428a());
        this.f8448b = cfi.m11082a(com_ushareit_listenit_ebq.mo1429b());
        this.f8449c = com_ushareit_listenit_ebq.mo1430c();
        if (com_ushareit_listenit_ebq.mo1431d() != null) {
            this.f8451e = com_ushareit_listenit_ebq.mo1431d();
            this.f8450d = com_ushareit_listenit_ebq.mo1431d().toString();
        }
        this.f8452f = com_ushareit_listenit_ebq.mo1432e();
        this.f8453g = com_ushareit_listenit_ebq.mo1433f();
    }

    public String mo1428a() {
        return this.f8447a;
    }

    public String mo1429b() {
        return this.f8448b;
    }

    public String mo1430c() {
        return this.f8449c;
    }

    public Uri mo1431d() {
        if (!TextUtils.isEmpty(this.f8450d) && this.f8451e == null) {
            this.f8451e = Uri.parse(this.f8450d);
        }
        return this.f8451e;
    }

    public String mo1432e() {
        return this.f8452f;
    }

    public boolean mo1433f() {
        return this.f8453g;
    }
}
