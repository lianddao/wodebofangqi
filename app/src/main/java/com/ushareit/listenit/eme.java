package com.ushareit.listenit;

import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.GooglePlayServicesNative.GooglePlayServicesNativeAd;
import com.mopub.nativeads.NativeErrorCode;

public class eme extends btu implements fge {
    private ffl f11246a;
    private String f11247b;
    private CustomEventNativeListener f11248c;
    private GooglePlayServicesNativeAd f11249d;
    private long f11250e = 0;
    private long f11251f = 0;

    public eme(String str, CustomEventNativeListener customEventNativeListener, GooglePlayServicesNativeAd googlePlayServicesNativeAd, long j) {
        this.f11247b = str;
        this.f11248c = customEventNativeListener;
        this.f11249d = googlePlayServicesNativeAd;
        this.f11250e = j;
    }

    public void onAdOpened() {
        super.onAdOpened();
        fie.m19248c(this.f11246a, System.currentTimeMillis() - this.f11251f);
        this.f11249d.m3150b();
    }

    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        fie.m19251c(this.f11247b, "" + i);
        switch (i) {
            case 0:
                this.f11248c.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
                return;
            case 1:
                this.f11248c.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
                return;
            case 2:
                this.f11248c.onNativeAdFailed(NativeErrorCode.CONNECTION_ERROR);
                return;
            case 3:
                this.f11248c.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
                return;
            default:
                this.f11248c.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                return;
        }
    }

    public void onAdClosed() {
        super.onAdClosed();
    }

    public void onAdLoaded() {
        super.onAdLoaded();
    }

    public void onNativeAdShow() {
        this.f11249d.m3148a();
        this.f11251f = System.currentTimeMillis();
        fie.m19241b(this.f11246a);
    }

    public void onNativeAdClose() {
        fie.m19254d(this.f11246a, System.currentTimeMillis() - this.f11251f);
    }

    public void setAdItem(ffl com_ushareit_listenit_ffl) {
        this.f11246a = com_ushareit_listenit_ffl;
    }
}
