package com.ushareit.listenit;

import android.os.Handler;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource;
import com.mopub.nativeads.PositioningSource.PositioningListener;

public class emb implements PositioningSource {
    private final Handler f11242a = new Handler();
    private final MoPubClientPositioning f11243b;

    public emb(MoPubClientPositioning moPubClientPositioning) {
        this.f11243b = MoPubNativeAdPositioning.m3198a(moPubClientPositioning);
    }

    public void loadPositions(String str, PositioningListener positioningListener) {
        this.f11242a.post(new emc(this, positioningListener));
    }
}
