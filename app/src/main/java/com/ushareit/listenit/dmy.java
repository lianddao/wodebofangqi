package com.ushareit.listenit;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

class dmy implements ceb, cec {
    final /* synthetic */ dmp f9973a;

    private dmy(dmp com_ushareit_listenit_dmp) {
        this.f9973a = com_ushareit_listenit_dmp;
    }

    public void mo1956a(int i) {
    }

    public void mo1957a(Bundle bundle) {
        this.f9973a.f9945k.mo2121a(new dmw(this.f9973a));
    }

    public void mo1954a(ConnectionResult connectionResult) {
        this.f9973a.f9936b.lock();
        try {
            if (this.f9973a.m14932b(connectionResult)) {
                this.f9973a.m14946h();
                this.f9973a.m14939e();
            } else {
                this.f9973a.m14936c(connectionResult);
            }
            this.f9973a.f9936b.unlock();
        } catch (Throwable th) {
            this.f9973a.f9936b.unlock();
        }
    }
}
