package com.ushareit.listenit;

import com.mopub.volley.DefaultRetryPolicy;
import java.util.ArrayList;

class fnx implements hgp {
    final /* synthetic */ fnr f13073a;

    fnx(fnr com_ushareit_listenit_fnr) {
        this.f13073a = com_ushareit_listenit_fnr;
    }

    public void mo2473a(hgw com_ushareit_listenit_hgw) {
        this.f13073a.f13056o = false;
        for (guo a : new ArrayList(this.f13073a.f13044c)) {
            try {
                a.mo2503a(false);
            } catch (Exception e) {
                exw.m18451b("LIPlayer", "onPreparing has an exception.", e);
            }
        }
    }

    public void mo2476a(hgw com_ushareit_listenit_hgw, boolean z) {
        this.f13073a.f13056o = false;
        if (z) {
            if (this.f13073a.f13053l) {
                this.f13073a.m20052h(z);
            } else {
                this.f13073a.f13051j.m23782a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            }
        } else if (this.f13073a.f13054m) {
            this.f13073a.m20052h(z);
        } else {
            this.f13073a.f13051j.m23782a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        for (guo a : new ArrayList(this.f13073a.f13044c)) {
            try {
                a.mo2503a(true);
            } catch (Exception e) {
            }
        }
        if (this.f13073a.f13055n && !this.f13073a.f13050i.m20190e()) {
            this.f13073a.m20046d(1000);
        }
    }

    public void mo2477b(hgw com_ushareit_listenit_hgw) {
        this.f13073a.f13056o = true;
        for (guo f_ : this.f13073a.f13044c) {
            try {
                f_.f_();
            } catch (Exception e) {
            }
        }
    }

    public void mo2478c(hgw com_ushareit_listenit_hgw) {
    }

    public void mo2479d(hgw com_ushareit_listenit_hgw) {
    }

    public void mo2480e(hgw com_ushareit_listenit_hgw) {
    }

    public void mo2475a(hgw com_ushareit_listenit_hgw, long j) {
    }

    public void mo2481f(hgw com_ushareit_listenit_hgw) {
    }

    public void mo2472a() {
        this.f13073a.f13056o = true;
        for (guo b : this.f13073a.f13044c) {
            try {
                b.mo2504b();
            } catch (Exception e) {
            }
        }
    }

    public void mo2474a(hgw com_ushareit_listenit_hgw, int i) {
        this.f13073a.f13056o = true;
        glg com_ushareit_listenit_glg = (glg) this.f13073a.f13050i.mo2499l();
        boolean z = com_ushareit_listenit_glg != null && gyn.m23260p(com_ushareit_listenit_glg.f14342j);
        if (!this.f13073a.m20035G()) {
            if (!z || gyn.m23256m()) {
                heb.m23596a((int) C0349R.string.toast_play_failure, 0).show();
            }
            if (this.f13073a.f13051j != null && this.f13073a.f13051j.m23804i()) {
                this.f13073a.f13051j.m23801f();
            }
            for (guo c : this.f13073a.f13044c) {
                try {
                    c.mo2505c();
                } catch (Exception e) {
                }
            }
        }
    }
}
