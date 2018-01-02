package com.ushareit.listenit;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

class cmg extends clt {
    final /* synthetic */ cme f8443a;

    private cmg(cme com_ushareit_listenit_cme) {
        this.f8443a = com_ushareit_listenit_cme;
    }

    public void mo1402a() {
        cfi.m11086a(this.f8443a.f8402a == 4, "Unexpected response type " + this.f8443a.f8402a);
        this.f8443a.m11549d();
    }

    public void mo1403a(Status status) {
        this.f8443a.m11555a(status);
    }

    public void mo1404a(CreateAuthUriResponse createAuthUriResponse) {
        cfi.m11086a(this.f8443a.f8402a == 3, "Unexpected response type " + this.f8443a.f8402a);
        this.f8443a.f8411j = createAuthUriResponse;
        this.f8443a.m11549d();
    }

    public void mo1405a(GetTokenResponse getTokenResponse) {
        boolean z = true;
        if (this.f8443a.f8402a != 1) {
            z = false;
        }
        cfi.m11086a(z, "Unexpected response type: " + this.f8443a.f8402a);
        this.f8443a.f8409h = getTokenResponse;
        this.f8443a.m11549d();
    }

    public void mo1406a(GetTokenResponse getTokenResponse, GetAccountInfoUser getAccountInfoUser) {
        cfi.m11086a(this.f8443a.f8402a == 2, "Unexpected response type: " + this.f8443a.f8402a);
        this.f8443a.f8409h = getTokenResponse;
        this.f8443a.f8410i = getAccountInfoUser;
        this.f8443a.m11549d();
    }

    public void mo1407b() {
        cfi.m11086a(this.f8443a.f8402a == 5, "Unexpected response type " + this.f8443a.f8402a);
        this.f8443a.m11549d();
    }

    public void mo1408c() {
        cfi.m11086a(this.f8443a.f8402a == 6, "Unexpected response type " + this.f8443a.f8402a);
        this.f8443a.m11549d();
    }
}
