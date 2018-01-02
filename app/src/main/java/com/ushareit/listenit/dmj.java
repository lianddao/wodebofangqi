package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

class dmj implements dob {
    final /* synthetic */ dmg f9928a;

    private dmj(dmg com_ushareit_listenit_dmg) {
        this.f9928a = com_ushareit_listenit_dmg;
    }

    public void mo1968a(int i, boolean z) {
        this.f9928a.f9924m.lock();
        try {
            if (this.f9928a.f9923l) {
                this.f9928a.f9923l = false;
                this.f9928a.m14843a(i, z);
                return;
            }
            this.f9928a.f9923l = true;
            this.f9928a.f9915d.mo1956a(i);
            this.f9928a.f9924m.unlock();
        } finally {
            this.f9928a.f9924m.unlock();
        }
    }

    public void mo1969a(Bundle bundle) {
        this.f9928a.f9924m.lock();
        try {
            this.f9928a.f9922k = ConnectionResult.f1674a;
            this.f9928a.m14858j();
        } finally {
            this.f9928a.f9924m.unlock();
        }
    }

    public void mo1970a(ConnectionResult connectionResult) {
        this.f9928a.f9924m.lock();
        try {
            this.f9928a.f9922k = connectionResult;
            this.f9928a.m14858j();
        } finally {
            this.f9928a.f9924m.unlock();
        }
    }
}
