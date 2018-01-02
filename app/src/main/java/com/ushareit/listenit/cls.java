package com.ushareit.listenit;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

public interface cls extends IInterface {
    void mo1402a();

    void mo1403a(Status status);

    void mo1404a(CreateAuthUriResponse createAuthUriResponse);

    void mo1405a(GetTokenResponse getTokenResponse);

    void mo1406a(GetTokenResponse getTokenResponse, GetAccountInfoUser getAccountInfoUser);

    void mo1407b();

    void mo1408c();
}
