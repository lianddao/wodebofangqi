package com.ushareit.listenit;

import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeErrorCode;

class enh implements MoPubNativeNetworkListener {
    final /* synthetic */ enf f11308a;

    enh(enf com_ushareit_listenit_enf) {
        this.f11308a = com_ushareit_listenit_enf;
    }

    public void onNativeLoad(NativeAd nativeAd) {
        if (this.f11308a.f11305l != null) {
            this.f11308a.f11295b = false;
            enf com_ushareit_listenit_enf = this.f11308a;
            com_ushareit_listenit_enf.f11297d++;
            this.f11308a.m17200e();
            this.f11308a.f11299f.add(new eoa(nativeAd));
            if (this.f11308a.f11299f.size() == 1 && this.f11308a.f11303j != null) {
                this.f11308a.f11303j.onAdsAvailable();
            }
            this.f11308a.m17202g();
        }
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f11308a.f11295b = false;
        if (this.f11308a.f11298e >= enf.f11294a.length - 1) {
            this.f11308a.m17200e();
            return;
        }
        this.f11308a.m17199d();
        this.f11308a.f11296c = true;
        this.f11308a.f11300g.postDelayed(this.f11308a.f11301h, (long) this.f11308a.m17201f());
    }
}
