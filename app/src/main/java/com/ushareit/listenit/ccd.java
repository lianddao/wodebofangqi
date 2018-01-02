package com.ushareit.listenit;

import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class ccd implements cbv {
    public Intent mo1267a(cdz com_ushareit_listenit_cdz) {
        cfi.m11080a((Object) com_ushareit_listenit_cdz);
        return ((ccj) com_ushareit_listenit_cdz.mo1996a(cap.f8026c)).mo1280e();
    }

    public cby mo1268a(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.f1686a;
        }
        return new cby(googleSignInAccount, status);
    }

    public ced<Status> mo1269b(cdz com_ushareit_listenit_cdz) {
        ccv.m10848a(com_ushareit_listenit_cdz.mo2001b()).m10858c();
        for (cdz d : cdz.m10921a()) {
            d.mo2005d();
        }
        return com_ushareit_listenit_cdz.mo2002b(new cce(this, com_ushareit_listenit_cdz));
    }

    public ced<Status> mo1270c(cdz com_ushareit_listenit_cdz) {
        ccv.m10848a(com_ushareit_listenit_cdz.mo2001b()).m10858c();
        for (cdz d : cdz.m10921a()) {
            d.mo2005d();
        }
        return com_ushareit_listenit_cdz.mo2002b(new ccg(this, com_ushareit_listenit_cdz));
    }
}
