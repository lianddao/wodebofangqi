package com.ushareit.listenit;

import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlWebViewListener;
import com.mopub.mobileads.MoPubErrorCode;

public class eio implements HtmlWebViewListener {
    private final CustomEventInterstitialListener f11091a;

    public eio(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f11091a = customEventInterstitialListener;
    }

    public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
        this.f11091a.onInterstitialLoaded();
    }

    public void onFailed(MoPubErrorCode moPubErrorCode) {
        this.f11091a.onInterstitialFailed(moPubErrorCode);
    }

    public void onClicked() {
        this.f11091a.onInterstitialClicked();
    }

    public void onCollapsed() {
    }
}
