package com.ushareit.listenit;

import com.facebook.ads.C0007a;
import com.facebook.ads.C0010h;
import com.facebook.ads.C0016g;
import com.facebook.ads.af;

class fgc implements C0010h, fge {
    final /* synthetic */ fga f12651a;
    private ese f12652b;
    private long f12653c = 0;
    private long f12654d = 0;

    public fgc(fga com_ushareit_listenit_fga, ese com_ushareit_listenit_ese, long j) {
        this.f12651a = com_ushareit_listenit_fga;
        this.f12652b = com_ushareit_listenit_ese;
        this.f12653c = j;
    }

    public void onError(C0007a c0007a, C0016g c0016g) {
        this.f12651a.m17784a(this.f12652b, c0016g != null ? new esd(c0016g.m958a(), c0016g.m959b()) : new esd(1));
        fie.m19238a(this.f12652b.f11686c, c0016g != null ? c0016g.m958a() + "-" + c0016g.m959b() : "");
    }

    public void onAdLoaded(C0007a c0007a) {
        ffm.m19110a((af) c0007a, (ffl) this.f12652b, (fge) this, new fgd(this));
    }

    public void onAdClicked(C0007a c0007a) {
        fie.m19235a((ffl) this.f12652b, System.currentTimeMillis() - this.f12654d);
        this.f12651a.m17787a((Object) c0007a);
    }

    public void onLoggingImpression(C0007a c0007a) {
        fie.m19250c(this.f12652b.f11686c, 0);
    }

    public void onNativeAdShow() {
        this.f12654d = System.currentTimeMillis();
        fie.m19234a((ffl) this.f12652b);
    }

    public void onNativeAdClose() {
        fie.m19242b((ffl) this.f12652b, System.currentTimeMillis() - this.f12654d);
    }
}
