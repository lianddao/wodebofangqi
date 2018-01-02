package com.ushareit.listenit;

import com.google.android.gms.common.ConnectionResult;

public class cgb implements cfy {
    final /* synthetic */ cfs f8233a;

    public cgb(cfs com_ushareit_listenit_cfs) {
        this.f8233a = com_ushareit_listenit_cfs;
    }

    public void mo1310a(ConnectionResult connectionResult) {
        if (connectionResult.m2235b()) {
            this.f8233a.m10614a(null, this.f8233a.mo1241w());
        } else if (this.f8233a.f8067v != null) {
            this.f8233a.f8067v.mo1319a(connectionResult);
        }
    }
}
