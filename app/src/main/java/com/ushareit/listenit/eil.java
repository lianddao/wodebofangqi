package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubErrorCode;

public class eil implements Runnable {
    final /* synthetic */ CustomEventInterstitialAdapter f11086a;

    public eil(CustomEventInterstitialAdapter customEventInterstitialAdapter) {
        this.f11086a = customEventInterstitialAdapter;
    }

    public void run() {
        MoPubLog.m2753d("Third-party network timed out.");
        this.f11086a.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f11086a.m2854c();
    }
}
