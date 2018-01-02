package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;

public final class emt implements MoPubNativeNetworkListener {
    public void onNativeLoad(NativeAd nativeAd) {
        nativeAd.destroy();
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
    }
}
