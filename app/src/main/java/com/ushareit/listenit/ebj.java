package com.ushareit.listenit;

import android.net.Uri;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.GetTokenResponse;
import java.util.List;

public abstract class ebj implements ebq {
    private FirebaseAuth mo1438h() {
        return FirebaseAuth.getInstance(mo1437g());
    }

    public dzo<Void> m11707a(UserProfileChangeRequest userProfileChangeRequest) {
        cfi.m11080a((Object) userProfileChangeRequest);
        return mo1438h().m2470a(this, userProfileChangeRequest);
    }

    public abstract ebj mo1434a(List<? extends ebq> list);

    public abstract String mo1428a();

    public abstract void mo1435a(GetTokenResponse getTokenResponse);

    public abstract ebj mo1436b(boolean z);

    public dzo<ebk> m11712c(boolean z) {
        return mo1438h().m2471a(this, z);
    }

    public abstract String mo1430c();

    public abstract Uri mo1431d();

    public abstract String mo1432e();

    public abstract eah mo1437g();

    public abstract boolean mo1439i();

    public abstract List<? extends ebq> mo1440j();

    public abstract GetTokenResponse mo1441k();

    public abstract String mo1442l();

    public abstract String mo1443m();
}
