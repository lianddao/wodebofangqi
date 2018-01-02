package com.ushareit.listenit;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Scope;

public class ccj extends cha<ccq> {
    private final GoogleSignInOptions f8127d;

    public ccj(Context context, Looper looper, cgs com_ushareit_listenit_cgs, GoogleSignInOptions googleSignInOptions, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 91, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        if (googleSignInOptions == null) {
            googleSignInOptions = new cbx().m10726d();
        }
        if (!com_ushareit_listenit_cgs.m11184e().isEmpty()) {
            cbx com_ushareit_listenit_cbx = new cbx(googleSignInOptions);
            for (Scope a : com_ushareit_listenit_cgs.m11184e()) {
                com_ushareit_listenit_cbx.m10722a(a, new Scope[0]);
            }
            googleSignInOptions = com_ushareit_listenit_cbx.m10726d();
        }
        this.f8127d = googleSignInOptions;
    }

    protected ccq m10821a(IBinder iBinder) {
        return ccr.m10838a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m10821a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public boolean mo1279d() {
        return true;
    }

    public Intent mo1280e() {
        Parcelable signInConfiguration = new SignInConfiguration(m10630p().getPackageName(), this.f8127d);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(m10630p(), SignInHubActivity.class);
        intent.putExtra("config", signInConfiguration);
        return intent;
    }

    public GoogleSignInOptions mo1281f() {
        return this.f8127d;
    }
}
