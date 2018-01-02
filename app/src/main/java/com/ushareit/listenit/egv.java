package com.ushareit.listenit;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.MoPubBrowser;

public class egv extends WebChromeClient {
    final /* synthetic */ MoPubBrowser f11054a;

    public egv(MoPubBrowser moPubBrowser) {
        this.f11054a = moPubBrowser;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.f11054a.setTitle("Loading...");
        this.f11054a.setProgress(i * 100);
        if (i == 100) {
            this.f11054a.setTitle(webView.getUrl());
        }
    }
}
