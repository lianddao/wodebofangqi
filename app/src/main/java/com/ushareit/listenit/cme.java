package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

abstract class cme<SuccessT, CallbackT> {
    protected final int f8402a;
    protected final cmg f8403b = new cmg();
    protected eah f8404c;
    protected ebj f8405d;
    protected clv f8406e;
    protected CallbackT f8407f;
    protected cmd<SuccessT> f8408g;
    protected GetTokenResponse f8409h;
    protected GetAccountInfoUser f8410i;
    protected CreateAuthUriResponse f8411j;
    boolean f8412k;
    SuccessT f8413l;
    Status f8414m;
    private boolean f8415n;

    public cme(int i) {
        this.f8402a = i;
    }

    private void m11549d() {
        mo1395b();
        cfi.m11086a(this.f8415n, (Object) "no success or failure set on method implementation");
    }

    public cme<SuccessT, CallbackT> m11550a(cmd<SuccessT> com_ushareit_listenit_cmd_SuccessT) {
        this.f8408g = com_ushareit_listenit_cmd_SuccessT;
        return this;
    }

    public cme<SuccessT, CallbackT> m11551a(eah com_ushareit_listenit_eah) {
        this.f8404c = (eah) cfi.m11081a((Object) com_ushareit_listenit_eah, (Object) "firebaseApp cannot be null");
        return this;
    }

    public cme<SuccessT, CallbackT> m11552a(ebj com_ushareit_listenit_ebj) {
        this.f8405d = (ebj) cfi.m11081a((Object) com_ushareit_listenit_ebj, (Object) "firebaseUser cannot be null");
        return this;
    }

    public cme<SuccessT, CallbackT> m11553a(CallbackT callbackT) {
        this.f8407f = cfi.m11081a((Object) callbackT, (Object) "external callback cannot be null");
        return this;
    }

    protected abstract void mo1394a();

    public void m11555a(Status status) {
        this.f8415n = true;
        this.f8412k = false;
        this.f8414m = status;
        this.f8408g.mo1397a(null, status);
    }

    public void m11556a(clv com_ushareit_listenit_clv) {
        this.f8406e = com_ushareit_listenit_clv;
        mo1394a();
    }

    public abstract void mo1395b();

    public void m11558b(SuccessT successT) {
        this.f8415n = true;
        this.f8412k = true;
        this.f8413l = successT;
        this.f8408g.mo1397a(successT, null);
    }

    public void m11559c() {
        m11558b(null);
    }
}
