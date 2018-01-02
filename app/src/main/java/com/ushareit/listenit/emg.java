package com.ushareit.listenit;

import com.mopub.nativeads.GooglePlayServicesNative.GooglePlayServicesNativeAd;
import com.mopub.nativeads.NativeErrorCode;

public class emg implements buw {
    final /* synthetic */ long f11254a;
    final /* synthetic */ GooglePlayServicesNativeAd f11255b;

    public emg(GooglePlayServicesNativeAd googlePlayServicesNativeAd, long j) {
        this.f11255b = googlePlayServicesNativeAd;
        this.f11254a = j;
    }

    public void onContentAdLoaded(buv com_ushareit_listenit_buv) {
        if (this.f11255b.m3162a(com_ushareit_listenit_buv)) {
            this.f11255b.f2624b = com_ushareit_listenit_buv;
            if (com_ushareit_listenit_buv != null) {
                fie.m19268g(this.f11255b.f2626d, System.currentTimeMillis() - this.f11254a);
                this.f11255b.f2623a.onNativeAdLoaded(this.f11255b);
                return;
            }
            fie.m19251c(this.f11255b.f2626d, "nativeContentAd is null");
            this.f11255b.f2623a.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        this.f11255b.f2623a.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
        fie.m19251c(this.f11255b.f2626d, "isValidContentAd: " + this.f11255b.m3167b(com_ushareit_listenit_buv));
    }
}
