package com.ushareit.listenit;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;

public final class ekm extends WebChromeClient {
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2753d(str2);
        jsResult.confirm();
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2753d(str2);
        jsResult.confirm();
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        MoPubLog.m2753d(str2);
        jsPromptResult.confirm();
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        MoPubLog.m2753d(str2);
        jsResult.confirm();
        return true;
    }
}
