package com.ushareit.listenit;

import com.facebook.ads.af;
import com.mopub.nativeads.BaseNativeAd;
import com.mopub.nativeads.FacebookNative.FacebookNativeAd;
import com.mopub.nativeads.GooglePlayServicesNative.GooglePlayServicesNativeAd;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;

class fgi implements MoPubNativeNetworkListener {
    final /* synthetic */ fgf f12664a;
    private ffl f12665b;
    private long f12666c;

    public fgi(fgf com_ushareit_listenit_fgf, ese com_ushareit_listenit_ese, long j) {
        this.f12664a = com_ushareit_listenit_fgf;
        this.f12665b = (ffl) com_ushareit_listenit_ese;
        this.f12666c = j;
    }

    public void onNativeLoad(NativeAd nativeAd) {
        BaseNativeAd baseNativeAd = nativeAd.getBaseNativeAd();
        if (baseNativeAd instanceof FacebookNativeAd) {
            FacebookNativeAd facebookNativeAd = (FacebookNativeAd) baseNativeAd;
            facebookNativeAd.setAdItem(this.f12665b);
            this.f12665b.c = facebookNativeAd.getPlacementId();
            this.f12665b.a = "facebook";
            ffm.m19110a((af) facebookNativeAd.getNativeAd(), this.f12665b, facebookNativeAd.getNativeAdListener(), new fgj(this));
        } else if (baseNativeAd instanceof GooglePlayServicesNativeAd) {
            GooglePlayServicesNativeAd googlePlayServicesNativeAd = (GooglePlayServicesNativeAd) baseNativeAd;
            this.f12665b.c = googlePlayServicesNativeAd.getPlacementId();
            this.f12665b.a = "admob";
            googlePlayServicesNativeAd.setAdItem(this.f12665b);
            ffm.m19112a(googlePlayServicesNativeAd.getNativeAd(), this.f12665b, googlePlayServicesNativeAd.getNativeAdListener(), new fgk(this));
        } else {
            nativeAd.setMoPubNativeEventListener(new fgh(this.f12664a, this.f12665b));
            this.f12665b.c = nativeAd.getAdUnitId();
            this.f12665b.a = "mopub";
            ffm.m19111a(nativeAd, this.f12665b, new fgl(this));
        }
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        fie.m19262e(this.f12665b.c, nativeErrorCode != null ? nativeErrorCode.toString() : "");
    }
}
