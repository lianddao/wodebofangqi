package com.ushareit.listenit;

final class bel extends btu implements buy {
    final beg f6019a;
    final bzm f6020b;

    public bel(beg com_ushareit_listenit_beg, bzm com_ushareit_listenit_bzm) {
        this.f6019a = com_ushareit_listenit_beg;
        this.f6020b = com_ushareit_listenit_bzm;
    }

    public void mo860a() {
        this.f6020b.mo1899e(this.f6019a);
    }

    public void onAdClosed() {
        this.f6020b.mo1893c(this.f6019a);
    }

    public void onAdFailedToLoad(int i) {
        this.f6020b.mo1885a(this.f6019a, i);
    }

    public void onAdLeftApplication() {
        this.f6020b.mo1896d(this.f6019a);
    }

    public void onAdLoaded() {
        this.f6020b.mo1884a(this.f6019a);
    }

    public void onAdOpened() {
        this.f6020b.mo1890b(this.f6019a);
    }
}
