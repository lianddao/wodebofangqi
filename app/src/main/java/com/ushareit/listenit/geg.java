package com.ushareit.listenit;

import com.google.firebase.auth.FirebaseAuth;

class geg implements ebb {
    final /* synthetic */ gef f13992a;

    geg(gef com_ushareit_listenit_gef) {
        this.f13992a = com_ushareit_listenit_gef;
    }

    public void mo2665a(FirebaseAuth firebaseAuth) {
        ebj b = firebaseAuth.m2481b();
        if (b != null) {
            this.f13992a.f13985a = b;
            exw.m18454c("LOGIN.CONTROLLER", "onAuthStateChanged:signed_in:" + b.mo1428a());
            return;
        }
        exw.m18454c("LOGIN.CONTROLLER", "onAuthStateChanged:signed_out");
    }
}
