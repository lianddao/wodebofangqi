package com.ushareit.listenit;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.internal.view.p000a.C0023d;

public class avf extends WebChromeClient {
    final /* synthetic */ C0023d f5563a;

    public avf(C0023d c0023d) {
        this.f5563a = c0023d;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        if (!TextUtils.isEmpty(message) && consoleMessage.messageLevel() == MessageLevel.LOG) {
            this.f5563a.f655d.m7195a(message);
        }
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f5563a.f655d.m7194a();
        if (this.f5563a.f654c != null) {
            this.f5563a.f654c.mo806a(i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f5563a.f654c != null) {
            this.f5563a.f654c.mo808b(str);
        }
    }
}
