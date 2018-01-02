package com.ushareit.listenit;

import com.google.firebase.auth.FirebaseAuth;

public class eay implements Runnable {
    final /* synthetic */ ebb f10784a;
    final /* synthetic */ FirebaseAuth f10785b;

    public eay(FirebaseAuth firebaseAuth, ebb com_ushareit_listenit_ebb) {
        this.f10785b = firebaseAuth;
        this.f10784a = com_ushareit_listenit_ebb;
    }

    public void run() {
        this.f10784a.mo2665a(this.f10785b);
    }
}
