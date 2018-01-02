package com.ushareit.listenit;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public final class eis extends WebViewClient {
    final /* synthetic */ CustomEventInterstitialListener f11101a;

    public eis(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f11101a = customEventInterstitialListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ("mopub://finishLoad".equals(str)) {
            this.f11101a.onInterstitialLoaded();
        } else if ("mopub://failLoad".equals(str)) {
            this.f11101a.onInterstitialFailed(null);
        }
        return true;
    }
}
