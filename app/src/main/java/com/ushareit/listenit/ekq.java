package com.ushareit.listenit;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import com.mopub.mraid.MraidBridge;

public class ekq extends WebChromeClient {
    final /* synthetic */ MraidBridge f11182a;

    public ekq(MraidBridge mraidBridge) {
        this.f11182a = mraidBridge;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.f11182a.f2568e != null) {
            return this.f11182a.f2568e.onJsAlert(str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.f11182a.f2568e != null) {
            return this.f11182a.f2568e.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
