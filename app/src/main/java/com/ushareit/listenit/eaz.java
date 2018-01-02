package com.ushareit.listenit;

import com.google.firebase.auth.FirebaseAuth;

public class eaz implements Runnable {
    final /* synthetic */ cyz f10786a;
    final /* synthetic */ FirebaseAuth f10787b;

    public eaz(FirebaseAuth firebaseAuth, cyz com_ushareit_listenit_cyz) {
        this.f10787b = firebaseAuth;
        this.f10786a = com_ushareit_listenit_cyz;
    }

    public void run() {
        this.f10787b.f1945a.m16620a(this.f10786a);
        for (ebb a : this.f10787b.f1946b) {
            a.mo2665a(this.f10787b);
        }
    }
}
