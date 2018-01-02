package com.ushareit.listenit;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.view.C0030c;
import java.util.HashMap;
import java.util.Map;

public class avk extends WebViewClient {
    final /* synthetic */ C0030c f5568a;

    public avk(C0030c c0030c) {
        this.f5568a = c0030c;
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Map hashMap = new HashMap();
        this.f5568a.f674d.m6935a(hashMap);
        hashMap.put("touch", atz.m7161a(this.f5568a.getTouchData()));
        this.f5568a.f672b.mo164a(str, hashMap);
        return true;
    }
}
