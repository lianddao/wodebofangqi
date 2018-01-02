package com.ushareit.listenit;

public final class djc implements bzk, bzm, bzo {
    private final dio f9838a;
    private bzp f9839b;

    public djc(dio com_ushareit_listenit_dio) {
        this.f9838a = com_ushareit_listenit_dio;
    }

    public bzp m14574a() {
        return this.f9839b;
    }

    public void mo1882a(bzj com_ushareit_listenit_bzj) {
        cfi.m11088b("onAdLoaded must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLoaded.");
        try {
            this.f9838a.mo1843e();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLoaded.", e);
        }
    }

    public void mo1883a(bzj com_ushareit_listenit_bzj, int i) {
        cfi.m11088b("onAdFailedToLoad must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f9838a.mo1838a(i);
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1884a(bzl com_ushareit_listenit_bzl) {
        cfi.m11088b("onAdLoaded must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLoaded.");
        try {
            this.f9838a.mo1843e();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLoaded.", e);
        }
    }

    public void mo1885a(bzl com_ushareit_listenit_bzl, int i) {
        cfi.m11088b("onAdFailedToLoad must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f9838a.mo1838a(i);
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1886a(bzn com_ushareit_listenit_bzn) {
        cfi.m11088b("onAdOpened must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdOpened.");
        try {
            this.f9838a.mo1842d();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdOpened.", e);
        }
    }

    public void mo1887a(bzn com_ushareit_listenit_bzn, int i) {
        cfi.m11088b("onAdFailedToLoad must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f9838a.mo1838a(i);
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1888a(bzn com_ushareit_listenit_bzn, bzp com_ushareit_listenit_bzp) {
        cfi.m11088b("onAdLoaded must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLoaded.");
        this.f9839b = com_ushareit_listenit_bzp;
        try {
            this.f9838a.mo1843e();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLoaded.", e);
        }
    }

    public void mo1889b(bzj com_ushareit_listenit_bzj) {
        cfi.m11088b("onAdOpened must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdOpened.");
        try {
            this.f9838a.mo1842d();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdOpened.", e);
        }
    }

    public void mo1890b(bzl com_ushareit_listenit_bzl) {
        cfi.m11088b("onAdOpened must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdOpened.");
        try {
            this.f9838a.mo1842d();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdOpened.", e);
        }
    }

    public void mo1891b(bzn com_ushareit_listenit_bzn) {
        cfi.m11088b("onAdClosed must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClosed.");
        try {
            this.f9838a.mo1840b();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClosed.", e);
        }
    }

    public void mo1892c(bzj com_ushareit_listenit_bzj) {
        cfi.m11088b("onAdClosed must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClosed.");
        try {
            this.f9838a.mo1840b();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClosed.", e);
        }
    }

    public void mo1893c(bzl com_ushareit_listenit_bzl) {
        cfi.m11088b("onAdClosed must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClosed.");
        try {
            this.f9838a.mo1840b();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClosed.", e);
        }
    }

    public void mo1894c(bzn com_ushareit_listenit_bzn) {
        cfi.m11088b("onAdLeftApplication must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLeftApplication.");
        try {
            this.f9838a.mo1841c();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1895d(bzj com_ushareit_listenit_bzj) {
        cfi.m11088b("onAdLeftApplication must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLeftApplication.");
        try {
            this.f9838a.mo1841c();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1896d(bzl com_ushareit_listenit_bzl) {
        cfi.m11088b("onAdLeftApplication must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdLeftApplication.");
        try {
            this.f9838a.mo1841c();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdLeftApplication.", e);
        }
    }

    public void mo1897d(bzn com_ushareit_listenit_bzn) {
        cfi.m11088b("onAdClicked must be called on the main UI thread.");
        bzp a = m14574a();
        if (a == null) {
            bze.m10490c("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (a.m7904b()) {
            bze.m10485a("Adapter called onAdClicked.");
            try {
                this.f9838a.mo1837a();
            } catch (Throwable e) {
                bze.m10491c("Could not call onAdClicked.", e);
            }
        } else {
            bze.m10485a("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        }
    }

    public void mo1898e(bzj com_ushareit_listenit_bzj) {
        cfi.m11088b("onAdClicked must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClicked.");
        try {
            this.f9838a.mo1837a();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClicked.", e);
        }
    }

    public void mo1899e(bzl com_ushareit_listenit_bzl) {
        cfi.m11088b("onAdClicked must be called on the main UI thread.");
        bze.m10485a("Adapter called onAdClicked.");
        try {
            this.f9838a.mo1837a();
        } catch (Throwable e) {
            bze.m10491c("Could not call onAdClicked.", e);
        }
    }
}
