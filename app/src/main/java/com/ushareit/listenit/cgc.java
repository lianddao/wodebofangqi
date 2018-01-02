package com.ushareit.listenit;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class cgc extends cft {
    public final IBinder f8234e;
    final /* synthetic */ cfs f8235f;

    public cgc(cfs com_ushareit_listenit_cfs, int i, IBinder iBinder, Bundle bundle) {
        this.f8235f = com_ushareit_listenit_cfs;
        super(com_ushareit_listenit_cfs, i, bundle);
        this.f8234e = iBinder;
    }

    protected void mo1311a(ConnectionResult connectionResult) {
        if (this.f8235f.f8067v != null) {
            this.f8235f.f8067v.mo1319a(connectionResult);
        }
        this.f8235f.m10612a(connectionResult);
    }

    protected boolean mo1312a() {
        try {
            String interfaceDescriptor = this.f8234e.getInterfaceDescriptor();
            if (this.f8235f.mo1245b().equals(interfaceDescriptor)) {
                IInterface b = this.f8235f.mo1244b(this.f8234e);
                if (b == null || !this.f8235f.m10597a(2, 3, b)) {
                    return false;
                }
                Bundle t = this.f8235f.m10634t();
                if (this.f8235f.f8066u != null) {
                    this.f8235f.f8066u.mo1318a(t);
                }
                return true;
            }
            String valueOf = String.valueOf(this.f8235f.mo1245b());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
