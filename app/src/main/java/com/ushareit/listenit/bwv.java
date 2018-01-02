package com.ushareit.listenit;

public class bwv extends btu {
    private final Object f7843a = new Object();
    private btu f7844b;

    public void m10043a(btu com_ushareit_listenit_btu) {
        synchronized (this.f7843a) {
            this.f7844b = com_ushareit_listenit_btu;
        }
    }

    public void onAdClosed() {
        synchronized (this.f7843a) {
            if (this.f7844b != null) {
                this.f7844b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f7843a) {
            if (this.f7844b != null) {
                this.f7844b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f7843a) {
            if (this.f7844b != null) {
                this.f7844b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f7843a) {
            if (this.f7844b != null) {
                this.f7844b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f7843a) {
            if (this.f7844b != null) {
                this.f7844b.onAdOpened();
            }
        }
    }
}
