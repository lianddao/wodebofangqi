package com.ushareit.listenit;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ushareit.browser.BrowserActivity;

public class eun extends WebViewClient {
    final /* synthetic */ BrowserActivity f11898a;

    private eun(BrowserActivity browserActivity) {
        this.f11898a = browserActivity;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f11898a.f3929M.setVisibility(0);
    }

    public void onPageFinished(WebView webView, String str) {
        this.f11898a.f3929M.setVisibility(8);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("intent://download") || str.startsWith("intent://play")) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f11898a.f3923G.setVisibility(0);
        webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        super.onReceivedError(webView, i, str, str2);
    }
}
