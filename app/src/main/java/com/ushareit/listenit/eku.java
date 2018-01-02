package com.ushareit.listenit;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mraid.MraidBridge;

public class eku extends WebViewClient {
    final /* synthetic */ MraidBridge f11187a;

    public eku(MraidBridge mraidBridge) {
        this.f11187a = mraidBridge;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.m2753d("Error: " + str);
        super.onReceivedError(webView, i, str, str2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f11187a.m3072b(str);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f11187a.m3061f();
    }
}
