package com.ushareit.listenit;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.SignInRequest;
import com.google.android.gms.signin.internal.SignInResponse;

public class dzh extends cha<dzd> implements dsb {
    private final boolean f10722d;
    private final cgs f10723e;
    private final Bundle f10724f;
    private Integer f10725g;

    public dzh(Context context, Looper looper, boolean z, cgs com_ushareit_listenit_cgs, Bundle bundle, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        super(context, looper, 44, com_ushareit_listenit_cgs, com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
        this.f10722d = z;
        this.f10723e = com_ushareit_listenit_cgs;
        this.f10724f = bundle;
        this.f10725g = com_ushareit_listenit_cgs.m11189j();
    }

    public dzh(Context context, Looper looper, boolean z, cgs com_ushareit_listenit_cgs, dsc com_ushareit_listenit_dsc, ceb com_ushareit_listenit_ceb, cec com_ushareit_listenit_cec) {
        this(context, looper, z, com_ushareit_listenit_cgs, m16538a(com_ushareit_listenit_cgs), com_ushareit_listenit_ceb, com_ushareit_listenit_cec);
    }

    public static Bundle m16538a(cgs com_ushareit_listenit_cgs) {
        dsc i = com_ushareit_listenit_cgs.m11188i();
        Integer j = com_ushareit_listenit_cgs.m11189j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", com_ushareit_listenit_cgs.m11181b());
        if (j != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", j.intValue());
        }
        if (i != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", i.m15414a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", i.m15415b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", i.m15416c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", i.m15417d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", i.m15418e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", i.m15419f());
            if (i.m15420g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", i.m15420g().longValue());
            }
            if (i.m15421h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", i.m15421h().longValue());
            }
        }
        return bundle;
    }

    private ResolveAccountRequest m16539y() {
        Account c = this.f10723e.m11182c();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(c.name)) {
            googleSignInAccount = ccv.m10848a(m10630p()).m10850a();
        }
        return new ResolveAccountRequest(c, this.f10725g.intValue(), googleSignInAccount);
    }

    protected dzd m16540a(IBinder iBinder) {
        return dze.m16524a(iBinder);
    }

    protected String mo1243a() {
        return "com.google.android.gms.signin.service.START";
    }

    public void mo2120a(chm com_ushareit_listenit_chm, boolean z) {
        try {
            ((dzd) m10635u()).mo2117a(com_ushareit_listenit_chm, this.f10725g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void mo2121a(dza com_ushareit_listenit_dza) {
        cfi.m11081a((Object) com_ushareit_listenit_dza, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((dzd) m10635u()).mo2116a(new SignInRequest(m16539y()), com_ushareit_listenit_dza);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                com_ushareit_listenit_dza.mo1994a(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected /* synthetic */ IInterface mo1244b(IBinder iBinder) {
        return m16540a(iBinder);
    }

    protected String mo1245b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle mo1246c() {
        if (!m10630p().getPackageName().equals(this.f10723e.m11186g())) {
            this.f10724f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f10723e.m11186g());
        }
        return this.f10724f;
    }

    public void mo1281f() {
        try {
            ((dzd) m10635u()).mo2110a(this.f10725g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public boolean mo1936j() {
        return this.f10722d;
    }

    public void mo2122m() {
        m10613a(new cgb(this));
    }
}
