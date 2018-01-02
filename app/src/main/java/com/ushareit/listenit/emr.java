package com.ushareit.listenit;

import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeImageHelper.ImageListener;

class emr implements ImageListener {
    final /* synthetic */ emq f11274a;

    emr(emq com_ushareit_listenit_emq) {
        this.f11274a = com_ushareit_listenit_emq;
    }

    public void onImagesCached() {
        this.f11274a.f11270b.onNativeAdLoaded(this.f11274a);
    }

    public void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
        this.f11274a.f11270b.onNativeAdFailed(nativeErrorCode);
    }
}
