package com.ushareit.listenit;

class ffz extends btu implements fge {
    public ese f12641a;
    public Object f12642b = null;
    final /* synthetic */ fft f12643c;
    private long f12644d = 0;
    private long f12645e = 0;

    public ffz(fft com_ushareit_listenit_fft, ese com_ushareit_listenit_ese, Object obj, long j) {
        this.f12643c = com_ushareit_listenit_fft;
        this.f12641a = com_ushareit_listenit_ese;
        this.f12642b = obj;
        this.f12644d = j;
    }

    public void onAdFailedToLoad(int i) {
        int i2;
        fie.m19251c(this.f12641a.f11686c, "" + i);
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
        this.f12643c.m17784a(this.f12641a, new esd(i2));
    }

    public void onAdOpened() {
        if (this.f12642b != null) {
            fie.m19248c((ffl) this.f12641a, System.currentTimeMillis() - this.f12645e);
            this.f12643c.m17787a(this.f12642b);
        }
    }

    public void onAdLeftApplication() {
        if (this.f12642b != null) {
            this.f12643c.m17789b(this.f12642b);
        }
    }

    public void onAdLoaded() {
        super.onAdLoaded();
    }

    public void onAdClosed() {
        super.onAdClosed();
    }

    public void onNativeAdShow() {
        this.f12645e = System.currentTimeMillis();
        fie.m19241b((ffl) this.f12641a);
    }

    public void onNativeAdClose() {
        fie.m19254d((ffl) this.f12641a, System.currentTimeMillis() - this.f12645e);
    }
}
