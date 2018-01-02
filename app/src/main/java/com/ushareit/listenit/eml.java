package com.ushareit.listenit;

import com.mopub.nativeads.MoPubAdAdapter;
import com.mopub.nativeads.MoPubNativeAdLoadedListener;

public class eml implements MoPubNativeAdLoadedListener {
    final /* synthetic */ MoPubAdAdapter f11261a;

    public eml(MoPubAdAdapter moPubAdAdapter) {
        this.f11261a = moPubAdAdapter;
    }

    public void onAdLoaded(int i) {
        this.f11261a.m3182a(i);
    }

    public void onAdRemoved(int i) {
        this.f11261a.m3183b(i);
    }
}
