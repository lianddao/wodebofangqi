package com.ushareit.listenit;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class cby implements ceg {
    private Status f8083a;
    private GoogleSignInAccount f8084b;

    public cby(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f8084b = googleSignInAccount;
        this.f8083a = status;
    }

    public GoogleSignInAccount m10727a() {
        return this.f8084b;
    }

    public Status mo260b() {
        return this.f8083a;
    }

    public boolean m10729c() {
        return this.f8083a.m2257f();
    }
}
