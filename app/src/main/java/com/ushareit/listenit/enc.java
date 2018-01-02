package com.ushareit.listenit;

import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubStreamAdPlacer;
import com.mopub.nativeads.PositioningSource.PositioningListener;

public class enc implements PositioningListener {
    final /* synthetic */ MoPubStreamAdPlacer f11291a;

    public enc(MoPubStreamAdPlacer moPubStreamAdPlacer) {
        this.f11291a = moPubStreamAdPlacer;
    }

    public void onLoad(MoPubClientPositioning moPubClientPositioning) {
        this.f11291a.m3258a(moPubClientPositioning);
    }

    public void onFailed() {
        MoPubLog.m2753d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
    }
}
