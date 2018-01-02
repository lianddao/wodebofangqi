package com.ushareit.listenit;

import com.mopub.mobileads.MoPubErrorCode;

public interface eim {
    void onCustomEventInterstitialClicked();

    void onCustomEventInterstitialDismissed();

    void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

    void onCustomEventInterstitialLoaded();

    void onCustomEventInterstitialShown();
}
