package com.ushareit.listenit;

import com.umeng.analytics.C0154a;
import java.util.ArrayList;
import java.util.List;

class ffy extends btu {
    public ese f12635a;
    public Object f12636b = null;
    final /* synthetic */ fft f12637c;
    private long f12638d = 0;
    private long f12639e = 0;
    private boolean f12640f = false;

    public ffy(fft com_ushareit_listenit_fft, ese com_ushareit_listenit_ese, Object obj, long j) {
        this.f12637c = com_ushareit_listenit_fft;
        this.f12635a = com_ushareit_listenit_ese;
        this.f12636b = obj;
        this.f12638d = j;
    }

    public void onAdFailedToLoad(int i) {
        int i2;
        fie.m19257d(this.f12635a.f11686c, "" + i);
        switch (i) {
            case 0:
                i2 = 2001;
                break;
            case 1:
                i2 = 1003;
                break;
            case 2:
                i2 = 1000;
                break;
            case 3:
                i2 = 1001;
                break;
            default:
                i2 = 1;
                break;
        }
        this.f12637c.m17784a(this.f12635a, new esd(i2));
    }

    public void onAdOpened() {
        if (this.f12636b != null) {
            this.f12639e = System.currentTimeMillis();
            fie.m19264f(this.f12635a.f11686c);
            fie.m19253d((ffl) this.f12635a);
        }
    }

    public void onAdLeftApplication() {
        if (this.f12636b != null) {
            this.f12637c.m17789b(this.f12636b);
            fie.m19271i(this.f12635a.f11686c, System.currentTimeMillis() - this.f12639e);
            fie.m19258e((ffl) this.f12635a);
            this.f12640f = true;
        }
    }

    public void onAdLoaded() {
        super.onAdLoaded();
        if (this.f12636b != null) {
            fie.m19270h(this.f12635a.f11686c, System.currentTimeMillis() - this.f12638d);
            List arrayList = new ArrayList();
            arrayList.add(new esi(this.f12635a.f11684a, this.f12635a.f11686c, C0154a.f2954j, this.f12636b, ((ffl) this.f12635a).f12607l));
            this.f12637c.m17785a(this.f12635a, arrayList);
        }
    }

    public void onAdClosed() {
        super.onAdClosed();
        fie.m19272j(this.f12635a.f11686c, System.currentTimeMillis() - this.f12639e);
        if (!this.f12640f) {
            fie.m19263f((ffl) this.f12635a);
        }
    }
}
