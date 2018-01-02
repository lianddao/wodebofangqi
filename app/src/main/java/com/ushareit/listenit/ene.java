package com.ushareit.listenit;

import com.mopub.nativeads.BaseNativeAd.NativeEventListener;
import com.mopub.nativeads.NativeAd;

public class ene implements NativeEventListener {
    final /* synthetic */ NativeAd f11293a;

    public ene(NativeAd nativeAd) {
        this.f11293a = nativeAd;
    }

    public void onAdImpressed() {
        this.f11293a.m3259a(null);
    }

    public void onAdClicked() {
        this.f11293a.m3260b(null);
    }
}
