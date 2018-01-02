package com.ushareit.listenit;

import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;

class dmw extends dyy {
    private final WeakReference<dmp> f9969a;

    dmw(dmp com_ushareit_listenit_dmp) {
        this.f9969a = new WeakReference(com_ushareit_listenit_dmp);
    }

    public void mo1994a(SignInResponse signInResponse) {
        dmp com_ushareit_listenit_dmp = (dmp) this.f9969a.get();
        if (com_ushareit_listenit_dmp != null) {
            com_ushareit_listenit_dmp.f9935a.m15050a(new dmx(this, com_ushareit_listenit_dmp, com_ushareit_listenit_dmp, signInResponse));
        }
    }
}
