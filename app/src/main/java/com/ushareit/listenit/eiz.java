package com.ushareit.listenit;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;

public final class eiz extends WebViewClient {
    final /* synthetic */ CustomEventInterstitialListener f11108a;

    public eiz(CustomEventInterstitialListener customEventInterstitialListener) {
        this.f11108a = customEventInterstitialListener;
    }

    public void onPageFinished(WebView webView, String str) {
        this.f11108a.onInterstitialLoaded();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f11108a.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }
}
