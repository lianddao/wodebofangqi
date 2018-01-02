package com.ushareit.listenit;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class cft extends cfx<Boolean> {
    public final int f8225a;
    public final Bundle f8226b;
    final /* synthetic */ cfs f8227c;

    protected cft(cfs com_ushareit_listenit_cfs, int i, Bundle bundle) {
        this.f8227c = com_ushareit_listenit_cfs;
        super(com_ushareit_listenit_cfs, Boolean.valueOf(true));
        this.f8225a = i;
        this.f8226b = bundle;
    }

    protected abstract void mo1311a(ConnectionResult connectionResult);

    protected void m11125a(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f8227c.m10600b(1, null);
            return;
        }
        switch (this.f8225a) {
            case 0:
                if (!mo1312a()) {
                    this.f8227c.m10600b(1, null);
                    mo1311a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                this.f8227c.m10600b(1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                this.f8227c.m10600b(1, null);
                if (this.f8226b != null) {
                    pendingIntent = (PendingIntent) this.f8226b.getParcelable("pendingIntent");
                }
                mo1311a(new ConnectionResult(this.f8225a, pendingIntent));
                return;
        }
    }

    protected /* synthetic */ void mo1304a(Object obj) {
        m11125a((Boolean) obj);
    }

    protected abstract boolean mo1312a();

    protected void mo1305b() {
    }
}
