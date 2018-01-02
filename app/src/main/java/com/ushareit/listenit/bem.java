package com.ushareit.listenit;

final class bem extends btu implements buu, buw, buy {
    final beg f6021a;
    final bzo f6022b;

    public bem(beg com_ushareit_listenit_beg, bzo com_ushareit_listenit_bzo) {
        this.f6021a = com_ushareit_listenit_beg;
        this.f6022b = com_ushareit_listenit_bzo;
    }

    public void mo860a() {
        this.f6022b.mo1897d(this.f6021a);
    }

    public void onAdClosed() {
        this.f6022b.mo1891b(this.f6021a);
    }

    public void onAdFailedToLoad(int i) {
        this.f6022b.mo1887a(this.f6021a, i);
    }

    public void onAdLeftApplication() {
        this.f6022b.mo1894c(this.f6021a);
    }

    public void onAdLoaded() {
    }

    public void onAdOpened() {
        this.f6022b.mo1886a(this.f6021a);
    }

    public void onAppInstallAdLoaded(but com_ushareit_listenit_but) {
        this.f6022b.mo1888a(this.f6021a, new bei(com_ushareit_listenit_but));
    }

    public void onContentAdLoaded(buv com_ushareit_listenit_buv) {
        this.f6022b.mo1888a(this.f6021a, new bej(com_ushareit_listenit_buv));
    }
}
