package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;

public class cca implements bq<Void> {
    final /* synthetic */ SignInHubActivity f8086a;

    private cca(SignInHubActivity signInHubActivity) {
        this.f8086a = signInHubActivity;
    }

    public dz<Void> mo1255a(int i, Bundle bundle) {
        return new ccc(this.f8086a, cdz.m10921a());
    }

    public void mo1256a(dz<Void> dzVar) {
    }

    public /* synthetic */ void mo1257a(dz dzVar, Object obj) {
        m10733a(dzVar, (Void) obj);
    }

    public void m10733a(dz<Void> dzVar, Void voidR) {
        this.f8086a.setResult(this.f8086a.f1672q, this.f8086a.f1673r);
        this.f8086a.finish();
    }
}
