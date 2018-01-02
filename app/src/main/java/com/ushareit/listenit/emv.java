package com.ushareit.listenit;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.BaseNativeAd;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.MoPubAdRenderer;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.network.AdResponse;

public class emv implements CustomEventNativeListener {
    final /* synthetic */ AdResponse f11280a;
    final /* synthetic */ MoPubNative f11281b;

    public emv(MoPubNative moPubNative, AdResponse adResponse) {
        this.f11281b = moPubNative;
        this.f11280a = adResponse;
    }

    public void onNativeAdLoaded(BaseNativeAd baseNativeAd) {
        Context a = this.f11281b.m3190a();
        if (a != null) {
            MoPubAdRenderer rendererForAd = this.f11281b.f2644b.getRendererForAd(baseNativeAd);
            if (rendererForAd == null) {
                onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
            } else {
                this.f11281b.f2647e.onNativeLoad(new NativeAd(a, this.f11280a.getImpressionTrackingUrl(), this.f11280a.getClickTrackingUrl(), this.f11281b.f2646d, baseNativeAd, rendererForAd));
            }
        }
    }

    public void onNativeAdFailed(NativeErrorCode nativeErrorCode) {
        MoPubLog.m2759v(String.format("Native Ad failed to load with error: %s.", new Object[]{nativeErrorCode}));
        this.f11281b.m3192a(this.f11280a.getFailoverUrl());
    }
}
