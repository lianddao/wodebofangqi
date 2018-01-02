package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class cgd extends cft {
    final /* synthetic */ cfs f8236e;

    public cgd(cfs com_ushareit_listenit_cfs, int i, Bundle bundle) {
        this.f8236e = com_ushareit_listenit_cfs;
        super(com_ushareit_listenit_cfs, i, bundle);
    }

    protected void mo1311a(ConnectionResult connectionResult) {
        this.f8236e.f8061p.mo1310a(connectionResult);
        this.f8236e.m10612a(connectionResult);
    }

    protected boolean mo1312a() {
        this.f8236e.f8061p.mo1310a(ConnectionResult.f1674a);
        return true;
    }
}
