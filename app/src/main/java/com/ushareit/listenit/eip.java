package com.ushareit.listenit;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.HtmlWebViewListener;
import java.util.EnumSet;

public class eip extends WebViewClient {
    private final EnumSet<UrlAction> f11092a = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, new UrlAction[]{UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    private final Context f11093b;
    private final String f11094c;
    private HtmlWebViewListener f11095d;
    private BaseHtmlWebView f11096e;
    private final String f11097f;
    private final String f11098g;

    public eip(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView baseHtmlWebView, String str, String str2, String str3) {
        this.f11095d = htmlWebViewListener;
        this.f11096e = baseHtmlWebView;
        this.f11097f = str;
        this.f11098g = str2;
        this.f11094c = str3;
        this.f11093b = baseHtmlWebView.getContext();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        new Builder().withDspCreativeId(this.f11094c).withSupportedUrlActions(this.f11092a).withResultActions(new eir(this)).withMoPubSchemeListener(new eiq(this)).build().handleUrl(this.f11093b, str, this.f11096e.wasClicked());
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f11098g != null && str.startsWith(this.f11098g)) {
            webView.stopLoading();
            if (this.f11096e.wasClicked()) {
                try {
                    Intents.showMoPubBrowserForUrl(this.f11093b, Uri.parse(str), this.f11094c);
                    return;
                } catch (IntentNotResolvableException e) {
                    MoPubLog.m2753d(e.getMessage());
                    return;
                }
            }
            MoPubLog.m2753d("Attempted to redirect without user interaction");
        }
    }
}
