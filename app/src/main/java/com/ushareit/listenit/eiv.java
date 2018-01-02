package com.ushareit.listenit;

import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.mobileads.MoPubConversionTracker;

public class eiv extends BaseUrlGenerator {
    final /* synthetic */ MoPubConversionTracker f11104a;

    private eiv(MoPubConversionTracker moPubConversionTracker) {
        this.f11104a = moPubConversionTracker;
    }

    public String generateUrlString(String str) {
        m2604a(str, Constants.CONVERSION_TRACKING_HANDLER);
        m2609k("6");
        m17088a(this.f11104a.f2372d);
        m2610l(ClientMetadata.getInstance(this.f11104a.f2369a).getAppVersion());
        m2606b();
        return m2602a();
    }

    private void m17088a(String str) {
        m2607b("id", str);
    }
}
