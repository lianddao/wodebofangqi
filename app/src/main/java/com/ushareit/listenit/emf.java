package com.ushareit.listenit;

import com.mopub.nativeads.GooglePlayServicesNative.GooglePlayServicesNativeAd;
import com.mopub.nativeads.NativeErrorCode;

public class emf implements buu {
    final /* synthetic */ long f11252a;
    final /* synthetic */ GooglePlayServicesNativeAd f11253b;

    public emf(GooglePlayServicesNativeAd googlePlayServicesNativeAd, long j) {
        this.f11253b = googlePlayServicesNativeAd;
        this.f11252a = j;
    }

    public void onAppInstallAdLoaded(but com_ushareit_listenit_but) {
        if (this.f11253b.m3161a(com_ushareit_listenit_but)) {
            this.f11253b.f2625c = com_ushareit_listenit_but;
            if (com_ushareit_listenit_but != null) {
                fie.m19268g(this.f11253b.f2626d, System.currentTimeMillis() - this.f11252a);
                this.f11253b.f2623a.onNativeAdLoaded(this.f11253b);
                return;
            }
            fie.m19251c(this.f11253b.f2626d, "nativeAppInstallAd is null");
            this.f11253b.f2623a.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        this.f11253b.f2623a.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
        fie.m19251c(this.f11253b.f2626d, "isValidAppInstallAd: " + this.f11253b.m3166b(com_ushareit_listenit_but));
    }
}
