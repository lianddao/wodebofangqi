package com.ushareit.listenit;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Set;

public final class dls extends dma<cen> {
    private int f9903a;
    private boolean f9904b;

    private void m14813a(ConnectionResult connectionResult) {
        fq fqVar = null;
        for (int i = 0; i < fqVar.size(); i++) {
            m14815a((dlp) fqVar.m20344b(i), connectionResult);
        }
    }

    protected cen m14814a(Status status) {
        cen com_ushareit_listenit_cen;
        synchronized (null) {
            try {
                m14813a(new ConnectionResult(8));
                fq fqVar = null;
                if (fqVar.size() != 1) {
                    com_ushareit_listenit_cen = new cen(status, null);
                }
            } finally {
            }
        }
        return com_ushareit_listenit_cen;
    }

    public void m14815a(dlp<?> com_ushareit_listenit_dlp_, ConnectionResult connectionResult) {
        synchronized (null) {
            fq fqVar = null;
            try {
                fqVar.put(com_ushareit_listenit_dlp_, connectionResult);
                this.f9903a--;
                boolean b = connectionResult.m2235b();
                if (!b) {
                    this.f9904b = b;
                }
                if (this.f9903a == 0) {
                    Status status = this.f9904b ? new Status(13) : Status.f1686a;
                    fqVar = null;
                    m10793b(fqVar.size() == 1 ? new cem(status, null) : new cen(status, null));
                }
            } finally {
            }
        }
    }

    protected /* synthetic */ ceg mo1278b(Status status) {
        return m14814a(status);
    }

    public Set<dlp<?>> mo1275b() {
        fq fqVar = null;
        return fqVar.keySet();
    }
}
