package com.ushareit.listenit;

import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.mobileads.MoPubErrorCode;

class eiq implements MoPubSchemeListener {
    final /* synthetic */ eip f11099a;

    eiq(eip com_ushareit_listenit_eip) {
        this.f11099a = com_ushareit_listenit_eip;
    }

    public void onFinishLoad() {
        this.f11099a.f11095d.onLoaded(this.f11099a.f11096e);
    }

    public void onClose() {
        this.f11099a.f11095d.onCollapsed();
    }

    public void onFailLoad() {
        this.f11099a.f11095d.onFailed(MoPubErrorCode.UNSPECIFIED);
    }
}
