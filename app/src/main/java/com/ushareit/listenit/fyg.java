package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.ushareit.listenit.fragments.PlayerFragment;

public class fyg implements hgq {
    final /* synthetic */ PlayerFragment f13719a;

    public fyg(PlayerFragment playerFragment) {
        this.f13719a = playerFragment;
    }

    public void mo2623a(String str, int i, int i2) {
        if (!(i2 != MoPubClientPositioning.NO_REPEAT || this.f13719a.f13251b == null || this.f13719a.f13251b.mo2465v() == null)) {
            i2 = this.f13719a.f13251b.mo2465v().f14337e;
        }
        this.f13719a.f13250a.m26887a(i, i2);
        this.f13719a.f13253d.m26951a(i, i2);
    }
}
