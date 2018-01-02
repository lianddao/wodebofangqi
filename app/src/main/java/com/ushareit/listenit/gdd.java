package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import com.ushareit.listenit.lockscreen.view.ChargeLockScreenView;

public class gdd implements gcz {
    final /* synthetic */ ChargeLockScreenView f13944a;

    public gdd(ChargeLockScreenView chargeLockScreenView) {
        this.f13944a = chargeLockScreenView;
    }

    public void mo2647a(int i, String str) {
        if (gvj.m22869H()) {
            this.f13944a.f15688d.m24567a(i, str);
            this.f13944a.f15690f.m24555a(i, str);
        }
    }

    public void mo2648a(boolean z) {
        if (gvj.m22869H()) {
            exw.m18454c("dzt_", " updatePowerConnected , isConnected =" + z);
            this.f13944a.f15688d.m24570b(z);
            this.f13944a.f15690f.m24556a(z);
            if (z) {
                this.f13944a.f15687c.m24582a(this.f13944a.f15691g);
                if (this.f13944a.f15692h.m19047a(this.f13944a.f15685a)) {
                    this.f13944a.f15690f.m24557b();
                    return;
                }
                this.f13944a.f15690f.m24554a();
                this.f13944a.f15688d.m24572d();
                this.f13944a.f15688d.m24566a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                this.f13944a.f15689e.m24611a(this.f13944a.f15691g);
                return;
            }
            this.f13944a.f15687c.m24584b(this.f13944a.f15691g);
            this.f13944a.f15690f.m24557b();
            this.f13944a.f15688d.m24571c();
        }
    }
}
