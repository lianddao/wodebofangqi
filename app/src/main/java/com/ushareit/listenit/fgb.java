package com.ushareit.listenit;

import com.facebook.ads.C0007a;
import com.facebook.ads.C0016g;
import com.facebook.ads.ac;
import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

class fgb implements ac {
    final /* synthetic */ fga f12646a;
    private ese f12647b;
    private long f12648c;
    private long f12649d = 0;
    private boolean f12650e = false;

    public fgb(fga com_ushareit_listenit_fga, ese com_ushareit_listenit_ese, long j) {
        this.f12646a = com_ushareit_listenit_fga;
        this.f12647b = com_ushareit_listenit_ese;
        this.f12648c = j;
    }

    public void onInterstitialDisplayed(C0007a c0007a) {
        this.f12649d = System.currentTimeMillis();
        fie.m19249c(this.f12647b.f11686c);
        fie.m19253d((ffl) this.f12647b);
    }

    public void onInterstitialDismissed(C0007a c0007a) {
        fie.m19265f(this.f12647b.f11686c, System.currentTimeMillis() - this.f12649d);
        if (!this.f12650e) {
            fie.m19263f((ffl) this.f12647b);
        }
    }

    public void onError(C0007a c0007a, C0016g c0016g) {
        this.f12646a.m17784a(this.f12647b, c0016g != null ? new esd(c0016g.m958a(), c0016g.m959b()) : new esd(1));
        fie.m19245b(this.f12647b.f11686c, c0016g != null ? c0016g.m958a() + "-" + c0016g.m959b() : "");
    }

    public void onAdLoaded(C0007a c0007a) {
        List arrayList = new ArrayList();
        arrayList.add(new esi(this.f12647b.f11684a, this.f12647b.f11686c, C0154a.f2954j, c0007a, ((ffl) this.f12647b).f12607l));
        this.f12646a.m17785a(this.f12647b, arrayList);
        fie.m19244b(this.f12647b.f11686c, System.currentTimeMillis() - this.f12648c);
    }

    public void onAdClicked(C0007a c0007a) {
        this.f12646a.m17787a((Object) c0007a);
        fie.m19261e(this.f12647b.f11686c, System.currentTimeMillis() - this.f12649d);
        fie.m19258e((ffl) this.f12647b);
        this.f12650e = true;
    }

    public void onLoggingImpression(C0007a c0007a) {
        fie.m19256d(this.f12647b.f11686c, System.currentTimeMillis() - this.f12649d);
    }
}
