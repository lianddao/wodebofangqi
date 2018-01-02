package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdLoadedListener;
import com.mopub.nativeads.MoPubRecyclerAdapter;

public class emy implements MoPubNativeAdLoadedListener {
    final /* synthetic */ MoPubRecyclerAdapter f11284a;

    public emy(MoPubRecyclerAdapter moPubRecyclerAdapter) {
        this.f11284a = moPubRecyclerAdapter;
    }

    public void onAdLoaded(int i) {
        this.f11284a.m3205a(i);
    }

    public void onAdRemoved(int i) {
        this.f11284a.m3206b(i);
    }
}
