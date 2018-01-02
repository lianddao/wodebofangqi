package com.ushareit.listenit;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.SignInResponse;

public interface dza extends IInterface {
    void mo1991a(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    void mo1992a(Status status);

    void mo1993a(Status status, GoogleSignInAccount googleSignInAccount);

    void mo1994a(SignInResponse signInResponse);

    void mo1995b(Status status);
}
