package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

class dmi implements dob {
    final /* synthetic */ dmg f9927a;

    private dmi(dmg com_ushareit_listenit_dmg) {
        this.f9927a = com_ushareit_listenit_dmg;
    }

    public void mo1968a(int i, boolean z) {
        this.f9927a.f9924m.lock();
        try {
            if (this.f9927a.f9923l || this.f9927a.f9922k == null || !this.f9927a.f9922k.m2235b()) {
                this.f9927a.f9923l = false;
                this.f9927a.m14843a(i, z);
                return;
            }
            this.f9927a.f9923l = true;
            this.f9927a.f9916e.mo1956a(i);
            this.f9927a.f9924m.unlock();
        } finally {
            this.f9927a.f9924m.unlock();
        }
    }

    public void mo1969a(Bundle bundle) {
        this.f9927a.f9924m.lock();
        try {
            this.f9927a.m14844a(bundle);
            this.f9927a.f9921j = ConnectionResult.f1674a;
            this.f9927a.m14858j();
        } finally {
            this.f9927a.f9924m.unlock();
        }
    }

    public void mo1970a(ConnectionResult connectionResult) {
        this.f9927a.f9924m.lock();
        try {
            this.f9927a.f9921j = connectionResult;
            this.f9927a.m14858j();
        } finally {
            this.f9927a.f9924m.unlock();
        }
    }
}
