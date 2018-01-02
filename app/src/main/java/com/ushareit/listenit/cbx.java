package com.ushareit.listenit;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class cbx {
    private Set<Scope> f8076a = new HashSet();
    private boolean f8077b;
    private boolean f8078c;
    private boolean f8079d;
    private String f8080e;
    private Account f8081f;
    private String f8082g;

    public cbx(GoogleSignInOptions googleSignInOptions) {
        cfi.m11080a((Object) googleSignInOptions);
        this.f8076a = new HashSet(googleSignInOptions.f1655f);
        this.f8077b = googleSignInOptions.f1658i;
        this.f8078c = googleSignInOptions.f1659j;
        this.f8079d = googleSignInOptions.f1657h;
        this.f8080e = googleSignInOptions.f1660k;
        this.f8081f = googleSignInOptions.f1656g;
        this.f8082g = googleSignInOptions.f1661l;
    }

    private String m10720b(String str) {
        cfi.m11082a(str);
        boolean z = this.f8080e == null || this.f8080e.equals(str);
        cfi.m11090b(z, "two different server client ids provided");
        return str;
    }

    public cbx m10721a() {
        this.f8076a.add(GoogleSignInOptions.f1651c);
        return this;
    }

    public cbx m10722a(Scope scope, Scope... scopeArr) {
        this.f8076a.add(scope);
        this.f8076a.addAll(Arrays.asList(scopeArr));
        return this;
    }

    public cbx m10723a(String str) {
        this.f8079d = true;
        this.f8080e = m10720b(str);
        return this;
    }

    public cbx m10724b() {
        this.f8076a.add(GoogleSignInOptions.f1650b);
        return this;
    }

    public cbx m10725c() {
        this.f8076a.add(GoogleSignInOptions.f1649a);
        return this;
    }

    public GoogleSignInOptions m10726d() {
        if (this.f8079d && (this.f8081f == null || !this.f8076a.isEmpty())) {
            m10721a();
        }
        return new GoogleSignInOptions(this.f8076a, this.f8081f, this.f8079d, this.f8077b, this.f8078c, this.f8080e, this.f8082g);
    }
}
