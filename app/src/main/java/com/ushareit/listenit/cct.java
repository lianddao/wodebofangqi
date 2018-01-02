package com.ushareit.listenit;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class cct extends ccm {
    private final Context f8132a;

    public cct(Context context) {
        this.f8132a = context;
    }

    private void m10842b() {
        if (!cjj.zzf(this.f8132a, Binder.getCallingUid())) {
            throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        }
    }

    private void m10843c() {
        ccv a = ccv.m10848a(this.f8132a);
        GoogleSignInAccount a2 = a.m10850a();
        cdl com_ushareit_listenit_cdl = GoogleSignInOptions.f1652d;
        if (a2 != null) {
            com_ushareit_listenit_cdl = a.m10854b();
        }
        cdz b = new cea(this.f8132a).m10956a(cap.f8029f, com_ushareit_listenit_cdl).m10960b();
        try {
            if (b.mo1977f().m2235b()) {
                if (a2 != null) {
                    cap.f8034k.mo1270c(b);
                } else {
                    b.mo1979h();
                }
            }
            b.mo1978g();
        } catch (Throwable th) {
            b.mo1978g();
        }
    }

    public void mo1285a() {
        m10842b();
        m10843c();
    }
}
