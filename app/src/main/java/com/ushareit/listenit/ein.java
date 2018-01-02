package com.ushareit.listenit;

import com.mopub.mobileads.GooglePlayServicesInterstitial;
import com.mopub.mobileads.MoPubErrorCode;

public class ein extends btu {
    final /* synthetic */ GooglePlayServicesInterstitial f11087a;
    private String f11088b;
    private long f11089c = 0;
    private long f11090d = 0;

    public ein(GooglePlayServicesInterstitial googlePlayServicesInterstitial, String str, long j) {
        this.f11087a = googlePlayServicesInterstitial;
        this.f11088b = str;
        this.f11089c = j;
    }

    public void onAdClosed() {
        fie.m19272j(this.f11088b, System.currentTimeMillis() - this.f11090d);
        if (this.f11087a.f2353a != null) {
            this.f11087a.f2353a.onInterstitialDismissed();
        }
    }

    public void onAdFailedToLoad(int i) {
        fie.m19257d(this.f11088b, "" + i);
        if (this.f11087a.f2353a != null) {
            this.f11087a.f2353a.onInterstitialFailed(m17085a(i));
        }
    }

    public void onAdLeftApplication() {
        fie.m19271i(this.f11088b, System.currentTimeMillis() - this.f11090d);
        if (this.f11087a.f2353a != null) {
            this.f11087a.f2353a.onInterstitialClicked();
        }
    }

    public void onAdLoaded() {
        fie.m19270h(this.f11088b, System.currentTimeMillis() - this.f11089c);
        if (this.f11087a.f2353a != null) {
            this.f11087a.f2353a.onInterstitialLoaded();
        }
    }

    public void onAdOpened() {
        this.f11090d = System.currentTimeMillis();
        fie.m19264f(this.f11088b);
        if (this.f11087a.f2353a != null) {
            this.f11087a.f2353a.onInterstitialShown();
        }
    }

    private MoPubErrorCode m17085a(int i) {
        switch (i) {
            case 0:
                return MoPubErrorCode.INTERNAL_ERROR;
            case 1:
                return MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            case 2:
                return MoPubErrorCode.NO_CONNECTION;
            case 3:
                return MoPubErrorCode.NO_FILL;
            default:
                return MoPubErrorCode.UNSPECIFIED;
        }
    }
}
