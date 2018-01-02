package com.ushareit.listenit;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.List;

final class cas extends cdp<ccj, GoogleSignInOptions> {
    cas() {
    }

    public ccj m10576a(Context context, Looper looper, cgs com_ushareit_listenit_cgs, GoogleSignInOptions googleSignInOptions, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        return new ccj(context, looper, com_ushareit_listenit_cgs, googleSignInOptions, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    public List<Scope> m10578a(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.m2216a();
    }

    public /* synthetic */ List mo1239a(Object obj) {
        return m10578a((GoogleSignInOptions) obj);
    }
}
