package com.ushareit.listenit;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

class dmr implements cfy {
    private final WeakReference<dmp> f9957a;
    private final cdj<?> f9958b;
    private final int f9959c;

    public dmr(dmp com_ushareit_listenit_dmp, cdj<?> com_ushareit_listenit_cdj_, int i) {
        this.f9957a = new WeakReference(com_ushareit_listenit_dmp);
        this.f9958b = com_ushareit_listenit_cdj_;
        this.f9959c = i;
    }

    public void mo1310a(ConnectionResult connectionResult) {
        boolean z = false;
        dmp com_ushareit_listenit_dmp = (dmp) this.f9957a.get();
        if (com_ushareit_listenit_dmp != null) {
            if (Looper.myLooper() == com_ushareit_listenit_dmp.f9935a.f10017g.mo2004c()) {
                z = true;
            }
            cfi.m11086a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            com_ushareit_listenit_dmp.f9936b.lock();
            try {
                if (com_ushareit_listenit_dmp.m14931b(0)) {
                    if (!connectionResult.m2235b()) {
                        com_ushareit_listenit_dmp.m14930b(connectionResult, this.f9958b, this.f9959c);
                    }
                    if (com_ushareit_listenit_dmp.m14938d()) {
                        com_ushareit_listenit_dmp.m14939e();
                    }
                    com_ushareit_listenit_dmp.f9936b.unlock();
                }
            } finally {
                com_ushareit_listenit_dmp.f9936b.unlock();
            }
        }
    }
}
