package com.ushareit.listenit;

import com.mopub.common.IntentActions;
import com.mopub.mobileads.BaseBroadcastReceiver;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MoPubErrorCode;

public class eit implements CustomEventInterstitialListener {
    final /* synthetic */ MoPubActivity f11102a;

    public eit(MoPubActivity moPubActivity) {
        this.f11102a = moPubActivity;
    }

    public void onInterstitialLoaded() {
        this.f11102a.f2368b.loadUrl(eik.WEB_VIEW_DID_APPEAR.m17084b());
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        BaseBroadcastReceiver.m2823a(this.f11102a, this.f11102a.m2866a().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
        this.f11102a.finish();
    }

    public void onInterstitialShown() {
    }

    public void onInterstitialClicked() {
        BaseBroadcastReceiver.m2823a(this.f11102a, this.f11102a.m2866a().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    public void onLeaveApplication() {
    }

    public void onInterstitialDismissed() {
    }
}
