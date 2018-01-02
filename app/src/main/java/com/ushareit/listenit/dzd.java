package com.ushareit.listenit;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;
import com.google.android.gms.signin.internal.SignInRequest;

public interface dzd extends IInterface {
    void mo2110a(int i);

    void mo2111a(int i, Account account, dza com_ushareit_listenit_dza);

    void mo2112a(AuthAccountRequest authAccountRequest, dza com_ushareit_listenit_dza);

    void mo2113a(ResolveAccountRequest resolveAccountRequest, chy com_ushareit_listenit_chy);

    void mo2114a(CheckServerAuthResult checkServerAuthResult);

    void mo2115a(RecordConsentRequest recordConsentRequest, dza com_ushareit_listenit_dza);

    void mo2116a(SignInRequest signInRequest, dza com_ushareit_listenit_dza);

    void mo2117a(chm com_ushareit_listenit_chm, int i, boolean z);

    void mo2118a(dza com_ushareit_listenit_dza);

    void mo2119a(boolean z);
}
